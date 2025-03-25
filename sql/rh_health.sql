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

 Date: 25/03/2025 13:48:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rh_health
-- ----------------------------
DROP TABLE IF EXISTS `rh_health`;
CREATE TABLE `rh_health`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `blood_pressure` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '血压',
  `weight` decimal(5, 2) NULL DEFAULT NULL COMMENT '体重',
  `height` decimal(5, 2) NULL DEFAULT NULL COMMENT '身高',
  `heart_rate` int NULL DEFAULT NULL COMMENT '心率',
  `blood_sugar` decimal(5, 2) NULL DEFAULT NULL COMMENT '血糖',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rh_health
-- ----------------------------
INSERT INTO `rh_health` VALUES (1, 'user2', '1', 100.00, 1.00, 1, 1.00, '0', '2025-03-16 14:23:01', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
