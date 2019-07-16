<template>
  <div>
    <card>
      <Input clearable placeholder="模版名" v-model="query.name" style="width: 200px;" />
      <Input clearable placeholder="模版码" v-model="query.code" style="width: 200px;margin-left: 10px" />
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">查询</Button>
      <Button type="primary" icon="ios-add" @click="toAddModel" style="margin-left: 10px">添加</Button>
    </card>

    <card>
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        所有模版
      </p>
      <Row v-if="table.data != null" :gutter="16">
        <Col span="8" v-for="template in table.data" style="margin-bottom: 10px">
          <Card>
            <p slot="title">
              <Icon type="ios-film-outline"></Icon>
              {{template.name}}
            </p>
            <div style="text-align:center">
              <img :src="template.frontCover" style="width: 200px;height:200px;">
              <h3>{{template.description}}</h3>
              <div>
                <Button type="primary" icon="ios-brush-outline" @click="toEditModel(template)" style="margin-left: 10px">修改</Button>
                <Button type="info" style="margin-left: 10px" icon="ios-settings-outline" @click="handleEditContent(template)">
                  页面内容
                </Button>
                <Button type="success" icon="ios-eye-outline" @click="toViewModel(template)" style="margin-left: 10px">预览</Button>
                <Button type="error" icon="ios-trash-outline" @click="handleDelete(template.id)" style="margin-left: 10px">删除</Button>
              </div>
            </div>
          </Card>
        </Col>
      </Row>
      <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
            v-show="table.operation.success"></Page>
    </card>


    <card v-if="!table.operation.success">
      {{table.operation.message}}
    </card>

    <Modal v-model="viewModal.showViewModal" :mask-closable="false" :title="viewModal.title" width="100">
      <h1>主图</h1>
      <img :src="viewModal.frontCover" style="max-width: 100%" />
      <h2>其他效果图</h2>
      <img v-if="showImages" v-for="img in viewModal.images" :src="img" />
    </Modal>

    <template-edit :id="modal.id" :title="modal.title" :show-modal="modal.showModal" @updateShowModal="(val) => {modal.showModal = val}" @success="search"></template-edit>
    <edit-page-content :id="pageContentModal.id" :title="pageContentModal.title" :show-modal="pageContentModal.showModal" @updateShowModal="(val) => {pageContentModal.showModal = val}" @success="search"></edit-page-content>

  </div>
</template>
<script>
  import templateApi from '@/api/template'
  import TemplateEdit from "./edit";
  import EditPageContent from "./editPageContent";

  export default {
    components: {EditPageContent, TemplateEdit},
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
          code: '',
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
          id: 0,
        },
        pageContentModal:{
          title: '',
          showModal: false,
          id: 0,
        },
        viewModal:{
          showViewModal: false,
          title:'',
          frontCover: '',
          images: []
        }

      }
    },
    computed:{
      showImages(){
        if(this.viewModal.images == null || this.viewModal.images.length <= 0){
          return false;
        }
        return true;
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
        templateApi.commonRequest(this.query).then(function (res) {
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


      handleDelete (id) {
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            templateApi.delete(id).then(function (res) {
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
        this.modal.title = null
        this.modal.showModal = true
        this.modal.id = 0
      },
      toViewModel(template){
        this.viewModal.showViewModal = true
        this.viewModal.title = template.name
        this.viewModal.frontCover = template.frontCover
        this.viewModal.images = (template.images == null || template.images == '') ? [] : template.images.split(',')
      },
      toEditModel(template) {
        this.modal.title = template.name
        this.modal.showModal = true
        this.modal.id = template.id
      },

      pageChange(pageNum){
        this.query.pageNumber = pageNum;
        this.search();
      },
      pageSizeChange(pageSize){
        this.query.pageSize = pageSize;
        this.search();
      },
      handleEditContent(template){
        this.pageContentModal.title = template.name
        this.pageContentModal.showModal = true
        this.pageContentModal.id = template.id
      }
    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
