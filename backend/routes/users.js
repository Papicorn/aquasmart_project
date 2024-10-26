const express = require('express');
const router = express.Router();
const db = require('../db');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
require('dotenv').config();

const generateToken = (userId) => {
    const payload = { id: userId };
    const secret = process.env.JWT_SECRET;
    const options = { expiresIn: '1h' };
    return jwt.sign(payload, secret, options);
};



// Rute untuk login
router.post('/login/admin', async (req, res) => {
    const { username, password } = req.body;

    try {
        const [rows] = await db.query('SELECT * FROM pengguna WHERE username = ?', [username]);

        if (rows.length === 0) {
            return res.status(401).json({ error: 'Invalid username or password' });
        }

        const user = rows[0];
        const isMatch = await bcrypt.compare(password, user.password);
        if (!isMatch) {
            return res.status(401).json({ error: 'Invalid username or password' });
        }

        // Cek apakah role adalah 'admin'
        if (user.role !== 'admin') {
            return res.status(403).json({ error: 'Access denied. Only admin users can log in.' });
        }

        const token = generateToken(user.id);
        res.json({ token });
    } catch (error) {
        console.error('Error logging in:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

// Rute untuk signup
router.post('/signup', async (req, res) => {
    const { username, password, role } = req.body;

    try {

        if (role !== 'admin' && role !== 'pekerja') {
            return res.status(400).json({ error: 'Role must be either admin or pekerja' });
        }


        const hashedPassword = await bcrypt.hash(password, 10);


        const [result] = await db.query(`INSERT INTO pengguna (username, password, role) VALUES (?, ?, ?)`, [username, hashedPassword, role]);


        console.log('Insert Result:', result);


        if (result.affectedRows > 0) {
            console.log('User  inserted with ID:', result.insertId);
            const token = generateToken(result.insertId);
            res.json({ token });
        } else {
            res.status(400).json({ error: 'User  could not be created' });
        }
    } catch (error) {
        console.error('Error during signup:', error);
        res.status(500).json({ error: 'Internal Server Error', details: error.message });
    }
});
module.exports = router;