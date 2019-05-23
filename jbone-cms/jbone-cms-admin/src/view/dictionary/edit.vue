<template>
  <div>
    <card :dis-hover="true" style="text-align: right">
        <Button type="primary" size="large" :loading="loading" @click="addOrUpdate('PUBLISH')">发表</Button>
        &nbsp;&nbsp;
        <Button type="success" size="large" :loading="loading" @click="addOrUpdate('AUDIT')">保存</Button>
    </card>
    <Card :dis-hover="true">
      <Form :model="article" :label-width="100" ref="modalForm" :rules="ruleValidate">
        <FormItem label="文章标题" prop="title" :required="true">
          <i-input v-model="article.title" clearable placeholder="栏目标题"></i-input>
        </FormItem>

        <FormItem label="关键字" prop="keywords">
          <i-input v-model="article.keywords" clearable placeholder="关键字"></i-input>
        </FormItem>

        <FormItem label="说明" prop="description" >
          <i-input v-model="article.description" clearable placeholder="说明"></i-input>
        </FormItem>

        <FormItem label="所属栏目">
          <Row>
            <Col span="6">
              <tree-select :data="categoryTree.data" v-model="categoryTree.selectedData" :expand-all="true" check-strictly></tree-select>
            </Col>

            <Col span="2" style="text-align: center">文章标签:</Col>
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
        <FormItem label="文章内容" prop="articleData.content" >
          <div class="edit_container" >
            <tinymce ref="editor" v-model="article.articleData.content"></tinymce>
          </div>
        </FormItem>
        <FormItem label="封面图" prop="frontCover" >
          <Row>
            <Col span="2" v-show="article.frontCover" style="width: 58px;height:58px;line-height: 58px;margin-right: 10px">
              <img :src="article.frontCover" style="width: 58px;height:58px;" />
            </Col>
            <Col span="2" style="width: 58px;height:58px;line-height: 58px;margin-right: 10px">
              <Upload
                multiple
                type="drag"
                action="//jsonplaceholder.typicode.com/posts/"
                :on-success="handleUploadSuccess"
                :before-upload="handleBeforeUpload"
              >
                <div style="width: 58px;height:58px;line-height: 58px;">
                  <Icon type="ios-camera" size="20"></Icon>
                </div>
              </Upload>
            </Col>

            <Col span="10">
              <Button @click="handleShowFrontCover" type="text">输入图片地址</Button>
              <i-input v-show="showFrontCover" v-model="article.frontCover" clearable placeholder="封面图"></i-input>
            </Col>

          </Row>


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

    export default {
      name: "editDictionaryGroup",
      components: {TreeSelect, Tinymce},
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
            selectedData: [],
            operation: {
              success: true,
              message: ""
            }
          },
          loading:false,
          showFrontCover:false
        }
      },
      computed:{
        title(){
          return this.id > 0 ? '编辑文章' : '新增文章'
        }
      },

      mounted() {
        this.init();
      },

      methods: {

        init(){
          // 加载栏目树
          this.searchCategoryTree();
          this.searchTags();
          this.loadArticle()
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
              self.categoryTree.data = res.data.data;
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

        loadArticle() {
          if(this.$route.query.id > 0){
            let self = this;
            articleApi.getById(this.$route.query.id).then(function (res) {
              let result = res.data;
              if(result.success){
                self.article.id = result.data.id;
                self.article.title = result.data.title;
                self.article.frontCover = result.data.frontCover;
                self.article.keywords = result.data.keywords;
                self.article.orders = result.data.orders;
                self.article.description = result.data.description;
                self.article.status = result.data.status;
                self.article.allowComment = result.data.allowComment;
                self.article.category.id = result.data.category.id;
                self.article.tagIds = result.data.tagIds;
                self.article.articleData.content = result.data.articleData.content;
                self.categoryTree.selectedData = [result.data.category.id];
              }else{
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {
              self.$Message.error(error.message);
            });
          }

        },
        setTreeMessage(message) {
          this.categoryTree.operation.success = false;
          this.categoryTree.operation.message = message;
        },
        addOrUpdate(status) {
          if(this.categoryTree.selectedData.length <= 0){
            this.$Message.error("请选择文章栏目");
            return;
          }
          if(this.categoryTree.selectedData.length > 1){
            this.$Message.error("只能选择一个栏目");
            return;
          }
          this.article.status = status;
          this.article.category.id = this.categoryTree.selectedData[0]

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

        handleUploadSuccess(response, file, fileList){
          console.info(response)
          console.info(file)
          console.info(fileList)
        },

        handleBeforeUpload(file){
          let reader = new FileReader()
          let self = this;
          reader.readAsDataURL(file)
          reader.onload = e => {
            let _file = e.target.result
            self.article.frontCover = _file
            console.info(_file)
          }
          return false
        },

        handleShowFrontCover(){
          this.showFrontCover = this.showFrontCover ? false : true
        }


      }
    }
</script>

<style scoped>

</style>
