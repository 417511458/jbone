import axios from '@/libs/api.request'
import { getUserId } from '@/libs/util'
import siteApi from '@/api/site'
let articleApi = {};

articleApi.commonSearch = function(condition){
  condition.siteId = siteApi.getCurrentSiteID()
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
  article.creator = getUserId();
  article.siteId = siteApi.getCurrentSiteID()
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

export default articleApi;

