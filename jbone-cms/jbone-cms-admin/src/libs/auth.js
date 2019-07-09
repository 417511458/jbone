import { setToken, getToken,clearToken,setRToken, getRToken,clearRToken, canTurnTo, setTitle } from '@/libs/util'
import axios from '@/libs/api.request'
import config from '@/config'

const SSO_CONFIG = process.env.NODE_ENV === 'development' ? config.sso.dev : config.sso.pro
//需要区分环境的配置
const OAUTH_REDIRECT_URI = SSO_CONFIG.OAUTH_REDIRECT_URI
const SSO_BASE_URL = SSO_CONFIG.SSO_BASE_URL
const OAUTH_CLIENT_ID = SSO_CONFIG.OAUTH_CLIENT_ID
const OAUTH_CLIENT_SECRET = SSO_CONFIG.OAUTH_CLIENT_SECRET

const OAUTH_RESPONSE_CODE = 'code'
const OAUTH_GRANT_TYPE = 'authorization_code'
const OAUTH_GRANT_TYPE_REFRESH_TOKEN = 'refresh_token'
const SSO_LOGOUT = SSO_BASE_URL + 'logout'
const SSO_OAUTH_AUTHOIZE_URL = SSO_BASE_URL + 'oauth2.0/authorize?response_type=' + OAUTH_RESPONSE_CODE + '&client_id=' + OAUTH_CLIENT_ID + '&redirect_uri=' + OAUTH_REDIRECT_URI
const SSO_OAUTH_ACCESSTOKEN_URL = 'oauth2.0/accessToken'


export const handleAuth = (code, callback) => {
  let token = getToken();
  console.info("token:" + token)
  //没有token，表示未登录/已登录但还没获取token
  if(!token){
    //登录过但未获取token
    if(code){
      requestToken(code, callback);
    }
    //还未登录，重定向到登录页
    else{
      toLogin();
    }
  }else{
    //有token,直接调用路由钩子函数回调函数
    callback()
  }
  //有token，表示已经登录过，token过期后需要刷新token
  // else{
  //   refreshToken();
  // }
}

export const toLogin = () => {
  clearAllToken()
  window.location.href = SSO_OAUTH_AUTHOIZE_URL;
}

export const requestToken = (code, callback) => {
  axios.requestByBaseUrl(SSO_BASE_URL,{
    url: SSO_OAUTH_ACCESSTOKEN_URL,
    method: 'get',
    params:{
      grant_type: OAUTH_GRANT_TYPE,
      client_id: OAUTH_CLIENT_ID,
      client_secret: OAUTH_CLIENT_SECRET,
      redirect_uri:OAUTH_REDIRECT_URI,
      code:code
    }
  }).then(function (res) {
    console.info("requestToken result:")
    console.info(res)
    let accessToken = res.data.access_token
    if(accessToken){
      setToken(accessToken)
      //获取到token，调用路由钩子函数回调函数
      callback()
    }else{
      toLogin();
    }
    // let refreshToken = res.data.refresh_token
    // let timeout  = res.data.expires_in
    // if(accessToken && refreshToken){
    //   setToken(accessToken)
    //   setRToken(refreshToken)
    // }else{
    //   toLogin();
    // }


  }).catch(function (error) {
    console.info(error)
    //获取accesstoken失败，表示code过期，需重新登录
    toLogin();
  });
}

//刷新token(为了简化登录流程，不生成refreshtoken了)
export const refreshToken = () => {

  let refreshToken = getRToken()
  console.info('refreshToken: ' + refreshToken)
  if(!refreshToken || refreshToken == 'undefined'){
    toLogin();
    return;
  }
  axios.requestByBaseUrl(SSO_BASE_URL,{
    url: SSO_OAUTH_ACCESSTOKEN_URL,
    method: 'get',
    params:{
      grant_type: OAUTH_GRANT_TYPE_REFRESH_TOKEN,
      client_id: OAUTH_CLIENT_ID,
      client_secret: OAUTH_CLIENT_SECRET,
      refresh_token:refreshToken
    }
  }).then(function (res) {
    console.info("refreshToken result:")
    console.info(res)
    let accessToken = res.data.access_token
    setToken(accessToken)
    setRToken(refreshToken)
  }).catch(function (error) {
    console.info(error)
    //刷新token失败，表示所token都已过期，需重新登录
    toLogin();
  });
}

//token交互失败时，清空所有token，重新获取
export const clearAllToken = () => {
  clearToken()
  // clearRToken()
}

export const logout = () => {
  clearAllToken()
  window.location.href = SSO_LOGOUT;
}
