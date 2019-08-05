<template>
  <div>
      <Row>
        <Col span="6">
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
        <Col :span="18" v-if="special.showContentCard">
          <card :dis-hover="true">
            <div style="text-align: center;margin-bottom: 10px">
              <Button @click="addRootToc">添加根目录</Button>
              <Button @click="appendToc" style="margin-left: 10px">添加子目录</Button>
              <Button @click="removeToc" style="margin-left: 10px">删除当前目录</Button>
            </div>

              <Form :model="special.toc" :label-width="100" ref="tocForm" :rules="ruleValidate">
                <FormItem label="标题" prop="title" :required="true">
                  <i-input v-model="special.toc.title" clearable placeholder="栏目标题"></i-input>
                </FormItem>


                <FormItem label="类型" prop="type" :required="true">
                  <RadioGroup v-model="special.toc.type">
                    <Radio label="inner">
                      <span>内部文章</span>
                    </Radio>
                    <Radio label="outer">
                      <span>外部链接</span>
                    </Radio>
                  </RadioGroup>
                </FormItem>


                <FormItem label="链接" prop="url" v-show="showLink">
                  <i-input v-model="special.toc.url" clearable placeholder="链接URL"></i-input>
                </FormItem>

                <FormItem label="打开目标" prop="target" v-show="showTarget" >
                  <RadioGroup v-model="special.toc.target">
                    <Radio label="_self">当前窗口打开</Radio>
                    <Radio label="_blank">新窗口打开</Radio>
                  </RadioGroup>
                </FormItem>

                <FormItem label="排序号" prop="orders" >
                  <InputNumber v-model="special.toc.orders" clearable  placeholder="排序号"></InputNumber>
                </FormItem>

                <FormItem label="关键字" prop="article.keywords" v-show="showKeywords">
                  <i-input v-model="special.toc.article.keywords" clearable placeholder="关键字,用逗号或空格隔开"></i-input>
                </FormItem>

                <FormItem label="说明" prop="article.description" v-show="showDescription">
                  <i-input v-model="special.toc.article.description" clearable placeholder="说明"></i-input>
                </FormItem>
                <FormItem label="标签" v-show="showTag">
                  <Row>
                    <Col span="6">
                      <Select v-model="special.toc.article.tagIds" filterable multiple>
                        <Option v-for="tag in tags" :value="tag.id" :key="tag.id">{{ tag.name }}</Option>
                      </Select>
                    </Col>

                    <Col span="2" style="text-align: center">评论设置:</Col>
                    <Col span="6">
                      <RadioGroup v-model="special.toc.article.allowComment" type="button">
                        <Radio label="TRUE">允许评论</Radio>
                        <Radio label="FALSE">关闭评论</Radio>
                      </RadioGroup>
                    </Col>

                  </Row>
                </FormItem>
                <FormItem label="内容" prop="article.articleData.content" v-show="showContent">
                  <div class="edit_container" >
                    <tinymce ref="editor" v-model="special.toc.article.articleData.content"></tinymce>
                  </div>
                </FormItem>
                <FormItem label="封面图" prop="article.frontCover" v-show="showFrontCover">
                  <upload-file v-model="special.toc.article.frontCover"></upload-file>
                </FormItem>
                <FormItem>
                  <Button type="primary" size="large" :loading="loading" @click="addOrUpdateToc">发表</Button>
                </FormItem>

              </Form>

          </Card>
        </Col>
      </Row>
  </div>
</template>

