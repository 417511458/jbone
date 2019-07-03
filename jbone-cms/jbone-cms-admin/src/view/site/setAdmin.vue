<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle" width="630">

    <card>
      <i-input v-model="searchUserCondition.username" clearable placeholder="管理员用户名" style="width: 250px"></i-input>
      <Button type="primary" icon="ios-search" :loading="loading" @click="loadSiteAdmins" style="margin-left: 10px">查询管理员</Button>
    </card>
    <div class="drag-box-card">
      <!-- 切记设置list1和list2属性时，一定要添加.sync修饰符 -->
      <drag-list :list1.sync="data.userList" :list2.sync="data.selectedUserList" :dropConClass="dropConClass" @on-change="handleDragChange">
        <h3 slot="left-title">所有管理员</h3>
        <Card class="drag-item" slot="left" slot-scope="left">{{ left.itemLeft.baseInfo.username }}</Card>
        <h3 slot="right-title">已选中管理员</h3>
        <Card class="drag-item" slot="right" slot-scope="right">{{ right.itemRight.baseInfo.username }}</Card>
      </drag-list>
    </div>
    <Page :total="searchUserCondition.totalRecord" show-total :pageSize="searchUserCondition.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"></Page>

    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import siteAdminApi from '@/api/siteAdmin'
  import DragList from '_c/drag-list'
  import {searchUsers} from '@/api/user'

    export default {
      name: "setAdmin",
      components: {DragList},
      props:{
        siteId: {
          type:Number,
          default: 0
        },
        title: String,
        showModal: {
          type: Boolean,
          default: false
        },
      },
      data() {

        return {
          searchUserCondition: {
            roleName: 'siteAdmin',
            pageSize: 100,
            pageNumber: 1,
            totalRecord: 0,
            username: ''

          },
          showEditModal: false,
          data: {
            userList:[],
            selectedUserList:[],
          },
          loading: false,
          dropConClass: {
            left: ['drop-box', 'left-drop-box'],
            right: ['drop-box', 'right-drop-box']
          },
        };
      },
      computed:{
        fullTitle(){
          return '设置站点管理员[' + this.title + ']'
        }
      },
      watch:{
        showModal(val){
          this.showEditModal = val
        },
        showEditModal(val) {
          this.$emit('updateShowModal', val);
          if(val){
            this.init();
          }
        },
      },
      methods:{
        init(){
          this.loadData()
        },
        loadData() {
          this.data.userList = []
          this.data.selectedUserList = []
          this.searchUserCondition.username = ''
          this.loadSiteAdmins()
          this.loadCurrentSiteAdmins()

        },

        loadSiteAdmins(){
          this.loading = true;
          let self = this;
          searchUsers(this.searchUserCondition).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.userList = result.data.datas == null ? [] : result.data.datas;
              self.searchUserCondition.pageSize = result.data.pageSize;
              self.searchUserCondition.pageNumber = result.data.pageNum;
              self.searchUserCondition.totalRecord = result.data.total;
              self.filterDrapDatas();
            }else{
              self.$Message.error(result.status.message);
            }
            self.loading = false;
          }).catch(function (error) {
            self.$Message.error(error.message);
            self.loading = false;
          });
        },

        loadCurrentSiteAdmins(){
          let self = this;
          siteAdminApi.getBySiteId(this.siteId).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.selectedUserList = result.data == null ? [] : result.data;
              self.filterDrapDatas();
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        //过滤已选中的标签
        filterDrapDatas(){
          let self = this;
          self.data.userList = self.data.userList.filter(function(item) {
            let itemResult = true;
            self.data.selectedUserList.forEach(function(sitem, index, arr) {
              if(sitem.baseInfo.id == item.baseInfo.id){
                itemResult = false;
              }
            });
            return itemResult;
          });

        },

        pageChange(pageNum){
          this.searchUserCondition.pageNumber = pageNum;
          this.loadSiteAdmins();
        },
        pageSizeChange(pageSize){
          this.searchUserCondition.pageSize = pageSize;
          this.loadSiteAdmins();
        },

        addOrUpdate() {
          this.loading = true;
          let self = this;
          let userIds = []
          if(this.data.selectedUserList != null){
            this.data.selectedUserList.forEach(function(item, index, arr) {
              userIds.push(item.baseInfo.id)
            });
          }
          siteAdminApi.addOrUpdate(self.siteId,userIds).then(function (res) {
            let result = res.data;
            if (result.success) {
              self.$Message.info("操作成功");
              self.$emit('success');
            } else {
              self.$Message.error(result.status.message);
            }
            self.loading = false;
          }).catch(function (error) {
            self.$Message.error(error.message);
            self.loading = false;
          });
        },

        handleDragChange({ src, target, oldIndex, newIndex }){
          console.info(src);
          console.info(target);
          console.info(oldIndex);
          console.info(newIndex);
        }
      }
    }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
  .drag-list-wrapper .drag-list-con {
    overflow-y: scroll;
  }
  .drag-box-card{
    display: inline-block;
    width: 600px;
    height: 560px;
    .drag-item{
      margin: 10px;
    }
    h3{
      padding: 10px 15px;
    }
    .drop-box{
      border: 1px solid #eeeeee;
      height: 455px;
      border-radius: 5px;
    }
    .left-drop-box{
      margin-right: 10px;
    }
    .right-drop-box{
      //
    }
  }
</style>
