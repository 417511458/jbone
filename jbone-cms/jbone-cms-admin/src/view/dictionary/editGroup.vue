<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="editForm" :rules="ruleValidate">
      <FormItem label="组名" prop="name" :required="true">
        <i-input v-model="data.name" clearable placeholder="组名"></i-input>
      </FormItem>
      <FormItem label="组编码" prop="code" :required="true">
        <i-input v-model="data.code" clearable  placeholder="组编码"></i-input>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import dictionaryApi from '@/api/dictionary'
    export default {
      name: "editDictionaryGroup",
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
            code: ''
          },
          loading:false,

          ruleValidate: {
            name: [
              {required: true, message: '组名不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ],
            code: [
              {required: true, message: '组编码不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ]
          },
        }
      },
      computed:{
        fullTitle(){
          if(this.id <= 0 ){
            return '添加字典'
          }
          return '编辑字典[' + this.name + ']'
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
        },

        loadData(){

          this.data = {
            id: 0,
            name: '',
            code: ''
          }

          if(this.id <= 0){
            return
          }

          let self = this;
          dictionaryApi.getGroup(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.id = result.data.id;
              self.data.name = result.data.name;
              self.data.code = result.data.code;
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        addOrUpdate() {
          let self = this;
          this.$refs.editForm.validate((valid) => {
            if (valid) {
              dictionaryApi.addOrUpdateGroup(this.data).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
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
