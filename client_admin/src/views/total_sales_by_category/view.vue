<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','title') || $check_field('add','title') || $check_field('set','title')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="标题" prop="title">
												<el-input id="title" v-model="form['title']" placeholder="请输入标题"
							  v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','title')) || (!form['total_sales_by_category_id'] && $check_field('add','title'))" :disabled="disabledObj['title_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','title')">{{form['title']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','statistical_time') || $check_field('add','statistical_time') || $check_field('set','statistical_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="统计时间" prop="statistical_time">
												<el-input id="statistical_time" v-model="form['statistical_time']" placeholder="请输入统计时间"
							  v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','statistical_time')) || (!form['total_sales_by_category_id'] && $check_field('add','statistical_time'))" :disabled="disabledObj['statistical_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','statistical_time')">{{form['statistical_time']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','classification_name') || $check_field('add','classification_name') || $check_field('set','classification_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="分类名称" prop="classification_name">
												<el-input id="classification_name" v-model="form['classification_name']" placeholder="请输入分类名称"
							  v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','classification_name')) || (!form['total_sales_by_category_id'] && $check_field('add','classification_name'))" :disabled="disabledObj['classification_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','classification_name')">{{form['classification_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','total_sales') || $check_field('add','total_sales') || $check_field('set','total_sales')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="总销量" prop="total_sales">
								<el-input-number id="total_sales" v-model.number="form['total_sales']"
						v-if="user_group === '管理员' || (form['total_sales_by_category_id'] && $check_field('set','total_sales')) || (!form['total_sales_by_category_id'] && $check_field('add','total_sales'))" :disabled="disabledObj['total_sales_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','total_sales')">{{form['total_sales']}}</div>
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
										"total_sales":  0, // 总销量
											"total_sales_by_category_id": 0, // ID
						
				},
				disabledObj:{
								"title_isDisabled": false,
										"statistical_time_isDisabled": false,
										"classification_name_isDisabled": false,
					          			"total_sales_isDisabled": false,
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
