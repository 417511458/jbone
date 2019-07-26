<template>
  <div>
    <card>
      <Button type="primary" icon="ios-add" @click="toAddModel(0)">添加</Button>
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">刷新</Button>
    </card>

    <card v-if="table.operation.success">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        所有栏目
      </p>
      <tree-table expand-key="title" :show-index="true" :expand-type="false" :selectable="false" :columns="table.columns" :data="table.data" >
        <template slot="handle" slot-scope="scope">
          <Button @click="toEditModel(scope.row.id,scope.row.title)" type="primary" size="small">编辑</Button>
          <Button @click="toAddModel(scope.row.id)" type="primary" size="small" style="margin-left: 5px">添加下级栏目</Button>
          <Button @click="handleDelete(scope.row.id)" type="error" size="small" style="margin-left: 5px">删除</Button>
          <Button @click="handleEditSpecial(scope.row.id,scope.row.title)" type="error" size="small" style="margin-left: 5px" v-if="scope.row.type == 'SPECIAL'">编辑专题</Button>
          <Button @click="handleEditTag(scope.row.id,scope.row.title)" type="error" size="small" style="margin-left: 5px" v-if="scope.row.type == 'TAG'">编辑标签</Button>
        </template>
        <template slot="type" slot-scope="scope">
          <span v-if="scope.row.type == 'CATEGORY'">普通栏目</span>
          <span v-if="scope.row.type == 'TAG'">标签聚合栏目</span>
          <span v-if="scope.row.type == 'SPECIAL'">专题栏目</span>
          <span v-if="scope.row.type == 'IMG'">图片栏目</span>
          <span v-if="scope.row.type == 'NEWS'">新闻栏目</span>
          <span v-if="scope.row.type == 'PRODUCT'">产品栏目</span>
        </template>
      </tree-table>
    </card>
    <card v-else>
      {{table.operation.message}}
    </card>


    <edit-special :category-id="specialModal.id"  :title="specialModal.title" :show-modal="specialModal.showModal" @updateShowModal="(val) => {specialModal.showModal = val}"></edit-special>
    <categoryedit :id="editModal.id" :pid="editModal.pid"  :title="editModal.title" :show-modal="editModal.showModal" @updateShowModal="(val) => {editModal.showModal = val}" @success="search"></categoryedit>
    <edit-tag :id="tagModal.id" :title="tagModal.title" :show-modal="tagModal.showModal" @updateShowModal="(val) => {tagModal.showModal = val}"></edit-tag>


  </div>
</template>
<script>
  import Tree from "iview/src/components/tree/tree"
  import categoryApi from '@/api/category'
  import InputNumber from "iview/src/components/input-number/input-number";
  import DragList from '_c/drag-list'
  import EditTag from "./editTag";
  import Categoryedit from "./edit";
  import EditSpecial from "./editSpecial";
  import siteApi from '@/api/site'

  export default {
    components: {EditSpecial, Categoryedit, EditTag, InputNumber,Tree,DragList},
    data() {
      return {

        table: {
          loading: false,
          columns: [
            {
              title: '栏目标题',
              key: 'title',
            },
            {
              title: '栏目编码',
              key: 'code',
            },
            {
              title: '关键字',
              key: 'keywords',
            },
            {
              title: '栏目类型',
              // key: 'type',
              minWidth: '200px',
              type: 'template',
              template: 'type'
            },
            {
              title: '排序号',
              key: 'orders',
            },
            {
              title: '操作',
              minWidth: '200px',
              type: 'template',
              template: 'handle'
            }
          ],
          data: [],
          operation: {
            success: true,
            message: ""
          }
        },

        //专题模版
        specialModal: {
          id: 0,
          title: '编辑专题',
          showModal: false
        },
        //标签栏目
        tagModal:{
          id: 0,
          title: '编辑标签',
          showModal: false
        },
        //编辑栏目
        editModal:{
          id: 0,
          pid: 0,
          title: '编辑标签',
          showModal: false
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
        categoryApi.getCategoryTree().then(function (res) {
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

      toAddModel(pid) {
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }

        this.editModal.id = 0
        this.editModal.pid = pid
        this.editModal.title = '添加栏目'
        this.editModal.showModal = true
      },

      toEditModel(id,title) {
        this.editModal.id = id
        this.editModal.title = title
        this.editModal.showModal = true
      },

      setTableMessage(message) {
        this.table.operation.success = false;
        this.table.operation.message = message;
      },
      handleDelete (id) {
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            console.log("delele ok.");
            console.log("id:" + id);
            categoryApi.delete(id).then(function (res) {
              let result = res.data;
              if(result.success){
                self.$Message.info('删除成功');
                self.search();
              }else {
                self.$Message.error('删除失败!' + result.status.message);
              }
            });
          }
        });

      },

      handleEditSpecial(id,title){
        this.specialModal.id = id;
        this.specialModal.title = title;
        this.specialModal.showModal = true;
      },

      handleEditTag(id,title){
        this.tagModal.showModal = true;
        this.tagModal.id = id;
        this.tagModal.title = title;
      },

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
