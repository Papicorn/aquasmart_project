const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');

router.post('/', authMiddleware, async (req, res) => {
    const { lokasi_bioflok, nama_awalan_kolam, nama_kolam, ph_air, kedalaman, diameter } = req.body;

    try {
        const [result] = await db.query('INSERT INTO kolam (lokasi_bioflok, nama_awalan_kolam, nama_kolam, ph_air, kedalaman, diameter) VALUES (?, ?, ?, ?, ?, ?)',
            [lokasi_bioflok, nama_awalan_kolam, nama_kolam, ph_air, kedalaman, diameter]);

        res.status(201).json({ message: 'Kolam created successfully', id_kolam: result.insertId });
    } catch (error) {
        console.error('Error creating kolam:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM kolam');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching kolam:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam } = req.params;
    const { lokasi_bioflok, nama_awalan_kolam, nama_kolam, ph_air, kedalaman, diameter } = req.body;

    try {
        const [result] = await db.query('UPDATE kolam SET lokasi_bioflok = ?, nama_awalan_kolam = ?, nama_kolam = ?, ph_air = ?, kedalaman = ?, diameter = ? WHERE id_kolam = ?',
            [lokasi_bioflok, nama_awalan_kolam, nama_kolam, ph_air, kedalaman, diameter, id_kolam]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Kolam not found' });
        }

        res.json({ message: 'Kolam updated successfully' });
    } catch (error) {
        console.error('Error updating kolam:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.delete('/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam } = req.params;

    try {
        const [result] = await db.query('DELETE FROM kolam WHERE id_kolam = ?', [id_kolam]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Kolam not found' });
        }

        res.json({ message: 'Kolam deleted successfully ' });
    } catch (error) {
        console.error('Error deleting kolam:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;