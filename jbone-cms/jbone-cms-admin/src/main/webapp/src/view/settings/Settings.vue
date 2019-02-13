<template>
  <div>
    <card>
      <Button type="primary" icon="ios-add" @click="toAddModel">添加</Button>
      <Button type="primary" icon="ios-backspace-outline" @click="handleBatchDelete" style="margin-left: 10px">删除</Button>
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">刷新</Button>
    </card>

    <card v-if="table.operation.success">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        网站基本信息配置
      </p>
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection" @on-delete="handleDelete" @on-select="handleSelect"></Table>
    </card>
    <card v-else>
      {{table.operation.message}}
    </card>

    <Modal :title="title" v-model="modal.showModal" :mask-closable="false">

      <p slot="header">
        <Icon type="ios-information-circle"></Icon>
        <span> {{ modal.title }}</span>
      </p>
      <Form :model="modal.data" :label-width="100" ref="modalForm" :rules="ruleValidate">
          <FormItem label="配置键" prop="settingKey" :required="true">
            <i-input v-model="modal.data.settingKey" clearable placeholder="配置键"></i-input>
          </FormItem>
          <FormItem label="配置值" prop="settingValue" :required="true">
            <i-input v-model="modal.data.settingValue" clearable  placeholder="配置值"></i-input>
          </FormItem>
          <FormItem label="说明" prop="description" >
            <i-input v-model="modal.data.description" clearable placeholder="说明"></i-input>
          </FormItem>
      </Form>
      <div slot="footer">
        <Button type="primary" size="large" long :loading="loading" @click="addOrUpdate">保存</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
  import settingsApi from '@/api/settings'

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
            {title: '配置ID', key: 'id'},
            {title: '配置键', key: 'settingKey'},
            {title: '配置值', key: 'settingValue'},
            {title: '说明', key: 'description'},
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
        modal:{
          title: '',
          showModal: false,
          data: {
            id: 0,
            settingKey: '',
            settingValue: '',
            description: ''
          }
        },

        ruleValidate: {
          settingKey: [
            {required: true, message: '配置键不能为空', trigger: 'blur'},
            {validator: validateName, trigger: 'blur'}
          ],
          settingValue: [
            {required: true, message: '配置值不能为空', trigger: 'blur'},
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
      },
      search() {
        this.table.loading = true;
        let self = this;
        settingsApi.getAll().then(function (res) {
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
        this.modal.title = '添加网站配置';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          settingKey: '',
          settingValue: '',
          description: ''
        };
      },

      toEditModel(index) {
        this.modal.title = '修改网站配置';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          settingKey: '',
          settingValue: '',
          description: ''
        };

        let self = this;
        settingsApi.getById(this.table.data[index].id).then(function (res) {
          let result = res.data;
          if(result.success){
            self.modal.data.id = result.data.id;
            self.modal.data.settingKey = result.data.settingKey;
            self.modal.data.settingValue = result.data.settingValue;
            self.modal.data.description = result.data.description;
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
      addOrUpdate() {
        let self = this;
        this.$refs.modalForm.validate((valid) => {
          if (valid) {
            settingsApi.addOrUpdate(this.modal.data).then(function (res) {
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
      handleDelete (index) {
        console.log(index);
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            settingsApi.delete(this.table.data[index].id).then(function (res) {
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
        console.info("batchDelete:" + ids);
        this.$Modal.confirm({
          title: '确定要删除这些记录吗？',
          onOk: () => {
            settingsApi.batchDelete(ids).then(function (res) {
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
      handleSelect(selection,row){
        console.info(selection);
        console.info(this.$refs.selection.getSelection());
      }
    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
