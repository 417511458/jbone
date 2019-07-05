import axios from '@/libs/api.request'
import siteApi from '@/api/site'

let pluginApi = {};

pluginApi.getAll = function(siteId){
  return axios.request({
    url: 'cms/plugin/getAll',
    method: 'get',
    params: {
      siteId: siteId
    }
  });
}

pluginApi.getById = function(id){
  return axios.request({
    url: 'cms/plugin/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

pluginApi.addOrUpdate = function(plugin){
  plugin.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/plugin/addOrUpdate',
    method: 'post',
    data: plugin
  });
}

pluginApi.delete = function(id){
  return axios.request({
    url: 'cms/plugin/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}


export default pluginApi;

