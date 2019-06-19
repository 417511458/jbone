import axios from 'axios'
import store from '@/store'
import { getToken,getUserId } from '@/libs/util'
// import { Spin } from 'iview'
import Vue from 'vue'

import { refreshToken,toLogin } from '@/libs/auth'

axios.defaults.withCredentials = true;
Vue.prototype.$axios = axios;

const addErrorLog = errorInfo => {
  const { statusText, status, request: { responseURL } } = errorInfo
  let info = {
    type: 'ajax',
    code: status,
    mes: statusText,
    url: responseURL
  }
  if (!responseURL.includes('save_error_logger')) store.dispatch('addErrorLog', info)
}

class HttpRequest {
  constructor (baseUrl = baseURL) {
    this.baseUrl = baseUrl
    this.queue = {}
  }
  getInsideConfig () {
    const config = {
      baseURL: this.baseUrl,
      timeout: 5000,
      withCredentials: true,
      headers: {
        'Access-Control-Allow-Origin': 'http://jbone-cms-admin-vue.majunwei.com:8080',
        'Access-Control-Allow-Credentials': true,
        'Content-Type': 'application/x-www-form-urlencoded',
        common:{'Accept' :'multipart/form-data,application/json,text/plain,*/*'},
        'J-Token': getToken()
        //'X-Requested-With': 'XMLHttpRequest',
      },
      crossDomain: true,
      transformRequest: [function transformRequest(data, headers) {
        /* 把类似content-type这种改成Content-Type */
        let keys = Object.keys(headers);
        let normalizedName = 'Content-Type';
        keys.forEach(name => {
            if (name !== normalizedName && name.toUpperCase() === normalizedName.toUpperCase()) {
            headers[normalizedName] = headers[name];
            delete headers[name];
          }
        });

        //对象采用json传参
        if (data && headers['Content-Type'] !== 'multipart/form-data') {
          headers['Content-Type'] = 'application/json;charset=utf-8';

          return JSON.stringify(data);
        }
      }]
    }
    return config;
  }
  destroy (url) {
    delete this.queue[url]
    if (!Object.keys(this.queue).length) {
      // Spin.hide()
    }
  }
  interceptors (instance, url) {
    // 请求拦截
    //添加请求拦截器
    instance.interceptors.request.use(function (config) {
    //在发送请求之前做某事
      return config;
    }, function (error) {
    //请求错误时做些事
    //   this.$Message.info(error.message);
      console.log(error);
      return Promise.reject(error);
    });
    // 响应拦截
    //添加响应拦截器
    instance.interceptors.response.use(function (response) {
      //对响应数据做些事
      return response;
    }, function (error) {
      //请求错误时做些事
      // console.info(error.message)
      // console.info(error.request)
      console.log(error);
      if(error.request.status == 401){
        console.info("失败了，得跳转到登录页，重新授权")
        // refreshToken();
        toLogin();
      }
      return Promise.reject(error);
    });
  }
  request (options) {
    const instance = axios.create();
    options = Object.assign(this.getInsideConfig(), options);
    this.interceptors(instance, options.url);
    return instance(options);
  }

  requestFile (options,file) {
    let tconfig = {
      //添加请求头
      headers: {
        "Content-Type": "multipart/form-data",
        'J-Token': getToken()
      },
      //添加上传进度监听事件
      onUploadProgress: e => {
        var completeProgress = ((e.loaded / e.total * 100) | 0) + "%";
        console.info(completeProgress)
      }
    };
    let param = new FormData();
    param.append("file", file);
    console.log(param.get("file"));
    return axios.post(this.baseUrl + "/" + options.url, param, tconfig)
  }

  requestByBaseUrl (burl,options) {
    const instance = axios.create();
    options = Object.assign(this.getInsideConfig(), options);
    options.baseURL = burl;
    this.interceptors(instance, options.url);
    return instance(options);
  }
}
export default HttpRequest
