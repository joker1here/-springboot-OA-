/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : oa

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 22/09/2022 11:33:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `attendance_id` int(0) NOT NULL AUTO_INCREMENT,
  `attendance_employee` int(0) NULL DEFAULT 0,
  `sign_up_time` datetime(0) NULL DEFAULT NULL,
  `sign_back_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`attendance_id`) USING BTREE,
  INDEX `e3`(`attendance_employee`) USING BTREE,
  CONSTRAINT `e3` FOREIGN KEY (`attendance_employee`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (1, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (6, 1, '2022-05-25 13:24:06', '2022-05-25 17:24:10');
INSERT INTO `attendance` VALUES (8, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (9, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (10, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (11, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (12, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (13, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (14, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (15, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (16, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (17, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (18, 10, '2022-05-25 09:22:42', '2022-05-25 17:22:53');
INSERT INTO `attendance` VALUES (19, 10, '2022-05-25 23:28:33', '2022-05-25 15:48:41');
INSERT INTO `attendance` VALUES (20, 10, '2022-05-25 15:48:46', '2022-05-25 15:49:06');
INSERT INTO `attendance` VALUES (21, 10, '2022-05-25 15:52:08', '2022-05-25 15:57:23');
INSERT INTO `attendance` VALUES (22, 10, '2022-05-25 15:57:27', '2022-05-25 16:00:16');
INSERT INTO `attendance` VALUES (23, 10, '2022-05-26 01:36:40', '2022-05-26 02:16:20');
INSERT INTO `attendance` VALUES (24, 10, '2022-05-26 02:18:22', '2022-05-26 02:19:21');
INSERT INTO `attendance` VALUES (25, 10, '2022-05-26 08:56:28', '2022-05-26 08:56:43');
INSERT INTO `attendance` VALUES (26, 10, '2022-05-26 09:01:08', '2022-05-26 09:01:11');
INSERT INTO `attendance` VALUES (27, 10, '2022-05-29 12:04:15', '2022-05-29 12:05:28');
INSERT INTO `attendance` VALUES (28, 10, '2022-05-29 12:05:31', '2022-05-29 12:19:33');
INSERT INTO `attendance` VALUES (29, 10, '2022-05-30 05:18:14', '2022-05-30 07:05:07');
INSERT INTO `attendance` VALUES (31, 10, '2022-05-30 14:51:42', '2022-05-31 08:07:14');
INSERT INTO `attendance` VALUES (32, 10, '2022-05-31 08:19:01', '2022-05-31 08:19:05');
INSERT INTO `attendance` VALUES (33, 10, '2022-06-06 12:28:54', '2022-06-06 12:28:57');
INSERT INTO `attendance` VALUES (34, 10, '2022-06-06 12:30:03', '2022-06-06 12:35:04');
INSERT INTO `attendance` VALUES (35, 10, '2022-06-06 12:49:25', '2022-06-06 12:49:27');
INSERT INTO `attendance` VALUES (36, 10, '2022-06-06 13:06:38', '2022-06-06 13:06:39');
INSERT INTO `attendance` VALUES (37, 10, '2022-06-10 00:49:31', '2022-06-10 00:49:36');
INSERT INTO `attendance` VALUES (38, 1, '2022-09-15 07:49:23', '2022-09-15 07:50:17');
INSERT INTO `attendance` VALUES (39, 1, '2022-09-15 12:34:30', '2022-09-15 12:34:47');
INSERT INTO `attendance` VALUES (40, 1, '2022-09-15 13:29:21', '2022-09-15 13:29:25');
INSERT INTO `attendance` VALUES (41, 10, '2022-09-16 09:30:56', '2022-09-16 09:31:03');
INSERT INTO `attendance` VALUES (42, 10, '2022-09-20 07:41:40', '2022-09-20 07:41:45');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `car_id` int(0) NOT NULL,
  `car_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车牌号',
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for car_application
-- ----------------------------
DROP TABLE IF EXISTS `car_application`;
CREATE TABLE `car_application`  (
  `application_id` int(0) NOT NULL,
  `dept_id` int(0) NULL DEFAULT NULL,
  `employee_id` int(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`application_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_application
-- ----------------------------

-- ----------------------------
-- Table structure for cost_application
-- ----------------------------
DROP TABLE IF EXISTS `cost_application`;
CREATE TABLE `cost_application`  (
  `application_id` int(0) NOT NULL,
  `dept_id` int(0) NULL DEFAULT NULL,
  `employee_id` int(0) NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `file_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`application_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cost_application
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int(0) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept_introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '开发部门', '这是一个开发的部门');
INSERT INTO `dept` VALUES (2, '销售部', '这是一个负责销售的部门');
INSERT INTO `dept` VALUES (3, '外交部', '这是一个负责对外联络的部门');
INSERT INTO `dept` VALUES (22, '无部门', '还没加入部门');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_id` int(0) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Sex` int(0) NULL DEFAULT 0,
  `User_Level` int(0) NULL DEFAULT 0,
  `Dept_Id` int(0) NULL DEFAULT NULL,
  `Job_Id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE,
  INDEX `EmployeeID`(`employee_id`) USING BTREE,
  INDEX `fk_jobid`(`Job_Id`) USING BTREE,
  INDEX `fk_deptid`(`Dept_Id`) USING BTREE,
  INDEX `idx_employee_id`(`employee_id`) USING BTREE,
  CONSTRAINT `fk_deptid` FOREIGN KEY (`Dept_Id`) REFERENCES `dept` (`dept_id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `fk_jobid` FOREIGN KEY (`Job_Id`) REFERENCES `job` (`job_id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张三', '123', '肇庆学院', '1999-01-01', '123@123.com', '123456789', '', 1, 6, 1, 1);
INSERT INTO `employee` VALUES (9, 'zhangsan', 'zhangsan', '123', '2022-05-28', '', NULL, NULL, 0, 2, 1, 3);
INSERT INTO `employee` VALUES (10, 'Joker', 'yecanshuo159', '肇庆学院', '2022-04-29', '1231231234', NULL, NULL, 1, 4, 1, 1);
INSERT INTO `employee` VALUES (25, 'wenshaojie', 'wenshaojie', '456', '2022-05-25', '', NULL, NULL, 0, 0, 1, 4);
INSERT INTO `employee` VALUES (53, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (54, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (55, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (56, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (57, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (58, 'test', '123', '肇庆学院', '1998-12-30', '123@123.com', '123456789', '', 1, 0, 3, 23);
INSERT INTO `employee` VALUES (59, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (60, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (61, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (62, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (63, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (64, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (65, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (66, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (67, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (68, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (69, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (70, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (71, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (72, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (73, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (74, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (75, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (76, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (77, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (78, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (79, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (80, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (81, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (82, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (83, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (84, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (85, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (86, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (87, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (88, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (89, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (90, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (91, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (92, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (93, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (94, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (95, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (96, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (97, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (98, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (99, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (100, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (101, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (102, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (103, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (104, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (105, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (106, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (107, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (108, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (109, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (110, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (111, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (112, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (113, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (114, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (115, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (116, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (117, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (118, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (119, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (120, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (121, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (122, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);
INSERT INTO `employee` VALUES (123, 'test', '123', '肇庆学院', '1998-12-31', '123@123.com', '123456789', '', 1, 0, 22, 23);

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `file_id` int(0) NOT NULL AUTO_INCREMENT,
  `file_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `file_form` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `file_time` datetime(0) NULL DEFAULT NULL,
  `file_text` varchar(2550) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `file_to` int(0) NULL DEFAULT NULL,
  `employee_id` int(0) NOT NULL,
  `file_read` int(0) UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`file_id`) USING BTREE,
  INDEX `EmployeeID1`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (21, '1111', NULL, NULL, '2022-06-09 09:41:24', '11', 1, 10, 1);
INSERT INTO `file` VALUES (22, '新邮件地址', NULL, NULL, '2022-06-09 11:21:28', '122', 9, 10, 1);
INSERT INTO `file` VALUES (23, '存储地址测试', NULL, NULL, '2022-06-09 11:52:55', '122', 1, 10, 1);
INSERT INTO `file` VALUES (24, '新邮件地址', 'Apple iPad 10.2英寸平板电脑 2021年款（64GB WLAN版,A13芯片,1200万像素,iPadOS MK2K3CH,A） 深空灰色', 'png', '2022-06-09 11:53:32', '11', 1, 10, 1);
INSERT INTO `file` VALUES (25, '新邮件地址', '006', 'png', '2022-06-10 00:48:52', '122', 25, 10, 0);
INSERT INTO `file` VALUES (26, '1', NULL, NULL, '2022-06-10 00:50:46', '', 10, 10, 0);

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `job_id` int(0) NOT NULL AUTO_INCREMENT,
  `job_introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `job_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (1, '负责经验管理', '经理');
INSERT INTO `job` VALUES (2, '主要管理者', '主管');
INSERT INTO `job` VALUES (3, '工作者', '员工');
INSERT INTO `job` VALUES (4, '实习期的员工', '实习生');
INSERT INTO `job` VALUES (23, '默认职位', '无职位');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(0) NOT NULL AUTO_INCREMENT,
  `notice_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `notice_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `notice_time` datetime(0) NULL DEFAULT NULL,
  `employee_id` int(0) NOT NULL,
  PRIMARY KEY (`notice_id`, `employee_id`) USING BTREE,
  INDEX `EmployeeID2`(`employee_id`) USING BTREE,
  CONSTRAINT `EmployeeID2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '通知一', '这是通知一', '2022-05-05 22:42:10', 1);
INSERT INTO `notice` VALUES (14, '11', '11', '2022-06-06 13:17:55', 10);

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation`  (
  `relation_id` int(0) NOT NULL,
  `employee_id` int(0) NULL DEFAULT NULL,
  `is_read` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relation
-- ----------------------------

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `task_id` int(0) NOT NULL AUTO_INCREMENT,
  `task_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `task_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `employee_id` int(0) NOT NULL,
  `finish_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`task_id`) USING BTREE,
  INDEX `EmployeeID3`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, '这是任务一', '任务一', 10, '2022-05-05 22:39:39');
INSERT INTO `task` VALUES (2, '这是任务二', '任务二', 10, '2022-05-05 22:39:55');
INSERT INTO `task` VALUES (3, '这是任务三', '任务三', 10, '2022-05-05 22:40:11');
INSERT INTO `task` VALUES (6, '这是测试用的任务', '测试任务', 10, '2022-05-08 02:26:25');
INSERT INTO `task` VALUES (7, '这是测试用的任务', '测试任务', 10, '2022-05-08 02:26:50');

-- ----------------------------
-- Table structure for todo
-- ----------------------------
DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo`  (
  `todo_id` int(0) NOT NULL AUTO_INCREMENT,
  `todo_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `todo_finish` int(0) NULL DEFAULT 0,
  `employee_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`todo_id`) USING BTREE,
  INDEX `e4`(`employee_id`) USING BTREE,
  CONSTRAINT `e4` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of todo
-- ----------------------------
INSERT INTO `todo` VALUES (1, '回眸一笑百媚生，六宫粉黛无颜色。', 0, 10);
INSERT INTO `todo` VALUES (2, '芙蓉如面柳如眉，对此如何不泪垂。', 0, 10);
INSERT INTO `todo` VALUES (3, '芙蓉如面柳如眉，对此如何不泪垂。', 1, 10);
INSERT INTO `todo` VALUES (17, '125454', 1, 10);
INSERT INTO `todo` VALUES (18, '哈哈哈', 0, 10);

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `work_id` int(0) NOT NULL AUTO_INCREMENT,
  `work_time` datetime(0) NULL DEFAULT NULL,
  `employee_id` int(0) NULL DEFAULT NULL,
  `work_to` int(0) NULL DEFAULT NULL,
  `work_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_finish` float NULL DEFAULT 0,
  PRIMARY KEY (`work_id`) USING BTREE,
  INDEX `e2`(`work_to`) USING BTREE,
  INDEX `e1`(`employee_id`) USING BTREE,
  CONSTRAINT `e1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `e2` FOREIGN KEY (`work_to`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES (1, '2022-05-13 09:58:20', 1, 10, '完成任务', 55);
INSERT INTO `work` VALUES (6, '2022-05-25 15:32:35', 9, 10, '完成邮箱', 40);
INSERT INTO `work` VALUES (7, '2022-06-22 16:00:00', 10, 9, '123', 28);
INSERT INTO `work` VALUES (8, '2022-05-20 15:35:29', 1, 10, '111', 60);
INSERT INTO `work` VALUES (11, '2022-05-25 15:37:41', 1, 10, '1112', 49);

SET FOREIGN_KEY_CHECKS = 1;
