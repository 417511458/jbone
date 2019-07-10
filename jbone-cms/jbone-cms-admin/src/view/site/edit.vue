<template>
  <div>
    <Card :dis-hover="true" style="text-align: right">
      <Button type="success" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </Card>

    <Card :dis-hover="true">

      <Form :model="site" :label-width="100" ref="modalForm" :rules="ruleValidate">
        <FormItem label="网站名" prop="name" :required="true">
          <i-input v-model="site.name" clearable placeholder="网站名"></i-input>
        </FormItem>
        <FormItem label="域名" prop="domain" :required="true">
          <i-input v-model="site.domain" clearable placeholder="域名"></i-input>
        </FormItem>
        <FormItem label="域别名1" prop="alias1">
          <i-input v-model="site.alias1" clearable placeholder="域别名1"></i-input>
        </FormItem>
        <FormItem label="域别名2" prop="alias2">
          <i-input v-model="site.alias2" clearable placeholder="域别名2"></i-input>
        </FormItem>
        <FormItem label="排序号" prop="orders" :required="true">
          <InputNumber v-model="site.orders" clearable  placeholder="排序号"></InputNumber>
        </FormItem>
        <FormItem label="是否启用" prop="enable" :required="true">
          <i-switch v-model="site.enable" size="large" true-value="1" false-value="0">
            <span slot="open">启用</span>
            <span slot="close">禁用</span>
          </i-switch>
        </FormItem>
        <FormItem label="描述" prop="description">
          <Input v-model="site.description" type="textarea" :rows="4" placeholder="描述" />
        </FormItem>

        <FormItem label="模版" prop="templateId">
          <Select v-model="site.templateId">
            <Option v-for="item in templateList" :value="item.id" :key="item.id">{{ item.name }} ({{item.code}}) </Option>
          </Select>
        </FormItem>

      </Form>

    </Card>

  </div>

</template>

<script>
  import siteApi from '@/api/site'
  import templateApi from "@/api/template"
  import { mapMutations } from 'vuex'
    export default {
      name: "siteEdit",
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
          site: {
            id: 0,
            name: '',
            description: '',
            domain: '',
            alias1: '',
            alias2:'',
            pid: 0,
            orders: 0,
            templateId: 0,
            enable: '1'
          },
          queryTemplate: {
            name: '',
            code: '',
            totalRecord: 0,
            pageSize: 50,
            pageNumber: 1
          },
          templateList:[],
          loading: false,
          ruleValidate: {
            name: [
              {required: true, message: '网站名不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ],
            domain: [
              {required: true, message: '域名不能为空', trigger: 'blur'}
            ],
            orders: [
              {required: true, type:'number', message: '排序号不能为空', trigger: 'blur'}
            ]
          },
        };
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
      methods:{
        init(id){
          this.loadSite(id)
          this.loadTemplates()
        },

        ...mapMutations([
          'closeTag'
        ]),

        loadTemplates(){
          let self = this;
          templateApi.commonRequest(this.queryTemplate).then(function (res) {
            if (!res.data.success) {
              self.$Message.error(result.status.message);
            } else {
              self.templateList = res.data.data.datas == null ? [] : res.data.data.datas;
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadSite(id) {
          this.site = {
            id: 0,
            name: '',
            description: '',
            domain: '',
            pid: 0,
            orders: 0,
            templateId: 0,
            enable: '1'
          }

          if(id > 0) {
            let self = this;
            siteApi.getById(id).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.site.id = result.data.id;
                self.site.name = result.data.name;
                self.site.description = result.data.description;
                self.site.domain = result.data.domain;
                self.site.pid = result.data.pid;
                self.site.orders = result.data.orders;
                self.site.templateId = result.data.templateId;
                self.site.enable = result.data.enable + '';
                self.site.alias1 = result.data.alias1;
                self.site.alias2 = result.data.alias2;
              } else {
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {
              self.$Message.error(error.message);
            });
          }
        },

        addOrUpdate() {
          let self = this;
          this.$refs.modalForm.validate((valid) => {
            if (valid) {
              siteApi.addOrUpdate(this.site).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
                  //操作成功后，跳到列表页
                  if(self.site.id <= 0){
                    self.closeMe();
                  }
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

        closeMe(){
          this.$router.push({ path: '/base/site/list'})
          this.closeTag({
            name: 'site_edit'
          })
        }
      }
    }
</script>

<style scoped>

</style>
