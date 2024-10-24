const express = require('express');
const router = express.Router();
const db = require('../db');
const { body, validationResult } = require('express-validator'); // Import express-validator

// Rute untuk menambah pemasukan
router.post('/income',
    authenticateToken,
    isAdmin,
    [
        body('amount').isNumeric().withMessage('Amount must be a number'),
        body('description').isString().notEmpty().withMessage('Description is required')
    ],
    async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { amount, description } = req.body;

        try {
            const [result] = await db.query(`INSERT INTO income (amount, description) VALUES (?, ?)`, [amount, description]);

            if (result.affectedRows > 0) {
                console.log(`Income added: ${amount}, Description: ${description}`); // Logging
                res.status(201).json({ message: 'Income added successfully' });
            } else {
                res.status(400).json({ error: 'Failed to add income' });
            }
        } catch (error) {
            console.error('Error adding income:', error);
            res.status(500).json({ error: 'Internal Server Error' });
        }
    }
);

// Rute untuk menambah pengeluaran
router.post('/expense',
    authenticateToken,
    isAdmin,
    [
        body('amount').isNumeric().withMessage('Amount must be a number'),
        body('description').isString().notEmpty().withMessage('Description is required')
    ],
    async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }

        const { amount, description } = req.body;

        try {
            const [result] = await db.query(`INSERT INTO expense (amount, description) VALUES (?, ?)`, [amount, description]);

            if (result.affectedRows > 0) {
                console.log(`Expense added: ${amount}, Description: ${description}`); // Logging
                res.status(201).json({ message: 'Expense added successfully' });
            } else {
                res.status(400).json({ error: 'Failed to add expense' });
            }
        } catch (error) {
            console.error('Error adding expense:', error);
            res.status(500).json({ error: 'Internal Server Error' });
        }
    }
);

module.exports = router;