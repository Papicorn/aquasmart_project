const express = require('express');
const app = express();
const db = require('./db');

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Rute untuk pengguna
const userRoute = require('./routes/users');
app.use('/api/users', userRoute);

// Rute untuk stok ikan
const stokikanRoute = require('./routes/stokikans');
app.use('/api/stokikans', stokikanRoute);

// ... (rute lainnya)

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});