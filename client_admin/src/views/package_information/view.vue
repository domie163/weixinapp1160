<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','package_name') || $check_field('add','package_name') || $check_field('set','package_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="套餐名称" prop="package_name">
												<el-input id="package_name" v-model="form['package_name']" placeholder="请输入套餐名称"
							  v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','package_name')) || (!form['package_information_id'] && $check_field('add','package_name'))" :disabled="disabledObj['package_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','package_name')">{{form['package_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','cover') || $check_field('add','cover') || $check_field('set','cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="封面" prop="cover">
								<el-upload :disabled="disabledObj['cover_isDisabled']" id="cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','cover')) || (!form['package_information_id'] && $check_field('add','cover'))">
						<img v-if="form['cover']" :src="$fullUrl(form['cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['cover'])" :preview-src-list="[$fullUrl(form['cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','flavor') || $check_field('add','flavor') || $check_field('set','flavor')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="口味" prop="flavor">
								<el-select id="flavor" v-model="form['flavor']"
						v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','flavor')) || (!form['package_information_id'] && $check_field('add','flavor'))">
						<el-option v-for="o in list_flavor" :key="o['flavor_type']" :label="o['flavor_type']"
							:value="o['flavor_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','flavor')">{{form['flavor']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','raw_material') || $check_field('add','raw_material') || $check_field('set','raw_material')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="原材料" prop="raw_material">
												<el-input id="raw_material" v-model="form['raw_material']" placeholder="请输入原材料"
							  v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','raw_material')) || (!form['package_information_id'] && $check_field('add','raw_material'))" :disabled="disabledObj['raw_material_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','raw_material')">{{form['raw_material']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','package_type') || $check_field('add','package_type') || $check_field('set','package_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="套餐类型" prop="package_type">
								<el-select id="package_type" v-model="form['package_type']"
						v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','package_type')) || (!form['package_information_id'] && $check_field('add','package_type'))">
						<el-option v-for="o in list_package_type" :key="o['classification_name']" :label="o['classification_name']"
							:value="o['classification_name']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','package_type')">{{form['package_type']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','package_price') || $check_field('add','package_price') || $check_field('set','package_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="套餐价格" prop="package_price">
								<el-input-number id="package_price" v-model.number="form['package_price']"
						v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','package_price')) || (!form['package_information_id'] && $check_field('add','package_price'))" :disabled="disabledObj['package_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','package_price')">{{form['package_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','merchant_name') || $check_field('add','merchant_name') || $check_field('set','merchant_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商家名称" prop="merchant_name">
												<el-input id="merchant_name" v-model="form['merchant_name']" placeholder="请输入商家名称"
							  v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','merchant_name')) || (!form['package_information_id'] && $check_field('add','merchant_name'))" :disabled="disabledObj['merchant_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','merchant_name')">{{form['merchant_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_number') || $check_field('add','contact_number') || $check_field('set','contact_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系电话" prop="contact_number">
												<el-input id="contact_number" v-model="form['contact_number']" placeholder="请输入联系电话"
							  v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','contact_number')) || (!form['package_information_id'] && $check_field('add','contact_number'))" :disabled="disabledObj['contact_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_number')">{{form['contact_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','detailed_description') || $check_field('add','detailed_description') || $check_field('set','detailed_description')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="详情描述" prop="detailed_description">
					<quill-editor v-model.number="form['detailed_description']"
						v-if="user_group === '管理员' || (form['package_information_id'] && $check_field('set','detailed_description')) || (!form['package_information_id'] && $check_field('add','detailed_description')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','detailed_description')" v-html="form['detailed_description']"></div>
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
										"package_price":  0, // 套餐价格
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
					          			"package_price_isDisabled": false,
										"merchant_name_isDisabled": false,
										"contact_number_isDisabled": false,
										"detailed_description_isDisabled": false,
										},

	
		
						// 口味选项列表
				list_flavor: [""],
	
		
						// 套餐类型选项列表
				list_package_type: [""],
	
		
		
		
		
	
			}
		},
		methods: {


	
	
						/**
			 * 上传封面
			 * @param {Object} param 图片参数
			 */
			upload_cover(param){
						this.uploadFile(param.file, "cover");
					},
	
	
			
				/**
			 * 获取口味列表
			 */
			async get_list_flavor() {
				var json = await this.$get("~/api/flavor_management/get_list?");
				if(json.result && json.result.list){
					this.list_flavor = json.result.list;
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
					this.list_package_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
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
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
								this.get_list_flavor();
								this.get_list_package_type();
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
