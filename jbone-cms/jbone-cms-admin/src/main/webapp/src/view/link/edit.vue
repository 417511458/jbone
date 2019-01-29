<template>
  <Modal :width="900" :title="title" v-model="showEditModal" :mask-closable="false">
    <Form :model="linkModel" :label-width="100" ref="linkForm" :rules="ruleValidate">
        <Card>
            <p slot="title">链接内容</p>
            <FormItem label="链接名" prop="title" style="margin: 0;" :required="true">
                <i-input v-model="linkModel.title" clearable style="width: 200px;" placeholder="链接名"></i-input>
            </FormItem>
            <FormItem label="URL" prop="url" style="margin: 0;" :required="true">
                <i-input v-model="linkModel.url" clearable style="width: 200px;" placeholder="链接地址"></i-input>
            </FormItem>
            <FormItem label="排序号" prop="orders" style="margin: 0;" :required="true">
                <i-input v-model="linkModel.orders" clearable style="width: 200px;" placeholder="排序号"></i-input>
            </FormItem>
            <FormItem label="描述" prop="description" style="margin: 0;" :required="true">
              <i-input v-model="linkModel.description" clearable style="width: 200px;" placeholder="描述"></i-input>
            </FormItem>
        </Card>

        <Card>
            <Button type="primary" @click="addOrUpdate" :loading="loading">保存</Button>
        </Card>

    </Form>
  </Modal>


</template>

<script>
    import linkApi from '@/api/link';

    export default {
        name: "LinkEdit",
        components: {
        },
        props: {
            id: Number,
            title: String,

            showModal: {
                type: Boolean,
                default: false
            },
        },
        data: function () {
            // 验证
            const validateService = (rule, value, callback) => {
                if (value === 0 || value === "") {
                    callback(new Error('服务不允许为空'));
                } else {
                    callback();
                }
            };
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
                showEditModal: this.showModal,
                linkModel: {
                    title: '',
                    url: '',
                    description: '',
                    orders: 0
                },
                processCode: '',
                visible: false,
                currentItemIndex: -1,
                demo: '',
                data: [],
                ruleValidate: {
                  title: [
                        {required: true, message: '链接名称不能为空', trigger: 'blur'},
                        {validator: validateName, trigger: 'blur'}
                    ],
                  url: [
                        {required: true, message: 'URL不能为空', trigger: 'blur'},
                        {validator: validateName, trigger: 'blur'},
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
                this.loading = false;
                debugger;
                if (!this.id) { // 新增事件
                    return;
                }

                linkApi.getById(this, this.id).then(function (res) {
                  this.linkModel = res.data.data.result;
                }).catch(function (error) {
                  this.prompt(false, error.message);
                });
            },
            addOrUpdate() {
                this.loading = true;
                this.$refs.linkForm.validate((valid) => {
                    if (valid) {
                        linkApi.addOrUpdate(this.linkModel).then(function (res) {
                          if (res.data.data.success) {
                            this.close("添加成功", true);
                          } else {
                            this.close(res.data.message, false);
                          }
                        }).catch(function (error) {
                          this.close(error.message, false);
                        });
                        this.loading = false;
                    } else {
                        this.loading = false;
                    }
                });

            },

            cancel() {
                this.loading = false;
                this.showEditModal = false;

            },
            close(message, success) {
                // 弹出全局提示
                this.prompt(success, message);
            },

            handleSuccess (item,res, file) {
                if(res.status.code === 200){
                    var url = res.result.url;
                    item["demo"] = url;
                }
            }
        },
    }
</script>

<style>
    .upload-list{
        display: inline-block;
        width: 60px;
        height: 60px;
        text-align: center;
        line-height: 60px;
        border: 1px solid transparent;
        border-radius: 4px;
        overflow: hidden;
        background: #fff;
        position: relative;
        box-shadow: 0 1px 1px rgba(0,0,0,.2);
        margin-right: 4px;
    }
    .upload-list img{
        width: 100%;
        height: 100%;
    }
    .upload-list-cover{
        display: none;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background: rgba(0,0,0,.6);
    }
    .upload-list:hover .upload-list-cover{
        display: block;
    }
    .upload-list-cover i{
        color: #fff;
        font-size: 20px;
        cursor: pointer;
        margin: 0 2px;
    }
</style>

