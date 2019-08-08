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
    redirect: '/home',
    component: Main,
    meta: {
      hideInMenu: true,
      notCache: true
    },
    children: [
      {
        path: '/home',
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
    path: '/content',
    name: 'content_management',
    component: Main,
    meta: {
      title: '内容管理',
      icon: 'ios-book'
    },
    children: [
      // {
      //   path: 'article/edit',
      //   name: 'article_edit',
      //   meta: {
      //     icon: 'ios-add-circle-outline',
      //     title: '发表文章'
      //   },
      //   component: () => import('@/view/article/edit.vue')
      // },
      {
        path: 'article/list',
        name: 'article_list',
        meta: {
          icon: 'ios-book',
          title: '文章管理'
        },
        component: () => import('@/view/article/manager.vue')
      },
      {
        path: 'category/list',
        name: 'category_list',
        meta: {
          icon: 'ios-book',
          title: '栏目管理'
        },
        component: () => import('@/view/category/list.vue')
      },
      {
        path: 'tag/list',
        name: 'tag_list',
        meta: {
            icon: 'ios-book',
            title: '标签管理'
        },
        component: () => import('@/view/tag/list.vue')
      },
      {
        path: 'plugin/list',
        name: 'plugin_list',
        meta: {
          icon: 'ios-book',
          title: '插件管理'
        },
        component: () => import('@/view/plugin/list.vue')
      }
    ]
  },
  {
    path: '/market',
    name: 'market',
    component: Main,
    meta: {
      title: '营销推广',
      icon: 'ios-book'
    },
    children: [
      {
        path: 'advertisement/list',
        name: 'advertisement_list',
        meta: {
          icon: 'ios-book',
          title: '广告管理'
        },
        component: () => import('@/view/advertisement/list.vue')
      },
      {
        path: 'link/list',
        name: 'link_list',
        meta: {
          icon: 'ios-book',
          title: '友情链接'
        },
        component: () => import('@/view/link/list.vue')
      }
    ]
  },
  {
    path: '/site',
    name: 'site',
    component: Main,
    meta: {
      title: '站点配置',
      icon: 'ios-book'
    },
    children: [
      {
        path: 'base',
        name: 'site_base_page',
        meta: {
          icon: 'ios-book',
          title: '站点基本信息'
        },
        component: () => import('@/view/site-settings/Settings.vue')
      },
      {
        path: 'extend',
        name: 'site_extend_page',
        meta: {
          icon: 'ios-book',
          title: '站点扩展信息'
        },
        component: () => import('@/view/site-settings/extend.vue')
      },
      {
        path: 'edit',
        name: 'site_property_page',
        meta: {
          icon: 'ios-book',
          title: '站点属性编辑',
          hideInMenu: true,
        },
        component: () => import('@/view/site-settings/edit.vue')
      },
    ]
  },
  {
    path: '/base',
    name: 'base',
    component: Main,
    meta: {
      title: '基本设置',
      icon: 'ios-book'
    },
    children: [
      {
        path: 'dictionary/list',
        name: 'dictionary_list',
        meta: {
          icon: 'ios-book',
          title: '字典管理'
        },
        component: () => import('@/view/dictionary/list.vue')
      },
      {
        path: 'site/list',
        name: 'site_list',
        meta: {
          icon: 'ios-book',
          title: '站点管理'
        },
        component: () => import('@/view/site/list.vue')
      },
      {
        path: 'template/list',
        name: 'template_list',
        meta: {
          icon: 'ios-book',
          title: '模版管理'
        },
        component: () => import('@/view/template/list.vue')
      },
      {
        path: 'site/edit',
        name: 'site_edit',
        meta: {
          hideInMenu: true,
          showAlways: true,
          notCache: true,
          title: '编辑站点',
          icon: 'ios-book'

        },
        component: () => import('@/view/site/edit.vue')
      }
      // {
      //   path: 'tinymce',
      //   name: 'tinymceDemo',
      //   meta: {
      //     icon: 'ios-book',
      //     title: 'tinymceDemo'
      //   },
      //   component: () => import('@/view/tinymce.vue')
      // }
    ]
  },

  {
    path: '/401',
    name: 'error_401',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/401.vue')
  },
  {
    path: '/500',
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
