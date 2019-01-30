import axios from '@/libs/api.request'

let settingsApi = {};

settingsApi.getAll = function(){
  return axios.request({
    url: 'cms/settings/getList',
    method: 'get'
  });
}

settingsApi.getById = function(id){
  return axios.request({
    url: 'cms/settings/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

settingsApi.addOrUpdate = function(link){
  return axios.request({
    url: 'cms/settings/addOrUpdate',
    method: 'post',
    data: link
  });
}

settingsApi.delete = function(id){
  return axios.request({
    url: 'cms/settings/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

settingsApi.batchDelete = function (ids) {
  return axios.request({
    url: 'cms/settings/batchDelete',
    method: 'delete',
    params: {
      ids: ids
    }
  });
}

export default settingsApi;

