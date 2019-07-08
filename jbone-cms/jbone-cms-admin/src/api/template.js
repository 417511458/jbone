import axios from '@/libs/api.request'

let templateApi = {};


templateApi.commonRequest = function(condition){
  return axios.request({
    url: 'cms/template/commonRequest',
    method: 'post',
    data: condition
  });
}

templateApi.getById = function(id){
  return axios.request({
    url: 'cms/template/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

templateApi.delete = function(id){
  return axios.request({
    url: 'cms/template/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

templateApi.addOrUpdate = function(template){
  return axios.request({
    url: 'cms/template/addOrUpdate',
    method: 'post',
    data: template
  });
}

export default templateApi;

