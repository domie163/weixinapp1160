<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','package_name') || $check_field('add','package_name') || $check_field('set','package_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="套餐名称" prop="package_name">
												<el-input id="package_name" v-model="form['package_name']" placeholder="请输入套餐名称"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','package_name')) || (!form['order_information_id'] && $check_field('add','package_name'))" :disabled="disabledObj['package_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','package_name')">{{form['package_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','flavor') || $check_field('add','flavor') || $check_field('set','flavor')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="口味" prop="flavor">
												<el-input id="flavor" v-model="form['flavor']" placeholder="请输入口味"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','flavor')) || (!form['order_information_id'] && $check_field('add','flavor'))" :disabled="disabledObj['flavor_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','flavor')">{{form['flavor']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','package_type') || $check_field('add','package_type') || $check_field('set','package_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="套餐类型" prop="package_type">
												<el-input id="package_type" v-model="form['package_type']" placeholder="请输入套餐类型"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','package_type')) || (!form['order_information_id'] && $check_field('add','package_type'))" :disabled="disabledObj['package_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','package_type')">{{form['package_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','package_price') || $check_field('add','package_price') || $check_field('set','package_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="套餐价格" prop="package_price">
								<el-input-number id="package_price" v-model.number="form['package_price']"
						v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','package_price')) || (!form['order_information_id'] && $check_field('add','package_price'))" :disabled="disabledObj['package_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','package_price')">{{form['package_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','merchant_name') || $check_field('add','merchant_name') || $check_field('set','merchant_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商家名称" prop="merchant_name">
												<el-input id="merchant_name" v-model="form['merchant_name']" placeholder="请输入商家名称"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','merchant_name')) || (!form['order_information_id'] && $check_field('add','merchant_name'))" :disabled="disabledObj['merchant_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','merchant_name')">{{form['merchant_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','order_number')) || (!form['order_information_id'] && $check_field('add','order_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_number') || $check_field('add','user_number') || $check_field('set','user_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户编号" prop="user_number">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_number(form['user_number']) }}
							<!--<el-input id="business_name" v-model="form['user_number']" placeholder="请输入用户编号"-->
							<!--v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','user_number')) || (!form['order_information_id'] && $check_field('add','user_number'))" :disabled="disabledObj['user_number_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_number')">{{form['user_number']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','user_number')) || (!form['order_information_id'] && $check_field('add','user_number'))" id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
								<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','user_number')" id="user_number" v-model="form['user_number']" :disabled="true">
								<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
							<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
												<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','full_name')) || (!form['order_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','phone_number') || $check_field('add','phone_number') || $check_field('set','phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="手机号码" prop="phone_number">
												<el-input id="phone_number" v-model="form['phone_number']" placeholder="请输入手机号码"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','phone_number')) || (!form['order_information_id'] && $check_field('add','phone_number'))" :disabled="disabledObj['phone_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','phone_number')">{{form['phone_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shipping_address') || $check_field('add','shipping_address') || $check_field('set','shipping_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货地址" prop="shipping_address">
												<el-input id="shipping_address" v-model="form['shipping_address']" placeholder="请输入收货地址"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','shipping_address')) || (!form['order_information_id'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','shipping_address')">{{form['shipping_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','purchase_time') || $check_field('add','purchase_time') || $check_field('set','purchase_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="购买时间" prop="purchase_time">
								<el-date-picker :disabled="disabledObj['purchase_time_isDisabled']" v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','purchase_time')) || (!form['order_information_id'] && $check_field('add','purchase_time'))" id="purchase_time"
						v-model="form['purchase_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','purchase_time')">{{form['purchase_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','annotation_notes') || $check_field('add','annotation_notes') || $check_field('set','annotation_notes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="标注说明" prop="annotation_notes">
												<el-input id="annotation_notes" v-model="form['annotation_notes']" placeholder="请输入标注说明"
							  v-if="user_group === '管理员' || (form['order_information_id'] && $check_field('set','annotation_notes')) || (!form['order_information_id'] && $check_field('add','annotation_notes'))" :disabled="disabledObj['annotation_notes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','annotation_notes')">{{form['annotation_notes']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

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
										"package_price":  0, // 套餐价格
										"merchant_name":  '', // 商家名称
										"order_number": this.$get_stamp(), // 订单编号
										"user_number": 0, // 用户编号
										"full_name":  '', // 姓名
										"phone_number":  '', // 手机号码
										"shipping_address":  '', // 收货地址
										"purchase_time":  '', // 购买时间
										"annotation_notes":  '', // 标注说明
											"order_information_id": 0, // ID
						
				},
				disabledObj:{
								"package_name_isDisabled": false,
										"flavor_isDisabled": false,
										"package_type_isDisabled": false,
					          			"package_price_isDisabled": false,
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


	
	
			
	
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user_number() {
                // if(this.user_group !== "管理员" && this.form["user_number"] === 0) {
                //     this.form["user_number"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=注册用户");
                if(json.result && json.result.list){
                    this.list_user_user_number = json.result.list;
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
												_this.form["user_number"] = id
									_this.disabledObj['user_number' + '_isDisabled'] = true
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
					get_user_user_number(id){
				var obj = this.list_user_user_number.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
											// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
																		
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																						        if (this.form["purchase_time"].indexOf("-")===-1){
          this.form["purchase_time"] = this.$toTime(parseInt(this.form["purchase_time"]),"yyyy-MM-dd")
        }
							$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																																        if(this.form["purchase_time"]=="0000-00-00"){
          this.form["purchase_time"] = null;
        }
				if(parseInt(this.form["purchase_time"]) > 9999){
					this.form["purchase_time"] = this.$toTime(parseInt(this.form["purchase_time"]),"yyyy-MM-dd")
				}
					


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																										return msg;
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
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
																	this.get_list_user_user_number();
					this.get_group_user_user_number();
															},
	}
</script>

<style>
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

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
