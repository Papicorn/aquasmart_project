import React from "react";
import Grafik from "../components/Grafiks";
import TransactionList from '../components/TransactionList';

const Laporan = () => {
    return (
        <div className="container">
            <h1 className="mt-5">Laporan Pemasukan dan Pengeluaran</h1>
            <p className="lead">Berikut adalah grafik yang menunjukkan pemasukan dan pengeluaran bulanan.</p>
            <Grafik />
            <TransactionList />
        </div>
    );
};

export default Laporan;