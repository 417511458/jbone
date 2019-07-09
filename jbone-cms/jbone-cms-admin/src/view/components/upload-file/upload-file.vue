<template>
    <div>
      <Row>
        <Col span="2" v-show="showImg" style="width: 58px;height:58px;line-height: 58px;margin-right: 10px">
          <img :src="imgUrl" style="width: 58px;height:58px;" />
        </Col>
      <Col span="2" style="width: 58px;height:58px;line-height: 58px;margin-right: 10px">
        <Tooltip placement="top">
        <Upload
          ref="upload"
          multiple
          :format="['jpg','jpeg','png','gif']"
          type="drag"
          action="//jsonplaceholder.typicode.com/posts/"
          :on-success="handleUploadSuccess"
          :before-upload="handleBeforeUpload"
        >
            <div style="width: 58px;height:58px;line-height: 58px;">
                <Icon type="ios-camera" size="20"></Icon>
            </div>


        </Upload>
          <div slot="content">
            <p>选择图片</p>
          </div>
        </Tooltip>
      </Col>

      <Col span="4">
        <div v-if="file !== null">{{ file.name }}</div>
        <div v-if="file !== null"><Button @click="doUpload" :loading="loading" icon="ios-cloud-upload-outline">上传</Button></div>

      </Col>
        <Col span="2">
          <Tooltip placement="top">
            <Button @click="handleShowInput" style="width: 58px;height:58px;"><Icon type="ios-create-outline" /></Button>
            <div slot="content">
              <p>{{inputControlText}}</p>
            </div>
          </Tooltip>
        </Col>
        <Col span="14">
          <i-input v-show="showInput" v-model="inputImgUrl" clearable placeholder="图片地址"></i-input>
        </Col>
      </Row>
    </div>
</template>

<script>
  import fileApi from '@/api/file'

  export default {
    name: "upload-file",

    props:{
      imgUrl:{
        type: String,
        default: ''
      }

    },

    model: {
      prop: 'imgUrl',
      event: 'uploadSuccess'
    },

    data(){
      return {
        showInput:false,
        file: null,
        loading: false,
      }
    },

    computed: {
      inputControlText(){
        if(this.showInput){
          return "隐藏图片地址"
        }else{
          return "输入图片地址"
        }
      },
      showImg(){
        if(this.imgUrl == null || this.imgUrl == ''){
          return false
        }
        return true
      },
      inputImgUrl: {
        get:function(){
          return this.imgUrl;
        },
        set: function(newValue) {
          this.$emit('uploadSuccess', newValue)
        }

      }
    },

    watch:{

    },

    methods:{
      handleShowInput(){
        this.showInput = !this.showInput
      },

      handleUploadSuccess(response, file, fileList){
        console.info(fileList)
      },

      handleBeforeUpload(file){
        console.info(file)
        this.file = file
        return false
      },

      doUpload(){
        if(this.file == null){
          this.$Message.error('先选择文件');
        }
        this.loading = true;
        let self = this;
        //上传到文件服务
        fileApi.upload(this.file).then(function (res) {
          let result = res.data;
          if (result.success) {
            self.$emit('uploadSuccess', result.data.url)
          } else {
            self.$Message.error(result.status.message);
          }
          self.file = null
          self.loading = false;
        }).catch(function (error) {
          self.$Message.error(error.message);
          self.loading = false;
          self.file = null
        });
        console.info(this.$refs.upload.fileList)
      }
    }

  }
</script>

<style scoped>

</style>
