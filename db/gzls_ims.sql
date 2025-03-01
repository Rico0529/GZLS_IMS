/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44-log)
 Source Host           : localhost:3306
 Source Schema         : gzls_ims

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44-log)
 File Encoding         : 65001

 Date: 02/03/2025 00:27:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aboutus
-- ----------------------------
DROP TABLE IF EXISTS `aboutus`;
CREATE TABLE `aboutus`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `subtitle` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '副标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `picture1` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片1',
  `picture2` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片2',
  `picture3` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '关于我们' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aboutus
-- ----------------------------
INSERT INTO `aboutus` VALUES (1, '2025-01-21 11:30:41', '关于我们', 'ABOUT US', '<p>嗨嗨嗨！这是一个基于SpringBoot的广州市劳动与社会保障信息管理系统的设计与实现</p>', 'upload/1740675260889.jpeg', 'upload/1740675263971.jpeg', 'upload/1740675268378.jpeg');

-- ----------------------------
-- Table structure for butiefafang
-- ----------------------------
DROP TABLE IF EXISTS `butiefafang`;
CREATE TABLE `butiefafang`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `butiemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '补贴名称',
  `butiefengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '补贴封面',
  `butiejine` double NULL DEFAULT NULL COMMENT '补贴金额',
  `fafangshijian` date NULL DEFAULT NULL COMMENT '发放时间',
  `fafangneirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '发放内容',
  `fafangxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '发放详情',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '补贴发放' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of butiefafang
-- ----------------------------
INSERT INTO `butiefafang` VALUES (1, '2025-01-21 11:30:40', '补贴名称1', 'upload/1740844158604.jpeg', 10000, '2025-01-30', '发放内容1', '<p>发放详情1</p>', 'aa', '小A');

-- ----------------------------
-- Table structure for butieshenqing
-- ----------------------------
DROP TABLE IF EXISTS `butieshenqing`;
CREATE TABLE `butieshenqing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `xiangmufengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '项目封面',
  `xiangmuziliao` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '项目资料',
  `shenqingzijin` double NULL DEFAULT NULL COMMENT '申请资金',
  `shenqingshijian` date NULL DEFAULT NULL COMMENT '申请时间',
  `shenqingneirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '申请内容',
  `shenqingxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '申请详情',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `fuzerenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '审核回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '补贴申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of butieshenqing
-- ----------------------------
INSERT INTO `butieshenqing` VALUES (9, '2025-02-28 00:40:08', '项目1', 'upload/1740674385534.jpeg', '', 2500, '2025-02-28', '不晓得', '<p>不清楚</p>', 'q1', '小A', '待审核', '');

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `adminid` bigint(20) NULL DEFAULT NULL COMMENT '管理员id',
  `ask` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '提问',
  `reply` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复',
  `isreply` int(11) NULL DEFAULT NULL COMMENT '是否回复',
  `isread` int(11) NULL DEFAULT 0 COMMENT '已读/未读(1:已读,0:未读)',
  `uname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `uimage` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '用户名',
  `type` int(11) NULL DEFAULT 1 COMMENT '内容类型(1:文本,2:图片,3:视频,4:文件,5:表情)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '客服中心' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES (27, '2025-03-01 17:27:36', 1740673709531, NULL, '😍', NULL, 0, 1, 'aaa', 'upload/1740673699419.jpg', 1);
