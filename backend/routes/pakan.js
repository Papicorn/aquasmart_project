const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');


router.post('/', authMiddleware, async (req, res) => {
    const { jenis_pakan, nama_pakan, stok_pakan } = req.body;

    try {
        const [result] = await db.query('INSERT INTO pakan (jenis_pakan, nama_pakan, stok_pakan) VALUES (?, ?, ?)',
            [jenis_pakan, nama_pakan, stok_pakan]);

        res.status(201).json({ message: 'Pakan created successfully', id_pakan: result.insertId });
    } catch (error) {
        console.error('Error creating pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM pakan');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_pakan', authMiddleware, async (req, res) => {
    const { id_pakan } = req.params;
    const { jenis_pakan, nama_pakan, stok_pakan } = req.body;

    try {
        const [result] = await db.query('UPDATE pakan SET jenis_pakan = ?, nama_pakan = ?, stok_pakan = ? WHERE id_pakan = ?',
            [jenis_pakan, nama_pakan, stok_pakan, id_pakan]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Pakan not found' });
        }

        res.json({ message: 'Pakan updated successfully' });
    } catch (error) {
        console.error('Error updating pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.delete('/:id_pakan', authMiddleware, async (req, res) => {
    const { id_pakan } = req.params;

    try {
        const [result] = await db.query('DELETE FROM pakan WHERE id_pakan = ?', [id_pakan]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Pakan not found' });
        }

        res.json({ message: 'Pakan deleted successfully' });
    } catch (error) {
        console.error('Error deleting pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;