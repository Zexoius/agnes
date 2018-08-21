/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : agnes

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2018-08-21 18:18:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_product`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `desciption` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `image` varchar(2000) DEFAULT NULL,
  `cid` bigint(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38973 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('38972', 'TPU 环保材质、耐磨、耐油、耐久性强', '坚果 Pro 软胶保护套', '38.00', '999', 'http://image.smartisanos.cn/resource/902befd5f32a8caf4ca79b55d39ee25a.jpg', '560', '1', null, null);

-- ----------------------------
-- Table structure for `tb_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_detail`;
CREATE TABLE `tb_product_detail` (
  `goods_id` bigint(20) NOT NULL,
  `goods_detail` text,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product_detail
-- ----------------------------
INSERT INTO `tb_product_detail` VALUES ('38972', '<img src=\"http://image.smartisanos.cn/resource/98521dbfe1dd1e67db3f7ca21e76c9ef.jpg\" style=\"width:1220px;height:7000px;\" alt=\"\" />', '2018-08-21 16:58:17', '2018-08-21 16:58:22');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', null, '0', null);