INSERT INTO `chat` VALUES (28, '2025-03-01 17:27:40', 1740673709531, NULL, '🤩', NULL, 0, 1, 'aaa', 'upload/1740673699419.jpg', 1);
INSERT INTO `chat` VALUES (29, '2025-03-01 17:27:44', 1740673709531, NULL, '🤪', NULL, 0, 1, 'aaa', 'upload/1740673699419.jpg', 1);
INSERT INTO `chat` VALUES (30, '2025-03-01 17:54:29', 1740673709531, 1, NULL, '😘', 0, 1, 'admin', 'upload/1740673537364.jpeg', 1);
INSERT INTO `chat` VALUES (31, '2025-03-01 21:49:53', 1740673709531, NULL, '🤪', NULL, 1, 1, 'aaa', 'upload/1740673699419.jpg', 1);
INSERT INTO `chat` VALUES (32, '2025-03-01 22:57:45', 1740674736566, NULL, '😣', NULL, 0, 1, 'ccc', 'upload/1740674725539.jpeg', 1);
INSERT INTO `chat` VALUES (33, '2025-03-01 23:05:10', 1740674736566, NULL, '😎', NULL, 0, 1, 'ccc', 'upload/1740674725539.jpeg', 1);
INSERT INTO `chat` VALUES (35, '2025-03-01 23:09:37', 1740674736566, NULL, '😜', NULL, 0, 1, 'ccc', 'upload/1740674725539.jpeg', 1);
INSERT INTO `chat` VALUES (36, '2025-03-01 23:10:40', 1740674736566, NULL, '😜', NULL, 0, 1, 'ccc', 'upload/1740674725539.jpeg', 1);
INSERT INTO `chat` VALUES (37, '2025-03-01 23:11:12', 1740674736566, 1, NULL, '😛', 0, 1, 'admin', 'upload/1740673537364.jpeg', 1);
INSERT INTO `chat` VALUES (38, '2025-03-01 23:27:21', 1740674736566, NULL, '111', NULL, 0, 1, 'ccc', 'upload/1740674725539.jpeg', 1);
INSERT INTO `chat` VALUES (39, '2025-03-01 23:27:52', 1740674736566, 1, NULL, 'upload/1740842872618.png', 0, 1, 'admin', 'upload/1740673537364.jpeg', 2);
INSERT INTO `chat` VALUES (40, '2025-03-01 23:28:40', 1740674736566, NULL, '😍', NULL, 0, 1, 'ccc', 'upload/1740674725539.jpeg', 1);
INSERT INTO `chat` VALUES (41, '2025-03-01 23:34:25', 1740674736566, NULL, '还要😍', NULL, 0, 1, 'ccc', 'upload/1740674725539.jpeg', 1);
INSERT INTO `chat` VALUES (42, '2025-03-01 23:35:54', 1740674736566, 1, NULL, 'upload/1740843354024.jpeg', NULL, 1, 'admin', 'upload/1740673537364.jpeg', 2);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/1740674562543.jpeg', NULL);
INSERT INTO `config` VALUES (2, 'picture2', 'upload/1740674552627.jpeg', NULL);
INSERT INTO `config` VALUES (3, 'picture3', 'upload/1740674541245.jpeg', NULL);

-- ----------------------------
-- Table structure for fafangbutie
-- ----------------------------
DROP TABLE IF EXISTS `fafangbutie`;
CREATE TABLE `fafangbutie`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `xiangmufengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '项目封面',
  `fafangzijin` double NULL DEFAULT NULL COMMENT '发放资金',
  `fafangshijian` date NULL DEFAULT NULL COMMENT '发放时间',
  `fafangneirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '发放内容',
  `fafangxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '发放详情',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `fuzerenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '发放补贴' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fafangbutie
-- ----------------------------
INSERT INTO `fafangbutie` VALUES (1, '2025-01-21 11:30:41', '项目名称1', 'upload/1740675096125.jpeg', 2500, '2025-01-31', '发放内容1', '<p>发放详情1</p>', 'q1', '小A');

-- ----------------------------
-- Table structure for laodongbaozhang
-- ----------------------------
DROP TABLE IF EXISTS `laodongbaozhang`;
CREATE TABLE `laodongbaozhang`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '封面',
  `zuixinzhengce` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '最新政策',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `baozhangneirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '保障内容',
  `baozhangxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '保障详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '劳动保障' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laodongbaozhang
