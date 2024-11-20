const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');


router.post('/', authMiddleware, async (req, res) => {
    const { id_kolam, dosis_pakan, catatan, waktu, frekuensi, status_aktif } = req.body;

    if (!id_kolam || !dosis_pakan || !catatan || !waktu || !frekuensi) {
        return res.status(400).json({ error: 'Semua field diperlukan' });
    }

    try {
        const [result] = await db.query('INSERT INTO jadwal_pakan (id_kolam, dosis_pakan, catatan, waktu, frekuensi, status_aktif) VALUES (?, ?, ?, ?, ?, ?)',
            [id_kolam, dosis_pakan, catatan, waktu, frekuensi, status_aktif]);

        res.status(201).json({ message: 'Jadwal pakan berhasil dibuat', id_jadwalpakan: result.insertId });
    } catch (error) {
        console.error('Error creating jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.post('/:id_kolam', authMiddleware, async (req, res) => {
    const { dosis_pakan, catatan, waktu, frekuensi, status_aktif } = req.body;
    const { id_kolam } = req.params;
    if (!dosis_pakan || !catatan || !waktu || !frekuensi) {
        return res.status(400).json({ error: 'Semua field diperlukan' });
    }

    try {
        const [result] = await db.query('INSERT INTO jadwal_pakan (id_kolam, dosis_pakan, catatan, waktu, frekuensi, status_aktif) VALUES (?, ?, ?, ?, ?, ?)',
            [id_kolam, dosis_pakan, catatan, waktu, frekuensi, status_aktif]);

        res.status(201).json({ message: 'Jadwal pakan berhasil dibuat', id_jadwalpakan: result.insertId });
    } catch (error) {
        console.error('Error creating jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM jadwal_pakan');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.put('/:id', authMiddleware, async (req, res) => {
    const { id } = req.params;
    const { id_kolam, dosis_pakan, catatan, waktu, frekuensi, status_aktif } = req.body;

    try {
        const [result] = await db.query('UPDATE jadwal_pakan SET id_kolam = ?, dosis_pakan = ?, catatan = ?, waktu = ?, frekuensi = ?, status_aktif = ? WHERE id_jadwalpakan = ?',
            [id_kolam, dosis_pakan, catatan, waktu, frekuensi, status_aktif, id]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal pakan tidak ditemukan' });
        }

        res.json({ message: 'Jadwal pakan berhasil diperbarui' });
    } catch (error) {
        console.error('Error updating jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.delete('/:id', authMiddleware, async (req, res) => {
    const { id } = req.params;

    try {
        const [result] = await db.query('DELETE FROM jadwal_pakan WHERE id_jadwalpakan = ?', [id]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal pakan tidak ditemukan' });
        }

        res.json({ message: 'Jadwal pakan berhasil dihapus' });
    } catch (error) {
        console.error('Error deleting jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;