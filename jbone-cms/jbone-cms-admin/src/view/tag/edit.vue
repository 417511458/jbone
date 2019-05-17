<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="modalForm" :rules="ruleValidate">
      <FormItem label="标签名" prop="name" :required="true">
        <i-input v-model="data.name" clearable placeholder="标签名"></i-input>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import tagApi from '@/api/tag'
    export default {
      name: "tagEdit",
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
          showEditModal: false,
          data: {
            id: 0,
            name: ''
          },
          loading: false,
          ruleValidate: {
            name: [
              {required: true, message: '标签名不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ]
          },
        };
      },
      computed:{
        fullTitle(){
          if(this.id <= 0 ){
            return '添加标签'
          }
          return '编辑标签 [' + this.title + ']'
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
          this.loadTag()
        },
        loadTag() {
          this.data = {
            id: 0,
            name: ''
          }
          if(this.id <= 0){
            return
          }

          let self = this;
          tagApi.getById(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.id = result.data.id;
              self.data.name = result.data.name;
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
              tagApi.addOrUpdate(this.data).then(function (res) {
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
          });

        },
      }
    }
</script>

<style scoped>

</style>
