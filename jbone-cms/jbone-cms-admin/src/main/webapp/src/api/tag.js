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

tagApi.commonRequest = function(condition){

  console.info(condition);

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
  console.info("tag:" + tag);
  console.info(tag);
  return axios.request({
    url: 'cms/tag/addOrUpdate',
    method: 'post',
    data: tag
  });
}

export default tagApi;

