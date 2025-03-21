<template>
	<view class="diy_details diy_div_order_status">
		<view v-if="Object.keys(obj).length!==0" class="warp">
			<view class="container">
				<view class="row">
					<view v-if="$check_field('get','order_number')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>订单编号:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["order_number"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','dish_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>菜品名称:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["dish_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','user_number')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>用户编号:</span>
						</view>
							<view class="diy_field diy_uid">
							<text>
								{{ get_user_user_number(obj['user_number']) }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','full_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>姓名:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["full_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','phone_number')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>手机号码:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["phone_number"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','shipping_address')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>收货地址:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["shipping_address"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','record_time')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>记录时间:</span>
						</view>
							<view class="diy_field diy_date">
							<text>
								{{ $toTime(obj["record_time"],"yyyy-MM-dd") }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','order_status')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>订单状态:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["order_status"]}}
							</text>
						</view>
						</view>
				</view>
			</view>
		</view>

			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/completed_order/edit')" v-if="$check_action('/completed_order/edit','add') || $check_action('/completed_order/edit','set')" >完成</button>
					</view>
				</view>
			</view>
		</view>
		</view>
</template>

<script>
	import mixin from "@/libs/mixins/component.js";
	export default {
		mixins: [mixin],
		props: {
			obj_goods: {
				type: Object,
				default(){
					return {}
				}
			},
			query:{
				type: Object,
				default(){
					return {
						order_status_id: 0
					}
				}
			}
		},
		data() {
			return {
				obj_goods_type: {},
				obj: {},
							// 用户列表
				list_user_user_number: [],
									}
		},
		methods: {
			async get_obj_goods_type() {
				var res = await this.$get("~/api/goods_type/get_obj", {
					name: this.obj_goods.type
				})

				if (res.result.obj) {
					this.obj_goods_type = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
			async get_obj_by_goods() {
				var {
					source_table,
					source_field
				} = this.obj_goods_type
				var {
					source_id
				} = this.obj_goods
				var query = {}
				query[source_field] = source_id
				this.$get("~/api/" + source_table + "/get_obj", {}, (res) => {
					if (res.result.obj) {
						this.obj = res.result.obj
					} else {
						console.log("没有请求到商品分类");
					}
				})
			},
			async get_obj_by_id(){
				var res = await this.$get("~/api/order_status/get_obj", {
					order_status_id:this.query.order_status_id
				})

				if (res.result && res.result.obj) {
					this.obj = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
						/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user_number() {
				var json = await this.$get("~/api/user/get_list?user_group=注册用户");
				if(json.result && json.result.list){
					this.list_user_user_number = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_user_number(id){
				let obj = this.list_user_user_number;
				let ret = "";
				for(let i=0;i<obj.length;i++){
					if(obj[i].user_id==id){
						ret = obj[i].nickname+"-"+obj[i].username;
					}
				}
				return ret;
			},
								},
		created() {
						this.get_list_user_user_number();
								},
		async onLoad(){
			if (Object.keys(this.obj_goods).length !== 0) {
				await this.get_obj_goods_type();
				await this.get_obj_by_goods();
			} else if (this.query["order_status_id"] !==0) {
				await this.get_obj_by_id();
			}
		}
	}
</script>

<style scoped>
	.div_order_status_details {}

	.details {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
		border-bottom: 1px solid #eee;
	}

	.left_text {
		flex: 0 0 25%;
	}

	.right_text {
		flex: 0 0 75%;
	}
	.edit_nav{
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}
</style>
