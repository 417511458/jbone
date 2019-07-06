<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="linkForm" :rules="ruleValidate">
      <FormItem label="链接名" prop="title" :required="true">
        <i-input v-model="data.title" clearable placeholder="链接名"></i-input>
      </FormItem>
      <FormItem label="URL" prop="url" :required="true">
        <i-input v-model="data.url" clearable  placeholder="链接地址"></i-input>
      </FormItem>
      <FormItem label="排序号" prop="orders"  :required="true">
        <InputNumber v-model="data.orders" clearable  placeholder="排序号"></InputNumber>
      </FormItem>
      <FormItem label="描述" prop="description" :required="true">
        <i-input v-model="data.description" clearable placeholder="描述"></i-input>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import linkApi from '@/api/link'
    export default {
      name: "editLink",
      props:{
        id: {
          type:Number,
          default: 0
        },
        title: String,
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
            title: '',
            url: '',
            description: '',
            orders: 0
          },
          loading:false,

          ruleValidate: {
            title: [
              {required: true, message: '链接名称不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ],
            url: [
              {required: true, message: '链接地址不能为空', trigger: 'blur'}
            ],
            description: [
              {required: true, message: '链接描述不能为空', trigger: 'blur'}
            ],
            orders: [
              {required: true,type:'number', message: '排序号不能为空', trigger: 'blur'}
            ]
          },
        }
      },
      computed:{
        fullTitle(){
          if(this.id <= 0 ){
            return '添加友情链接'
          }
          return '编辑友情链接 [' + this.title + ']'
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
          this.loadLink()
        },

        loadLink(){

          this.data = {
            id: 0,
            title: '',
            url: '',
            description: '',
            orders: 0
          }

          if(this.id <= 0){
            return
          }

          let self = this;
          linkApi.getById(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.id = result.data.id;
              self.data.title = result.data.title;
              self.data.url = result.data.url;
              self.data.description = result.data.description;
              self.data.orders = result.data.orders;
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
              linkApi.addOrUpdate(this.data).then(function (res) {
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
