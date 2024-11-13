// src/components/Pengguna.js
import React, { useState } from 'react';
import './Pengguna.css';

const Pengguna = () => {
  // State untuk pengguna
  const [users, setUsers] = useState([
    {
      name: 'Budiono Siregar',
      role: 'Petani',
      registrationDate: '20 Oktober 2000',
      location: 'Indojaya Bioflok',
      email: 'budiono@example.com',
      password: 'password123',
    },
  ]);

  // State untuk form input
  const [newUser, setNewUser] = useState({
    name: '',
    role: 'Petani', // Default role
    registrationDate: '',
    location: '',
    email: '',
    password: '',
  });

  // State untuk kontrol tampilan form
  const [isFormVisible, setFormVisible] = useState(false);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewUser({
      ...newUser,
      [name]: value,
    });
  };

  const handleAddUser = () => {
    if (newUser.name && newUser.role && newUser.registrationDate && newUser.location && newUser.email && newUser.password) {
      setUsers([...users, newUser]);
      setNewUser({ name: '', role: 'Petani', registrationDate: '', location: '', email: '', password: '' }); // Reset form
      setFormVisible(false); // Sembunyikan form setelah menambahkan pengguna
    } else {
      alert('Semua field harus diisi!');
    }
  };

  return (
    <div className="pengguna-container">
      <h2>Total Pengguna Keseluruhan</h2>
      <h3>{users.length} Pengguna</h3>
      
      <div className="user-list">
        {users.map((user, index) => (
          <div key={index} className="user-card">
            <div className="user-info">
              <h4>{user.name} <span>{user.role}</span></h4>
              <p><strong>Tgl Daftar:</strong> {user.registrationDate}</p>
              <p><strong>Lokasi:</strong> {user.location}</p>
              <p><strong>Email:</strong> {user.email}</p>
            </div>
            <div className="user-options">⋮</div>
          </div>
        ))}
      </div>

      {/* Form untuk menambah pengguna */}
      {isFormVisible && (
        <div className="add-user-form">
          <input
            type="text"
            name="name"
            placeholder="Nama Lengkap"
            value={newUser.name}
            onChange={handleInputChange}
          />
          <input
            type="text"
            name="location"
            placeholder="Lokasi Bioflok"
            value={newUser.location}
            onChange={handleInputChange}
          />
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={newUser.email}
            onChange={handleInputChange}
          />
          <select
            name="role"
            value={newUser.role}
            onChange={handleInputChange}
          >
            <option value="Petani">Petani</option>
            <option value="Admin">Admin</option>
          </select>
          <input
            type="password"
            name="password"
            placeholder="Kata Sandi"
            value={newUser.password}
            onChange={handleInputChange}
          />
          <button onClick={handleAddUser}>Tambah Pengguna</button>
        </div>
      )}

      {/* Tombol untuk menampilkan form */}
      <button className="floating-button" onClick={() => setFormVisible(!isFormVisible)}>
        {isFormVisible ? '-' : '+'}
      </button>
    </div>
  );
};

export default Pengguna;
