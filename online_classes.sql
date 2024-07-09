/*
 Navicat Premium Data Transfer

 Source Server         : xuying
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : online_classes

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 22/03/2022 15:52:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `isInSchool` tinyint(1) NULL DEFAULT 1 COMMENT '是否在校',
  `userFace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `isStudent` tinyint(1) NULL DEFAULT 1 COMMENT '是否是学生',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否锁定',
  `enrollmentTime` date NULL DEFAULT NULL COMMENT '入学时间',
  `majorId` int(11) NULL DEFAULT NULL COMMENT '专业ID',
  `gradeId` int(11) NULL DEFAULT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tb_admin_ibfk_1`(`majorId`) USING BTREE,
  INDEX `tb_admin_ibfk_2`(`gradeId`) USING BTREE,
  CONSTRAINT `tb_admin_ibfk_1` FOREIGN KEY (`majorId`) REFERENCES `tb_major` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_admin_ibfk_2` FOREIGN KEY (`gradeId`) REFERENCES `tb_grades` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, 'admin', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '管理员', NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://tupian.qqw21.com/article/UploadPic/2020-4/202041521185361316.jpg', 0, 1, NULL, NULL, NULL);
INSERT INTO `tb_admin` VALUES (2, '1111111111', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '张老师', '男', '1983-02-02', '410122198302025462', '13865423154', '河南省开封市', '13865423154@163.com', 1, 'https://tse1-mm.cn.bing.net/th/id/R-C.ecf1d650a18f8fbe82dfc43522cc7ca8?rik=jtZHyCzxPa1Ajw&riu=http%3a%2f%2fwww.qubiaoqing.cn%2fpic%2f2020%2f12%2f08%2fptt1vffjthj.jpg&ehk=QJCnAHw7suQlmbEqZwMCKwvGvKhBDr3%2fjhWTbYTQxI4%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1', 0, 1, '2000-02-04', NULL, NULL);
INSERT INTO `tb_admin` VALUES (3, '1812030001', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '学生甲', '男', '2000-02-08', '410122200002081236', '13256641256', '河南省郑州市中牟县', '13256641256@163.com', 1, 'https://tse1-mm.cn.bing.net/th/id/R-C.b0669c36c39de9e8942d7371ffcccbc2?rik=ejRxilJt5w6OJA&riu=http%3a%2f%2fpic.ntimg.cn%2ffile%2f20180816%2f27259502_133950770037_2.jpg&ehk=zaN011aK%2b%2buTJK0DcDHCglhMlszTTzSrO5XE9Zum%2fl8%3d&risl=&pid=ImgRaw&r=0', 1, 1, '2018-09-01', 3, 3);
INSERT INTO `tb_admin` VALUES (4, '1812030036', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '韩虎', '男', '1998-11-19', '410122199811197419', '13253347105', '河南省郑州市中牟县', '13253347105@163.com', 1, 'https://imgo.68h5.com/img2022/1/26/17/2022012671781140.jpg', 1, 1, '2018-09-01', 1, 1);
INSERT INTO `tb_admin` VALUES (5, '1812030004', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '王五', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 1, 'https://tse3-mm.cn.bing.net/th/id/OIP-C.o3RTYOcYpneyyH3WVTD-CAAAAA?pid=ImgDet&rs=1', 1, 1, '2018-10-16', 3, 1);
INSERT INTO `tb_admin` VALUES (6, '1812030005', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '刘六', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 1, 'https://tse1-mm.cn.bing.net/th/id/OIP-C.T4MZjBiEJyKkRVymS0AyAgAAAA?pid=ImgDet&rs=1', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (7, '1812030006', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '阿泽', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 1, 'https://tse3-mm.cn.bing.net/th/id/OIP-C.V4LnQOdeOmKKT1zhgvixvwAAAA?pid=ImgDet&rs=1', 1, 1, '2018-10-16', 2, 3);
INSERT INTO `tb_admin` VALUES (8, '1812030007', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '狗焕', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 0, 'https://tse4-mm.cn.bing.net/th/id/OIP-C.VWGW8yd_tisshcgpU9n-TgAAAA?pid=ImgDet&rs=1', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (9, '1812030008', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '德善', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (10, '1812030009', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '贾哦跑', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 4);
INSERT INTO `tb_admin` VALUES (11, '1812030010', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '张东健', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 0, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (12, '1812030011', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '姚冬季', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 3);
INSERT INTO `tb_admin` VALUES (13, '1812030012', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '周杰伦', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (14, '1812030013', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '朱亚文', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (15, '1812030014', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '周迅', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 4);
INSERT INTO `tb_admin` VALUES (16, '1812030015', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '夕设计', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (17, '1812030016', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '德哈卡', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_admin` VALUES (18, '1812030065', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', 'xxx', '', '1999-11-20', '123456789541232546', '', '', '', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-10-16', 1, 1);
INSERT INTO `tb_admin` VALUES (19, '1812030003', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '李四', '女', '1999-11-20', '410122199811197416', '13253347105', '河北省xx市xx县', '132533417500@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-09-01', 2, 1);
INSERT INTO `tb_admin` VALUES (21, '1812030017', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '学生乙', '男', '2000-02-08', '410122200002081236', '13256641256', '河南省郑州市中牟县', '13256641256@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-09-01', 3, 3);
INSERT INTO `tb_admin` VALUES (22, '1812030018', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '学生丙', '男', '2000-11-19', '410122200011197419', '13253347105', '河南省郑州市中牟县', '13253347105@163.com', 1, 'https://img.ixintu.com/download/jpg/202001/f0029cfddeaec4c88b84df3cfb6ba6a3.jpg!ys', 1, 1, '2018-09-01', 1, 1);
INSERT INTO `tb_admin` VALUES (24, '1812030019', '$2a$10$kgrWmS7wDYpiqFNaLn24IO3cAVO.g7ZU3eaktU8dEaAJCfQrgdWtG', '测试1', '男', '2000-02-08', '410122200002081236', '13256641256', '河南省郑州市中牟县', '13256641256@163.com', 1, NULL, 1, 1, '2018-09-01', 3, 3);
INSERT INTO `tb_admin` VALUES (25, '1812030020', NULL, '测试2', '女', '2000-02-08', '410122200002081236', '13256641256', '河南省郑州市中牟县', '13256641256@163.com', 1, NULL, 1, 1, '2018-09-01', 1, 3);

-- ----------------------------
-- Table structure for tb_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_role`;
CREATE TABLE `tb_admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `rid` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `adminId`(`adminId`) USING BTREE,
  CONSTRAINT `tb_admin_role_ibfk_1` FOREIGN KEY (`adminId`) REFERENCES `tb_admin` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tb_admin_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `tb_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin_role
-- ----------------------------
INSERT INTO `tb_admin_role` VALUES (1, 1, 1);
INSERT INTO `tb_admin_role` VALUES (2, 2, 2);
INSERT INTO `tb_admin_role` VALUES (3, 3, 5);
INSERT INTO `tb_admin_role` VALUES (4, 4, 5);
INSERT INTO `tb_admin_role` VALUES (5, 5, 5);

-- ----------------------------
-- Table structure for tb_courses
-- ----------------------------
DROP TABLE IF EXISTS `tb_courses`;
CREATE TABLE `tb_courses`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `courseName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `credit` int(11) NULL DEFAULT NULL COMMENT '学分',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型',
  `week` int(11) NULL DEFAULT NULL,
  `jieci` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_courses
-- ----------------------------
INSERT INTO `tb_courses` VALUES (1, '移动应用开发技术', 2, '选修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (2, '网络应用编程', 2, '选修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (3, '计算机图形学', 2, '选修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (4, '数据结构', 4, '必修', 1, 2);
INSERT INTO `tb_courses` VALUES (5, '操作系统', 3, '必修', 2, 1);
INSERT INTO `tb_courses` VALUES (6, '计算机组成原理', 3, '必修', 3, 3);
INSERT INTO `tb_courses` VALUES (7, '计算机网络', 3, '必修', 4, 2);
INSERT INTO `tb_courses` VALUES (8, '高等数学', 5, '必修', 5, 1);
INSERT INTO `tb_courses` VALUES (9, '线性代数', 3, '必修', 5, 3);
INSERT INTO `tb_courses` VALUES (10, '概率与统计', 2, '必修', 6, 2);
INSERT INTO `tb_courses` VALUES (11, '大学英语视听说', 2, '必修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (12, '大学英语读写译', 2, '必修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (13, '马克思主义基本原理', 2, '必修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (14, '毛泽东思想', 2, '必修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (15, '编译原理', 2, '选修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (16, '物联网技术', 2, '选修', NULL, NULL);
INSERT INTO `tb_courses` VALUES (18, '测试1', 2, '选修', NULL, NULL);

-- ----------------------------
-- Table structure for tb_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_file`;
CREATE TABLE `tb_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `trueName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务器中的文件名',
  `fileSize` int(11) NOT NULL COMMENT '文件大小',
  `uploadTime` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上传时间',
  `fileType` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `fileUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文件下载链接',
  `uploadUser` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传文件的用户名',
  `isExist` tinyint(1) NULL DEFAULT 1 COMMENT '是否存在',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_file
-- ----------------------------
INSERT INTO `tb_file` VALUES (1, 'spring-boot-文档.pdf', 'javakf/spring-boot-文档.pdf', 14739596, '2022-02-14', 'pdf', 'https://online-classes.oss-cn-beijing.aliyuncs.com/javakf/spring-boot-%E6%96%87%E6%A1%A3.pdf?Expires=1645452924&OSSAccessKeyId=LTAI5t81U4hLZdzQRnWDawDb&Signature=GG0tn9TXQNjjZ5hPuqtd%2Birvw5k%3D', '韩虎', 1);
INSERT INTO `tb_file` VALUES (2, '尚硅谷_前端技术_Vue全家桶.pdf', 'javakf/尚硅谷_前端技术_Vue全家桶.pdf', 2266901, '2022-02-14', 'pdf', 'https://online-classes.oss-cn-beijing.aliyuncs.com/javakf/%E5%B0%9A%E7%A1%85%E8%B0%B7_%E5%89%8D%E7%AB%AF%E6%8A%80%E6%9C%AF_Vue%E5%85%A8%E5%AE%B6%E6%A1%B6.pdf?Expires=1645453224&OSSAccessKeyId=LTAI5t81U4hLZdzQRnWDawDb&Signature=Aer0%2BfHE6pJqRWBTwR8bP0M9ZXw%3D', '韩虎', 1);
INSERT INTO `tb_file` VALUES (4, '巴黎铁塔.jpg', 'javakf/巴黎铁塔.jpg', 584815, '2022-02-14', 'jpg', 'https://online-classes.oss-cn-beijing.aliyuncs.com/javakf/%E5%B7%B4%E9%BB%8E%E9%93%81%E5%A1%94.jpg?Expires=1645453355&OSSAccessKeyId=LTAI5t81U4hLZdzQRnWDawDb&Signature=kiWgm8eZVxlMMFQ6XVS2CBH4uG8%3D', '韩虎', 1);
INSERT INTO `tb_file` VALUES (5, '测试007.png', 'javakf/测试007.png', 202962, '2022-02-14', 'png', 'https://online-classes.oss-cn-beijing.aliyuncs.com/javakf/%E6%B5%8B%E8%AF%95007.png?Expires=1645454922&OSSAccessKeyId=LTAI5t81U4hLZdzQRnWDawDb&Signature=4U81ogn6ApC%2BhkRllVtp5%2FHP6PM%3D', '韩虎', 1);

-- ----------------------------
-- Table structure for tb_grades
-- ----------------------------
DROP TABLE IF EXISTS `tb_grades`;
CREATE TABLE `tb_grades`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `gradeName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_grades
-- ----------------------------
INSERT INTO `tb_grades` VALUES (1, '1801');
INSERT INTO `tb_grades` VALUES (2, '1802');
INSERT INTO `tb_grades` VALUES (3, '1803');
INSERT INTO `tb_grades` VALUES (4, '1804');
INSERT INTO `tb_grades` VALUES (5, '测试');
INSERT INTO `tb_grades` VALUES (6, '测试2');

-- ----------------------------
-- Table structure for tb_major
-- ----------------------------
DROP TABLE IF EXISTS `tb_major`;
CREATE TABLE `tb_major`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `majorName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_major
-- ----------------------------
INSERT INTO `tb_major` VALUES (1, '计算机科学与技术');
INSERT INTO `tb_major` VALUES (2, '信息安全');
INSERT INTO `tb_major` VALUES (3, '大数据');
INSERT INTO `tb_major` VALUES (4, '人工智能');
INSERT INTO `tb_major` VALUES (6, '测试');

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'path',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `keepAlive` tinyint(1) NULL DEFAULT NULL COMMENT '是否保持激活',
  `requireAuth` tinyint(1) NULL DEFAULT NULL COMMENT '是否要求权限',
  `parentId` int(11) NULL DEFAULT NULL COMMENT '父id',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parentId`(`parentId`) USING BTREE,
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `tb_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES (1, '/', NULL, NULL, '所有', NULL, NULL, NULL, 1);
INSERT INTO `tb_menu` VALUES (2, '/', '/home', 'Home', '学生管理', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (3, '/', '/home', 'Home', '教师管理', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (4, '/', '/home', 'Home', '课程管理', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (5, '/', '/home', 'Home', '成绩管理', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (6, '/', '/home', 'Home', '通知管理', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (7, '/', '/home', 'Home', '系统管理', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (8, '/student/basic/**', '/stu/bas', 'StuBas', '基本信息', NULL, 1, 2, 1);
INSERT INTO `tb_menu` VALUES (9, '/student/other/**', '/stu/oth', 'StuOth', '学生选课', NULL, 1, 2, 1);
INSERT INTO `tb_menu` VALUES (10, '/teacher/basic/**', '/tea/bas', 'TeaBas', '基本信息', NULL, 1, 3, 1);
INSERT INTO `tb_menu` VALUES (11, '/teacher/other/**', '/stu/oth', 'TeaOth', 'xxx', NULL, 1, 3, 1);
INSERT INTO `tb_menu` VALUES (12, '/course/info/**', '/cou/inf', 'CouInf', '课程信息', NULL, 1, 4, 1);
INSERT INTO `tb_menu` VALUES (13, '/course/select/**', '/cou/sel', 'CouSel', '选课信息', NULL, 1, 4, 1);
INSERT INTO `tb_menu` VALUES (14, '/course/other2/**', '/cou/ot2', 'CouOt2', '课程xx', NULL, 1, 4, 1);
INSERT INTO `tb_menu` VALUES (15, '/score/info/**', '/sco/inf', 'ScoInf', '成绩信息', NULL, 1, 5, 1);
INSERT INTO `tb_menu` VALUES (16, '/score/rank/**', '/sco/ran', 'ScoRan', '成绩排名', NULL, 1, 5, 1);
INSERT INTO `tb_menu` VALUES (17, '/score/analyse/**', '/sco/ana', 'ScoAna', '成绩分析', NULL, 1, 5, 1);
INSERT INTO `tb_menu` VALUES (18, '/score/other/**', '/sco/oth', 'ScoOth', '成绩xx', NULL, 1, 5, 1);
INSERT INTO `tb_menu` VALUES (19, '/notice/info/**', '/not/inf', 'NotInf', '通知信息', NULL, 1, 6, 1);
INSERT INTO `tb_menu` VALUES (20, '/notice/other/**', '/not/oth', 'NotOth', '通知xx', NULL, 1, 6, 1);
INSERT INTO `tb_menu` VALUES (21, '/system/grade/**', '/sys/gra', 'SysGra', '班级管理', NULL, 1, 7, 1);
INSERT INTO `tb_menu` VALUES (22, '/system/major/**', '/sys/maj', 'SysMaj', '专业管理', NULL, 1, 7, 1);
INSERT INTO `tb_menu` VALUES (23, '/system/permission/**', '/sys/per', 'SysPer', '权限管理', NULL, 1, 7, 1);
INSERT INTO `tb_menu` VALUES (30, '/', '/home', 'Home', '直播授课', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (31, '/', '/home', 'Home', '我的课程', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (32, '/', '/home', 'Home', '我的同学', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (33, '/', '/home', 'Home', '在线聊天', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (34, '/', '/home', 'Home', '课件管理', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (35, '/', '/home', 'Home', '学校通知', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (36, '/', '/home', 'Home', '疫情专区', NULL, 1, 1, 1);
INSERT INTO `tb_menu` VALUES (37, '/live/course/**', '/live/course', 'LiveCou', '正在上课', NULL, 1, 30, 1);
INSERT INTO `tb_menu` VALUES (38, '/course/my/**', '/course/my', 'MyCourse', '我的选课', NULL, 1, 31, 1);
INSERT INTO `tb_menu` VALUES (39, '/course/table/**', '/course/table', 'MyTable', '课程表', NULL, 1, 31, 1);
INSERT INTO `tb_menu` VALUES (40, '/student/all/**', '/student/all', 'IStuAll', '全部同学', NULL, 1, 32, 1);
INSERT INTO `tb_menu` VALUES (41, '/student/course/**', '/student/cou', 'IStuCou', '课程同学', NULL, 1, 32, 1);
INSERT INTO `tb_menu` VALUES (42, '/friend/chat/**', '/friend/chat', 'FriendChat', '在线聊天', NULL, 1, 33, 1);
INSERT INTO `tb_menu` VALUES (43, '/file/manage/**', '/file/mgr', 'FileMgr', '课程文件', NULL, 1, 34, 1);
INSERT INTO `tb_menu` VALUES (45, '/inotice/info/**', '/Inot/inf', 'INotInf', '通知信息', NULL, 1, 35, 1);
INSERT INTO `tb_menu` VALUES (46, '/covid/info/**', '/covid/inf', 'CovidInf', '疫情信息', NULL, 1, 36, 1);

-- ----------------------------
-- Table structure for tb_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_role`;
CREATE TABLE `tb_menu_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mid` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `rid` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `tb_menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `tb_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `tb_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu_role
-- ----------------------------
INSERT INTO `tb_menu_role` VALUES (1, 8, 1);
INSERT INTO `tb_menu_role` VALUES (2, 9, 1);
INSERT INTO `tb_menu_role` VALUES (3, 10, 1);
INSERT INTO `tb_menu_role` VALUES (4, 11, 1);
INSERT INTO `tb_menu_role` VALUES (5, 12, 1);
INSERT INTO `tb_menu_role` VALUES (6, 13, 1);
INSERT INTO `tb_menu_role` VALUES (7, 14, 1);
INSERT INTO `tb_menu_role` VALUES (8, 15, 1);
INSERT INTO `tb_menu_role` VALUES (9, 16, 1);
INSERT INTO `tb_menu_role` VALUES (10, 17, 1);
INSERT INTO `tb_menu_role` VALUES (11, 18, 1);
INSERT INTO `tb_menu_role` VALUES (12, 19, 1);
INSERT INTO `tb_menu_role` VALUES (13, 20, 1);
INSERT INTO `tb_menu_role` VALUES (14, 21, 1);
INSERT INTO `tb_menu_role` VALUES (15, 22, 1);
INSERT INTO `tb_menu_role` VALUES (16, 23, 1);
INSERT INTO `tb_menu_role` VALUES (35, 37, 5);
INSERT INTO `tb_menu_role` VALUES (36, 38, 5);
INSERT INTO `tb_menu_role` VALUES (37, 39, 5);
INSERT INTO `tb_menu_role` VALUES (38, 40, 5);
INSERT INTO `tb_menu_role` VALUES (39, 41, 5);
INSERT INTO `tb_menu_role` VALUES (40, 42, 5);
INSERT INTO `tb_menu_role` VALUES (45, 43, 5);
INSERT INTO `tb_menu_role` VALUES (46, 45, 5);
INSERT INTO `tb_menu_role` VALUES (48, 46, 5);

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `createDate` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateDate` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知类型（班级or学院）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES (1, '学院召开党史学习教育专题民主会议', '1月19日上午，计算机与信息工程学院召开2021年度党史学习教育专题民主生活会。学院全体班子成员参加。会议由学院党委书记吕冰主持。\r\n\r\n民主生活会前，班子成员围绕会议主题，深入研讨，广泛征求意见，开展谈心谈话，认真撰写个人发言提纲，为开好民主生活会做好充分准备。\r\n\r\n会上，吕冰紧扣会议主题，代表班子重点从五个方面汇报班子工作情况特别是开展党史学习教育情况，通报班子检视问题情况，并带头作个人对照检查。随后班子其他成员联系思想和工作实际，围绕党史学习情况逐一发言，讲收获提高，讲差距不足，开展自我批评和批评。大家聚焦主题，自觉把自己摆进去、把职责摆进去、把工作摆进去，共同过了一次严肃健康的党内政治生活。\r\n\r\n会议最后，吕冰进行总结发言。要求班子进一步团结协作，围绕学院事业高质量发展持续抓好整改落实，进一步推进党史学习教育常态化长效化，把党史学习教育成果转化为实际行动，以优异成绩迎接校庆110周年和党的二十大胜利召开。同时要求班子每位成员针对自身所存在的不足之处，作出整改承诺，一项一项改进提高，限时整改，即知即改，立行立改，抓实整改，抓出成效，确保整改落实到位。', '2022-01-19 15:27:16', '2022-02-15 18:12:04', 'news');
INSERT INTO `tb_notice` VALUES (2, '计算机与信息工程学院课程思政建设方案', '为深入学习贯彻习近平总书记关于教育的重要论述、全国教育大会精神和教育部《高等学校课程思政建设指导纲要》文件精神，全面落实立德树人根本任务，构建全员全过程全方位育人体系，结合学院实际，决定开展课程思政教学改革项目立项建设工作。\r\n\r\n一、指导思想\r\n\r\n以习近平新时代中国特色社会主义思想为指导，坚持社会主义办学方向，紧紧围绕“培养什么人、怎样培养人、为谁培养人”这个根本问题，牢牢把握立德树人这一根本任务，充分发挥课堂教学主渠道作用，按照“所有课程都有育人功能”的要求，深入挖掘各类通识课程、专业课程及各教学环节育人功能，切实做到“各守一段渠、种好责任田”，形成全员、全过程、全方位育人格局，培养德智体美劳全面发展的社会主义建设者和接班人。\r\n\r\n二、建设目标\r\n\r\n紧密结合计算机学科特色，深入发掘课程的思想政治教育资源，将知识、能力、价值塑造有效融合到专业课程中，制定体现课程思政目标和科学评价体系的教学大纲，建立计算机类的专业课程思政教学案例、教学资源库，初步形成一套较为科学有效的课程思政教育教学质量考核评价体系。建成5至10门专业课程思政样板课程，培养2至3个优秀课程思政教学团队，促进专业课程与思想政治理论课同向同行、协同育人。\r\n\r\n三、工作要求\r\n\r\n（一）注重挖掘课程所蕴含的思政元素\r\n\r\n工程技术、实验类专业课程要突出培育学生求真务实、实践创新、精益求精的工匠精神，培养学生踏实严谨、吃苦耐劳、追求卓越等优秀品质，使学生成长为善学习、重实践、勇创新的高素质复合型人才。\r\n\r\n（二）注重明确课程思政的教育重点\r\n\r\n1.加强理想信念教育，教育引导学生树立共产主义远大理想和中国特色社会主义共同理想，立志肩负起民族复兴的时代重任。\r\n\r\n2.加强社会主义核心价值观教育，把社会主义核心价值观渗透到课程教学过程中，弘扬主旋律，传播正能量，在潜移默化中引导学生树立正确的世界观、人生观、价值观。\r\n\r\n3.加强新发展理念教育，把“创新、协调、绿色、开放、共享”的五大发展理念融入课程教学，引导学生树立科学的社会发展观和人生发展观。\r\n\r\n4.加强“三大文化”教育，推动中华优秀传统文化融入课程教学，加强革命文化和社会主义先进文化教育，引导学生厚植爱国主义情怀，传承中华优秀传统文化，弘扬以爱国主义为核心的民族精神和以改革创新为核心的时代精神。\r\n\r\n5.加强专业职业素养教育，把专业职业素养教育同课程教学内容紧密结合起来，加强职业道德、专业伦理、科学精神和工匠精神教育。\r\n\r\n6.加强法治教育，在相关课程中渗透法治教育，增强大学生的法治意识、规则意识、程序意识、平等意识、权利意识、法治思维，坚定大学生的法治信念。\r\n\r\n（三）注重把握课程思政的建设重点\r\n\r\n课程大纲要注重思政教育与专业教育有机衔接和融合，确立课程思政目标。结合课程教学内容，明确思想政治教育切入点和融入点，并体现在学生课程学习评价中。教案、课件要体现课程思政特点，在单元教学设计中明确体现德育元素与内涵。创新教育教学方式方法，将专业课程思政教学目标融入教学设计，融入学生学习任务。以文字、图片、视频等形式汇总课程思政教学改革过程中的典型案例及体现德育成效的材料。\r\n\r\n四、实施方案\r\n\r\n（一）推进实施阶段（2021年12月至2022年2月）\r\n\r\n邀请专家学者深入解读“课程思政”，加深教师对“课程思政”内涵、目标及原则的全面理解，帮助和指导教师结合具体课程挖掘思政元素。结合教研室活动、党支部活动、一流专业和一流课程建设，通过教学观摩、教学研讨、集体备课等方式引导教师全面提升育德意识和育德能力，加强教师课程思政能力。\r\n\r\n（二）重点实施阶段（2022年3月至2022年8月）\r\n\r\n面向全院教师为本科生开设的全部课程（包括专业必修课、专业选修课和校选通识课），遴选立项第一批课程思政示范课程3至6门（各专业负责建设1至2门）。结合一流专业和一流课程建设，采取课程组申报课程思政教学研究项目的方式，给予专项经费支持。\r\n\r\n（三）总结提升阶段（2022年9月至2022年12月）\r\n\r\n全面加强师德师风建设，健全师德师风建设长效机制，引导教师重视以德立身、以德立学、以德施教、以德育德，做“四有”好老师。强化在线课程建设，制作高质量授课微视频。开展优秀课程思政案例库、示范教学课件、典型示范课程评选。培育“课程思政”教学团队，培养课程思政教学名师，不断提升教学团队整体教学能力。\r\n\r\n五、保障措施\r\n\r\n1.学院成立课程思政工作领导小组，统筹推进学院课程思政教育教学改革工作。进一步强化顶层设计、完善制度措施、健全工作机制、明确工作职责，加强协同合作，形成党政齐抓共管，学院教学督导组、教学指导委员会和各系教学组织工作联动，统筹推进“课程思政”的工作格局，确保“课程思政”工作落到实处。\r\n\r\n \r\n\r\n组  长：吕  冰   乔保军\r\n\r\n副组长：曹  堃   阎朝坤\r\n\r\n成  员：柯  杨   葛  强   左宪禹 \r\n\r\n            杜晓玉   李  征   苗  茹\r\n\r\n领导小组负责研究部署学院课程思政建设工作，审定学院课程思政建设工作政策和制度，推动学院课程思政工作方案的落实，研究解决工作中需要解决的重大问题，协调处理工作中遇到的问题。\r\n\r\n2.学院对所有立项项目给予经费支持并参照河南省教育厅课程思政样板课程评价标准组织开展项目监督、结项验收工作。结项验收评价结果为优秀的，在河南省本科高校课程思政项目申报中优先。\r\n\r\n3.聘请学校相关领域专家作为顾问，具体指导课程思政建设，帮助挖掘课程思政案例，提升相关课程的建设水平。', '2022-02-15 15:28:56', '2022-02-15 15:28:58', 'notice');
INSERT INTO `tb_notice` VALUES (3, '测试', 'XXX:\n   开头空两行。\n\n中间空一行。', '2022-02-15 17:47:26', '2022-02-15 20:06:29', NULL);
INSERT INTO `tb_notice` VALUES (8, '关于2022年春季学期开学的通知', '全校各单位：\n\n根据学校工作安排，结合当前疫情防控形势和学校工作实际，为做好开学准备，安排师生安全有序、错峰返校，现将有关事项通知如下。\n\n一、返校时间\n\n（一）开封校区普通全日制本科生及研究生于2月17-20日分批返校报到注册，具体安排如下：\n\n第一批：2月17日，2021级研究生报到注册；\n\n第二批：2月18日，非2021级研究生报到注册；\n\n第三批：2月19日，2021级、2020级本科生报到注册；\n\n第四批：2月20日，2019级、2018级等其他年级本科生报到注册。\n\n（二）郑州校区普通全日制本科生及研究生于2月19-20日分批返校报到注册，具体安排如下：\n\n第一批：2月19日，本科生报到注册；\n\n第二批：2月20日，研究生报到注册。', '2022-02-15 20:05:46', '2022-02-15 20:05:46', NULL);

-- ----------------------------
-- Table structure for tb_post
-- ----------------------------
DROP TABLE IF EXISTS `tb_post`;
CREATE TABLE `tb_post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `creator` bigint(20) NOT NULL,
  `comment_count` int(11) NOT NULL DEFAULT 0,
  `view_count` int(11) NOT NULL DEFAULT 0,
  `like_count` int(11) NOT NULL DEFAULT 0,
  `tag` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_column` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `latest_comment` bigint(20) NOT NULL,
  `post_status` int(11) NOT NULL DEFAULT 0 COMMENT '1加精，2置顶，3精+顶',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 497 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_post
-- ----------------------------
INSERT INTO `tb_post` VALUES (496, '发布新帖测试', '发布新帖内容内容内容内容内容内容内容内容', '2022-03-22 14:00:19', '2022-03-22 14:00:19', 4, 0, 0, 0, 'springboot,springmvc', '公告', 0, 0);

-- ----------------------------
-- Table structure for tb_post_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_post_comment`;
CREATE TABLE `tb_post_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` bigint(20) NOT NULL,
  `like_count` int(11) NOT NULL DEFAULT 0,
  `post_id` bigint(20) NOT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 518 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_post_comment
-- ----------------------------
INSERT INTO `tb_post_comment` VALUES (495, '123123', '2022-03-19 23:39:07', 4, 0, 491, 0);
INSERT INTO `tb_post_comment` VALUES (496, '12', '2022-03-19 23:41:48', 4, 0, 491, 0);
INSERT INTO `tb_post_comment` VALUES (497, '2123', '2022-03-19 23:42:13', 4, 0, 491, 0);
INSERT INTO `tb_post_comment` VALUES (498, '2123', '2022-03-19 23:42:35', 4, 0, 491, 0);
INSERT INTO `tb_post_comment` VALUES (499, '2123', '2022-03-19 23:43:24', 4, 0, 491, 0);
INSERT INTO `tb_post_comment` VALUES (500, '123555', '2022-03-19 23:44:31', 4, 0, 491, 0);
INSERT INTO `tb_post_comment` VALUES (501, '11111', '2022-03-20 00:56:24', 4, 0, 491, 0);
INSERT INTO `tb_post_comment` VALUES (502, '123', '2022-03-20 00:58:52', 4, 0, 493, 0);
INSERT INTO `tb_post_comment` VALUES (503, 'qwe2', '2022-03-20 00:58:55', 4, 0, 493, 0);
INSERT INTO `tb_post_comment` VALUES (504, '评论测试', '2022-03-21 10:32:32', 4, 0, 495, 0);
INSERT INTO `tb_post_comment` VALUES (516, '123', '2022-03-22 15:48:34', 4, 0, 496, 0);
INSERT INTO `tb_post_comment` VALUES (517, '回复@韩虎：阿斯顿', '2022-03-22 15:48:54', 4, 0, 496, 516);

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `nameZh` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, 'ROLE_admin', '系统管理员');
INSERT INTO `tb_role` VALUES (2, 'ROLE_admin_tea', '教师管理员');
INSERT INTO `tb_role` VALUES (3, 'ROLE_admin_stu', '学生管理员');
INSERT INTO `tb_role` VALUES (4, 'ROLE_teacher', '教师');
INSERT INTO `tb_role` VALUES (5, 'ROLE_student', '学生');

-- ----------------------------
-- Table structure for tb_students
-- ----------------------------
DROP TABLE IF EXISTS `tb_students`;
CREATE TABLE `tb_students`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` int(11) NOT NULL COMMENT '学号',
  `password` int(11) NOT NULL COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `isInSchool` tinyint(1) NULL DEFAULT 1 COMMENT '是否在校',
  `userFace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `isStudent` tinyint(1) NULL DEFAULT 1 COMMENT '是否是学生',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否锁定',
  `enrollmentTime` date NULL DEFAULT NULL COMMENT '入学时间',
  `majorId` int(11) NULL DEFAULT NULL COMMENT '专业ID',
  `gradeId` int(11) NULL DEFAULT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tb_students_ibfk_2`(`gradeId`) USING BTREE,
  INDEX `tb_students_ibfk_3`(`majorId`) USING BTREE,
  CONSTRAINT `tb_students_ibfk_2` FOREIGN KEY (`gradeId`) REFERENCES `tb_grades` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_students_ibfk_3` FOREIGN KEY (`majorId`) REFERENCES `tb_major` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_students
-- ----------------------------
INSERT INTO `tb_students` VALUES (1, 1812030001, 123456, '学生甲', '男', '2000-07-13', '410122200007130321', '13265412365', '河南省郑州市中牟县', '13256412562@163.com', 1, NULL, 1, 1, '2108-09-01', 1, 1);
INSERT INTO `tb_students` VALUES (2, 1812030036, 123456, '韩虎', '男', '1998-11-19', '410122199811197419', '13253347105', '河南省郑州市中牟县', '13253347105@163.com', 1, NULL, 1, 1, '2018-09-01', 1, 2);
INSERT INTO `tb_students` VALUES (3, 1812030002, 123456, '张三', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (4, 1812030003, 123456, '李四', '女', '1999-11-20', '410122199811197416', '13253347105', '河北省xx市xx县', '132533417500@163.com', 1, NULL, 1, 1, '2018-09-01', 2, 1);
INSERT INTO `tb_students` VALUES (5, 1812030004, 123456, '王五', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 3, 1);
INSERT INTO `tb_students` VALUES (6, 1812030005, 123456, '刘六', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (7, 1812030006, 123456, '阿泽', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 0, NULL, 1, 1, '2018-10-16', 2, 3);
INSERT INTO `tb_students` VALUES (8, 1812030007, 123456, '狗焕', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省xx市xx县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (9, 1812030008, 123456, '德善', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (10, 1812030009, 123456, '贾哦跑', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 0, NULL, 1, 1, '2018-10-16', 2, 4);
INSERT INTO `tb_students` VALUES (11, 1812030010, 123456, '张东健', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (12, 1812030011, 123456, '姚冬季', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 3);
INSERT INTO `tb_students` VALUES (13, 1812030012, 123456, '周杰伦', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (14, 1812030013, 123456, '朱亚文', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (15, 1812030014, 123456, '周迅', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 4);
INSERT INTO `tb_students` VALUES (16, 1812030015, 123456, '夕设计', '男', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);
INSERT INTO `tb_students` VALUES (17, 1812030016, 123456, '德哈卡', '女', '1999-11-20', '410122199811197416', '13253347105', '河南省郑州市中牟县', '132533417500@163.com', 1, NULL, 1, 1, '2018-10-16', 2, 1);

-- ----------------------------
-- Table structure for tb_todo
-- ----------------------------
DROP TABLE IF EXISTS `tb_todo`;
CREATE TABLE `tb_todo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `isfinished` tinyint(1) NULL DEFAULT 0 COMMENT '是否完成',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tb_todo_ibfk_1`(`adminId`) USING BTREE,
  CONSTRAINT `tb_todo_ibfk_1` FOREIGN KEY (`adminId`) REFERENCES `tb_admin` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_todo
-- ----------------------------
INSERT INTO `tb_todo` VALUES (1, '买水果', 0, 3);
INSERT INTO `tb_todo` VALUES (2, '写作业', 0, 3);
INSERT INTO `tb_todo` VALUES (3, '取快递', 0, 4);

-- ----------------------------
-- Table structure for tb_user_courses
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_courses`;
CREATE TABLE `tb_user_courses`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `courseId` int(11) NULL DEFAULT NULL COMMENT '课程 ID',
  `score` int(11) NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tb_user_course_ibfk_1`(`adminId`) USING BTREE,
  INDEX `tb_user_course_ibfk_2`(`courseId`) USING BTREE,
  CONSTRAINT `tb_user_course_ibfk_1` FOREIGN KEY (`adminId`) REFERENCES `tb_admin` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tb_user_course_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `tb_courses` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_courses
-- ----------------------------
INSERT INTO `tb_user_courses` VALUES (3, 3, 4, NULL);
INSERT INTO `tb_user_courses` VALUES (4, 3, 5, NULL);
INSERT INTO `tb_user_courses` VALUES (5, 3, 6, NULL);
INSERT INTO `tb_user_courses` VALUES (6, 3, 7, NULL);
INSERT INTO `tb_user_courses` VALUES (7, 3, 8, NULL);
INSERT INTO `tb_user_courses` VALUES (8, 3, 9, NULL);
INSERT INTO `tb_user_courses` VALUES (9, 3, 10, NULL);
INSERT INTO `tb_user_courses` VALUES (10, 4, 4, NULL);
INSERT INTO `tb_user_courses` VALUES (11, 4, 5, NULL);
INSERT INTO `tb_user_courses` VALUES (12, 4, 6, NULL);
INSERT INTO `tb_user_courses` VALUES (13, 4, 7, NULL);
INSERT INTO `tb_user_courses` VALUES (14, 4, 8, NULL);
INSERT INTO `tb_user_courses` VALUES (15, 4, 9, NULL);
INSERT INTO `tb_user_courses` VALUES (16, 3, 18, NULL);
INSERT INTO `tb_user_courses` VALUES (17, 4, 18, NULL);
INSERT INTO `tb_user_courses` VALUES (18, 2, 4, NULL);
INSERT INTO `tb_user_courses` VALUES (19, 5, 4, NULL);
INSERT INTO `tb_user_courses` VALUES (20, 6, 4, NULL);

SET FOREIGN_KEY_CHECKS = 1;
