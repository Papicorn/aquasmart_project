const express = require('express');
const router = express.Router();
const db = require('../db');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

// Token generation function
const generateToken = (userId, isAdmin = false) => {
    const payload = { id: userId, isAdmin };
    const secret = process.env.JWT_SECRET;
    const options = { expiresIn: '1h' };
    return jwt.sign(payload, secret, options);
};

// Middleware untuk autentikasi token
const authenticateToken = (req, res, next) => {
    const token = req.headers['authorization']?.split(' ')[1];

    if (!token) return res.sendStatus(401); // Jika tidak ada token, kirim 401 Unauthorized

    jwt.verify(token, process.env.JWT_SECRET, (err, user) => {
        if (err) return res.sendStatus(403); // Jika token tidak valid, kirim 403 Forbidden
        req.user = user; // Simpan informasi pengguna di request
        next(); // Lanjutkan ke rute berikutnya
    });
};

// Rute untuk login
router.post('/login', async (req, res) => {
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

        const isAdmin = user.username === 'admin'; // Ganti dengan logika Anda sendiri untuk menentukan admin
        const token = generateToken(user.id, isAdmin);
        res.json({ token });
    } catch (error) {
        console.error('Error logging in :', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

// Rute untuk signup
router.post('/signup', async (req, res) => {
    const { username, password } = req.body;

    try {
        // Hash the password before storing it
        const hashedPassword = await bcrypt.hash(password, 10);

        // Execute the insert query
        const [result] = await db.query(`INSERT INTO pengguna (username, password) VALUES (?, ?)`, [username, hashedPassword]);

        // Log the result of the insert operation
        console.log('Insert Result:', result);

        // Check if the insert was successful
        if (result.affectedRows > 0) {
            console.log('User inserted with ID:', result.insertId);
            const token = generateToken(result.insertId);
            res.json({ token });
        } else {
            res.status(400).json({ error: 'User could not be created' });
        }
    } catch (error) {
        console.error('Error during signup:', error);
        res.status(500).json({ error: 'Internal Server Error', details: error.message });
    }
});

router.get('/protected', authenticateToken, (req, res) => {
    res.json({ message: 'This is a protected route', user: req.user });
});

module.exports = router;