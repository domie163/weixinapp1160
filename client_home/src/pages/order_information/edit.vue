<template>
	<view class="diy_edit page_order_information" id="order_information_edit">
		<view class='warp'>
			<view class='container'>
				<view class='row'>
						<view v-if="$check_field('set','package_name') || $check_field('add','package_name') || $check_field('get','package_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								套餐名称:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_package_name" v-model="form['package_name']" placeholder="请输入套餐名称" v-if="(form['package_name'] && $check_field('set','package_name')) || (!form['package_name'] && $check_field('add','package_name'))" :disabled="disabledObj['package_name_isDisabled']" />
							<text v-else-if="$check_field('get','package_name')">{{ form['package_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','flavor') || $check_field('add','flavor') || $check_field('get','flavor')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								口味:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_flavor" v-model="form['flavor']" placeholder="请输入口味" v-if="(form['flavor'] && $check_field('set','flavor')) || (!form['flavor'] && $check_field('add','flavor'))" :disabled="disabledObj['flavor_isDisabled']" />
							<text v-else-if="$check_field('get','flavor')">{{ form['flavor'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','package_type') || $check_field('add','package_type') || $check_field('get','package_type')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								套餐类型:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_package_type" v-model="form['package_type']" placeholder="请输入套餐类型" v-if="(form['package_type'] && $check_field('set','package_type')) || (!form['package_type'] && $check_field('add','package_type'))" :disabled="disabledObj['package_type_isDisabled']" />
							<text v-else-if="$check_field('get','package_type')">{{ form['package_type'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','package_price') || $check_field('add','package_price') || $check_field('get','package_price')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								套餐价格:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_package_price" v-model="form['package_price']" placeholder="请输入套餐价格" v-if="(form['package_price'] && $check_field('set','package_price')) || (!form['package_price'] && $check_field('add','package_price'))" :disabled="disabledObj['package_price_isDisabled']" />
							<text v-else-if="$check_field('get','package_price')">{{ form['package_price'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','merchant_name') || $check_field('add','merchant_name') || $check_field('get','merchant_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								商家名称:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_merchant_name" v-model="form['merchant_name']" placeholder="请输入商家名称" v-if="(form['merchant_name'] && $check_field('set','merchant_name')) || (!form['merchant_name'] && $check_field('add','merchant_name'))" :disabled="disabledObj['merchant_name_isDisabled']" />
							<text v-else-if="$check_field('get','merchant_name')">{{ form['merchant_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','order_number') || $check_field('add','order_number') || $check_field('get','order_number')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								订单编号:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_order_number" v-model="form['order_number']" placeholder="请输入订单编号" v-if="(form['order_number'] && $check_field('set','order_number')) || (!form['order_number'] && $check_field('add','order_number'))" :disabled="true" />
							<text v-else-if="$check_field('get','order_number')">{{ form['order_number'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','user_number') || $check_field('add','user_number') || $check_field('get','user_number')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户编号:
							</text>
						</view>
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_user_number"
									v-model="form['user_number']"
									:localdata="list_user_user_number"
									:clear="!disabledObj['user_number_isDisabled']"
									:disabled="disabledObj['user_number_isDisabled']"
									v-if="(form['user_number'] && $check_field('set','user_number')) || (!form['user_number'] && $check_field('add','user_number'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','user_number')">{{ form['user_number'] }}</text>
						</view>
					</view>
							<view v-if="$check_field('set','full_name') || $check_field('add','full_name') || $check_field('get','full_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								姓名:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_full_name" v-model="form['full_name']" placeholder="请输入姓名" v-if="(form['full_name'] && $check_field('set','full_name')) || (!form['full_name'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']" />
							<text v-else-if="$check_field('get','full_name')">{{ form['full_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','phone_number') || $check_field('add','phone_number') || $check_field('get','phone_number')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								手机号码:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_phone_number" v-model="form['phone_number']" placeholder="请输入手机号码" v-if="(form['phone_number'] && $check_field('set','phone_number')) || (!form['phone_number'] && $check_field('add','phone_number'))" :disabled="disabledObj['phone_number_isDisabled']" />
							<text v-else-if="$check_field('get','phone_number')">{{ form['phone_number'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','shipping_address') || $check_field('add','shipping_address') || $check_field('get','shipping_address')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								收货地址:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_shipping_address" v-model="form['shipping_address']" placeholder="请输入收货地址" v-if="(form['shipping_address'] && $check_field('set','shipping_address')) || (!form['shipping_address'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']" />
							<text v-else-if="$check_field('get','shipping_address')">{{ form['shipping_address'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','purchase_time') || $check_field('add','purchase_time') || $check_field('get','purchase_time')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								购买时间:
							</text>
						</view>
								<!-- 日期 -->
						<view class="diy_field diy_date">
							<uni-datetime-picker :disabled="disabledObj['purchase_time_isDisabled']" type="date" id="form_purchase_time" v-model="form['purchase_time']" placeholder="请输入购买时间" v-if="(form['purchase_time'] && $check_field('set','purchase_time')) || (!form['purchase_time'] && $check_field('add','purchase_time'))" />
							<text v-else-if="$check_field('get','purchase_time')">{{ form['purchase_time'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','annotation_notes') || $check_field('add','annotation_notes') || $check_field('get','annotation_notes')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								标注说明:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_annotation_notes" v-model="form['annotation_notes']" placeholder="请输入标注说明" v-if="(form['annotation_notes'] && $check_field('set','annotation_notes')) || (!form['annotation_notes'] && $check_field('add','annotation_notes'))" :disabled="disabledObj['annotation_notes_isDisabled']" />
							<text v-else-if="$check_field('get','annotation_notes')">{{ form['annotation_notes'] }}</text>
						</view>
										</view>
	
				</view>
				<view class="row">
					<view class="col-12">
						<view class="btn_box">
							<button class="btn_submit primary_btn" @click="submit()">提交</button>
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
	mixins:[mixin],
	components:{},
	data(){
		return{
			url_get_obj:"~/api/order_information/get_obj?",
			url_add:"~/api/order_information/add?",
			url_set:"~/api/order_information/set?",

			// 登录权限
			oauth: {
				"signIn": true,
				"user_group": []
			},

			// 查询条件
			query: {
					"package_name": "",
						"flavor": "",
						"package_type": "",
						"package_price": 0,
						"merchant_name": "",
						"order_number": "",
						"user_number": 0,
						"full_name": "",
						"phone_number": "",
						"shipping_address": "",
						"purchase_time": "",
						"annotation_notes": "",
					"order_information_id": 0
			},

			obj: {
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
					"order_information_id": 0,

			},

			// 表单字段
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
					"order_information_id": 0,
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
											
			field:"order_information_id",
			table_key:"order_information",

		}
	},
	methods: {
			
	
				
	
				
	
				
	
				
	
				
	
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
				async get_user_session_user_number(){
			var _this = this;
			var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
			if(json.result && json.result.obj){
				var source_table = json.result.obj.source_table;
				var user_id = _this.$store.state.user.user_id;
				if (user_id){
					var url = "~/api/"+source_table+"/get_obj?"
					this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
						if (res.result && res.result.obj) {
							var arr = []
							for (let key in res.result.obj) {
								arr.push(key)
							}
							var arrForm = []
							for (let key in _this.form) {
								arrForm.push(key)
							}
							_this.form["user_number"] = user_id
							_this.disabledObj['user_number' + '_isDisabled'] = true
							for (var i=0;i<arr.length;i++){
                if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                  for (var j = 0; j < arrForm.length; j++) {
                    if (arr[i] === arrForm[j]) {
                      if (arr[i] !== "user_number") {
                        _this.form[arrForm[j]] = res.result.obj[arr[i]]
                        _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                        break;
                      }
                    }
                  }
                }
							}
						}
					});
				}
			}
			else if(json.error){
				console.error(json.error);
			}
		},
	
	
				
	
				
	
				
	
				
	
				
	
			change_file(key_name){
			var _self = this;
				this.$chooseFile().then(res=>{
					console.log(res)

						const uploadTask = uni.uploadFile({
							url: _self.$fullUrl("/api/feedback/upload?"),
							filePath: res[0].path,
							name: "file",
							formData: {
								i_want_to_customize: "test",
							},
							header: {
								"x-auth-token": _self.$store.state.user.token,
							},
							success: function(uploadFileRes) {
								console.log(uploadFileRes)
								var filename = JSON.parse(uploadFileRes.data).result.url;
								_self.form[key_name] = filename;
							},
						});

						uploadTask.onProgressUpdate(function(res) {
							_self.percent = res.progress;
							console.log("上传进度" + res.progress);
							console.log("已经上传的数据长度" + res.totalBytesSent);
							console.log(
								"预期需要上传的数据总长度" + res.totalBytesExpectedToSend
							);
						});

				})
		},
		change_img(key_name) {
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
							'order_information': 'test'
						},
						header: {
							'x-auth-token': _self.$store.state.user.token
						},
						success: function(uploadFileRes) {
							var filename = JSON.parse(uploadFileRes.data).result.url
							var img_url = filename
							_self.form[key_name] = img_url
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
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_after(json ,func){
			var form = uni.db.get("form");
			var obj = Object.assign({} ,form ,this.obj);
			if (form) {
				this.obj = uni.push(this.obj ,obj);
			}
			if (form) {
				this.form = uni.push(this.form ,form);
			}
			if(func){
				func(json);
			}
		},

	},
	onLoad(){
																						this.get_user_session_user_number();
				this.get_list_user_user_number();
																	},
}
</script>

<style scoped>
	input{
		font-size: 10px;
	}

	.form_edit {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
	}

	.left_text {
		flex: 0 0 25%;
		display: flex;
		align-items: center;
	}

	.right_text {
		flex: 0 0 75%;
		border-bottom: 1px solid #eee;
	}
	.right_text.btn_warp{
		border-bottom: 0;
	}

	.btn_submit {
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}

	.btn_submit:hover {
		opacity: 0.5;
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




</style>
<style scoped>
/*新样式*/
.diy_text_row {
  display: inline-block;
}
.container {
	margin-top:1rem ;
	padding: 1rem;
    -webkit-box-shadow: 0px 0px 0px #888888;
    box-shadow: 0px 0px 0px #888888;
}
.primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
	.btn_submit{
		padding: 0;
		margin-top:1rem ;
	}
	.row-item {
		padding: 10px 10px;
	    background: #f8f6fc;
		margin-bottom: 1rem;
	}
	.diy_field{
		padding-left: 1rem;
	}
	.diy_title{
		align-items: center;
        font-size: 14px;
        color: #333;
	}

	.row-item{
		display: flex !important;
		align-items: baseline;
	}
	.diy_select_flex{
		flex: 1;
	}
	.query_select{
		flex: 1;
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
</style>

