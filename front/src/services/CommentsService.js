import axios from "axios";
import { getToken } from "./AuthService";

const BASE_REST_API_URL = 'http://localhost:8080/api/comments';

axios.interceptors.request.use(function (config) {

    config.headers['Authorization'] = getToken();

    return config;
}, function (error) {

    return Promise.reject(error);
});

export const getAllComments = () => axios.get(BASE_REST_API_URL)

export const saveComment = (comment) => axios.post(BASE_REST_API_URL, comment)

export const getComment = (id) => axios.get(BASE_REST_API_URL + '/' + id)

export const updateComment = (id, comment) => axios.put(BASE_REST_API_URL + '/' + id, comment)

export const deleteComment = (id) => axios.delete(BASE_REST_API_URL + '/' + id)

