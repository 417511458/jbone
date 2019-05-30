import axios from '@/libs/api.request'
import { getUserId } from '@/libs/util'

let dictionaryApi = {};

dictionaryApi.requestGroup = function(condition){
  return axios.request({
    url: 'cms/dictionary/requestGroup',
    method: 'post',
    data: condition
  });
}

dictionaryApi.getGroup = function(id){
  return axios.request({
    url: 'cms/dictionary/getGroup',
    method: 'get',
    params: {
      id: id
    }
  });
}

dictionaryApi.addOrUpdateGroup = function(group){
  group.creator = getUserId();
  return axios.request({
    url: 'cms/dictionary/addOrUpdateGroup',
    method: 'post',
    data: group
  });
}

dictionaryApi.deleteGroup = function(id){
  return axios.request({
    url: 'cms/dictionary/deleteGroup',
    method: 'delete',
    params: {
      id: id
    }
  });
}



dictionaryApi.getItem = function(id){
  return axios.request({
    url: 'cms/dictionary/getItem',
    method: 'get',
    params: {
      id: id
    }
  });
}

dictionaryApi.getItems = function(groupId){
  return axios.request({
    url: 'cms/dictionary/getItems',
    method: 'get',
    params: {
      groupId: groupId
    }
  });
}

dictionaryApi.getItemsByCode = function(code){
  return axios.request({
    url: 'cms/dictionary/getItemsByCode',
    method: 'get',
    params: {
      code: code
    }
  });
}

dictionaryApi.addOrUpdateItem = function(item){
  item.creator = getUserId();
  return axios.request({
    url: 'cms/dictionary/addOrUpdateItem',
    method: 'post',
    data: item
  });
}

dictionaryApi.deleteItem = function(id){
  return axios.request({
    url: 'cms/dictionary/deleteItem',
    method: 'delete',
    params: {
      id: id
    }
  });
}


export default dictionaryApi;

