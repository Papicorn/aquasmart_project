const express = require('express');
const router = express.Router();
const db = require('../db');


const checkRole = (req, res, next) => {
    const { role } = req.body; // Asumsikan role dikirim dalam body permintaan
    if (role !== 'admin') {
        return res.status(403).json({ error: 'Access denied. Only admin can access this resource.' });
    }
    next();
};

// Rute untuk mendapatkan semua laporan (hanya untuk pengelola)
router.get('/', checkRole, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM laporan');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching reports:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

// Rute untuk menambahkan laporan
router.post('/', async (req, res) => {
    const { kategori_laporan, jenis_transaksi, total, catatan } = req.body;
    const id_pengguna = req.user.id;
    // ?
    try {
        const [result] = await db.query('INSERT INTO laporan (id_pengguna, kategori_laporan, jenis_transaksi, total, catatan) VALUES (?, ?, ?, ?, ?)',
            [id_pengguna, kategori_laporan, jenis_transaksi, total, catatan]);

        res.status(201).json({ id_laporan: result.insertId, message: 'Report created successfully' });
    } catch (error) {
        console.error('Error creating report:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

// Rute untuk memperbarui laporan
router.put('/:id_laporan', async (req, res) => {
    const { id_laporan } = req.params;
    const { kategori_laporan, jenis_transaksi, total, catatan } = req.body;

    try {
        const [result] = await db.query('UPDATE laporan SET kategori_laporan = ?, jenis_transaksi = ?, total = ?, catatan = ? WHERE id_laporan = ?',
            [kategori_laporan, jenis_transaksi, total, catatan, id_laporan]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Report not found' });
        }

        res.json({ message: 'Report updated successfully' });
    } catch (error) {
        console.error('Error updating report:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

// Rute untuk menghapus laporan
router.delete('/:id_laporan', async (req, res) => {
    const { id_laporan } = req.params;

    try {
        const [result] = await db.query('DELETE FROM laporan WHERE id_laporan = ?', [id_laporan]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Report not found' });
        }

        res.json({ message: 'Report deleted successfully' });
    } catch (error) {
        console.error('Error deleting report:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;