<template>
  <div>

    <card :dis-hover="true">
      <Row>
        <Col span="4">
          <h2>{{categoryTitle}}</h2>
          <Menu :active-name="categoryTree.selectedData.id" ref="menu" width="auto" @on-select="handleSelect">
            <template v-for="item in categoryTree.data">
              <template v-if="item.children && item.children.length > 0">
                <MenuGroup :name="item.id" :title="item.title">
                  <MenuItem  v-for="childItem in item.children" :name="childItem.id" style="margin-left: 20px;">
                    <Icon type="md-document" />
                    {{childItem.title}}
                  </MenuItem>
                </MenuGroup>
              </template>
              <template v-else>
                <MenuItem :name="item.id">
                  <Icon type="md-document" />
                  {{item.title}}
                </MenuItem>
              </template>
            </template>
          </Menu>
        </Col>

        <Col :span="20">
          <card :dis-hover="true" v-show="showContentCard">


            <article-edit v-if="showArticleEdit" :category-id="categoryTree.selectedData.id" :category-type="categoryTree.selectedData.type" :article-id="articleId" @success="editArticleSuccess" @cancel="hideArticle"></article-edit>
            <br />
            <article-list v-if="showArticleList" :category-id="categoryTree.selectedData.id" @addArticle="toAddArticle" @editArticle="toEditArticle"></article-list>
            <special v-if="showSpecial" :category-id="categoryTree.selectedData.id" :category-type="categoryTree.selectedData.type"></special>
          </Card>
        </Col>
      </Row>
    </card>
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
    import ArticleList from "./list";
    import Special from "./special";
    import ArticleEdit from "./edit";

    export default {
      name: "manager",
      components: {ArticleEdit, Special, ArticleList, UploadFile, TreeSelect, Tinymce},
      props:{
        id: {
          type: Number,
          default: 0
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
          showArticleEdit: false,
          articleId : 0,
          tags: [],
          ruleValidate: {
            title: [
              {required: true, message: '标题不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ]
          },
          categoryTree: {
            data: [],
            selectedData: {},
            operation: {
              success: true,
              message: ""
            }
          },
          special:{
            tree:[],
            toc:{
              id: 0,
              title: '',
              pid: 0,
              url: '',
              target: '_self',
              orders: 0,
              categoryId:0,
              article: null
            },
            initToc:true,
            tocType:'article'
          },
          loading:false,
          showFrontCover:false
        }
      },
      computed:{
        categoryTitle(){

          let title = this.categoryTree.selectedData.title;
          if(title){
            return '所属栏目(' + title + ')'
          }else{
            return '所属栏目'
          }

        },
        titleLabel(){
          let title = '文章标题'
          if(this.categoryTree.selectedData){
            let type = this.categoryTree.selectedData.type;
            if(type){
              if(type == 'CATEGORY'){
                title = '文章标题'
              }else if(type == 'IMG'){
                title = '图片标题'
              }else if(type == 'PRODUCT'){
                title = '产品名称'
              }else if(type == 'NEWS'){
                title = '新闻标题'
              }
            }
          }
          return title
        },
        frontCoverLabel(){
          let title = '封面图'
          if(this.categoryTree.selectedData){
            let type = this.categoryTree.selectedData.type;
            if(type){
              if(type == 'IMG'){
                title = '图片'
              }
            }
          }
          return title
        },

        keywordsShow(){
          let show = true
          if(this.categoryTree.selectedData){
            let type = this.categoryTree.selectedData.type;
            if(type){
              if(type == 'IMG'){
                show = false
              }
            }
          }
          return show
        },

        showContentCard(){
          let show = true
          let type = this.categoryTree.selectedData.type;
          if(!type){
            return false
          }

          if(type == 'TAG'){
            show = false
          }

          return show
        },

        showArticleList(){
          let show = false
          let type = this.categoryTree.selectedData.type;
          if(!type){
            return false
          }
          if(type == 'CATEGORY'){
            show = true
          }else if(type == 'IMG'){
            show = true
          }else if(type == 'PRODUCT'){
            show = true
          }else if(type == 'NEWS'){
            show = true
          }

          return show

        },

        showTag(){
          let show = true
          let type = this.categoryTree.selectedData.type;
          if(!type){
            return false
          }

          if(type == 'CATEGORY'){
            show = true
          }else if(type == 'IMG'){
            show = false
          }else if(type == 'PRODUCT'){
            show = true
          }else if(type == 'NEWS'){
            show = true
          }

          return show
        },

        showEditor(){
          let show = true
          let type = this.categoryTree.selectedData.type;
          if(!type){
            return false
          }

          if(type == 'IMG'){
            show = false
          }

          return show
        },

        showSpecial(){
          let show = false
          let type = this.categoryTree.selectedData.type;
          if(!type){
            return false
          }

          if(type == 'SPECIAL'){
            show = true
          }

          return show
        },

        showSpecialContent(){
          return !this.initToc
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
        if(this.$route.query.id > 0){
          this.init(this.$route.query.id);
        }else{
          this.init(0);
        }
      },

      methods: {

        init(id){
          // 加载栏目树
          this.searchCategoryTree();
        },

        ...mapMutations([
          'closeTag'
        ]),
        searchCategoryTree(){
          let self = this;
          categoryApi.getCategoryTree().then(function (res) {
            if (!res.data.success) {
              self.setTreeMessage(res.data.status.message);
            } else {
              self.categoryTree.data = res.data.data == null ? [] : res.data.data;
              self.initSelectedCate(self.article.category.id)
            }
          }).catch(function (error) {
            self.setTreeMessage(error.message);
          });
        },

        handleSelect (name) {
          this.initSelectedCate(name);
          this.hideArticle()
        },

        initSelectedCate(id){
          if(id && this.categoryTree.data.length > 0){
            let self = this;
            this.categoryTree.data.forEach(function(item, index, arr) {
              let children = item.children;
              if(children && children.length > 0){
                children.forEach(function(childItem, index, arr) {
                  if(id == childItem.id){
                    self.categoryTree.selectedData = childItem;
                  }
                })
              }

              if(id == item.id){
                self.categoryTree.selectedData = item;
              }

            });
          }
          console.log(this.categoryTree.selectedData)
        },

        hideArticle(){
          this.showArticleEdit = false
        },

        showArticle(){
          this.showArticleEdit = true
        },
        toAddArticle(){
          this.articleId = 0
          this.showArticle()
        },

        toEditArticle(id){
          this.articleId = id
          this.showArticle()
        },

        editArticleSuccess(){
          this.hideArticle()

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
          this.article.category.id = data.category == null ? 0 : data.category.id;
          this.article.tagIds = data.tagIds;
          this.article.articleData.content = data.articleData == null ? '' : data.articleData.content;
        },

        setTreeMessage(message) {
          this.categoryTree.operation.success = false;
          this.categoryTree.operation.message = message;
        },





      }
    }
</script>

<style scoped>

</style>
