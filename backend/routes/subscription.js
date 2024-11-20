const express = require('express');
const bodyParser = require('body-parser');
const db = require('../db');
const authMiddleware = require('../middleware/auth');

const router = express.Router();
router.use(bodyParser.json());

router.post('/', authMiddleware, (req, res) => {
    const subscription = req.body;
    const id_pengguna = req.user.id;

    const query = 'INSERT INTO subscriptions (id_pengguna, endpoint, `keys`) VALUES (?, ?, ?)';
    const values = [id_pengguna, subscription.endpoint, JSON.stringify(subscription.keys)];

    db.query(query, values, (error, results) => {
        if (error) {
            console.error('Error saving subscription:', error);
            return res.sendStatus(500);
        }
        res.sendStatus(201);
    });
});


module.exports = router;