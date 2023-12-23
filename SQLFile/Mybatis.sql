/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : 127.0.0.1:3306
 Source Schema         : Mybatis

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 23/12/2023 21:08:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Academy
-- ----------------------------
DROP TABLE IF EXISTS `Academy`;
CREATE TABLE `Academy`  (
  `id` int NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `fk_AcademyId`(`id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Academy
-- ----------------------------
INSERT INTO `Academy` VALUES (10000, '电子与物联网');
INSERT INTO `Academy` VALUES (10001, '数学科学学院');
INSERT INTO `Academy` VALUES (10002, '工业与互联网');
INSERT INTO `Academy` VALUES (10003, '测试');

-- ----------------------------
-- Table structure for Account
-- ----------------------------
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`  (
  `Username` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Password` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Account
-- ----------------------------
INSERT INTO `Account` VALUES ('10000', '123456', 1);
INSERT INTO `Account` VALUES ('10001', '123456', NULL);

-- ----------------------------
-- Table structure for Specialized
-- ----------------------------
DROP TABLE IF EXISTS `Specialized`;
CREATE TABLE `Specialized`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `academyId` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_AcademyId`(`academyId` ASC) USING BTREE,
  CONSTRAINT `fk_AcademyId` FOREIGN KEY (`academyId`) REFERENCES `Academy` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10008 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Specialized
-- ----------------------------
INSERT INTO `Specialized` VALUES (10000, '物联网信息技术', 10000);
INSERT INTO `Specialized` VALUES (10001, '数字建模', 10001);
INSERT INTO `Specialized` VALUES (10002, '应用电子技术', 10000);
INSERT INTO `Specialized` VALUES (10004, '电子信息', 10001);

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student`  (
  `uid` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `addr` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `academy` int NULL DEFAULT NULL,
  `specialized` int NULL DEFAULT NULL,
  `studentClass` int NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `studentAcademy`(`academy` ASC) USING BTREE,
  INDEX `studentSpecialized`(`specialized` ASC) USING BTREE,
  INDEX `studentStudentClass`(`studentClass` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Student
-- ----------------------------
INSERT INTO `Student` VALUES (5, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (10, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (15, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (18, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (19, '王五', 19, '男', '未知', 10000, 10000, 10000302);
INSERT INTO `Student` VALUES (20, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (21, '王五', 20, '男', '未知', 10000, 10000, 10000302);
INSERT INTO `Student` VALUES (22, '李四', 20, '男', '未知', 10000, 10000, 10000302);
INSERT INTO `Student` VALUES (23, '李明', 20, '女', '未知', 10000, 10000, 10000302);
INSERT INTO `Student` VALUES (24, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (25, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (26, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (27, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (28, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (29, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (30, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (31, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (32, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (33, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (34, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (35, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (36, '王五', 20, '男', '未知', 10000, 10000, 10000302);
INSERT INTO `Student` VALUES (37, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (38, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (39, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (40, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (41, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (42, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (43, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (44, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (45, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (46, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (47, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (48, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (49, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (50, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (51, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (52, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (53, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (54, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (55, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (56, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (57, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (58, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (59, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (60, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (61, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (62, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (63, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (64, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (65, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (66, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (67, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (68, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (69, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (70, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (71, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (72, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (73, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (74, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (75, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (76, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (77, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (78, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (79, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (80, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (81, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (82, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (83, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (84, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (85, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (86, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (87, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (88, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (89, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (90, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (91, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (92, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (93, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (94, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (95, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (96, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (97, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (98, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (99, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (100, '张三', 18, '男', '未知', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (101, '王五', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (102, '李四', 20, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (103, '李明', 20, '女', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (104, '王五', 19, '男', '未知', 10000, 10000, 10000301);
INSERT INTO `Student` VALUES (107, '测试用信息', 20, '女', '测试用信息', 10001, 10001, 10001301);
INSERT INTO `Student` VALUES (108, '测试', 20, '男', '测试', 10001, 10000, 10002302);
INSERT INTO `Student` VALUES (109, '测试用数据', 19, '女', '测试', 10000, 10002, 10002301);

-- ----------------------------
-- Table structure for StudentClass
-- ----------------------------
DROP TABLE IF EXISTS `StudentClass`;
CREATE TABLE `StudentClass`  (
  `id` int NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `specializedId` int NULL DEFAULT NULL,
  INDEX `fk_SpecializedId`(`specializedId` ASC) USING BTREE,
  INDEX `id`(`id` ASC) USING BTREE,
  CONSTRAINT `fk_SpecializedId` FOREIGN KEY (`specializedId`) REFERENCES `Specialized` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of StudentClass
-- ----------------------------
INSERT INTO `StudentClass` VALUES (10000301, '物联网301', 10000);
INSERT INTO `StudentClass` VALUES (10002301, '应用电子301', 10002);
INSERT INTO `StudentClass` VALUES (10001301, '数字建模301', 10001);
INSERT INTO `StudentClass` VALUES (10000302, '物联网302', 10000);
INSERT INTO `StudentClass` VALUES (10002302, '物联网303', 10000);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
