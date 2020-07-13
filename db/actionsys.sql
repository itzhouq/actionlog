/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : actionsys

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 13/07/2020 10:59:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `log_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '日志ID',
  `user_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户名字',
  `user_ip` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户IP',
  `request_method` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '请求方法',
  `request_desc` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '方法描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='日志表';

-- ----------------------------
-- Records of t_sys_log
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_log` VALUES ('1516cc86-655b-4c04-9beb-110c6ee75dde', 'tyuio', '82.21.34.23', 'GET', 'vbnm,', '2020-07-12 13:12:34');
INSERT INTO `t_sys_log` VALUES ('1bf69bc0-e2e9-4405-841e-4d4ea44454b1', '444', '82.21.34.224', 'GET', 'de444sc', NULL);
INSERT INTO `t_sys_log` VALUES ('262bdc30-41cc-43c3-8105-3dae4cfac22a', '分工会尽快了', '78.42.45.2', 'GET', '描述www', '2020-07-12 13:36:46');
INSERT INTO `t_sys_log` VALUES ('83e5fee7-566b-430e-aebd-e806d1f8210f', '333', '82.21.34.223', 'GET', 'de333sc', NULL);
INSERT INTO `t_sys_log` VALUES ('8df7c992-d854-4c10-beeb-ebc3e3c64206', 'Jack', '192.168.0.109', 'com.itzhouq.actionlog.controller.UserController.deleteUserById', '删除用户', NULL);
INSERT INTO `t_sys_log` VALUES ('bc88d875-4fe9-4158-bd06-56f9d9071fcf', '222', '82.21.34.222', 'GET', 'desc', '2020-07-12 13:18:59');
INSERT INTO `t_sys_log` VALUES ('c9851d74-06b2-4516-b0ff-29c1de736909', '1111', '82.21.34.21', 'GET', 'desc', '2020-07-11 00:00:00');
INSERT INTO `t_sys_log` VALUES ('eeeee', 'tyuiop', '128.23.35.22', 'GET', 'vbnm', '2020-07-12 01:43:44');
INSERT INTO `t_sys_log` VALUES ('rrr', 'dfghjk', '128.23.35.89', 'GET', 'fffffff', '2020-07-12 09:46:37');
INSERT INTO `t_sys_log` VALUES ('sdfghjkl', '用户1', '127.0.0.2', 'xxx', 'yyyy', '2020-07-11 15:55:51');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'itzhouq', '232323', '1', 'itzhouq111');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
