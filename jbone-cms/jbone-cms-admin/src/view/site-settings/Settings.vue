<template>
  <div>
    <card>
    <Tabs type="card">
      <TabPane label="网站基本信息">
        <Form :model="baseInfo" :label-width="150" ref="baseInfoForm">
          <FormItem label="网站标题" prop="title" :required="true">
            <i-input v-model="baseInfo.title" clearable placeholder="网站标题"></i-input>
          </FormItem>
          <FormItem label="网站搜索关键字" prop="keywords" :required="true">
            <i-input v-model="baseInfo.keywords" clearable  placeholder="网站搜索关键字"></i-input>
          </FormItem>
          <FormItem label="网站说明" prop="description"  :required="true">
            <i-input v-model="baseInfo.description" clearable placeholder="网站说明"></i-input>
          </FormItem>
          <FormItem label="网站版权信息" prop="copyright"  :required="true">
            <i-input v-model="baseInfo.copyright" clearable placeholder="网站版权信息"></i-input>
          </FormItem>
          <FormItem label="网站品牌文字" prop="brand"  :required="true">
            <i-input v-model="baseInfo.brand" clearable placeholder="网站品牌文字"></i-input>
          </FormItem>
          <FormItem label="网站logo" prop="logo">
            <upload-file v-model="home.logo"></upload-file>
          </FormItem>
        </Form>
      </TabPane>
      <TabPane label="联系方式">
        <Form :model="contact" :label-width="150" ref="contactForm">
          <FormItem label="github" prop="github" :required="true">
            <i-input v-model="contact.github" clearable placeholder="github"></i-input>
          </FormItem>
          <FormItem label="码云" prop="gitee" :required="true">
            <i-input v-model="contact.gitee" clearable  placeholder="码云"></i-input>
          </FormItem>
          <FormItem label="QQ" prop="qq" >
            <i-input v-model="contact.qq" clearable placeholder="QQ"></i-input>
          </FormItem>
          <FormItem label="微信" prop="copyright" >
            <i-input v-model="contact.wechat" clearable placeholder="微信"></i-input>
          </FormItem>
          <FormItem label="电话" prop="phone" >
            <i-input v-model="contact.phone" clearable placeholder="电话"></i-input>
          </FormItem>
          <FormItem label="邮箱" prop="mail" >
            <i-input v-model="contact.mail" clearable placeholder="邮箱"></i-input>
          </FormItem>
        </Form>
      </TabPane>

      <TabPane label="网站首页">
        <Form :model="home" :label-width="150" ref="homeForm">
          <FormItem label="首页大标题" prop="title" :required="true">
            <i-input v-model="home.title" clearable placeholder="首页大标题"></i-input>
          </FormItem>
          <FormItem label="首页副标题" prop="description" :required="true">
            <i-input v-model="home.description" clearable  placeholder="首页副标题"></i-input>
          </FormItem>
          <FormItem label="首页Banner" prop="banner">
            <upload-file v-model="home.banner"></upload-file>
          </FormItem>
        </Form>
      </TabPane>

      <TabPane label="广告设置">
        <Form :model="ads" :label-width="150" ref="adsForm">
          <FormItem label="打开网站广告" prop="switch" :required="true">
            <i-switch v-model="ads.switch" size="large" @on-change="adsSwitchchange">
              <span slot="open">打开</span>
              <span slot="close">关闭</span>
            </i-switch>
          </FormItem>
        </Form>
      </TabPane>
      <TabPane label="其他配置">
        <Form :model="orthers" :label-width="150" ref="orthersForm">
          <FormItem label="关于我" prop="aboutme" :required="true">
            <i-input v-model="orthers.aboutme" type="textarea" :rows="4" clearable  placeholder="关于我"></i-input>
          </FormItem>
        </Form>
      </TabPane>
    </Tabs>
      <Form :label-width="150">
        <FormItem label="" prop="switch" :required="true">
          <Button type="primary" size="large" :loading="loading" @click="addOrUpdate">保存配置</Button>
        </FormItem>
      </Form>
    </card>
  </div>
