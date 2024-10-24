const express = require('express');
const app = express();
const db = require('./db');
const jwt = require('jsonwebtoken');
require('dotenv').config();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Rute untuk pengguna
const userRoute = require('./routes/users');
app.use('/api/users', userRoute);

// Rute untuk stok ikan
const stokikanRoute = require('./routes/stokikans');
app.use('/api/stokikans', stokikanRoute);

// Middleware autentikasi

const authenticateToken = (req, res, next) => {
    const token = req.headers['authorization']?.split(' ')[1];

    if (!token) return res.sendStatus(401); // Jika tidak ada token, kirim 401 Unauthorized

    jwt.verify(token, process.env.JWT_SECRET, (err, user) => {
        if (err) return res.sendStatus(403); // Jika token tidak valid, kirim 403 Forbidden
        req.user = user; // Simpan informasi pengguna di request
        next(); // Lanjutkan ke rute berikutnya
    });
};



app.listen(3000, () => {
    console.log('Server listening on port 3000');
});