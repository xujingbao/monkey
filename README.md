## 前端框架

## 简介

移动端框架采用 Native+Hybrid，Native支持iOS和Android两个平台，Hybrid基于 [Vue](https://cn.vuejs.org/v2/guide/) + [Cordova ](https://cordova.apache.org/docs/en/latest/)开发；框架带有后台配置管理画面，采用 Vue 开发，主题使用 [Element-UI ](http://element.eleme.io/#/zh-CN/component/installation)组件库。后台使用 [SpringBoot](https://projects.spring.io/spring-boot/) 提供 RESTful 服务。

## 文件架构

├── admin                       Admin use Vue  
├── admin-provider    Admin RESTful Base Spring Boot  
├── front                         Vue + Cordova  
├── front-provider      RESTful API  
├── android                    Android  
└── ios                             iOS  

##环境安装

#### 安装Node.JS相关

[brew](https://brew.sh/) 是Mac上的包管理工具，其他情况参考 https://nodejs.org/en/download/

```shell
$ brew install node@6
```

也可以通过 [nvm](https://github.com/creationix/nvm) 安装，它是Node的版本工具，可以使用homebrew安装nvm，再通过nvm安装指定版本的node

```shell
$ brew install nvm
$ nvm install v6.10.0
```

[nrm](https://github.com/Pana/nrm) 是npm的镜像管理工具，可以帮助你简单快速的切换镜像

```shell
$ npm install -g nrm
$ nrm ls
* npm -----  https://registry.npmjs.org/
  cnpm ----  http://r.cnpmjs.org/
  taobao --  https://registry.npm.taobao.org/
  nj ------  https://registry.nodejitsu.com/
  rednpm -- http://registry.mirror.cqupt.edu.cn
  skimdb -- https://skimdb.npmjs.com/registry
```

最后确认node是否安装正确

```shell
$ node -v
v6.10.0
```

#### 安装Vue

在用 Vue.js 构建大型应用时推荐使用 NPM 安装， NPM 能很好地和诸如 [Webpack](http://webpack.github.io/) 或 [Browserify](http://browserify.org/) 模块打包器配合使用。 Vue.js 也提供配套工具来开发[单文件组件](https://cn.vuejs.org/v2/guide/single-file-components.html)。

```shell
# 最新稳定版
$ npm install -g vue
```

Vue.js 提供一个[官方命令行工具](https://github.com/vuejs/vue-cli)，可用于快速搭建大型单页应用。该工具提供开箱即用的构建工具配置，带来现代化的前端开发流程。只需几分钟即可创建并启动一个带热重载、保存时静态检查以及可用于生产环境的构建配置的项目：

```shell
# 全局安装 vue-cli
$ npm install --global vue-cli
# 创建一个基于 webpack 模板的新项目
$ vue init webpack my-project
# 安装依赖，走你
$ cd my-project
$ npm install
$ npm run dev
```

#### 启动

admin采用前后分离的方式，需要启动两个服务

```shell
# 启动管理y
$ npm install 
$ npm run dev

# 启动Spring Boot
```
#### 开发工具

<img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/visual-studio.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/npm.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/webpack.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/vue.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/angular-icon.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/spring.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/html-5.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/css-3.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/cordova.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/android-icon.svg" width="100" height="100"/> <img src="https://s3-us-west-2.amazonaws.com/svgporn.com/logos/spring.svg" width="100" height="100"/>  
