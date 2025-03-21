import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告消息列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告消息详情'
		}
	},

	// 商品路由
	// {
	// 	path: '/goods/table',
	// 	name: 'goods_table',
	// 	component: () => import('../views/goods/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '商品列表'
	// 	}
	// },
	// {
	// 	path: '/goods/view',
	// 	name: 'goods_view',
	// 	component: () => import('../views/goods/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '商品详情'
	// 	}
	// },

	// 商品分类路由
	{
		path: '/goods_type/table',
		name: 'goods_type_table',
		component: () => import('../views/goods_type/table.vue'),
		meta: {
			index: 0,
			title: '商品分类列表'
		}
	},
	{
		path: '/goods_type/view',
		name: 'goods_type_view',
		component: () => import('../views/goods_type/view.vue'),
		meta: {
			index: 0,
			title: '商品分类详情'
		}
	},

	// 订单路由
	{
		path: '/order/table',
		name: 'order_table',
		component: () => import('../views/order/table.vue'),
		meta: {
			index: 0,
			title: '订单列表'
		}
	},
	{
		path: '/order/view',
		name: 'order_view',
		component: () => import('../views/order/view.vue'),
		meta: {
			index: 0,
			title: '订单详情'
		}
	},

	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 注册用户路由
	{
		path: '/registered_users/table',
		name: 'registered_users_table',
		component: () => import('../views/registered_users/table.vue'),
		meta: {
			index: 0,
			title: '注册用户列表'
		}
	},
	{
		path: '/registered_users/view',
		name: 'registered_users_view',
		component: () => import('../views/registered_users/view.vue'),
		meta: {
			index: 0,
			title: '注册用户详情'
		}
	},
	// 菜品信息路由
	{
		path: '/dish_information/table',
		name: 'dish_information_table',
		component: () => import('../views/dish_information/table.vue'),
		meta: {
			index: 0,
			title: '菜品信息列表'
		}
	},
	{
		path: '/dish_information/view',
		name: 'dish_information_view',
		component: () => import('../views/dish_information/view.vue'),
		meta: {
			index: 0,
			title: '菜品信息详情'
		}
	},
	// 口味管理路由
	{
		path: '/flavor_management/table',
		name: 'flavor_management_table',
		component: () => import('../views/flavor_management/table.vue'),
		meta: {
			index: 0,
			title: '口味管理列表'
		}
	},
	{
		path: '/flavor_management/view',
		name: 'flavor_management_view',
		component: () => import('../views/flavor_management/view.vue'),
		meta: {
			index: 0,
			title: '口味管理详情'
		}
	},
	// 员工路由
	{
		path: '/staff/table',
		name: 'staff_table',
		component: () => import('../views/staff/table.vue'),
		meta: {
			index: 0,
			title: '员工列表'
		}
	},
	{
		path: '/staff/view',
		name: 'staff_view',
		component: () => import('../views/staff/view.vue'),
		meta: {
			index: 0,
			title: '员工详情'
		}
	},
	// 套餐信息路由
	{
		path: '/package_information/table',
		name: 'package_information_table',
		component: () => import('../views/package_information/table.vue'),
		meta: {
			index: 0,
			title: '套餐信息列表'
		}
	},
	{
		path: '/package_information/view',
		name: 'package_information_view',
		component: () => import('../views/package_information/view.vue'),
		meta: {
			index: 0,
			title: '套餐信息详情'
		}
	},
	// 套餐分类路由
	{
		path: '/package_classification/table',
		name: 'package_classification_table',
		component: () => import('../views/package_classification/table.vue'),
		meta: {
			index: 0,
			title: '套餐分类列表'
		}
	},
	{
		path: '/package_classification/view',
		name: 'package_classification_view',
		component: () => import('../views/package_classification/view.vue'),
		meta: {
			index: 0,
			title: '套餐分类详情'
		}
	},
	// 订单信息路由
	{
		path: '/order_information/table',
		name: 'order_information_table',
		component: () => import('../views/order_information/table.vue'),
		meta: {
			index: 0,
			title: '订单信息列表'
		}
	},
	{
		path: '/order_information/view',
		name: 'order_information_view',
		component: () => import('../views/order_information/view.vue'),
		meta: {
			index: 0,
			title: '订单信息详情'
		}
	},
	// 订单退款路由
	{
		path: '/order_refund/table',
		name: 'order_refund_table',
		component: () => import('../views/order_refund/table.vue'),
		meta: {
			index: 0,
			title: '订单退款列表'
		}
	},
	{
		path: '/order_refund/view',
		name: 'order_refund_view',
		component: () => import('../views/order_refund/view.vue'),
		meta: {
			index: 0,
			title: '订单退款详情'
		}
	},
	// 订单状态路由
	{
		path: '/order_status/table',
		name: 'order_status_table',
		component: () => import('../views/order_status/table.vue'),
		meta: {
			index: 0,
			title: '订单状态列表'
		}
	},
	{
		path: '/order_status/view',
		name: 'order_status_view',
		component: () => import('../views/order_status/view.vue'),
		meta: {
			index: 0,
			title: '订单状态详情'
		}
	},
	// 已完成订单路由
	{
		path: '/completed_order/table',
		name: 'completed_order_table',
		component: () => import('../views/completed_order/table.vue'),
		meta: {
			index: 0,
			title: '已完成订单列表'
		}
	},
	{
		path: '/completed_order/view',
		name: 'completed_order_view',
		component: () => import('../views/completed_order/view.vue'),
		meta: {
			index: 0,
			title: '已完成订单详情'
		}
	},
	// 联系客服路由
	{
		path: '/contact_customer_service/table',
		name: 'contact_customer_service_table',
		component: () => import('../views/contact_customer_service/table.vue'),
		meta: {
			index: 0,
			title: '联系客服列表'
		}
	},
	{
		path: '/contact_customer_service/view',
		name: 'contact_customer_service_view',
		component: () => import('../views/contact_customer_service/view.vue'),
		meta: {
			index: 0,
			title: '联系客服详情'
		}
	},
	// 关于我们路由
	{
		path: '/about_us/table',
		name: 'about_us_table',
		component: () => import('../views/about_us/table.vue'),
		meta: {
			index: 0,
			title: '关于我们列表'
		}
	},
	{
		path: '/about_us/view',
		name: 'about_us_view',
		component: () => import('../views/about_us/view.vue'),
		meta: {
			index: 0,
			title: '关于我们详情'
		}
	},
	// 分类销售额路由
	{
		path: '/classified_sales/table',
		name: 'classified_sales_table',
		component: () => import('../views/classified_sales/table.vue'),
		meta: {
			index: 0,
			title: '分类销售额列表'
		}
	},
	{
		path: '/classified_sales/view',
		name: 'classified_sales_view',
		component: () => import('../views/classified_sales/view.vue'),
		meta: {
			index: 0,
			title: '分类销售额详情'
		}
	},
	// 分类总销量路由
	{
		path: '/total_sales_by_category/table',
		name: 'total_sales_by_category_table',
		component: () => import('../views/total_sales_by_category/table.vue'),
		meta: {
			index: 0,
			title: '分类总销量列表'
		}
	},
	{
		path: '/total_sales_by_category/view',
		name: 'total_sales_by_category_view',
		component: () => import('../views/total_sales_by_category/view.vue'),
		meta: {
			index: 0,
			title: '分类总销量详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "外卖系统小程序-admin";
	document.title = title;
})

export default router
