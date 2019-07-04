<template>
  <div>

    <Dropdown trigger="click" @on-click="selectSite">

      <a href="javascript:void(0)">
        {{ title }}
        <Icon :size="18" type="md-arrow-dropdown" />
      </a>
      <DropdownMenu slot="list">
        <DropdownItem v-for="site in siteList" :name="site.id" :key="site.id">{{ site.domain }}</DropdownItem>
      </DropdownMenu>
    </Dropdown>
    <Button type="text" @click="loadSites">
      <Icon type="ios-refresh" title="刷新站点" @click="loadSites" :size="23" />
    </Button>

  </div>
</template>

<script>
  import siteApi from '@/api/site'
  import { getToken,getUserId } from '@/libs/util'
  export default {
    name: "change-site",
    props: {
      siteId: String
    },
    data () {
      return {
        siteList: []
      }
    },
    watch: {
      // siteId (siteId) {
      //   this.$i18n.locale = lang
      // }
    },
    computed: {
      title () {
        let fullTitle = '选择站点'
        if(this.siteId != null && this.siteId != ''){
          let sid = parseInt(this.siteId)
          this.siteList.forEach(function(item, index, arr) {
            if(item.id == sid){
              fullTitle = '当前站点：' + item.domain
            }
          });
        }

        return fullTitle
      }
    },
    mounted() {
      this.loadSites()
    },

    methods: {
      selectSite (name) {
        this.$emit('on-site-change', name + '')
      },
      loadSites(){
        let userId = getUserId();
        if(userId != null && userId > 0){
          let self = this;
          siteApi.getByUserId(userId).then(function (res) {
            let result = res.data;
            if(result.success){
              self.siteList = result.data == null ? [] : result.data;
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        }
      }
    }
  }
</script>

<style scoped>

</style>
