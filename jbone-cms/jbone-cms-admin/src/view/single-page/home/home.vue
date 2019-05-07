<template>
  <div>
    <Row :gutter="20">
      <i-col :xs="12" :md="8" :lg="4" v-for="(infor, i) in inforCardData" :key="`infor-${i}`" style="height: 120px;padding-bottom: 10px;">
        <infor-card shadow :color="infor.color" :icon="infor.icon" :icon-size="36">
          <count-to :end="infor.count" count-class="count-style"/>
          <p>{{ infor.title }}</p>
        </infor-card>
      </i-col>
    </Row>
    <br>
    <br>
    <Row :gutter="20">
      <i-col span="12">
        <Card title="jbone交流群(547104190)" shadow>
          <img class="qq-group-img" :src="qqFans" alt="">
          <p class="qq-group-intro">本群为jbone交流群，知识分享，共同进步。</p>
        </Card>
      </i-col>
      <i-col span="12">
        <Card title="项目地址" shadow>
          <a href="https://github.com/417511458/jbone" target="_blank"><h1>Github</h1></a>
          <a href="https://gitee.com/majunwei2017/jbone" target="_blank"><h1>码云</h1></a>
          <a href="http://www.jbone.cn" target="_blank"><h1>Jbone官网</h1></a>
        </Card>
      </i-col>
    </Row>
  </div>
</template>

<script>
import InforCard from '_c/info-card'
import CountTo from '_c/count-to'
import { ChartPie, ChartBar } from '_c/charts'
import Example from './example.vue'
import statisticsApi from '@/api/statistics'
import qqFans from '@/assets/images/qq-group.png'

export default {
  name: 'home',
  components: {
    InforCard,
    CountTo,
    ChartPie,
    ChartBar,
    Example
  },
  data () {
    return {
      inforCardData: [
        { title: '文章数', icon: 'md-person-add', count: 0, color: '#2d8cf0' },
        { title: '累计点击', icon: 'md-locate', count: 0, color: '#19be6b' },
        { title: '栏目数', icon: 'md-help-circle', count: 0, color: '#ff9900' },
        { title: '专题数', icon: 'md-share', count: 0, color: '#ed3f14' },
        { title: '标签数', icon: 'md-chatbubbles', count: 0, color: '#E46CBB' },
        { title: '友链数', icon: 'md-map', count: 0, color: '#9A66E4' }
      ],
      qqFans: qqFans
    }
  },
  mounted () {
    //
  },
  created() {
    this.init();
  },
  methods: {
    init(){
      let self = this;
      statisticsApi.count().then(function (res) {
        if (!res.data.success) {
          console.info("获取统计信息失败" + res.data.status.message);
        } else {
          let result = res.data.data;
          self.inforCardData.forEach((item, index) => {
            if (item.title == '文章数') {
              item.count = result.articleCount;
            }else if(item.title == '累计点击'){
              item.count = result.hitsCount;
            }else if(item.title == '栏目数'){
              item.count = result.categoryCount;
            }else if(item.title == '专题数'){
              item.count = result.specialCount;
            }else if(item.title == '标签数'){
              item.count = result.tagCount;
            }else if(item.title == '友链数'){
              item.count = result.linkCount;
            }
          })
        }
      }).catch(function (error) {
        console.info("获取统计信息失败" + error.message);
      });
    }
  }
}
</script>
<style lang="less">
.count-style{
  font-size: 50px;
}

.qq-group-img{
  display: block;
  margin: 0 auto;
  width: 240px;
}
.qq-group-intro{
  padding: 20px;
  font-size: 16px;
}
</style>
