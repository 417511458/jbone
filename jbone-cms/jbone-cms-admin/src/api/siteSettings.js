import axios from '@/libs/api.request'

let siteSettingsApi = {};

siteSettingsApi.getAll = function(siteId){
  return axios.request({
    url: 'cms/siteSettings/getMap',
    method: 'get',
    params: {
      siteId: siteId
    }
  });
}

siteSettingsApi.getById = function(id){
  return axios.request({
    url: 'cms/siteSettings/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

siteSettingsApi.addOrUpdate = function(settings){
  return axios.request({
    url: 'cms/siteSettings/addOrUpdate',
    method: 'post',
    data: settings
  });
}


siteSettingsApi.batchAddOrUpdate = function(siteId,settingsArray){
  let settingsData = {siteId:siteId, settingsList: settingsArray}
  return axios.request({
    url: 'cms/siteSettings/batchAddOrUpdate',
    method: 'post',
    data: settingsData
  });
}

siteSettingsApi.delete = function(id){
  return axios.request({
    url: 'cms/siteSettings/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

siteSettingsApi.batchDelete = function (ids) {
  return axios.request({
    url: 'cms/siteSettings/batchDelete',
    method: 'delete',
    params: {
      ids: ids
    }
  });
}

export default siteSettingsApi;

