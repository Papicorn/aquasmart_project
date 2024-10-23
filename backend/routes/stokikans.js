const express = require('express');
const router = express.Router();
const db = require('../db');

router.get('/:userId', async (req, res) => {
    const userId = req.params.userId;
    try {
        const stokikans = await db.query(`SELECT * FROM stokikan WHERE id_pengguna = ?`, [userId]);
        res.json(stokikans);
    } catch (error) {
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.post('/', async (req, res) => {
    const stokikanData = req.body;
    try {
        const stokikan = await db.query(`INSERT INTO stokikan (id_pengguna, nama_ikan, nama_kolam, tanggal_tebar, tanggal_panen ) VALUES (?, ?, ?, ?, ?)`, [stokikanData.userId, stokikanData.nama_ikan, , stokikanData.nama_kolam, stokikanData.tanggal_tebar, stokikanData.tanggal_panen]);
        res.json(stokikan);
    } catch (error) {
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;