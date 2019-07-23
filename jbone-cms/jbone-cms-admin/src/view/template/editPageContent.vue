<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle" width="1024">

    <Card :dis-hover="true">

      <Tabs type="card">
        <TabPane v-for="page in templatePages" :label="page.dictName">
          <div style="width: 100px">
            <Checkbox :label="dc.dictName" v-model="dc[page.dictValue]"  v-for="dc in dataCollectors">{{dc.dictName}}</Checkbox>
          </div>
        </TabPane>
      </Tabs>
    </Card>


    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import templateApi from "@/api/template";
  import dictionaryApi from '@/api/dictionary'
  import UploadFile from "../components/upload-file/upload-file";

    export default {
      name: "editPageContent",
      components: {UploadFile},
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

        return {
          showEditModal: false,
          template: {
            id: 0,
            name: '',
            code: '',
            frontCover: '',
            images: '',
            description: '',
            type: '',
            style: '',
            color: '',
            enable: '1',
            singlePage: '0',
            dataCollectors: ''
          },
          templateDataCollectors:[],
          templatePages:[],
          dataCollectors: [],
          allDataCollectors: [],
          loading: false,
        };
      },
      computed:{
        fullTitle(){
          return '编辑模版页面内容[' + this.title + ']'
        }
      },
      watch:{
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
      methods:{
        init(){
          this.loadData()
        },
        loadData() {
          this.template = {
            id: 0,
            name: '',
            code: '',
            frontCover: '',
            images: '',
            description: '',
            type: '',
            style: '',
            color: '',
            enable: '1',
            singlePage: '0',
            dataCollectors: ''
          }
          this.loadTemlate()
          this.loadTemplatePage()
          this.loadDataCollectors()

        },
        loadTemlate(){
          if(this.id > 0) {
            let self = this;
            templateApi.getById(this.id).then(function (res) {
              let result = res.data;
              if (result.success) {
                self.template.id = result.data.id;
                self.template.name = result.data.name;
                self.template.description = result.data.description;
                self.template.code = result.data.code;
                self.template.color = result.data.color;
                self.template.enable = result.data.enable + '';
                self.template.frontCover = result.data.frontCover;
                self.template.images = result.data.images;
                self.template.style = result.data.style;
                self.template.type = result.data.type;
                self.template.singlePage = result.data.singlePage + '';
                self.template.dataCollectors = result.data.dataCollectors;
                self.setDefaultContent();
              } else {
                self.$Message.error(result.status.message);
              }
            }).catch(function (error) {
              self.$Message.error(error.message);
            });
          }
        },

        setDefaultContent(){

          this.dataCollectors = []
          let self = this;
          let currentDataCollectors = {}
          if(this.template.dataCollectors != null && this.template.dataCollectors != ''){
            currentDataCollectors = JSON.parse(this.template.dataCollectors)
          }
          this.allDataCollectors.forEach(function(dataCollector, index, arr) {
            for (let k of Object.keys(currentDataCollectors)) {
              let v = currentDataCollectors[k];
              if(v.indexOf(dataCollector.dictValue) > -1){
                dataCollector[k] = true
              }
            }
            self.dataCollectors.push(dataCollector)
          });
          console.info(this.dataCollectors)

        },

        loadTemplatePage(){
          let self = this;
          dictionaryApi.getItemsByCode('page_name').then(function (res) {
            let result = res.data;
            if(result.success){
              self.templatePages = result.data == null ? [] : result.data
              self.setDefaultContent();
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadDataCollectors(){
          let self = this;
          dictionaryApi.getItemsByCode('data_collector').then(function (res) {
            let result = res.data;
            if(result.success){
              self.allDataCollectors = result.data == null ? [] : result.data
              self.setDefaultContent();
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },



        addOrUpdate() {
          // this.loading = true;
          let self = this
          let collectors = {}
          self.templatePages.forEach(function(templatePage, index, arr) {
            self.dataCollectors.forEach(function(dataCollector, index, arr) {
              if(dataCollector[templatePage.dictValue]){
                if(collectors[templatePage.dictValue]){
                  collectors[templatePage.dictValue] = collectors[templatePage.dictValue] + "," + dataCollector.dictValue
                }else{
                  collectors[templatePage.dictValue] = dataCollector.dictValue
                }

              }
            });
          });
          console.info(collectors)

          self.template.dataCollectors = JSON.stringify(collectors);

          templateApi.addOrUpdate(this.template).then(function (res) {
            let result = res.data;
            if (result.success) {
              self.$Message.info("操作成功");
              self.$emit('success');
            } else {
              self.$Message.error(result.status.message);
            }
            self.loading = false;
          }).catch(function (error) {
            self.$Message.error(error.message);
            self.loading = false;
          });
          self.showEditModal = false;
        },

      }
    }
</script>

<style lang="less">
</style>
