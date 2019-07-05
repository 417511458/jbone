<template>
  <div>
    <card>
      <Button type="primary" icon="ios-add" @click="toAddModel">添加</Button>
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">刷新</Button>
    </card>

    <card v-if="table.operation.success">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        插件管理
      </p>
      <Table :loading="table.loading" :columns="table.columns" :data="table.data" stripe border ref="selection" @on-delete="handleDelete">
        <template slot="enable" slot-scope="{ row, index }">
          <Button v-if="row.enable == 1" type="success">可用</Button>
          <Button v-if="row.enable == 0" type="dashed">不可用</Button>
        </template>
        <template slot="pluginType" slot-scope="{ row, index }">
          <div v-if="row.pluginType">
            <Tooltip placement="top">
              <p v-text="row.pluginType.name"></p>
              <div slot="content">
                <p v-text="row.pluginType.prompt"></p>
              </div>
            </Tooltip>
          </div>
          <div v-else>
            <p v-text="row.type"></p>
          </div>
        </template>
      </Table>
    </card>
    <card v-else>
      {{table.operation.message}}
    </card>

    <edit-plugin  :id="editModal.id" :show-modal="editModal.showModal" :name="editModal.name" @success="search" @updateShowModal="(val) => {editModal.showModal = val}"></edit-plugin>
  </div>
</template>
<script>
  import pluginApi from '@/api/plugin'
  import EditPlugin from "./edit";
  import siteApi from '@/api/site'

  export default {
    components: {EditPlugin},
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
            {title: '插件名', key: 'name'},
            {
              title: '插件类型',
              type: 'template',
              slot: 'pluginType'
            },
            {
              title: '状态',
              type: 'template',
              slot: 'enable'
            },
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

        editModal: {
          id: 0,
          name: '',
          showModal: false,
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
        pluginApi.getAll(siteApi.getCurrentSiteID()).then(function (res) {
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
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }
        this.editModal.id = 0
        this.editModal.name = '添加插件'
        this.editModal.showModal = true
      },

      toEditModel(index) {
        this.editModal.id = this.table.data[index].id
        this.editModal.name = this.table.data[index].name
        this.editModal.showModal = true
      },
      setTableMessage(message) {
        this.table.operation.success = false;
        this.table.operation.message = message;
      },
      handleDelete (index) {
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            pluginApi.delete(this.table.data[index].id).then(function (res) {
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
