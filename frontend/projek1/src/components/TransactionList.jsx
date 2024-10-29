// src/TransactionList.jsx
import React from 'react';
import '@fortawesome/fontawesome-free/css/all.min.css';
import './TransactionList.css'; // Jika Anda ingin memisahkan CSS
import '@fortawesome/fontawesome-free/css/all.min.css';
const transactions = [
    {
        id: 1,
        icon: 'fas fa-fish',
        title: 'Penjualan Ikan x526',
        time: '20:56:08',
        amount: 825000,
        type: 'pemasukan',
    },
    {
        id: 2,
        icon: 'fas fa-fish',
        title: 'Pembelian Stok Pakan 3kg',
        time: '20:56:08',
        amount: 825000,
        type: 'pengeluaran',
    },
    {
        id: 3,
        icon: 'fas fa-egg',
        title: 'Pembelian Bibit ikan x600',
        time: '20:56:08',
        amount: 825000,
        type: 'pengeluaran',
    },
    // Tambahkan lebih banyak transaksi sesuai kebutuhan
];

const TransactionList = () => {
    return (
        <div>
            <div className="header">
                <h1>Bulan Oktober 2024</h1>
                <div className="summary">
                    Laba : <span>Rp123.456</span> Rugi : <span>Rp0</span>
                </div>
            </div>
            <ul className="transaction-list">
                {transactions.map(transaction => (
                    <li key={transaction.id} className="transaction-item">
                        <div className="icon"><i className={transaction.icon}></i></div>
                        <div className="details">
                            <p className="title">{transaction.title}</p>
                            <p className="time">{transaction.time}</p>
                        </div>
                        <div className="amount">
                            <p className={`value ${transaction.type === 'pemasukan' ? 'income' : 'expense'}`}>
                                Rp {transaction.amount.toLocaleString()}
                            </p>
                            <p className="type">{transaction.type}</p>
                        </div>
                        <div className="menu"><i className="fas fa-ellipsis-v"></i></div>
                    </li>
                ))}
            </ul>
            <button className="add-button"><i className="fas fa-plus"></i></button>
        </div>
    );
};

export default TransactionList;