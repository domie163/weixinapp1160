<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','package_name') || ($check_field('add','package_name') || $check_field('set','package_name'))" label="套餐名称" name="package_name">
                            <uni-easyinput type="text" v-model="form['package_name']" v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','package_name')) || (!form['package_information_id'] && $check_field('add','package_name'))" :disabled="disabledObj['package_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','package_name')">
                  {{ form['package_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','cover') || ($check_field('add','cover') || $check_field('set','cover'))" label="封面" name="cover">
                    <!-- 修改权限 -->
                <view class="diy_field diy_img" v-if="form['cover'] && $check_field('set','cover')">
                  <image v-if="disabledObj['cover_isDisabled']" :src="$fullUrl(form['cover'])" />
                  <image v-if="!disabledObj['cover_isDisabled']" :src="$fullUrl(form['cover'])" @click="change_img('cover')" />
                </view>
                <!-- 添加权限 -->
                <view class="diy_field diy_img" v-else-if="!form['cover'] && $check_field('add','cover')">
                  <view v-if="disabledObj['cover_isDisabled']" class="btn_add_img">
                    <text>+</text>
                  </view>
                  <view v-if="!disabledObj['cover_isDisabled']" class="btn_add_img" @click="change_img('cover')">
                    <text>+</text>
                  </view>
                </view>
                <!-- 查询权限 -->
                <view class="diy_field diy_img" v-else-if="$check_field('get','cover')">
                  <image :src="$fullUrl(form['cover'])" />
                </view>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','flavor') || ($check_field('add','flavor') || $check_field('set','flavor'))" label="口味" name="flavor">
                    <uni-data-select
                  v-model="form.flavor"
                  :localdata="list_flavor"
                  :clear="!disabledObj['flavor_isDisabled']"
                  :disabled="disabledObj['flavor_isDisabled']"
                  v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','flavor')) || (!form['package_information_id'] && $check_field('add','flavor'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','flavor')">
                  {{ form['flavor'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','raw_material') || ($check_field('add','raw_material') || $check_field('set','raw_material'))" label="原材料" name="raw_material">
                            <uni-easyinput type="text" v-model="form['raw_material']" v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','raw_material')) || (!form['package_information_id'] && $check_field('add','raw_material'))" :disabled="disabledObj['raw_material_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','raw_material')">
                  {{ form['raw_material'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','package_type') || ($check_field('add','package_type') || $check_field('set','package_type'))" label="套餐类型" name="package_type">
                    <uni-data-select
                  v-model="form.package_type"
                  :localdata="list_package_type"
                  :clear="!disabledObj['package_type_isDisabled']"
                  :disabled="disabledObj['package_type_isDisabled']"
                  v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','package_type')) || (!form['package_information_id'] && $check_field('add','package_type'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','package_type')">
                  {{ form['package_type'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','package_price') || ($check_field('add','package_price') || $check_field('set','package_price'))" label="套餐价格" name="package_price">
                            <uni-easyinput type="text" v-model="form['package_price']" v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','package_price')) || (!form['package_information_id'] && $check_field('add','package_price'))" :disabled="disabledObj['package_price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','package_price')">
                  {{ form['package_price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','merchant_name') || ($check_field('add','merchant_name') || $check_field('set','merchant_name'))" label="商家名称" name="merchant_name">
                            <uni-easyinput type="text" v-model="form['merchant_name']" v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','merchant_name')) || (!form['package_information_id'] && $check_field('add','merchant_name'))" :disabled="disabledObj['merchant_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','merchant_name')">
                  {{ form['merchant_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','contact_number') || ($check_field('add','contact_number') || $check_field('set','contact_number'))" label="联系电话" name="contact_number">
                            <uni-easyinput type="text" v-model="form['contact_number']" v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','contact_number')) || (!form['package_information_id'] && $check_field('add','contact_number'))" :disabled="disabledObj['contact_number_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','contact_number')">
                  {{ form['contact_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','detailed_description') || ($check_field('add','detailed_description') || $check_field('set','detailed_description'))" label="详情描述" name="detailed_description">
                    <uni-easyinput type="textarea" v-model="form['detailed_description']" v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','detailed_description')) || (!form['package_information_id'] && $check_field('add','detailed_description'))" :disabled="disabledObj['detailed_description_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','detailed_description')">
                  {{ form['detailed_description'] }}
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
      field: "package_information_id",
      url_add: "~/api/package_information/add?",
      url_set: "~/api/package_information/set?",
      url_get_obj: "~/api/package_information/get_obj?",
      url_upload: "~/api/package_information/upload?",

      query: {
        "package_information_id": 0,
      },

      form: {
            "package_name":  '', // 套餐名称
                    "cover":  '', // 封面
                    "flavor":  '', // 口味
                    "raw_material":  '', // 原材料
                    "package_type":  '', // 套餐类型
                    "package_price":  0 , // 套餐价格
                    "merchant_name":  '', // 商家名称
                    "contact_number":  '', // 联系电话
                    "detailed_description":  '', // 详情描述
                                "package_information_id": 0, // ID
                
              },
          disabledObj:{
                        "package_name_isDisabled": false,
                                "cover_isDisabled": false,
                                "flavor_isDisabled": false,
                                "raw_material_isDisabled": false,
                                "package_type_isDisabled": false,
                                                    "merchant_name_isDisabled": false,
                                "contact_number_isDisabled": false,
                                "detailed_description_isDisabled": false,
                                  },
                                                              // 口味选项列表
          list_flavor: [],
                                                          // 套餐类型选项列表
          list_package_type: [],
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
            url: _self.$fullUrl('/api/package_information/upload?'),
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
            url: _self.$fullUrl('/api/package_information/upload?'),
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
     * 获取口味列表
     */
    async get_list_flavor() {
              var json = await this.$get("~/api/flavor_management/get_list?");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_flavor.push({value:o.flavor_type,text:o.flavor_type}));
      }
      else if(json.error){
        console.error(json.error);
      }
        },
        
            
            /**
     * 获取套餐类型列表
     */
    async get_list_package_type() {
              var json = await this.$get("~/api/package_classification/get_list?");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_package_type.push({value:o.classification_name,text:o.classification_name}));
      }
      else if(json.error){
        console.error(json.error);
      }
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
        bl = this.$check_action('/package_information/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/package_information/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/package_information/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/package_information/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/package_information/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
                        this.get_list_flavor();
                        this.get_list_package_type();
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
