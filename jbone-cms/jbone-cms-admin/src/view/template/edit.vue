<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle" width="1024">

    <Card :dis-hover="true">

      <Form :model="template" :label-width="100" ref="modalForm" :rules="ruleValidate">
        <FormItem label="模版名" prop="name" :required="true">
          <i-input v-model="template.name" clearable placeholder="模版名"></i-input>
        </FormItem>
        <FormItem label="模版码" prop="code" :required="true">
          <i-input v-model="template.code" clearable placeholder="模版名,对应模版目录名"></i-input>
        </FormItem>
        <FormItem label="模版类型" prop="type" :required="true">
          <Select v-model="template.type">
            <Option v-for="item in templateTypes" :value="item.dictValue" :key="item.id">{{ item.dictName }}</Option>
          </Select>
        </FormItem>
        <FormItem label="模版风格" prop="style" :required="true">
          <Select v-model="template.style">
            <Option v-for="item in templateStyles" :value="item.dictValue" :key="item.id">{{ item.dictName }}</Option>
          </Select>
        </FormItem>
        <FormItem label="模版色系" prop="color" :required="true">
          <Select v-model="template.color">
            <Option v-for="item in templateColors" :value="item.dictValue" :key="item.id">{{ item.dictName }}</Option>
          </Select>
        </FormItem>
        <FormItem label="是否启用" prop="enable" :required="true">
          <i-switch v-model="template.enable" size="large" true-value="1" false-value="0">
            <span slot="open">启用</span>
            <span slot="close">禁用</span>
          </i-switch>
        </FormItem>
        <FormItem label="单页模版" prop="singlePage" :required="true">
          <i-switch v-model="template.singlePage" size="large" true-value="1" false-value="0">
            <span slot="open">启用</span>
            <span slot="close">禁用</span>
          </i-switch>
        </FormItem>
        <FormItem label="描述" prop="description">
          <Input v-model="template.description" type="textarea" :rows="4" placeholder="描述" />
        </FormItem>

        <FormItem label="封面图" prop="frontCover" :required="true">
          <upload-file v-model="template.frontCover"></upload-file>
        </FormItem>
        <FormItem label="其他图片" prop="images">
          <upload-file v-model="template.images"></upload-file>
        </FormItem>

      </Form>

    </Card>


    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import templateApi from "@/api/template";
  import dictionaryApi from '@/api/dictionary'
  import UploadFile from "../components/upload-file/upload-file";

    export default {
      name: "templateEdit",
      components: {UploadFile},
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

        return {
          showEditModal: false,
          template: {
            id: 0,
            name: '',
            code: '',
            frontCover: '',
            images: '',
            description: '',
            type: '',
            style: '',
            color: '',
            enable: '1',
            singlePage: '0',
            dataCollectors: ''
          },
          templateTypes:[],
          templateColors: [],
          templateStyles: [],
          loading: false,
          ruleValidate: {
            name: [
              {required: true, message: '模版名不能为空', trigger: 'blur'},
            ],
            type: [
              {required: true, message: '类型不能为空', trigger: 'blur'}
            ],
            color: [
              {required: true, message: '色系不能为空', trigger: 'blur'}
            ],
            style: [
              {required: true, message: '风格不能为空', trigger: 'blur'}
            ],
            code: [
              {required: true, message: '模版码不能为空', trigger: 'blur'}
            ],
            frontCover: [
              {required: true, message: '封面图不能为空', trigger: 'blur'}
            ],
            singlePage: [
              {required: true, message: '单页不能为空', trigger: 'blur'}
            ]
          },
        };
      },
      computed:{
        fullTitle(){
          if(this.title != null){
            return '编辑模版[' + this.title + ']'
          }else{
            return '添加模版'
          }

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
          this.template = {
            id: 0,
            name: '',
            code: '',
            frontCover: '',
            images: '',
            description: '',
            type: '',
            style: '',
            color: '',
            enable: '1',
            singlePage: '0',
            dataCollectors: ''
          }
          this.loadTemlate()
          this.loadTemplateType()
          this.loadTemplateColor()
          this.loadTemplateStyle()

        },
        loadTemlate(){
          if(this.id > 0) {
            let self = this;
            templateApi.getById(this.id).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.template.id = result.data.id;
                self.template.name = result.data.name;
                self.template.description = result.data.description;
                self.template.code = result.data.code;
                self.template.color = result.data.color;
                self.template.enable = result.data.enable + '';
                self.template.frontCover = result.data.frontCover;
                self.template.images = result.data.images;
                self.template.style = result.data.style;
                self.template.type = result.data.type;
                self.template.singlePage = result.data.singlePage + '';
                self.template.dataCollectors = result.data.dataCollectors;
              } else {
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {
              self.$Message.error(error.message);
            });
          }
        },

        loadTemplateType(){
          let self = this;
          dictionaryApi.getItemsByCode('template_type').then(function (res) {
            let result = res.data;
            if(result.success){
              self.templateTypes = result.data == null ? [] : result.data
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadTemplateColor(){
          let self = this;
          dictionaryApi.getItemsByCode('template_color').then(function (res) {
            let result = res.data;
            if(result.success){
              self.templateColors = result.data == null ? [] : result.data
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadTemplateStyle(){
          let self = this;
          dictionaryApi.getItemsByCode('template_style').then(function (res) {
            let result = res.data;
            if(result.success){
              self.templateStyles = result.data == null ? [] : result.data
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },



        pageChange(pageNum){
          this.searchUserCondition.pageNumber = pageNum;
          this.loadSiteAdmins();
        },
        pageSizeChange(pageSize){
          this.searchUserCondition.pageSize = pageSize;
          this.loadSiteAdmins();
        },

        addOrUpdate() {
          this.loading = true;
          let self = this;
          this.$refs.modalForm.validate((valid) => {
            if (valid) {
              templateApi.addOrUpdate(this.template).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
                  self.$emit('success');
                } else {
                  self.$Message.error(result.status.message);
                }
                self.loading = false;
              }).catch(function (error) {
                self.$Message.error(error.message);
                self.loading = false;
              });
              self.showEditModal = false;

            } else {
              self.loading = false;
            }
          })

        },

      }
    }
</script>

<style lang="less">
</style>
