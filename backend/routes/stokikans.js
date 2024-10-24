const express = require('express');
const router = express.Router();
const db = require('../db');

// Rute untuk mendapatkan semua stok ikan (tanpa autentikasi)
router.get('/', async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM stokikan');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching stok ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

// Rute untuk menambah stok ikan (juga tanpa autentikasi)
router.post('/', async (req, res) => {
    const { name, quantity } = req.body;

    try {
        const [result] = await db.query(`INSERT INTO stokikan (name, quantity) VALUES (?, ?)`, [name, quantity]);

        if (result.affectedRows > 0) {
            res.status(201).json({ message: 'Stok ikan added successfully' });
        } else {
            res.status(400).json({ error: 'Failed to add stok ikan' });
        }
    } catch (error) {
        console.error('Error adding stok ikan:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;