<template>
  <div>
    <card>
      <Input clearable placeholder="广告名" v-model="query.name" style="width: 200px;" />
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">查询</Button>
      <Button type="primary" icon="ios-add" @click="toAddModel" style="margin-left: 10px">添加</Button>
    </card>

    <card>
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        广告管理
      </p>
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection"></Table>
      <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
            v-show="table.operation.success"></Page>
    </card>


    <card v-if="!table.operation.success">
      {{table.operation.message}}
    </card>

    <advertisement-edit :id="modal.id" :title="modal.title" :show-modal="modal.showModal" @updateShowModal="(val) => {modal.showModal = val}" @success="search"></advertisement-edit>
  </div>
</template>
<script>
  import advertisementApi from '@/api/advertisement'
  import AdvertisementEdit from "./edit";

  export default {
    components: {AdvertisementEdit},
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
            {title: 'id', key: 'id'},
            {title: '名称', key: 'name'},
            {title: '类型', key: 'type'},
            {title: '位置', key: 'location'},
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

        let self = this;
        self.table.loading = true;
        advertisementApi.commonRequest(this.query).then(function (res) {
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
            advertisementApi.delete(id).then(function (res) {
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
        this.modal.title = '添加广告'
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
