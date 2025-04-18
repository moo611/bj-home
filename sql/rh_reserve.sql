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

 Date: 25/03/2025 13:48:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rh_reserve
-- ----------------------------
DROP TABLE IF EXISTS `rh_reserve`;
CREATE TABLE `rh_reserve`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `service_id` int NULL DEFAULT NULL COMMENT '服务id',
  `service_date` datetime NULL DEFAULT NULL COMMENT '预约时间',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '预约人',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rh_reserve
-- ----------------------------
INSERT INTO `rh_reserve` VALUES (2, 2, '2025-03-25 10:03:00', 'user1', '0', '2025-03-25 11:06:39', NULL, NULL, NULL);
INSERT INTO `rh_reserve` VALUES (3, 1, '2025-03-26 00:00:00', 'user1', '0', '2025-03-25 11:44:08', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
