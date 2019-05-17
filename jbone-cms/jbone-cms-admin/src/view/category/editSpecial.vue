<template>
  <Modal v-model="showEditModal" :mask-closable="false" width="850" title="编辑专题">

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
            <Tree :data="data.tocTree" @on-select-change="handleCategoryChanged" :render="renderContent" empty-text="暂无数据"></Tree>
          </card>
        </Col>
        <Col span="12">
          <card v-if="showDetail">
            <p slot="title">
              <Icon type="ios-film-outline"></Icon>
              目录详情
            </p>
            <Form :model="data.toc" :label-width="100" ref="tocForm" :rules="ruleValidate">
              <FormItem label="标题" prop="title" :required="true">
                <i-input v-model="data.toc.title" clearable placeholder="栏目标题"></i-input>
              </FormItem>

              <FormItem label="链接" prop="keywords">
                <i-input v-model="data.toc.url" clearable placeholder="链接URL"></i-input>
              </FormItem>

              <FormItem label="打开目标" prop="type" >
                <RadioGroup v-model="data.toc.target">
                  <Radio label="_self">当前窗口打开</Radio>
                  <Radio label="_blank">新窗口打开</Radio>
                </RadioGroup>
              </FormItem>


              <FormItem label="排序号" prop="orders" >
                <InputNumber v-model="data.toc.orders" clearable  placeholder="排序号"></InputNumber>
              </FormItem>

              <FormItem label="链接文章" prop="url" >
                <Select v-model="data.toc.article.id" filterable remote
                        :remote-method="loadArticles">
                  <Option v-for="article in data.articles" :value="article.id" :key="article.id">{{ article.title }}</Option>
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
</template>

<script>
  import categoryTocApi from '@/api/categoryToc'
  import articleApi from '@/api/article'
    export default {
      name: "editSpecial",
      props:{
        categoryId: {
          type: Number,
          default: 0
        },
        title: String,
        showModal: {
          type: Boolean,
          default: false
        },
      },
      data(){
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
          showDetail: false,
          loading: false,
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
          },

          ruleValidate: {
            title: [
              {required: true, message: '标题不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ]
          }
        }
      },
      watch: {
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

      computed: {

      },

      methods: {
        init(){
          this.loadTocs()
        },
        loadTocs(){
          if(this.categoryId <= 0){
            return
          }

          let self = this;
          categoryTocApi.getTree(this.categoryId).then(function (res) {
            if (!res.data.success) {
              self.setTreeMessage(res.data.status.message);
            } else {
              self.data.tocTree = res.data.data;
            }
          }).catch(function (error) {
            self.setTreeMessage(error.message);
          });
        },

        loadArticles(query){
          this.query.queryArticles.title = query;
          let self = this;
          articleApi.commonSearch(this.query.queryArticles).then(function (res) {
            console.info(res);
            if (!res.data.success) {
              console.info("获取文章列表失败" + res.data.status.message);
            } else {
              self.data.articles = res.data.data.datas;
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

              self.showDetail = true;
            }
          }).catch(function (error) {
            console.info("获取专题目录失败" + error);
          });
        },
        setToc(data){
          this.data.toc.id = data.id;
          if(data.article != null){
            this.data.toc.article.id = data.article.id;
            this.data.articles = [];
            this.data.articles.push(data.article);
          }else{
            this.data.toc.article.id = 0;
          }
          this.data.toc.target = data.target;
          this.data.toc.url = data.url;
          this.data.toc.category.id = data.category.id;
          this.data.toc.orders = data.orders;
          this.data.toc.pid = data.pid;
          this.data.toc.title = data.title;
        },

        appendToc (data) {
          this.showDetail = true;
          this.resetToc();
          this.data.toc.pid = data.id;
        },
        addRootToc(){
          this.showDetail = true;
          this.resetToc();
        },
        resetToc(){
          this.data.toc.id = 0;
          this.data.toc.title = '';
          this.data.toc.pid = 0;
          this.data.toc.url = '';
          this.data.toc.target = '_self';
          this.data.toc.orders = 0;
          this.data.toc.category.id = this.categoryId;
          this.data.toc.article.id = 0;
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
              categoryTocApi.addOrUpdate(this.data.toc).then(function (res) {
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
        setTreeMessage(message) {
          this.tree.operation.success = false;
          this.tree.operation.message = message;
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
      }
    }
</script>

<style scoped>

</style>
