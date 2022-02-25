/*
Navicat MySQL Data Transfer

Source Server         : dev_192.168.2.254
Source Server Version : 50623
Source Host           : 192.168.2.254:3306
Source Database       : tc_db

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2016-07-15 19:56:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tc_account_password_check_log
-- ----------------------------
DROP TABLE IF EXISTS `tc_account_password_check_log`;
CREATE TABLE `tc_account_password_check_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(30) NOT NULL,
  `check_time` bigint(20) NOT NULL,
  `check_result` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21831 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for tc_account_transaction
-- ----------------------------
DROP TABLE IF EXISTS `tc_account_transaction`;
CREATE TABLE `tc_account_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `txid` varchar(30) NOT NULL COMMENT '流水号',
  `account_id` varchar(20) DEFAULT NULL COMMENT '主账户/子帐户号',
  `account_type` tinyint(4) DEFAULT NULL COMMENT '1:主账户，2：子账户',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `in_out` tinyint(4) DEFAULT NULL COMMENT '1:收入，0：支出',
  `biz_no` varchar(50) DEFAULT NULL COMMENT '业务编号',
  `biz_type` tinyint(4) DEFAULT NULL COMMENT '业务类型',
  `biz_time` bigint(20) DEFAULT NULL,
  `pay_txid` varchar(50) DEFAULT NULL COMMENT '支付流水号',
  `refund_txid` varchar(50) DEFAULT NULL COMMENT '退款',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '银行处理流水号',
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建日期',
  `unlock_time` bigint(20) DEFAULT NULL,
  `cancel_time` bigint(20) DEFAULT NULL,
  `effect_user` varchar(50) DEFAULT NULL,
  `effect_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `cancel_user` varchar(50) DEFAULT NULL,
  `unlock_user` varchar(50) DEFAULT NULL,
  `trans_type` tinyint(4) DEFAULT '1' COMMENT '流水的类型：\r\n0：锁定流水，1：正常\r\n2：对冲流水，3：撤销流水',
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_txid` (`txid`) USING BTREE,
  KEY `idx_accountId` (`account_id`) USING BTREE,
  KEY `idx_bizNo_bizType` (`account_id`,`in_out`,`biz_no`,`biz_type`) USING BTREE,
  KEY `idxSign` (`sign`)
) ENGINE=InnoDB AUTO_INCREMENT=1788470 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_account_transaction_lock
-- ----------------------------
DROP TABLE IF EXISTS `tc_account_transaction_lock`;
CREATE TABLE `tc_account_transaction_lock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `lock_txid` varchar(30) NOT NULL COMMENT '流水号',
  `create_time` bigint(20) NOT NULL COMMENT '创建日期',
  `effective_time` bigint(20) DEFAULT NULL COMMENT '生效时间',
  `unlock_time` bigint(20) DEFAULT NULL COMMENT '解锁时间',
  `unlock_txid` varchar(30) DEFAULT NULL COMMENT '解锁生成的交易流水',
  `status` tinyint(4) NOT NULL COMMENT '状态：0=锁定，1=解锁',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_lock_txid` (`lock_txid`) USING BTREE,
  KEY `idx_unlock_txid` (`unlock_txid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_account_transaction_sn
-- ----------------------------
DROP TABLE IF EXISTS `tc_account_transaction_sn`;
CREATE TABLE `tc_account_transaction_sn` (
  `id` bigint(20) NOT NULL COMMENT '最后一次生成的流水号',
  `step` int(11) DEFAULT NULL COMMENT '步长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_account_transaction_version
-- ----------------------------
DROP TABLE IF EXISTS `tc_account_transaction_version`;
CREATE TABLE `tc_account_transaction_version` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `log_time` bigint(20) DEFAULT NULL,
  `operator` varchar(50) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `txid` varchar(30) DEFAULT NULL COMMENT '流水号',
  `account_id` varchar(20) DEFAULT NULL COMMENT '主账户/子帐户号',
  `account_type` tinyint(4) DEFAULT NULL COMMENT '1:主账户，2：子账户',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `in_out` tinyint(4) DEFAULT NULL COMMENT '1:收入，0：支出',
  `biz_no` varchar(50) DEFAULT NULL COMMENT '业务编号',
  `biz_type` tinyint(4) DEFAULT NULL COMMENT '业务类型',
  `biz_time` bigint(20) DEFAULT NULL,
  `pay_txid` varchar(50) DEFAULT NULL COMMENT '支付流水号',
  `refund_txid` varchar(50) DEFAULT NULL COMMENT '退款',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '银行处理流水号',
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建日期',
  `unlock_time` bigint(20) DEFAULT NULL,
  `cancel_time` bigint(20) DEFAULT NULL,
  `effect_user` varchar(50) DEFAULT NULL,
  `effect_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `cancel_user` varchar(50) DEFAULT NULL,
  `unlock_user` varchar(50) DEFAULT NULL,
  `trans_type` tinyint(4) DEFAULT '1' COMMENT '流水的类型：\r\n0：锁定流水，1：正常\r\n2：对冲流水，3：撤销流水',
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=488 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for tc_batch_transfer_payee
-- ----------------------------
DROP TABLE IF EXISTS `tc_batch_transfer_payee`;
CREATE TABLE `tc_batch_transfer_payee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `transfer_id` int(11) NOT NULL COMMENT '转账ID',
  `biz_no` varchar(50) NOT NULL COMMENT '业务单号',
  `biz_type` tinyint(4) DEFAULT NULL COMMENT '业务类型 0.直接转账 1.运费补偿 2.会员卡退款 3.订单退货',
  `txid` varchar(30) DEFAULT NULL COMMENT '流水号',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '商户内部流水号',
  `payee_name` varchar(50) DEFAULT NULL COMMENT '收款人账户名',
  `payee_account` varchar(50) DEFAULT NULL COMMENT '收款人的账户',
  `payment_amount` decimal(10,2) DEFAULT NULL COMMENT '付款金额',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态标识  0未确认 1成功 2失败',
  `payment_comments` varchar(50) DEFAULT NULL COMMENT '付款备注',
  `return_message` varchar(100) DEFAULT NULL COMMENT '成功内容为空，失败则为失败原因',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_Txid` (`txid`),
  KEY `idx_bizNo_bizType` (`biz_no`,`biz_type`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tc_batch_transfer_transaction
-- ----------------------------
DROP TABLE IF EXISTS `tc_batch_transfer_transaction`;
CREATE TABLE `tc_batch_transfer_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `txid` varchar(30) NOT NULL COMMENT '转账流水号',
  `batch_no` varchar(50) DEFAULT NULL COMMENT '批次号',
  `source` tinyint(4) DEFAULT NULL COMMENT '调用来源标识',
  `transfer_way_code` tinyint(4) DEFAULT NULL COMMENT '转账类型，1:支付宝转支付宝，2:微信转微信，3:支付宝转银行，4:银行转支付宝',
  `payer_name` varchar(50) DEFAULT NULL COMMENT '付款人账户名',
  `payer_account` varchar(50) DEFAULT NULL COMMENT '付款人账号',
  `transfer_total_amount` decimal(10,2) DEFAULT NULL COMMENT '转账总金额',
  `transfer_num` int(4) DEFAULT NULL COMMENT '转账总笔数',
  `transfer_comments` varchar(50) DEFAULT NULL COMMENT '转账备注',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '银行或支付宝转账交易流水号',
  `transfer_time` bigint(20) DEFAULT NULL COMMENT '转账时间',
  `create_user_name` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user_name` varchar(50) DEFAULT NULL COMMENT '更新人',
  `status` tinyint(4) DEFAULT NULL COMMENT '1:转账申请已经提交，2:转账完成，3:转账失败',
  `transfer_return_message` varchar(50) DEFAULT NULL COMMENT '支付平台返回的消息',
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_Txid` (`txid`),
  UNIQUE KEY `idx_batchNo_source` (`batch_no`,`source`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tc_batch_transfer_transaction_status_log
-- ----------------------------
DROP TABLE IF EXISTS `tc_batch_transfer_transaction_status_log`;
CREATE TABLE `tc_batch_transfer_transaction_status_log` (
  `log_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Log自增ID',
  `txid` varchar(30) NOT NULL COMMENT '事务号',
  `old_status` tinyint(4) DEFAULT NULL COMMENT '原来状态',
  `new_status` tinyint(4) DEFAULT NULL COMMENT '最新状态',
  `log_time` bigint(20) DEFAULT NULL COMMENT '创建日期',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `change_reason` varchar(200) DEFAULT NULL COMMENT '状态变更原因',
  PRIMARY KEY (`log_id`),
  UNIQUE KEY `idx_Txid` (`txid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tc_main_account
-- ----------------------------
DROP TABLE IF EXISTS `tc_main_account`;
CREATE TABLE `tc_main_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `main_account_id` varchar(20) NOT NULL COMMENT '主账户编号',
  `user_id` int(11) NOT NULL COMMENT '用户账号',
  `user_type` tinyint(4) DEFAULT '1' COMMENT '用户类型：1：客户（customer） 2：店员（user） 3：C端顾客（user）\r\n',
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `total_balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '余额',
  `available_balance` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payment_password` varchar(50) DEFAULT NULL COMMENT '支付密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `card_id` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `is_mobile_validated` bit(1) DEFAULT NULL COMMENT '手机是否验证',
  `is_email_validated` bit(1) DEFAULT NULL COMMENT '邮箱是否验证',
  `is_id_validated` bit(1) DEFAULT NULL COMMENT '身份是否验证',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` bigint(20) DEFAULT NULL COMMENT '最后一次更新时间',
  `update_user` varchar(50) DEFAULT NULL,
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `last_ref_txid` varchar(30) DEFAULT NULL,
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_mainAccountId` (`main_account_id`) USING BTREE,
  UNIQUE KEY `idx_userId_type` (`user_id`,`user_type`)
) ENGINE=InnoDB AUTO_INCREMENT=170739 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_main_account_sn
-- ----------------------------
DROP TABLE IF EXISTS `tc_main_account_sn`;
CREATE TABLE `tc_main_account_sn` (
  `id` bigint(20) NOT NULL COMMENT '最后一次生成的流水号',
  `step` int(11) DEFAULT NULL COMMENT '步长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_main_account_status_log
-- ----------------------------
DROP TABLE IF EXISTS `tc_main_account_status_log`;
CREATE TABLE `tc_main_account_status_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `main_account_id` varchar(20) DEFAULT NULL COMMENT '主账户编号',
  `old_status` tinyint(4) DEFAULT NULL COMMENT '变更前的状态',
  `new_status` tinyint(4) DEFAULT NULL COMMENT '变更后的状态',
  `reason` varchar(50) DEFAULT NULL COMMENT '状态变更原因',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建日期',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`log_id`),
  KEY `idx_mainAccountId` (`main_account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_main_account_version
-- ----------------------------
DROP TABLE IF EXISTS `tc_main_account_version`;
CREATE TABLE `tc_main_account_version` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `log_time` bigint(20) DEFAULT NULL COMMENT '日志记录时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作人',
  `id` int(11) NOT NULL COMMENT '自增ID',
  `main_account_id` varchar(20) NOT NULL COMMENT '主账户编号',
  `user_id` int(11) NOT NULL COMMENT '用户账号',
  `user_type` tinyint(4) DEFAULT NULL COMMENT '用户类型：1：客户（customer） 2：店员（user） 3：C端顾客（user）',
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `total_balance` decimal(10,2) NOT NULL COMMENT '余额',
  `available_balance` decimal(10,2) DEFAULT '0.00',
  `payment_password` varchar(50) DEFAULT NULL COMMENT '支付密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `card_id` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `is_mobile_validated` bit(1) DEFAULT NULL COMMENT '手机是否验证',
  `is_email_validated` bit(1) DEFAULT NULL COMMENT '邮箱是否验证',
  `is_id_validated` bit(1) DEFAULT NULL COMMENT '身份是否验证',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` bigint(20) DEFAULT NULL COMMENT '最后一次更新时间',
  `update_user` varchar(50) DEFAULT NULL,
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `last_ref_txid` varchar(30) DEFAULT NULL,
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_pay_transaction
-- ----------------------------
DROP TABLE IF EXISTS `tc_pay_transaction`;
CREATE TABLE `tc_pay_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `txid` varchar(30) NOT NULL COMMENT '支付事务号',
  `biz_no` varchar(50) DEFAULT NULL COMMENT 'TM业务编号',
  `biz_type` tinyint(4) DEFAULT NULL COMMENT 'TM业务类型',
  `amount` decimal(18,2) DEFAULT NULL COMMENT '支付金额',
  `pay_name` tinyint(4) DEFAULT NULL COMMENT '支付方式，支付宝，易宝，',
  `pay_type` tinyint(4) DEFAULT NULL COMMENT '支付类型，银行直连，还是平台支付',
  `bank_code` varchar(4) DEFAULT NULL COMMENT '直连的时候，银行代码',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '银行交易流水号',
  `pay_time` bigint(20) DEFAULT NULL COMMENT '支付时间',
  `create_user` varchar(50) DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0：未支付，1：已支付，2：已取消',
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_Txid` (`txid`) USING BTREE,
  KEY `idx_bizNo_bizType` (`biz_no`,`biz_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=558 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_pay_transaction_sn
-- ----------------------------
DROP TABLE IF EXISTS `tc_pay_transaction_sn`;
CREATE TABLE `tc_pay_transaction_sn` (
  `id` bigint(20) NOT NULL COMMENT '最后一次生成的流水号',
  `step` int(11) DEFAULT NULL COMMENT '步长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_pay_transaction_status_log
-- ----------------------------
DROP TABLE IF EXISTS `tc_pay_transaction_status_log`;
CREATE TABLE `tc_pay_transaction_status_log` (
  `txid` varchar(30) NOT NULL COMMENT '支付事务号',
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `old_status` tinyint(4) DEFAULT NULL,
  `new_status` tinyint(4) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `log_time` bigint(20) DEFAULT NULL COMMENT '创建日期',
  `operator` varchar(50) DEFAULT 'system',
  PRIMARY KEY (`log_id`),
  UNIQUE KEY `idx_Txid` (`txid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=318 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_refund_transaction
-- ----------------------------
DROP TABLE IF EXISTS `tc_refund_transaction`;
CREATE TABLE `tc_refund_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `txid` varchar(30) NOT NULL COMMENT '退款流水号',
  `pay_txid` varchar(30) NOT NULL COMMENT '对应支付流水号',
  `biz_no` varchar(50) DEFAULT NULL COMMENT '业务单号',
  `biz_type` tinyint(4) DEFAULT NULL COMMENT '义务类型',
  `amount` decimal(10,2) DEFAULT NULL,
  `refund_trade_no` varchar(50) DEFAULT NULL COMMENT '银行退款流水号',
  `return_message` varchar(5000) DEFAULT NULL COMMENT '银行/支付平台返回的消息',
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(50) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL COMMENT '最后一次更新时间',
  `refund_time` bigint(20) DEFAULT NULL COMMENT '银行实际退款时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态：\r\n            0，待退款，\r\n            1，已发送到队列，\r\n            2：提交到银行/支付平台成功，\r\n            3：提交到银行/支付平台失败\r\n            4，退款成功\r\n            5，退款失败',
  `sign` varchar(200) DEFAULT NULL COMMENT '签名',
  `refund_batch_no` varchar(50) DEFAULT NULL,
  `refund_reason` varchar(200) DEFAULT NULL,
  `is_notify_biz_system` tinyint(4) DEFAULT '0' COMMENT '是否通知业务系统退款结果，0：未通知，1：已通知',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_Txid` (`txid`) USING BTREE,
  UNIQUE KEY `idx_bizNo_bizType` (`biz_no`,`biz_type`) USING BTREE,
  KEY `idx_payTxid` (`pay_txid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_refund_transaction_sn
-- ----------------------------
DROP TABLE IF EXISTS `tc_refund_transaction_sn`;
CREATE TABLE `tc_refund_transaction_sn` (
  `id` bigint(20) NOT NULL COMMENT '最后一次生成的流水号',
  `step` int(11) DEFAULT NULL COMMENT '步长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_refund_transaction_status_log
-- ----------------------------
DROP TABLE IF EXISTS `tc_refund_transaction_status_log`;
CREATE TABLE `tc_refund_transaction_status_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `txid` varchar(30) NOT NULL COMMENT '事务号',
  `old_status` tinyint(4) DEFAULT NULL,
  `new_status` tinyint(4) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `log_time` bigint(20) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`log_id`),
  KEY `idx_Txid` (`txid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_sub_account
-- ----------------------------
DROP TABLE IF EXISTS `tc_sub_account`;
CREATE TABLE `tc_sub_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `sub_account_id` varchar(20) NOT NULL COMMENT '子账户编号',
  `main_account_id` varchar(20) NOT NULL,
  `payment_password` varchar(50) NOT NULL COMMENT '支付密码',
  `sub_account_type` tinyint(4) NOT NULL COMMENT '子账户类型：1，会员卡，2：积分',
  `total_balance` decimal(10,2) NOT NULL COMMENT '账户余额',
  `available_balance` decimal(10,2) NOT NULL DEFAULT '0.00',
  `locked_income_balance` decimal(10,2) DEFAULT '0.00' COMMENT '锁定的收入总额',
  `locked_outcome_balance` decimal(10,2) DEFAULT '0.00' COMMENT '锁定的支出总额',
  `card_no` varchar(50) DEFAULT NULL COMMENT '卡号',
  `card_type` tinyint(4) DEFAULT NULL COMMENT '卡类型，1会员卡',
  `status` tinyint(4) DEFAULT NULL COMMENT '0：未激活，\r\n            1：激活，\r\n            2：锁定\r\n            3：注销',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '最后一次修改时间',
  `create_user` varchar(50) DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `last_ref_txid` varchar(30) DEFAULT NULL,
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  `last_check_password_time` bigint(20) DEFAULT NULL,
  `password_wrong_times` int(11) DEFAULT '0',
  `status_change_type` tinyint(4) DEFAULT '0' COMMENT '状态变更原因：\r\n0：\r\n1：账户升级\r\n2：密码错误次数\r\n3：管理员操作\r\n4：',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_subAccountId` (`sub_account_id`) USING BTREE,
  UNIQUE KEY `idx_mainAccountId_SubAccountType` (`main_account_id`,`sub_account_type`,`card_no`,`card_type`) USING BTREE,
  KEY `idx_cardNo_cardType` (`card_no`,`card_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=116405 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_sub_account_sn
-- ----------------------------
DROP TABLE IF EXISTS `tc_sub_account_sn`;
CREATE TABLE `tc_sub_account_sn` (
  `id` bigint(20) NOT NULL COMMENT '最后一次生成的流水号',
  `step` int(11) DEFAULT NULL COMMENT '步长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_sub_account_status_log
-- ----------------------------
DROP TABLE IF EXISTS `tc_sub_account_status_log`;
CREATE TABLE `tc_sub_account_status_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_account_id` varchar(20) NOT NULL,
  `old_status` tinyint(4) DEFAULT NULL,
  `new_status` tinyint(4) DEFAULT NULL,
  `status_change_type` tinyint(4) DEFAULT '0',
  `reason` varchar(50) DEFAULT NULL,
  `log_time` bigint(20) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`log_id`),
  KEY `idx_subAccountId` (`sub_account_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for tc_sub_account_version
-- ----------------------------
DROP TABLE IF EXISTS `tc_sub_account_version`;
CREATE TABLE `tc_sub_account_version` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志',
  `log_time` bigint(20) DEFAULT NULL COMMENT '日志记录时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作人',
  `id` int(11) NOT NULL COMMENT '自增ID',
  `sub_account_id` varchar(20) NOT NULL COMMENT '子账户编号',
  `main_account_id` varchar(20) DEFAULT NULL,
  `payment_password` varchar(50) DEFAULT NULL COMMENT '支付密码',
  `sub_account_type` tinyint(4) DEFAULT NULL COMMENT '子账户类型:1，会员卡，',
  `total_balance` decimal(10,2) DEFAULT NULL COMMENT '账户余额',
  `available_balance` decimal(10,2) DEFAULT '0.00',
  `locked_income_balance` decimal(10,2) DEFAULT NULL,
  `locked_outcome_balance` decimal(10,2) DEFAULT NULL,
  `card_no` varchar(50) DEFAULT NULL COMMENT '卡号',
  `card_type` tinyint(4) DEFAULT NULL COMMENT '卡类型，1会员卡,2:积分',
  `status` tinyint(4) DEFAULT NULL COMMENT '0：未激活，\r\n            1：激活，\r\n            2：锁定\r\n            3：注销',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '最后一次修改时间',
  `create_user` varchar(50) DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `last_ref_txid` varchar(30) DEFAULT NULL,
  `last_check_password_time` bigint(20) DEFAULT NULL,
  `password_wrong_times` int(11) DEFAULT NULL,
  `status_change_type` tinyint(4) DEFAULT '0',
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91593 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- View structure for tc_account_transaction_view
-- ----------------------------
DROP VIEW IF EXISTS `tc_account_transaction_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `tc_account_transaction_view` AS select `a`.`id` AS `id`,`a`.`txid` AS `txid`,`a`.`account_id` AS `sub_account_id`,`a`.`account_type` AS `sub_account_type`,`a`.`amount` AS `amount`,`a`.`in_out` AS `in_out`,`a`.`biz_no` AS `biz_no`,`a`.`biz_type` AS `biz_type`,`a`.`biz_time` AS `biz_time`,`a`.`pay_txid` AS `pay_txid`,`a`.`refund_txid` AS `refund_txid`,`a`.`trade_no` AS `trade_no`,`a`.`create_user` AS `create_user`,`a`.`create_time` AS `create_time`,`a`.`unlock_time` AS `unlock_time`,`a`.`cancel_time` AS `cancel_time`,`a`.`effect_user` AS `effect_user`,`a`.`effect_time` AS `effect_time`,`a`.`update_time` AS `update_time`,`a`.`update_user` AS `update_user`,`a`.`cancel_user` AS `cancel_user`,`a`.`unlock_user` AS `unlock_user`,`a`.`trans_type` AS `trans_type`,`a`.`sign` AS `sign`,`b`.`main_account_id` AS `main_account_id`,`b`.`card_no` AS `card_no`,`b`.`card_type` AS `card_type`,`b`.`available_balance` AS `available_balance`,`b`.`total_balance` AS `total_balance`,`b`.`locked_income_balance` AS `locked_income_balance`,`b`.`locked_outcome_balance` AS `locked_outcome_balance`,`b`.`status` AS `STATUS`,`b`.`status_change_type` AS `status_change_type`,`c`.`user_id` AS `user_id`,`c`.`user_type` AS `user_type` from ((`tc_account_transaction` `a` join `tc_sub_account` `b` on((`a`.`account_id` = `b`.`sub_account_id`))) join `tc_main_account` `c` on((`b`.`main_account_id` = `c`.`main_account_id`))) ;

-- ----------------------------
-- View structure for tc_sub_account_view
-- ----------------------------
DROP VIEW IF EXISTS `tc_sub_account_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER VIEW `tc_sub_account_view` AS select `sa`.`id` AS `id`,`sa`.`sub_account_id` AS `sub_account_id`,`sa`.`main_account_id` AS `main_account_id`,`sa`.`payment_password` AS `payment_password`,`sa`.`sub_account_type` AS `sub_account_type`,`sa`.`total_balance` AS `total_balance`,`sa`.`available_balance` AS `available_balance`,`sa`.`locked_income_balance` AS `locked_income_balance`,`sa`.`locked_outcome_balance` AS `locked_outcome_balance`,`sa`.`card_no` AS `card_no`,`sa`.`card_type` AS `card_type`,`sa`.`status` AS `STATUS`,`sa`.`create_time` AS `create_time`,`sa`.`update_time` AS `update_time`,`sa`.`create_user` AS `create_user`,`sa`.`update_user` AS `update_user`,`sa`.`last_ref_txid` AS `last_ref_txid`,`sa`.`sign` AS `sign`,`sa`.`last_check_password_time` AS `last_check_password_time`,`sa`.`password_wrong_times` AS `password_wrong_times`,`sa`.`status_change_type` AS `status_change_type`,`ma`.`user_id` AS `user_id` from (`tc_sub_account` `sa` left join `tc_main_account` `ma` on((`sa`.`main_account_id` = `ma`.`main_account_id`))) ;

-- ----------------------------
-- Function structure for get_account_transaction_sn
-- ----------------------------
DROP FUNCTION IF EXISTS `get_account_transaction_sn`;
DELIMITER ;;
CREATE DEFINER=`alpha_user`@`%` FUNCTION `get_account_transaction_sn`() RETURNS int(11)
BEGIN
	UPDATE tc_account_transaction_sn

SET id = (
	CASE
	WHEN id < 99999999 THEN
		LAST_INSERT_ID(id + step)
	ELSE
		LAST_INSERT_ID(step)
	END
);
RETURN (SELECT LAST_INSERT_ID());
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for get_main_account_sn
-- ----------------------------
DROP FUNCTION IF EXISTS `get_main_account_sn`;
DELIMITER ;;
CREATE DEFINER=`alpha_user`@`%` FUNCTION `get_main_account_sn`() RETURNS int(11)
BEGIN
	UPDATE tc_main_account_sn
SET id = (LAST_INSERT_ID(id + step));
RETURN (SELECT LAST_INSERT_ID());
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for get_pay_transaction_sn
-- ----------------------------
DROP FUNCTION IF EXISTS `get_pay_transaction_sn`;
DELIMITER ;;
CREATE DEFINER=`alpha_user`@`%` FUNCTION `get_pay_transaction_sn`() RETURNS int(11)
BEGIN
	UPDATE tc_pay_transaction_sn
SET id = (
	CASE
	WHEN id < 99999999 THEN
		LAST_INSERT_ID(id + step)
	ELSE
		LAST_INSERT_ID(step)
	END
);
RETURN (SELECT LAST_INSERT_ID());
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for get_refund_transaction_sn
-- ----------------------------
DROP FUNCTION IF EXISTS `get_refund_transaction_sn`;
DELIMITER ;;
CREATE DEFINER=`alpha_user`@`%` FUNCTION `get_refund_transaction_sn`() RETURNS int(11)
BEGIN
	UPDATE tc_refund_transaction_sn
SET id = (
	CASE
	WHEN id < 99999999 THEN
		LAST_INSERT_ID(id + step)
	ELSE
		LAST_INSERT_ID(step)
	END
);
RETURN (SELECT LAST_INSERT_ID());
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for get_sub_account_sn
-- ----------------------------
DROP FUNCTION IF EXISTS `get_sub_account_sn`;
DELIMITER ;;
CREATE DEFINER=`alpha_user`@`%` FUNCTION `get_sub_account_sn`() RETURNS int(11)
BEGIN
	UPDATE tc_sub_account_sn
SET id = (LAST_INSERT_ID(id + step));
RETURN (SELECT LAST_INSERT_ID());
END
;;
DELIMITER ;
