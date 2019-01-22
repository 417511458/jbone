import axios from 'axios'
import store from '@/store'
import { getToken } from '@/libs/util'
// import { Spin } from 'iview'
import Vue from 'vue'

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
        'Access-Control-Allow-Origin': 'http://jbone-cms-admin.majunwei.com:50002',
        'Access-Control-Allow-Credentials': true,
        'Content-Type': 'application/x-www-form-urlencoded'
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

        /* 这里就是用来解决POST提交json数据的时候是直接把整个json放在request payload中提交过去的情况
         * 这里简单处理下，把 {name: 'admin', pwd: 123}这种转换成name=admin&pwd=123就可以通过
         * x-www-form-urlencoded这种方式提交
         * */
        if (data) {
          headers['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

          let keys2 = Object.keys(data);
          /* 这里就是把json变成url形式，并进行encode */
          return encodeURI(keys2.map(name => `${name}=${data[name]}`).join('&'));
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
      // this.$Message.info(error.message);
      console.log(error);
      return Promise.reject(error);
    });
  }
  request (options) {
    const instance = axios.create({params:{token:getToken()}});
    options = Object.assign(this.getInsideConfig(), options);
    this.interceptors(instance, options.url);
    return instance(options);
  }
}
export default HttpRequest
