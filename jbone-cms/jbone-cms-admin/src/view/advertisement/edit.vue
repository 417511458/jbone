<template>
  <Modal v-model="showEditModal" :mask-closable="false" :title="fullTitle">

    <Form :model="data" :label-width="100" ref="modalForm" :rules="ruleValidate">
      <FormItem label="广告名" prop="name" :required="true">
        <i-input v-model="data.name" clearable placeholder="广告名"></i-input>
      </FormItem>
      <FormItem label="类型" prop="type" :required="true">
        <Select v-model="data.type">
          <Option v-for="item in adsTypes" :value="item.dictValue" :key="item.id">{{ item.dictName }}</Option>
        </Select>
      </FormItem>
      <FormItem label="广告位" prop="location" :required="true">
        <Select v-model="data.location">
          <Option v-for="item in adsLocations" :value="item.dictValue" :key="item.id">{{ item.dictName }}</Option>
        </Select>
      </FormItem>
      <FormItem label="是否启用" prop="enable" :required="true">
        <i-switch v-model="data.enable" size="large" true-value="1" false-value="0">
          <span slot="open">启用</span>
          <span slot="close">禁用</span>
        </i-switch>
      </FormItem>
      <FormItem label="图片" prop="img" v-if="data.type == 'img' || data.type == 'imgAndText'">
        <i-input v-model="data.img" clearable placeholder="图片"></i-input>
      </FormItem>
      <FormItem label="文本" prop="text" v-if="data.type == 'text' || data.type == 'imgAndText'">
        <i-input v-model="data.text" clearable placeholder="文本"></i-input>
      </FormItem>
      <FormItem label="代码" prop="content" v-if="data.type == 'code'">
        <i-input v-model="data.content" type="textarea" :rows="4" clearable placeholder="代码"></i-input>
      </FormItem>
      <FormItem label="链接地址" prop="url" v-if="data.type == 'img' || data.type == 'imgAndText' || data.type == 'text'">
        <i-input v-model="data.url" clearable placeholder="图片"></i-input>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import advertisementApi from '@/api/advertisement'
  import dictionaryApi from '@/api/dictionary'
    export default {
      name: "advertisementEdit",
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
          data: {
            id: 0,
            name: '',
            location: '',
            type: 'text',
            content: '',
            url: '',
            enable: '1',
            img: '',
            text: ''
          },
          adsTypes:[],
          adsLocations:[],
          loading: false,
          ruleValidate: {
            name: [
              {required: true, message: '广告名不能为空', trigger: 'blur'},
              {validator: validateName, trigger: 'blur'}
            ],
            type: [
              {required: true, message: '广告类型不能为空', trigger: 'blur'}
            ],
            location: [
              {required: true, message: '广告位置不能为空', trigger: 'blur'}
            ]
          },
        };
      },
      computed:{
        fullTitle(){
          if(this.id <= 0 ){
            return '添加广告'
          }
          return '编辑广告 [' + this.title + ']'
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
          this.loadAdvertisement()
          this.loadAdsType()
          this.loadAdsLocation()
        },
        loadAdvertisement() {
          this.data = {
            id: 0,
            name: '',
            location: '',
            type: 'text',
            content: '',
            url: '',
            enable: '1',
            img: '',
            text: ''
          }
          if(this.id <= 0){
            return
          }

          let self = this;
          advertisementApi.getById(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data = {
                id: result.data.id,
                name: result.data.name,
                location: result.data.location,
                type: result.data.type,
                content: result.data.content,
                url: result.data.url,
                enable: result.data.enable + '',
                img: result.data.img,
                text: result.data.text
              }
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadAdsType(){
          let self = this;
          dictionaryApi.getItemsByCode('ads_type').then(function (res) {
            let result = res.data;
            if(result.success){
              self.adsTypes = result.data
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        loadAdsLocation(){
          let self = this;
          dictionaryApi.getItemsByCode('ads_location').then(function (res) {
            let result = res.data;
            if(result.success){
              self.adsLocations = result.data
            }else{
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
        },

        addOrUpdate() {
          let self = this;
          this.$refs.modalForm.validate((valid) => {
            if (valid) {
              advertisementApi.addOrUpdate(this.data).then(function (res) {
                let result = res.data;
                if (result.success) {
                  self.$Message.info("操作成功");
                  self.$emit('success');
                } else {
                  self.$Message.error(result.status.message);
                }
              }).catch(function (error) {
                self.$Message.error(error.message);
              });
              self.loading = false;
              self.showEditModal = false;

            } else {
              self.loading = false;
            }
          });

        },
      }
    }
</script>

<style scoped>

</style>
