import axios from '@/libs/api.request'
import siteApi from '@/api/site'
let tagApi = {};

tagApi.getAll = function(){
  return axios.request({
    url: 'cms/tag/getAll',
    method: 'get',
    params: {
      siteId: siteApi.getCurrentSiteID()
    }
  });
}

tagApi.getByName = function(name){
  return axios.request({
    url: 'cms/tag/getByName',
    method: 'get',
    params: {
      name: name,
      siteId: siteApi.getCurrentSiteID()
    }
  });
}

tagApi.commonRequest = function(condition){
  condition.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/tag/commonRequest',
    method: 'post',
    data: condition
  });
}

tagApi.getById = function(id){
  return axios.request({
    url: 'cms/tag/getById',
    method: 'get',
    params: {
      id: id
    }
  });
}

tagApi.delete = function(id){
  return axios.request({
    url: 'cms/tag/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

tagApi.addOrUpdate = function(tag){
  tag.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/tag/addOrUpdate',
    method: 'post',
    data: tag
  });
}

export default tagApi;

