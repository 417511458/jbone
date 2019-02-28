import axios from '@/libs/api.request'

let articleApi = {};

articleApi.commonSearch = function(condition){
  return axios.request({
    url: 'cms/article/commonRequest',
    method: 'post',
    data: condition
  });
}

articleApi.getById = function(id){
  return axios.request({
    url: 'cms/article/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

articleApi.addOrUpdate = function(article){
  return axios.request({
    url: 'cms/article/addOrUpdate',
    method: 'post',
    data: article
  });
}

articleApi.delete = function(id){
  return axios.request({
    url: 'cms/article/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

articleApi.flushDelete = function(id){
  return axios.request({
    url: 'cms/article/flushDelete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

articleApi.batchDelete = function (ids) {
  return axios.request({
    url: 'cms/article/batchDelete',
    method: 'delete',
    params: {
      ids: ids
    }
  });
}

export default articleApi;

