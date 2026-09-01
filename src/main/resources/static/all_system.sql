/*
 Navicat Premium Dump SQL

 Source Server         : localhost3306
 Source Server Type    : MySQL
 Source Server Version : 80046 (8.0.46)
 Source Host           : localhost:3306
 Source Schema         : all_system

 Target Server Type    : MySQL
 Target Server Version : 80046 (8.0.46)
 File Encoding         : 65001

 Date: 01/09/2026 16:59:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `login_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `login_datetime` datetime NOT NULL COMMENT '登录时间',
  `login_pc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录设备',
  `login_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录ip',
  `id` int NOT NULL COMMENT 'id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `reg_date` datetime NOT NULL COMMENT '注册时间',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('005605d0d5c3651b9c60a37c05d0d99b', '123', '$2a$10$RUF/gSVkkVGKyPv6g3Y5yuf2lDhAzIkuINgCwZ5S4jYcTKA/1yaGy', '1056682585@qq.com', '2026-05-29 06:10:36', NULL);
INSERT INTO `user_login` VALUES ('2a0ebe4d16cad50c5051ef5562135cb2', '1', '$2a$10$nk3EGb08w1eZcuxCqHFG.O4RHQ.R0.0bUncHlVaHu5JoFEWRULZly', '1056682585@qq.com', '2026-05-29 10:30:45', '管理员');
INSERT INTO `user_login` VALUES ('3ac8343f6c7fab3c28830695772aac04', '2', '$2a$10$WcocgaRLLEFmpvKtwApaQO3KbH2cls6L/rRXPz6u5tGqHKYcxNS4C', '1056682585@qq.com', '2026-05-29 10:30:45', '管理员');
INSERT INTO `user_login` VALUES ('812d1a537052f33334e9392cfb4cc621', '流星雨', '$2a$10$dIwQqqouBOulKvNcaJ8Jf.9AvBbtGk8X9kGqbmsK9qJXbg/ve62Uy', '1056682585@qq.com', '2026-08-31 03:18:38', NULL);

SET FOREIGN_KEY_CHECKS = 1;