-- ----------------------------
INSERT INTO `laodongbaozhang` VALUES (9, '2025-02-28 00:34:16', '新劳动法', 'upload/1740674028812.jpg', '', '2025-02-28', '你猜', '<p>你再猜</p>');
INSERT INTO `laodongbaozhang` VALUES (10, '2025-03-01 23:47:23', '新政策', 'upload/1740844014858.png', '', '2025-03-01', '新政策', '<p>不知道</p>');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '简介',
  `typename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分类名称',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布人',
  `headportrait` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '头像',
  `clicknum` int(11) NULL DEFAULT 0 COMMENT '点击次数',
  `clicktime` datetime NULL DEFAULT NULL COMMENT '最近点击时间',
  `thumbsupnum` int(11) NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int(11) NULL DEFAULT 0 COMMENT '踩',
  `storeupnum` int(11) NULL DEFAULT 0 COMMENT '收藏数',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '社保公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (8, '2025-01-21 11:30:41', '这是公告一', '这是简介一', '分类名称1', '小Z', 'upload/news_headportrait8.jpg', 18, '2025-03-01 23:55:49', 8, 8, 8, 'upload/1740844364994.jpeg', '<p>嗨嗨嗨</p><p><strong>嘿嘿嘿</strong></p>');
INSERT INTO `news` VALUES (9, '2025-03-01 17:58:17', '这是公告2', '这是简介2', '分类名称2', '小M', '', 3, '2025-03-01 23:43:14', 0, 0, 0, 'upload/1740823076352.jpeg', '<p>想不到！！！</p>');
INSERT INTO `news` VALUES (10, '2025-03-01 17:59:10', '这是公告3', '这是简介3', '分类名称1', '小Q', '', 2, '2025-03-01 18:00:05', 0, 0, 0, 'upload/1740823128446.jpeg', '<p>还是想不到！</p>');

-- ----------------------------
-- Table structure for newstype
-- ----------------------------
DROP TABLE IF EXISTS `newstype`;
CREATE TABLE `newstype`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `typename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '社保公告分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newstype
-- ----------------------------
INSERT INTO `newstype` VALUES (1, '2025-01-21 11:30:41', '分类名称1');
INSERT INTO `newstype` VALUES (2, '2025-01-21 11:30:41', '分类名称2');

-- ----------------------------
-- Table structure for popupremind
-- ----------------------------
DROP TABLE IF EXISTS `popupremind`;
CREATE TABLE `popupremind`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '发布人id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '个人' COMMENT '类型',
  `brief` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '简介',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `remindtime` datetime NULL DEFAULT NULL COMMENT '提醒时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '弹窗提醒' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of popupremind
-- ----------------------------
INSERT INTO `popupremind` VALUES (9, '2025-02-28 00:53:20', 1, '提醒1', '全局', '一个提醒1', '<p>一个提醒1</p>', '2025-02-28 01:00:00');
INSERT INTO `popupremind` VALUES (10, '2025-03-01 17:54:07', 1, '一个提醒2', '全局', '嘿嘿', '<p>嗨嗨嗨</p>', '2025-03-01 17:55:39');

-- ----------------------------
-- Table structure for qiye
-- ----------------------------
DROP TABLE IF EXISTS `qiye`;
CREATE TABLE `qiye`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '企业账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `fuzerenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '负责人姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `touxiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '头像',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `qiyezizhi` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '企业资质',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '审核回复',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `qiyezhanghao`(`qiyezhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1740822281356 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '企业' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qiye
-- ----------------------------
INSERT INTO `qiye` VALUES (1740673882008, '2025-02-28 00:31:22', 'q1', 'ED5wLgc3Mnw=', '小A', '男', 'upload/1740673863666.jpeg', '13012340003', 'upload/1740673880462.jpeg', '是', 'aaa');
INSERT INTO `qiye` VALUES (1740673956671, '2025-02-28 00:32:36', 'q2', 'ED5wLgc3Mnw=', '小Q', '女', 'upload/1740673944819.jpeg', '13012340004', 'upload/1740673955188.jpeg', '是', '嘿嘿');
INSERT INTO `qiye` VALUES (1740822281355, '2025-03-01 17:44:41', 'q3', 'ED5wLgc3Mnw=', '小W', '男', 'upload/1740822263649.jpeg', '13012340006', 'upload/1740822279521.jpeg', '待审核', '');

-- ----------------------------
-- Table structure for shebaojiaofei
-- ----------------------------
DROP TABLE IF EXISTS `shebaojiaofei`;
CREATE TABLE `shebaojiaofei`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `shebaoleixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '社保类型',
  `shebaotupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '社保图片',
  `shebaojiage` double NULL DEFAULT NULL COMMENT '社保价格',
  `jiaofeiriqi` date NULL DEFAULT NULL COMMENT '缴费日期',
  `jiaofeixiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '缴费详情',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `fuzerenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `ispay` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '社保缴费' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shebaojiaofei
