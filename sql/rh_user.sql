/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 25/03/2025 13:48:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rh_user
-- ----------------------------
DROP TABLE IF EXISTS `rh_user`;
CREATE TABLE `rh_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `role` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '0管理员1医护人员2老人3家属',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rh_user
-- ----------------------------
INSERT INTO `rh_user` VALUES (1, 'admin', '$2a$10$yIYPQz0.mSBy7pmpu1kAae2a.Vkk1vUuycalPKs1HkEcRLXUX28za', '管理员', '0', '0', '2025-03-15 15:54:38', NULL, NULL, NULL, 20, '0');
INSERT INTO `rh_user` VALUES (2, 'user1', '$2a$10$DxRzQ72NNpAbOvEpTOa8IOSvYyEiNuRXwqcmY621D19xnBWKdMURO', '老王', '2', '0', '2025-03-15 16:18:39', NULL, NULL, NULL, 80, '0');
INSERT INTO `rh_user` VALUES (3, 'user2', '$2a$10$AjToF9c/sqybQ9aG1qAEzeSyeIjC5PBo5FM6QsAhoiRuyrUgoKMhi', '老李', '2', '0', '2025-03-15 16:21:49', NULL, NULL, NULL, 76, '1');
INSERT INTO `rh_user` VALUES (4, 'server1', '$2a$10$WLKUyEpmINFrpqR6rNGHCOrZJXh2L65L/QyjPxfRCULgPOM7qnQ6i', '护工小张', '1', '0', '2025-03-24 17:36:26', NULL, NULL, NULL, 30, '1');
INSERT INTO `rh_user` VALUES (5, 'server2', '$2a$10$LCpE5AqrPeWicQ0xyN7HY.haW.TlRMYKgIIims0uhgki4ZsFk/m3G', '小赵', '1', '0', '2025-03-24 17:37:04', NULL, NULL, NULL, 25, '1');

SET FOREIGN_KEY_CHECKS = 1;
