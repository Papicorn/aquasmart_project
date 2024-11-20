const cron = require('node-cron');
const db = require('../db');
const webPush = require('web-push');
const admin = require('firebase-admin');

// Konfigurasi VAPID keys untuk web push
const vapidKeys = {
    publicKey: 'BFIhk3OjZClavk4sNMk1fwAMYRVyc31wz839ZzfWsUIh43ZgZB4CPnK1CA6qJD9U67JGRLes7wTBnQPP5xfyFZc',
    privateKey: 'ktWE_lmjO4o_t8os2nAQ8GHQPdk3D2ZT2CfKG2vssfI'
};

webPush.setVapidDetails(
    'mailto:hilmidipo13@gmail.com',
    vapidKeys.publicKey,
    vapidKeys.privateKey
);

const serviceAccount = require('../aquasmart-994ef-firebase-adminsdk-57svh-aac133d176.json');
admin.initializeApp({
    credential: admin.credential.cert(serviceAccount)
});

cron.schedule('* * * * *', async () => {
    try {
        const [rowsPakan] = await db.query('SELECT * FROM jadwal_pakan WHERE status_aktif = "aktif"');

        const now = new Date();
        for (const jadwal of rowsPakan) {
            const waktuPakan = new Date(jadwal.waktu);
            const waktuPengingat = new Date(waktuPakan.getTime() - 30 * 60 * 1000); // 30 menit sebelum waktu pakan

            if (now >= waktuPengingat && now < waktuPakan) {
                const message = {
                    title: 'Pengingat Pakan',
                    body: `Saatnya memberi pakan untuk kolam ${jadwal.id_kolam} dengan dosis ${jadwal.dosis_pakan}.`
                };

                const [subscriptions] = await db.query('SELECT * FROM subscriptions WHERE id_pengguna = ?', [jadwal.id_pengguna]);
                const pushSubscription = subscriptions[0];
                const mobileToken = subscriptions[0].mobile_token;

                await webPush.sendNotification(pushSubscription, JSON.stringify(message));

                await admin.messaging().send({
                    notification: {
                        title: message.title,
                        body: message.body
                    },
                    token: mobileToken
                });

                console.log(`Notifikasi pengingat dikirim untuk kolam ${jadwal.id_kolam}`);

                await db.query('UPDATE jadwal_pakan SET status_aktif = "tidak aktif" WHERE id_jadwalpakan = ?', [jadwal.id_jadwalpakan]);
            }
        }

        // Menambahkan pengingat untuk jadwal panen
        const [rowsPanen] = await db.query('SELECT * FROM jadwal_panen WHERE status_aktif = "aktif"');

        for (const jadwal of rowsPanen) {
            const waktuPanen = new Date(jadwal.tanggal);

            // Pengingat seminggu sebelum panen
            const waktuPengingatSeminggu = new Date(waktuPanen.getTime() - 7 * 24 * 60 * 60 * 1000); // 7 hari sebelum waktu panen
            if (now >= waktuPengingatSeminggu && now < waktuPanen) {
                const messagePanenSeminggu = {
                    title: 'Pengingat Panen',
                    body: `Ingat! Panen untuk kolam ${jadwal.id_kolam} akan dilakukan dalam 7 hari.`
                };

                const [subscriptionsPanenSeminggu] = await db.query('SELECT * FROM subscriptions WHERE id_pengguna = ?', [jadwal.id_pengguna]);
                const pushSubscriptionPanenSeminggu = subscriptionsPanenSeminggu[0];
                const mobileTokenPanenSeminggu = subscriptionsPanenSeminggu[0].mobile_token;

                await webPush.sendNotification(pushSubscriptionPanenSeminggu, JSON.stringify(messagePanenSeminggu));

                await admin.messaging().send({
                    notification: {
                        title: messagePanenSeminggu.title,
                        body: messagePanenSeminggu.body
                    },
                    token: mobileTokenPanenSeminggu
                });

                console.log(`Notifikasi pengingat seminggu dikirim untuk kolam ${jadwal.id_kolam}`);
            }

            // Pengingat satu hari sebelum panen
            const waktuPengingatSatuHari = new Date(waktuPanen.getTime() - 24 * 60 * 60 * 1000); // 1 hari sebelum waktu panen
            if (now >= waktuPengingatSatuHari && now < waktuPanen) {
                const messagePanenSatuHari = {
                    title: 'Pengingat Panen',
                    body: `Ingat! Panen untuk kolam ${jadwal.id_kolam} akan dilakukan besok.`
                };

                const [subscriptionsPanenSatuHari] = await db.query('SELECT * FROM subscriptions WHERE id_pengguna = ?', [jadwal.id_pengguna]);
                const pushSubscriptionPanenSatuHari = subscriptionsPanenSatuHari[0];
                const mobileTokenPanenSatuHari = subscriptionsPanenSatuHari[0].mobile_token;

                await webPush.sendNotification(pushSubscriptionPanenSatuHari, JSON.stringify(messagePanenSatuHari));

                await admin.messaging().send({
                    notification: {
                        title: messagePanenSatuHari.title,
                        body: messagePanenSatuHari.body
                    },
                    token: mobileTokenPanenSatuHari
                });

                console.log(`Notifikasi pengingat satu hari dikirim untuk kolam ${jadwal.id_kolam}`);
            }

            await db.query('UPDATE jadwal_panen SET status_aktif = "tidak aktif" WHERE id_jadwalpanen = ?', [jadwal.id_jadwalpanen]);
        }
    } catch (error) {
        console.error('Error fetching jadwal pakan dan panen:', error);
    }
});