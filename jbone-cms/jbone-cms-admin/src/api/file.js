import axios from '@/libs/api.request'

let fileApi = {};

fileApi.upload = function(file){
  return axios.requestFile({
    url: 'fs/file/fileUpload',
    method: 'post',
  },file);
}


export default fileApi;

