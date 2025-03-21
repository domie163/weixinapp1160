<template>
	<el-form ref="form" :rules="rules" :model="form" status-icon label-width="80px">
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="口味" prop="flavor">
						<el-select id="flavor" v-model="form['flavor']"
					v-if="user_group == '管理员' || (form['dish_information_id'] && $check_field('set','flavor') ) || $check_field('add','flavor')">
					<el-option v-for="o in list_flavor" :key="o.flavor_type" :label="o.flavor_type"
						:value="o.flavor_type">
					</el-option>
				</el-select>
				<div v-else-if="$check_field('get','flavor')">{{form['flavor']}}</div>
					</el-form-item>
		</el-col>
				<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="原料" prop="raw_material">
						<el-input id="raw_material" v-model="form['raw_material']" placeholder="请输入原料"
					v-if="user_group == '管理员' || (form['dish_information_id'] && $check_field('set','raw_material') ) || $check_field('add','raw_material')"></el-input>
				<div v-else-if="$check_field('get','raw_material')">{{form['raw_material']}}</div>
					</el-form-item>
		</el-col>
				<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="商家名称" prop="merchant_name">
						<el-input id="merchant_name" v-model="form['merchant_name']" placeholder="请输入商家名称"
					v-if="user_group == '管理员' || (form['dish_information_id'] && $check_field('set','merchant_name') ) || $check_field('add','merchant_name')"></el-input>
				<div v-else-if="$check_field('get','merchant_name')">{{form['merchant_name']}}</div>
					</el-form-item>
		</el-col>
				<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="联系电话" prop="contact_number">
						<el-input id="contact_number" v-model="form['contact_number']" placeholder="请输入联系电话"
					v-if="user_group == '管理员' || (form['dish_information_id'] && $check_field('set','contact_number') ) || $check_field('add','contact_number')"></el-input>
				<div v-else-if="$check_field('get','contact_number')">{{form['contact_number']}}</div>
					</el-form-item>
		</el-col>
	


		<el-col :xs="24" :sm="24" :lg="24" style="text-align: center;" class="el_form_btn_warp">
			<el-button type="primary" @click="submit()">提交</el-button>
			<el-button @click="cancel()">取消</el-button>
		</el-col>

	</el-form>
</template>

<script>
	import mixin from "../../mixins/component.js";

	export default {
		mixins: [mixin],
		props:{
			query: {
				type: Object,
				default: function(){
					return {
						"dish_information_id": 0
					}
				}
			},
			form_goods:{
				type: Object,
				default: function(){
					return {}
				}
			},
			func_check:{
				type: Function,
				default: function(fun){
					console.log("调试输出",fun);
				}
			},
			func_submit:{
				type: Function,
				default: function(fun){
					console.log("调试输出",fun);
				}
			}
		},
		data() {
			return {
				field: "dish_information_id",
				url_add: "~/api/dish_information/add?",
				url_set: "~/api/dish_information/set?",
				url_get_obj: "~/api/dish_information/get_obj?",
				url_upload: "~/api/dish_information/upload?",

				form: {
						"flavor":  '',
							"raw_material":  '',
							"merchant_name":  '',
							"contact_number":  '',
					},

					list_flavor: [""],
				
				rules: {
					"flavor": [     {required: true,message: '口味不能为空'},  ],
					"raw_material": [     {required: true,message: '原料不能为空'},  ],
					"merchant_name": [     {required: true,message: '商家名称不能为空'},  ],
					"contact_number": [     {required: true,message: '联系电话不能为空'},  ],
				}

			}
		},
		methods: {

			/**
			 * 请求列表前
			 * @param {Object} param
			 */
			get_list_before(param) {
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
																		}
				}

				return param;
			},

	
	
				/**
			 * 获取口味列表
			 */
			async get_list_flavor() {
				var list = await this.$get("~/api/flavor_management/get_list?");
				this.list_flavor = list.result.list;
			},
		
	
		
	
		
	
	
			submit(){
				this.func_check(()=>{
					this.$refs["form"].validate((valid)} => {
						if (valid) {
							this.submit();
						} else {
							console.error('error 提交失败!!');
						}
					});
				})
			},

			submit_after(){
				var source_id = this.form_goods.source_id;
				if(source_id){
					this.func_submit();
				}else{
					this.$get('~/api/dish_information/get_obj?',this.form,(res)=>{
						if(res.result && res.result.obj){
							this.form_goods.source_id = res.result.obj["dish_information_id"];
							this.func_submit();
						}else{
							console.error(res.error);
						}

					})
				}
			}
		},
		created() {
				this.get_list_flavor();
						}
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
