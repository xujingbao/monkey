/**
 *  Promise based HTTP client for the browser and node.js (https://github.com/mzabriskie/axios)
 -   Make XMLHttpRequests from the browser
 -   Make http requests from node.js
 -   Supports the Promise API
 -   Intercept request and response
 -   Transform request and response data
 -   Cancel requests
 -   Automatic transforms for JSON data
 -   Client side support for protecting against XSRF
 */
import axios from 'axios';

let base = '';

export const requestLogin = params => {
    return axios.post(`${base}/login`, params).then(res => res.data);
};

export const getUserList = params => {
    return axios.get(`${base}/user/list`, {
        params: params
    });
};

export const getUserListPage = params => {
    return axios.get(`${base}/user/listpage`, {
        params: params
    });
};

export const removeUser = params => {
    return axios.get(`${base}/user/remove`, {
        params: params
    });
};

export const batchRemoveUser = params => {
    return axios.get(`${base}/user/batchremove`, {
        params: params
    });
};

export const editUser = params => {
    return axios.get(`${base}/user/edit`, {
        params: params
    });
};

export const addUser = params => {
    return axios.get(`${base}/user/add`, {
        params: params
    });
};