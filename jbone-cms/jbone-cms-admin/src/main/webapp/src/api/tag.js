import axios from '@/libs/api.request'

let tagApi = {};

tagApi.getAll = function(){
  return axios.request({
    url: 'cms/tag/getAll',
    method: 'get'
  });
}

tagApi.getByName = function(name){
  return axios.request({
    url: 'cms/tag/getByName',
    method: 'get',
    params: {
      name: name
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

export default tagApi;

