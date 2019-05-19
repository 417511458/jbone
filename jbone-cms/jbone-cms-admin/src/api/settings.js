import axios from '@/libs/api.request'

let settingsApi = {};

settingsApi.getAll = function(){
  return axios.request({
    url: 'cms/settings/getMap',
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

settingsApi.addOrUpdate = function(settings){
  return axios.request({
    url: 'cms/settings/addOrUpdate',
    method: 'post',
    data: settings
  });
}


settingsApi.batchAddOrUpdate = function(settingsArray){
  let settingsData = {settingsList: settingsArray}
  return axios.request({
    url: 'cms/settings/batchAddOrUpdate',
    method: 'post',
    data: settingsData
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

