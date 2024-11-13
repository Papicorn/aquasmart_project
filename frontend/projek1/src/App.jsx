import "./App.css";
import { Routes, Route, Navigate, Outlet } from "react-router-dom";
import { useEffect, useState } from "react";

// Import komponen
import Login from './components/Login';
import Dashboard from './components/Dashboard';
import LaporanPage from "./pages/laporan/laporan-page";
import EditPage from "./pages/laporan/edit-page/edit-page";
import LaporanAddingPage from "./pages/laporan/adding-page/adding-page";
import PenggunaPage from "./pages/pengguna/pengguna-page";
import PenggunaAddingPage from "./pages/pengguna/addding-page/adding-page";
import Dokumentasi from './components/Dokumentasi';
import PenggunaEditPage from './pages/pengguna/edit-page/edit-page'
import TambahDokumentasi from './components/TambahDokumentasi';
import Profile from './pages/profile/profile'
import Reminder from './components/Reminder'

import { Navbar } from "./components/navbar";
import { Hero } from "./components/hero";
import { Footer } from "./components/footer";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const loggedInStatus = localStorage.getItem('isLoggedIn') === 'true';
    setIsLoggedIn(loggedInStatus);
  }, []);

  useEffect(() => {
    localStorage.setItem('isLoggedIn', isLoggedIn);
  }, [isLoggedIn]);

  // Komponen wrapper untuk rute yang dilindungi
  const ProtectedLayout = () => {
    return isLoggedIn ? (
      <>
        <Navbar />
        <Hero />
        <Outlet />
        <Footer />
      </>
    ) : (
      <Navigate to="/login" />
    );
  };

  return (
    <Routes>

      <Route path="/login" element={<Login setIsLoggedIn={setIsLoggedIn} />} />


      <Route element={<ProtectedLayout />}>
        <Route path="/" element={<Navigate to="/dashboard" />} />
        <Route path="/dashboard" element={<Dashboard />} />


        <Route path="/laporan" element={<LaporanPage />} />
        <Route path="/laporan/:id" element={<EditPage />} />
        <Route path="/laporan/adding-page" element={<LaporanAddingPage />} />


        <Route path="/pengguna" element={<PenggunaPage />} />
        <Route path="/pengguna/adding-page" element={<PenggunaAddingPage />} />
        <Route path="/pengguna/:id" element={<PenggunaEditPage />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/reminder" element={<Reminder />} />

        <Route path="/dokumentasi" element={<Dokumentasi />} />
        <Route path="/tambah-dokumentasi" element={<TambahDokumentasi />} />
      </Route>

      {/* Tangani rute yang tidak ditemukan */}
      <Route path="*" element={<Navigate to={isLoggedIn ? "/dashboard" : "/login"} />} />
    </Routes>
  );
}

export default App;