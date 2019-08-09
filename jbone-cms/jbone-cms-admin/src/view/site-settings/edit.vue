<template>
  <div>
    <Card :dis-hover="true">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        编辑站点属性
      </p>
      <Form :model="settings" :label-width="100" ref="modalForm" :rules="ruleValidate">

        <FormItem label="属性名" prop="name" :required="true">
          <i-input v-model="settings.name" clearable placeholder="属性名，用于页面取值，如title、keywords等"></i-input>
        </FormItem>
        <FormItem label="属性类型" prop="dataType" :required="true">
          <Select v-model="settings.dataType" @on-change="handleDataTypeChange">
            <Option v-for="item in dataTypes" :value="item.dictValue" :key="item.id">{{ item.dictName }}</Option>
          </Select>
        </FormItem>
        <FormItem label="属性值" prop="value" :required="true" v-if="settings.dataType == 'text'">
          <i-input v-model="settings.value" type="textarea" :rows="4" clearable placeholder="属性值，展示在页面上的内容"></i-input>
        </FormItem>
        <FormItem label="上传图片" prop="value" :required="true" v-if="settings.dataType == 'img'">
          <upload-file v-model="settings.value"></upload-file>
        </FormItem>
        <FormItem label="上传图片" prop="value" :required="true" v-if="settings.dataType == 'richText'">
          <div class="edit_container" >
            <tinymce ref="editor" v-model="settings.value"></tinymce>
          </div>
        </FormItem>
        <FormItem label="属性描述" prop="prompt">
          <i-input v-model="settings.prompt" clearable placeholder="备注下本属性的作用，不会展示"></i-input>
        </FormItem>
        <FormItem>
          <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
          &nbsp;&nbsp;
          <Button type="text" size="large" @click="cancel">取消</Button>
        </FormItem>


      </Form>

    </Card>

  </div>
</template>

<script>
  import UploadFile from "../components/upload-file/upload-file";
  import Tinymce from "../../components/tinymce/index";
  import dictionaryApi from '@/api/dictionary'
  import siteSettingsApi from '@/api/siteSettings'
  import { mapMutations } from 'vuex'
    export default {
      name: "editSettings",
      components: {Tinymce,UploadFile},
      data(){
        return {
          settings:{
            id: 0,
            name: '',
            value: '',
            prompt: '',
            dataType: 'text',
          },
          dataTypes: [],
          loading: false,


          ruleValidate: {
            name: [
              {required: true, message: '属性名不能为空', trigger: 'blur'},
            ],
            dataType: [
              {required: true, message: '属性类型不能为空', trigger: 'blur'}
            ],
            value: [
              {required: true, message: '属性值不能为空', trigger: 'blur'}
            ],
          },
        }
      },
      created() {
        this.init();
      },

      mounted() {
        if(this.$route.query.id > 0){
          this.init(this.$route.query.id);
        }else{
          this.init(0);
        }

      },

      beforeRouteUpdate (to, from, next) {
        // 在当前路由改变，但是该组件被复用时调用
        // 举例来说，对于一个带有动态参数的路径 /foo/:id，在 /foo/1 和 /foo/2 之间跳转的时候，
        // 由于会渲染同样的 Foo 组件，因此组件实例会被复用。而这个钩子就会在这个情况下被调用。
        // 可以访问组件实例 `this`
        this.init(to.query.id);
        next();
      },

      methods: {

        ...mapMutations([
          'closeTag'
        ]),

        init(id) {
          this.loadDataTypes()
          this.loadData(id)
        },
        loadDataTypes(){
          let self = this;
          dictionaryApi.getItemsByCode('site_data_type').then(function (res) {
            let result = res.data;
            if(result.success){
              self.dataTypes = result.data == null ? [] : result.data
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadData(id){
          this.settings = {
            id: 0,
            name: '',
            value: '',
            prompt: '',
            dataType: 'text',
          }

          if(id > 0) {
            let self = this;
            siteSettingsApi.getById(id).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.settings.id = result.data.id
                self.settings.name = result.data.name
                self.settings.value = result.data.value
                self.settings.prompt = result.data.prompt
                self.settings.dataType = result.data.dataType == null ? 'text' : result.data.dataType
              } else {
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {
              self.$Message.error(error.message);
            });
          }
        },

        addOrUpdate(){
          let self = this;
          this.$refs.modalForm.validate((valid) => {
            if (valid) {
              self.loading = true;
              siteSettingsApi.addOrUpdate(this.settings).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
                  self.cancel();
                } else {
                  self.$Message.error(result.status.message);
                }
              }).catch(function (error) {
                self.$Message.error(error.message);
              });
              self.loading = false;
            } else {
              self.loading = false;
            }
          });
        },

        cancel(){
          this.$router.push({ path: '/site/extend'})
          this.closeTag({
            name: 'site_property_page'
          })
        },

        handleDataTypeChange(val){
          if(val == 'richText'){
            try {
              //这里防止第一次加载，未初始化时出错，Cannot read property 'parse' of undefined
              this.$refs.editor.setContent(this.settings.value)
            } catch (error) {
              console.warn('设置文章内容',error)
            }
          }
        }
      }
    }
</script>

<style scoped>

</style>
