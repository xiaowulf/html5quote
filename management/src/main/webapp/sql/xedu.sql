/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : xedu

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2020-03-04 17:08:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for futures_close
-- ----------------------------
DROP TABLE IF EXISTS `futures_close`;
CREATE TABLE `futures_close` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `close_price` double DEFAULT NULL,
  `hand` double DEFAULT NULL,
  `record_date` bigint(20) DEFAULT NULL,
  `record_time` bigint(20) DEFAULT NULL,
  `strategy_id` bigint(20) DEFAULT NULL,
  `close_profit` double DEFAULT NULL,
  `fangxiang` varchar(255) DEFAULT NULL,
  `fund_account` varchar(255) DEFAULT NULL,
  `sxf` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of futures_close
-- ----------------------------
INSERT INTO `futures_close` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for futures_message
-- ----------------------------
DROP TABLE IF EXISTS `futures_message`;
CREATE TABLE `futures_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of futures_message
-- ----------------------------
INSERT INTO `futures_message` VALUES ('1', '武龙峰', '', '62378103');
INSERT INTO `futures_message` VALUES ('2', '武龙峰', '12121212121212', '62378103');

-- ----------------------------
-- Table structure for futures_orders
-- ----------------------------
DROP TABLE IF EXISTS `futures_orders`;
CREATE TABLE `futures_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_date` int(10) unsigned DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `hand` double DEFAULT NULL,
  `fund_account` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `strategy_id` bigint(20) unsigned DEFAULT NULL,
  `fangxiang` varchar(45) DEFAULT NULL,
  `record_time` varchar(45) DEFAULT NULL,
  `remain_hand` double DEFAULT NULL,
  `remain_profit` double DEFAULT NULL,
  `risk` double DEFAULT NULL,
  `ref_value` bigint(20) unsigned DEFAULT NULL,
  `sessionid` bigint(20) unsigned DEFAULT NULL,
  `frontid` bigint(20) unsigned DEFAULT NULL,
  `sxf` double DEFAULT NULL,
  `ccjsyk` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of futures_orders
-- ----------------------------
INSERT INTO `futures_orders` VALUES ('1', '1', '1', '1', '1', 'ag2006', null, '1', '1', '1', '1', '1', '1', null, '1', '1', '1');
INSERT INTO `futures_orders` VALUES ('2', '2', '2', '2', '2', 'i2005', '2', '2', '2', '2', '2', '2', '2', null, '2', '2', '2');
INSERT INTO `futures_orders` VALUES ('3', '3', '3', '3', '3', 'a2005', '3', '3', '3', '3', '3', '3', '3', null, '3', '3', '3');

-- ----------------------------
-- Table structure for futures_strategy
-- ----------------------------
DROP TABLE IF EXISTS `futures_strategy`;
CREATE TABLE `futures_strategy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_use` varchar(255) DEFAULT NULL,
  `qcqy` double DEFAULT NULL,
  `drqy` double DEFAULT NULL,
  `srqy` double DEFAULT NULL,
  `initdate` bigint(20) DEFAULT NULL,
  `record_date` bigint(20) DEFAULT NULL,
  `kyzj` double DEFAULT NULL,
  `relate_code` varchar(1000) NOT NULL,
  `isauto` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of futures_strategy
-- ----------------------------
INSERT INTO `futures_strategy` VALUES ('1', '策略一', '1', '1', null, null, null, '111', null, '1111', '1');
INSERT INTO `futures_strategy` VALUES ('2', '策略二', '1', '1', null, null, null, '111', null, '111', '11');

-- ----------------------------
-- Table structure for futures_sus_orders
-- ----------------------------
DROP TABLE IF EXISTS `futures_sus_orders`;
CREATE TABLE `futures_sus_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_date` int(10) unsigned DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `hand` double DEFAULT NULL,
  `fund_account` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `strategy_id` bigint(20) unsigned DEFAULT NULL,
  `fangxiang` varchar(45) DEFAULT NULL,
  `record_time` varchar(45) DEFAULT NULL,
  `remain_hand` double DEFAULT NULL,
  `remain_profit` double DEFAULT NULL,
  `risk` double DEFAULT NULL,
  `ref_value` bigint(20) unsigned DEFAULT NULL,
  `sessionid` bigint(20) unsigned DEFAULT NULL,
  `frontid` bigint(20) unsigned DEFAULT NULL,
  `sxf` double DEFAULT NULL,
  `ccjsyk` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of futures_sus_orders
-- ----------------------------
INSERT INTO `futures_sus_orders` VALUES ('1', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '2222', null, null, null);

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_use` varchar(255) DEFAULT NULL,
  `qcqy` double DEFAULT NULL,
  `drqy` double DEFAULT NULL,
  `srqy` double DEFAULT NULL,
  `initdate` bigint(20) DEFAULT NULL,
  `record_date` bigint(20) DEFAULT NULL,
  `kyzj` double DEFAULT NULL,
  `relate_code` varchar(1000) NOT NULL,
  `isauto` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of strategy
-- ----------------------------

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `true_name` varchar(255) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  `loginip` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `showorder` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('1', '1', '96E79218965EB72C92A549DD5A330112', '1', '2020-02-27 18:03:21', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `truename` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `pic1` varchar(255) DEFAULT NULL,
  `pic2` varchar(255) DEFAULT NULL,
  `pic3` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `resume` varchar(2000) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `truename` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `pic1` varchar(255) DEFAULT NULL,
  `pic2` varchar(255) DEFAULT NULL,
  `pic3` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `certificate` varchar(255) DEFAULT NULL,
  `resume` varchar(2000) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `video1` varchar(255) DEFAULT NULL,
  `video2` varchar(255) DEFAULT NULL,
  `video3` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  `create_date` bigint(20) DEFAULT NULL,
  `certificate2` varchar(255) DEFAULT NULL,
  `certificate3` varchar(255) DEFAULT NULL,
  `birthday` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('1', '张三', '1', '1', '1', '1', '1', null, '1', '1', '1', '2', '1', '教师资格证书', null, 'wu@kiiik.com', null, null, null, '4.2', '1', null, null, null, null);
SET FOREIGN_KEY_CHECKS=1;
