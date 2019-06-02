import axios from '@/libs/api.request'

let advertisementApi = {};

advertisementApi.commonRequest = function(condition){

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
  return axios.request({
    url: 'cms/advertisement/addOrUpdate',
    method: 'post',
    data: advertisement
  });
}

export default advertisementApi;

