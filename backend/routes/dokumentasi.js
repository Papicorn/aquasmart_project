const express = require('express');
const multer = require('multer');
const router = express.Router();
const db = require('../db');
const authMiddleware = require('../middleware/auth');
const path = require('path');
const fs = require('fs');



const uploadDir = path.join(__dirname, '../uploads');



const storage = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, uploadDir);
    },
    filename: (req, file, cb) => {
        cb(null, Date.now() + path.extname(file.originalname));
    }
});


const fileFilter = (req, file, cb) => {
    cb(null, true);
};

const upload = multer({
    storage: storage,
    fileFilter: fileFilter,
    limits: { fileSize: 5 * 1024 * 1024 }
});

router.post('/', authMiddleware, upload.single('foto'), async (req, res) => {
    const { catatan } = req.body;


    if (!req.file) {
        return res.status(400).json({ error: 'File not uploaded' });
    }

    const fotoUrl = `/uploads/${req.file.filename}`;
    const id_pengguna = req.user.id;

    try {
        const [result] = await db.query('INSERT INTO dokumentasi (id_pengguna, catatan, foto_url) VALUES (?, ?, ?)', [id_pengguna, catatan, fotoUrl]);
        res.status(201).json({ message: 'Dokumentasi created successfully', id_dokumentasi: result.insertId });
    } catch (error) {
        console.error('Error creating dokumentasi:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/', authMiddleware, async (req, res) => {
    try {
        const [rows] = await db.query('SELECT * FROM dokumentasi');
        res.json(rows);
    } catch (error) {
        console.error('Error fetching dokumentasi:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.get('/:id_dokumentasi', authMiddleware, async (req, res) => {
    const { id_dokumentasi } = req.params;

    try {
        const [rows] = await db.query('SELECT * FROM dokumentasi WHERE id_dokumentasi = ?', [id_dokumentasi]);
        if (rows.length === 0) {
            return res.status(404).json({ error: 'Dokumentasi not found' });
        }
        res.json(rows[0]);
    } catch (error) {
        console.error('Error fetching dokumentasi:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.put('/:id_dokumentasi', authMiddleware, upload.single('foto'), async (req, res) => {
    const { id_dokumentasi } = req.params;

    try {
        const [dokumen] = await db.query('SELECT foto_url FROM dokumentasi WHERE id_dokumentasi = ?', [id_dokumentasi]);

        if (dokumen.length === 0) {
            return res.status(404).json({ error: 'Dokumentasi not found' });
        }

        const fotoUrlLama = dokumen[0].foto_url;

        if (fotoUrlLama) {
            const filePathLama = path.join(__dirname, '..', fotoUrlLama);
            fs.unlink(filePathLama, (err) => {
                if (err) {
                    console.error('Error deleting old file:', err);
                }
            });
        }

        const fotoUrlBaru = `uploads/${req.file.filename}`;
        await db.query('UPDATE dokumentasi SET foto_url = ? WHERE id_dokumentasi = ?', [fotoUrlBaru, id_dokumentasi]);

        res.json({ message: 'Dokumentasi updated successfully', foto_url: fotoUrlBaru });
    } catch (error) {
        console.error('Error updating dokumentasi:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});


router.delete('/:id_dokumentasi', authMiddleware, async (req, res) => {
    const { id_dokumentasi } = req.params;

    try {
        const [dokumen] = await db.query('SELECT foto_url FROM dokumentasi WHERE id_dokumentasi = ?', [id_dokumentasi]);

        if (dokumen.length === 0) {
            return res.status(404).json({ error: 'Dokumentasi not found' });
        }

        const fotoUrl = dokumen[0].foto_url;

        const [result] = await db.query('DELETE FROM dokumentasi WHERE id_dokumentasi = ?', [id_dokumentasi]);

        if (result.affectedRows === 0) {
            return res.status(404).json({ error: 'Dokumentasi not found' });
        }

        if (fotoUrl) {
            const filePath = path.join(__dirname, '..', fotoUrl);
            fs.unlink(filePath, (err) => {
                if (err) {
                    console.error('Error deleting file:', err);
                } else {
                    console.log('File deleted successfully');
                }
            });
        }

        res.json({ message: 'Dokumentasi deleted successfully' });
    } catch (error) {
        console.error('Error deleting dokumentasi:', error);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

module.exports = router;