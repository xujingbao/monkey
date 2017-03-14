import Login from './pages/Login.vue'
import NotFound from './pages/404.vue'
import Home from './pages/Home.vue'
import Main from './pages/Main.vue'
import Table from './pages/nav1/Table.vue'
import Form from './pages/nav1/Form.vue'
import user from './pages/nav1/user.vue'
import Merchant from './pages/nav1/Merchant.vue'
import Page4 from './pages/nav2/Page4.vue'
import Page5 from './pages/nav2/Page5.vue'
import Page6 from './pages/nav3/Page6.vue'
import Page7 from './pages/nav3/Page7.vue'
import echarts from './pages/charts/echarts.vue'

let routes = [{
        path: '/login',
        component: Login,
        name: '',
        hidden: true
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    //{ path: '/main', component: Main },
    {
        path: '/',
        component: Home,
        name: '常用组件',
        iconCls: 'el-icon-message', //图标样式class
        children: [{
                path: '/main',
                component: Main,
                name: '主页',
                hidden: false
            },
            {
                path: '/table',
                component: Table,
                name: '表格'
            },
            {
                path: '/form',
                component: Form,
                name: '表单'
            },
            {
                path: '/user',
                component: user,
                name: '列表'
            },
            {
                path: '/tree',
                component: user,
                name: '树形控件'
            },
        ]
    },
    {
        path: '/',
        component: Home,
        name: '代理商',
        iconCls: 'fa fa-id-card-o',
        children: [{
                path: '/merchant',
                component: Merchant,
                name: '新增商户'
            },
            {
                path: '/page5',
                component: Page5,
                name: '页面5'
            }
        ]
    },
    {
        path: '/',
        component: Home,
        name: '门户',
        iconCls: 'fa fa-address-card',
        //leaf: true,//只有一个节点
        children: [{
                path: '/page6',
                component: Page6,
                name: '新增商户'
            },
            {
                path: '/page7',
                component: Page7,
                name: '手刷商户管理'
            }
        ]
    },
    {
        path: '/',
        component: Home,
        name: '图表',
        iconCls: 'fa fa-bar-chart',
        children: [{
            path: '/echarts',
            component: echarts,
            name: 'echarts'
        }]
    },
    {
        path: '*',
        hidden: true,
        redirect: {
            path: '/404'
        }
    }
];

export default routes;