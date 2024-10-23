import React, { useState } from 'react';
import userService from '../services/userService';

const LoginForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await userService.login(username, password);
            // Simpan token ke localStorage
            localStorage.setItem('token', response.token);
            // Redirect ke halaman stok ikan
            window.location.href = '/stok-ikan';
        } catch (error) {
            setError(error.message);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>Username:</label>
            <input type="text" value={username} onChange={(event) => setUsername(event.target.value)} />
            <br />
            <label>Password:</label>
            <input type="password" value={password} onChange={(event) => setPassword(event.target.value)} />
            <br />
            <button type="submit">Login</button>
            {error && <div style={{ color: 'red' }}>{error}</div>}
        </form>
    );
};

export default LoginForm;