import React from 'react';
import { useNavigate } from 'react-router-dom';
import backgroundImage from '../assets/background_login.jpg';
import logoImage from '../assets/logo.jpg';
import './Login.css';

const Login = ({ setIsLoggedIn }) => {
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    setIsLoggedIn(true); 
    navigate('/dashboard');
  };

  return (
    <div className="login-container" style={{ backgroundImage: `url(${backgroundImage})` }}>
      <div className="login-box">
        <div className="logo">
          <img src={logoImage} alt="AQUA Logo" className="logo-image" />
        </div>
        <div className="login-form">
          <h3>Masuk ke Akun Anda</h3>
          <form onSubmit={handleLogin}>
            <input type="email" placeholder="Email" required />
            <input type="password" placeholder="Kata Sandi" required />
            <div className="remember-me">
              <input type="checkbox" id="rememberMe" />
              <label htmlFor="rememberMe">Ingat Saya</label>
            </div>
            <button type="submit">Masuk</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
