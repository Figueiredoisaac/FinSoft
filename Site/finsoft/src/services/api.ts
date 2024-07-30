import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080', // Atualize para o URL correto do seu backend
});

export default api;
