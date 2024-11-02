import React from 'react';
import ReactDOM from 'react-dom/client'; // Ganti dari 'react-dom' ke 'react-dom/client'
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import './index.css'

const rootElement = document.getElementById('root'); // Ambil elemen root
const root = ReactDOM.createRoot(rootElement); // Gunakan createRoot

root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);