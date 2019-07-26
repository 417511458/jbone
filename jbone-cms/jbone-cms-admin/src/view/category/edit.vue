<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="modalForm" :rules="ruleValidate">
      <FormItem label="栏目标题" prop="title" :required="true">
        <i-input v-model="data.title" clearable placeholder="栏目标题"></i-input>
      </FormItem>
      <FormItem label="栏目编码" prop="code" :required="true">
        <i-input v-model="data.code" clearable placeholder="栏目编码（用于导航路径）"></i-input>
      </FormItem>

      <FormItem label="关键字" prop="keywords">
        <i-input v-model="data.keywords" clearable placeholder="关键字"></i-input>
      </FormItem>

      <FormItem label="说明" prop="description" >
        <i-input v-model="data.description" clearable placeholder="说明"></i-input>
      </FormItem>

      <FormItem label="类型" prop="type">
        <RadioGroup v-model="data.type" type="button">
          <Radio label="CATEGORY">文章</Radio>
          <Radio label="SPECIAL">专题</Radio>
          <Radio label="IMG">图集</Radio>
          <Radio label="NEWS">新闻</Radio>
          <Radio label="PRODUCT">产品</Radio>
          <Radio label="TAG">标签聚合</Radio>
        </RadioGroup>
      </FormItem>

      <FormItem label="是否展示在导航" prop="inMenu"  >
        <RadioGroup v-model="data.inMenu" type="button">
          <Radio label="TRUE">是</Radio>
          <Radio label="FALSE">否</Radio>
        </RadioGroup>
      </FormItem>

      <FormItem label="展示方式" prop="inMenu"  >
        <RadioGroup v-model="data.showType" type="button">
          <Radio label="LIST">列表展示</Radio>
          <Radio label="FIRSTARTICLE">展示第一篇文章</Radio>
        </RadioGroup>
      </FormItem>

      <FormItem label="状态" prop="status" >
        <RadioGroup v-model="data.status" type="button">
          <Radio label="PUBLISH">发布</Radio>
          <Radio label="AUDIT">待审核</Radio>
        </RadioGroup>
      </FormItem>

      <FormItem label="排序号" prop="orders" >
        <InputNumber v-model="data.orders" clearable  placeholder="排序号"></InputNumber>
      </FormItem>

      <FormItem label="封面图" prop="frontCover" >
        <i-input v-model="data.frontCover" clearable  placeholder="封面图"></i-input>
      </FormItem>

      <FormItem label="栏目链接" prop="url" >
        <i-input v-model="data.url" clearable  placeholder="栏目链接"></i-input>
      </FormItem>

      <FormItem label="跳转目标" prop="target">
        <RadioGroup v-model="data.target" type="button">
          <Radio label="_blank">新标签页</Radio>
          <Radio label="_self">当前页</Radio>
        </RadioGroup>
      </FormItem>

    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import categoryApi from '@/api/category'
    export default {
      name: "categoryedit",
      props:{
        id: {
          type:Number,
          default: 0
        },
        pid:{
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
            pid: 0,
            title: '',
            url: '',
            target: '_blank',
            orders: 0,
            keywords: '',
            description: '',
            type: 'CATEGORY',
            inMenu: 'TRUE',
            status: 'PUBLISH',
            showType: 'LIST',
            frontCover: '',
            code: '',
            tags: []
          },
          loading: false,
          ruleValidate: {
            title: [
              {required: true, message: '标题不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ],
            code: [
              {required: true, message: '编码不能为空', trigger: 'blur'}
            ]
          }
        };
      },
      computed:{
        fullTitle(){
          if(this.id <= 0 ){
            return '添加栏目'
          }
          return '编辑栏目 [' + this.title + ']'
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
        pid(val){
          this.data.pid = val
        }
      },

      methods:{

        init(){
          this.loadCategory()
        },

        loadCategory() {

          this.data = {
            id: 0,
            pid: this.pid,
            title: '',
            url: '',
            target: '_blank',
            orders: 0,
            keywords: '',
            description: '',
            type: 'CATEGORY',
            inMenu: 'TRUE',
            status: 'PUBLISH',
            showType: 'LIST',
            frontCover: '',
            code: '',
            tags: []
          }

          if(this.id <= 0){
            return
          }

          let self = this;
          categoryApi.getById(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data = {
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
                status: result.data.status,
                showType: result.data.showType,
                frontCover: result.data.frontCover,
                code: result.data.code,
                tags: result.data.tags
              };
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },
        addOrUpdate() {
          let self = this;
          this.loading = true
          this.$refs.modalForm.validate((valid) => {
            if (valid) {
              categoryApi.addOrUpdate(self.data).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
                  self.showEditModal = false
                  self.$emit('success');
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
      }
    }
</script>

<style scoped>

</style>
