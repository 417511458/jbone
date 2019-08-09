<template>
  <div>
    <card>
      <Input clearable placeholder="请输入属性名，如title、keywords" v-model="query.name" style="width: 250px;" />
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">查询</Button>
      <Button type="primary" icon="ios-add" @click="toAddModel" style="margin-left: 10px">添加</Button>
    </card>

    <card v-if="table.operation.success">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        网站基本信息配置
      </p>
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection" @on-delete="handleDelete">
        <template slot="dataType" slot-scope="{ row, index }">
          <span v-if="row.dataType == 'text'">文本</span>
          <span v-if="row.dataType == 'img'">图片</span>
          <span v-if="row.dataType == 'richText'">富文本</span>
        </template>
      </Table>
      <Page :total="query.totalRecord" show-total :pageSize="query.pageSize" @on-change="pageChange" show-sizer @on-page-size-change="pageSizeChange"
            v-show="table.operation.success"></Page>
    </card>
    <card v-else>
      {{table.operation.message}}
    </card>

  </div>
</template>
<script>
  import siteSettingsApi from '@/api/siteSettings'
  import siteApi from '@/api/site'
  import { mapMutations } from 'vuex'

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

        query: {
          name: '',
          totalRecord: 0,
          pageSize: 10,
          pageNumber: 1
        },
        table: {
          loading: false,
          columns: [
            {
              type: 'selection',
              width: 60,
              align: 'center'
            },
            {title: '配置ID', key: 'id'},
            {title: '配置名', key: 'name'},
            {title: '配置值', key: 'value'},
            {title: '说明', key: 'prompt'},
            {
              title: '类型',
              type: 'template',
              slot: 'dataType'
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
            {required: true, message: '配置值不能为空', trigger: 'blur'}
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

      ...mapMutations([
        'closeTag'
      ]),

      search() {
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }
        this.table.loading = true;
        let self = this;
        siteSettingsApi.commonRequest(this.query).then(function (res) {
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
          self.setTableMessage(error.message);
        });
      },

      toAddModel() {

        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }

        this.closeTag({
          name: 'site_property_page'
        })
        this.$router.push({ path: '/site/edit'})
      },

      toEditModel(index) {

        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }

        this.$router.push({ path: '/site/edit', query: { id:this.table.data[index].id }})
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
            siteSettingsApi.delete(this.table.data[index].id).then(function (res) {
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

