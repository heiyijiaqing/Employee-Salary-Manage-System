/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : employee_salary_manage_system

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2020-06-28 15:01:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for basicsalary
-- ----------------------------
DROP TABLE IF EXISTS `basicsalary`;
CREATE TABLE `basicsalary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` int(11) DEFAULT NULL COMMENT '所属用户，关联User.id',
  `basicSalary` float(10,2) DEFAULT NULL COMMENT '基本薪资，由人力资源管理人员设置。',
  `laterDeductMoney` float(10,2) DEFAULT NULL COMMENT '迟到扣薪标准',
  `absenceDeductMoney` float(10,2) DEFAULT NULL COMMENT '旷工扣薪标准',
  `weekendOverWorkMoney` float(10,2) DEFAULT NULL COMMENT '周末加班薪资标准',
  `holidayOverWorkMoney` float(10,2) DEFAULT NULL COMMENT '节日加班薪资标准',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `isDel` tinyint(1) DEFAULT '0' COMMENT '是否删除：0-未删除；1-已删除。',
  PRIMARY KEY (`id`),
  KEY `fk_BasicSalary_User` (`userId`) USING BTREE,
  CONSTRAINT `basicsalary_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='03 薪资基本参数表';

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名',
  `createDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `isDel` tinyint(1) DEFAULT '0' COMMENT '是否删除：0-未删除；1-已删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='01 部门表';

-- ----------------------------
-- Table structure for rewardpunish
-- ----------------------------
DROP TABLE IF EXISTS `rewardpunish`;
CREATE TABLE `rewardpunish` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` int(11) DEFAULT NULL COMMENT '所属用于，关联User.id',
  `type` tinyint(1) DEFAULT NULL COMMENT '奖惩类型：\r\n0-市场部销售提成；\r\n1-节日福利奖金；\r\n2-年终奖金；\r\n3-迟到；\r\n4-旷工；\r\n5-周末加班；\r\n6-节日加班。',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述奖惩类型的具体内容，如节日加班是哪个借。',
  `money` float(10,2) DEFAULT NULL COMMENT '奖惩金额',
  `yearMonth` varchar(6) DEFAULT NULL COMMENT '保存奖惩所属年月。',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `isDel` tinyint(1) DEFAULT '0' COMMENT '是否删除：0-未删除；1-已删除。',
  PRIMARY KEY (`id`),
  KEY `fk_RewardPunish_User` (`userId`) USING BTREE,
  CONSTRAINT `rewardpunish_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='04 惩罚和奖励表';

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` int(11) DEFAULT NULL COMMENT '所属用户，关联User.id',
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门，关联Department.id。',
  `totalSalary` float(10,2) DEFAULT NULL COMMENT '计算月工资',
  `yearMonth` varchar(6) DEFAULT NULL COMMENT '保存薪资统计年月，如202006。',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `isDel` tinyint(1) DEFAULT '0' COMMENT '是否删除：0-未删除；已删除。',
  PRIMARY KEY (`id`),
  KEY `fk_Salary_User` (`userId`) USING BTREE,
  KEY `fk_Salary_Department` (`departmentId`) USING BTREE,
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `salary_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='05 薪资统计表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门，关联Department.id',
  `account` varchar(255) DEFAULT NULL COMMENT '账户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '用于加密',
  `name` varchar(255) DEFAULT NULL COMMENT '个人真实姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别：0-女；1-男。',
  `age` smallint(3) DEFAULT NULL COMMENT '年龄，每年自动+1。',
  `phoneNumber` int(11) DEFAULT NULL COMMENT '联系方式，手机号码。',
  `jobTitle` tinyint(1) DEFAULT NULL COMMENT '职位：0-普通员工；1-部门经理。',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `isDel` tinyint(1) DEFAULT '0' COMMENT '是否删除：0-未删除；1-已删除。',
  PRIMARY KEY (`id`),
  KEY `fk_User_Department` (`departmentId`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='02 用户表';
