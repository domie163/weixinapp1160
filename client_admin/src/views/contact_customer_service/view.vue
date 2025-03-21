<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','customer_service_name') || $check_field('add','customer_service_name') || $check_field('set','customer_service_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="客服名称" prop="customer_service_name">
												<el-input id="customer_service_name" v-model="form['customer_service_name']" placeholder="请输入客服名称"
							  v-if="user_group === '管理员' || (form['contact_customer_service_id'] && $check_field('set','customer_service_name')) || (!form['contact_customer_service_id'] && $check_field('add','customer_service_name'))" :disabled="disabledObj['customer_service_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','customer_service_name')">{{form['customer_service_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_number') || $check_field('add','contact_number') || $check_field('set','contact_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系电话" prop="contact_number">
												<el-input id="contact_number" v-model="form['contact_number']" placeholder="请输入联系电话"
							  v-if="user_group === '管理员' || (form['contact_customer_service_id'] && $check_field('set','contact_number')) || (!form['contact_customer_service_id'] && $check_field('add','contact_number'))" :disabled="disabledObj['contact_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_number')">{{form['contact_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_content') || $check_field('add','service_content') || $check_field('set','service_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务内容" prop="service_content">
								<el-input type="textarea" id="service_content" v-model="form['service_content']" placeholder="请输入服务内容"
						v-if="user_group === '管理员' || (form['contact_customer_service_id'] && $check_field('set','service_content')) || (!form['contact_customer_service_id'] && $check_field('add','service_content'))" :disabled="disabledObj['service_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','service_content')">{{form['service_content']}}</div>
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
				field: "contact_customer_service_id",
				url_add: "~/api/contact_customer_service/add?",
				url_set: "~/api/contact_customer_service/set?",
				url_get_obj: "~/api/contact_customer_service/get_obj?",
				url_upload: "~/api/contact_customer_service/upload?",

				query: {
					"contact_customer_service_id": 0,
				},

				form: {
								"customer_service_name":  '', // 客服名称
										"contact_number":  '', // 联系电话
										"service_content":  '', // 服务内容
											"contact_customer_service_id": 0, // ID
						
				},
				disabledObj:{
								"customer_service_name_isDisabled": false,
										"contact_number_isDisabled": false,
										"service_content_isDisabled": false,
										},

	
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
		
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
										$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


									


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
					bl = this.$check_action('/contact_customer_service/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/contact_customer_service/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/contact_customer_service/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/contact_customer_service/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/contact_customer_service/view','get');
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
