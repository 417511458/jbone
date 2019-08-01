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
        <Col span="4" v-if="showSpecial">
          <h2>专题目录</h2>
          <Menu :active-name="special.toc.id" ref="specialToc" width="auto" @on-select="handleSelectToc">
            <template v-for="item in special.tree">
              <template v-if="item.children && item.children.length > 0">
                <Submenu :name="item.id" :title="item.title">
                  <template slot="title">
                    <Icon type="ios-folder" />
                    <Button type="text" @click="handleSelectToc(item.id)">{{item.title}}</Button>
                  </template>
                  <MenuItem  v-for="childItem in item.children" :name="childItem.id" style="margin-left: 20px;">
                    <Icon type="md-document" />
                    {{childItem.title}}
                  </MenuItem>
                </Submenu>
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
        <Col :span="showSpecial ? 16 : 20">
          <card :dis-hover="true" v-show="showContentCard">
            <div style="text-align: center;margin-bottom: 10px" v-if="showSpecial">
              <Button @click="addRootToc">添加根目录</Button>
              <Button @click="appendToc" style="margin-left: 10px">添加子目录</Button>

              <RadioGroup v-model="special.tocType" style="margin-left: 10px">
                <Radio label="link">
                  <span>外部链接</span>
                </Radio>
                <Radio label="article">
                  <span>内部文章</span>
                </Radio>
              </RadioGroup>
            </div>

            <div v-if="showSpecialContent">
              <Form :model="special.toc" :label-width="100" ref="tocForm" :rules="ruleValidate" v-if="showSpecial && special.tocType == 'link'">
                <FormItem label="标题" prop="title" :required="true">
                  <i-input v-model="special.toc.title" clearable placeholder="栏目标题"></i-input>
                </FormItem>

                <FormItem label="链接" prop="keywords">
                  <i-input v-model="special.toc.url" clearable placeholder="链接URL"></i-input>
                </FormItem>

                <FormItem label="打开目标" prop="type" >
                  <RadioGroup v-model="special.toc.target">
                    <Radio label="_self">当前窗口打开</Radio>
                    <Radio label="_blank">新窗口打开</Radio>
                  </RadioGroup>
                </FormItem>

                <FormItem label="排序号" prop="orders" >
                  <InputNumber v-model="special.toc.orders" clearable  placeholder="排序号"></InputNumber>
                </FormItem>

                <FormItem label="" prop="" >
                  <Button type="primary" size="large" long :loading="loading" @click="addOrUpdateToc">保存</Button>
                </FormItem>
              </Form>

              <Form :model="article" :label-width="100" ref="modalForm" :rules="ruleValidate" v-else>
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
                </FormItem>

              </Form>
            </div>

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

    export default {
      name: "edit",
      components: {UploadFile, TreeSelect, Tinymce},
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
          this.searchTags();
          this.loadArticle(id)
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

        handleSelect (name) {
          this.initSelectedCate(name);
          this.resetTocData()
          this.loadTocs()
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
                self.initSelectedCate(result.data.category.id)
              }else{
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {
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
          this.article.category.id = data.category == null ? 0 : data.category.id;
          this.article.tagIds = data.tagIds;
          this.article.articleData.content = data.articleData == null ? '' : data.articleData.content;
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
          this.article.category.id = this.categoryTree.selectedData.id;

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
                  //添加文章成功后，跳到列表页
                  if(self.article.id <= 0){
                    self.$router.push({ path: '/content/article/list'})
                    self.closeTag({
                      name: 'article_edit'
                    })
                  }
                } else {
                  self.$Message.error(result.status.message);
                }
                self.loading = false;
              }).catch(function (error) {
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
        },

        //
        //
        // 专题栏目相关 start
        //
        //
        handleSelectToc (name) {
          this.loadToc(name)
        },

        resetTocData(){
          this.special.tree = []
          this.clearToc()
          this.special.tocType = 'article'
        },


        loadTocs(){
          let type = this.categoryTree.selectedData.type;
          if(!type){
            return
          }

          if(type != 'SPECIAL'){
            return
          }

          let self = this;
          categoryTocApi.getTree(this.categoryTree.selectedData.id).then(function (res) {
            if (!res.data.success) {
              self.setTreeMessage(res.data.status.message);
            } else {
              self.special.tree = res.data.data == null ? [] : res.data.data;
            }
          }).catch(function (error) {
            self.setTreeMessage(error.message);
          });
        },

        resetTocType(){
          if(this.special.toc.article == null){
            this.special.tocType = 'link'
          }else{
            this.special.tocType = 'article'
          }
        },
        setToc(data){
          this.special.toc.id = data.id;
          if(data.article != null){
            this.setArticle(data.article);
          }else{
            this.clearArticle()
          }
          this.special.toc.target = data.target;
          this.special.toc.url = data.url;
          this.special.toc.categoryId = data.category.id;
          this.special.toc.orders = data.orders;
          this.special.toc.pid = data.pid;
          this.special.toc.title = data.title;
          this.special.initToc = false
          this.resetTocType()

        },

        clearToc(){
          this.special.toc = {
            id: 0,
            title: '',
            pid: 0,
            url: '',
            target: '_self',
            orders: 0,
            categoryId: this.categoryTree.selectedData.id,
            article: null
          }
          this.special.initToc = true
          this.resetTocType()
        },
        loadToc(id){
          this.clearToc()
          let self = this;
          categoryTocApi.getById(id).then(function (res) {
            let result = res.data;
            if (!result.success) {
              console.info("获取专题目录失败" + result.status.message);
            } else {
              self.setToc(result.data);
            }
          }).catch(function (error) {
            console.info("获取专题目录失败" + error);
          });
        },

        addOrUpdateToc(){
          if(this.special.tocType == 'article'){
            this.article.category.id = this.categoryTree.selectedData.id
            this.special.toc.article = this.article
          }else{
            this.special.toc.article = null
          }

          let self = this;
          this.$refs.tocForm.validate((valid) => {
            if (valid) {
              categoryTocApi.addOrUpdate(this.special.toc).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
                  self.loadTocs();
                  self.setToc(result.data);
                } else {
                  self.$Message.error(result.status.message);
                }
              }).catch(function (error) {
                self.$Message.error(error.message);
              });
            }
          });
        },

        appendToc () {
          let pid = this.special.toc.id
          this.clearToc();
          this.special.toc.pid = pid;
        },
        addRootToc(){
          this.clearToc();
        },
        removeToc (root, node, data) {
          console.info(data);
          let self = this;
          this.$Modal.confirm({
            title: '确定要删除这条记录吗？',
            onOk: () => {
              categoryTocApi.delete(data.id).then(function (res) {
                let result = res.data;
                if(result.success){
                  self.$Message.info('删除成功');
                  self.loadTocs();
                }else {
                  self.$Message.error('删除失败!' + result.status.message);
                }
              });
            }
          });
        },

        //
        //
        // 专题栏目相关 end
        //
        //

      }
    }
</script>

<style scoped>

</style>
