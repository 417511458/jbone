<template>
  <div>
    <card>
      <Input clearable placeholder="标签名" v-model="query.name" style="width: 200px;" />
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">查询</Button>
      <Button type="primary" icon="ios-add" @click="toAddModel" style="margin-left: 10px">添加</Button>
    </card>

    <card>
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        所有标签
      </p>
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection"></Table>
      <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
            v-show="table.operation.success"></Page>
    </card>


    <card v-if="!table.operation.success">
      {{table.operation.message}}
    </card>

    <tag-edit :id="modal.id" :title="modal.title" :show-modal="modal.showModal" @updateShowModal="(val) => {modal.showModal = val}" @success="search"></tag-edit>

  </div>
</template>
<script>
  import tagApi from '@/api/tag'
  import Input from "iview/src/components/input/input";
  import TagEdit from "./edit";
  import siteApi from '@/api/site'

  export default {
    components: {TagEdit, Input},
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
          totalRecord: 0,
          pageSize: 10,
          pageNumber: 1,
          includeArticleCount: true
        },
        table: {
          columns: [
            {
              type: 'selection',
              width: 60,
              align: 'center'
            },
            {title: '标签ID', key: 'id'},
            {title: '标签名', key: 'name'},
            {title: '文章数量', key: 'articleCount'},
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
                        this.handleDeleteOnTable(params.index);
                      }
                    }
                  }, '删除')
                ]);
              }
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
          id: 0,
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
      search() {
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }
        let self = this;
        self.table.loading = true;
        tagApi.commonRequest(this.query).then(function (res) {
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
            tagApi.delete(id).then(function (res) {
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
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }

        this.modal.title = '添加标签'
        this.modal.showModal = true
        this.modal.id = 0
      },

      toEditModel(index) {
        this.modal.title = this.table.data[index].name
        this.modal.showModal = true
        this.modal.id = this.table.data[index].id
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
