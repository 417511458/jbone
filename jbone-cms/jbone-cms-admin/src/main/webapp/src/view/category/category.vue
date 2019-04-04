<template>
  <div>
    <card>
      <Button type="primary" icon="ios-add" @click="toAddModel(0)">添加</Button>
      <Button type="primary" icon="ios-search" @click="search" style="margin-left: 10px">刷新</Button>
    </card>

    <card v-if="table.operation.success">
      <p slot="title">
        <Icon type="ios-film-outline"></Icon>
        所有栏目
      </p>
      <tree-table expand-key="title" :show-index="true" :expand-type="false" :selectable="false" :columns="table.columns" :data="table.data" >
        <template slot="handle" slot-scope="scope">
          <Button @click="toEditModel(scope.row.id)" type="primary" size="small">编辑</Button>
          <Button @click="toAddModel(scope.row.id)" type="primary" size="small" style="margin-left: 5px">添加下级栏目</Button>
          <Button @click="handleDelete(scope.row.id)" type="error" size="small" style="margin-left: 5px">删除</Button>
          <Button @click="handleEditSpecial(scope.row.id,scope.row.title)" type="error" size="small" style="margin-left: 5px" v-if="scope.row.type == 'SPECIAL'">编辑专题</Button>
          <Button @click="handleEditTag(scope.row.id,scope.row.title)" type="error" size="small" style="margin-left: 5px" v-if="scope.row.type == 'TAG'">编辑标签</Button>
        </template>
        <template slot="type" slot-scope="scope">
          <span v-if="scope.row.type == 'CATEGORY'">普通栏目</span>
          <span v-if="scope.row.type == 'TAG'">标签聚合栏目</span>
          <span v-if="scope.row.type == 'SPECIAL'">专题栏目</span>
        </template>
      </tree-table>
    </card>
    <card v-else>
      {{table.operation.message}}
    </card>

    <Modal :title="title" v-model="modal.showModal" :mask-closable="false">

      <p slot="header">
        <Icon type="ios-information-circle"></Icon>
        <span> {{ modal.title }}</span>
      </p>
      <Form :model="modal.data" :label-width="100" ref="modalForm" :rules="ruleValidate">
        <FormItem label="栏目标题" prop="title" :required="true">
          <i-input v-model="modal.data.title" clearable placeholder="栏目标题"></i-input>
        </FormItem>

        <FormItem label="关键字" prop="keywords">
          <i-input v-model="modal.data.keywords" clearable placeholder="关键字"></i-input>
        </FormItem>

        <FormItem label="说明" prop="description" >
          <i-input v-model="modal.data.description" clearable placeholder="说明"></i-input>
        </FormItem>

        <FormItem label="类型" prop="type" >
          <RadioGroup v-model="modal.data.type" type="button">
            <Radio label="CATEGORY">普通栏目</Radio>
            <Radio label="TAG">标签聚合栏目</Radio>
            <Radio label="SPECIAL">专题栏目</Radio>
          </RadioGroup>
        </FormItem>

        <FormItem label="是否展示在导航" prop="inMenu"  >
          <RadioGroup v-model="modal.data.inMenu" type="button">
            <Radio label="TRUE">是</Radio>
            <Radio label="FALSE">否</Radio>
          </RadioGroup>
        </FormItem>

        <FormItem label="展示方式" prop="inMenu"  >
          <RadioGroup v-model="modal.data.showType" type="button">
            <Radio label="LIST">列表展示</Radio>
            <Radio label="FIRSTARTICLE">展示第一篇文章</Radio>
          </RadioGroup>
        </FormItem>

        <FormItem label="状态" prop="status" >
          <RadioGroup v-model="modal.data.status" type="button">
            <Radio label="PUBLISH">发布</Radio>
            <Radio label="AUDIT">待审核</Radio>
          </RadioGroup>
        </FormItem>

        <FormItem label="排序号" prop="orders" >
          <InputNumber v-model="modal.data.orders" clearable  placeholder="排序号"></InputNumber>
        </FormItem>

        <FormItem label="封面图" prop="frontCover" >
          <i-input v-model="modal.data.frontCover" clearable  placeholder="封面图"></i-input>
        </FormItem>

        <FormItem label="栏目链接" prop="url" >
          <i-input v-model="modal.data.url" clearable  placeholder="栏目链接"></i-input>
        </FormItem>

        <FormItem label="跳转目标" prop="target">
          <RadioGroup v-model="modal.data.target" type="button">
            <Radio label="_self">当前页</Radio>
            <Radio label="_blank">新标签页</Radio>
          </RadioGroup>
        </FormItem>

      </Form>
      <div slot="footer">
        <Button type="primary" size="large" long :loading="loading" @click="addOrUpdate">保存</Button>
      </div>
    </Modal>



    <Modal :title="title" v-model="specialModal.showModal" :mask-closable="false" width="650">

      <p slot="header">
        <Icon type="ios-information-circle"></Icon>
        <span> 编辑专题 【{{specialModal.title}}】</span>
      </p>
      <div>
        <Row>
          <Col span="12">
            <card>
              <p slot="title">
                <Icon type="ios-film-outline"></Icon>
                专题目录
              </p>
              <Button href="#" slot="extra" @click="addRootToc" size="small">
                <Icon type="ios-add"></Icon>
              </Button>
              <Tree :data="specialModal.data.tocTree" @on-select-change="handleCategoryChanged" :render="renderContent"></Tree>
            </card>
          </Col>
          <Col span="12">
            <card v-if="specialModal.showDetail">
              <p slot="title">
                <Icon type="ios-film-outline"></Icon>
                目录详情
              </p>
              <Form :model="specialModal.data.toc" :label-width="100" ref="tocForm" :rules="ruleValidate">
                <FormItem label="标题" prop="title" :required="true">
                  <i-input v-model="specialModal.data.toc.title" clearable placeholder="栏目标题"></i-input>
                </FormItem>

                <FormItem label="链接" prop="keywords">
                  <i-input v-model="specialModal.data.toc.url" clearable placeholder="链接URL"></i-input>
                </FormItem>

                <FormItem label="打开目标" prop="type" >
                  <RadioGroup v-model="specialModal.data.toc.target">
                    <Radio label="_self">当前窗口打开</Radio>
                    <Radio label="_blank">新窗口打开</Radio>
                  </RadioGroup>
                </FormItem>


                <FormItem label="排序号" prop="orders" >
                  <InputNumber v-model="specialModal.data.toc.orders" clearable  placeholder="排序号"></InputNumber>
                </FormItem>

                <FormItem label="链接文章" prop="url" >
                  <Select v-model="specialModal.data.toc.article.id" filterable remote
                          :remote-method="loadArticles">
                    <Option v-for="article in specialModal.data.articles" :value="article.id" :key="article.title">{{ article.title }}</Option>
                  </Select>
                </FormItem>

                <FormItem label="" prop="" >
                  <Button type="primary" size="large" long :loading="loading" @click="addOrUpdateToc">保存</Button>
                </FormItem>
              </Form>
            </card>
          </Col>
        </Row>
      </div>
      <div slot="footer">
      </div>
    </Modal>


    <Modal :title="title" v-model="tagModal.showModal" :mask-closable="false" width="650">

      <p slot="header">
        <Icon type="ios-information-circle"></Icon>
        <span> 编辑专题标签 【{{tagModal.title}}】</span>
      </p>
      <div class="drag-box-card">
            <!-- 切记设置list1和list2属性时，一定要添加.sync修饰符 -->
            <drag-list :list1.sync="tagModal.data.tagList" :list2.sync="tagModal.data.selectedTagList" :dropConClass="tagModal.dropConClass" @on-change="handleDragChange">
              <h3 slot="left-title">所有标签</h3>
              <Card class="drag-item" slot="left" slot-scope="left">{{ left.itemLeft.name }}</Card>
              <h3 slot="right-title">已选中标签</h3>
              <Card class="drag-item" slot="right" slot-scope="right">{{ right.itemRight.name }}</Card>
            </drag-list>

          </div>
      <div slot="footer">
        <Button type="primary" size="large" long :loading="loading" @click="updateTag">保存</Button>
      </div>
    </Modal>


  </div>
