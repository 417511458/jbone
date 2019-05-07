import axios from '@/libs/api.request'

let categoryTocApi = {};

categoryTocApi.getCategorys = function(cate){
  return axios.request({
    url: 'cms/category/requestCategorys',
    method: 'post',
    data: cate
  });
}

categoryTocApi.getById = function(id){
  return axios.request({
    url: 'cms/categoryToc/get',
    method: 'get',
    params: {
      id: id
    }
  });
}

categoryTocApi.getTree = function(categoryId){
  return axios.request({
    url: 'cms/categoryToc/getTree',
    method: 'get',
    params: {
      categoryId: categoryId
    }
  });
}

categoryTocApi.addOrUpdate = function(toc){
  console.info("toc:");
  console.info(toc);
  return axios.request({
    url: 'cms/categoryToc/addOrUpdate',
    method: 'post',
    data: toc
  });
}

categoryTocApi.delete = function(id){
  console.info("delete categoryToc :" + id);
  return axios.request({
    url: 'cms/categoryToc/delete',
    method: 'delete',
    params: {
      id: id
    }
  });
}

export default categoryTocApi;

