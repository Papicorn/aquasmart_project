const express = require('express');
const router = express.Router();
const db = require('../db');

router.post('/login', async (req, res) => {
    const { username, password } = req.body;
    try {
        const user = await db.query(`SELECT * FROM pengguna WHERE username = ? AND password = ?`, [username, password]);
        if (user.length > 0) {
            const token = generateToken(user[0].id_pengguna);
            res.json({ token });
        } else {
            res.status(401).json({ error: 'Invalid username or password' });
        }
    } catch (error) {
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.post('/signup', async (req, res) => {
    const { username, password } = req.body;
    try {
        const user = await db.query(`INSERT INTO pengguna (username, password) VALUES (?, ?)`, [username, password]);
        const token = generateToken(user.insertId);
        res.json({ token });
    } catch (error) {
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;