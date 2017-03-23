/**
 *  Promise based HTTP client for the browser and node.js (https://github.com/mzabriskie/axios)
 */
import axios from 'axios';
import qs from 'qs';
import _ from 'lodash'

// lodash test
// console.log(_.defer(function (stamp) {
//     console.log(_.now() - stamp);
// }, _.now()))

/**
 * axios配置
 */
axios.defaults.timeout = 5000
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.baseURL = 'http://localhost:8080'

/**
 * 添加请求拦截器
 */
axios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    if (config.method === 'post') {
        config.data = qs.stringify(config.data)
    }
    return config
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error)
});

/**
 * 添加响应拦截器
 */
axios.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response
}, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error)
});

/**
 * 
 * @param {*} url 
 * @param {*} params 
 * @param {*} method 
 */
export function fetch(url, params, method = 'get') {
    return new Promise((resolve, reject) => {
        axios({
            method: method,
            url: url,
            data: params
        }).then(response => {
            resolve(response.data)
        }, err => {
            reject(err)
        }).catch((error) => {
            reject(error)
        })
    })
}

/**
 * 
 */
export default {

    /**
     * 用户登录
     * @param {*} params 
     */
    requestLogin(params) {
        return fetch('/user/', params);
    },

    /**
     * 获取用户列表
     * @param {*} params 
     */
    getUserList(params) {
        return fetch('/v1/users/', params);
    },

    addUser(params) {
        return fetch('/v1/users/', params, 'post');
    }
}

// export const getUserList = params => {
//     return fetch('/user/list', params);
// }

// export const getUserListPage = params => {
//     return axios.get(`${base}/user/listpage`, {
//         params: params
//     });
// };

// export const removeUser = params => {
//     return axios.get(`${base}/user/remove`, {
//         params: params
//     });
// };

// export const batchRemoveUser = params => {
//     return axios.get(`${base}/user/batchremove`, {
//         params: params
//     });
// };

// export const editUser = params => {
//     return axios.get(`${base}/user/edit`, {
//         params: params
//     });
// };

// export const addUser = params => {
//     return axios.get(`${base}/user/add`, {
//         params: params
//     });
// };