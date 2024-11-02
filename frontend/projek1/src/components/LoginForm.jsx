import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const LoginForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();
    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!username || !password) {
            setError('Username and password are required');
            return;
        }
        setLoading(true);
        try {
            // Mengirim permintaan login ke server
            const response = await axios.post('http://localhost:3000/api/users/login/admin', {
                username: username,
                password: password
            });
            const token = response.data.token; // Mengambil token dari respons
            localStorage.setItem('token', token); // Menyimpan token di localStorage
            navigate('/laporan');
        } catch (error) {
            if (error.response && error.response.data) {
                setError(error.response.data.error || 'Login failed');
            } else {
                setError('An unexpected error occurred');
            }
        } finally {
            setLoading(false);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>Username:</label>
            <input
                type="text"
                value={username}
                onChange={(event) => setUsername(event.target.value)}
            />
            <br />
            <label>Password:</label>
            <input
                type="password"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
            />
            <br />
            <button type="submit" disabled={loading}>Login</button>

            {error && <div style={{ color: 'red' }}>{error}</div>}
            {loading && <div>Loading...</div>}
        </form>
    );
};

export default LoginForm;