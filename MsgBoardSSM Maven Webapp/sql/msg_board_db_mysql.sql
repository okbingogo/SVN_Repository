/*
Navicat MySQL Data Transfer

Source Server         : MYSQL_LOCALHOST
Source Server Version : 50512
Source Host           : localhost:3306
Source Database       : msg_board_db

Target Server Type    : MYSQL
Target Server Version : 50512
File Encoding         : 65001

Date: 2016-07-16 17:46:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aa
-- ----------------------------
DROP TABLE IF EXISTS `aa`;
CREATE TABLE `aa` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aa
-- ----------------------------
INSERT INTO `aa` VALUES ('2');
INSERT INTO `aa` VALUES ('4');
INSERT INTO `aa` VALUES ('6');
INSERT INTO `aa` VALUES ('8');
INSERT INTO `aa` VALUES ('10');

-- ----------------------------
-- Table structure for bb
-- ----------------------------
DROP TABLE IF EXISTS `bb`;
CREATE TABLE `bb` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb
-- ----------------------------
INSERT INTO `bb` VALUES ('1');
INSERT INTO `bb` VALUES ('2');
INSERT INTO `bb` VALUES ('3');
INSERT INTO `bb` VALUES ('4');
INSERT INTO `bb` VALUES ('5');
INSERT INTO `bb` VALUES ('6');
INSERT INTO `bb` VALUES ('7');
INSERT INTO `bb` VALUES ('8');
INSERT INTO `bb` VALUES ('9');
INSERT INTO `bb` VALUES ('10');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `comm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `from_name` varchar(16) NOT NULL COMMENT '评论用户名',
  `msg_id` int(11) NOT NULL COMMENT '评论所属留言编号',
  `comm_content` varchar(200) NOT NULL COMMENT '评论内容',
  `comm_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`comm_id`),
  KEY `user_id` (`from_name`),
  KEY `msg_id` (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', 'a', '2', 'sdafdsaSfsdfa撒发撒旦发撒旦圣达菲', '2016-07-13 14:04:45');
INSERT INTO `t_comment` VALUES ('2', 'a', '2', 'sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定', '2016-07-13 14:04:54');
INSERT INTO `t_comment` VALUES ('3', 'a', '2', 'sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定', '2016-07-13 14:04:58');
INSERT INTO `t_comment` VALUES ('4', 'a', '2', 'sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定', '2016-07-13 14:05:01');
INSERT INTO `t_comment` VALUES ('5', 'a', '2', 'sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定', '2016-07-13 14:05:03');
INSERT INTO `t_comment` VALUES ('6', 'a', '2', 'sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定sdfa发电公司的地方公司法定', '2016-07-13 14:05:06');
INSERT INTO `t_comment` VALUES ('7', 'a', '10', '#10\r\ntest1\r\n阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法', '2016-07-13 14:07:25');
INSERT INTO `t_comment` VALUES ('8', 'a', '11', 'sqlserver却会出事', '2016-07-14 08:42:48');
INSERT INTO `t_comment` VALUES ('9', 'b', '17', '把是打发萨的发生', '2016-07-16 16:40:17');
INSERT INTO `t_comment` VALUES ('10', 'b', '17', '把是打发法撒旦', '2016-07-16 16:41:06');
INSERT INTO `t_comment` VALUES ('11', 'b', '17', 'fdsafdsadf', '2016-07-16 16:41:15');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
  `from_name` varchar(16) NOT NULL COMMENT '留言用户名',
  `msg_content` varchar(200) NOT NULL COMMENT '留言内容',
  `msg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '留言时间',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('1', 'a', 'sadfsdfsdfsad', '2016-07-13 13:56:18');
INSERT INTO `t_message` VALUES ('2', 'a', 'sdfa发电公司的地方公司法定', '2016-07-13 13:56:25');
INSERT INTO `t_message` VALUES ('3', 'a', '是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打发打发是打发打', '2016-07-12 13:56:37');
INSERT INTO `t_message` VALUES ('4', 'a', '阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法', '2016-07-13 14:05:49');
INSERT INTO `t_message` VALUES ('5', 'a', '阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法', '2016-07-13 14:05:50');
INSERT INTO `t_message` VALUES ('6', 'a', '阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法', '2016-07-13 14:05:52');
INSERT INTO `t_message` VALUES ('7', 'a', '阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法', '2016-07-13 14:05:54');
INSERT INTO `t_message` VALUES ('8', 'a', '阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法', '2016-07-13 14:05:57');
INSERT INTO `t_message` VALUES ('9', 'a', '阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法', '2016-07-13 14:05:59');
INSERT INTO `t_message` VALUES ('10', 'a', '阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发撒旦法阿斯顿发', '2016-07-13 14:06:12');
INSERT INTO `t_message` VALUES ('11', 'a', '为什么毛事都没有\r\n', '2016-07-14 08:42:28');
INSERT INTO `t_message` VALUES ('12', 'a', '阿萨德法撒旦', '2016-07-15 10:04:33');
INSERT INTO `t_message` VALUES ('13', 'aa', 'sdfsadsa发生的发生的', '2016-07-16 16:13:31');
INSERT INTO `t_message` VALUES ('14', 'aa', '啊阿萨德发的是', '2016-07-16 16:30:42');
INSERT INTO `t_message` VALUES ('15', 'aa', 'asdfsadfsd是的发生的发生的', '2016-07-16 16:38:19');
INSERT INTO `t_message` VALUES ('16', 'aa', '萨的发生发的是的', '2016-07-16 16:38:26');
INSERT INTO `t_message` VALUES ('17', 'aa', '是打发打发', '2016-07-16 16:40:01');
INSERT INTO `t_message` VALUES ('18', 'a', 'sdfad多少分', '2016-07-16 17:40:28');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(16) NOT NULL COMMENT '用户名',
  `password` varchar(16) NOT NULL COMMENT '用户密码',
  `email` varchar(32) NOT NULL COMMENT '用户邮箱',
  `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'a', 'a', 'a', '2016-07-13 13:50:56');
INSERT INTO `t_user` VALUES ('2', 'b', 'b', 'b', '2016-07-13 13:51:06');
INSERT INTO `t_user` VALUES ('4', 'c', 'c', 'c', '2016-07-13 13:54:33');
INSERT INTO `t_user` VALUES ('5', 'd', 'd', 'd', '2016-07-13 13:54:43');
INSERT INTO `t_user` VALUES ('6', 'e', 'e', 'e', '2016-07-13 13:54:57');
INSERT INTO `t_user` VALUES ('7', 'f', 'f', 'f', '2016-07-13 13:55:02');
INSERT INTO `t_user` VALUES ('8', 'g', 'g', 'g', '2016-07-13 13:55:06');
INSERT INTO `t_user` VALUES ('9', 'h', 'h', 'h', '2016-07-13 13:55:10');
INSERT INTO `t_user` VALUES ('10', 'test1', 'test1', 'test1', '2016-07-13 13:55:21');
INSERT INTO `t_user` VALUES ('11', 'test2', 'test2', 'test2', '2016-07-13 13:55:44');
INSERT INTO `t_user` VALUES ('12', '地方', 'df', 'df', '2016-07-13 13:56:11');
INSERT INTO `t_user` VALUES ('13', 'aa', 'aa', 'aa', '2016-07-16 14:37:34');
