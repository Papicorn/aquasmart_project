const express = require('express');
const app = express();
const db = require('./db');
const jwt = require('jsonwebtoken');
require('dotenv').config();
const cors = require('cors');

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));





// Rute untuk pengguna
const userRoute = require('./routes/users');
app.use('/api/users', userRoute);

// Rute untuk stok ikan
const stokikanRoute = require('./routes/stokikans');
app.use('/api/stokikans', stokikanRoute);

const incomeExpenseRoute = require('./routes/incomeexpense');

app.use('/api/incomeexpense', incomeExpenseRoute);

const laporanRoute = require('./routes/laporan');
app.use('/api/laporan', laporanRoute);

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});