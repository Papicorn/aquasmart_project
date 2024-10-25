const express = require('express');
const router = express.Router();
const db = require('../db');
const { body, validationResult } = require('express-validator');
const jwt = require('jsonwebtoken');

const authenticateToken = (req, res, next) => {
    const token = req.headers['authorization']?.split(' ')[1];

    if (!token) return res.sendStatus(401);

    jwt.verify(token, process.env.JWT_SECRET, (err, user) => {
        if (err) return res.sendStatus(403);
        req.user = user; // Menyimpan informasi pengguna dari token
        next();
    });
};

// Rute untuk menambah pemasukan
router.post('/income',
    authenticateToken,
    [
        body('total').isNumeric().withMessage('total must be a number'),
        body('catatan').isString().notEmpty().withMessage('catatan is required')
    ],
    async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { total, catatan } = req.body;
        const id_pengguna = req.user.id; // Mengambil id pengguna dari token
        console.log('ID Pengguna:', id_pengguna); // Log ID pengguna

        try {
            const [result] = await db.query(
                `INSERT INTO income (id_pengguna, waktu, total, catatan) VALUES (?, CURRENT_TIMESTAMP, ?, ?)`,
                [id_pengguna, total, catatan]
            );

            if (result.affectedRows > 0) {
                res.status(201).json({ message: 'Income added successfully' });
            } else {
                res.status(400).json({ error: 'Failed to add income' });
            }
        } catch (error) {
            console.error('Database error:', error); // Log kesalahan database
            res.status(500).json({ error: 'Internal Server Error' });
        }
    }
);

// Rute untuk menambah pengeluaran
router.post('/expense',
    authenticateToken,
    [
        body('total').isNumeric().withMessage('total must be a number'),
        body('catatan').isString().notEmpty().withMessage('catatan is required')
    ],
    async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { total, catatan } = req.body;
        const id_pengguna = req.user.id; // Mengambil id pengguna dari token

        try {
            const [result] = await db.query(
                `INSERT INTO expense (id_pengguna, waktu, total, catatan) VALUES (?, CURRENT_TIMESTAMP, ?, ?)`,
                [id_pengguna, total, catatan]
            );

            if (result.affectedRows > 0) {
                res.status(201).json({ message: 'Expense added successfully' });
            } else {
                res.status(400).json({ error: 'Failed to add expense' });
            }
        } catch (error) {
            console.error('Database error:', error); // Log kesalahan database
            res.status(500).json({ error: 'Internal Server Error' });
        }
    }
);

module.exports = router;