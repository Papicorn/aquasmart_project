// src/App.js
import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './components/Login';
import Dashboard from './components/Dashboard';
import Pengguna from './components/Pengguna';
import Dokumentasi from './components/Dokumentasi';
import TambahPengguna from './components/TambahPengguna';
import TambahDokumentasi from './components/TambahDokumentasi'; // Import new component

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const loggedInStatus = localStorage.getItem('isLoggedIn') === 'true';
    setIsLoggedIn(loggedInStatus);
  }, []);

  useEffect(() => {
    localStorage.setItem('isLoggedIn', isLoggedIn);
  }, [isLoggedIn]);

  const ProtectedRoute = ({ element }) => {
    return isLoggedIn ? element : <Navigate to="/login" />;
  };

  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login setIsLoggedIn={setIsLoggedIn} />} />
        <Route path="/dashboard" element={<ProtectedRoute element={<Dashboard />} />} />
        <Route path="/pengguna" element={<ProtectedRoute element={<Pengguna />} />} />
        <Route path="/dokumentasi" element={<ProtectedRoute element={<Dokumentasi />} />} />
        <Route path="/tambah-pengguna" element={<ProtectedRoute element={<TambahPengguna />} />} />
        
        {/* New route for TambahDokumentasi */}
        <Route path="/tambah-dokumentasi" element={<ProtectedRoute element={<TambahDokumentasi />} />} />
        

        {/* Redirect any other path to dashboard or login */}
        <Route path="*" element={<Navigate to={isLoggedIn ? "/dashboard" : "/login"} />} />
      </Routes>
    </Router>
  );
}

export default App;
