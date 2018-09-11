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

### 功能一览
- [x] 登录
- [x] 注册
- [ ] 首页
- [ ] 浏览商品
- [ ] 下单
- [ ] 购物车
- [ ] 订单
- [ ] 地址

### 使用说明
1. 新建数据库，于`agnes-manager > application.yml`修改数据库账号密码。
2. 启动`agnes-server` 注册中心。
3. 启动`agnes-zuul` 网关。
4. 启动`redis-server`缓存。
5. 启动`agnes-manager`管理中心。
