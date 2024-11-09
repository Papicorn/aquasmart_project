// src/components/Dokumentasi.js
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBell, faUser } from '@fortawesome/free-solid-svg-icons';
import Notification from './Notification';
import './Dokumentasi.css';
import logo from '../assets/logo.jpg';
import hero from '../assets/hero.png';

const Dokumentasi = () => {
  const [showNotification, setShowNotification] = useState(true);
  const [dataDokumentasi, setDataDokumentasi] = useState([]);

  useEffect(() => {
    // Load data from localStorage
    const savedData = JSON.parse(localStorage.getItem('dokumentasiData')) || [];
    setDataDokumentasi(savedData);
  }, []);

  const handleCloseNotification = () => {
    setShowNotification(false);
  };

  return (
    <div className="dokumentasi-container">
      {/* Navbar */}
      <header className="navbar">
        <img src={logo} alt="Aqua Smart Logo" className="logo-navbar" />
        <nav>
          <Link to="/dashboard">Beranda</Link>
          <Link to="/pengguna">Pengguna</Link>
          <Link to="/laporan">Laporan</Link>
          <Link to="/dokumentasi">Dokumentasi</Link>
        </nav>
        <div className="navbar-icons">
          <FontAwesomeIcon icon={faBell} className="icon" title="Notifications" />
          <FontAwesomeIcon icon={faUser} className="icon" title="User Profile" />
        </div>
      </header>

      {/* Background Image */}
      <div className="hero-section">
        <img src={hero} alt="Background" className="background-image" />
      </div>

      {/* Notification */}
      {showNotification && (
        <Notification 
          message="Jadwal panen hari ini pada jam 09:00 WIB di kolam A2 dan A4."
          onClose={handleCloseNotification} 
        />
      )}

      {/* Documentation Table */}
      <h2 className="dokumentasi-title">Dokumentasi </h2>
      <div className="dokumentasi-table-container">
        <table className="dokumentasi-table">
          <thead>
            <tr>
              <th>No</th>
              <th>Foto Dokumentasi</th>
              <th>Nama Kegiatan</th>
              <th>Keterangan</th>
              <th>Tanggal</th>
            </tr>
          </thead>
          <tbody>
            {dataDokumentasi.length > 0 ? (
              dataDokumentasi.map((item, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>
                    {item.foto ? (
                      <img src={item.foto} alt="Dokumentasi" className="foto-dokumentasi" />
                    ) : (
                      <span className="no-image-text">No Image</span>
                    )}
                  </td>
                  <td>{item.nama}</td>
                  <td>{item.keterangan}</td>
                  <td>{item.tanggal}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="5" className="no-data">No Data Available</td>
              </tr>
            )}
          </tbody>
        </table>
        {/* Link to TambahDokumentasi */}
        <Link to="/TambahDokumentasi">
          <button className="add-btn">+</button>
        </Link>
      </div>

      {/* Footer */}
      <footer className="footer">
        <p>&copy; 2024 Aqua Smart</p>
      </footer>
    </div>
  );
};

export default Dokumentasi;
