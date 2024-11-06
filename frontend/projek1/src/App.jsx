import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import SignupForm from './components/SignupForm';
import BerandaPage from "./pages/beranda/beranda-page";
import LaporanPage from "./pages/laporan/laporan-page";
import EditPage from "./pages/laporan/edit-page/edit-page";
import LaporanAddingPage from "./pages/laporan/adding-page/adding-page";
import PenggunaPage from "./pages/pengguna/pengguna-page";
import PenggunaAddingPage from "./pages/pengguna/addding-page/adding-page";
import PenggunaEditPage from "./pages/pengguna/edit-page/edit-page";
import ProfilePage from "./pages/profile/profile";
import ProfileEditPage from "./pages/profile/edit-page/edit-page";

import { Navbar } from "./components/navbar";
import { Hero } from "./components/hero";
import { Footer } from "./components/footer";


const App = () => {
  return (
    <>
      <Navbar />
      <Hero />
      <Routes>
        <Route path="/" element={<LoginForm />} />
        <Route path="/home" element={<BerandaPage />} />
        <Route path="/laporan" element={<LaporanPage />} />
        <Route path="/laporan/:id" element={<EditPage />} />
        <Route path="/laporan/adding-page" element={<LaporanAddingPage />} />
        <Route path="/pengguna" element={<PenggunaPage />} />
        <Route path="/pengguna/adding-page" element={<PenggunaAddingPage />} />
        <Route path="/pengguna/:id" element={<PenggunaEditPage />} />
        <Route path="/profile" element={<ProfilePage />} />
        <Route path="/profile" element={<ProfilePage />} />
        <Route path="/profile/edit" element={<ProfileEditPage />} />
        {/* You can add a fallback route here if needed */}
        <Route path="*" element={<Navigate to="/home" />} /> { }
      </Routes>
      <Footer />
    </>
  );
};

export default App;