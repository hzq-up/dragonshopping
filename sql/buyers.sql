/*
 Navicat Premium Data Transfer

 Source Server         : localhost1
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : buyers

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 02/12/2019 23:37:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comments_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `comments_centent` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论的内容',
  `comments_user_id` int(255) DEFAULT NULL COMMENT '评论的用户id',
  `comments_produce_id` int(255) DEFAULT NULL COMMENT '评论的商品id',
  `comments_stars` int(11) DEFAULT NULL COMMENT '评论的星级',
  `comments_date` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '评论的时间',
  PRIMARY KEY (`comments_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '真的好看', 1, 1, 2, '2019-09-04 00:00:00');
INSERT INTO `comment` VALUES (2, '内容精彩', 2, 2, 5, '2019-09-15 00:00:00');
INSERT INTO `comment` VALUES (3, '内容精彩', 2, 2, 2, '2019-09-04 00:00:00');
INSERT INTO `comment` VALUES (4, '还可以吧就是有点少', NULL, 2, 1, '2019-09-04 00:00:00');
INSERT INTO `comment` VALUES (7, '好看', 1, 1, 2, '2019-09-30 12:58:01');
INSERT INTO `comment` VALUES (8, '士大夫', 1, 6, 0, '2019-09-30 14:21:07');
INSERT INTO `comment` VALUES (19, 'dsafsdaf', 1, 6, 0, '2019-09-30 14:26:09');
INSERT INTO `comment` VALUES (20, 'sdafsd', 1, 6, 4, '2019-09-30 14:26:48');
INSERT INTO `comment` VALUES (21, 'fadsfasd', 1, 6, 5, '2019-09-30 14:27:59');
INSERT INTO `comment` VALUES (22, '发生法撒旦', 2, 3, 3, '2019-09-30 15:10:18');
INSERT INTO `comment` VALUES (23, '大事发生的', 2, 6, 3, '2019-09-30 15:52:34');
INSERT INTO `comment` VALUES (24, 'asdf', 2, 6, 2, '2019-09-30 15:53:39');
INSERT INTO `comment` VALUES (25, '防守打法', 2, 6, 3, '2019-09-30 15:54:49');
INSERT INTO `comment` VALUES (40, '很好看！！！！！！！！！！！！！', 2, 1, 4, '2019-10-16 16:26:02');
INSERT INTO `comment` VALUES (41, '第三方', 2, 3, 4, '2019-10-18 22:11:19');
INSERT INTO `comment` VALUES (42, '受益匪浅呀', 2, 4, 5, '2019-10-21 22:02:14');
INSERT INTO `comment` VALUES (43, '1111', 2, 2, 5, '2019-10-29 10:59:34');
INSERT INTO `comment` VALUES (44, 'admin来过', 2, 7, 5, '2019-10-31 21:35:01');
INSERT INTO `comment` VALUES (45, '真好看！', 2, 1, 5, '2019-11-02 16:36:35');
INSERT INTO `comment` VALUES (46, '还行吧？', 2, 2, 5, '2019-11-02 23:45:28');
INSERT INTO `comment` VALUES (47, '还行！', 2, 1, 5, '2019-11-04 10:27:40');
INSERT INTO `comment` VALUES (48, 'qqq', 2, 2, 5, '2019-11-04 16:07:51');
INSERT INTO `comment` VALUES (49, '田茂林真帅', 2, 2, 5, '2019-11-04 23:08:43');
INSERT INTO `comment` VALUES (50, '23.45', 2, 1, 5, '2019-11-04 23:45:52');
INSERT INTO `comment` VALUES (51, '现在是0：03', 2, 1, 5, '2019-11-05 00:03:39');

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `produce_id` int(11) DEFAULT NULL COMMENT '商品id',
  `pay_state` int(11) DEFAULT 0 COMMENT '支付状态（1已支付，0未支付）',
  `pay_way` int(11) DEFAULT NULL COMMENT '支付方式（1微信，2支付宝）',
  `order_num` int(11) DEFAULT NULL COMMENT '订单号',
  `pay_time` datetime(0) DEFAULT NULL COMMENT '支付时间',
  `order_details_total_price` decimal(10, 2) DEFAULT NULL COMMENT '订单总价',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int(11) DEFAULT NULL COMMENT '订单用户id',
  `produce_id` int(11) DEFAULT NULL COMMENT '订单商品id',
  `quantity` int(11) DEFAULT NULL COMMENT '订单数量',
  `total_price` decimal(10, 2) DEFAULT NULL COMMENT '总订单总价',
  `create_time` datetime(0) DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '订单更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for produce_sell
-- ----------------------------
DROP TABLE IF EXISTS `produce_sell`;
CREATE TABLE `produce_sell`  (
  `produce_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品详情id',
  `produce_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名字',
  `produce_explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品说明',
  `produce_produce_sortnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品种类编号',
  `produce_count` int(11) DEFAULT NULL COMMENT '商品库存数量',
  `produce_price` decimal(10, 2) DEFAULT NULL COMMENT '商品实际销售价格',
  `produce_shop_price` decimal(10, 2) DEFAULT NULL COMMENT '商品原销售价格',
  `produce_imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片地址',
  `produce_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品的作者',
  `produce_sale_count` int(11) DEFAULT NULL COMMENT '已销售数量',
  `produce_hot` int(11) DEFAULT NULL COMMENT '商品热度',
  `produce_creat_user_id` int(11) DEFAULT 2 COMMENT '发布商品的用户id',
  `create_time` datetime(0) DEFAULT NULL COMMENT '发布时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`produce_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of produce_sell
-- ----------------------------
INSERT INTO `produce_sell` VALUES (1, 'c#高级编程', '内容超级全', 'bc001', 499, 100.00, 150.00, '/images/cbiancheng.jpg', '未知', NULL, 10, 2, '2019-09-04 14:58:30', '2019-09-20 14:58:36');
INSERT INTO `produce_sell` VALUES (2, 'java从入门到精通', '第五版', 'bc001', 12, 50.00, 99.90, '/images/javarumeng.jpg', '未知', NULL, 9, 2, '2019-09-05 15:09:09', '2019-09-18 15:09:22');
INSERT INTO `produce_sell` VALUES (3, '哈利波特', '故事很精彩', 'et001', 8, 20.00, 31.50, '/images/halibote.jpg', '未知', NULL, 6, 2, '2019-09-02 15:48:48', '2019-09-18 15:48:52');
INSERT INTO `produce_sell` VALUES (4, '文学的邀约', '关于文学的介绍', 'wx001', 48, 25.00, 42.70, '/images/wenxuede.jpg', '未知', NULL, 5, 2, '2019-09-10 15:48:54', '2019-09-18 15:48:58');
INSERT INTO `produce_sell` VALUES (5, '文学的意义', '关于文学的意义', 'wx001', 130, 10.00, 15.00, '/images/wenxuedeyiyi.jpg', '未知', NULL, 7, 2, '2019-09-03 15:47:55', '2019-09-18 15:48:02');
INSERT INTO `produce_sell` VALUES (6, 'python学习手册', '关于python的知识和一些你意想不到的知识', 'bc001', 296, 120.00, 173.00, '/images/python.jpg', '未知', NULL, 8, 2, '2019-09-04 15:58:31', '2019-09-18 15:58:34');
INSERT INTO `produce_sell` VALUES (7, 'Go语高级编程', '关于go语言的教材', 'bc001', 251, 40.00, 70.30, '/images/goyvyang.jpg', '未知', NULL, 2, 2, '2019-09-09 15:59:55', '2019-09-18 16:00:02');
INSERT INTO `produce_sell` VALUES (8, '格林童话精选', '有意思的故事会', 'wx001', 560, 5.00, 13.50, '/images/gelin.jpg', '未知', NULL, 1, 2, '2019-09-03 16:02:52', '2019-09-18 16:02:56');
INSERT INTO `produce_sell` VALUES (9, '西游记', '去西天取经', 'wx001', 2000, 17.00, 19.50, '/images/xiyouji.jpg', '吴承恩', NULL, 3, 2, '2019-09-09 16:04:16', '2019-09-18 16:04:23');

-- ----------------------------
-- Table structure for produce_sell_category
-- ----------------------------
DROP TABLE IF EXISTS `produce_sell_category`;
CREATE TABLE `produce_sell_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类目id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品类别名称',
  `
describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品类别描述',
  `sortnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品种类编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sortnum`(`sortnum`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of produce_sell_category
-- ----------------------------
INSERT INTO `produce_sell_category` VALUES (1, '编程类', '有关编程的读书', 'bc001');
INSERT INTO `produce_sell_category` VALUES (2, '儿童读书', 'java的基础知识点', 'et001');
INSERT INTO `produce_sell_category` VALUES (3, '传记', '叙述名人的生平经历', 'zj001');
INSERT INTO `produce_sell_category` VALUES (4, '文学', '用形象反映社会生活', 'wx001');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `produce_id` int(11) DEFAULT NULL COMMENT '商品id',
  `cart_produce_count` int(11) DEFAULT NULL COMMENT '购物车中此商品的数量',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES (1, 2, 1, 13, '2019-10-02 13:54:46', '2019-10-13 13:54:50');
INSERT INTO `shopping_cart` VALUES (15, 2, 2, 3, '2019-10-22 11:56:41', '2019-10-22 11:56:41');
INSERT INTO `shopping_cart` VALUES (16, 2, 3, 3, '2019-10-22 11:57:34', '2019-10-22 11:57:34');
INSERT INTO `shopping_cart` VALUES (17, 3, 3, 1, '2019-10-31 21:33:56', '2019-10-31 21:33:56');
INSERT INTO `shopping_cart` VALUES (18, 2, 4, 1, '2019-11-01 20:58:49', '2019-11-01 20:58:49');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `user_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户性别',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `user_
address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户地址',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户电话',
  `user_headimgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像图片地址',
  `user_status` int(255) DEFAULT NULL COMMENT '状态（1禁用，0未禁用）',
  `user_type` int(255) DEFAULT NULL COMMENT '身份标识（1买家，2卖家，3超级管理员）',
  `user_money` decimal(10, 1) DEFAULT NULL COMMENT '用户账户余额',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '鸣人', '男', 'password', '台北', '15173468345', '/images/mingren.jpg', 0, 1, 200.0);
INSERT INTO `user` VALUES (2, 'musicman', '男', 'password', '衡阳', '15173468345', '/images/leehongwang.jpg', 0, 3, 0.0);
INSERT INTO `user` VALUES (3, 'admin', '男', 'password', '衡阳', NULL, '/images/mingren.jpg', 0, 3, 0.0);
INSERT INTO `user` VALUES (5, 'JayZhou', '男', 'password', NULL, NULL, '/images/JayZhou.jpeg', 0, 1, 100000000.0);
INSERT INTO `user` VALUES (6, '周杰伦', '男', 'password', '台北', NULL, '/images/JayZhou.jpeg', 0, 1, 100000000.0);
INSERT INTO `user` VALUES (7, '林俊杰', '男', 'password', '新加坡', NULL, '/images/mingren.jpg', NULL, NULL, 0.0);
INSERT INTO `user` VALUES (8, 'object', NULL, 'password', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, 'obj', NULL, 'password', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, 'obj', NULL, 'password', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (11, 'gootobj', NULL, 'password', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (12, 'abc', NULL, 'password', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (13, 'a', NULL, 'password', NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
