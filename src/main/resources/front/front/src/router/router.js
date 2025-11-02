import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import jiankangyishengList from '../pages/jiankangyisheng/list'
import jiankangyishengDetail from '../pages/jiankangyisheng/detail'
import jiankangyishengAdd from '../pages/jiankangyisheng/add'
import jiankangdanganList from '../pages/jiankangdangan/list'
import jiankangdanganDetail from '../pages/jiankangdangan/detail'
import jiankangdanganAdd from '../pages/jiankangdangan/add'
import jiankangshujuList from '../pages/jiankangshuju/list'
import jiankangshujuDetail from '../pages/jiankangshuju/detail'
import jiankangshujuAdd from '../pages/jiankangshuju/add'
import jiankangjihuaList from '../pages/jiankangjihua/list'
import jiankangjihuaDetail from '../pages/jiankangjihua/detail'
import jiankangjihuaAdd from '../pages/jiankangjihua/add'
import zixunleixingList from '../pages/zixunleixing/list'
import zixunleixingDetail from '../pages/zixunleixing/detail'
import zixunleixingAdd from '../pages/zixunleixing/add'
import jiankangzixunList from '../pages/jiankangzixun/list'
import jiankangzixunDetail from '../pages/jiankangzixun/detail'
import jiankangzixunAdd from '../pages/jiankangzixun/add'
import zhinengchuandaishebeiList from '../pages/zhinengchuandaishebei/list'
import zhinengchuandaishebeiDetail from '../pages/zhinengchuandaishebei/detail'
import zhinengchuandaishebeiAdd from '../pages/zhinengchuandaishebei/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import discussjiankangzixunList from '../pages/discussjiankangzixun/list'
import discussjiankangzixunDetail from '../pages/discussjiankangzixun/detail'
import discussjiankangzixunAdd from '../pages/discussjiankangzixun/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'jiankangyisheng',
					component: jiankangyishengList
				},
				{
					path: 'jiankangyishengDetail',
					component: jiankangyishengDetail
				},
				{
					path: 'jiankangyishengAdd',
					component: jiankangyishengAdd
				},
				{
					path: 'jiankangdangan',
					component: jiankangdanganList
				},
				{
					path: 'jiankangdanganDetail',
					component: jiankangdanganDetail
				},
				{
					path: 'jiankangdanganAdd',
					component: jiankangdanganAdd
				},
				{
					path: 'jiankangshuju',
					component: jiankangshujuList
				},
				{
					path: 'jiankangshujuDetail',
					component: jiankangshujuDetail
				},
				{
					path: 'jiankangshujuAdd',
					component: jiankangshujuAdd
				},
				{
					path: 'jiankangjihua',
					component: jiankangjihuaList
				},
				{
					path: 'jiankangjihuaDetail',
					component: jiankangjihuaDetail
				},
				{
					path: 'jiankangjihuaAdd',
					component: jiankangjihuaAdd
				},
				{
					path: 'zixunleixing',
					component: zixunleixingList
				},
				{
					path: 'zixunleixingDetail',
					component: zixunleixingDetail
				},
				{
					path: 'zixunleixingAdd',
					component: zixunleixingAdd
				},
				{
					path: 'jiankangzixun',
					component: jiankangzixunList
				},
				{
					path: 'jiankangzixunDetail',
					component: jiankangzixunDetail
				},
				{
					path: 'jiankangzixunAdd',
					component: jiankangzixunAdd
				},
				{
					path: 'zhinengchuandaishebei',
					component: zhinengchuandaishebeiList
				},
				{
					path: 'zhinengchuandaishebeiDetail',
					component: zhinengchuandaishebeiDetail
				},
				{
					path: 'zhinengchuandaishebeiAdd',
					component: zhinengchuandaishebeiAdd
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
				{
					path: 'discussjiankangzixun',
					component: discussjiankangzixunList
				},
				{
					path: 'discussjiankangzixunDetail',
					component: discussjiankangzixunDetail
				},
				{
					path: 'discussjiankangzixunAdd',
					component: discussjiankangzixunAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
