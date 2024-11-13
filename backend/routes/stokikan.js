const express = require('express');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');


router.post('/:id_kolam', authMiddleware, async (req, res) => {
    const { id_kolam } = req.params;
    const { tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran } = req.body;

    try {
        const [result] = await db.query('INSERT INTO stok_ikan (id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran) VALUES (?, ?, ?, ?, ?, ?, ?)',
            [id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran]);

        res.status(201).json({ message: 'Stock created successfully', id_stok: result.insertId });
    } catch (error) {
        console.error('Error creating stock:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.post('/', authMiddleware, async (req, res) => {
    const { id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran } = req.body;

    try {
        const [result] = await db.query('INSERT INTO stok_ikan (id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran) VALUES (?, ?, ?, ?, ?, ?, ?)',
            [id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran]);

        res.status(201).json({ message: 'Stock created successfully', id_stok: result.insertId });
    } catch (error) {
        console.error('Error creating stock:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM stok_ikan');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching stocks:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_stok', authMiddleware, async (req, res) => {
    const { id_stok } = req.params;
    const { id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran } = req.body;

    try {
        const [result] = await db.query('UPDATE stok_ikan SET id_kolam = ?, tgl_tebar = ?, tgl_panen = ?, jumlah_nila_merah = ?, jumlah_nila_hitam = ?, berat = ?, lampiran = ? WHERE id_stok = ?',
            [id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran, id_stok]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Stock not found' });
        }

        res.json({ message: 'Stock updated successfully' });
    } catch (error) {
        console.error('Error updating stock:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_stok/:id_kolam', authMiddleware, async (req, res) => {
    const { id_stok, id_kolam } = req.params;
    const { tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran } = req.body;

    try {
        const [result] = await db.query('UPDATE stok_ikan SET id_kolam = ?, tgl_tebar = ?, tgl_panen = ?, jumlah_nila_merah = ?, jumlah_nila_hitam = ?, berat = ?, lampiran = ? WHERE id_stok = ?',
            [id_kolam, tgl_tebar, tgl_panen, jumlah_nila_merah, jumlah_nila_hitam, berat, lampiran, id_stok]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Stock not found' });
        }

        res.json({ message: 'Stock updated successfully' });
    } catch (error) {
        console.error('Error updating stock:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.delete('/:id_stok', authMiddleware, async (req, res) => {
    const { id_stok } = req.params;

    try {
        const [result] = await db.query('DELETE FROM stok_ikan WHERE id_stok = ?', [id_stok]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Stock not found' });
        }

        res.json({ message: 'Stock deleted successfully' });
    } catch (error) {
        console.error('Error deleting stock:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;