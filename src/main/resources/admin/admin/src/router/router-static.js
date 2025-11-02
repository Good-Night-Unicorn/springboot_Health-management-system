import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import jiankangdangan from '@/views/modules/jiankangdangan/list'
	import jiankangyisheng from '@/views/modules/jiankangyisheng/list'
	import yonghu from '@/views/modules/yonghu/list'
	import jiankangshuju from '@/views/modules/jiankangshuju/list'
	import chat from '@/views/modules/chat/list'
	import zhinengchuandaishebei from '@/views/modules/zhinengchuandaishebei/list'
	import jiankangjihua from '@/views/modules/jiankangjihua/list'
	import zixunleixing from '@/views/modules/zixunleixing/list'
	import config from '@/views/modules/config/list'
	import discussjiankangzixun from '@/views/modules/discussjiankangzixun/list'
	import jiankangzixun from '@/views/modules/jiankangzixun/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/jiankangdangan',
		name: '健康档案',
		component: jiankangdangan
	}
	,{
		path: '/jiankangyisheng',
		name: '健康医生',
		component: jiankangyisheng
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/jiankangshuju',
		name: '健康数据',
		component: jiankangshuju
	}
	,{
		path: '/chat',
		name: 'AI健康顾问',
		component: chat
	}
	,{
		path: '/zhinengchuandaishebei',
		name: '智能穿戴设备',
		component: zhinengchuandaishebei
	}
	,{
		path: '/jiankangjihua',
		name: '健康计划',
		component: jiankangjihua
	}
	,{
		path: '/zixunleixing',
		name: '资讯类型',
		component: zixunleixing
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/discussjiankangzixun',
		name: '健康资讯评论',
		component: discussjiankangzixun
	}
	,{
		path: '/jiankangzixun',
		name: '健康资讯',
		component: jiankangzixun
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
