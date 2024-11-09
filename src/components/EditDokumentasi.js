import React from 'react';
import './DokumentasiForm.css';

const EditDokumentasi = () => {
  const handleSubmit = (e) => {
    e.preventDefault();
    // Buek logika untuk manyimpan parubahan
  };

  return (
    <div className="dokumentasi-form-container">
      <h2>Edit Dokumentasi</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Foto Dokumentasi</label>
          <input type="file" required />
        </div>
        <div className="form-group">
          <label>Nama Kegiatan</label>
          <input type="text" placeholder="Nama Kegiatan" required />
        </div>
        <div className="form-group">
          <label>Keterangan</label>
          <textarea placeholder="Keterangan" required></textarea>
        </div>
        <div className="form-group">
          <label>Tanggal</label>
          <input type="date" required />
        </div>
        <button type="submit" className="submit-button">Simpan Perubahan</button>
      </form>
    </div>
  );
};

export default EditDokumentasi;
