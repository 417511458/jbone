<template>
  <div>
    <card :dis-hover="true">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        编辑文章
      </p>
        <Form :model="article" :label-width="100" ref="modalForm" :rules="ruleValidate">
          <FormItem :label="titleLabel" prop="title" :required="true">
            <i-input v-model="article.title" clearable :placeholder="titleLabel"></i-input>
          </FormItem>

          <FormItem label="关键字" prop="keywords" v-if="keywordsShow">
            <i-input v-model="article.keywords" clearable placeholder="关键字"></i-input>
          </FormItem>

          <FormItem label="说明" prop="description">
            <i-input v-model="article.description" clearable placeholder="说明"></i-input>
          </FormItem>

          <FormItem label="标签" v-show="showTag">
            <Row>
              <Col span="6">
                <Select v-model="article.tagIds" filterable multiple>
                  <Option v-for="tag in tags" :value="tag.id" :key="tag.id">{{ tag.name }}</Option>
                </Select>
              </Col>

              <Col span="2" style="text-align: center">评论设置:</Col>
              <Col span="6">
                <RadioGroup v-model="article.allowComment" type="button">
                  <Radio label="TRUE">允许评论</Radio>
                  <Radio label="FALSE">关闭评论</Radio>
                </RadioGroup>
              </Col>

            </Row>
          </FormItem>
          <FormItem label="内容" prop="articleData.content" v-show="showEditor">
            <div class="edit_container" >
              <tinymce ref="editor" v-model="article.articleData.content"></tinymce>
            </div>
          </FormItem>
          <FormItem :label="frontCoverLabel" prop="frontCover">
            <upload-file v-model="article.frontCover"></upload-file>
          </FormItem>
          <FormItem>
            <Button type="primary" size="large" :loading="loading" @click="addOrUpdate('PUBLISH')">发表</Button>
            &nbsp;&nbsp;
            <Button type="success" size="large" :loading="loading" @click="addOrUpdate('AUDIT')">保存</Button>
            &nbsp;&nbsp;
            <Button type="info" size="large" :loading="loading" @click="cancel">取消</Button>
          </FormItem>

        </Form>
    </Card>

  </div>
</template>

