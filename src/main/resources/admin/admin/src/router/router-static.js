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
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import shenqingbutie from '@/views/modules/shenqingbutie/list'
	import shebaojiaofei from '@/views/modules/shebaojiaofei/list'
	import butiefafang from '@/views/modules/butiefafang/list'
	import butieshenqing from '@/views/modules/butieshenqing/list'
	import laodongbaozhang from '@/views/modules/laodongbaozhang/list'
	import syslog from '@/views/modules/syslog/list'
	import storeup from '@/views/modules/storeup/list'
	import qiye from '@/views/modules/qiye/list'
	import zhaopinxinxi from '@/views/modules/zhaopinxinxi/list'
	import toudijianli from '@/views/modules/toudijianli/list'
	import popupremind from '@/views/modules/popupremind/list'
	import systemintro from '@/views/modules/systemintro/list'
	import yonghu from '@/views/modules/yonghu/list'
	import shebaoxinxi from '@/views/modules/shebaoxinxi/list'
	import chat from '@/views/modules/chat/list'
	import yewuyuyue from '@/views/modules/yewuyuyue/list'
	import fafangbutie from '@/views/modules/fafangbutie/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


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
		path: '/news',
		name: '社保公告',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/shenqingbutie',
		name: '申请补贴',
		component: shenqingbutie
	}
	,{
		path: '/shebaojiaofei',
		name: '社保缴费',
		component: shebaojiaofei
	}
	,{
		path: '/butiefafang',
		name: '补贴发放',
		component: butiefafang
	}
	,{
		path: '/butieshenqing',
		name: '补贴申请',
		component: butieshenqing
	}
	,{
		path: '/laodongbaozhang',
		name: '劳动保障',
		component: laodongbaozhang
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/qiye',
		name: '企业',
		component: qiye
	}
	,{
		path: '/zhaopinxinxi',
		name: '招聘信息',
		component: zhaopinxinxi
	}
	,{
		path: '/toudijianli',
		name: '投递简历',
		component: toudijianli
	}
	,{
		path: '/popupremind',
		name: '弹窗提醒',
		component: popupremind
	}
	,{
		path: '/systemintro',
		name: '系统简介',
		component: systemintro
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/shebaoxinxi',
		name: '社保信息',
		component: shebaoxinxi
	}
	,{
		path: '/chat',
		name: '客服中心',
		component: chat
	}
	,{
		path: '/yewuyuyue',
		name: '业务预约',
		component: yewuyuyue
	}
	,{
		path: '/fafangbutie',
		name: '发放补贴',
		component: fafangbutie
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '社保公告分类',
		component: newstype
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
