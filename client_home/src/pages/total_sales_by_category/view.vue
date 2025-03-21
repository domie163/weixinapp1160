<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','title') || ($check_field('add','title') || $check_field('set','title'))" label="标题" name="title">
                            <uni-easyinput type="text" v-model="form['title']" v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','title')) || (!form['total_sales_by_category_id'] && $check_field('add','title'))" :disabled="disabledObj['title_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','title')">
                  {{ form['title'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','statistical_time') || ($check_field('add','statistical_time') || $check_field('set','statistical_time'))" label="统计时间" name="statistical_time">
                            <uni-easyinput type="text" v-model="form['statistical_time']" v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','statistical_time')) || (!form['total_sales_by_category_id'] && $check_field('add','statistical_time'))" :disabled="disabledObj['statistical_time_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','statistical_time')">
                  {{ form['statistical_time'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','classification_name') || ($check_field('add','classification_name') || $check_field('set','classification_name'))" label="分类名称" name="classification_name">
                            <uni-easyinput type="text" v-model="form['classification_name']" v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','classification_name')) || (!form['total_sales_by_category_id'] && $check_field('add','classification_name'))" :disabled="disabledObj['classification_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','classification_name')">
                  {{ form['classification_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','total_sales') || ($check_field('add','total_sales') || $check_field('set','total_sales'))" label="总销量" name="total_sales">
                            <uni-easyinput type="text" v-model="form['total_sales']" v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','total_sales')) || (!form['total_sales_by_category_id'] && $check_field('add','total_sales'))" :disabled="disabledObj['total_sales_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','total_sales')">
                  {{ form['total_sales'] }}
                </text>
                          </uni-forms-item>


            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()" class="primary_btn">提交</button>
              <button size="mini" @click="cancel()">取消</button>
            </view>
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";

export default {
  mixins: [mixin],
  data() {
    return {
      field: "total_sales_by_category_id",
      url_add: "~/api/total_sales_by_category/add?",
      url_set: "~/api/total_sales_by_category/set?",
      url_get_obj: "~/api/total_sales_by_category/get_obj?",
      url_upload: "~/api/total_sales_by_category/upload?",

      query: {
        "total_sales_by_category_id": 0,
      },

      form: {
            "title":  '', // 标题
                    "statistical_time":  '', // 统计时间
                    "classification_name":  '', // 分类名称
                    "total_sales":  0 , // 总销量
                                "total_sales_by_category_id": 0, // ID
                
              },
          disabledObj:{
                        "title_isDisabled": false,
                                "statistical_time_isDisabled": false,
                                "classification_name_isDisabled": false,
                                                      },
                                                                                                      }
  },
  methods: {
    changeLog(v,value){
      this.form[value] = v
    },
    /**
     * 上传文件
     * @param {Object} param文件参数
     */
    change_file(key_name){
      var _self = this;
      // 选择图像方法
      uni.chooseFile({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/total_sales_by_category/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
            }
          });

          uploadTask.onProgressUpdate(function(res) {
            _self.percent = res.progress;
            console.log('上传进度' + res.progress);
            console.log('已经上传的数据长度' + res.totalBytesSent);
            console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
          });
        },
        error: function(e) {
          console.log(e);
        }
      });
    },
    /**
     * 上传图片
     * @param {Object} param文件参数
     */
    change_img(key_name){
      var _self = this;
      _self.upload_img_flag = false
      // 选择图像方法
      uni.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/total_sales_by_category/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
            }
          });

          uploadTask.onProgressUpdate(function(res) {
            _self.percent = res.progress;
            console.log('上传进度' + res.progress);
            console.log('已经上传的数据长度' + res.totalBytesSent);
            console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
          });
        },
        error: function(e) {
          console.log(e);
        }
      });
    },
    /**
     * 获取对象后获取缓存表单
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_before(param){
      var form = uni.db.get("form");
      if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
        this.obj = uni.push(this.obj ,form);
        this.form = uni.push(this.form ,form);
      }
      var arr = []
      for (let key in form) {
        arr.push(key)
      }
      for (var i=0;i<arr.length;i++){
        this.disabledObj[arr[i] + '_isDisabled'] = true
      }
                                      uni.db.del("form");
      return param;
    },
        
            
            
            
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                    },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/total_sales_by_category/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/total_sales_by_category/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/total_sales_by_category/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/total_sales_by_category/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/total_sales_by_category/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
                                  },
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.form_button{
  padding-bottom: 15px;
  display: flex;
}
.form_button button{
  width: 40%;
}
.query_select{
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline:none;
}

.query_option{
  width: 100%;
}

.btn_add_img{
  color: #D3D3D3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text{
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.form_button {
  padding-bottom: 15px;
  display: flex;
}
.form_button button {
  width: 40%;
}
.query_select {
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline: none;
}

.query_option {
  width: 100%;
}

.btn_add_img {
  color: #d3d3d3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text {
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
/*新样式*/
.uni-forms{
padding-top:1rem;
}
.uni-forms-item {
	padding: 6px 10px;
    background: #f8f6fc;
}
.uni-forms .is-input-border{
	border: 0;
}
.container{
	    -webkit-box-shadow: 0px 0px 0px #888888;
	    box-shadow: 0px 0px 0px #888888;
}
.form_button .primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
</style>
