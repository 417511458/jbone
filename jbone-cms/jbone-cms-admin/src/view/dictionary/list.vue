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
                <Button type="warning" icon="ios-backspace-outline" @click="deleteItems(group.id)" style="margin-left: 10px;">删除字典项</Button>
                <Button type="error" icon="ios-backspace-outline" @click="deleteGroup(group.id)" style="margin-left: 10px;">删除本字典</Button>
              </div>
              <Table v-if="group.items && group.items.length > 0"  :loading="table.loading" :columns="table.columns" :data="group.items" stripe border ref="selection"></Table>
              <Alert v-else>暂无字典项，请添加！</Alert>
            </div>
          </Panel>
        </Collapse>
        <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
              v-show="table.operation.success"></Page>
      </card>
  </div>
</template>
<script>
  import dictionaryApi from '@/api/dictionary'

  export default {
    data() {
      return {
        query: {
          code: '',
          name: '',
          totalRecord: 0,
          pageSize: 5,
          pageNumber: 1
        },
        groups:[],
        table: {
          loading: false,
          columns: [
            {
              type: 'selection',
              width: 60,
              align: 'center'
            },
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
                        this.toEditModel(params.index);
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
        loading: false
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

      },
      deleteGroup(groupId){
        console.info(groupId)
      },
      deleteItems(groupId){
        console.info(groupId)
      },
      toAddItem(groupId){
        console.info(groupId)
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
