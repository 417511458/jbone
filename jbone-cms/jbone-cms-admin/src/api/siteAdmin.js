import axios from '@/libs/api.request'

let siteAdminApi = {};


siteAdminApi.getBySiteId = function(siteId){
  return axios.request({
    url: 'cms/siteAdmin/getBySiteId',
    method: 'get',
    params: {
      siteId: siteId
    }
  });
}


siteAdminApi.addOrUpdate = function(siteId,userIds){
  let data = {siteId:siteId,userIds:userIds}
  return axios.request({
    url: 'cms/siteAdmin/addOrUpdate',
    method: 'post',
    data: data
  });
}

export default siteAdminApi;

