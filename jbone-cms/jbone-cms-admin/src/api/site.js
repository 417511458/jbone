import axios from '@/libs/api.request'

let siteApi = {};


siteApi.getByDomain = function(name){
  return axios.request({
    url: 'cms/site/getByDomain',
    method: 'get',
    params: {
      name: name
    }
  });
}

siteApi.commonRequest = function(condition){
  return axios.request({
    url: 'cms/site/commonRequest',
    method: 'post',
    data: condition
  });
}

siteApi.getById = function(id){
  return axios.request({
    url: 'cms/site/getById',
    method: 'get',
    params: {
      id: id
    }
  });
}

siteApi.delete = function(id){
  return axios.request({
    url: 'cms/site/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

siteApi.addOrUpdate = function(site){
  return axios.request({
    url: 'cms/site/addOrUpdate',
    method: 'post',
    data: site
  });
}

export default siteApi;

