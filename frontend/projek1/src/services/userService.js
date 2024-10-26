import axios from 'axios';

const API_URL = 'http://localhost:3000/api/users';

axios.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
});

const userService = {
    async login(username, password) {
        const response = await axios.post(`${API_URL}/users/login`, { username, password });
        return response.data;
    },
    async signup(username, password) {
        const response = await axios.post(`${API_URL}/users/signup`, { username, password });
        return response.data;
    }
};

export default userService;