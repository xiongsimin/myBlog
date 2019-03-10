/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3307
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 24/02/2019 16:22:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (123, '我是熊哥233', '303511');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, '第一篇博客', '<span style=\'color:red\'>这是博客内容</span>', '2019-02-20 00:30:26', NULL);
INSERT INTO `blog` VALUES (2, '第二篇博客', '这是第二篇博客', '2019-02-22 16:11:29', NULL);
INSERT INTO `blog` VALUES (3, '第三篇博客', '这是第三篇博客', '2019-02-22 16:25:07', NULL);
INSERT INTO `blog` VALUES (7, NULL, NULL, '2019-02-24 11:59:28', NULL);
INSERT INTO `blog` VALUES (8, NULL, NULL, '2019-02-24 12:00:35', NULL);

-- ----------------------------
-- Table structure for blog_type
-- ----------------------------
DROP TABLE IF EXISTS `blog_type`;
CREATE TABLE `blog_type`  (
  `blog_id` int(11) NOT NULL,
  `type_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_type
-- ----------------------------
INSERT INTO `blog_type` VALUES (1, 1);
INSERT INTO `blog_type` VALUES (2, 2);
INSERT INTO `blog_type` VALUES (3, 2);
INSERT INTO `blog_type` VALUES (7, 3);
INSERT INTO `blog_type` VALUES (7, 3);
INSERT INTO `blog_type` VALUES (8, 4);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '萌新', 1);
INSERT INTO `tag` VALUES (2, 'fdsf', 1);
INSERT INTO `tag` VALUES (3, '萌新2', 2);
INSERT INTO `tag` VALUES (4, 'fdsf', 2);
INSERT INTO `tag` VALUES (5, '萌新3', 3);
INSERT INTO `tag` VALUES (6, 'fdsf', 3);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `show` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, 'ssm', 1);
INSERT INTO `type` VALUES (2, 'spring', 1);
INSERT INTO `type` VALUES (3, 'jsp', 0);
INSERT INTO `type` VALUES (4, 'java', 1);

SET FOREIGN_KEY_CHECKS = 1;
