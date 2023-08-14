import axios from "axios";
import { getToken } from "./AuthService";

const BASE_REST_API_URL = 'http://localhost:8081/api/plants';



axios.interceptors.request.use(function (config) {
    config.headers['Authorization'] = getToken();



    return config;

}, function (error) {



    return Promise.reject(error);

});


export const getAllPlants = () => axios.get(BASE_REST_API_URL)

export const savePlant = (plant) => axios.post(BASE_REST_API_URL, plant)

export const getPlant = (id) => axios.get(BASE_REST_API_URL + '/' + id)

export const updatePlant = (id, plant) => axios.put(BASE_REST_API_URL + '/' + id, plant)

export const deletePlant = (id) => axios.delete(BASE_REST_API_URL + '/' + id)

// export const completeTodo = (id) => axios.patch(BASE_REST_API_URL + '/' + id + '/complete')
//
// export const inCompleteTodo = (id) => axios.patch(BASE_REST_API_URL + '/' + id + '/in-complete')