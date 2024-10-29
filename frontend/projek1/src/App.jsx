import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import SignupForm from './components/SignupForm';
import Laporan from "./pages/Laporan";

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" />} /> {/* Redirect ke "/login" */}
      <Route path="/login" element={<LoginForm />} />
      <Route path="/laporan" element={<Laporan />} />
      <Route path="/signup" element={<SignupForm />} />

    </Routes>
  );
};

export default App;