</template>
<script>
  import Tree from "iview/src/components/tree/tree"
  import categoryApi from '@/api/category'
  import categoryTocApi from '@/api/categoryToc'
  import articleApi from '@/api/article'
  import tagApi from '@/api/tag'
  import InputNumber from "iview/src/components/input-number/input-number";
  import DragList from '_c/drag-list'

  export default {
    components: {InputNumber,Tree,DragList},
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

        table: {
          loading: false,
          columns: [
            {
              title: '栏目标题',
              key: 'title',
            },
            {
              title: '关键字',
              key: 'keywords',
            },
            {
              title: '栏目类型',
              // key: 'type',
              minWidth: '200px',
              type: 'template',
              template: 'type'
            },
            {
              title: '排序号',
              key: 'orders',
            },
            {
              title: '操作',
              minWidth: '200px',
              type: 'template',
              template: 'handle'
            }
          ],
          data: [],
          operation: {
            success: true,
            message: ""
          }
        },

        modal:{
          title: '',
          showModal: false,
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
            inMenu: 'FALSE',
            status: 'PUBLISH',
            showType: 'LIST',
            frontCover: '',
            tags: []

          }
        },

        //专题模版
        specialModal: {
          showModal: false,
          title: '',
          showDetail: false,
          query: {
            categoryId: 0,
            queryArticles: {
              title: '',
              pageSize: 10,
              pageNumber: 1
            },
          },

          data: {
            tocTree:[],
            toc:{
              id: 0,
              title: '',
              pid: 0,
              url: '',
              target: '_self',
              orders: 0,
              category: {
                id: 0
              },
              article: {
                id: 0
              }
            },
            articles:[]
          },

          tree: {
            operation: {
              success : false,
              message : ''
            }
          }
        },

        tagModal:{
          title: '编辑标签',
          showModal: false,
          data: {
            tagList:[],
            selectedTagList:[]
          },
          dropConClass: {
            left: ['drop-box', 'left-drop-box'],
            right: ['drop-box', 'right-drop-box']
          }
        },

        ruleValidate: {
          title: [
            {required: true, message: '标题不能为空', trigger: 'blur'},
            {validator: validateName, trigger: 'blur'}
          ]
        },

        loading: false
      }
    },
    created() {
      this.init();
    },
    methods: {
      init() {
        // 加载表格数据
        this.search();
      },
      search() {
        this.table.loading = true;
        let self = this;
        categoryApi.getCategoryTree().then(function (res) {
          console.info(res);
          self.table.loading = false;
          if (!res.data.success) {
            self.setTableMessage(res.data.status.message);
          } else {
            self.table.data = res.data.data;
          }
        }).catch(function (error) {
          self.setTableMessage(error.message);
        });
      },

      toAddModel(pid) {
        this.modal.title = '添加栏目';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          pid: pid,
          title: '',
          url: '',
          target: '',
          orders: 0,
          keywords: '',
          description: '',
          type: 'CATEGORY',
          inMenu: 'FALSE',
          status: 'PUBLISH',
          showType: 'LIST',
          frontCover: ''
        };
      },

      toEditModel(id) {
        this.modal.title = '修改网站配置';
        this.modal.showModal = true;
        this.modal.data = {
          id: 0,
          pid: 0,
          title: '',
          url: '',
          target: '_blank',
          orders: 0,
          keywords: '',
          description: '',
          type: 'CATEGORY',
          inMenu: 'FALSE',
          status: 'PUBLISH',
          showType: 'LIST',
          frontCover: '',
          tags: []
        };

        let self = this;
        categoryApi.getById(id).then(function (res) {
          let result = res.data;
          if(result.success){
            self.modal.data = {
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
              tags: result.data.tags
            };
          }else{
            self.$Message.error(result.status.message);
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
        });
      },

      setTableMessage(message) {
        this.table.operation.success = false;
        this.table.operation.message = message;
      },
      addOrUpdate() {
        let self = this;
        this.$refs.modalForm.validate((valid) => {
          if (valid) {
            categoryApi.addOrUpdate(this.modal.data).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.$Message.info("操作成功");
                self.search();
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
      handleDelete (id) {
        let self = this;
        this.$Modal.confirm({
          title: '确定要删除这条记录吗？',
          onOk: () => {
            console.log("delele ok.");
            console.log("id:" + id);
            categoryApi.delete(id).then(function (res) {
              let result = res.data;
              if(result.success){
                self.$Message.info('删除成功');
                self.search();
              }else {
                self.$Message.error('删除失败!' + result.status.message);
              }
            });
          }
        });

      },

      handleEditSpecial(id,title){
        console.info("id" + id);
        this.specialModal.showModal = true;
        this.specialModal.title = title;
        this.specialModal.query.categoryId = id;
        this.specialModal.showDetail = false;
        this.loadTocs();
      },

      loadTocs(){
        let self = this;
        categoryTocApi.getTree(this.specialModal.query.categoryId).then(function (res) {
          console.info(res);
          if (!res.data.success) {
            self.setTreeMessage(res.data.status.message);
          } else {
            self.specialModal.data.tocTree = res.data.data;
          }
        }).catch(function (error) {
          self.setTreeMessage(error.message);
        });
      },

      loadArticles(query){
        this.specialModal.query.queryArticles.title = query;
        let self = this;
        articleApi.commonSearch(this.specialModal.query.queryArticles).then(function (res) {
          console.info(res);
          if (!res.data.success) {
            console.info("获取文章列表失败" + res.data.status.message);
          } else {
            self.specialModal.data.articles = res.data.data.datas;
          }
        }).catch(function (error) {
          console.info("获取文章列表失败" + error);
        });
      },

      handleCategoryChanged(row,event){
        this.loadToc(row[0].id);
      },

      loadToc(id){
        let self = this;
        categoryTocApi.getById(id).then(function (res) {
          let result = res.data;
          console.info(result);
          if (!result.success) {
            console.info("获取专题目录失败" + result.status.message);
          } else {
            self.setToc(result.data);

            self.specialModal.showDetail = true;
          }
        }).catch(function (error) {
          console.info("获取专题目录失败" + error);
        });
      },
      setToc(data){
        this.specialModal.data.toc.id = data.id;
        if(data.article != null){
          this.specialModal.data.toc.article.id = data.article.id;
          this.specialModal.data.articles = [];
          this.specialModal.data.articles.push(data.article);
        }else{
          this.specialModal.data.toc.article.id = 0;
        }
        this.specialModal.data.toc.target = data.target;
        this.specialModal.data.toc.url = data.url;
        this.specialModal.data.toc.category.id = data.category.id;
        this.specialModal.data.toc.orders = data.orders;
        this.specialModal.data.toc.pid = data.pid;
        this.specialModal.data.toc.title = data.title;
      },
      setTreeMessage(message) {
        this.specialModal.tree.operation.success = false;
        this.specialModal.tree.operation.message = message;
      },
      renderContent (h, { root, node, data }) {
        return h('span', {
          style: {
            display: 'inline-block',
            width: '100%'
          }
        }, [
          h('span', [
            h('Icon', {
              props: {
                type: 'ios-paper-outline'
              },
              style: {
                marginRight: '8px'
              }
            }),
            h('span', data.title)
          ]),
          h('span', {
            style: {
              display: 'inline-block',
              float: 'right',
              marginRight: '32px'
            }
          }, [
            h('Button', {
              props: Object.assign({}, this.buttonProps, {
                icon: 'ios-add',
                size: 'small'
              }),
              style: {
                marginRight: '8px',
              },
              on: {
                click: () => { this.appendToc(data) }
              }
            }),
            h('Button', {
              props: Object.assign({}, this.buttonProps, {
                icon: 'ios-remove',
                size: 'small'
              }),
              style: {
                marginRight: '8px'
              },
              on: {
                click: () => { this.removeToc(root, node, data) }
              }
            }),
            h('Button', {
              props: Object.assign({}, this.buttonProps, {
                icon: 'ios-create',
                size: 'small'
              }),

              on: {
                click: () => { this.loadToc(data.id) }
              }
            })
          ])
        ]);
      },
      appendToc (data) {
        this.specialModal.showDetail = true;
        this.resetToc();
        this.specialModal.data.toc.pid = data.id;
      },
      addRootToc(){
        this.specialModal.showDetail = true;
        this.resetToc();
      },
      resetToc(){
        this.specialModal.data.toc.id = 0;
        this.specialModal.data.toc.title = '';
        this.specialModal.data.toc.pid = 0;
        this.specialModal.data.toc.url = '';
        this.specialModal.data.toc.target = '_self';
        this.specialModal.data.toc.orders = 0;
        this.specialModal.data.toc.category.id = this.specialModal.query.categoryId;
        this.specialModal.data.toc.article.id = 0;
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
      addOrUpdateToc(){
        let self = this;
        this.$refs.tocForm.validate((valid) => {
          if (valid) {
            categoryTocApi.addOrUpdate(this.specialModal.data.toc).then(function (res) {
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

      handleEditTag(id,title){
        this.tagModal.showModal = true;
        let self = this;

        tagApi.getAll().then(function (res) {
          if (res.data.success) {
            self.tagModal.data.tagList = res.data.data;
            self.filterDrapDatas();
          }else{
            self.$Message.error(res.data.status.message);
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
        });

        categoryApi.getById(id).then(function (res) {
          let result = res.data;
          if(result.success){
            self.modal.data = {
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
              tags: result.data.tags
            };
            if(result.data.tags == null){
              self.tagModal.data.selectedTagList = [];
            }else{
              self.tagModal.data.selectedTagList = result.data.tags;
              self.filterDrapDatas();
            }

          }else{
            self.$Message.error(result.status.message);
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
        });
      },

      //过滤已选中的标签
      filterDrapDatas(){
        let self = this;
        self.tagModal.data.tagList = self.tagModal.data.tagList.filter(function(item) {
          let itemResult = true;
          self.tagModal.data.selectedTagList.forEach(function(sitem, index, arr) {
            if(sitem.id == item.id){
              itemResult = false;
            }
          });
          return itemResult;
        });
      },

      updateTag(){
        console.info(this.tagModal.data.selectedTagList);
        this.modal.data.tags = this.tagModal.data.selectedTagList;
        let self = this;
        categoryApi.addOrUpdate(this.modal.data).then(function (res) {
          let result = res.data;
          if (result.success) {
            self.$Message.info("操作成功");
          } else {
            self.$Message.error(result.status.message);
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
        });
        this.tagModal.showModal = false;
      },

      handleDragChange({ src, target, oldIndex, newIndex }){
        console.info(src);
        console.info(target);
        console.info(oldIndex);
        console.info(newIndex);
      }


    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
  .drag-list-wrapper .drag-list-con {
    overflow-y: scroll;
  }
  .drag-box-card{
    display: inline-block;
    width: 600px;
    height: 560px;
    .drag-item{
      margin: 10px;
    }
    h3{
      padding: 10px 15px;
    }
    .drop-box{
      border: 1px solid #eeeeee;
      height: 455px;
      border-radius: 5px;
    }
    .left-drop-box{
      margin-right: 10px;
    }
    .right-drop-box{
      //
    }
  }
</style>
