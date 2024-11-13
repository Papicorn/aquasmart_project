const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');


router.post('/', authMiddleware, async (req, res) => {
    const { id_kolam, jenis_ikan, jumlah, catatan, waktu } = req.body;


    if (!id_kolam || !jenis_ikan || !jumlah || !catatan) {
        return res.status(400).json({ error: 'Semua field harus diisi' });
    }

    try {
        const [result] = await db.query('INSERT INTO kematian_ikan (id_kolam, jenis_ikan, jumlah, catatan, waktu) VALUES (?, ?, ?, ?, ?)',
            [id_kolam, jenis_ikan, jumlah, catatan, waktu]);

        res.status(201).json({ message: 'Kematian ikan created successfully', id_kematian: result.insertId });
    } catch (error) {
        console.error('Error creating kematian ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.post('/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam } = req.params;
    const { jenis_ikan, jumlah, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('INSERT INTO kematian_ikan (id_kolam, jenis_ikan, jumlah, catatan, waktu) VALUES (?, ?, ?, ?, ?)',
            [id_kolam, jenis_ikan, jumlah, catatan, waktu]);

        res.status(201).json({ message: 'Kematian ikan created successfully', id_kematian: result.insertId });
    } catch (error) {
        console.error('Error creating kematian ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM kematian_ikan');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching kematian ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_kematian', authMiddleware, async (req, res) => {
    const { id_kematian } = req.params;
    const { id_kolam, jenis_ikan, jumlah, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('UPDATE kematian_ikan SET id_kolam = ?, jenis_ikan = ?, jumlah = ?, catatan = ?, waktu = ? WHERE id_kematian = ?',
            [id_kolam, jenis_ikan, jumlah, catatan, waktu, id_kematian]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Kematian ikan not found' });
        }

        res.json({ message: 'Kematian ikan updated successfully' });
    } catch (error) {
        console.error('Error updating kematian ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.put('/:id_kematian/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kematian, id_kolam } = req.params;
    const { jenis_ikan, jumlah, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('UPDATE kematian_ikan SET id_kolam = ?, jenis_ikan = ?, jumlah = ?, catatan = ?, waktu = ? WHERE id_kematian = ?',
            [id_kolam, jenis_ikan, jumlah, catatan, waktu, id_kematian]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Kematian ikan not found' });
        }

        res.json({ message: 'Kematian ikan updated successfully' });
    } catch (error) {
        console.error('Error updating kematian ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.delete('/:id_kematian', authMiddleware, async (req, res) => {
    const { id_kematian } = req.params;

    try {
        const [result] = await db.query('DELETE FROM kematian_ikan WHERE id_kematian = ?', [id_kematian]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Kematian ikan not found' });
        }

        res.json({ message: 'Kematian ikan deleted successfully' });
    } catch (error) {
        console.error('Error deleting kematian ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;