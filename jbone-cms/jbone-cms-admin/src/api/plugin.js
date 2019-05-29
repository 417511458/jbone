import axios from '@/libs/api.request'

let pluginApi = {};

pluginApi.getAll = function(){
  return axios.request({
    url: 'cms/plugin/getAll',
    method: 'get'
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

