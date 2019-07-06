<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="linkForm" :rules="ruleValidate">
      <FormItem label="插件名" prop="name" :required="true">
        <i-input v-model="data.name" clearable placeholder="链接名"></i-input>
      </FormItem>
      <FormItem label="插件类型" prop="type" :required="true">
        <Select v-model="data.type">
        <Option v-for="item in pluginTypes" :value="item.dictValue" :key="item.id">{{ item.dictName }}</Option>
      </Select>
      </FormItem>
      <FormItem label="插件内容" prop="content" :required="true">
        <Input v-model="data.content" type="textarea" :rows="4" placeholder="插件内容" />
      </FormItem>
      <FormItem label="是否启用" prop="enable" :required="true">
        <i-switch v-model="data.enable" size="large" true-value="1" false-value="0">
          <span slot="open">启用</span>
          <span slot="close">禁用</span>
        </i-switch>
      </FormItem>
      <FormItem label="排序号" prop="orders"  :required="true">
        <InputNumber v-model="data.orders" clearable  placeholder="排序号"></InputNumber>
      </FormItem>

    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import pluginApi from '@/api/plugin'
  import dictionaryApi from '@/api/dictionary'
    export default {
      name: "editPlugin",
      props:{
        id: {
          type:Number,
          default: 0
        },
        name: String,
        showModal: {
          type: Boolean,
          default: false
        },
      },
      data(){
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
          showEditModal: false,
          data: {
            id: 0,
            name: '',
            content: '',
            type: 'global',
            enable: '1',
            orders: 0
          },
          pluginTypes:[],
          loading:false,

          ruleValidate: {
            name: [
              {required: true, message: '插件名称不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ],
            content: [
              {required: true, message: '插件内容不能为空', trigger: 'blur'}
            ],
            type: [
              {required: true, message: '插件类型不能为空', trigger: 'blur'}
            ],
            orders: [
              {required: true,type:'number', message: '插件序号不能为空', trigger: 'blur'}
            ]
          },
        }
      },
      computed:{
        fullTitle(){
          if(this.id <= 0 ){
            return '添加插件'
          }
          return '编辑插件 [' + this.name + ']'
        }
      },
      watch:{
        showModal(val){
          this.showEditModal = val
        },
        showEditModal(val) {
          this.$emit('updateShowModal', val);
          if(val){
            this.init();
          }
        },
      },
      methods:{
        init(){
          this.loadData()
          this.loadPluginType()
        },

        loadData(){
          this.data = {
            id: 0,
            name: '',
            content: '',
            type: 'global',
            enable: '1',
            orders: 0
          }

          if(this.id <= 0){
            return
          }

          let self = this;
          pluginApi.getById(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.id = result.data.id;
              self.data.name = result.data.name;
              self.data.type = result.data.type;
              self.data.content = result.data.content;
              self.data.enable = result.data.enable + '';
              self.data.orders = result.data.orders;
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadPluginType(){
          let self = this;
          dictionaryApi.getItemsByCode('plugin_type').then(function (res) {
            let result = res.data;
            if(result.success){
              self.pluginTypes = result.data
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        addOrUpdate() {
          let self = this;
          this.$refs.linkForm.validate((valid) => {
            if (valid) {
              pluginApi.addOrUpdate(self.data).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("添加成功");
                  self.$emit('success');
                } else {
                  self.$Message.error(result.status.message);
                }
              }).catch(function (error) {
                self.$Message.error(error.message);
              });
              self.loading = false;
              self.showEditModal = false;

            } else {
              self.loading = false;
            }
          })
        },

      }
    }
</script>

<style scoped>

</style>