<script>
    import Tinymce from "../../components/tinymce/index";
    import categoryApi from '@/api/category'
    import articleApi from '@/api/article'
    import tagApi from '@/api/tag'
    import TreeSelect from "../../components/tree-select/tree-select";
    import { mapMutations } from 'vuex'
    import siteApi from '@/api/site'
    import UploadFile from "../components/upload-file/upload-file";
    import categoryTocApi from '@/api/categoryToc'

    export default {
      name: "articleEdit",
      components: {UploadFile, TreeSelect, Tinymce},
      props:{
        articleId: {
          type: Number,
          default: 0
        },
        categoryId:{
          type: Number,
          default: 0
        },
        categoryType:{
          type: String,
          default: ''
        }

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
          article: {
            id: 0,
            title: '',
            frontCover: '',
            keywords: '',
            orders: 0,
            description: '',
            status: 'PUBLISH',
            allowComment: 'TRUE',
            category:{
              id: 0
            },
            tagIds: [],
            articleData:{
              content: ''
            }
          },
          tags: [],
          ruleValidate: {
            title: [
              {required: true, message: '标题不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ]
          },
          loading:false,
          showFrontCover:false
        }
      },
      computed:{
        titleLabel(){
          let title = '文章标题'
          if(this.categoryType == 'CATEGORY'){
            title = '文章标题'
          }else if(this.categoryType == 'IMG'){
            title = '图片标题'
          }else if(this.categoryType == 'PRODUCT'){
            title = '产品名称'
          }else if(this.categoryType == 'NEWS'){
            title = '新闻标题'
          }
          return title
        },
        frontCoverLabel(){
          let title = '封面图'
          if(this.categoryType == 'IMG'){
            title = '图片'
          }
          return title
        },

        keywordsShow(){
          let show = true
          if(this.categoryType == 'IMG'){
            show = false
          }
          return show
        },

        showTag(){
          let show = true
          if(this.categoryType == 'CATEGORY'){
            show = true
          }else if(this.categoryType == 'IMG'){
            show = false
          }else if(this.categoryType == 'PRODUCT'){
            show = true
          }else if(this.categoryType == 'NEWS'){
            show = true
          }

          return show
        },

        showEditor(){
          let show = true
          if(this.categoryType == 'IMG'){
            show = false
          }

          return show
        },

      },

      beforeRouteUpdate (to, from, next) {
        // 在当前路由改变，但是该组件被复用时调用
        // 举例来说，对于一个带有动态参数的路径 /foo/:id，在 /foo/1 和 /foo/2 之间跳转的时候，
        // 由于会渲染同样的 Foo 组件，因此组件实例会被复用。而这个钩子就会在这个情况下被调用。
        // 可以访问组件实例 `this`
        this.init(to.query.id);
        next();
      },

      mounted() {
        if(this.articleId > 0){
          this.init(this.articleId);
        }else{
          this.init(0);
        }
      },

      watch: {
        articleId(val){
          this.init(val)
        }
      },

      methods: {

        init(id){
          // 加载栏目树
          this.searchTags();
          this.loadArticle(id)
        },

        ...mapMutations([
          'closeTag'
        ]),
        searchTags(){
          let self = this;
          tagApi.getAll().then(function (res) {
            if (res.data.success) {
              self.tags = res.data.data;
            }
          }).catch(function (error) {
            console.error("加载标签失败!" + error.message)
          });
        },


        loadArticle(id) {
          if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
            this.$Message.error('请选择站点');
            return
          }

          this.clearArticle()

          if(id > 0){
            let self = this;
            articleApi.getById(id).then(function (res) {
              let result = res.data;
              if(result.success){
                self.setArticle(result.data)
              }else{
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {

              console.error(error)
              self.$Message.error(error.message);
            });
          }

        },

        setArticle(data){
          if(data == null){
            return
          }
          this.article.id = data.id;
          this.article.title = data.title;
          this.article.frontCover = data.frontCover;
          this.article.keywords = data.keywords;
          this.article.orders = data.orders;
          this.article.description = data.description;
          this.article.status = data.status;
          this.article.allowComment = data.allowComment;
          this.article.tagIds = data.tagIds;
          this.article.articleData.content = data.articleData == null ? '' : data.articleData.content;
          try {
            //这里防止第一次加载，未初始化时出错，Cannot read property 'parse' of undefined
            this.$refs.editor.setContent(this.article.articleData.content)
          } catch (error) {
            console.warn('设置文章内容',error)
          }

        },

        setTreeMessage(message) {
          this.categoryTree.operation.success = false;
          this.categoryTree.operation.message = message;
        },

        addOrUpdate(status) {
          if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
            this.$Message.error('请选择站点');
            return
          }

          this.article.status = status;
          this.article.category.id = this.categoryId;

          if(!this.article.category.id){
            this.$Message.error("请选择文章栏目");
            return;
          }

          console.info(this.article)
          this.loading = true;
          let self = this;
          this.$refs.modalForm.validate((valid) => {
            if (valid) {
              articleApi.addOrUpdate(this.article).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("发表成功");
                  self.$emit('success');
                } else {
                  self.$Message.error(result.status.message);
                }
                self.loading = false;
              }).catch(function (error) {
                console.error(error)
                self.$Message.error(error.message);
                self.loading = false;
              });
            } else {
              self.loading = false;
            }
          })
        },

        clearArticle(){
          this.article ={
            id: 0,
            title: '',
            frontCover: '',
            keywords: '',
            orders: 0,
            description: '',
            status: 'PUBLISH',
            allowComment: 'TRUE',
            category:{
              id: 0
            },
            tagIds: [],
            articleData:{
              content: ''
            }
          }
          try {
            //这里防止第一次加载，未初始化时出错，Cannot read property 'parse' of undefined
            this.$refs.editor.setContent('')
          } catch (error) {
            console.warn('设置文章内容',error)
          }
        },

        cancel(){
          this.$emit('cancel');
        }
      }
    }
</script>

<style scoped>

</style>
