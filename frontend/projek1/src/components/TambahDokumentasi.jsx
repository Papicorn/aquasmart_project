// src/components/TambahDokumentasi.js
import React, { useState, useEffect } from 'react';
import './TambahDokumentasi.css';
import { useNavigate, useLocation } from 'react-router-dom';
import logo from '../assets/logo.jpg';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBell, faUser } from '@fortawesome/free-solid-svg-icons';

const TambahDokumentasi = () => {
  const [namaKegiatan, setNamaKegiatan] = useState('');
  const [keterangan, setKeterangan] = useState('');
  const [tanggal, setTanggal] = useState('');
  const [foto, setFoto] = useState(null);
  const navigate = useNavigate();
  const location = useLocation();

  const isEditing = location.state && location.state.nama;

  useEffect(() => {
    if (isEditing) {
      const { nama, keterangan, tanggal } = location.state; // Exclude foto from here
      setNamaKegiatan(nama);
      setKeterangan(keterangan);
      setTanggal(tanggal);
    }
  }, [isEditing, location.state]);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Jika foto ada, buat URL untuk foto
    const fotoURL = foto ? URL.createObjectURL(foto) : null;

    const newDokumentasi = { nama: namaKegiatan, keterangan, tanggal, foto: fotoURL };
    const savedData = JSON.parse(localStorage.getItem('dokumentasiData')) || [];

    if (isEditing) {
      // Find the index of the item being edited
      const indexToEdit = savedData.findIndex(item => item.nama === location.state.nama);
      if (indexToEdit !== -1) {
        // Update the existing documentation entry
        savedData[indexToEdit] = newDokumentasi;
        localStorage.setItem('dokumentasiData', JSON.stringify(savedData));
      }
    } else {
      // Add new documentation entry
      savedData.push(newDokumentasi);
      localStorage.setItem('dokumentasiData', JSON.stringify(savedData));
    }

    navigate('/dokumentasi'); // Redirect to the Dokumentasi page
  };

  return (
    <div className="tambah-dokumentasi-background">
      {/* Main Form */}
      <div className="tambah-dokumentasi-container">
        <form onSubmit={handleSubmit} className="tambah-dokumentasi-form">
          <div className="form-group">
            <label htmlFor="namaKegiatan">Nama Kegiatan</label>
            <input
              type="text"
              id="namaKegiatan"
              value={namaKegiatan}
              onChange={(e) => setNamaKegiatan(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="keterangan">Keterangan</label>
            <textarea
              id="keterangan"
              value={keterangan}
              onChange={(e) => setKeterangan(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="tanggal">Tanggal</label>
            <input
              type="date"
              id="tanggal"
              value={tanggal}
              onChange={(e) => setTanggal(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="foto">Foto Dokumentasi</label>
            <input
              type="file"
              id="foto"
              onChange={(e) => setFoto(e.target.files[0])}
              accept="image/*"
            />
          </div>
          <button type="submit" className="btn-tambah">{isEditing ? 'Simpan' : 'Tambah'}</button>
        </form>
      </div>
    </div>
  );
};

export default TambahDokumentasi;