-- ----------------------------
INSERT INTO `shebaojiaofei` VALUES (1, '2025-01-21 11:30:40', 'aa', '小A', '社保类型1', 'upload/1740674848071.jpeg', 25, '2025-01-30', '<p>缴费详情1</p>', 'q1', '小A', '未支付');
INSERT INTO `shebaojiaofei` VALUES (9, '2025-03-01 17:52:19', 'bb', '小B', '合作医疗', 'upload/1740822345282.png', 2500, '2025-03-01', '<p>111</p>', 'q2', '小Q', '未支付');

-- ----------------------------
-- Table structure for shebaoxinxi
-- ----------------------------
DROP TABLE IF EXISTS `shebaoxinxi`;
CREATE TABLE `shebaoxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shebaobianhao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '社保编号',
  `shebaoleixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '社保类型',
  `shebaotupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '社保图片',
  `shebaojiage` double NULL DEFAULT NULL COMMENT '社保价格',
  `shebaowenjian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '社保文件',
  `shebaozhuangtai` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '社保状态',
  `dengjiriqi` date NULL DEFAULT NULL COMMENT '登记日期',
  `shebaobeizhu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '社保备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `shebaobianhao`(`shebaobianhao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '社保信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shebaoxinxi
-- ----------------------------
INSERT INTO `shebaoxinxi` VALUES (1, '2025-01-21 11:30:40', '1111111111', '养老保险', 'upload/1740674782282.jpeg', 25, '', '未缴费', '2025-01-30', '<p>社保备注1</p>');
INSERT INTO `shebaoxinxi` VALUES (9, '2025-03-01 17:46:04', '1740822328338', '合作医疗', 'upload/1740822345282.png', 2500, '', '已缴费', '2025-03-01', '<p>111</p>');
INSERT INTO `shebaoxinxi` VALUES (10, '2025-03-01 17:46:31', '1740822372433', '其他社会保障', 'upload/1740822380598.jpeg', 250, '', '未缴费', '2025-03-01', '<p>222</p>');

-- ----------------------------
-- Table structure for shenqingbutie
-- ----------------------------
DROP TABLE IF EXISTS `shenqingbutie`;
CREATE TABLE `shenqingbutie`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `butiemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '补贴名称',
  `butiefengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '补贴封面',
  `butieziliao` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '补贴资料',
  `butiejine` double NULL DEFAULT NULL COMMENT '补贴金额',
  `shenqingzhuangtai` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请状态',
  `shenqingshijian` date NULL DEFAULT NULL COMMENT '申请时间',
  `shenqingneirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '申请内容',
  `shenqingxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '申请详情',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '申请补贴' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shenqingbutie
