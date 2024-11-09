import React from 'react';
import './Notification.css';

const Notification = ({ message, onClose }) => {
  return (
    <div className="notification">
      <h3>Notifikasi</h3>
      <p>{message}</p>
      <button onClick={onClose}>Oke</button>
      <button onClick={onClose} className="close-button">✖</button>
    </div>
  );
};

export default Notification;
