<template>
  <div>
    <card>
      <Button type="primary" icon="ios-add" @click="toAddModel">添加</Button>
      <Button type="primary" icon="ios-backspace-outline" @click="search" style="margin-left: 10px">删除</Button>
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">刷新</Button>
    </card>

    <card v-if="table.operation.success">
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection" @on-delete="handleDelete"></Table>
    </card>
    <card v-else>
      {{table.operation.message}}
    </card>

    <Modal :title="title" v-model="editModalModel.showModal" :mask-closable="false">

      <p slot="header">
        <Icon type="ios-information-circle"></Icon>
        <span> {{ editModalModel.title }}</span>
      </p>
      <Form :model="linkModel" :label-width="100" ref="linkForm" :rules="ruleValidate">
          <FormItem label="链接名" prop="title" style="margin: 0;" :required="true">
            <i-input v-model="linkModel.title" clearable style="width: 200px;" placeholder="链接名"></i-input>
          </FormItem>
          <FormItem label="URL" prop="url" style="margin: 0;" :required="true">
            <i-input v-model="linkModel.url" clearable style="width: 200px;" placeholder="链接地址"></i-input>
          </FormItem>
          <FormItem label="排序号" prop="orders" style="margin: 0;" :required="true">
            <i-input v-model="linkModel.orders" clearable style="width: 200px;" placeholder="排序号"></i-input>
          </FormItem>
          <FormItem label="描述" prop="description" style="margin: 0;" :required="true">
            <i-input v-model="linkModel.description" clearable style="width: 200px;" placeholder="描述"></i-input>
          </FormItem>

      </Form>
      <div slot="footer">
        <Button type="primary" size="large" long :loading="loading" @click="addOrUpdate">保存</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
  import linkApi from '@/api/link'

  export default {
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

        editModalModel: {
          title: '',
          showModal: false,
          linkId: 0,
        },

        linkModel: {
          id: 0,
          title: '',
          url: '',
          description: '',
          orders: 0
        },

        ruleValidate: {
          title: [
            {required: true, message: '链接名称不能为空', trigger: 'blur'},
            {validator: validateName, trigger: 'blur'}
          ],
          url: [
            {required: true, message: 'URL不能为空', trigger: 'blur'},
            {validator: validateName, trigger: 'blur'},
          ]
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

        this.table.columns.forEach(item => {
          // if (item.key === 'handle') {
          //   item.render = (h, param) => {
          //     let currentRowData = this.table.data[param.index];
          //     return h('div', [
          //       addHandleButton(this, h, currentRowData, param.index),
          //     ]);
          //   };
          // }
        });
      },
      search() {
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
        this.editModalModel.title = '添加链接';
        this.editModalModel.showModal = true;
        this.linkModel = {
          id: 0,
          title: '',
          url: '',
          description: '',
          orders: 0
        };
      },

      toEditModel(index) {
        this.editModalModel.title = '修改链接';
        this.editModalModel.showModal = true;
        this.linkModel = {
          id: 0,
          title: '',
          url: '',
          description: '',
          orders: 0
        };
        console.info("toEditModel,index:" + index )
        let self = this;
        linkApi.getById(this.table.data[index].id).then(function (res) {
          let result = res.data;
          if(result.success){
            self.linkModel.id = result.data.id;
            self.linkModel.title = result.data.title;
            self.linkModel.url = result.data.url;
            self.linkModel.description = result.data.description;
            self.linkModel.orders = result.data.orders;
          }else{
            self.$Message.error(result.status.message);
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
        });
      },
      setTableMessage(message) {
        this.table.operation.success = false;
        this.table.operation.message = message;
      },
      show (index) {
        this.$Modal.info({
          title: '链接信息',
          content: `链接名：${this.table.data[index].title}<br>URL：${this.table.data[index].url}<br>说明：${this.table.data[index].description}`
        })
      },
      addOrUpdate() {
        let self = this;
        this.$refs.linkForm.validate((valid) => {
          if (valid) {
            linkApi.addOrUpdate(this.linkModel).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.close("添加成功", true);
                self.search();
              } else {
                self.close(result.status.message, false);
              }
            }).catch(function (error) {
              self.close(error.message, false);
            });
            self.loading = false;
            self.editModalModel.showModal = false;

          } else {
            self.loading = false;
          }
        });

      },
      close(message, success) {
        // 弹出全局提示
        if(success){
          this.$Message.info(message);
        }else{
          this.$Message.error(message);
        }
      },
      handleDelete (index) {
        console.log(index);
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
    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
