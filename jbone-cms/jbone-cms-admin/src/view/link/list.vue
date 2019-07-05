<template>
  <div>
    <card>
      <Button type="primary" icon="ios-add" @click="toAddModel">添加</Button>
      <Button type="primary" icon="ios-backspace-outline" @click="handleBatchDelete" style="margin-left: 10px">批量删除</Button>
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">刷新</Button>
    </card>

    <card v-if="table.operation.success">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        友情链接
      </p>
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection" @on-delete="handleDelete"></Table>
    </card>
    <card v-else>
      {{table.operation.message}}
    </card>

    <edit-link :id="editModal.id" :show-modal="editModal.showModal" :title="editModal.title" @success="search" @updateShowModal="(val) => {editModal.showModal = val}"></edit-link>
  </div>
</template>
<script>
  import linkApi from '@/api/link'
  import EditLink from "./edit";
  import siteApi from '@/api/site'

  export default {
    components: {EditLink},
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

        query: {title: '', url: ''},
        table: {
          loading: false,
          columns: [
            {
              type: 'selection',
              width: 60,
              align: 'center'
            },
            {title: '链接ID', key: 'id'},
            {title: '链接名', key: 'title'},
            {title: 'URL', key: 'url'},
            {title: '说明', key: 'description'},
            {title: '排序号', key: 'orders'},
            {
              title: '操作',
              key: 'handle',
              render: (h, params) => {
                return h('div', [
                  h('Button', {
                    props: {
                      type: 'primary',
                      size: 'small'
                    },
                    style: {
                      marginRight: '5px'
                    },
                    on: {
                      click: () => {
                        this.toEditModel(params.index);
                      }
                    }
                  }, '修改'),
                  h('Button', {
                    props: {
                      type: 'error',
                      size: 'small'
                    },
                    on: {
                      click: () => {
                        this.handleDelete(params.index);
                      }
                    }
                  }, '删除')
                ]);
              }
            }
          ],
          data: [],
          operation: {
            success: true,
            message: ""
          }
        },
        totalRecord: 0,
        pageSize: 15,
        pageNum: 1,
        editModelTitle: '',

        editModal: {
          id: 0,
          title: '',
          showModal: false,
        },

        loading: false
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
      search() {

        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }

        this.table.loading = true;
        let self = this;
        linkApi.getAll().then(function (res) {
          console.info(res);
          self.table.loading = false;
          if (!res.data.success) {
            self.setTableMessage(res.data.status.message);
          } else {
            self.table.data = res.data.data;
          }
        }).catch(function (error) {
          self.setTableMessage(error.message);
        });
      },

      toAddModel() {

        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }

        this.editModal.id = 0
        this.editModal.title = '添加友情链接'
        this.editModal.showModal = true
      },

      toEditModel(index) {
        this.editModal.id = this.table.data[index].id
        this.editModal.title = this.table.data[index].title
        this.editModal.showModal = true
      },
      setTableMessage(message) {
        this.table.operation.success = false;
        this.table.operation.message = message;
      },
      handleDelete (index) {
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            linkApi.delete(this.table.data[index].id).then(function (res) {
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
      handleBatchDelete(){
        let self = this;
        let selectedData = this.$refs.selection.getSelection();
        if(selectedData == null || selectedData.length <= 0){
          this.$Message.error("请选中要删除的数据");
          return;
        }
        let ids = '';
        selectedData.forEach(currentData => {
          ids = ids + currentData.id + ',';
        });
        this.$Modal.confirm({
          title: '确定要删除这些记录吗？',
          onOk: () => {
            linkApi.batchDelete(ids).then(function (res) {
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
    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
