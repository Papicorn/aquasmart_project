const express = require('express');
const app = express();
const db = require('./db');
const jwt = require('jsonwebtoken');
require('dotenv').config();
const cors = require('cors');
const path = require('path');
//commit hilmi
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use('/uploads', express.static(path.join(__dirname, 'uploads')));





const userRoute = require('./routes/users');
app.use('/api/users', userRoute);


const stokikanRoute = require('./routes/stokikan');
app.use('/api/stokikan', stokikanRoute);

const incomeExpenseRoute = require('./routes/incomeexpense');
app.use('/api/incomeexpense', incomeExpenseRoute);

const laporanRoute = require('./routes/laporan');
app.use('/api/laporan', laporanRoute);

const kolamRoute = require('./routes/kolam');
app.use('/api/kolam', kolamRoute);

const jadwalpakanRoute = require('./routes/jadwalpakan');
app.use('/api/jadwalpakan', jadwalpakanRoute);

const jadwalpanenRoute = require('./routes/jadwalpanen');
app.use('/api/jadwalpanen', jadwalpanenRoute);

const dokumentasiRoute = require('./routes/dokumentasi');
app.use('/api/dokumentasi', dokumentasiRoute);

const kematianikanRoute = require('./routes/kematianikan');
app.use('/api/kematianikan', kematianikanRoute);

const pakanRoute = require('./routes/pakan');
app.use('/api/pakan', pakanRoute);

app.listen(3000, () => {
    console.log('Server listening on port 3000');
}); 