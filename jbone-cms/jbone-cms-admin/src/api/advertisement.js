import axios from '@/libs/api.request'
import siteApi from '@/api/site'

let advertisementApi = {};

advertisementApi.commonRequest = function(condition){
  condition.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/advertisement/commonRequest',
    method: 'post',
    data: condition
  });
}

advertisementApi.getById = function(id){
  return axios.request({
    url: 'cms/advertisement/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

advertisementApi.delete = function(id){
  return axios.request({
    url: 'cms/advertisement/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

advertisementApi.addOrUpdate = function(advertisement){
  advertisement.siteId = siteApi.getCurrentSiteID()
  return axios.request({
    url: 'cms/advertisement/addOrUpdate',
    method: 'post',
    data: advertisement
  });
}

export default advertisementApi;

