import axios from '@/libs/api.request'

let statisticsApi = {};

statisticsApi.count = function(){
  return axios.request({
    url: 'cms/statistics/count',
    method: 'get'
  });
}

export default statisticsApi;

