<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="editForm" :rules="ruleValidate">
      <FormItem label="字典名" prop="dictName" :required="true">
        <i-input v-model="data.dictName" clearable placeholder="字典名"></i-input>
      </FormItem>
      <FormItem label="字典值" prop="dictValue" :required="true">
        <i-input v-model="data.dictValue" clearable  placeholder="字典值"></i-input>
      </FormItem>
      <FormItem label="字典提示文本" prop="dictPrompt" :required="true">
        <i-input v-model="data.dictPrompt" clearable  placeholder="字典提示文本"></i-input>
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
      name: "editDictionaryItem",
      props:{
        id: {
          type:Number,
          default: 0
        },
        groupId:{
          type:Number,
          default: 0
        },
        dictName: String,
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
            dictName: '',
            dictValue: '',
            dictPrompt: '',
            groupId: 0
          },
          loading:false,

          ruleValidate: {
            dictName: [
              {required: true, message: '名字不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ],
            dictValue: [
              {required: true, message: '值不能为空', trigger: 'blur'}
            ],
            dictPrompt: [
              {required: true, message: '提示文本不能为空', trigger: 'blur'}
            ]
          },
        }
      },
      computed:{
        fullTitle(){
          if(this.id <= 0 ){
            return '添加字典项'
          }
          return '编辑字典项[' + this.dictName + ']'
        }
      },
      watch:{
        showModal(val){
          this.showEditModal = val
        },
        groupId(val){
          this.data.groupId = val
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
            dictName: '',
            dictValue: '',
            dictPrompt: '',
            groupId: this.groupId
          }

          if(this.id <= 0){
            return
          }

          let self = this;
          dictionaryApi.getItem(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.id = result.data.id;
              self.data.dictName = result.data.dictName;
              self.data.dictValue = result.data.dictValue;
              self.data.dictPrompt = result.data.dictPrompt;
              self.data.groupId = result.data.groupId;
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
              dictionaryApi.addOrUpdateItem(this.data).then(function (res) {
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