</template>
<script>
  import siteSettingsApi from '@/api/siteSettings'
  import fileApi from '@/api/file'
  import siteApi from '@/api/site'
  import UploadFile from "../components/upload-file/upload-file";
  export default {
    components: {UploadFile},
    data() {
      return {
        baseInfo:{
          title:'',   //网站标题
          keywords: '', //网站关键字
          description: '', //网站描述
          brand: '',        //品牌名字
          copyright: '',    //版权信息
          logo: '',
        },
        home: {
          title: '',  //首页大标题
          description: '',//首页副标题
          banner: '', //首页banner
        },
        contact: {      //联系方式
          github: '',
          gitee: '',
          qq: '',
          wechat: '',
          phone: '',
          mail: ''
        },
        ads:{
          switch: true,  //广告开关
        },
        orthers:{
          aboutme: '',  //广告开关
        },
        loading: false,
        settings:[],
        showBannerInput:false,
        bannerUploding: false
      }
    },
    created() {
      this.init();
    },
    methods: {

      fillSettings(){
        this.settings = []
        this.settings.push(this.newSetting('title',this.baseInfo.title))
        this.settings.push(this.newSetting('keywords',this.baseInfo.keywords))
        this.settings.push(this.newSetting('description',this.baseInfo.description))
        this.settings.push(this.newSetting('brand',this.baseInfo.brand))
        this.settings.push(this.newSetting('logo',this.baseInfo.logo))
        this.settings.push(this.newSetting('copyright',this.baseInfo.copyright))
        this.settings.push(this.newSetting('home_title',this.home.title))
        this.settings.push(this.newSetting('home_description',this.home.description))
        this.settings.push(this.newSetting('home_banner',this.home.banner))
        this.settings.push(this.newSetting('contact_github',this.contact.github))
        this.settings.push(this.newSetting('contact_gitee',this.contact.gitee))
        this.settings.push(this.newSetting('contact_qq',this.contact.qq))
        this.settings.push(this.newSetting('contact_wechat',this.contact.wechat))
        this.settings.push(this.newSetting('contact_phone',this.contact.phone))
        this.settings.push(this.newSetting('contact_mail',this.contact.phone))
        this.settings.push(this.newSetting('ads_switch',this.ads.switch))
        this.settings.push(this.newSetting('aboutme',this.orthers.aboutme))
        console.info(this.settings)

      },

      fillData(settingMap){
        this.baseInfo.title = this.getSettingValue(settingMap,"title")
        this.baseInfo.keywords = this.getSettingValue(settingMap,"keywords")
        this.baseInfo.description = this.getSettingValue(settingMap,"description")
        this.baseInfo.brand = this.getSettingValue(settingMap,"brand")
        this.baseInfo.copyright = this.getSettingValue(settingMap,"copyright")
        this.baseInfo.logo = this.getSettingValue(settingMap,"logo")
        this.home.title = this.getSettingValue(settingMap,"home_title")
        this.home.description = this.getSettingValue(settingMap,"home_description")
        this.home.banner = this.getSettingValue(settingMap,"home_banner")
        this.contact.github = this.getSettingValue(settingMap,"contact_github")
        this.contact.gitee = this.getSettingValue(settingMap,"contact_gitee")
        this.contact.qq = this.getSettingValue(settingMap,"contact_qq")
        this.contact.wechat = this.getSettingValue(settingMap,"contact_wechat")
        this.contact.phone = this.getSettingValue(settingMap,"contact_phone")
        this.contact.mail = this.getSettingValue(settingMap,"contact_mail")
        this.ads.switch = this.getSettingValue(settingMap,"ads_switch") == 'true'
        this.orthers.aboutme = this.getSettingValue(settingMap,"aboutme")

      },

      getSettingValue(settingMap,key){
        return settingMap[key]
      },

      newSetting(key,val){
        return {
          name: key,
          value: val
        }
      },

      init() {
        // 加载表格数据
        this.search();
      },
      search() {
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }
        let self = this;
        siteSettingsApi.getAll().then(function (res) {
          if (!res.data.success) {
            self.$Message.error(res.data.status.message);
          } else {
            let settingMap = res.data.data
            self.fillData(settingMap)
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
        });
      },

      adsSwitchchange(status){
        console.info(status)
      },
      addOrUpdate() {
        if(siteApi.getCurrentSiteID() == null || siteApi.getCurrentSiteID() == ''){
          this.$Message.error('请选择站点');
          return
        }
        this.fillSettings()
        let self = this;
        let validResult = true
        this.$refs.baseInfoForm.validate((valid) => {
          if (!valid) {
            validResult = false
          }
        })
        this.$refs.contactForm.validate((valid) => {
          if (!valid) {
            validResult = false
          }
        })

        this.$refs.adsForm.validate((valid) => {
          if (!valid) {
            validResult = false
          }
        })

        this.$refs.orthersForm.validate((valid) => {
          if (!valid) {
            validResult = false
          }
        })
        if(validResult){
          siteSettingsApi.batchAddOrUpdate(this.settings).then(function (res) {
            let result = res.data;
            if (result.success) {
              self.$Message.info("添加成功");
            } else {
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
          self.loading = false;
        }


      },

      handleBeforeUpload(file){
        let self = this;
        this.bannerUploding = true
        //上传到文件服务
        fileApi.upload(file).then(function (res) {
          self.bannerUploding = false
          let result = res.data;
          if (result.success) {
            self.home.banner = result.data.url
          } else {
            self.$Message.error(result.status.message);
          }
        }).catch(function (error) {
          self.$Message.error(error.message);
          self.bannerUploding = false
        });
        return false
      },

      handleShowBannerInput(){
        this.showBannerInput = this.showBannerInput ? false : true
      }

    }
  }
</script>

<style lang="less">
  .ivu-page {
    margin-top: 10px;
  }
</style>
