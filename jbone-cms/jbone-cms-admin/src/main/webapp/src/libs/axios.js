import axios from 'axios'
import store from '@/store'
// import { Spin } from 'iview'

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
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Credentials': true,
        //'Content-Type': 'application/x-www-form-urlencoded',
        //'X-Requested-With': 'XMLHttpRequest',
      },
      withCredentials: true // 允许携带cookie
    }
    return config
  }
  destroy (url) {
    delete this.queue[url]
    if (!Object.keys(this.queue).length) {
      // Spin.hide()
    }
  }
  interceptors (instance, url) {
    // 请求拦截
    instance.interceptors.request.use(config => {
      // 添加全局的loading...
      if (!Object.keys(this.queue).length) {
        // Spin.show() // 不建议开启，因为界面不友好
      }
      this.queue[url] = true
      return config
    }, error => {
      return Promise.reject(error)
    })
    // 响应拦截
    instance.interceptors.response.use(res => {
      this.destroy(url)
      const { data, status } = res
      return { data, status }
    }, error => {
      this.destroy(url)
      let errorInfo = error.response
      if (!errorInfo) {
        const { request: { statusText, status }, config } = JSON.parse(JSON.stringify(error))
        errorInfo = {
          statusText,
          status,
          request: { responseURL: config.url }
        }
      }
      addErrorLog(errorInfo)
      return Promise.reject(error)
    })
  }
  request (options) {
    const instance = axios.create({
      baseURL: this.baseUrl,
      timeout: 5000, // 请求的超时时间
      withCredentials: true, // 允许携带cookie
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Credentials': true,
        //'Content-Type': 'application/x-www-form-urlencoded',
        //'X-Requested-With': 'XMLHttpRequest',
      },
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
    })
    options = Object.assign(this.getInsideConfig(), options);
    console.info(options);
    this.interceptors(instance, options.url)
    return instance(options)
  }
}
export default HttpRequest
