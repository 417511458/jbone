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
          <Button @click="toEditModel(scope.row.id)" type="primary" size="small">编辑</Button>
          <Button @click="toAddModel(scope.row.id)" type="primary" size="small" style="margin-left: 5px">添加下级栏目</Button>
          <Button @click="handleDelete(scope.row.id)" type="error" size="small" style="margin-left: 5px">删除</Button>
        </template>
        <template slot="type" slot-scope="scope">
          <span v-if="scope.row.type == 'CATEGORY'">普通栏目</span>
          <span v-if="scope.row.type == 'TAG'">标签聚合栏目</span>
          <span v-if="scope.row.type == 'SPECIAL'">专题栏目</span>
        </template>
      </tree-table>
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
        <FormItem label="栏目标题" prop="title" :required="true">
          <i-input v-model="modal.data.title" clearable placeholder="栏目标题"></i-input>
        </FormItem>

        <FormItem label="关键字" prop="keywords">
          <i-input v-model="modal.data.keywords" clearable placeholder="关键字"></i-input>
        </FormItem>

        <FormItem label="说明" prop="description" >
          <i-input v-model="modal.data.description" clearable placeholder="说明"></i-input>
        </FormItem>

        <FormItem label="类型" prop="type" >
          <RadioGroup v-model="modal.data.type" type="button">
            <Radio label="CATEGORY">普通栏目</Radio>
            <Radio label="TAG">标签聚合栏目</Radio>
            <Radio label="SPECIAL">专题栏目</Radio>
          </RadioGroup>
        </FormItem>

        <FormItem label="是否展示在导航" prop="inMenu"  >
          <RadioGroup v-model="modal.data.inMenu" type="button">
            <Radio label="TRUE">是</Radio>
            <Radio label="FALSE">否</Radio>
          </RadioGroup>
        </FormItem>

        <FormItem label="状态" prop="status" >
          <RadioGroup v-model="modal.data.status" type="button">
            <Radio label="PUBLISH">发布</Radio>
            <Radio label="AUDIT">待审核</Radio>
          </RadioGroup>
        </FormItem>

        <FormItem label="排序号" prop="orders" >
          <InputNumber v-model="modal.data.orders" clearable  placeholder="排序号"></InputNumber>
        </FormItem>

        <FormItem label="栏目链接" prop="url" >
          <i-input v-model="modal.data.url" clearable  placeholder="栏目链接"></i-input>
        </FormItem>

        <FormItem label="跳转目标" prop="target">
          <i-input v-model="modal.data.target" clearable  placeholder="跳转目标"></i-input>
        </FormItem>

      </Form>
      <div slot="footer">
        <Button type="primary" size="large" long :loading="loading" @click="addOrUpdate">保存</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
  import categoryApi from '@/api/category'
  import InputNumber from "iview/src/components/input-number/input-number";

  export default {
    components: {InputNumber},
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

        table: {
          loading: false,
          columns: [
            {
              title: '栏目标题',
              key: 'title',
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
              // key: 'handle',
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

        modal:{
          title: '',
          showModal: false,
          data: {
            id: 0,
            pid: 0,
            title: '',
            url: '',
            target: '',
            orders: 0,
            keywords: '',
            description: '',
            type: 'CATEGORY',
            inMenu: 'FALSE',
            status: 'PUBLISH'

          }
        },

        ruleValidate: {
          title: [
            {required: true, message: '标题不能为空', trigger: 'blur'},
            {validator: validateName, trigger: 'blur'}
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
        this.modal.title = '添加栏目';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          pid: pid,
          title: '',
          url: '',
          target: '',
          orders: 0,
          keywords: '',
          description: '',
          type: 'CATEGORY',
          inMenu: 'FALSE',
          status: 'PUBLISH'
        };
      },

      toEditModel(id) {
        this.modal.title = '修改网站配置';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          pid: 0,
          title: '',
          url: '',
          target: '',
          orders: 0,
          keywords: '',
          description: '',
          type: 'CATEGORY',
          inMenu: 'FALSE',
          status: 'PUBLISH'
        };

        let self = this;
        categoryApi.getById(id).then(function (res) {
          let result = res.data;
          if(result.success){
            self.modal.data = {
              id: result.data.id,
              pid: result.data.pid,
              title: result.data.title,
              url: result.data.url,
              target: result.data.target,
              orders: result.data.orders,
              keywords: result.data.keywords,
              description: result.data.description,
              type: result.data.type,
              inMenu: result.data.inMenu,
              status: result.data.status
            };
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
            categoryApi.addOrUpdate(this.modal.data).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.$Message.info("操作成功");
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
