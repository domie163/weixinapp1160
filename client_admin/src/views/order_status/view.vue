<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','order_number')) || (!form['order_status_id'] && $check_field('add','order_number'))" :disabled="disabledObj['order_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','dish_name') || $check_field('add','dish_name') || $check_field('set','dish_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="菜品名称" prop="dish_name">
												<el-input id="dish_name" v-model="form['dish_name']" placeholder="请输入菜品名称"
							  v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','dish_name')) || (!form['order_status_id'] && $check_field('add','dish_name'))" :disabled="disabledObj['dish_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','dish_name')">{{form['dish_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_number') || $check_field('add','user_number') || $check_field('set','user_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户编号" prop="user_number">
													<el-select v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','user_number')) || (!form['order_status_id'] && $check_field('add','user_number'))" id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
							<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','user_number')" id="user_number" v-model="form['user_number']" :disabled="true">
							<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
												<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','full_name')) || (!form['order_status_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','phone_number') || $check_field('add','phone_number') || $check_field('set','phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="手机号码" prop="phone_number">
												<el-input id="phone_number" v-model="form['phone_number']" placeholder="请输入手机号码"
							  v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','phone_number')) || (!form['order_status_id'] && $check_field('add','phone_number'))" :disabled="disabledObj['phone_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','phone_number')">{{form['phone_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shipping_address') || $check_field('add','shipping_address') || $check_field('set','shipping_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="收货地址" prop="shipping_address">
												<el-input id="shipping_address" v-model="form['shipping_address']" placeholder="请输入收货地址"
							  v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','shipping_address')) || (!form['order_status_id'] && $check_field('add','shipping_address'))" :disabled="disabledObj['shipping_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','shipping_address')">{{form['shipping_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','record_time') || $check_field('add','record_time') || $check_field('set','record_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="记录时间" prop="record_time">
								<el-date-picker :disabled="disabledObj['record_time_isDisabled']" v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','record_time')) || (!form['order_status_id'] && $check_field('add','record_time'))" id="record_time"
						v-model="form['record_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','record_time')">{{form['record_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_status') || $check_field('add','order_status') || $check_field('set','order_status')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单状态" prop="order_status">
												<el-input id="order_status" v-model="form['order_status']" placeholder="请输入订单状态"
							  v-if="user_group === '管理员' || (form['order_status_id'] && $check_field('set','order_status')) || (!form['order_status_id'] && $check_field('add','order_status'))" :disabled="disabledObj['order_status_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_status')">{{form['order_status']}}</div>
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
				field: "order_status_id",
				url_add: "~/api/order_status/add?",
				url_set: "~/api/order_status/set?",
				url_get_obj: "~/api/order_status/get_obj?",
				url_upload: "~/api/order_status/upload?",

				query: {
					"order_status_id": 0,
				},

				form: {
								"order_number":  '', // 订单编号
										"dish_name":  '', // 菜品名称
										"user_number": 0, // 用户编号
										"full_name":  '', // 姓名
										"phone_number":  '', // 手机号码
										"shipping_address":  '', // 收货地址
										"record_time":  '', // 记录时间
										"order_status":  '', // 订单状态
											"order_status_id": 0, // ID
						
				},
				disabledObj:{
								"order_number_isDisabled": false,
										"dish_name_isDisabled": false,
										"user_number_isDisabled": false,
										"full_name_isDisabled": false,
										"phone_number_isDisabled": false,
										"shipping_address_isDisabled": false,
										"record_time_isDisabled": false,
										"order_status_isDisabled": false,
										},

	
		
		
					// 用户列表
				list_user_user_number: [],
				
		
		
		
		
	
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
														        if (this.form["record_time"].indexOf("-")===-1){
          this.form["record_time"] = this.$toTime(parseInt(this.form["record_time"]),"yyyy-MM-dd")
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


																				        if(this.form["record_time"]=="0000-00-00"){
          this.form["record_time"] = null;
        }
				if(parseInt(this.form["record_time"]) > 9999){
					this.form["record_time"] = this.$toTime(parseInt(this.form["record_time"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/order_status/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/order_status/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/order_status/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/order_status/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/order_status/view','get');
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
