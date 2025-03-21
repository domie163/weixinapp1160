<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','package_name') || ($check_field('add','package_name') || $check_field('set','package_name'))" label="套餐名称" name="package_name">
                            <uni-easyinput type="text" v-model="form['package_name']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','package_name')) || (!form['order_information_id'] && $check_field('add','package_name'))" :disabled="disabledObj['package_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','package_name')">
                  {{ form['package_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','flavor') || ($check_field('add','flavor') || $check_field('set','flavor'))" label="口味" name="flavor">
                            <uni-easyinput type="text" v-model="form['flavor']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','flavor')) || (!form['order_information_id'] && $check_field('add','flavor'))" :disabled="disabledObj['flavor_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','flavor')">
                  {{ form['flavor'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','package_type') || ($check_field('add','package_type') || $check_field('set','package_type'))" label="套餐类型" name="package_type">
                            <uni-easyinput type="text" v-model="form['package_type']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','package_type')) || (!form['order_information_id'] && $check_field('add','package_type'))" :disabled="disabledObj['package_type_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','package_type')">
                  {{ form['package_type'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','package_price') || ($check_field('add','package_price') || $check_field('set','package_price'))" label="套餐价格" name="package_price">
                            <uni-easyinput type="text" v-model="form['package_price']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','package_price')) || (!form['order_information_id'] && $check_field('add','package_price'))" :disabled="disabledObj['package_price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','package_price')">
                  {{ form['package_price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','merchant_name') || ($check_field('add','merchant_name') || $check_field('set','merchant_name'))" label="商家名称" name="merchant_name">
                            <uni-easyinput type="text" v-model="form['merchant_name']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','merchant_name')) || (!form['order_information_id'] && $check_field('add','merchant_name'))" :disabled="disabledObj['merchant_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','merchant_name')">
                  {{ form['merchant_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','order_number') || ($check_field('add','order_number') || $check_field('set','order_number'))" label="订单编号" name="order_number">
                            <uni-easyinput type="text" v-model="form['order_number']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','order_number')) || (!form['order_information_id'] && $check_field('add','order_number'))"  :disabled="true" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_number')">
                  {{ form['order_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_number') || ($check_field('add','user_number') || $check_field('set','user_number'))" label="用户编号" name="user_number">
                    <uni-data-select
                  id="form_user_number"
                  v-model="form['user_number']"
                  :localdata="list_user_user_number"
                  :clear="!disabledObj['user_number_isDisabled']"
                  :disabled="disabledObj['user_number_isDisabled']"
                  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','user_number')) || (!form['order_information_id'] && $check_field('add','user_number'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['user_number']"
                  :localdata="list_user_user_number"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','user_number')" id="user_number"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','full_name') || ($check_field('add','full_name') || $check_field('set','full_name'))" label="姓名" name="full_name">
                            <uni-easyinput type="text" v-model="form['full_name']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','full_name')) || (!form['order_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','full_name')">
                  {{ form['full_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','phone_number') || ($check_field('add','phone_number') || $check_field('set','phone_number'))" label="手机号码" name="phone_number">
                            <uni-easyinput type="text" v-model="form['phone_number']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','phone_number')) || (!form['order_information_id'] && $check_field('add','phone_number'))" :disabled="disabledObj['phone_number_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','phone_number')">
                  {{ form['phone_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','shipping_address') || ($check_field('add','shipping_address') || $check_field('set','shipping_address'))" label="收货地址" name="shipping_address">
                            <uni-easyinput type="text" v-model="form['shipping_address']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','shipping_address')) || (!form['order_information_id'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','shipping_address')">
                  {{ form['shipping_address'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','purchase_time') || ($check_field('add','purchase_time') || $check_field('set','purchase_time'))" label="购买时间" name="purchase_time">
                    <uni-datetime-picker v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','purchase_time')) || (!form['order_information_id'] && $check_field('add','purchase_time'))" v-model="form['purchase_time']" type="date" :disabled="disabledObj['purchase_time_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','purchase_time')">
                  {{ form['purchase_time'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','annotation_notes') || ($check_field('add','annotation_notes') || $check_field('set','annotation_notes'))" label="标注说明" name="annotation_notes">
                            <uni-easyinput type="text" v-model="form['annotation_notes']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','annotation_notes')) || (!form['order_information_id'] && $check_field('add','annotation_notes'))" :disabled="disabledObj['annotation_notes_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','annotation_notes')">
                  {{ form['annotation_notes'] }}
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
      field: "order_information_id",
      url_add: "~/api/order_information/add?",
      url_set: "~/api/order_information/set?",
      url_get_obj: "~/api/order_information/get_obj?",
      url_upload: "~/api/order_information/upload?",

      query: {
        "order_information_id": 0,
      },

      form: {
            "package_name":  '', // 套餐名称
                    "flavor":  '', // 口味
                    "package_type":  '', // 套餐类型
                    "package_price":  0 , // 套餐价格
                    "merchant_name":  '', // 商家名称
                    "order_number": this.$get_stamp(), // 订单编号
                    "user_number": 0, // 用户编号
                    "full_name":  '', // 姓名
                    "phone_number":  '', // 手机号码
                    "shipping_address":  '', // 收货地址
                    "purchase_time": this.$toTime(new Date().getTime(), "yyyy-MM-dd"),
                    "annotation_notes":  '', // 标注说明
                                "order_information_id": 0, // ID
                
              },
          disabledObj:{
                        "package_name_isDisabled": false,
                                "flavor_isDisabled": false,
                                "package_type_isDisabled": false,
                                                    "merchant_name_isDisabled": false,
                                "order_number_isDisabled": false,
                                "user_number_isDisabled": false,
                                "full_name_isDisabled": false,
                                "phone_number_isDisabled": false,
                                "shipping_address_isDisabled": false,
                                "purchase_time_isDisabled": false,
                                "annotation_notes_isDisabled": false,
                                  },
                                                                                                                                                        // 用户列表
            list_user_user_number: [],
                        // 用户组
            group_user_user_number: "",
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
            url: _self.$fullUrl('/api/order_information/upload?'),
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
            url: _self.$fullUrl('/api/order_information/upload?'),
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
                                                                                              if (this.form["purchase_time"] && JSON.stringify(this.form["purchase_time"]).indexOf("-")===-1) {
        this.form["purchase_time"] = this.$toTime(parseInt(this.form["purchase_time"]), "yyyy-MM-dd")
      }
                  uni.db.del("form");
      return param;
    },
        
            
            
            
            
            
                /**
     * 获取注册用户用户列表
     */
    async get_list_user_user_number() {
      // if(this.user_group !== "管理员" && this.form["user_number"] === 0) {
      //     this.form["user_number"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=注册用户");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_user_number.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            /**
     * 获取注册用户用户组
     */
    async get_group_user_user_number() {
      this.form["user_number"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
      if(json.result && json.result.obj){
        this.group_user_user_number = json.result.obj;
        this.get_user_session_user_number(this.form['user_number'])
      }
      else if(json.error){
        console.error(json.error);
      }
    },
    get_user_session_user_number(id){
      var _this = this;
      var user_id = {"user_id":id}
      var url = "~/api/"+_this.group_user_user_number.source_table+"/get_obj?"
      this.$get(url, user_id, function(res) {
        if (res.result && res.result.obj) {
          var arr = []
          for (let key in res.result.obj) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in _this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arr[i] === arrForm[j]) {
                  if (arr[i] !== "user_number") {
                    _this.form[arrForm[j]] = res.result.obj[arr[i]]
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                    break;
                  } else {
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  }
                }
              }
            }
          }
        }
      });
    },
            
            
            
            
            
            
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                                                              if (this.form["purchase_time"] && JSON.stringify(this.form["purchase_time"]).indexOf("-")===-1) {
        this.form["purchase_time"] = this.$toTime(parseInt(this.form["purchase_time"]),"yyyy-MM-dd")
      }
                },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/order_information/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/order_information/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/order_information/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/order_information/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/order_information/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
                                                            this.get_list_user_user_number();
            this.get_group_user_user_number();
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
