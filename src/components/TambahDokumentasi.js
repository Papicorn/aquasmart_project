// src/TambahDokumentasi.js
import React, { useState } from 'react';
import './TambahDokumentasi.css'; // Import CSS

const TambahDokumentasi = () => {
    const [formVisible, setFormVisible] = useState(false);

    const tampilkanForm = () => {
        setFormVisible(true); // Tampilkan form
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        alert("Dokumentasi berhasil ditambahkan!"); // Simulasi penambahan
        setFormVisible(false); // Sembunyikan form setelah penambahan
    };

    return (
        <div className="dokumentasi-container">
            <nav className="navbar">
                <a href="#">Beranda</a>
                <a href="#">Pengguna</a>
                <a href="#">Laporan</a>
                <a href="#" className="active">Dokumentasi</a>
            </nav>

            <h1 className="dokumentasi-title">Dokumentasi</h1>

            {formVisible && (
                <form className="form-tambah" onSubmit={handleSubmit}>
                    {/* Form fields */}
                </form>
            )}

            <button className="add-btn" onClick={tampilkanForm}>+</button>

            <footer>
                &copy; 2023 Aqua Brunt
            </footer>
        </div>
    );
};

export default TambahDokumentasi;
