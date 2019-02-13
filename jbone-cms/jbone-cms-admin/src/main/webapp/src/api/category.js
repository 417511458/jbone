import axios from '@/libs/api.request'

let categoryApi = {};

categoryApi.getCategoryTree = function(){
  return axios.request({
    url: 'cms/category/getCategoryTree',
    method: 'get'
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
  console.info("cate:" + cate);
  console.info(cate);
  return axios.request({
    url: 'cms/category/addOrUpdate',
    method: 'post',
    data: cate
  });
}

categoryApi.delete = function(id){
  console.info("delete category :" + id);
  return axios.request({
    url: 'cms/category/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

categoryApi.batchDelete = function (ids) {
  return axios.request({
    url: 'cms/category/batchDelete',
    method: 'delete',
    params: {
      ids: ids
    }
  });
}

export default categoryApi;

