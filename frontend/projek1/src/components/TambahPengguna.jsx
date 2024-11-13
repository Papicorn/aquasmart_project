// src/components/TambahPengguna.js
import React, { useState } from 'react';

function TambahPengguna() {
  const [formData, setFormData] = useState({
    nama: '',
    lokasi: '',
    email: '',
    role: '',
    password: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Logika untuk menyimpan data pengguna
    console.log(formData);
  };

  return (
    <div className="tambah-pengguna-container">
      <h2>Tambah Pengguna</h2>
      <form onSubmit={handleSubmit} className="tambah-pengguna-form">
        <label>
          Nama Lengkap
          <input
            type="text"
            name="nama"
            value={formData.nama}
            onChange={handleChange}
            required
          />
        </label>
        
        <label>
          Lokasi Bioflok
          <input
            type="text"
            name="lokasi"
            value={formData.lokasi}
            onChange={handleChange}
            required
          />
        </label>
        
        <label>
          Email
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </label>
        
        <label>
          Role
          <select
            name="role"
            value={formData.role}
            onChange={handleChange}
            required
          >
            <option value="">Pilih Role</option>
            <option value="admin">Admin</option>
            <option value="petani">Petani</option>
            {/* Tambahkan opsi role lainnya jika diperlukan */}
          </select>
        </label>
        
        <label>
          Kata Sandi
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </label>
        
        <button type="submit" className="btn-simpan">Simpan</button>
      </form>
    </div>
  );
}

export default TambahPengguna;
