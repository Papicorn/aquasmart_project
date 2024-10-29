import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Ganti useHistory dengan useNavigate
import axios from 'axios';

const SignupForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate(); // Ganti history dengan navigate

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!username || !password) {
            setError('Username and password are required');
            return;
        }
        setLoading(true);
        try {
            // Mengirim permintaan signup ke server
            const response = await axios.post('/api/users/signup', {
                username: username,
                password: password
            });
            // Jika signup berhasil, arahkan pengguna ke halaman login
            navigate('/login'); // Ganti dengan rute yang sesuai
        } catch (error) {
            if (error.response && error.response.data) {
                setError(error.response.data.error || 'Signup failed');
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
            <button type="submit" disabled={loading}>Signup</button>

            {error && <div style={{ color: 'red' }}>{error}</div>}
            {loading && <div>Loading...</div>}
        </form>
    );
};

export default SignupForm;