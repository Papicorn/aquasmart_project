const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');


router.post('/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam } = req.params;
    const { dosis_pakan, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('INSERT INTO jadwal_pakan (id_kolam, dosis_pakan, catatan, waktu) VALUES (?, ?, ?, ?)',
            [id_kolam, dosis_pakan, catatan, waktu]);

        res.status(201).json({ message: 'Jadwal pakan created successfully', id_jadwalpakan: result.insertId });
    } catch (error) {
        console.error('Error creating jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.post('/', authMiddleware, async (req, res) => {
    const { id_kolam, dosis_pakan, catatan, waktu } = req.body;

    if (!id_kolam || !dosis_pakan || !catatan || !waktu) {
        return res.status(400).json({ error: 'All fields are required' });
    }

    try {
        const [result] = await db.query('INSERT INTO jadwal_pakan (id_kolam, dosis_pakan, catatan, waktu) VALUES (?, ?, ?, ?)',
            [id_kolam, dosis_pakan, catatan, waktu]);

        res.status(201).json({ message: 'Jadwal pakan created successfully', id_jadwalpakan: result.insertId });
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


router.put('/:id_jadwalpakan', authMiddleware, async (req, res) => {
    const { id_jadwalpakan } = req.params;
    const { id_kolam, dosis_pakan, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('UPDATE jadwal_pakan SET id_kolam = ?, dosis_pakan = ?, catatan = ?, waktu = ? WHERE id_jadwalpakan = ?',
            [id_kolam, dosis_pakan, catatan, waktu, id_jadwalpakan]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal pakan not found' });
        }

        res.json({ message: 'Jadwal pakan updated successfully' });
    } catch (error) {
        console.error('Error updating jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.put('/:id_jadwalpakan/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam, id_jadwalpakan } = req.params;
    const { dosis_pakan, catatan, waktu } = req.body;

    try {
        const [result] = await db.query('UPDATE jadwal_pakan SET id_kolam = ?, dosis_pakan = ?, catatan = ?, waktu = ? WHERE id_jadwalpakan = ?',
            [id_kolam, dosis_pakan, catatan, waktu, id_jadwalpakan]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal pakan not found' });
        }

        res.json({ message: 'Jadwal pakan updated successfully' });
    } catch (error) {
        console.error('Error updating jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.delete('/:id_jadwalpakan', authMiddleware, async (req, res) => {
    const { id_jadwalpakan } = req.params;

    try {
        const [result] = await db.query('DELETE FROM jadwal_pakan WHERE id_jadwalpakan = ?', [id_jadwalpakan]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Jadwal pakan not found' });
        }

        res.json({ message: 'Jadwal pakan deleted successfully' });
    } catch (error) {
        console.error('Error deleting jadwal pakan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;