const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');


router.post('/', authMiddleware, async (req, res) => {
    const { id_kolam, nama_kolam, catatan, waktu } = req.body;

    if (!id_kolam || !nama_kolam || !catatan || !waktu) {
        return res.status(400).json({ error: 'All fields are required' });
    }

    try {
        const [result] = await db.query('INSERT INTO jadwal_panen (id_kolam, nama_kolam, catatan, waktu) VALUES (?, ?, ?, ?)',
            [id_kolam, nama_kolam, catatan, waktu]);

        res.status(201).json({ message: 'Jadwal panen created successfully', id_jadwalpanen: result.insertId });
    } catch (error) {
        console.error('Error creating jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.post('/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam } = req.params;
    const { nama_kolam, catatan, waktu } = req.body;


    if (!nama_kolam || !catatan || !waktu) {
        return res.status(400).json({ error: 'All fields except id_kolam are required' });
    }

    try {
        const [result] = await db.query('INSERT INTO jadwal_panen (id_kolam, nama_kolam, catatan, waktu) VALUES (?, ?, ?, ?)',
            [id_kolam, nama_kolam, catatan, waktu]);

        res.status(201).json({ message: 'Jadwal panen created successfully', id_jadwalpanen: result.insertId });
    } catch (error) {
        console.error('Error creating jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM jadwal_panen');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching jadwal panen:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_jadwalpanen', authMiddleware, async (req, res) => {
    const { id_jadwalpanen } = req.params;
    const { id_kolam, nama_kolam, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('UPDATE jadwal_panen SET id_kolam = ?, nama_kolam = ?, catatan = ?, waktu = ? WHERE id_jadwalpanen = ?',
            [id_kolam, nama_kolam, catatan, waktu, id_jadwalpanen]);

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
    const { nama_kolam, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('UPDATE jadwal_panen SET id_kolam = ?, nama_kolam = ?, catatan = ?, waktu = ? WHERE id_jadwalpanen = ?',
            [id_kolam, nama_kolam, catatan, waktu, id_jadwalpanen]);

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
        const [result] = await db.query('DELETE FROM jadwal_panen WHERE id_jadwalpanen = ?', [id_jadwalpanen]);

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