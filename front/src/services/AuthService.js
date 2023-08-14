import axios from "axios";

const AUTH_REST_API_BASE_URL = "http://localhost:8081/api/auth"

export const registerAPICall = (registerObj) => axios.post(AUTH_REST_API_BASE_URL + '/register', registerObj);

export const loginAPICall = (username, password) => axios.post(AUTH_REST_API_BASE_URL + '/login', { username, password});

export const storeToken = (token) => localStorage.setItem("token", token);

export const bearerToken = () => "Bearer " + localStorage.getItem("token");

export const getToken = () => localStorage.getItem("token");

export const saveLoggedInUser = (username) => sessionStorage.setItem("authenticatedUser", username);

export const isUserLoggedIn = () => {

    const username = sessionStorage.getItem("authenticatedUser");

    if(username == null) {
        return false;
    }    
    else {
        return true;
    }   
}

export const getLoggedInUser = () => {
    const username = sessionStorage.getItem("authenticatedUser");
    return username;
}

export const logout = () => {
    localStorage.clear();
    sessionStorage.clear();
}