-- ----------------------------
INSERT INTO `shenqingbutie` VALUES (1, '2025-01-21 11:30:40', '补贴名称1', 'upload/1740675009303.jpeg', '', 25, '已通过', '2025-01-30', '申请内容1', '<p>申请详情1</p>', 'aa', '小A');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片',
  `type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storeup
-- ----------------------------
INSERT INTO `storeup` VALUES (1, '2025-02-28 01:00:04', 1, 9, 'popupremind', '提醒1', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (2, '2025-02-28 01:00:11', 1740673709531, 9, 'popupremind', '提醒1', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (3, '2025-02-28 01:04:05', 1740673882008, 9, 'popupremind', '提醒1', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (4, '2025-03-01 03:05:14', 1740673793308, 9, 'popupremind', '提醒1', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (5, '2025-03-01 16:51:14', 1740674736566, 9, 'popupremind', '提醒1', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (6, '2025-03-01 17:48:12', 1740673956671, 9, 'popupremind', '提醒1', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (7, '2025-03-01 17:55:46', 1740673956671, 10, 'popupremind', '一个提醒2', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (8, '2025-03-01 17:55:47', 1740673793308, 10, 'popupremind', '一个提醒2', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (9, '2025-03-01 21:49:36', 1740673709531, 10, 'popupremind', '一个提醒2', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (10, '2025-03-01 22:57:30', 1740674736566, 10, 'popupremind', '一个提醒2', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (11, '2025-03-01 23:55:34', 1740844433414, 9, 'popupremind', '提醒1', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (12, '2025-03-01 23:55:34', 1740844433414, 10, 'popupremind', '一个提醒2', NULL, '61', NULL, NULL);

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `operation` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '请求参数',
  `time` bigint(20) NULL DEFAULT NULL COMMENT '请求时长(毫秒)',
  `ip` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of syslog
-- ----------------------------
INSERT INTO `syslog` VALUES (110, '2025-03-01 23:52:16', 'admin', '删除系统日志', 'com.controller.SyslogController.delete()', '[109]', 8, '0:0:0:0:0:0:0:1');
INSERT INTO `syslog` VALUES (111, '2025-03-01 23:53:53', 'admin', '新增用户', 'com.controller.YonghuController.save()', '{\"id\":1740844433414,\"yonghuzhanghao\":\"dd\",\"mima\":\"ED5wLgc3Mnw\\u003d\",\"yonghuxingming\":\"小D\",\"xingbie\":\"女\",\"touxiang\":\"upload/1740844417675.jpeg\",\"lianxifangshi\":\"13012340007\",\"nianling\":66}', 5, '0:0:0:0:0:0:0:1');
INSERT INTO `syslog` VALUES (112, '2025-03-01 23:55:34', 'dd', '新增收藏表', 'com.controller.StoreupController.add()', '{\"id\":11,\"userid\":1740844433414,\"refid\":9,\"tablename\":\"popupremind\",\"name\":\"提醒1\",\"type\":\"61\"}', 4, '0:0:0:0:0:0:0:1');
INSERT INTO `syslog` VALUES (113, '2025-03-01 23:55:34', 'dd', '新增收藏表', 'com.controller.StoreupController.add()', '{\"id\":12,\"userid\":1740844433414,\"refid\":10,\"tablename\":\"popupremind\",\"name\":\"一个提醒2\",\"type\":\"61\"}', 2, '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for systemintro
-- ----------------------------
DROP TABLE IF EXISTS `systemintro`;
CREATE TABLE `systemintro`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `subtitle` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '副标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `picture1` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片1',
  `picture2` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片2',
  `picture3` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统简介' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of systemintro
-- ----------------------------
INSERT INTO `systemintro` VALUES (1, '2025-01-21 11:30:41', '系统简介', 'SYSTEM INTRODUCTION', '<p>这是一个基于SpringBoot的广州市劳动与社会保障信息管理系统的设计与实现</p>', 'upload/1740675290632.jpeg', 'upload/1740675296384.jpeg', 'upload/1740675303751.jpeg');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'admin', 'users', '管理员', '1v348ls1uottz6axjgifwo7effgiam3g', '2025-02-28 00:25:13', '2025-03-02 00:41:28');
INSERT INTO `token` VALUES (2, 1740673709531, 'aa', 'yonghu', '用户', 'ewaigeym5jheip570h1rgzyn29evy7no', '2025-02-28 00:35:17', '2025-03-01 22:49:37');
INSERT INTO `token` VALUES (3, 1740673882008, 'q1', 'qiye', '企业', 'aak8d6f8sr3stk4ngcpup6tc7lqhgv3g', '2025-02-28 00:37:29', '2025-03-01 18:42:27');
INSERT INTO `token` VALUES (4, 1740673793308, 'bb', 'yonghu', '用户', '9dwko8udbx9jvcye3tyu3962zxmf9vgv', '2025-03-01 03:05:14', '2025-03-02 00:42:45');
INSERT INTO `token` VALUES (5, 1740674736566, 'cc', 'yonghu', '用户', 'erjuq4os28iu0l1x8rxae2py39ay2h44', '2025-03-01 16:51:13', '2025-03-02 00:09:23');
INSERT INTO `token` VALUES (6, 1740673956671, 'q2', 'qiye', '企业', 'h1u9cilnn35zpbwg2z56ajf4o5cl60uv', '2025-03-01 17:48:12', '2025-03-01 18:51:19');
INSERT INTO `token` VALUES (7, 1740844433414, 'dd', 'yonghu', '用户', '4nhevym6unssmtyjb6g1wt3546bnnlwq', '2025-03-01 23:55:34', '2025-03-02 00:55:34');

-- ----------------------------
-- Table structure for toudijianli
-- ----------------------------
DROP TABLE IF EXISTS `toudijianli`;
CREATE TABLE `toudijianli`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhaopinmingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招聘名称',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '封面',
  `jinengyaoqiu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '技能要求',
  `gangweixinzi` double NULL DEFAULT NULL COMMENT '岗位薪资',
  `zhaopingangwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '应聘岗位',
  `gongzuodidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作地点',
  `toudishijian` date NULL DEFAULT NULL COMMENT '投递时间',
  `toudixiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '投递详情',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `fuzerenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '投递简历' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toudijianli
