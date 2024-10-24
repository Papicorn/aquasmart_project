const mysql = require('mysql2/promise'); // Menggunakan mysql2 dengan dukungan promise


const db = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'aqua_smart',
});

module.exports = db;