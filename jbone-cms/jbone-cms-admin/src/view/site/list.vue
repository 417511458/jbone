<template>
  <div>
    <card>
      <Input clearable placeholder="站点名" v-model="query.name" style="width: 200px;" />
      <Input clearable placeholder="域名" v-model="query.domain" style="width: 200px;margin-left: 10px" />
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">查询</Button>
      <Button type="primary" icon="ios-add" @click="toAddModel" style="margin-left: 10px">添加</Button>
    </card>

    <card>
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        所有站点
      </p>
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection">
        <template slot="enable" slot-scope="{ row, index }">
          <Button v-if="row.enable == 1" type="success">可用</Button>
          <Button v-if="row.enable == 0" type="dashed">不可用</Button>
          <Button v-if="row.enable == -1" type="dashed" disabled>已删除</Button>
        </template>
        <template slot="handle" slot-scope="{ row, index }">
          <Button @click="toEditModel(index)" type="primary" size="small">编辑</Button>
          <Button @click="toSetContentModel(index)" type="success" size="small" style="margin-left: 5px">配额</Button>
          <Button @click="toSetAdmin(index)" type="success" size="small" style="margin-left: 5px">管理员</Button>
          <Button @click="handleDeleteOnTable(index)" type="error" size="small" style="margin-left: 5px">删除</Button>
        </template>
      </Table>
      <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
            v-show="table.operation.success"></Page>
    </card>


    <card v-if="!table.operation.success">
      {{table.operation.message}}
    </card>

    <set-content-limit :siteId="modal.siteId" :title="modal.title" :show-modal="modal.showModal" @updateShowModal="(val) => {modal.showModal = val}" @success="search"></set-content-limit>

    <set-admin :siteId="adminModal.siteId" :title="adminModal.title" :show-modal="adminModal.showModal" @updateShowModal="(val) => {adminModal.showModal = val}" @success="search"></set-admin>
  </div>
</template>
<script>
  import siteApi from '@/api/site'
  import Input from "iview/src/components/input/input";
  import SiteEdit from "./edit";
  import { mapMutations } from 'vuex'
  import SetContentLimit from "./setContentLimit";
  import SetAdmin from "./setAdmin";

  export default {
    components: {SetAdmin, SetContentLimit, SiteEdit, Input},
    data() {

      const validateName = (rule, value, callback) => {
        if (value) {
          var pattern = new RegExp("[~'!@#￥$%^&*()-+=:?><{}]");
          if (pattern.test(value)) {
            return callback(new Error('不允许含有特殊字符'));
          }
          callback();
        } else {
          callback();
        }
      };

      return {

        query: {
          name: '',
          domain: '',
          totalRecord: 0,
          pageSize: 10,
          pageNumber: 1
        },
        table: {
          columns: [
            {
              type: 'selection',
              width: 60,
              align: 'center'
            },
            {title: 'ID', key: 'id'},
            {title: '站点名', key: 'name'},
            {title: '站点域名', key: 'domain'},
            {
              title: '状态',
              type: 'template',
              slot: 'enable'
            },
            {
              title: '操作',
              type: 'template',
              slot: 'handle'
            }
          ],
          loading: false,
          data:[],
          operation:{
            success: false,
            message: ''
          }
        },
        loading: false,
        modal:{
          title: '',
          showModal: false,
          siteId: 0,
        },

        adminModal:{
          title: '',
          showModal: false,
          siteId: 0,
        },

      }
    },
    created() {
      this.init();
    },
    methods: {
      init() {
        // 加载表格数据
        this.search();
      },

      ...mapMutations([
        'closeTag'
      ]),
      search() {

        let self = this;
        self.table.loading = true;
        siteApi.commonRequest(this.query).then(function (res) {
          self.table.loading = false;
          if (!res.data.success) {
            self.table.operation.success = false;
            self.table.operation.message = res.data.status.message;
          } else {
            self.table.operation.success = true
            self.table.data = res.data.data.datas;
            self.query.totalRecord = res.data.data.total;
            self.query.pageSize = res.data.data.pageSize;
            self.query.pageNumber = res.data.data.pageNum;
          }
        }).catch(function (error) {
          self.table.loading = false;
        });
      },

      handleDeleteOnTable (index) {
        this.handleDelete(this.table.data[index].id);
      },

      handleDelete (id) {
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            siteApi.delete(id).then(function (res) {
              let result = res.data;
              if(result.success){
                self.$Message.info('删除成功');
                self.search();
              }else {
                self.$Message.error('删除失败');
              }
            });
          }
        });
      },

      toAddModel() {
        this.closeTag({
          name: 'site_edit'
        })
        this.$router.push({ path: '/base/site/edit'})
      },

      toEditModel(index) {
        this.$router.push({ path: '/base/site/edit', query: { id:this.table.data[index].id }})
      },

      toSetAdmin(index) {
        this.adminModal.title = this.table.data[index].name + '(' + this.table.data[index].domain + ')'
        this.adminModal.showModal = true
        this.adminModal.siteId = this.table.data[index].id
      },

      toSetContentModel(index) {
        this.modal.title = this.table.data[index].name + '(' + this.table.data[index].domain + ')'
        this.modal.showModal = true
        this.modal.siteId = this.table.data[index].id
      },

      pageChange(pageNum){
        this.query.pageNumber = pageNum;
        this.search();
      },
      pageSizeChange(pageSize){
        this.query.pageSize = pageSize;
        this.search();
      },
    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
