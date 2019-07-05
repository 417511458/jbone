import axios from '@/libs/api.request'
import siteApi from '@/api/site'
let categoryApi = {};

categoryApi.getCategoryTree = function(){
  return axios.request({
    url: 'cms/category/getCategoryTree',
    method: 'get',
    params:{
      siteId: siteApi.getCurrentSiteID()
    }
  });
}

categoryApi.getById = function(id){
  return axios.request({
    url: 'cms/category/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

categoryApi.addOrUpdate = function(cate){
  cate.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/category/addOrUpdate',
    method: 'post',
    data: cate
  });
}

categoryApi.delete = function(id){
  return axios.request({
    url: 'cms/category/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

export default categoryApi;

