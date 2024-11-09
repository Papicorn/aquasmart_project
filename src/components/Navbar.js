import React from 'react';
import './Navbar.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-logo">
        <img src="logo.png" alt="Aqua Smart" /> {/* Ganti dengan logo aplikasi */}
      </div>
      <div className="navbar-menu">
        <a href="/" className="navbar-link active">Beranda</a>
        <a href="/pengguna" className="navbar-link">Pengguna</a>
        <a href="/laporan" className="navbar-link">Laporan</a>
        <a href="/dokumentasi" className="navbar-link">Dokumentasi</a>
      </div>
      <div className="navbar-icons">
        <i className="fas fa-bell navbar-icons"></i> {/* Ikon Notifikasi */}
        <i className="fas fa-user navbar-icons"></i> {/* Ikon User */}
      </div>
    </nav>
  );
};

export default Navbar;
