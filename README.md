# agnes

### 项目介绍
agnes基于spring cloud和vue微服务，前后分离的移动电商，为入门级spring cloud和vue的学习框架。

### 后端技术指标

 - Spring+SpringMVC+Mybtis
 - SpringCloud全家桶（Eureka、Ribbon、Feign、Hystrix、Zuul）
 - MySQL
 - Redis
 - JWT
 - Maven
 - 相关插件：mybatis-generator

> 可进入`agnes-parent > pom.xml`查看具体依赖。
> 进入 localhost:8004/swagger-ui.html#/ 查看具体接口文档（须已在本机运行）

### 功能一览
- [x] 用户功能：登录、注册、登出、修改密码等
- [x] 地址功能：地址的增删查改等
- [x] 商品功能：浏览、详情等
- [x] 购物车功能：购物车的增删查改 

### 运行说明
1. 新建数据库，于`agnes-manager > application.yml`修改数据库账号密码。
2. 启动`agnes-server` 注册中心。
3. 启动`agnes-zuul` 网关。
4. 启动`redis-server`缓存。
5. 启动`agnes-manager`管理中心。

> 确保以下环境已具备：
> 1. maven使用本地maven配置，于`setting`中搜索配置。
> 2. 确保本机有`tomcat8.0+`