<script>
    import Tinymce from "../../components/tinymce/index";
    import tagApi from '@/api/tag'
    import TreeSelect from "../../components/tree-select/tree-select";
    import { mapMutations } from 'vuex'
    import siteApi from '@/api/site'
    import UploadFile from "../components/upload-file/upload-file";
    import categoryTocApi from '@/api/categoryToc'
    import { getUserId } from '@/libs/util'

    export default {
      name: "special",
      components: {UploadFile, TreeSelect, Tinymce},
      props:{
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
          tags: [],
          ruleValidate: {
            title: [
              {required: true, message: '标题不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ]
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
              type: 'inner',
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
              }
            },
            showContentCard:true,
          },
          loading:false,
        }
      },
      computed:{
        showLink(){
          if(this.special.toc.type == 'inner'){
            return false
          }
          return true
        },

        showTarget(){
          if(this.special.toc.type == 'inner'){
            return false
          }
          return true
        },

        showKeywords(){
          if(this.special.toc.type == 'inner'){
            return true
          }
          return false
        },

        showDescription(){
          if(this.special.toc.type == 'inner'){
            return true
          }
          return false
        },

        showTag(){
          if(this.special.toc.type == 'inner'){
            return true
          }
          return false
        },

        showContent(){
          if(this.special.toc.type == 'inner'){
            return true
          }
          return false
        },

        showFrontCover(){
          if(this.special.toc.type == 'inner'){
            return true
          }
          return false
        }
      },

      watch:{
        categoryId(val){
          this.init();
        }
      },
      mounted() {
        this.init();
      },

      methods: {

        init(){
          // 加载栏目树
          this.searchTags();
          this.loadTocs()
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



        setArticle(data){
          if(data == null){
            this.clearArticle()
            return
          }
          this.special.toc.article.id = data.id;
          this.special.toc.article.title = data.title;
          this.special.toc.article.frontCover = data.frontCover;
          this.special.toc.article.keywords = data.keywords;
          this.special.toc.article.orders = data.orders;
          this.special.toc.article.description = data.description;
          this.special.toc.article.status = data.status;
          this.special.toc.article.allowComment = data.allowComment;
          this.special.toc.article.tagIds = data.tagIds;
          this.special.toc.article.articleData.content = data.articleData == null ? '' : data.articleData.content;
          try {
            //这里防止第一次加载，未初始化时出错，Cannot read property 'parse' of undefined
            this.$refs.editor.setContent(this.special.toc.article.articleData.content)
          } catch (error) {
            console.warn('设置文章内容',error)
          }
        },

        clearArticle(){
          this.special.toc.article = {
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
            this.$refs.editor.setContent(this.special.toc.article.articleData.content)
          } catch (error) {
            console.warn('设置文章内容',error)
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
        },


        loadTocs(){
          let type = this.categoryType;
          if(!type){
            return
          }

          if(type != 'SPECIAL'){
            return
          }

          let self = this;
          categoryTocApi.getTree(this.categoryId).then(function (res) {
            if (!res.data.success) {
              self.$Message.error(res.data.status.message);
            } else {
              self.special.tree = res.data.data == null ? [] : res.data.data;
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        setToc(data){
          this.special.toc.id = data.id;
          this.special.toc.article = data.article;
          this.special.toc.target = data.target;
          this.special.toc.url = data.url;
          this.special.toc.categoryId = data.category.id;
          this.special.toc.orders = data.orders;
          this.special.toc.pid = data.pid;
          this.special.toc.title = data.title;
          this.special.toc.type = data.type;
          this.setArticle(data.article);
        },

        clearToc(){
          this.special.toc = {
            id: 0,
            title: '',
            pid: 0,
            url: '',
            target: '_self',
            type : 'inner',
            orders: 0,
            categoryId: this.categoryId,
          }
          this.clearArticle()
        },
        loadToc(id){
          this.special.showContentCard = false
          this.clearToc()
          let self = this;
          categoryTocApi.getById(id).then(function (res) {
            let result = res.data;
            if (!result.success) {
              console.info("获取专题目录失败" + result.status.message);
            } else {
              self.setToc(result.data);
              self.special.showContentCard = true
            }
          }).catch(function (error) {
            console.info("获取专题目录失败" + error);
          });
        },

        addOrUpdateToc(){
          this.special.toc.article.category = {id: this.categoryId}
          this.special.toc.article.creator = getUserId();
          this.special.toc.article.siteId = siteApi.getCurrentSiteID()
          this.special.toc.categoryId = this.categoryId

          //如果是外部文章，则不发表
          if(this.special.toc.type == 'outer'){
            this.special.toc.article.status = 'AUDIT'
          }

          let self = this;
          this.$refs.tocForm.validate((valid) => {
            if (valid) {
              categoryTocApi.addOrUpdate(this.special.toc).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
                  self.loadTocs();
                  self.clearToc()
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
        removeToc () {

          if(this.special.toc.id <= 0){
            this.$Message.info('请选择目录');
            return
          }
          let self = this;
          this.$Modal.confirm({
            title: '确定要删除这条记录吗？',
            onOk: () => {
              categoryTocApi.delete(this.special.toc.id).then(function (res) {
                let result = res.data;
                if(result.success){
                  self.$Message.info('删除成功');
                  self.loadTocs();
                  self.clearToc()
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
