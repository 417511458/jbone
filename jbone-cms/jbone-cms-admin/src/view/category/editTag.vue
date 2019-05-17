<template>
  <Modal v-model="showEditModal" :mask-closable="false" width="650" :title="fullTitle">

    <div class="drag-box-card">
      <!-- 切记设置list1和list2属性时，一定要添加.sync修饰符 -->
      <drag-list :list1.sync="data.tagList" :list2.sync="data.selectedTagList" :dropConClass="dropConClass" @on-change="handleDragChange">
        <h3 slot="left-title">所有标签</h3>
        <Card class="drag-item" slot="left" slot-scope="left">{{ left.itemLeft.name }}</Card>
        <h3 slot="right-title">已选中标签</h3>
        <Card class="drag-item" slot="right" slot-scope="right">{{ right.itemRight.name }}</Card>
      </drag-list>

    </div>
    <div slot="footer">
      <Button type="text" size="large" @click="showEditModal = false">关闭</Button>
      <Button type="primary" size="large" :loading="loading" @click="updateTag">保存</Button>
    </div>
  </Modal>
</template>

<script>
  import categoryApi from '@/api/category'
  import tagApi from '@/api/tag'
  import DragList from '_c/drag-list'
    export default {
      components: {DragList},
      name: "editTag",
      props:{
        id: Number,
        title: String,
        showModal: {
          type: Boolean,
          default: false
        },

      },
      data(){
        return {
          data: {
            tagList:[],
            selectedTagList:[],
            category:{}
          },
          dropConClass: {
            left: ['drop-box', 'left-drop-box'],
            right: ['drop-box', 'right-drop-box']
          },
          loading: false,
          showEditModal: this.showModal
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

      computed:{
        fullTitle(){
          return '编辑专题标签 [' + this.title + ']'
        }
      },
      mounted(){

      },
      methods: {
        init(){
          if (this.id <= 0) {
            return;
          }
          let self = this;
          tagApi.getAll().then(function (res) {
            if (res.data.success) {
              self.data.tagList = res.data.data;
              self.filterDrapDatas();
            }else{
              self.$Message.error(res.data.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });

          categoryApi.getById(this.id).then(function (res) {
            let result = res.data;
            if(result.success){
              self.data.category = {
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
                self.data.selectedTagList = [];
              }else{
                self.data.selectedTagList = result.data.tags;
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
          self.data.tagList = self.data.tagList.filter(function(item) {
            let itemResult = true;
            self.data.selectedTagList.forEach(function(sitem, index, arr) {
              if(sitem.id == item.id){
                itemResult = false;
              }
            });
            return itemResult;
          });
        },

        updateTag(){
          this.data.category.tags = this.data.selectedTagList;
          let self = this;
          categoryApi.addOrUpdate(this.data.category).then(function (res) {
            let result = res.data;
            if (result.success) {
              self.$Message.info("操作成功");
            } else {
              self.$Message.error(result.status.message);
            }
          }).catch(function (error) {
            self.$Message.error(error.message);
          });
          this.showEditModal = false;
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