-- ----------------------------
INSERT INTO `toudijianli` VALUES (9, '2025-02-28 00:40:55', '练习生', 'upload/1740674290648.jpeg', '唱、跳、lap', 2.5, '个人练习生', '鸽鸽家', '2025-02-28', '<p>我我我！</p>', 'q1', '小A', 'aaa', '小Z');
INSERT INTO `toudijianli` VALUES (10, '2025-03-01 17:50:59', '专招牛马', 'upload/1740822557651.jpeg', '牛马会的', 0, '牛马', '牛马栏', NULL, '<p>我是牛马</p>', 'q2', '小Q', 'bbb', '小M');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', 'upload/1740673537364.jpeg', '管理员', '2025-01-21 11:30:41');

-- ----------------------------
-- Table structure for yewuyuyue
-- ----------------------------
DROP TABLE IF EXISTS `yewuyuyue`;
CREATE TABLE `yewuyuyue`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '封面',
  `banlishijian` datetime NULL DEFAULT NULL COMMENT '办理时间',
  `banlididian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '办理地点',
  `yuyueshijian` datetime NULL DEFAULT NULL COMMENT '预约时间',
  `yuyueneirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '预约内容',
  `yuyuexiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '预约详情',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '业务预约' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yewuyuyue
-- ----------------------------
INSERT INTO `yewuyuyue` VALUES (9, '2025-02-28 00:57:01', '新劳动法', 'upload/1740674028812.jpg', '2025-02-28 00:00:00', '鸽鸽家', '2025-03-01 00:00:00', '嘿嘿', '<p>嗨嗨嗨</p>', 'aaa', '小Z');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `touxiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '头像',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `nianling` int(11) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yonghuzhanghao`(`yonghuzhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1740844433415 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (1740673709531, '2025-02-28 00:28:29', 'aa', 'ED5wLgc3Mnw=', '小A', '男', 'upload/1740673699419.jpg', '13012340001', 21);
INSERT INTO `yonghu` VALUES (1740673793308, '2025-02-28 00:29:53', 'bb', 'ED5wLgc3Mnw=', '小B', '女', 'upload/1740673783757.jpeg', '13012340002', 18);
INSERT INTO `yonghu` VALUES (1740674736566, '2025-02-28 00:45:36', 'cc', 'ED5wLgc3Mnw=', '小C', '女', 'upload/1740674725539.jpeg', '13012340005', 19);
INSERT INTO `yonghu` VALUES (1740844433414, '2025-03-01 23:53:53', 'dd', 'ED5wLgc3Mnw=', '小D', '女', 'upload/1740844417675.jpeg', '13012340007', 66);

-- ----------------------------
-- Table structure for zhaopinxinxi
-- ----------------------------
DROP TABLE IF EXISTS `zhaopinxinxi`;
CREATE TABLE `zhaopinxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhaopinmingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招聘名称',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '封面',
  `jinengyaoqiu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '技能要求',
  `gangweixinzi` double NULL DEFAULT NULL COMMENT '岗位薪资',
  `zhaopingangwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招聘岗位',
  `zhaopinrenshu` int(11) NULL DEFAULT NULL COMMENT '招聘人数',
  `gongzuodidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作地点',
  `zhaopinshijian` date NULL DEFAULT NULL COMMENT '招聘时间',
  `zhaopinxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '招聘详情',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `fuzerenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '招聘信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhaopinxinxi
-- ----------------------------
INSERT INTO `zhaopinxinxi` VALUES (9, '2025-02-28 00:39:19', '练习生', 'upload/1740674290648.jpeg', '唱、跳、lap', 2.5, '个人练习生', 25, '鸽鸽家', '2025-02-28', '<p>请加入我们吧！</p>', 'q1', '小A');
INSERT INTO `zhaopinxinxi` VALUES (10, '2025-03-01 17:50:14', '专招牛马', 'upload/1740822557651.jpeg', '牛马会的', 0, '牛马', 100, '牛马栏', '2025-03-01', '<p>牛马们快来吧！</p>', 'q2', '小Q');

SET FOREIGN_KEY_CHECKS = 1;
