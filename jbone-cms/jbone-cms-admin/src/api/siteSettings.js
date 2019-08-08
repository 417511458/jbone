import axios from '@/libs/api.request'
import siteApi from '@/api/site'

let siteSettingsApi = {};

siteSettingsApi.getAll = function(){
  return this.getAllWithSiteId(siteApi.getCurrentSiteID())
}

siteSettingsApi.getAllWithSiteId = function(siteId){
  return axios.request({
    url: 'cms/siteSettings/getMap',
    method: 'get',
    params: {
      siteId: siteId
    }
  });
}

siteSettingsApi.commonRequest = function(condition){
  condition.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/siteSettings/commonRequest',
    method: 'post',
    data: condition
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
  settings.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/siteSettings/addOrUpdate',
    method: 'post',
    data: settings
  });
}


siteSettingsApi.batchAddOrUpdate = function(settingsArray){
  let settingsData = {siteId:siteApi.getCurrentSiteID(), settingsList: settingsArray}
  return axios.request({
    url: 'cms/siteSettings/batchAddOrUpdate',
    method: 'post',
    data: settingsData
  });
}

siteSettingsApi.batchAddOrUpdateWithSiteId = function(siteId,settingsArray){
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

