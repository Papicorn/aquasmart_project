const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');


router.post('/', authMiddleware, async (req, res) => {
    const { id_kolam, tanggal, catatan } = req.body;

    if (!id_kolam || !tanggal || !catatan) {
        return res.status(400).json({ error: 'All fields are required' });
    }

    try {
        const [result] = await db.query('INSERT INTO jadwal_panen (id_kolam, tanggal, catatan, status_aktif) VALUES (?, ?, ?, "aktif")',
            [id_kolam, tanggal, catatan]);

        res.status(201).json({ message: 'Jadwal panen created successfully', id_jadwalpanen: result.insertId });
    } catch (error) {
        console.error('Error creating jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.post('/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam } = req.params;
    const { tanggal, catatan } = req.body;

    if (!tanggal || !catatan) {
        return res.status(400).json({ error: 'Tanggal and catatan are required' });
    }

    try {
        const [result] = await db.query('INSERT INTO jadwal_panen (id_kolam, tanggal, catatan, status_aktif) VALUES (?, ?, ?, "aktif")',
            [id_kolam, tanggal, catatan]);

        res.status(201).json({ message: 'Jadwal panen created successfully', id_jadwalpanen: result.insertId });
    } catch (error) {
        console.error('Error creating jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM jadwal_panen WHERE status_aktif = "aktif"');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_jadwalpanen', authMiddleware, async (req, res) => {
    const { id_jadwalpanen } = req.params;
    const { id_kolam, tanggal, catatan } = req.body;

    try {
        const [result] = await db.query('UPDATE jadwal_panen SET id_kolam = ?, tanggal = ?, catatan = ? WHERE id_jadwalpanen = ?',
            [id_kolam, tanggal, catatan, id_jadwalpanen]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal panen not found' });
        }

        res.json({ message: 'Jadwal panen updated successfully' });
    } catch (error) {
        console.error('Error updating jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.put('/:id_jadwalpanen/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam, id_jadwalpanen } = req.params;
    const { tanggal, catatan } = req.body;

    try {
        const [result] = await db.query('UPDATE jadwal_panen SET id_kolam = ?, tanggal = ?, catatan = ? WHERE id_jadwalpanen = ?',
            [id_kolam, tanggal, catatan, id_jadwalpanen]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal panen not found' });
        }

        res.json({ message: 'Jadwal panen updated successfully' });
    } catch (error) {
        console.error('Error updating jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.delete('/:id_jadwalpanen', authMiddleware, async (req, res) => {
    const { id_jadwalpanen } = req.params;

    try {
        const [result] = await db.query('UPDATE jadwal_panen SET status_aktif = "tidak aktif" WHERE id_jadwalpanen = ?', [id_jadwalpanen]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal panen not found' });
        }

        res.json({ message: 'Jadwal panen deleted successfully' });
    } catch (error) {
        console.error('Error deleting jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;