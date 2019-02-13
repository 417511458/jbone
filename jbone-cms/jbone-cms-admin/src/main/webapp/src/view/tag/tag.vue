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
      <Tabs>
        <TabPane label="列表形式">
          <Table :loading="table.loading" :columns="table.columns" :data="tagcloud.data" stripe border ref="selection"></Table>
        </TabPane>
        <TabPane label="标签形式">
          <Tag v-for="item in tagcloud.data" :key="item" :color="item.color" :name="item" closable @on-close="handleDeleteOnTag">{{ item.name }}({{item.articleCount}})</Tag>
        </TabPane>
      </Tabs>
      <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
            v-show="tagcloud.operation.success"></Page>
    </card>


    <card v-if="!tagcloud.operation.success">
      {{tagcloud.operation.message}}
    </card>

    <Modal :title="title" v-model="modal.showModal" :mask-closable="false">

      <p slot="header">
        <Icon type="ios-information-circle"></Icon>
        <span> {{ modal.title }}</span>
      </p>
      <Form :model="modal.data" :label-width="100" ref="modalForm" :rules="ruleValidate">
        <FormItem label="标签名" prop="name" :required="true">
          <i-input v-model="modal.data.name" clearable placeholder="标签名"></i-input>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="primary" size="large" long :loading="loading" @click="addOrUpdate">保存</Button>
      </div>
    </Modal>

  </div>
</template>
<script>
  import tagApi from '@/api/tag'
  import Input from "iview/src/components/input/input";

  export default {
    components: {Input},
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
          pageNumber: 1
        },
        tagcloud: {
          operation: {
            operation: {
              success: true,
              message: ""
            }
          },
          data:[]
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
          loading: false
        },
        loading: false,
        modal:{
          title: '',
          showModal: false,
          data: {
            id: 0,
            name: ''
          }
        },
        ruleValidate: {
          name: [
            {required: true, message: '标签名不能为空', trigger: 'blur'},
            {validator: validateName, trigger: 'blur'}
          ]
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
        tagApi.commonRequest(this.query).then(function (res) {
          self.table.loading = false;
          if (!res.data.success) {
            self.tagcloud.operation.success = false;
            self.tagcloud.operation.message = res.data.status.message;
          } else {
            self.tagcloud.data = res.data.data.datas;
            self.tagcloud.data.forEach(tag => {
              tag.color = 'default';

              if(tag.articleCount > 30){
                tag.color = 'red';
              }else if(tag.articleCount > 20){
                tag.color = 'orange';
              }else if(tag.articleCount > 0){
                tag.color = 'gold';
              }

            });

            self.query.totalRecord = res.data.data.total;
            self.query.pageSize = res.data.data.pageSize;
            self.query.pageNumber = res.data.data.pageNum;
            self.tagcloud.operation.success = true;

            self.tagcloud.operation.message = '';
            console.info(self.tagcloud.data);
          }
        }).catch(function (error) {
          self.tagcloud.operation.success = false;
          self.tagcloud.operation.message = res.data.status.message;
          self.table.loading = false;
        });
      },


      handleDeleteOnTag (event, tag) {
        this.handleDelete(tag.id);
      },

      handleDeleteOnTable (index) {
        this.handleDelete(this.tagcloud.data[index].id);
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
        this.modal.title = '添加标签';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          name: ''
        };
      },

      toEditModel(index) {
        this.modal.title = '修改标签';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          name: ''
        };
        let self = this;
        tagApi.getById(this.tagcloud.data[index].id).then(function (res) {
          let result = res.data;
          if(result.success){
            self.modal.data.id = result.data.id;
            self.modal.data.name = result.data.name;
          }else{
            self.$Message.error(result.status.message);
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
        });
      },
      addOrUpdate() {
        let self = this;
        this.$refs.modalForm.validate((valid) => {
          if (valid) {
            tagApi.addOrUpdate(this.modal.data).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.$Message.info("添加成功");
                self.search();
              } else {
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {
              self.$Message.error(error.message);
            });
            self.loading = false;
            self.modal.showModal = false;

          } else {
            self.loading = false;
          }
        });

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
