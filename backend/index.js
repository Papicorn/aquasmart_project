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

const incomeExpenseRoute = require('./routes/incomeexpense');
// Gunakan rute untuk income dan expense
app.use('/api/incomeexpense', incomeExpenseRoute);



app.listen(3000, () => {
    console.log('Server listening on port 3000');
});