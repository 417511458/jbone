<template>
  <div>
      <card :dis-hover="true">
        <p slot="title">
          <Icon type="ios-film-outline"></Icon>
          字典管理
        </p>

        <div style="margin-bottom: 10px;">
          <Input clearable placeholder="字典编码" v-model="query.code" style="width: 250px;" />
          <Input clearable placeholder="字典名字" v-model="query.name" style="width: 250px;margin-left: 10px;" />
          <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px;">查询</Button>
          <Button type="primary" icon="ios-add" @click="toAddGroup" style="margin-left: 10px;">添加字典</Button>
        </div>
        <Collapse accordion>
          <Panel :name="group.name" v-for="group in groups" :title="group.name">
            {{group.name}}
            <div slot="content" >
              <div style="margin-bottom: 10px;">
                <Button type="primary" icon="ios-add" @click="toAddItem(group.id)">添加字典项</Button>
                <Button type="error" icon="ios-backspace-outline" @click="deleteGroup(group.id,group.name)" style="margin-left: 10px;">删除字典</Button>
                <Button type="success" icon="ios-backspace-outline" @click="toEditGroup(group.id,group.name)" style="margin-left: 10px;">修改字典</Button>
              </div>
              <Table v-if="group.items && group.items.length > 0"  :loading="table.loading" :columns="table.columns" :data="group.items" stripe border ref="selection"></Table>
              <Alert v-else>暂无字典项，请添加！</Alert>
            </div>
          </Panel>
        </Collapse>
        <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
              v-show="table.operation.success"></Page>
      </card>

    <edit-dictionary-group :id="editGroupModal.id" :name="editGroupModal.name" :show-modal="editGroupModal.showModal" @success="search" @updateShowModal="(val) => {editGroupModal.showModal = val}"></edit-dictionary-group>
    <edit-dictionary-item  :id="editItemModal.id" :group-id="editItemModal.groupId" :dict-name="editItemModal.dictName" :show-modal="editItemModal.showModal" @success="search" @updateShowModal="(val) => {editItemModal.showModal = val}"></edit-dictionary-item>
  </div>
</template>
<script>
  import dictionaryApi from '@/api/dictionary'
  import EditDictionaryGroup from "./editGroup";
  import EditDictionaryItem from "./editItem";

  export default {
    components: {EditDictionaryItem, EditDictionaryGroup},
    data() {
      return {
        query: {
          code: '',
          name: '',
          totalRecord: 0,
          pageSize: 10,
          pageNumber: 1
        },
        groups:[],
        table: {
          loading: false,
          columns: [
            {title: '字典名', key: 'dictName'},
            {title: '字典值', key: 'dictValue'},
            {title: '提示文本', key: 'dictPrompt'},
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
                        this.toEditItem(params.row.id,params.row.dictName);
                      }
                    }
                  }, '修改'),
                  h('Button', {
                    props: {
                      type: 'warning',
                      size: 'small'
                    },
                    style: {
                      marginRight: '5px'
                    },
                    on: {
                      click: () => {
                        this.toDeleteItem(params.row.id,params.row.dictName);
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
          },
        },
        loading: false,
        editGroupModal: {
          id: 0,
          name: '',
          showModal: false,
        },
        editItemModal: {
          id: 0,
          groupId:0,
          dictName: '',
          showModal: false,
        },
      }
    },
    created() {
      this.init();
    },

    methods: {

      init(){
        // 加载栏目树
        this.search();
      },
      toAddGroup(){
        this.editGroupModal.id = 0
        this.editGroupModal.name = ''
        this.editGroupModal.showModal = true
      },
      toEditGroup(groupId,name){
        this.editGroupModal.id = groupId
        this.editGroupModal.name = name
        this.editGroupModal.showModal = true
      },
      deleteGroup(groupId,name){
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除本字典[' + name + ']吗？',
          onOk: () => {
            dictionaryApi.deleteGroup(groupId).then(function (res) {
              let result = res.data;
              if(result.success){
                self.$Message.info('删除成功');
                self.search();
              }else {
                self.$Message.error('删除失败! ' + result.status.message);
              }
            });
          }
        });
      },
      toDeleteItem(id,dictName){
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除字典项[' + dictName +']吗?',
          onOk: () => {
            dictionaryApi.deleteItem(id).then(function (res) {
              let result = res.data;
              if(result.success){
                self.$Message.info('删除成功');
                self.search();
              }else {
                self.$Message.error('删除失败! ' + result.status.message);
              }
            });
          }
        });
      },
      toAddItem(groupId){
        this.editItemModal.id = 0
        this.editItemModal.groupId = groupId
        this.editItemModal.dictName = ''
        this.editItemModal.showModal = true
      },
      toEditItem(id,name){
        this.editItemModal.id = id
        this.editItemModal.groupId = 0
        this.editItemModal.dictName = name
        this.editItemModal.showModal = true
      },
      search() {
        this.table.loading = true;
        let self = this;
        dictionaryApi.requestGroup(this.query).then(function (res) {
          console.info(res);
          self.table.loading = false;
          if (!res.data.success) {
            self.$Message.warn(res.data.status.message);
          } else {
            self.groups = res.data.data.datas;
            self.query.totalRecord = res.data.data.total;
            self.query.pageSize = res.data.data.pageSize;
            self.query.pageNumber = res.data.data.pageNum;
          }
        }).catch(function (error) {
          self.$Message.warn(error.message);
        });
      },
      pageChange(pageNum){
        this.query.pageNumber = pageNum;
        this.search();
      },
      pageSizeChange(pageSize){
        this.query.pageSize = pageSize;
        this.search();
      }
    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
