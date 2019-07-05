import axios from '@/libs/api.request'
import siteApi from '@/api/site'
let linkApi = {};

linkApi.getAll = function(){
  return axios.request({
    url: 'cms/link/getAll',
    method: 'get',
    params:{
      siteId: siteApi.getCurrentSiteID()
    }
  });
}

linkApi.getById = function(id){
  return axios.request({
    url: 'cms/link/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

linkApi.addOrUpdate = function(link){
  link.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/link/addOrUpdate',
    method: 'post',
    data: link
  });
}

linkApi.delete = function(id){
  return axios.request({
    url: 'cms/link/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

linkApi.batchDelete = function (ids) {
  return axios.request({
    url: 'cms/link/batchDelete',
    method: 'delete',
    params: {
      ids: ids
    }
  });
}

export default linkApi;

