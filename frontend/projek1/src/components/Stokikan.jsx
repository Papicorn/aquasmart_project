import React, { useState, useEffect } from 'react';
import stokikanService from '../services/stokikanService';

const Stokikan = () => {
    const [stokikans, setStokikans] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchStokikans = async () => {
            try {
                const response = await stokikanService.getStokikanByUser(localStorage.getItem('token'));
                setStokikans(response.data);
            } catch (error) {
                setError(error.message);
            }
        };
        fetchStokikans();
    }, []);

    return (
        <div>
            <h1>Stok Ikan</h1>
            <ul>
                {stokikans.map((stokikan) => (
                    <li key={stokikan.id}>{stokikan.nama_ikan}</li>
                ))}
            </ul>
            {error && <div style={{ color: 'red' }}>{error}</div>}
        </div>
    );
};

export default Stokikan;