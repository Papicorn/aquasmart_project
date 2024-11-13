import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBell, faUser, faFish, faWater, faDollarSign, faMoneyBillWave } from '@fortawesome/free-solid-svg-icons';
import Notification from './Notifications';
import './Dashboard.css';
import logo from '../assets/logo.jpg';
import nilaSatu from '../assets/nila-satu.jpg';
import nilaDua from '../assets/nila-dua.jpg';
import hero from '../assets/hero.png';
import kolamImage from '../assets/kolam.jpg';

const Dashboard = () => {
  const [showNotification, setShowNotification] = useState(true);

  const handleCloseNotification = () => {
    setShowNotification(false);
  };

  return (
    <div className="dashboard-container">



      {/* Notification */}
      {showNotification && (
        <Notification
          message="Jadwal panen hari ini pada jam 09:00 WIB di kolam A2 dan A4."
          onClose={handleCloseNotification}
        />
      )}

      {/* Summary Cards */}
      <div className="summary-cards">
        <div className="card">
          <FontAwesomeIcon icon={faFish} className="card-icon" />
          <h3>Stok Ikan</h3>
          <p>12.000</p>
        </div>
        <div className="card">
          <FontAwesomeIcon icon={faWater} className="card-icon" />
          <h3>Jumlah Kolam</h3>
          <p>25</p>
        </div>
        <div className="card">
          <FontAwesomeIcon icon={faDollarSign} className="card-icon" />
          <h3>Pemasukan</h3>
          <p>Rp. 5.000.000</p>
        </div>
        <div className="card">
          <FontAwesomeIcon icon={faMoneyBillWave} className="card-icon" />
          <h3>Pengeluaran</h3>
          <p>Rp. 500.000</p>
        </div>
      </div>

      {/* Image Section */}
      <div className="image-section">
        <img src={nilaSatu} alt="Ikan" />
        <img src={nilaDua} alt="Ikan" />
      </div>

      {/* Activity Section */}
      <div className="activity-section">
        <div className="activity-card schedule">
          <h4>Hari Ini (2)</h4>
          <div className="activity-item">
            <p>Panen ikan kolam A1, A2, A3</p>
            <span>09:00</span>
          </div>
          <div className="activity-item">
            <p>Panen ikan kolam A4</p>
            <span>11:00</span>
          </div>
          <h4>Besok (1)</h4>
          <div className="activity-item">
            <p>Panen ikan kolam A5</p>
            <span>09:00</span>
          </div>
        </div>
        <div className="activity-image">
          <img src={kolamImage} alt="Kolam" />
        </div>
      </div>

    </div>
  );
};

export default Dashboard;
