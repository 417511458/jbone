import Main from '@/components/main'
import parentView from '@/components/parent-view'

/**
 * iview-admin中meta除了原生参数外可配置的参数:
 * meta: {
 *  title: { String|Number|Function }
 *         显示在侧边栏、面包屑和标签栏的文字
 *         使用'{{ 多语言字段 }}'形式结合多语言使用，例子看多语言的路由配置;
 *         可以传入一个回调函数，参数是当前路由对象，例子看动态路由和带参路由
 *  hideInBread: (false) 设为true后此级路由将不会出现在面包屑中，示例看QQ群路由配置
 *  hideInMenu: (false) 设为true后在左侧菜单不会显示该页面选项
 *  notCache: (false) 设为true后页面在切换标签后不会缓存，如果需要缓存，无需设置这个字段，而且需要设置页面组件name属性和路由配置的name一致
 *  access: (null) 可访问该页面的权限数组，当前路由设置的权限会影响子路由
 *  icon: (-) 该页面在左侧菜单、面包屑和标签导航处显示的图标，如果是自定义图标，需要在图标名称前加下划线'_'
 *  beforeCloseName: (-) 设置该字段，则在关闭当前tab页时会去'@/router/before-close.js'里寻找该字段名对应的方法，作为关闭前的钩子函数
 * }
 */

export default [
  {
    path: '/',
    name: '_home',
    redirect: '/ui/home',
    component: Main,
    meta: {
      hideInMenu: true,
      notCache: true
    },
    children: [
      {
        path: '/ui/home',
        name: 'home',
        meta: {
          hideInMenu: true,
          title: '首页',
          notCache: true,
          icon: 'md-home'
        },
        component: () => import('@/view/single-page/home')
      }
    ]
  },
  {
    path: '',
    name: 'doc',
    meta: {
      title: '文档',
      href: 'http://www.jbone.cn',
      icon: 'ios-book'
    }
  },
  {
    path: '/ui/article',
    name: 'article',
    component: Main,
    meta: {
      title: '内容管理',
      icon: 'ios-book'
    },
    children: [
      {
        path: 'category_page',
        name: 'category_page',
        meta: {
          icon: 'ios-book',
          title: '栏目管理'
        },
        component: () => import('@/view/join-page.vue')
      },
      {
        path: 'article_page',
        name: 'article_page',
        meta: {
          icon: 'ios-book',
          title: '文章管理'
        },
        component: () => import('@/view/join-page.vue')
      },
      {
        path: 'tag_page',
        name: 'tag_page',
        meta: {
            icon: 'ios-book',
            title: '标签管理'
        },
        component: () => import('@/view/join-page.vue')
      },
      {
        path: 'special_page',
        name: 'special_page',
        meta: {
          icon: 'ios-book',
          title: '专题管理'
        },
        component: () => import('@/view/join-page.vue')
      }
    ]
  },

  {
    path: '/ui/base',
    name: 'base',
    component: Main,
    meta: {
      title: '基本设置',
      icon: 'ios-book'
    },
    children: [
      {
        path: 'site_base_page',
        name: 'site_base_page',
        meta: {
         icon: 'ios-book',
         title: '网站基本信息'
        },
        component: () => import('@/view/join-page.vue')
      },
      {
        path: 'link_page',
        name: 'link_page',
        meta: {
          icon: 'ios-book',
          title: '友情链接'
        },
        component: () => import('@/view/join-page.vue')
      }
    ]
  },

  {
    path: '/ui/401',
    name: 'error_401',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/401.vue')
  },
  {
    path: '/ui/500',
    name: 'error_500',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/500.vue')
  },
  {
    path: '*',
    name: 'error_404',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/404.vue')
  }
]
