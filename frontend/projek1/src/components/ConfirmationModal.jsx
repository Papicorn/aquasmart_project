import React from 'react';
import './ConfirmationModal.css';

const ConfirmationModal = ({ message, onConfirm, onCancel }) => {
  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h2>{message}</h2>
        <div className="modal-buttons">
          <button className="btn-confirm" onClick={onConfirm}>Hapus</button>
          <button className="btn-cancel" onClick={onCancel}>Batal</button>
        </div>
      </div>
    </div>
  );
};

export default ConfirmationModal;
