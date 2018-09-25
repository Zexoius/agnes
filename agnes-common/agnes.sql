/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : agnes

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2018-09-24 20:27:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_address`
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '住址ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `is_default` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES ('3', '1', 'admin', '7758258', 'M78星云紫禁区颐和路38号', '1');
INSERT INTO `tb_address` VALUES ('4', '1', 'zexus', '18822220000', '英仙座力士', '0');

-- ----------------------------
-- Table structure for `tb_panel`
-- ----------------------------
DROP TABLE IF EXISTS `tb_panel`;
CREATE TABLE `tb_panel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `name` varchar(50) DEFAULT NULL COMMENT '板块名称',
  `type` int(1) DEFAULT NULL COMMENT '类型 0轮播图 1板块种类一 2板块种类二 3板块种类三 ',
  `sort_order` int(4) DEFAULT NULL COMMENT '排列序号',
  `position` int(1) DEFAULT NULL COMMENT '所属位置 0首页 1商品推荐 2我要捐赠',
  `limit_num` int(4) DEFAULT NULL COMMENT '板块限制商品数量',
  `status` int(1) DEFAULT '1' COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='内容分类';

-- ----------------------------
-- Records of tb_panel
-- ----------------------------
INSERT INTO `tb_panel` VALUES ('1', '热门商品', '2', '2', '0', '3', '1', '', '2018-09-11 08:58:40', '2018-09-11 08:58:51');
INSERT INTO `tb_panel` VALUES ('2', '官方精选', '3', '3', '0', '3', '1', '', null, '2018-08-19 11:20:59');
INSERT INTO `tb_panel` VALUES ('3', '品牌精选', '3', '5', '0', '3', '1', '', '2018-04-18 23:49:19', '2018-04-17 18:54:15');
INSERT INTO `tb_panel` VALUES ('4', '活动板块3', '2', '3', '2', '3', '1', '', '2018-08-23 15:20:31', '2017-11-06 13:17:04');
INSERT INTO `tb_panel` VALUES ('6', '为您推荐', '2', '6', '1', '3', '1', '', '2018-08-06 13:17:41', '2017-11-06 13:17:41');
INSERT INTO `tb_panel` VALUES ('7', '轮播图', '0', '0', '0', '3', '1', '', '2018-08-15 12:33:07', '2018-04-15 12:33:07');
INSERT INTO `tb_panel` VALUES ('8', '活动版块', '1', '1', '0', '3', '1', '', '2018-08-15 19:05:00', '2018-04-15 19:05:00');
INSERT INTO `tb_panel` VALUES ('9', '活动版块2', '1', '7', '0', '3', '1', '', null, '2018-08-19 11:57:47');
INSERT INTO `tb_panel` VALUES ('10', '品牌周边', '3', '4', '0', '3', '1', null, '2018-08-18 23:50:32', '2018-04-18 23:50:35');

