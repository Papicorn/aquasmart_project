// src/components/Dokumentasi.js
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBell, faUser, faEdit, faTrash } from '@fortawesome/free-solid-svg-icons'; // Import the edit and trash icons
import Notification from './Notifications';
import ConfirmationModal from './ConfirmationModal'; // Import the confirmation modal
import './Dokumentasi.css';
import logo from '../assets/logo.jpg';


const Dokumentasi = () => {
  const [showNotification, setShowNotification] = useState(true);
  const [dataDokumentasi, setDataDokumentasi] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [deleteIndex, setDeleteIndex] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const savedData = JSON.parse(localStorage.getItem('dokumentasiData')) || [];
    setDataDokumentasi(savedData);
  }, []);

  const handleCloseNotification = () => {
    setShowNotification(false);
  };

  const handleEdit = (index) => {
    const documentationToEdit = dataDokumentasi[index];
    navigate('/tambah-dokumentasi', { state: documentationToEdit });
  };

  const openDeleteModal = (index) => {
    setDeleteIndex(index);
    setIsModalOpen(true);
  };

  const handleDelete = () => {
    const updatedData = dataDokumentasi.filter((_, i) => i !== deleteIndex);
    setDataDokumentasi(updatedData);
    localStorage.setItem('dokumentasiData', JSON.stringify(updatedData));
    setIsModalOpen(false); // Close the modal after deletion
  };

  return (
    <div className="dokumentasi-container">



      {/* Confirmation Modal */}
      {isModalOpen && (
        <ConfirmationModal
          message="Anda yakin ingin menghapus data ini?"
          onConfirm={handleDelete}
          onCancel={() => setIsModalOpen(false)}
        />
      )}

      {/* Documentation Table */}
      <h2 className="dokumentasi-title">Dokumentasi Kegiatan</h2>
      <div className="dokumentasi-table">
        <table>
          <thead>
            <tr>
              <th>No</th>
              <th>Foto Dokumentasi</th>
              <th>Nama Kegiatan</th>
              <th>Keterangan</th>
              <th>Tanggal</th>
              <th>Aksi</th>
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
                      'No Image'
                    )}
                  </td>
                  <td>{item.nama}</td>
                  <td>{item.keterangan}</td>
                  <td>{item.tanggal}</td>
                  <td>
                    <button onClick={() => handleEdit(index)} className="icon-button">
                      <FontAwesomeIcon icon={faEdit} title="Edit" />
                    </button>
                    <button onClick={() => openDeleteModal(index)} className="icon-button">
                      <FontAwesomeIcon icon={faTrash} title="Hapus" />
                    </button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="6">No Data Available</td>
              </tr>
            )}
          </tbody>
        </table>
        {/* Link to TambahDokumentasi */}
        <Link to="/tambah-dokumentasi">
          <button className="add-btn">+</button>
        </Link>
      </div>
    </div>
  );
};

export default Dokumentasi;