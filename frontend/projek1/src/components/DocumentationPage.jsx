import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import './DocumentationPage.css'; // Optional: Custom CSS file for styles

const DocumentationPage = () => {
  return (
    <div>
      {/* Navbar */}
      <nav className="navbar navbar-expand-lg navbar-light bg-primary">
        <div className="container">
          <a className="navbar-brand text-white" href="/">AQUA SMART</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item">
                <a className="nav-link text-white" href="/">Beranda</a>
              </li>
              <li className="nav-item">
                <a className="nav-link text-white" href="/pengguna">Pengguna</a>
              </li>
              <li className="nav-item">
                <a className="nav-link text-white" href="/laporan">Laporan</a>
              </li>
              <li className="nav-item">
                <a className="nav-link text-white" href="/dokumentasi">Dokumentasi</a>
              </li>
            </ul>
          </div>
          <div className="d-flex">
            <button className="btn btn-outline-light" type="button">&#128276;</button>
            <button className="btn btn-outline-light" type="button">&#128100;</button>
          </div>
        </div>
      </nav>

      {/* Hero Section */}
      <div className="hero" style={{ backgroundImage: 'url("/path/to/your/background.jpg")', height: '400px', backgroundSize: 'cover', backgroundPosition: 'center' }}>
        <div className="hero-content text-white text-center">
          <h1>Dokumentasi Kegiatan</h1>
          <p>Menampilkan semua kegiatan dalam sistem</p>
        </div>
      </div>

      {/* Documentation Table */}
      <div className="container my-5">
        <div className="card shadow-lg border-0" style={{ borderRadius: '20px', padding: '20px' }}>
          <h3 className="text-center">Dokumentasi Kegiatan</h3>
          <table className="table table-hover mt-4">
            <thead>
              <tr className="text-center">
                <th>No</th>
                <th>Foto Dokumentasi</th>
                <th>Nama Kegiatan</th>
                <th>Keterangan</th>
                <th>Tanggal</th>
                <th>Aksi</th>
              </tr>
            </thead>
            <tbody className="text-center">
              <tr>
                <td>1</td>
                <td><img src="image1.jpg" alt="Dokumentasi 1" style={{ width: '70px', borderRadius: '10px' }} /></td>
                <td>Lorem Ipsum</td>
                <td>Lorem Ipsum</td>
                <td>00/00/0000</td>
                <td>
                  <button className="btn btn-link text-primary">
                    <i className="fas fa-edit"></i>
                  </button>
                  <button className="btn btn-link text-danger">
                    <i className="fas fa-trash"></i>
                  </button>
                </td>
              </tr>
              {/* Tambahkan baris tambahan sesuai kebutuhan */}
            </tbody>
          </table>
        </div>
        <button className="btn btn-primary rounded-circle" style={{ position: 'fixed', bottom: '20px', right: '20px', width: '50px', height: '50px' }}>
          <i className="fas fa-plus"></i>
        </button>
      </div>

      {/* Footer */}
      <footer className="bg-primary text-white text-center py-4">
        <p>&copy; 2024 Aqua Smart. All Rights Reserved.</p>
      </footer>
    </div>
  );
};

export default DocumentationPage;