-- ----------------------------
-- Table structure for `tb_panel_content`
-- ----------------------------
DROP TABLE IF EXISTS `tb_panel_content`;
CREATE TABLE `tb_panel_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `panel_id` int(11) NOT NULL COMMENT '所属板块id',
  `type` int(1) DEFAULT NULL COMMENT '类型 0关联商品 1其他链接',
  `product_id` bigint(20) DEFAULT NULL COMMENT '关联商品id',
  `sort_order` int(4) DEFAULT NULL,
  `full_url` varchar(500) DEFAULT NULL COMMENT '其他链接',
  `pic_url` varchar(500) DEFAULT NULL,
  `pic_url2` varchar(500) DEFAULT NULL COMMENT '3d轮播图备用',
  `pic_url3` varchar(500) DEFAULT NULL COMMENT '3d轮播图备用',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`panel_id`),
  KEY `updated` (`updated`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_panel_content
-- ----------------------------
INSERT INTO `tb_panel_content` VALUES ('2', '3', '0', '150642571432851', '1', '', 'https://resource.smartisan.com/resource/7ac3af5a92ad791c2b38bfe1e38ee334.jpg', null, null, '2017-09-23 00:03:02', '2018-04-20 00:23:40');
INSERT INTO `tb_panel_content` VALUES ('7', '3', '0', '816448', '2', '', 'https://resource.smartisan.com/resource/41cb562a47d4831e199ed7e2057f3b61.jpg', null, null, '2017-09-23 22:58:11', '2018-04-20 00:14:29');
INSERT INTO `tb_panel_content` VALUES ('8', '2', '0', '150642571432837', '1', '', 'https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg', null, null, '2017-09-25 17:03:48', '2018-04-19 23:23:26');
INSERT INTO `tb_panel_content` VALUES ('9', '2', '0', '150642571432838', '2', '', 'https://resource.smartisan.com/resource/63ea40e5c64db1c6b1d480c48fe01272.jpg', null, null, '2017-09-25 17:04:35', '2018-04-20 10:48:17');
INSERT INTO `tb_panel_content` VALUES ('14', '2', '0', '150642571432839', '3', '', 'https://resource.smartisan.com/resource/5e4b1feddb13639550849f12f6b2e202.jpg', null, null, '2017-10-22 22:14:01', '2018-04-20 10:48:29');
INSERT INTO `tb_panel_content` VALUES ('15', '2', '0', '150642571432840', '4', '', 'https://resource.smartisan.com/resource/10525c4b21f039fc8ccb42cd1586f5cd.jpg', null, null, '2017-10-22 22:14:52', '2018-04-20 10:48:43');
INSERT INTO `tb_panel_content` VALUES ('16', '2', '0', '150642571432841', '5', '', 'https://resource.smartisan.com/resource/b899d9b82c4bc2710492a26af021d484.jpg', null, null, '2017-10-22 22:15:51', '2018-04-20 10:49:02');
INSERT INTO `tb_panel_content` VALUES ('17', '2', '0', '150642571432842', '6', '', 'https://resource.smartisan.com/resource/abb6986430536cd9365352b434f3c568.jpg', null, null, '2017-10-22 22:17:01', '2018-04-20 10:49:17');
INSERT INTO `tb_panel_content` VALUES ('18', '3', '0', '847276', '3', null, 'https://resource.smartisan.com/resource/99c548bfc9848a8c95f4e4f7f2bc1095.png', null, null, '2017-10-22 22:22:52', '2017-10-22 22:22:52');
INSERT INTO `tb_panel_content` VALUES ('19', '3', '0', '150642571432844', '4', '', 'https://resource.smartisan.com/resource/71432ad30288fb860a4389881069b874.png', null, null, '2017-10-22 22:23:35', '2018-04-20 11:25:38');
INSERT INTO `tb_panel_content` VALUES ('20', '3', '0', '847276', '5', '', 'https://resource.smartisan.com/resource/804b82e4c05516e822667a23ee311f7c.jpg', null, null, '2017-10-22 22:24:54', '2018-04-20 00:15:03');
INSERT INTO `tb_panel_content` VALUES ('21', '3', '0', '150642571432852', '6', '', 'https://resource.smartisan.com/resource/367d93db1d58f9f3505bc0ec18efaa44.jpg', null, null, '2017-10-22 22:25:28', '2018-04-20 00:24:11');
INSERT INTO `tb_panel_content` VALUES ('22', '1', '0', '150635087972564', '1', null, 'https://resource.smartisan.com/resource/13e91511f6ba3227ca5378fd2e93c54b.png?x-oss-process=image/resize,w_270/format,webp', null, null, '2017-10-22 22:26:31', '2017-10-22 22:26:31');
INSERT INTO `tb_panel_content` VALUES ('23', '1', '0', '150642571432835', '2', '', 'https://resource.smartisan.com/resource/1cd5ad269fa043103e723728e8e96c2e.jpg?x-oss-process=image/resize,w_270/format,webp', null, null, '2017-10-22 22:26:40', '2018-04-17 20:59:35');
INSERT INTO `tb_panel_content` VALUES ('25', '8', '0', '150642571432835', '1', 'https://www.smartisan.com/jianguo3-accessories', 'https://resource.smartisan.com/resource/6/610400xinpinpeijian.jpg', null, null, '2018-04-15 19:07:43', '2018-04-19 23:20:34');
INSERT INTO `tb_panel_content` VALUES ('26', '8', '0', '150635087972564', '2', 'https://www.smartisan.com/service/#/tradein', 'https://resource.smartisan.com/resource/5abc95e62727a4035b41833f55dba45f.png', null, null, '2018-04-15 19:08:00', '2018-04-19 23:20:48');
INSERT INTO `tb_panel_content` VALUES ('27', '8', '0', '150642571432835', '3', 'https://www.smartisan.com/category?id=69', 'https://resource.smartisan.com/resource/cc9ab6e4d761f960c8339892195a942c.png', null, null, '2018-04-15 19:08:24', '2018-04-19 23:21:01');
INSERT INTO `tb_panel_content` VALUES ('28', '8', '0', '150635087972564', '4', 'https://www.smartisan.com/', 'https://resource.smartisan.com/resource/8b5eb49937208882640bfa3b1376d124.png', null, null, '2018-04-15 19:08:58', '2018-04-19 23:21:13');
INSERT INTO `tb_panel_content` VALUES ('29', '2', '2', '150642571432843', '0', '', 'https://resource.smartisan.com/resource/1/1220858shoujilouceng.jpg', null, null, '2018-04-15 20:14:35', '2018-04-20 11:41:27');
INSERT INTO `tb_panel_content` VALUES ('30', '3', '2', '150642571432850', '0', '', 'https://resource.smartisan.com/resource/a/acillouceng1220856.jpg', null, null, '2018-04-15 20:15:18', '2018-04-20 11:18:03');
INSERT INTO `tb_panel_content` VALUES ('32', '7', '0', '150635087972564', '1', '', 'https://resource.smartisan.com/resource/9/913shoujiaopc1.png', 'http://static.smartisanos.cn/index/img/store/home/banner-3d-item-1-box-3_8fa7866d59.png', 'http://ow2h3ee9w.bkt.clouddn.com/banner-3d-item-1-box-33.png', '2018-04-17 20:41:02', '2018-04-17 20:58:41');
INSERT INTO `tb_panel_content` VALUES ('33', '7', '0', '150642571432835', '2', '', 'https://resource.smartisan.com/resource/j/jiaodian21.png', 'http://ow2h3ee9w.bkt.clouddn.com/phone_left2.png', 'http://oweupqzdv.bkt.clouddn.com/erji_left.png', '2018-04-17 21:08:22', '2018-04-20 10:47:19');
INSERT INTO `tb_panel_content` VALUES ('35', '7', '0', '150642571432843', '4', '', 'https://resource.smartisan.com/resource/4f9947ce81ae61707bce6ac9efa04381.png', null, null, '2018-04-18 23:44:48', '2018-04-20 11:41:46');
INSERT INTO `tb_panel_content` VALUES ('36', '9', '3', '150635087972564', '1', 'https://www.smartisan.com/pr/#/video/conference-r1', 'https://resource.smartisan.com/resource/f82c9e2774ce0e391a17f1b20c1e0c90.jpg', null, null, '2018-04-18 23:51:45', '2018-04-20 12:03:05');
INSERT INTO `tb_panel_content` VALUES ('37', '9', '3', '150642571432835', '2', 'https://www.smartisan.com/os/#/6-x', 'https://resource.smartisan.com/resource/5ea6f0905535d7b11258e9a0f9b1abeb.jpg', null, null, '2018-04-18 23:51:51', '2018-04-20 12:03:19');
INSERT INTO `tb_panel_content` VALUES ('38', '9', '3', '150635087972564', '3', 'https://www.smartisan.com/pr/#/video/changhuxi-jinghuaqi', 'https://resource.smartisan.com/resource/c245ada282824a4a15e68bec80502ad4.jpg', null, null, '2018-04-18 23:51:58', '2018-04-20 12:03:31');
INSERT INTO `tb_panel_content` VALUES ('39', '9', '3', '150642571432835', '4', 'https://www.smartisan.com/pr/#/video/onestep-introduction', 'https://resource.smartisan.com/resource/m/minibanner_03.jpg', null, null, '2018-04-18 23:52:02', '2018-04-20 12:03:41');
INSERT INTO `tb_panel_content` VALUES ('40', '10', '3', null, '0', 'http://localhost:8082/goods?cid=1184', 'https://resource.smartisan.com/resource/z/zhoubianshangpin1220858web.jpg', null, null, '2018-04-19 00:02:53', '2018-04-20 11:15:59');
INSERT INTO `tb_panel_content` VALUES ('41', '10', '0', '150642571432845', '1', '', 'https://resource.smartisan.com/resource/2f9a0f5f3dedf0ed813622003f1b287b.jpg', null, null, '2018-04-19 00:02:56', '2018-04-20 00:24:36');
INSERT INTO `tb_panel_content` VALUES ('42', '10', '0', '150642571432836', '2', '', 'https://resource.smartisan.com/resource/2b05dbca9f5a4d0c1270123f42fb834c.jpg', null, null, '2018-04-19 00:03:00', '2018-04-20 00:25:01');
INSERT INTO `tb_panel_content` VALUES ('43', '10', '0', '150642571432846', '3', '', 'https://resource.smartisan.com/resource/804edf579887b3e1fae4e20a379be5b5.png', null, null, '2018-04-19 00:03:04', '2018-04-20 00:25:17');
INSERT INTO `tb_panel_content` VALUES ('44', '10', '0', '150642571432848', '4', '', 'https://resource.smartisan.com/resource/a1c53b5f12dd7ef790cadec0eaeaf466.jpg', null, null, '2018-04-19 00:03:10', '2018-04-20 10:55:52');
INSERT INTO `tb_panel_content` VALUES ('45', '10', '0', '150642571432847', '5', '', 'https://resource.smartisan.com/resource/daa975651d6d700c0f886718c520ee19.jpg', null, null, '2018-04-19 00:03:15', '2018-04-20 10:54:56');
INSERT INTO `tb_panel_content` VALUES ('46', '10', '0', '150642571432849', '6', '', 'https://resource.smartisan.com/resource/3973d009d182d8023bea6250b9a3959e.jpg', null, null, '2018-04-19 00:03:20', '2018-04-20 10:55:03');
INSERT INTO `tb_panel_content` VALUES ('47', '6', '0', '150635087972564', '1', '', 'http://ow2h3ee9w.bkt.clouddn.com/FjvP4gBFeYGQoEtEX7dL3kbwJTDW', null, null, '2018-04-19 11:15:35', '2018-04-19 11:15:35');
INSERT INTO `tb_panel_content` VALUES ('48', '6', '0', '150642571432835', '2', null, 'http://ow2h3ee9w.bkt.clouddn.com/FgwHSk1Rnd-8FKqNJhFSSdcq2QVB', null, null, '2018-04-19 11:18:16', '2018-04-19 11:18:18');
INSERT INTO `tb_panel_content` VALUES ('49', '4', '0', '150635087972564', '1', null, 'http://ow2h3ee9w.bkt.clouddn.com/FjvP4gBFeYGQoEtEX7dL3kbwJTDW', null, null, '2018-04-19 11:20:15', '2018-04-19 11:20:17');
INSERT INTO `tb_panel_content` VALUES ('50', '4', '0', '150642571432835', '2', null, 'http://ow2h3ee9w.bkt.clouddn.com/FgwHSk1Rnd-8FKqNJhFSSdcq2QVB', null, null, '2018-04-19 11:20:19', '2018-04-19 11:20:21');
INSERT INTO `tb_panel_content` VALUES ('51', '1', '0', '150642581432815', '3', null, 'https://resource.smartisan.com/resource/c71ce2297b362f415f1e74d56d867aed.png?x-oss-process=image/resize,w_270/format,webp', null, null, '2018-09-17 18:59:15', '2018-09-17 18:59:20');

-- ----------------------------
-- Table structure for `tb_product`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` bigint(20) NOT NULL COMMENT '商品id，同时也是商品编号',
  `title` varchar(100) DEFAULT NULL COMMENT '商品标题',
  `sell_point` varchar(100) DEFAULT NULL COMMENT '商品卖点',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '商品价格',
  `num` int(11) DEFAULT NULL COMMENT '库存数量',
  `limit_num` int(11) DEFAULT NULL COMMENT '售卖数量限制',
  `image` varchar(2000) DEFAULT NULL COMMENT '商品图片',
  `cid` bigint(11) DEFAULT NULL COMMENT '所属分类',
  `status` int(1) DEFAULT '1' COMMENT '商品状态 1正常 0下架',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `status` (`status`),
  KEY `updated` (`updated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('562379', '坚果 Pro 软胶保护套', 'TPU 环保材质、耐磨、耐油、耐久性强', '49.00', '999', '100', 'http://image.smartisanos.cn/resource/902befd5f32a8caf4ca79b55d39ee25a.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('605616', '坚果 Pro 钢化玻璃保护膜（前屏用）', '高达 92% 的超强透光率、耐刮花、防指纹', '49.00', '999', '100', 'http://image.smartisanos.cn/resource/30cacf4088f7105d16452c661afd9299.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('679532', 'Smartisan 原装快充充电器 18W', '18W 安全快充、支持主流 QC3.0, MTK PE+2.0 快充协议', '59.00', '999', '100', 'http://image.smartisanos.cn/resource/dc53bd870ee64d2053ecc51750ece43a.jpg', '560', '1', '2017-09-05 21:27:54', '2017-11-09 22:31:04');
INSERT INTO `tb_product` VALUES ('679533', 'Smartisan 坚果自拍杆', '通用 3.5 mm 接口、航空铝合金伸缩杆、防过敏硅胶手柄', '69.00', '999', '100', 'http://image.smartisanos.cn/resource/afe5728faa22f4b078b84d9c725c136d.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('691300', 'Smartisan 快充移动电源 10000mAh', '10000mAh 双向快充、轻盈便携、高标准安全保护', '199.00', '999', '100', 'http://image.smartisanos.cn/resource/0540778097a009364f2dcbb8c5286451.jpg', '560', '1', '2017-09-05 21:27:54', '2017-11-09 22:22:53');
INSERT INTO `tb_product` VALUES ('738388', 'Smartisan 原装 Type-C 数据线', 'PTC 过温保护、凹形设计、TPE 环保材质', '39.00', '999', '100', 'http://image.smartisanos.cn/resource/c79a73ffc6f8e782160d978f49f543dc.jpg', '560', '1', '2017-09-05 21:27:54', '2017-10-22 22:15:02');
INSERT INTO `tb_product` VALUES ('741524', 'Smartisan S-100 半入耳式线控耳机', '卓越的 14.2mm 发音单元、三按键式线控', '99.00', '999', '100', 'http://image.smartisanos.cn/resource/c98abe89b5a5502ef04c30e751b2bfef.png', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('816448', '极米无屏电视 CC', '720P 高清分辨率、JBL 音响、两万毫安续航力', '2799.00', '999', '100', 'http://image.smartisanos.cn/resource/41cb562a47d4831e199ed7e2057f3b61.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('816753', '《索尼设计，塑造现代》', '索尼全盛时期工业设计作品首次集结成书并引进中国', '259.00', '999', '100', 'http://image.smartisanos.cn/resource/f950d9c27ef21e17374fa212b40d66a9.jpg', '76', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('830972', '《深泽直人》', '首次面向中国读者介绍其作品', '199.00', '999', '100', 'http://image.smartisanos.cn/resource/5e4e40120d09fb6791f9430f914c6f68.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('832739', 'FIIL CARAT 蓝牙运动耳机', '智能计步、磁吸项链式、佩戴舒适不易掉', '499.00', '999', '100', 'http://image.smartisanos.cn/resource/61b4f3de01f00e57a664e648d6ea4721.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('844022', 'FIIL CARAT LITE 蓝牙运动耳机', '线控带麦、IP65 防水、磁吸项链式', '299.00', '999', '100', 'http://image.smartisanos.cn/resource/62c1a6988de8071beef4203bedde5144.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('847276', 'FIIL Diva Pro 全场景无线降噪耳机', '智能语音交互、高清无损本地存储播放', '1499.00', '999', '100', 'http://image.smartisanos.cn/resource/804b82e4c05516e822667a23ee311f7c.jpg', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('856645', '三星 Galaxy S4 (I9500) 16G版 星空黑 联通3G手机', '年货特价来袭！三星经典旗舰机！', '1888.00', '999', '100', 'http://ow2h3ee9w.bkt.clouddn.com/nopic.jpg', '560', '0', '2017-09-05 21:27:54', '2017-11-06 23:44:32');
INSERT INTO `tb_product` VALUES ('150635087972564', '坚果pro2s 双系统，无限屏', '颠覆性的“无限屏”功能 颠覆性的“TNT”大屏幕操作系统', '1798.00', '999', '100', 'https://resource.smartisan.com/resource/13e91511f6ba3227ca5378fd2e93c54b.png?x-oss-process=image/resize,w_270/format,webp', '560', '1', '2017-09-05 21:27:54', '2017-09-05 21:29:54');
INSERT INTO `tb_product` VALUES ('150642571432835', '坚果pro2 领券立减700元', '赠官方配件包', '1799.00', '999', '100', 'https://resource.smartisan.com/resource/1cd5ad269fa043103e723728e8e96c2e.jpg?x-oss-process=image/resize,w_270/format,webp', '560', '1', '2017-09-05 21:27:54', '2017-11-09 22:12:23');
INSERT INTO `tb_product` VALUES ('150642571432836', 'Smartisan T恤 伍迪·艾伦出生', '一件内外兼修的舒适T恤', '149.00', '999', '100', 'https://resource.smartisan.com/resource/f96f0879768bc317b74e7cf9e3d96884.jpg,https://resource.smartisan.com/resource/095b46c25f9df5b13ee51f3e512d1e96.jpg,https://resource.smartisan.com/resource/0c9c397c8ac68a2ad327e1da8a5cb7d0.jpg,https://resource.smartisan.com/resource/154b35897ed3c1cb8dc1c7aae7b88f1f.jpg,https://resource.smartisan.com/resource/4a1686f2fde86e0aaac49c92395d4b32.jpg', '1184', '1', '2018-04-18 20:41:41', '2018-04-20 00:21:01');
INSERT INTO `tb_product` VALUES ('150642571432837', '坚果 3 前屏钢化玻璃保护膜', '超强透光率、耐刮花、防指纹', '49.00', '999', '100', 'https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg', '560', '1', '2018-04-19 00:34:06', '2018-04-19 23:49:38');
INSERT INTO `tb_product` VALUES ('150642571432838', '坚果 3 绒布国旗保护套', '质感精良、完美贴合、周到防护', '79.00', '999', '100', 'https://resource.smartisan.com/resource/63ea40e5c64db1c6b1d480c48fe01272.jpg,https://resource.smartisan.com/resource/4b8d00ab6ba508a977a475988e0fdb53.jpg,https://resource.smartisan.com/resource/87ea3888491d172b7d7a0e78e4294b4b.jpg,https://resource.smartisan.com/resource/8d30265188ddd1ba05e34f669c5dcf1c.jpg', '560', '1', '2018-04-19 00:35:50', '2018-04-20 00:01:08');
INSERT INTO `tb_product` VALUES ('150642571432839', '坚果 3 TPU 软胶透明保护套', '轻薄透明、完美贴合、TPU 环保材质', '29.00', '999', '100', 'https://resource.smartisan.com/resource/5e4b1feddb13639550849f12f6b2e202.jpg,https://resource.smartisan.com/resource/0477d8b177db197a0b09a18e116b2bca.jpg,https://resource.smartisan.com/resource/b66d7e832339cf240b13a9a91107abdc.jpg,https://resource.smartisan.com/resource/56db3c83cca697572fa8a1df2e3172d7.jpg', '560', '1', '2018-04-19 00:38:07', '2018-04-20 00:02:54');
INSERT INTO `tb_product` VALUES ('150642571432840', 'Smartisan 半入耳式耳机', '经典配色、专业调音、高品质麦克风', '89.00', '999', '100', 'https://resource.smartisan.com/resource/9c1d958f10a811df841298d50e1ca7c0.jpg,https://resource.smartisan.com/resource/afa4ecdb54d7f50d0b6265bbcf31d6c8.jpg,https://resource.smartisan.com/resource/eb1bf1dee365c7855e6b047d8b9c5b1e.jpg,https://resource.smartisan.com/resource/dfcc9fa16ab354a41683959398bff128.jpg', '560', '1', '2018-04-19 00:40:40', '2018-04-20 00:04:41');
INSERT INTO `tb_product` VALUES ('150642571432841', '坚果 3 TPU 软胶保护套', 'TPU 环保材质、完美贴合、周到防护', '49.00', '999', '100', 'https://resource.smartisan.com/resource/b899d9b82c4bc2710492a26af021d484.jpg,https://resource.smartisan.com/resource/bb8859032d6060ccb4e733a2c8e2f51d.jpg,https://resource.smartisan.com/resource/df5b3d3539481eb1c00333a5bc5b60b6.jpg', '560', '1', '2018-04-19 00:43:48', '2018-04-20 00:06:58');
INSERT INTO `tb_product` VALUES ('150642571432842', '坚果 3 \"足迹\"背贴 乐高创始人出生', '1891 年 4 月 7 日', '79.00', '999', '100', 'https://resource.smartisan.com/resource/abb6986430536cd9365352b434f3c568.jpg', '560', '1', '2018-04-19 00:45:14', '2018-04-20 00:08:21');
INSERT INTO `tb_product` VALUES ('150642571432843', '坚果 3', '漂亮得不像实力派', '1999.00', '999', '100', 'https://resource.smartisan.com/resource/718bcecced0df1cd23bbdb9cc1f70b7d.png', '560', '1', '2018-04-19 22:13:31', '2018-04-20 11:44:57');
INSERT INTO `tb_product` VALUES ('150642571432844', '畅呼吸智能空气净化器超级除甲醛版', '购新空净 赠价值 699 元活性炭滤芯', '2999.00', '999', '100', 'https://resource.smartisan.com/resource/71432ad30288fb860a4389881069b874.png', '560', '1', '2018-04-19 22:16:05', '2018-04-20 11:47:02');
INSERT INTO `tb_product` VALUES ('150642571432845', 'Smartisan 帆布鞋', '一双踏实、舒适的帆布鞋', '199.00', '999', '100', 'https://resource.smartisan.com/resource/2f9a0f5f3dedf0ed813622003f1b287b.jpg,https://resource.smartisan.com/resource/0cd8f107c70d002caf902745355e269a.jpg,https://resource.smartisan.com/resource/fa42dcd439e9fb990831f1d21c3f19b8.jpg', '1184', '1', '2018-04-19 22:22:02', '2018-04-20 00:19:39');
INSERT INTO `tb_product` VALUES ('150642571432846', 'Smartisan T恤 任天堂发售“红白机”', '100% 美国 SUPIMA 棉、舒适拉绒质地', '149.00', '999', '100', 'https://resource.smartisan.com/resource/804edf579887b3e1fae4e20a379be5b5.png,https://resource.smartisan.com/resource/6a92fe5ab90b379d5315c0ee2610f467.png,https://resource.smartisan.com/resource/76c811504b910e04c448dda8d47a09c3.png', '1184', '1', '2018-04-19 22:23:39', '2018-04-20 00:23:09');
INSERT INTO `tb_product` VALUES ('150642571432847', 'Smartisan Polo衫 经典款', '一件表里如一的舒适 POLO 衫', '249.00', '999', '100', 'https://resource.smartisan.com/resource/daa975651d6d700c0f886718c520ee19.jpg,https://resource.smartisan.com/resource/8b4884f04835f8de3c33817732fdcb46.jpg,https://resource.smartisan.com/resource/057f6010d6cb7afc964f812093742283.jpg,https://resource.smartisan.com/resource/3cc4b5a1e0a6136eb9725a88d6c1d3be.jpg,https://resource.smartisan.com/resource/f35c053b87dd0e1255be2a8bfa773232.jpg', '1184', '1', '2018-04-19 22:25:41', '2018-04-20 10:51:53');
INSERT INTO `tb_product` VALUES ('150642571432848', 'Smartisan 牛津纺衬衫', '一件无拘无束的舒适衬衫', '199.00', '999', '100', 'https://resource.smartisan.com/resource/a1c53b5f12dd7ef790cadec0eaeaf466.jpg,https://resource.smartisan.com/resource/dccec50aa1480c23a6d62648d2271c0a.jpg,https://resource.smartisan.com/resource/28c798c14b3cc9cfe7100567df6e5999.jpg,https://resource.smartisan.com/resource/da87105789046c13412f6f6a32032df7.jpg,https://resource.smartisan.com/resource/cf9704df83dc6d6ff5404da154388a58.jpg', '1184', '1', '2018-04-19 22:28:11', '2018-04-20 10:53:15');
INSERT INTO `tb_product` VALUES ('150642571432849', 'Smartisan 明信片', '优质卡纸、包装精致、色彩饱满', '9.90', '999', '100', 'https://resource.smartisan.com/resource/3973d009d182d8023bea6250b9a3959e.jpg,https://resource.smartisan.com/resource/1901bf9f58d83978353cf1ec58442cc6.jpg,https://resource.smartisan.com/resource/4e0b690102858fc3013ea650fb1e1a8e.jpg,https://resource.smartisan.com/resource/51765f60367d6e40e4ae6f2b9ce46a91.jpg,https://resource.smartisan.com/resource/5108b5e7448c14e5241b60ba41fafc8e.jpg', '1148', '1', '2018-04-19 22:31:09', '2018-04-20 10:54:24');
INSERT INTO `tb_product` VALUES ('150642571432850', 'ACIL E1 颈挂式蓝牙耳机', '无感佩戴，一切变得简单', '199.00', '999', '100', 'https://resource.smartisan.com/resource/406eddef8808fa5a9be9594d07ef8643.jpg,https://resource.smartisan.com/resource/548de41c48d47232b4ed541c1df57c2f.jpg,https://resource.smartisan.com/resource/aee0949bc33654bc18cedb8cd7dfbcff.jpg', '560', '1', '2018-04-19 22:32:38', '2018-04-20 11:17:31');
INSERT INTO `tb_product` VALUES ('150642571432851', '优点智能 E1 推拉式智能指纹密码锁', '推拉一下，轻松开关', '2699.00', '999', '100', 'https://resource.smartisan.com/resource/7ac3af5a92ad791c2b38bfe1e38ee334.jpg,https://resource.smartisan.com/resource/e37029b8cd3194ad9581de0ee6512acb.jpg,https://resource.smartisan.com/resource/1501eaf68c9771e5599eec45a5f6320a.jpg,https://resource.smartisan.com/resource/a8c6a41637041c576aaa2a5162d2ab56.jpg,https://resource.smartisan.com/resource/3934e0c458922c0049d311b84ddb73e0.jpg', '560', '1', '2018-04-19 22:36:50', '2018-04-20 00:13:44');
INSERT INTO `tb_product` VALUES ('150642571432852', 'FIIL Driifter 脖挂蓝牙耳机', '全天佩戴 抬手就听 HEAC稳连技术', '499.00', '999', '100', 'https://resource.smartisan.com/resource/367d93db1d58f9f3505bc0ec18efaa44.jpg,https://resource.smartisan.com/resource/8ecc94c0f0c4ebc861f06c86789a66e6.jpg,https://resource.smartisan.com/resource/58a2cdb44f722202b05dd09d6fd959de.jpg,https://resource.smartisan.com/resource/2b811a93a2915310f72291e46bd944ad.jpg,https://resource.smartisan.com/resource/8cd011adef99f9734ed974ea9732e6e7.jpg', '560', '1', '2018-04-19 22:38:59', '2018-04-20 00:18:17');
INSERT INTO `tb_product` VALUES ('150642581432815', '坚果 Pro 2', '赠价值 49 元 Pro 2 PET 2D 保护膜', '39.00', '999', '100', 'https://resource.smartisan.com/resource/c71ce2297b362f415f1e74d56d867aed.png?x-oss-process=image/resize,w_270/format,webp', '560', '1', '2018-09-17 19:02:20', '2018-09-17 19:02:23');

-- ----------------------------
-- Table structure for `tb_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_detail`;
CREATE TABLE `tb_product_detail` (
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `item_desc` text COMMENT '商品描述',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品描述表';

-- ----------------------------
-- Records of tb_product_detail
-- ----------------------------
INSERT INTO `tb_product_detail` VALUES ('562379', '<img src=\"http://image.smartisanos.cn/resource/98521dbfe1dd1e67db3f7ca21e76c9ef.jpg\" style=\"width:1220px;height:7000px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:19:07');
INSERT INTO `tb_product_detail` VALUES ('679532', '<img src=\"http://image.smartisanos.cn/resource/4a7b87fe01ec8339985702ee922d205a.jpg\" style=\"width:1220px;height:4526px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-09 22:31:04');
INSERT INTO `tb_product_detail` VALUES ('679533', '<img src=\"http://image.smartisanos.cn/resource/0bb13cf0b2e0b4817f4914a317fb1445.png\" style=\"width:1220px;height:6481px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:28:04');
INSERT INTO `tb_product_detail` VALUES ('691300', '<img src=\"http://image.smartisanos.cn/resource/d930be42185ab064035d0894f37ea179.jpg\" style=\"width:1220px;height:6478px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-09 22:22:53');
INSERT INTO `tb_product_detail` VALUES ('738388', '<img src=\"http://image.smartisanos.cn/resource/b3d7b420e3e609e858a8d75f19cbfd7c.jpg\" style=\"width:1220px;height:4829px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:21:41');
INSERT INTO `tb_product_detail` VALUES ('741524', '<img src=\"http://image.smartisanos.cn/resource/73fdd5f948cd6248c51521e87acb33e5.jpg\" style=\"width:1220px;height:8703px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:31:05');
INSERT INTO `tb_product_detail` VALUES ('816448', '<img src=\"http://image.smartisanos.cn/resource/e7ed8222dcd7c9f67af3097bd7bd5c2b.jpg\" style=\"width:1220px;height:12257px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:42:22');
INSERT INTO `tb_product_detail` VALUES ('816753', '<img src=\"http://image.smartisanos.cn/resource/62a60be80e9cd3307ef334ede82b430a.jpg\" style=\"width:1220px;height:8267px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:41:18');
INSERT INTO `tb_product_detail` VALUES ('830972', '<img src=\"http://image.smartisanos.cn/resource/102ed8a03b5f4452dda7dc513c016f12.jpg\" style=\"width:1220px;height:8811px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:37:54');
INSERT INTO `tb_product_detail` VALUES ('832739', '<img src=\"http://image.smartisanos.cn/resource/f86802b6a7b207d02f5c69163fa5e347.jpg\" style=\"width:1220px;height:13682px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:39:10');
INSERT INTO `tb_product_detail` VALUES ('844022', '<img src=\"http://image.smartisanos.cn/resource/bcd85c778a0b54b61afe813bd7b674d4.jpg\" style=\"width:1220px;height:12384px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:40:07');
INSERT INTO `tb_product_detail` VALUES ('847276', '<img src=\"http://image.smartisanos.cn/resource/9be6229b3498749c4afd173a3b1fe165.png\" style=\"width:1120px;height:15514px;\" alt=\"\" />', '2017-09-05 21:27:54', '2017-11-19 21:45:31');
INSERT INTO `tb_product_detail` VALUES ('856645', '<div class=\"ssd-module-wrap\" style=\"margin:0 auto;text-align:left;\">\n	<div class=\"outer-container\">\n		<div class=\" \" id=\"\">\n			<div class=\"ssd-1080\">\n				<div class=\"ssd-j-module item_tit\">\n					<div class=\"tit1\">\n						产品特色\n					</div>\n					<div class=\"tit2\">\n						PRODUCTION\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-1183\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#ffffff url(http://img30.360buyimg.com/sku/jfs/t460/159/849423048/82352/867f75ff/548e5a88N73b12dd9.jpg) no-repeat;\">\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n						</div>\n						<div class=\"title2\">\n						</div>\n					</div>\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t451/241/814906943/1043/fa877bc/548e4238N585a2a89.png\" alt=\"\" /> \n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-2165\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#ffffff url(http://img30.360buyimg.com/cms/jfs/t217/232/2460673136/4947/e76ec4b7/541a3cf8Ne7d0749d.png) no-repeat;\">\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t598/141/839042103/90325/3ea2cf8a/548e7e74Nc2025337.jpg\" alt=\"\" /> \n					</div>\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n						</div>\n						<div class=\"title2\">\n						</div>\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-2165\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#ffffff;\">\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t472/95/847651115/101211/6b98601c/548e7fc5Ncb21ef86.jpg\" alt=\"\" /> \n					</div>\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n							、\n						</div>\n						<div class=\"title2\">\n							、\n						</div>\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \" id=\"\">\n			<div class=\"ssd-1080\">\n				<div class=\"ssd-j-module item_tit\">\n					<div class=\"tit1\">\n						产品功能\n					</div>\n					<div class=\"tit2\">\n						PRODUCT FUNCTION\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-2165\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#ffffff url(http://img30.360buyimg.com/cms/jfs/t217/232/2460673136/4947/e76ec4b7/541a3cf8Ne7d0749d.png) no-repeat;\">\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t745/150/148843066/79290/604280fc/548e8318Na94c82f9.jpg\" alt=\"\" /> \n					</div>\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n							、\n						</div>\n						<div class=\"title2\">\n							、\n						</div>\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-1829\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#ffffff;\">\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t769/364/157509045/89868/d97d79ef/548e9d75N18fc06d2.jpg\" alt=\"\" /> \n					</div>\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n						</div>\n						<div class=\"title2\">\n						</div>\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-2136\">\n				<div class=\"ssd-j-module img_box\" style=\"background:#cccccc;\">\n					<div class=\"imglab\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t685/187/809086881/59964/1802066d/548ea270N6853bbcd.jpg\" alt=\"\" /> \n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-2136\">\n				<div class=\"ssd-j-module img_box\" style=\"background:#cccccc;\">\n					<div class=\"imglab\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t685/96/811972813/58610/d1082b4d/548ea4ceN7273b5bd.jpg\" alt=\"\" /> \n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-1243\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#f3f3f3 url(http://img30.360buyimg.com/sku/jfs/t487/290/816270587/57176/b1d5d9d0/548ea5afN026eaf9a.jpg) no-repeat;\">\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n							、\n						</div>\n						<div class=\"title2\">\n							、\n						</div>\n					</div>\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t547/275/827858003/1121/958dc0d9/548ea626Na2fb0cd4.png\" alt=\"\" /> \n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \" id=\"\">\n			<div class=\"ssd-1080\">\n				<div class=\"ssd-j-module item_tit\">\n					<div class=\"tit1\">\n						产品细节\n					</div>\n					<div class=\"tit2\">\n						PRODUCT DETAILS\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-2165\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#ffffff url(http://img30.360buyimg.com/cms/jfs/t217/232/2460673136/4947/e76ec4b7/541a3cf8Ne7d0749d.png) no-repeat;\">\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t766/326/165583398/153663/931a1487/548ea712N54c54c32.jpg\" alt=\"\" /> \n					</div>\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n						</div>\n						<div class=\"title2\">\n						</div>\n					</div>\n				</div>\n			</div>\n		</div>\n		<div class=\" \">\n			<div class=\"ssd-2165\">\n				<div class=\"ssd-j-module item_tw_1\" style=\"background:#ffffff url(http://img30.360buyimg.com/cms/jfs/t217/232/2460673136/4947/e76ec4b7/541a3cf8Ne7d0749d.png) no-repeat;\">\n					<div class=\"img-pic\">\n						<img class=\"ssd-err-product\" src=\"http://img30.360buyimg.com/sku/jfs/t571/63/809585802/77035/720c5d87/548ea7d9N22f04056.jpg\" alt=\"\" /> \n					</div>\n					<div class=\"txt_box\">\n						<div class=\"title1\">\n						</div>\n						<div class=\"title2\">\n						</div>\n					</div>\n				</div>\n			</div>\n		</div>\n	</div>\n</div>', '2017-09-05 21:27:54', '2017-10-22 22:04:26');
INSERT INTO `tb_product_detail` VALUES ('150635087972564', '<p style=\"text-align:center;\">\n	<img src=\"http://ow2h3ee9w.bkt.clouddn.com/FqBDN5mRaCJfUXsZlEwgNlY9UCJw\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FvP7mq3aF6HSbnbiIe_amQQ1CWB8\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/Fllk6gbfTG93tJiDJRwbAgcKvea9\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/Fur__xJSxoOM9YyPWgELEkMwJZ78\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FrlJB1F11Oxr2bZ0n8PfMhuussu0\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FkrxCvAaRDyHCcqvD8XvYy-ayZI8\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FpS75rNFTD8NHmgJOOkV2LoZZldd\" alt=\"\" /> \n</p>\n<p style=\"text-align:center;\">\n	<img src=\"http://ow2h3ee9w.bkt.clouddn.com/FiZ_UVwbjVA60GLr05qD3Cn5JLkh\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FiIwt0c7nQHgjlPoLGIryIRPp7C-\" alt=\"\" /> \n</p>', '2017-09-25 22:47:59', '2017-09-26 21:39:23');
INSERT INTO `tb_product_detail` VALUES ('150642571432835', 'https://resource.smartisan.com/resource/3f618a3b236bc8c8f0243c5ad490874e.jpg?x-oss-process=image/resize,w_1920/indexcrop,y_1440,i_0/format,webp', '2017-09-05 21:27:54', '2017-11-19 22:36:10');
INSERT INTO `tb_product_detail` VALUES ('150642571432836', '<img src=\"https://resource.smartisan.com/resource/36fee45879f4f252492ec552dfd4c323.jpg\" style=\"width:1220px;height:6982px;\" alt=\"\" />', '2018-04-18 20:41:41', '2018-04-20 00:21:01');
INSERT INTO `tb_product_detail` VALUES ('150642571432837', '<img src=\"https://resource.smartisan.com/resource/5dcbe27f36e1f8f2bfdfabb0b2681879.jpg\" style=\"width:1220px;height:3665px;\" alt=\"\" />', '2018-04-19 00:34:06', '2018-04-19 23:49:38');
INSERT INTO `tb_product_detail` VALUES ('150642571432838', '<img src=\"https://resource.smartisan.com/resource/3aa27e8caf798b5e7e3796388190b43b.jpg\" style=\"width:1220px;height:5797px;\" alt=\"\" />', '2018-04-19 00:35:50', '2018-04-20 00:01:08');
INSERT INTO `tb_product_detail` VALUES ('150642571432839', '<img src=\"https://resource.smartisan.com/resource/fda5d962cc2b2e579c5df1c3d9e2f2c8.jpg\" style=\"width:1220px;height:4957px;\" alt=\"\" />', '2018-04-19 00:38:07', '2018-04-20 00:02:54');
INSERT INTO `tb_product_detail` VALUES ('150642571432840', '<img src=\"https://resource.smartisan.com/resource/14497b77e21fc6d0807e57bb9deabe28.jpg\" style=\"width:1220px;height:9527px;\" alt=\"\" />', '2018-04-19 00:40:40', '2018-04-20 00:04:41');
INSERT INTO `tb_product_detail` VALUES ('150642571432841', '<img src=\"https://resource.smartisan.com/resource/4272e7737eed967a8f2f10ebef9b84dc.jpg style=\"width:1220px;height:4990px;\" alt=\"\" />', '2018-04-19 00:43:48', '2018-04-20 00:06:59');
INSERT INTO `tb_product_detail` VALUES ('150642571432842', '<img src=\"https://resource.smartisan.com/resource/4cbe4a14ab225c9466e16f8c8ef4e29e.jpg\" style=\"width:1220px;height:4083px;\" alt=\"\" />', '2018-04-19 00:45:14', '2018-04-20 00:08:21');
INSERT INTO `tb_product_detail` VALUES ('150642571432843', '<img src=\"http://ow2h3ee9w.bkt.clouddn.com/FjNp6CU3QDN4X8wfjbONZ-kf2YbG\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FmbDadGBR28eur3yOGwxgMST0GlF\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FgHeBZRyLgCrHq3fg-36RWgwixeU\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FqEtQQx5n-8fQhy7csu1OrPbSsUI\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/Fq5I2-jrTWgrjZpAQbj13n4CUfoE\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/Fhj_BTPsZTC6ZXLAS3FS1B6ErYI_\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FnDbl9SM1Wafmv3tc5QdQ46fmJJt\" width=\"1220px\" alt=\"\" />', '2018-04-19 22:13:31', '2018-04-20 11:44:57');
INSERT INTO `tb_product_detail` VALUES ('150642571432844', '<img src=\"http://ow2h3ee9w.bkt.clouddn.com/FodxCrwcYDkQCQEplLXPt0Eu_1h2\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/Ft2VIi4GWeNB05Q3uEiVKJDquvv1\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FnUQwpuj0qiUsJtQ8e_5Z_PaMRSB\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FoGioa80w9Z2gKtHXwRgAR65vK4k\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FgY67q3m8sVmspUkeMEOPLt0oWpv\" width=\"1220px\" alt=\"\" /><img src=\"http://ow2h3ee9w.bkt.clouddn.com/FpXCKQ7WBg648LUVPkrt5zvm2teG\" width=\"1220px\" alt=\"\" />', '2018-04-19 22:16:05', '2018-04-20 11:47:02');
INSERT INTO `tb_product_detail` VALUES ('150642571432845', '<img src=\"https://resource.smartisan.com/resource/27a054301d8e10c40461443928dccd77.jpg\" style=\"width:1220px;height:7451px;\" alt=\"\" />', '2018-04-19 22:22:02', '2018-04-20 00:19:39');
INSERT INTO `tb_product_detail` VALUES ('150642571432846', '<img src=\"https://resource.smartisan.com/resource/65e89427674ee370fa58f5fe98120679.png\" style=\"width:1220px;height:7881px;\" alt=\"\" />', '2018-04-19 22:23:39', '2018-04-20 00:23:09');
INSERT INTO `tb_product_detail` VALUES ('150642571432847', '<img src=\"https://resource.smartisan.com/resource/41338ebac06fc82450f8b8e4867df257.jpg\" style=\"width:1220px;height:5043px;\" alt=\"\" />', '2018-04-19 22:25:41', '2018-04-20 10:51:53');
INSERT INTO `tb_product_detail` VALUES ('150642571432848', '<img src=\"https://resource.smartisan.com/resource/debb893778547fb9d5a6119b376d9ec1.jpg\" style=\"width:1220px;height:6879px;\" alt=\"\" />', '2018-04-19 22:28:11', '2018-04-20 10:53:15');
INSERT INTO `tb_product_detail` VALUES ('150642571432849', '<img src=\"https://resource.smartisan.com/resource/f03a523847e63f28f9238aad45567b37.jpg\" style=\"width:1220px;height:7935px;\" alt=\"\" />', '2018-04-19 22:31:09', '2018-04-20 10:54:24');
INSERT INTO `tb_product_detail` VALUES ('150642571432850', '<img src=\"https://resource.smartisan.com/resource/f6de19257228641b1a0c1964239b19b7.jpg\" style=\"width:1220px;height:9970px;\" alt=\"\" />', '2018-04-19 22:32:38', '2018-04-20 11:17:31');
INSERT INTO `tb_product_detail` VALUES ('150642571432851', '<img src=\"https://resource.smartisan.com/resource/a1f3fbf662376e8684e528f05721b286.jpg\" style=\"width:1220px;height:14998px;\" alt=\"\" />', '2018-04-19 22:36:50', '2018-04-20 00:13:44');
INSERT INTO `tb_product_detail` VALUES ('150642571432852', '<img src=\"https://resource.smartisan.com/resource/a86e4fc110fbb0bf72095a6ea78de841.jpg\" style=\"width:1220px;height:13362px;\" alt=\"\" />', '2018-04-19 22:38:59', '2018-04-20 00:18:17');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `state` int(11) DEFAULT NULL COMMENT '身份标识',
  `img` varchar(255) DEFAULT NULL COMMENT '头像',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', '7758258', '0', '1', 'http://pa6r78di4.bkt.clouddn.com/avator.jpg', null);
INSERT INTO `tb_user` VALUES ('2', 'test', 'test', null, null, null, 'http://pa6r78di4.bkt.clouddn.com/avator.jpg', null);
