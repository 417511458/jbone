<template>
  <div>
    <card>
      <Input clearable placeholder="标签名" v-model="query.name" style="width: 200px;" />
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">刷新</Button>
    </card>

    <card v-if="tagcloud.operation.success">
      <Tag v-for="item in tagcloud.data" :key="item" :name="item" closable @on-close="handleDelete">{{ item.name }}</Tag>
    </card>
    <card v-else>
      {{tagcloud.operation.message}}
    </card>

  </div>
</template>
<script>
  import tagApi from '@/api/tag'
  import Input from "iview/src/components/input/input";

  export default {
    components: {Input},
    data() {

      return {

        query: {name: ''},
        tagcloud: {
          operation: {
            operation: {
              success: true,
              message: ""
            }
          },
          data:[]
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
        tagApi.getByName(this.query.name).then(function (res) {
          console.info(res);
          if (!res.data.success) {
            self.tagcloud.operation.success = false;
            self.tagcloud.operation.message = res.data.status.message;
          } else {
            self.tagcloud.data = res.data.data;
            self.tagcloud.operation.success = true;
            self.tagcloud.operation.message = '';
            console.info(self.tagcloud.data);
          }
        }).catch(function (error) {
          self.tagcloud.operation.success = false;
          self.tagcloud.operation.message = res.data.status.message;
        });
      },


      handleDelete (event, name) {
        console.log(event);
        console.log(name);
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            tagApi.delete(this.table.data[index].id).then(function (res) {
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

      }

    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
