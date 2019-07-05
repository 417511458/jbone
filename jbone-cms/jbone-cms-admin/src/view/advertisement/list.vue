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
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection">
        <template slot="type" slot-scope="{ row, index }">
          <span v-if="row.typeDetail" v-text="row.typeDetail.name"></span>
          <span v-else v-text="row.type"></span>
        </template>
        <template slot="location" slot-scope="{ row, index }">
          <span v-if="row.locationDetail" v-text="row.locationDetail.name"></span>
          <span v-else v-text="row.location"></span>
        </template>

        <template slot="enable" slot-scope="{ row, index }">
          <Button v-if="row.enable == 1" type="success">可用</Button>
          <Button v-if="row.enable == 0" type="dashed">不可用</Button>
        </template>
      </Table>
      <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
            v-show="table.operation.success"></Page>
    </card>


    <card v-if="!table.operation.success">
      {{table.operation.message}}
    </card>

    <advertisement-edit :id="modal.id" :title="modal.title" :show-modal="modal.showModal" @updateShowModal="(val) => {modal.showModal = val}" @success="search"></advertisement-edit>
    <Modal v-model="showPreview"  :mask-closable="false" title="广告预览">
        <div v-if="previewData.type == 'img'">
          <img :src="previewData.img" style="max-width: 200px" />
        </div>
        <div v-if="previewData.type == 'text'">
          <span v-text="previewData.text"></span>
        </div>
        <div v-if="previewData.type == 'imgAndText'">
          <img :src="previewData.img" style="max-width: 200px;" />
          <span v-text="previewData.text"></span>
        </div>
        <span v-if="previewData.type == 'code'" v-html="previewData.content"></span>
    </Modal>
  </div>
</template>
<script>
  import advertisementApi from '@/api/advertisement'
  import siteApi from '@/api/site'
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
            {title: '名称', key: 'name'},
            {
              title: '广告类型',
              type: 'template',
              slot: 'type'
            },
            {
              title: '位置',
              type: 'template',
              slot: 'location'
            },
            {
              title: '状态',
              type: 'template',
              slot: 'enable'
            },
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
                        this.toPreview(params.index);
                      }
                    }
                  }, '预览'),
                  h('Button', {
                    props: {
                      type: 'success',
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
        previewData:{},
        showPreview: false,
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
      toPreview(index){
        this.showPreview = true
        this.previewData = this.table.data[index]
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
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }

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
