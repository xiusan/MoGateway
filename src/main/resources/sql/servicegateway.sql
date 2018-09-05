/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : servicegateway

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-07-30 18:48:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agreement
-- ----------------------------
DROP TABLE IF EXISTS `agreement`;
CREATE TABLE `agreement` (
  `agreement_id` varchar(20) NOT NULL DEFAULT '',
  `agreement_name` varchar(50) DEFAULT NULL,
  `agreement_addr` varchar(100) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `agreement_sub_channel` varchar(50) DEFAULT NULL,
  `agreement_pub_channel` varchar(255) DEFAULT NULL,
  `agreement_home_url` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`agreement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agreement
-- ----------------------------
INSERT INTO `agreement` VALUES ('97', '97电表协议', '/home/temp/agreementFiles/97/ammeterprotocol97-0.0.1-SNAPSHOT.jar', '1', '-', '-', 'http://localhost:8190', 'admin', '2018-06-01 17:51:53', 'admin', '2018-06-01 17:54:46');

-- ----------------------------
-- Table structure for ammeter
-- ----------------------------
DROP TABLE IF EXISTS `ammeter`;
CREATE TABLE `ammeter` (
  `ammeter_id` varchar(255) NOT NULL DEFAULT '',
  `ammeter_name` varchar(255) DEFAULT NULL,
  `agreement_id` varchar(255) DEFAULT NULL,
  `enable` tinyint(4) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ammeter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ammeter
-- ----------------------------
INSERT INTO `ammeter` VALUES ('126025000000', '2号电表', '97', '0', '2018-05-16 10:21:15', 'admin');
INSERT INTO `ammeter` VALUES ('156025000000', '1号电表', '97', '0', '2018-05-15 17:16:55', 'admin');

-- ----------------------------
-- Table structure for can_frame
-- ----------------------------
DROP TABLE IF EXISTS `can_frame`;
CREATE TABLE `can_frame` (
  `protocol_id` varchar(255) NOT NULL DEFAULT '',
  `frame_id` char(8) DEFAULT NULL,
  `attribute_cn` varchar(255) DEFAULT NULL,
  `attribute_en` varchar(255) DEFAULT NULL,
  `attibute_type` varchar(255) DEFAULT NULL,
  `start_byte_index` int(11) DEFAULT NULL,
  `byte_count` int(11) DEFAULT NULL,
  `endian_type` tinyint(4) DEFAULT NULL,
  `decode_type` tinyint(4) DEFAULT NULL,
  `accuracy` double DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`protocol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of can_frame
-- ----------------------------

-- ----------------------------
-- Table structure for can_frame_detail
-- ----------------------------
DROP TABLE IF EXISTS `can_frame_detail`;
CREATE TABLE `can_frame_detail` (
  `protocol_id` varchar(255) DEFAULT NULL,
  `frame_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of can_frame_detail
-- ----------------------------

-- ----------------------------
-- Table structure for charge_record
-- ----------------------------
DROP TABLE IF EXISTS `charge_record`;
CREATE TABLE `charge_record` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `charging_record_no` varchar(255) DEFAULT NULL,
  `equipment_no` varchar(255) DEFAULT NULL,
  `order_number` varchar(255) DEFAULT NULL,
  `charging_station_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `car_number` varchar(255) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `start_charging_dttm` datetime DEFAULT NULL,
  `end_charging_dttm` datetime DEFAULT NULL,
  `total_charging_dttm` int(10) DEFAULT NULL,
  `start_ammeter_no` double(10,2) DEFAULT NULL,
  `ent_ammeter_no` double(10,2) DEFAULT NULL,
  `total_charging_kwh` double(10,2) DEFAULT NULL,
  `charged_amount` double(10,2) DEFAULT NULL,
  `discount_amount` double(10,2) DEFAULT NULL,
  `start_soc` int(10) DEFAULT NULL,
  `end_soc` int(10) DEFAULT NULL,
  `total_soc` int(10) DEFAULT NULL,
  `end_reason` int(1) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `sharp_start_charging_dttm` datetime DEFAULT NULL,
  `sharp_end_charging_dttm` datetime DEFAULT NULL,
  `sharp_start_ammeter_no` double(10,2) DEFAULT NULL,
  `sharp_end_ammeter_no` double(10,2) DEFAULT NULL,
  `sharp_total_charging_kwh` double(10,2) DEFAULT NULL,
  `sharp_total_charging_dttm` int(11) DEFAULT NULL,
  `sharp_total_charging_amount` double DEFAULT NULL,
  `peak_start_charging_dttm` datetime DEFAULT NULL,
  `peak_end_charging_dttm` datetime DEFAULT NULL,
  `peak_start_ammeter_no` double(10,2) DEFAULT NULL,
  `peak_end_ammeter_no` double(10,2) DEFAULT NULL,
  `peak_total_charging_kwh` double(10,2) DEFAULT NULL,
  `peak_total_charging_dttm` int(11) DEFAULT NULL,
  `peak_total_charging_amount` double DEFAULT NULL,
  `flat_start_charging_dttm` datetime DEFAULT NULL,
  `flat_end_charging_dttm` datetime DEFAULT NULL,
  `flat_start_ammeter_no` double(10,2) DEFAULT NULL,
  `flat_end_ammeter_no` double(10,2) DEFAULT NULL,
  `flat_total_charging_kwh` double(10,2) DEFAULT NULL,
  `flat_total_charging_dttm` int(11) DEFAULT NULL,
  `falt_total_charging_amount` double DEFAULT NULL,
  `valley_start_charging_dttm` datetime DEFAULT NULL,
  `valley_end_charging_dttm` datetime DEFAULT NULL,
  `valley_start_ammeter_no` double(10,2) DEFAULT NULL,
  `valley_end_ammeter_no` double(10,2) DEFAULT NULL,
  `valley_total_charging_kwh` double(10,2) DEFAULT NULL,
  `valley_total_charging_dttm` int(11) DEFAULT NULL,
  `valley_total_charging_amount` double DEFAULT NULL,
  `send_flag_kj` int(1) DEFAULT NULL COMMENT '科佳云地址',
  `send_flag_other` int(1) DEFAULT NULL COMMENT '客户云地址',
  `abnormal_flag` int(1) DEFAULT NULL COMMENT '是否异常',
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of charge_record
-- ----------------------------
INSERT INTO `charge_record` VALUES ('1', '8', 'jd00102', '1527059303321', null, null, null, '2018-05-23 15:08:30', '2018-05-23 15:08:45', '0', '27.00', '27.00', '0.00', '0.00', '0.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1', 'admin', '2018-05-23 15:08:45', 'admin', '2018-05-23 15:08:45');
INSERT INTO `charge_record` VALUES ('2', '9', 'jd00102', '1527059474388', null, null, null, '2018-05-23 15:11:20', '2018-05-23 15:11:35', '0', '27.00', '27.00', '0.00', '0.00', '0.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1', 'admin', '2018-05-23 15:11:35', 'admin', '2018-05-23 15:11:35');
INSERT INTO `charge_record` VALUES ('3', '10', 'jd00102', '1527059691566', null, null, null, '2018-05-23 15:15:00', '2018-05-23 15:15:15', '0', '26.64', '26.64', '0.00', '0.00', '0.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '0', 'admin', '2018-05-23 15:15:15', 'admin', '2018-05-23 15:15:15');
INSERT INTO `charge_record` VALUES ('4', '1', 'jd00102', '1527069417107', null, null, null, '2018-05-23 17:57:06', '2018-05-23 17:58:40', '1', '26.64', '26.64', '0.00', '0.00', '0.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1', 'admin', '2018-05-23 17:58:40', 'admin', '2018-05-23 17:58:40');
INSERT INTO `charge_record` VALUES ('5', '2', 'jd00102', '1527124592051', null, null, null, '2018-05-24 09:16:50', '2018-05-24 09:18:16', '1', '26.64', '26.64', '0.00', '0.00', '0.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1', 'admin', '2018-05-24 09:18:16', 'admin', '2018-05-24 09:18:16');
INSERT INTO `charge_record` VALUES ('6', '4', 'jd00102', '1527124909912', null, null, null, '2018-05-24 09:22:00', '2018-05-24 09:22:30', '0', '26.64', '26.64', '0.00', '0.00', '0.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1', 'admin', '2018-05-24 09:22:30', 'admin', '2018-05-24 09:22:30');
INSERT INTO `charge_record` VALUES ('7', '1', 'jd00102', '1527129451762', null, null, null, '2018-05-24 10:37:40', '2018-05-24 10:38:00', '0', '26.64', '26.64', '0.00', '0.00', '0.00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1', 'admin', '2018-05-24 10:38:00', 'admin', '2018-05-24 10:38:00');

-- ----------------------------
-- Table structure for chargingstation
-- ----------------------------
DROP TABLE IF EXISTS `chargingstation`;
CREATE TABLE `chargingstation` (
  `charging_station_id` varchar(5) NOT NULL DEFAULT '' COMMENT '充电站ID',
  `operator_id` char(9) NOT NULL COMMENT '运营商ID',
  `equipment_owner_id` char(9) NOT NULL COMMENT '设备所属方ID',
  `country_code` char(2) NOT NULL COMMENT '充电站国家代码',
  `area_code` varchar(20) NOT NULL COMMENT '充电站省市辖区编码',
  `charging_station_name` varchar(50) NOT NULL COMMENT '充电站名称',
  `charging_station_addr` varchar(50) NOT NULL COMMENT '充电站地址',
  `charging_station_tel` varchar(30) DEFAULT NULL COMMENT '站点电话',
  `charging_service_tel` varchar(30) NOT NULL COMMENT '服务电话',
  `charging_station_type` int(11) NOT NULL DEFAULT '0' COMMENT '站点类型',
  `charging_station_status` int(11) NOT NULL DEFAULT '0' COMMENT '站点状态',
  `park_nums` int(11) NOT NULL COMMENT '车位数量',
  `charging_station_lng` double NOT NULL COMMENT '经度',
  `charging_station_lat` double NOT NULL COMMENT '维度',
  `site_guide` varchar(100) DEFAULT NULL COMMENT '站点引导',
  `construction` int(11) NOT NULL COMMENT '建设场所',
  `pictures` varchar(255) DEFAULT NULL COMMENT '站点照片',
  `match_cars` varchar(100) DEFAULT NULL COMMENT '适用车型描述',
  `park_info` varchar(100) DEFAULT NULL COMMENT '车位楼层及数量描述',
  `busine_houres` varchar(100) DEFAULT NULL COMMENT '营业时间',
  `electricity_fee` varchar(255) DEFAULT NULL COMMENT '充电电费率',
  `service_fee` varchar(100) DEFAULT NULL COMMENT '服务费率',
  `park_fee` varchar(100) DEFAULT NULL COMMENT '停车费',
  `payment` varchar(20) DEFAULT NULL COMMENT '支付方式',
  `support_order` tinyint(4) DEFAULT NULL COMMENT '是否支持预约，1代表支持，0代表不支持',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `enabled` tinyint(1) NOT NULL COMMENT '是否可用',
  `create_user` varchar(10) NOT NULL COMMENT '创建者',
  `create_dttm` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(10) NOT NULL COMMENT '更新者',
  `update_dttm` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`charging_station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chargingstation
-- ----------------------------
INSERT INTO `chargingstation` VALUES ('kj001', '551133697', '551133697', '10', '441781', '交大充电站', '交大', '123456789', '123456789', '0', '0', '0', '0', '0', null, '0', 'images', '123123', '123123', '123132', '123123', '123', '123', '123', '123', '123', '1', 'ck', '2018-05-18 15:37:01', 'ck', '2018-05-18 15:37:07');

-- ----------------------------
-- Table structure for charging_process_file
-- ----------------------------
DROP TABLE IF EXISTS `charging_process_file`;
CREATE TABLE `charging_process_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fiel_type` varchar(255) DEFAULT NULL,
  `equipment_id` varchar(255) DEFAULT NULL,
  `current_dttm` datetime DEFAULT NULL,
  `file_size` varchar(20) DEFAULT NULL COMMENT '文件大小',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_create_time` datetime DEFAULT NULL COMMENT '文件创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_ equipment_id` (`equipment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of charging_process_file
-- ----------------------------

-- ----------------------------
-- Table structure for charing_connector_type
-- ----------------------------
DROP TABLE IF EXISTS `charing_connector_type`;
CREATE TABLE `charing_connector_type` (
  `charging_connector_type` bigint(2) NOT NULL COMMENT 'ID',
  `charging_connector_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `create_user` varchar(10) DEFAULT NULL COMMENT '创建者',
  `create_dttm` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(10) DEFAULT NULL COMMENT '更新者',
  `update_dttm` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`charging_connector_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充电设备接口类型表';

-- ----------------------------
-- Records of charing_connector_type
-- ----------------------------
INSERT INTO `charing_connector_type` VALUES ('0', '请选择', 'amidn', '2018-07-13 17:23:30', 'admin', '2018-07-13 17:23:35');
INSERT INTO `charing_connector_type` VALUES ('1', '家用插座（模式2）', 'admin', '2018-07-11 09:56:59', 'admin', '2018-07-11 09:57:07');
INSERT INTO `charing_connector_type` VALUES ('2', '交流接口插座（模式3，连接方式B）', 'admin', '2018-07-11 09:56:59', 'admin', '2018-07-11 09:56:59');
INSERT INTO `charing_connector_type` VALUES ('3', '交流接口插头（模式3.连接方式C）', 'admin', '2018-07-11 09:56:59', 'admin', '2018-07-11 09:56:59');
INSERT INTO `charing_connector_type` VALUES ('4', '直流接口枪头（带枪线，模式4）', 'admin', '2018-07-11 09:56:59', 'admin', '2018-07-11 09:56:59');
INSERT INTO `charing_connector_type` VALUES ('5', '无线充电座', 'admin', '2018-07-11 09:56:59', 'admin', '2018-07-11 09:56:59');
INSERT INTO `charing_connector_type` VALUES ('6', '其他', 'admin', '2018-07-11 09:56:59', 'admin', '2018-07-11 09:56:59');

-- ----------------------------
-- Table structure for cloud_address_manager
-- ----------------------------
DROP TABLE IF EXISTS `cloud_address_manager`;
CREATE TABLE `cloud_address_manager` (
  `cloud_id` varchar(255) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `kj_cloud_address` varchar(255) CHARACTER SET latin1 DEFAULT NULL COMMENT '科佳云地址',
  `customer_cloud_address` varchar(255) CHARACTER SET latin1 DEFAULT NULL COMMENT '客户云地址',
  `is_synchronization` int(1) DEFAULT NULL COMMENT '是否开启同步',
  `is_certificate` int(1) DEFAULT NULL COMMENT '是否忽略证书',
  PRIMARY KEY (`cloud_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cloud_address_manager
-- ----------------------------
INSERT INTO `cloud_address_manager` VALUES ('kjtc', 'http://www.kejiatc.cn/', 'https://www.longruisdddanyou.com', '1', '0');

-- ----------------------------
-- Table structure for connect_type
-- ----------------------------
DROP TABLE IF EXISTS `connect_type`;
CREATE TABLE `connect_type` (
  `connect_type` varchar(255) NOT NULL,
  `connect_ip` varchar(255) DEFAULT NULL,
  `connect_port` int(11) DEFAULT NULL,
  `connect_baudrate` int(11) DEFAULT NULL,
  `connect_serial_port` varchar(20) DEFAULT NULL,
  `connect_serial_check_id` int(1) DEFAULT NULL,
  `connect_direction` tinyint(4) DEFAULT NULL,
  `connect_file` varchar(255) DEFAULT NULL,
  `connect_pub_redis_channel` varchar(255) DEFAULT NULL,
  `connect_sub_redis_channel` varchar(255) DEFAULT NULL,
  `connect_home_url` varchar(255) DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`connect_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of connect_type
-- ----------------------------
INSERT INTO `connect_type` VALUES ('serial', '', null, '2400', 'COM1', '2', '0', '/home/temp/connectTypeFiles/serial/serialserver-0.0.1.jar', null, null, null, '1', 'admin', '2018-06-21 16:12:00', 'admin', '2018-06-21 16:12:00');

-- ----------------------------
-- Table structure for construction_info
-- ----------------------------
DROP TABLE IF EXISTS `construction_info`;
CREATE TABLE `construction_info` (
  `construction` int(4) NOT NULL COMMENT '建设场所ID',
  `construction_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '建设场所名称',
  `create_user` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_dttm` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_dttm` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`construction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='建设场所表';

-- ----------------------------
-- Records of construction_info
-- ----------------------------

-- ----------------------------
-- Table structure for data_manager_real_time
-- ----------------------------
DROP TABLE IF EXISTS `data_manager_real_time`;
CREATE TABLE `data_manager_real_time` (
  `id` varchar(255) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `key_name` varchar(255) CHARACTER SET latin1 DEFAULT NULL COMMENT '字段名称',
  `is_synchronization` int(1) DEFAULT NULL COMMENT '是否同步 0否；1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_manager_real_time
-- ----------------------------
INSERT INTO `data_manager_real_time` VALUES ('180509100918168', 'outputVoltage', '1');
INSERT INTO `data_manager_real_time` VALUES ('18050910091833', 'chargedKWH', '1');
INSERT INTO `data_manager_real_time` VALUES ('18050910091835', 'communicateStatus', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918427', 'softwareVersion', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918489', 'chargingGunStatus', '1');
INSERT INTO `data_manager_real_time` VALUES ('18050910091854', 'hardwareVersion', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918582', 'startChargingAmmeterNo', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918584', 'startChargingDTTM', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918627', 'chargedTime', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918636', 'faultStatus', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918679', 'workStatus', '1');
INSERT INTO `data_manager_real_time` VALUES ('18050910091875', 'outputCurrent', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918820', 'currentSOC', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918871', 'equipmentID', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918948', 'ammeterNo', '1');
INSERT INTO `data_manager_real_time` VALUES ('180509100918992', 'outputPower', '1');

-- ----------------------------
-- Table structure for electric_price
-- ----------------------------
DROP TABLE IF EXISTS `electric_price`;
CREATE TABLE `electric_price` (
  `ID` varchar(255) NOT NULL DEFAULT '',
  `price` double DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of electric_price
-- ----------------------------

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `equipment_id` varchar(255) NOT NULL DEFAULT '' COMMENT '设备ID',
  `equipment_no` varchar(10) DEFAULT NULL COMMENT '设备号',
  `equipment_name` varchar(20) DEFAULT NULL COMMENT '设备名称',
  `charging_station_id` varchar(5) DEFAULT NULL COMMENT '所属充电站ID',
  `active` tinyint(1) DEFAULT NULL COMMENT '是否监控；0：监控，1：不监控',
  `equipment_type` bigint(4) DEFAULT NULL COMMENT '设备类型',
  `agreement_id` varchar(20) DEFAULT NULL COMMENT '协议ID',
  `ammeter_id` varchar(255) DEFAULT NULL COMMENT '对应电表表号',
  `connector_type` bigint(1) DEFAULT NULL COMMENT '充电枪口类型',
  `voltage_upper_limits` bigint(10) DEFAULT NULL COMMENT '额定电压上限(V)',
  `voltage_lower_limits` bigint(10) DEFAULT NULL COMMENT '额定电压下限(V)',
  `current` bigint(10) DEFAULT NULL COMMENT '额定电流',
  `power` float DEFAULT NULL COMMENT '额定功率',
  `park_no` varchar(10) DEFAULT NULL COMMENT '对应车位编号',
  `national_standard` bigint(4) DEFAULT NULL COMMENT '国标',
  `manufacturer` varchar(50) DEFAULT NULL COMMENT '设备生产商ID',
  `manufacturer_name` varchar(30) DEFAULT NULL COMMENT '设备生产商名称',
  `manufacturer_dttm` datetime DEFAULT NULL COMMENT '出厂日期',
  `delivery_dttm` datetime DEFAULT NULL COMMENT '投运日期',
  `device_id` varchar(255) DEFAULT NULL COMMENT '设备编号(一桩多枪时对应桩的编号)',
  `charging_gun_no` int(10) DEFAULT NULL COMMENT '充电枪编号',
  `create_user` varchar(10) DEFAULT NULL COMMENT '创建者',
  `create_dttm` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(10) DEFAULT NULL COMMENT '更新者',
  `update_dttm` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('kj00101', 'kj00101', '1#充电桩', 'kj001', '1', '1', '9', null, '1', '500', '100', '200', '200', 'carno001', '11', '科佳', '1', '2018-06-29 09:21:03', '2018-06-29 09:21:05', 'kj00101', '1', 'ck', '2018-06-29 09:21:11', 'ck', '2018-06-29 09:21:17');

-- ----------------------------
-- Table structure for equipment_attribute
-- ----------------------------
DROP TABLE IF EXISTS `equipment_attribute`;
CREATE TABLE `equipment_attribute` (
  `agreement_id` varchar(10) NOT NULL,
  `operation_code` int(20) NOT NULL,
  `attribute` varchar(60) NOT NULL,
  `default_value` varchar(20) DEFAULT NULL,
  `create_user` varchar(10) NOT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(10) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`agreement_id`,`operation_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment_attribute
-- ----------------------------
INSERT INTO `equipment_attribute` VALUES ('07', '1', 'ammeterID', '', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '2', 'communicateStatus', '1', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '3', 'workStatus', '2', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '4', 'phaseACurrent', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '5', 'phaseBCurrent', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '6', 'phaseCCurrent', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '7', 'phaseAVoltage', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '8', 'phaseBVoltage', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '9', 'phaseCVoltage', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '10', 'phaseAPower', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '11', 'phaseBPower', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '12', 'phaseCPower', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('07', '13', 'lastRequestDTTM', '-', 'ck', '2018-05-15 09:22:15', 'ck', '2018-05-15 09:22:18');
INSERT INTO `equipment_attribute` VALUES ('07', '14', 'enabled', '-', 'ck', '2018-05-16 15:03:21', 'ck', '2018-05-16 15:03:27');
INSERT INTO `equipment_attribute` VALUES ('07', '15', 'ammeterNo', '0.0', 'ck', '2018-05-16 15:03:49', 'ck', '2018-05-16 15:03:55');
INSERT INTO `equipment_attribute` VALUES ('97', '1', 'ammeterID', null, 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '2', 'communicateStatus', '1', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '3', 'workStatus', '2', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '4', 'phaseACurrent', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '5', 'phaseBCurrent', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '6', 'phaseCCurrent', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '7', 'phaseAVoltage', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '8', 'phaseBVoltage', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '9', 'phaseCVoltage', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '10', 'phaseAPower', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '11', 'phaseBPower', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '12', 'phaseCPower', '-', 'ck', '2018-05-14 11:57:43', 'ck', '2018-05-14 11:57:48');
INSERT INTO `equipment_attribute` VALUES ('97', '13', 'lastRequestDTTM', '-', 'ck', '2018-05-15 09:21:41', 'ck', '2018-05-15 09:21:48');
INSERT INTO `equipment_attribute` VALUES ('97', '14', 'enabled', '-', 'ck', '2018-05-16 15:02:21', 'ck', '2018-05-16 15:02:27');
INSERT INTO `equipment_attribute` VALUES ('97', '15', 'ammeterNo', '-', 'ck', '2018-05-16 15:02:55', 'ck', '2018-05-16 15:03:00');

-- ----------------------------
-- Table structure for equipment_type
-- ----------------------------
DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE `equipment_type` (
  `equipment_type` bigint(4) NOT NULL COMMENT '设备类型ID',
  `equipment_type_name` varchar(16) DEFAULT NULL COMMENT '设备类型名称',
  `create_user` varchar(10) DEFAULT NULL COMMENT '创建者',
  `create_dttm` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(10) DEFAULT NULL COMMENT '更新者',
  `update_dttm` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`equipment_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备类型表';

-- ----------------------------
-- Records of equipment_type
-- ----------------------------
INSERT INTO `equipment_type` VALUES ('0', '请选择', 'admin', '2018-07-10 11:04:21', 'admin', '2018-07-10 11:04:29');
INSERT INTO `equipment_type` VALUES ('1', '直流设备', 'admin', '2018-07-11 09:44:55', 'admin', '2018-07-11 09:45:01');
INSERT INTO `equipment_type` VALUES ('2', '交流设备', 'admin', '2018-07-11 09:45:47', 'admin', '2018-07-11 09:46:05');
INSERT INTO `equipment_type` VALUES ('3', '交直流一体设备', 'admin', '2018-07-11 09:45:50', 'admin', '2018-07-11 09:46:08');
INSERT INTO `equipment_type` VALUES ('4', '无线设备', 'admin', '2018-07-11 09:45:53', 'admin', '2018-07-11 09:46:11');
INSERT INTO `equipment_type` VALUES ('5', '其他', 'admin', '2018-07-11 09:45:55', 'admin', '2018-07-11 09:46:14');

-- ----------------------------
-- Table structure for event_record
-- ----------------------------
DROP TABLE IF EXISTS `event_record`;
CREATE TABLE `event_record` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `event` varchar(255) DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `event_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_record
-- ----------------------------
INSERT INTO `event_record` VALUES ('1', '异常记录', 'chargingRecord', '2018-04-18 18:05:56');
INSERT INTO `event_record` VALUES ('2', '充电桩故障', 'realTime', '2018-04-10 18:06:25');

-- ----------------------------
-- Table structure for event_type
-- ----------------------------
DROP TABLE IF EXISTS `event_type`;
CREATE TABLE `event_type` (
  `event_type` varchar(255) NOT NULL DEFAULT '',
  `event_type_name` varchar(255) DEFAULT NULL,
  `event_description` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_type
-- ----------------------------
INSERT INTO `event_type` VALUES ('chargingRecord', '充电记录', '产生异常记录', '2018-04-19 18:06:51', 'ck', '2018-04-19 18:06:57', 'ck');
INSERT INTO `event_type` VALUES ('realTime', '实时状态', '实时故障', '2018-04-18 18:06:18', 'ck', '2018-04-18 18:06:18', 'ck');

-- ----------------------------
-- Table structure for history_data
-- ----------------------------
DROP TABLE IF EXISTS `history_data`;
CREATE TABLE `history_data` (
  `history_id` varchar(255) CHARACTER SET latin1 NOT NULL,
  `instructions_name` varchar(255) DEFAULT NULL COMMENT '指令名称',
  `is_enable` int(1) DEFAULT NULL COMMENT '是否启用 0否；1启用',
  `is_flang_kj` int(1) DEFAULT NULL COMMENT '科佳是否同步 0否；1是',
  `is_flang_cust` int(1) DEFAULT NULL COMMENT '客户是否同步 0否；1是',
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history_data
-- ----------------------------
INSERT INTO `history_data` VALUES ('1', '充电记录', '1', '0', '1');

-- ----------------------------
-- Table structure for info_massge
-- ----------------------------
DROP TABLE IF EXISTS `info_massge`;
CREATE TABLE `info_massge` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `name_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `shijian` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of info_massge
-- ----------------------------
INSERT INTO `info_massge` VALUES ('1', '1', '1', '2018-07-18 14:12:04');
INSERT INTO `info_massge` VALUES ('111', '11', '111', null);

-- ----------------------------
-- Table structure for log_history
-- ----------------------------
DROP TABLE IF EXISTS `log_history`;
CREATE TABLE `log_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_id` varchar(255) DEFAULT NULL,
  `file_date_start` datetime DEFAULT NULL,
  `file_date_end` datetime DEFAULT NULL,
  `file_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_history
-- ----------------------------
INSERT INTO `log_history` VALUES ('1', 'connectManage', '2018-04-08 17:40:12', '2018-04-08 18:40:16', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('2', 'connectManage', '2018-04-25 16:31:37', '2018-05-03 16:31:40', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('3', 'connectManage', '2018-04-08 17:40:12', '2018-04-08 18:40:16', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('4', 'connectManage', '2018-04-08 17:40:13', '2018-04-08 18:40:17', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('5', 'connectManage', '2018-04-08 17:40:14', '2018-04-08 18:40:18', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('6', 'connectManage', '2018-04-08 17:40:15', '2018-04-08 18:40:19', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('7', 'connectManage', '2018-04-08 17:40:16', '2018-04-08 18:40:20', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('8', 'connectManage', '2018-04-08 17:40:17', '2018-04-08 18:40:21', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('9', 'connectManage', '2018-04-08 17:40:18', '2018-04-08 18:40:22', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('10', 'connectManage', '2018-04-08 17:40:19', '2018-04-08 18:40:23', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('11', 'connectManage', '2018-04-08 17:40:20', '2018-04-08 18:40:24', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('12', 'connectManage', '2018-04-08 17:40:21', '2018-04-08 18:40:25', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('13', 'connectManage', '2018-04-08 17:40:22', '2018-04-08 18:40:26', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('14', 'connectManage', '2018-04-08 17:40:23', '2018-04-08 18:40:27', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('15', 'connectManage', '2018-04-08 17:40:24', '2018-04-08 18:40:28', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('16', 'connectManage', '2018-04-08 17:40:25', '2018-04-08 18:40:29', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('17', 'connectManage', '2018-04-08 17:40:26', '2018-04-08 18:40:30', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('18', 'connectManage', '2018-04-08 17:40:27', '2018-04-08 18:40:31', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('19', 'connectManage', '2018-04-08 17:40:28', '2018-04-08 18:40:32', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('20', 'connectManage', '2018-04-08 17:40:29', '2018-04-08 18:40:33', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('21', 'connectManage', '2018-04-08 17:40:30', '2018-04-08 18:40:34', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('22', 'connectManage', '2018-04-08 17:40:31', '2018-04-08 18:40:35', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('23', 'connectManage', '2018-04-08 17:40:32', '2018-04-08 18:40:36', '/home/temp/logs/redis.txt');
INSERT INTO `log_history` VALUES ('24', 'connectManage', '2018-04-27 14:37:07', '2018-04-27 14:37:07', '/home/temp/logs/connectManage/2018-04-27/9a1acf0a-7353-4fe0-aa6e-ebcacfe5764d.7z');
INSERT INTO `log_history` VALUES ('25', 'logManage', '2018-04-27 19:39:23', '2018-04-27 19:39:23', '/home/temp/logs/logManage/2018-04-27/0a3228c0-4778-46fa-ac64-780bdf883d1d.7z');
INSERT INTO `log_history` VALUES ('26', 'logManage', '2018-04-27 19:43:04', '2018-04-27 19:43:04', '/home/temp/logs/logManage/2018-04-27/e17dc4d7-e7d4-45a8-9d55-aafc070e4e9f.7z');
INSERT INTO `log_history` VALUES ('27', 'logManage', '2018-04-27 19:44:12', '2018-04-27 19:44:12', '/home/temp/logs/logManage/2018-04-27/1e4ac642-3c90-49fe-a461-08d2ace42f0e.7z');
INSERT INTO `log_history` VALUES ('28', 'logManage', '2018-04-27 19:45:15', '2018-04-27 19:45:15', '/home/temp/logs/logManage/2018-04-27/4341723d-9129-48a6-adbd-f9d3985741f5.7z');
INSERT INTO `log_history` VALUES ('29', 'logManage', '2018-04-27 19:46:55', '2018-04-27 19:46:55', '/home/temp/logs/logManage/2018-04-27/2a2ffc19-26d1-4648-b9ea-cdc3d4766256.7z');
INSERT INTO `log_history` VALUES ('30', 'logManage', '2018-04-27 19:48:56', '2018-04-27 19:48:56', '/home/temp/logs/logManage/2018-04-27/495ef70e-e859-4396-ada8-0a2f1391c149.7z');
INSERT INTO `log_history` VALUES ('31', 'connectManage', '2018-04-28 11:56:11', '2018-04-28 11:56:11', '/home/temp/logs/connectManage/2018-04-28/a6c3442f-ed68-4008-82f1-88a6bcd57384.7z');
INSERT INTO `log_history` VALUES ('32', 'connectManage', '2018-04-28 12:01:20', '2018-04-28 12:01:20', '/home/temp/logs/connectManage/2018-04-28/70e14100-213d-4f12-9237-a11994903aa1.7z');
INSERT INTO `log_history` VALUES ('33', 'connectManage', '2018-04-28 12:03:52', '2018-04-28 12:03:52', '/home/temp/logs/connectManage/2018-04-28/b25b1ebb-cb04-4754-90fa-f0b659a7732e.7z');
INSERT INTO `log_history` VALUES ('34', 'connectManage', '2018-04-28 12:20:22', '2018-04-28 12:20:22', '/home/temp/logs/connectManage/2018-04-28/5c023c67-09cc-4b99-a21f-7b63547ebb42.7z');
INSERT INTO `log_history` VALUES ('35', 'connectManage', '2018-04-28 13:30:01', '2018-04-28 13:30:01', '/home/temp/logs/connectManage/2018-04-28/7f54e0e1-5127-4077-8782-b2287fada9ad.7z');
INSERT INTO `log_history` VALUES ('36', 'connectManage', '2018-04-28 13:33:21', '2018-04-28 13:33:21', '/home/temp/logs/connectManage/2018-04-28/fb3eb32d-2a78-401e-a474-4f4fb65725aa.7z');
INSERT INTO `log_history` VALUES ('37', 'connectManage', '2018-04-28 13:34:45', '2018-04-28 13:34:44', '/home/temp/logs/connectManage/2018-04-28/57ce6773-9f57-42e4-b45b-acc299c1a80e.7z');
INSERT INTO `log_history` VALUES ('38', 'chargeAmount', '2018-05-21 16:23:32', '2018-05-21 16:23:32', '/home/temp/logschargeAmount/2018-05-21/c581532d-46a7-4720-876c-17066c39eb86.7z');
INSERT INTO `log_history` VALUES ('39', 'chargeAmount', '2018-05-21 17:30:22', '2018-05-21 17:30:22', '/home/temp/logschargeAmount/2018-05-21/9e5cccb9-a9a4-42da-bff2-6fecaf906cf6.7z');
INSERT INTO `log_history` VALUES ('40', 'chargeAmount', '2018-05-21 17:46:11', '2018-05-21 17:46:11', '/home/temp/logschargeAmount/2018-05-21/526b54a1-3603-4e20-8bb0-d9a04873a760.7z');
INSERT INTO `log_history` VALUES ('41', 'chargeAmount', '2018-05-21 20:12:45', '2018-05-21 20:12:45', '/home/temp/logschargeAmount/2018-05-21/b0b4e55c-df3f-46df-84a8-f9eda46bdc2f.7z');
INSERT INTO `log_history` VALUES ('42', 'chargeAmount', '2018-05-21 20:15:59', '2018-05-21 20:15:59', '/home/temp/logschargeAmount/2018-05-21/695f3737-77d5-429b-975c-3478273b40ac.7z');
INSERT INTO `log_history` VALUES ('43', 'chargeAmount', '2018-05-21 20:21:49', '2018-05-21 20:21:49', '/home/temp/logschargeAmount/2018-05-21/bdfc8970-7555-4e49-ae13-dabb69e09015.7z');
INSERT INTO `log_history` VALUES ('44', 'chargeAmount', '2018-05-21 21:09:27', '2018-05-21 21:09:27', '/home/temp/logschargeAmount/2018-05-21/35c4517a-db16-4388-8c0b-7f2b9e9fb562.7z');
INSERT INTO `log_history` VALUES ('45', 'chargeAmount', '2018-05-23 14:42:38', '2018-05-23 14:42:38', '/home/temp/logschargeAmount/2018-05-23/d45a183e-d5b6-4bdb-a2bc-1d4db962a851.7z');
INSERT INTO `log_history` VALUES ('46', 'chargeAmount', '2018-05-23 14:46:07', '2018-05-23 14:46:07', '/home/temp/logschargeAmount/2018-05-23/ccef116e-fa61-4d44-8b5c-ac9ac85b4f7b.7z');
INSERT INTO `log_history` VALUES ('47', 'chargeAmount', '2018-05-23 14:51:13', '2018-05-23 14:51:13', '/home/temp/logschargeAmount/2018-05-23/b6220326-a735-4530-aea0-316e8c244b12.7z');
INSERT INTO `log_history` VALUES ('48', 'chargeAmount', '2018-05-23 14:53:33', '2018-05-23 14:53:33', '/home/temp/logschargeAmount/2018-05-23/7b809dce-739c-4765-8d54-d2ee1d05bc37.7z');
INSERT INTO `log_history` VALUES ('49', 'chargeAmount', '2018-05-23 15:03:22', '2018-05-23 15:03:22', '/home/temp/logschargeAmount/2018-05-23/40fbad9f-7040-4a4a-aad6-f777500daeed.7z');
INSERT INTO `log_history` VALUES ('50', 'chargeAmount', '2018-05-23 15:05:28', '2018-05-23 15:05:28', '/home/temp/logschargeAmount/2018-05-23/ed305fa0-d036-4d8b-b4b5-478605468b4c.7z');
INSERT INTO `log_history` VALUES ('51', 'chargeAmount', '2018-05-23 15:08:33', '2018-05-23 15:08:33', '/home/temp/logschargeAmount/2018-05-23/e9f4adbc-4e54-43dd-ac81-28ee6b3e033f.7z');
INSERT INTO `log_history` VALUES ('52', 'chargeAmount', '2018-05-23 15:11:23', '2018-05-23 15:11:23', '/home/temp/logschargeAmount/2018-05-23/babfe8c7-2765-4c0c-8519-9f6821c434c8.7z');
INSERT INTO `log_history` VALUES ('53', 'chargeAmount', '2018-05-23 15:15:03', '2018-05-23 15:15:03', '/home/temp/logschargeAmount/2018-05-23/8e5e6c73-708e-4125-a1b6-439182a64f30.7z');
INSERT INTO `log_history` VALUES ('54', 'connectManage', '2018-05-23 15:49:12', '2018-05-23 15:49:12', 'D:\\logconnectManage/2018-05-23/e7ac9893-f10d-412f-8990-51ca4fc16a1d.7z');
INSERT INTO `log_history` VALUES ('55', 'chargeAmount', '2018-05-23 17:11:18', '2018-05-23 17:11:18', '/home/temp/logschargeAmount/2018-05-23/40bba34f-cc86-4f54-b003-0ea76e690544.7z');
INSERT INTO `log_history` VALUES ('56', 'chargeAmount', '2018-05-23 17:56:34', '2018-05-23 17:56:34', '/home/temp/logschargeAmount/2018-05-23/46663eab-9914-4386-97ba-d66796744ff9.7z');
INSERT INTO `log_history` VALUES ('57', 'connectManage', '2018-05-23 19:25:59', '2018-05-23 19:25:59', '/home/temp/logsconnectManage/2018-05-23/c9a75187-0928-46ac-b86f-51162fd06dcb.7z');
INSERT INTO `log_history` VALUES ('58', 'connectManage', '2018-05-23 19:26:59', '2018-05-23 19:26:59', '/home/temp/logsconnectManage/2018-05-23/5d4ff40f-b722-47cb-9b3f-9cfd0060a07f.7z');
INSERT INTO `log_history` VALUES ('59', 'connectManage', '2018-05-23 19:27:59', '2018-05-23 19:27:59', '/home/temp/logsconnectManage/2018-05-23/33a01a5b-11d2-4e52-9276-57608b3a43d7.7z');
INSERT INTO `log_history` VALUES ('60', 'connectManage', '2018-05-23 19:34:58', '2018-05-23 19:34:58', '/home/temp/logsconnectManage/2018-05-23/093eff93-b696-4df7-94dc-c583ace00885.7z');
INSERT INTO `log_history` VALUES ('61', 'connectManage', '2018-05-23 19:36:38', '2018-05-23 19:36:38', '/home/temp/logsconnectManage/2018-05-23/d4b4b3a0-f9a0-4dda-bdac-2afa45b250df.7z');
INSERT INTO `log_history` VALUES ('62', 'connectManage', '2018-05-23 19:42:20', '2018-05-23 19:42:20', '/home/temp/logsconnectManage/2018-05-23/9625d210-1ed9-47c6-8011-c7397a47f6d3.7z');
INSERT INTO `log_history` VALUES ('63', 'connectManage', '2018-05-23 19:43:26', '2018-05-23 19:43:26', '/home/temp/logsconnectManage/2018-05-23/b119bc79-eed7-4c62-bc56-2b9a6505e4fc.7z');
INSERT INTO `log_history` VALUES ('64', 'connectManage', '2018-05-23 19:44:26', '2018-05-23 19:44:26', '/home/temp/logsconnectManage/2018-05-23/cb4ef906-7be2-41fc-8567-65003db72b2e.7z');
INSERT INTO `log_history` VALUES ('65', 'connectManage', '2018-05-23 19:45:26', '2018-05-23 19:45:26', '/home/temp/logsconnectManage/2018-05-23/773fabc5-c40f-466d-9385-65f84613c79e.7z');
INSERT INTO `log_history` VALUES ('66', 'connectManage', '2018-05-23 20:10:24', '2018-05-23 20:10:19', '/home/temp/logsconnectManage/2018-05-23/f62d000c-c803-4aaf-b20d-6a19fcbba29c.7z');
INSERT INTO `log_history` VALUES ('67', 'connectManage', '2018-05-23 20:11:29', '2018-05-23 20:11:29', '/home/temp/logsconnectManage/2018-05-23/e24491b6-51c1-4646-803a-2ad63c2fa254.7z');
INSERT INTO `log_history` VALUES ('68', 'connectManage', '2018-05-23 20:12:34', '2018-05-23 20:12:34', '/home/temp/logsconnectManage/2018-05-23/dc27053e-8595-47fc-963e-9a35d12082aa.7z');
INSERT INTO `log_history` VALUES ('69', 'connectManage', '2018-05-23 20:13:42', '2018-05-23 20:13:30', '/home/temp/logsconnectManage/2018-05-23/e6f67287-7428-4010-b447-817b7199784a.7z');
INSERT INTO `log_history` VALUES ('70', 'connectManage', '2018-05-23 20:14:54', '2018-05-23 20:14:54', '/home/temp/logsconnectManage/2018-05-23/28b38096-ca1e-4331-a245-2f94095d0265.7z');
INSERT INTO `log_history` VALUES ('71', 'chargeAmount', '2018-05-24 09:15:54', '2018-05-24 09:15:54', '/home/temp/logschargeAmount/2018-05-24/789eb2aa-ce2c-4933-ac31-b18d183caabf.7z');
INSERT INTO `log_history` VALUES ('72', 'chargeAmount', '2018-05-24 09:22:01', '2018-05-24 09:22:01', '/home/temp/logschargeAmount/2018-05-24/82d22340-a5a0-44aa-b178-d28387428494.7z');
INSERT INTO `log_history` VALUES ('73', 'chargeAmount', '2018-05-24 10:35:03', '2018-05-24 10:35:03', '/home/temp/logschargeAmount/2018-05-24/992f3127-bb31-43ac-b756-11c6da84c42f.7z');
INSERT INTO `log_history` VALUES ('74', 'chargeAmount', '2018-05-24 10:37:03', '2018-05-24 10:37:03', '/home/temp/logschargeAmount/2018-05-24/6acd655a-da6f-4a27-9e15-ca8de7f6076d.7z');
INSERT INTO `log_history` VALUES ('75', 'connectManage', '2018-05-30 11:16:38', '2018-05-30 11:16:38', '/home/temp/logsconnectManage/2018-05-30/83e47977-f914-4b9b-96b9-3b2bf84d7181.7z');
INSERT INTO `log_history` VALUES ('76', 'connectManage', '2018-05-30 11:17:38', '2018-05-30 11:17:38', '/home/temp/logsconnectManage/2018-05-30/74e5aafd-8b6a-445f-98bc-c4866cf2c8b9.7z');
INSERT INTO `log_history` VALUES ('77', 'connectManage', '2018-05-30 11:18:39', '2018-05-30 11:18:39', '/home/temp/logsconnectManage/2018-05-30/9602332c-f489-4d84-8c2f-14274cdd6a23.7z');
INSERT INTO `log_history` VALUES ('78', 'connectManage', '2018-05-30 11:19:39', '2018-05-30 11:19:39', '/home/temp/logsconnectManage/2018-05-30/5775bae4-9c4a-45a2-b8b5-66d93d1544f9.7z');
INSERT INTO `log_history` VALUES ('79', 'connectManage', '2018-05-30 11:20:39', '2018-05-30 11:20:39', '/home/temp/logsconnectManage/2018-05-30/5f407e92-3c75-455e-941d-444d0dcc2b99.7z');
INSERT INTO `log_history` VALUES ('80', 'connectManage', '2018-05-30 11:21:39', '2018-05-30 11:21:39', '/home/temp/logsconnectManage/2018-05-30/4d518f77-d370-496c-afad-75e07eba7154.7z');
INSERT INTO `log_history` VALUES ('81', 'connectManage', '2018-05-30 11:22:39', '2018-05-30 11:22:39', '/home/temp/logsconnectManage/2018-05-30/086d6ab7-5673-4098-b746-243eba7ea6d5.7z');
INSERT INTO `log_history` VALUES ('82', 'connectManage', '2018-05-30 11:23:39', '2018-05-30 11:23:39', '/home/temp/logsconnectManage/2018-05-30/03c54b82-85ff-4479-ba05-363d2cd45c6e.7z');
INSERT INTO `log_history` VALUES ('83', 'connectManage', '2018-05-30 11:24:39', '2018-05-30 11:24:39', '/home/temp/logsconnectManage/2018-05-30/82784f74-d8e8-4e87-a338-094607920094.7z');
INSERT INTO `log_history` VALUES ('84', 'connectManage', '2018-05-30 11:25:40', '2018-05-30 11:25:40', '/home/temp/logsconnectManage/2018-05-30/905dae89-62fa-4d17-904f-93a9bd3e1e2d.7z');
INSERT INTO `log_history` VALUES ('85', 'connectManage', '2018-05-30 11:26:40', '2018-05-30 11:26:40', '/home/temp/logsconnectManage/2018-05-30/2847e782-2801-4e84-9a64-b67c262526d0.7z');

-- ----------------------------
-- Table structure for log_setting
-- ----------------------------
DROP TABLE IF EXISTS `log_setting`;
CREATE TABLE `log_setting` (
  `module_id` varchar(255) NOT NULL DEFAULT '',
  `log_flag` int(11) DEFAULT NULL COMMENT '0：存储；1：不存储',
  `store_style` int(11) DEFAULT NULL COMMENT '1:按时间存储，2:按文件大小存储',
  `store_period` int(11) DEFAULT NULL COMMENT '单位：秒',
  `store_file_size` int(11) DEFAULT NULL COMMENT '单位：M',
  `compress_flag` int(11) DEFAULT NULL COMMENT '0:压缩；1：不压缩',
  `compress_style` int(11) DEFAULT NULL COMMENT '0:7z;1:zip;2:tar',
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_setting
-- ----------------------------
INSERT INTO `log_setting` VALUES ('AgreementManage', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:22:12', 'admin', '2018-05-16 09:22:12');
INSERT INTO `log_setting` VALUES ('ammeterAgreement', '0', '1', '86400', '100', '0', '0', 'ck', '2018-06-29 11:41:45', 'ck', '2018-06-29 11:41:47');
INSERT INTO `log_setting` VALUES ('AmmterManage', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:22:29', 'admin', '2018-05-16 09:22:29');
INSERT INTO `log_setting` VALUES ('chargeAmount', '0', '1', '120', null, '0', '0', 'admin', '2018-05-21 15:43:30', 'admin', '2018-05-21 15:43:30');
INSERT INTO `log_setting` VALUES ('ChargeRecordManage', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:22:50', 'admin', '2018-05-16 09:22:50');
INSERT INTO `log_setting` VALUES ('CloudAddressManager', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:23:06', 'admin', '2018-05-16 09:23:06');
INSERT INTO `log_setting` VALUES ('connectManage', '0', '1', '60', '100', '0', '0', 'ck', '2018-04-27 15:43:01', 'ck', '2018-04-27 15:43:08');
INSERT INTO `log_setting` VALUES ('EquipmentManage', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:23:22', 'admin', '2018-05-16 09:23:22');
INSERT INTO `log_setting` VALUES ('Event', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:23:37', 'admin', '2018-05-16 09:23:37');
INSERT INTO `log_setting` VALUES ('logManage', '0', '1', '60', '100', '0', '0', 'ck', '2018-04-27 19:36:26', 'ck', '2018-04-27 19:36:32');
INSERT INTO `log_setting` VALUES ('main', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:23:52', 'admin', '2018-05-16 09:23:52');
INSERT INTO `log_setting` VALUES ('RealTimeManage', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:24:04', 'admin', '2018-05-16 09:24:04');
INSERT INTO `log_setting` VALUES ('SerialConfigManage', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:24:17', 'admin', '2018-05-16 09:24:17');
INSERT INTO `log_setting` VALUES ('TaskManage', '0', '1', '86400', '100', '0', '0', 'admin', '2018-05-16 09:24:32', 'admin', '2018-05-16 09:24:32');

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` varchar(255) NOT NULL DEFAULT '',
  `module_name` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('AgreementManage', '协议管理', 'ck', '2018-05-16 09:11:54');
INSERT INTO `module` VALUES ('ammeterAgreement', '电表协议', 'ck', '2018-06-29 11:41:07');
INSERT INTO `module` VALUES ('AmmterManage', '电表管理', 'ck', '2018-05-16 09:12:16');
INSERT INTO `module` VALUES ('chargeAmount', '计费', 'ck', '2018-05-21 15:38:46');
INSERT INTO `module` VALUES ('ChargeRecordManage', '充电记录', 'ck', '2018-05-02 11:11:52');
INSERT INTO `module` VALUES ('CloudAddressManager', '数据转发', 'ck', '2018-05-02 11:12:49');
INSERT INTO `module` VALUES ('ConnectManage', '连接管理', 'ck', '2018-04-26 15:57:23');
INSERT INTO `module` VALUES ('EquipmentManage', '设备管理', 'ck', '2018-05-02 11:13:18');
INSERT INTO `module` VALUES ('Event', '事件告警', 'ck', '2018-04-27 19:44:42');
INSERT INTO `module` VALUES ('LogManage', '日志管理', 'ck', '2018-04-27 19:36:56');
INSERT INTO `module` VALUES ('main', '主程序', 'ck', '2018-05-02 11:16:05');
INSERT INTO `module` VALUES ('RealTimeManage', '实时状态', 'ck', '2018-05-02 11:16:30');
INSERT INTO `module` VALUES ('SerialConfigManage', '电表配置管理', 'ck', '2018-05-16 09:15:35');
INSERT INTO `module` VALUES ('TaskManage', '定时任务', 'ck', '2018-05-02 11:16:52');

-- ----------------------------
-- Table structure for operator_info
-- ----------------------------
DROP TABLE IF EXISTS `operator_info`;
CREATE TABLE `operator_info` (
  `operator_id` varchar(9) COLLATE utf8_bin NOT NULL COMMENT '运营商ID',
  `operator_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '运营商名称',
  `operator_tel1` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '运营商电话1',
  `operator_tel2` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '运营商电话2',
  `operator_reg_address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '运营商注册地址',
  `operator_note` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `aes_secret` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '第三方加密秘钥',
  `operator_secret` varchar(20) COLLATE utf8_bin NOT NULL COMMENT 'token秘钥',
  `aes_iv` char(16) COLLATE utf8_bin NOT NULL COMMENT '初始化向量',
  `sig_secret` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '签名秘钥',
  PRIMARY KEY (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运营商表';

-- ----------------------------
-- Records of operator_info
-- ----------------------------
INSERT INTO `operator_info` VALUES ('551133697', '隆瑞三优', '18053634463', '18053634463', '北京隆瑞三优', null, 'b8d892605ae27b92', '92c162e274ac4382', 'aab23c44b6a484ff', 'a4da0eb7944f062e');

-- ----------------------------
-- Table structure for operator_info_secret
-- ----------------------------
DROP TABLE IF EXISTS `operator_info_secret`;
CREATE TABLE `operator_info_secret` (
  `operator_id` varchar(9) NOT NULL,
  `aes_secret` varchar(20) DEFAULT NULL,
  `operator_secret` varchar(20) DEFAULT NULL,
  `aes_iv` char(16) DEFAULT NULL,
  `sig_secret` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator_info_secret
-- ----------------------------
INSERT INTO `operator_info_secret` VALUES ('551133697', 'b8d892605ae27b92', '92c162e274ac4382', 'aab23c44b6a484ff', 'a4da0eb7944f062e');

-- ----------------------------
-- Table structure for operator_info_third_party
-- ----------------------------
DROP TABLE IF EXISTS `operator_info_third_party`;
CREATE TABLE `operator_info_third_party` (
  `operator_id` varchar(9) COLLATE utf8_bin NOT NULL COMMENT '运营商ID',
  `operator_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '运营商名称',
  `operator_tel1` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '运营商电话1',
  `operator_tel2` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '运营商电话2',
  `operator_reg_address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '运营商注册地址',
  `operator_note` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `aes_secret` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '第三方加密秘钥',
  `operator_secret` varchar(20) COLLATE utf8_bin NOT NULL COMMENT 'token秘钥',
  `aes_iv` char(16) COLLATE utf8_bin NOT NULL COMMENT '初始化向量',
  `sig_secret` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '签名秘钥',
  PRIMARY KEY (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运营商表';

-- ----------------------------
-- Records of operator_info_third_party
-- ----------------------------
INSERT INTO `operator_info_third_party` VALUES ('551433697', '华商三优优易充', '18053634463', '18053634463', '华商三优优易充', null, 'b8d892605ae27b92', '92c162e274ac4382', 'aab23c44b6a484ff', 'a4da0eb7944f062e');

-- ----------------------------
-- Table structure for periodrule
-- ----------------------------
DROP TABLE IF EXISTS `periodrule`;
CREATE TABLE `periodrule` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RuleID` varchar(10) DEFAULT NULL,
  `PeriodStartDTTM` time DEFAULT NULL,
  `PeriodEndDTTM` time DEFAULT NULL,
  `PeriodStartID` tinyint(1) DEFAULT NULL,
  `PeriodPrice` double DEFAULT NULL,
  `CreateUser` varchar(10) DEFAULT NULL,
  `CreateDTTM` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of periodrule
-- ----------------------------
INSERT INTO `periodrule` VALUES ('1', '1', '00:00:00', '07:00:00', '4', '0.28604', 'ck', '2017-05-03 17:33:31');
INSERT INTO `periodrule` VALUES ('2', '1', '07:00:00', '10:00:00', '3', '0.7151', 'ck', '2017-05-03 17:34:11');
INSERT INTO `periodrule` VALUES ('3', '1', '10:00:00', '15:00:00', '2', '0.7151', 'ck', '2017-05-03 17:34:36');
INSERT INTO `periodrule` VALUES ('4', '1', '15:00:00', '18:00:00', '3', '1.1446', 'ck', '2017-05-03 17:35:06');
INSERT INTO `periodrule` VALUES ('5', '1', '18:00:00', '21:00:00', '2', '1.21567', 'ck', '2017-05-03 17:35:36');
INSERT INTO `periodrule` VALUES ('6', '1', '21:00:00', '23:00:00', '3', '0.7151', 'ck', '2017-05-03 17:36:35');
INSERT INTO `periodrule` VALUES ('7', '1', '23:00:00', '24:00:00', '4', '0.28604', 'ck', '2017-05-03 17:37:29');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`) USING BTREE,
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`) USING BTREE,
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`) USING BTREE,
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`) USING BTREE,
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for real_time
-- ----------------------------
DROP TABLE IF EXISTS `real_time`;
CREATE TABLE `real_time` (
  `equipment_no` varchar(255) NOT NULL COMMENT '设备号',
  `communicate_status` int(1) DEFAULT NULL COMMENT '设备通讯状态',
  `work_status` int(1) DEFAULT NULL COMMENT '设备工作状态',
  `charging_gun_status` int(1) DEFAULT NULL COMMENT '枪连接状态',
  `output_voltage` double(10,0) DEFAULT NULL COMMENT '输出电压',
  `output_current` double(10,0) DEFAULT NULL COMMENT '输出电流',
  `output_power` double(10,0) DEFAULT NULL COMMENT '输出功率',
  `ammeter_no` double(10,0) DEFAULT NULL COMMENT '电表数',
  `current_soc` double(10,0) DEFAULT NULL COMMENT 'SOC',
  `fault_status` int(1) DEFAULT NULL COMMENT '故障状态',
  `fault_desc` varchar(255) DEFAULT NULL COMMENT '故障描述',
  `start_charging_dttm` datetime DEFAULT NULL COMMENT '开始充电时间',
  `charged_time` varchar(255) DEFAULT NULL COMMENT '充电时间',
  `start_charging_ammeter_no` double(10,0) DEFAULT NULL COMMENT '开始电表数',
  `hardware_version` varchar(255) DEFAULT NULL COMMENT '硬件版本',
  `software_version` varchar(255) DEFAULT NULL COMMENT '软件版本',
  `charged_kwh` double(10,0) DEFAULT NULL COMMENT '已充电量',
  PRIMARY KEY (`equipment_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of real_time
-- ----------------------------
INSERT INTO `real_time` VALUES ('003', '1', '1', '1', '1', '1', '1', '1', '89', '1', '折了', '2018-04-19 00:00:00', '23分15秒', '36524', '0.3.6(20180226)', '0.3.6(20180226)', '36');
INSERT INTO `real_time` VALUES ('004', '0', '0', '0', '0', '0', '0', '0', '89', '0', '折了', '2018-04-26 00:00:00', '23分15秒', '36524', '0.3.6(20180226)', '0.3.6(20180226)', '36');

-- ----------------------------
-- Table structure for redis_address
-- ----------------------------
DROP TABLE IF EXISTS `redis_address`;
CREATE TABLE `redis_address` (
  `id` int(10) NOT NULL DEFAULT '0',
  `redis_ip` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `redis_port` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of redis_address
-- ----------------------------

-- ----------------------------
-- Table structure for serial_config
-- ----------------------------
DROP TABLE IF EXISTS `serial_config`;
CREATE TABLE `serial_config` (
  `serial_name` varchar(255) NOT NULL DEFAULT '' COMMENT '串口号',
  `serial_baud_rate` int(11) DEFAULT NULL COMMENT '串口校验位',
  `serial_checkout_id` tinyint(1) DEFAULT NULL COMMENT '波特率',
  `create_dttm` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`serial_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serial_config
-- ----------------------------
INSERT INTO `serial_config` VALUES ('COM2', '2400', '2', '2018-05-24 15:18:15', 'admin', null, null);

-- ----------------------------
-- Table structure for station_status
-- ----------------------------
DROP TABLE IF EXISTS `station_status`;
CREATE TABLE `station_status` (
  `station_status` int(4) NOT NULL COMMENT '站点状态ID',
  `station_status_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '站点状态名称',
  `create_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_dttm` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_dttm` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`station_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='站点状态表';

-- ----------------------------
-- Records of station_status
-- ----------------------------
INSERT INTO `station_status` VALUES ('11', '11', '111', '2017-03-02 15:22:22', 'admin', '2018-07-18 17:32:59');

-- ----------------------------
-- Table structure for station_type
-- ----------------------------
DROP TABLE IF EXISTS `station_type`;
CREATE TABLE `station_type` (
  `station_type` int(4) NOT NULL COMMENT '站点类型ID',
  `station_type_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '站点类型名称',
  `create_user` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_dttm` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_dttm` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`station_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='站点类型表';

-- ----------------------------
-- Records of station_type
-- ----------------------------
INSERT INTO `station_type` VALUES ('222', '111', '111', '2017-03-02 15:22:22', '111', '2017-03-02 15:22:22');
INSERT INTO `station_type` VALUES ('555', '555', 'admin', '2018-07-18 18:31:20', 'admin', '2018-07-18 18:31:20');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `timed_task_id` varchar(255) NOT NULL,
  `timed_task_name` varchar(255) DEFAULT NULL,
  `last_execu_time` datetime DEFAULT NULL COMMENT '上次执行',
  `next_execu_time` datetime DEFAULT NULL COMMENT '下次执行',
  `start_time` datetime DEFAULT NULL,
  `stop_time` datetime DEFAULT NULL,
  `task_method` varchar(255) DEFAULT NULL COMMENT '任务方法',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  `execu_count` int(10) DEFAULT NULL COMMENT '执行次数',
  `fail_count` int(10) DEFAULT NULL COMMENT '失败次数',
  `miss_count` int(10) DEFAULT NULL COMMENT '错过次数',
  `execu_cycle` int(10) DEFAULT NULL COMMENT '执行周期',
  `cycle` int(1) DEFAULT NULL COMMENT '周期  0：一次性；1：周期性',
  `task_status` int(1) DEFAULT NULL COMMENT '任务状态：0已禁用；1：已删除； 2：已过期； 3：等待中; 4:运行中',
  `create_user_id` varchar(255) DEFAULT NULL,
  `creadate` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `job_group_name` varchar(255) DEFAULT NULL COMMENT '分组',
  `method` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`timed_task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('180607205714805', '请求命令', null, null, null, null, 'com.mogateway.quartzJob.ExecutJob', '0/2 * * * * ?', null, null, null, null, null, '1', null, '2018-06-07 20:57:14', null, null, '180607205714841', 'http://localhost:8078/requestHomePolling');

-- ----------------------------
-- Table structure for tcp_config
-- ----------------------------
DROP TABLE IF EXISTS `tcp_config`;
CREATE TABLE `tcp_config` (
  `tcp_port` int(11) NOT NULL COMMENT '端口',
  `create_user` varchar(255) DEFAULT NULL,
  `create_dttm` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`tcp_port`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcp_config
-- ----------------------------
INSERT INTO `tcp_config` VALUES ('6001', 'ck', '2018-06-05 11:28:29', 'ck', '2018-06-05 11:28:29');

-- ----------------------------
-- Table structure for tcp_key
-- ----------------------------
DROP TABLE IF EXISTS `tcp_key`;
CREATE TABLE `tcp_key` (
  `tcp_id` varchar(255) NOT NULL,
  `tcp_key` varchar(255) DEFAULT NULL,
  `tcp_data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tcp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcp_key
-- ----------------------------
