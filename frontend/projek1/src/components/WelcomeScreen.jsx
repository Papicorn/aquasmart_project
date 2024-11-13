// src/components/WelcomeScreen.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import './WelcomeScreen.css';

const WelcomeScreen = () => {
  const navigate = useNavigate();

  const handleLoginClick = () => {
    navigate('/login');
  };

  return (
    <div className="welcome-container">
      <div className="welcome-box">
        <h1>Selamat Datang di Aqua Smart!</h1>
        <p>
          Kelola perikanan Anda dengan mudah dan efisien. Kami hadir untuk
          membantu Anda memantau, mengelola, dan meningkatkan hasil budidaya
          perikanan secara cerdas dan praktis.
        </p>
        <button onClick={handleLoginClick}>Masuk</button>
      </div>
    </div>
  );
};

export default WelcomeScreen;
