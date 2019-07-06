<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="modalForm" :rules="ruleValidate">
      <FormItem label="文章数" prop="maximumArticles" :required="true">
        <InputNumber v-model="data.maximumArticles" style="width: 200px" clearable  placeholder="最大支持文章数"></InputNumber>
      </FormItem>
      <FormItem label="栏目数" prop="maximumCategorys" :required="true">
        <InputNumber v-model="data.maximumCategorys" style="width: 200px"  clearable  placeholder="最大支持栏目数"></InputNumber>
      </FormItem>
      <FormItem label="标签数" prop="maximumTags" :required="true">
        <InputNumber v-model="data.maximumTags" style="width: 200px"  clearable  placeholder="最大支持标签数"></InputNumber>
      </FormItem>
      <FormItem label="评论数" prop="maximumComments" :required="true">
        <InputNumber v-model="data.maximumComments" style="width: 200px"  clearable  placeholder="最大支持评论数"></InputNumber>
      </FormItem>
      <FormItem label="广告数" prop="maximumAdvertisements" :required="true">
        <InputNumber v-model="data.maximumAdvertisements" style="width: 200px"  clearable  placeholder="最大支持广告数"></InputNumber>
      </FormItem>
      <FormItem label="插件数" prop="maximumPlugins" :required="true">
        <InputNumber v-model="data.maximumPlugins"  style="width: 200px"  clearable  placeholder="最大支持插件数"></InputNumber>
      </FormItem>
      <FormItem label="友链数" prop="maximumLinks" :required="true">
        <InputNumber v-model="data.maximumLinks"  style="width: 200px"  clearable  placeholder="最大支持友链数"></InputNumber>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import siteApi from '@/api/site'
  import siteSettingsApi from '@/api/siteSettings'

    export default {
      name: "setContentLimit",
      props:{
        siteId: {
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

        return {
          showEditModal: false,
          data: {
            maximumArticles: 0,
            maximumCategorys: 0,
            maximumTags: 0,
            maximumAdvertisements: 0,
            maximumPlugins: 0,
            maximumComments: 0,
            maximumLinks: 0
          },
          loading: false,
          ruleValidate: {
            maximumArticles: [
              {required: true,type:'number', message: '文章限制数不能为空', trigger: 'blur'}
            ],
            maximumCategorys: [
              {required: true,type:'number', message: '栏目限制数不能为空', trigger: 'blur'}
            ],
            maximumTags: [
              {required: true,type:'number', message: '标签限制数不能为空', trigger: 'blur'}
            ],
            maximumComments: [
              {required: true,type:'number', message: '评论限制数不能为空', trigger: 'blur'}
            ],
            maximumAdvertisements: [
              {required: true,type:'number', message: '广告限制数不能为空', trigger: 'blur'}
            ],
            maximumPlugins: [
              {required: true,type:'number', message: '插件限制数不能为空', trigger: 'blur'}
            ],
            maximumLinks: [
              {required: true,type:'number', message: '友链限制数不能为空', trigger: 'blur'}
            ]
          },
        };
      },
      computed:{
        fullTitle(){
          return '设置站点[' + this.title + ']的内容限制'
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
        loadData() {
          this.data = {
            maximumArticles: 0,
            maximumCategorys: 0,
            maximumTags: 0,
            maximumAdvertisements: 0,
            maximumPlugins: 0,
            maximumComments: 0,
            maximumLinks: 0
          }
          if(this.siteId <= 0){
            return
          }

          let self = this;
          siteSettingsApi.getAllWithSiteId(this.siteId).then(function (res) {
            let result = res.data;
            if(result.success){
              let maximumArticles = result.data.maximumArticles
              let maximumCategorys = result.data.maximumCategorys
              let maximumTags = result.data.maximumTags
              let maximumAdvertisements = result.data.maximumAdvertisements
              let maximumPlugins = result.data.maximumPlugins
              let maximumComments = result.data.maximumComments
              let maximumLinks = result.data.maximumLinks
              self.data.maximumArticles = maximumArticles == null ? 0 : parseInt(maximumArticles);
              self.data.maximumCategorys = maximumCategorys == null ? 0 : parseInt(maximumCategorys);
              self.data.maximumTags = maximumTags == null ? 0 : parseInt(maximumTags);
              self.data.maximumAdvertisements = maximumAdvertisements == null ? 0 : parseInt(maximumAdvertisements);
              self.data.maximumPlugins = maximumPlugins == null ? 0 : parseInt(maximumPlugins);
              self.data.maximumComments = maximumComments == null ? 0 : parseInt(maximumComments);
              self.data.maximumLinks = maximumLinks == null ? 0 : parseInt(maximumLinks);
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
              let settings = []
              let keys = Object.keys(this.data);
              keys.forEach(name => {
                let setting = {name:name,value:this.data[name]}
                settings.push(setting);
              });


              siteSettingsApi.batchAddOrUpdateWithSiteId(self.siteId,settings).then(function (res) {
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
          });

        },
      }
    }
</script>

<style scoped>

</style>
