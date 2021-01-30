import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: 'https://osm-burger-app.firebaseio.com/'
});

export default axiosInstance;