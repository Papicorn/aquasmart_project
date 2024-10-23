import axios from 'axios';

const API_URL = 'http://localhost:3000/api';

const stokikanService = {
    async getStokikanByUser(userId) {
        const response = await axios.get(`${API_URL}/stokikans/${userId}`);
        return response.data;
    },
    async createStokikan(stokikanData) {
        const response = await axios.post(`${API_URL}/stokikans`, stokikanData);
        return response.data;
    }
};

export default stokikanService;