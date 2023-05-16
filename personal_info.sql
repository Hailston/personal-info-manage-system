/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : personal_info

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 16/05/2023 21:54:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for date
-- ----------------------------
DROP TABLE IF EXISTS `date`;
CREATE TABLE `date` (
  `username` varchar(30) DEFAULT NULL COMMENT '用户登录名',
  `date` varchar(30) NOT NULL COMMENT '日程时间',
  `thing` varchar(255) DEFAULT NULL COMMENT '日程内容',
  PRIMARY KEY (`date`),
  KEY `date_ibfk_1` (`username`),
  CONSTRAINT `date_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `username` varchar(30) DEFAULT NULL COMMENT '用户登录名',
  `title` varchar(30) DEFAULT NULL COMMENT '文件标题',
  `name` varchar(30) DEFAULT NULL COMMENT '文件名字',
  `contentType` varchar(30) DEFAULT NULL COMMENT '文件类型',
  `size` varchar(30) DEFAULT NULL COMMENT '文件大小',
  `filePath` varchar(255) DEFAULT NULL COMMENT '用户操作',
  KEY `file_ibfk_1` (`username`),
  CONSTRAINT `file_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `username` varchar(30) DEFAULT NULL COMMENT '用户登录名',
  `name` varchar(30) DEFAULT NULL COMMENT '好友名称',
  `phone` char(11) DEFAULT NULL COMMENT '好友电话',
  `email` varchar(30) DEFAULT NULL COMMENT '好友邮箱',
  `workplace` varchar(30) DEFAULT NULL COMMENT '好友工作单位',
  `place` varchar(30) DEFAULT NULL COMMENT '好友住址',
  `QQ` varchar(10) DEFAULT NULL COMMENT '好友QQ号',
  KEY `username` (`username`),
  CONSTRAINT `friend_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(30) NOT NULL COMMENT '用户登录名',
  `password` varchar(30) DEFAULT NULL COMMENT '用户登录密码',
  `name` varchar(30) DEFAULT NULL COMMENT '用户真实姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '用户性别',
  `birth` varchar(10) DEFAULT NULL COMMENT '出生日期',
  `nation` varchar(10) DEFAULT NULL COMMENT '用户民族',
  `edu` varchar(10) DEFAULT NULL COMMENT '用户学历',
  `work` varchar(30) DEFAULT NULL COMMENT '用户职称',
  `phone` char(11) DEFAULT NULL COMMENT '用户电话',
  `place` varchar(30) DEFAULT NULL COMMENT '用户住址',
  `email` varchar(30) DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
