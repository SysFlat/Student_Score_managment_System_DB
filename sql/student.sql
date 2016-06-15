/*
Navicat MySQL Data Transfer

Source Server         : link
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-15 09:39:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(10) NOT NULL,
  `name` varchar(15) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `academy` varchar(15) DEFAULT NULL,
  `score1` float DEFAULT '0',
  `score2` float DEFAULT NULL,
  `score3` float DEFAULT NULL,
  `averageScore` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1001', 'bkrzs', 'M', 'B', '77', '89.2', '91.8', '86');
INSERT INTO `student` VALUES ('1002', 'vlhjf', 'M', 'B', '70', '57.7', '61.9', '63.2');
INSERT INTO `student` VALUES ('1003', 'khskb', 'M', 'B', '97.8', '92.9', '69.1', '86.6');
INSERT INTO `student` VALUES ('1004', 'edipg', 'M', 'B', '52.6', '50.6', '91.4', '64.87');
INSERT INTO `student` VALUES ('1005', 'xuwdc', 'F', 'B', '96.5', '64.1', '76.7', '79.1');
INSERT INTO `student` VALUES ('1006', 'gpmyg', 'F', 'F', '63.9', '84.9', '80.9', '76.57');
INSERT INTO `student` VALUES ('1007', 'edipg', 'F', 'G', '31.1', '15.8', '86.4', '44.43');
INSERT INTO `student` VALUES ('1008', 'llmvz', 'M', 'C', '53.4', '68.1', '95.2', '72.23');
INSERT INTO `student` VALUES ('1009', 'fxsiz', 'M', 'C', '77.1', '84.3', '91.6', '84.33');
INSERT INTO `student` VALUES ('1010', 'edipg', 'M', 'E', '70.4', '91.7', '70.6', '77.57');
INSERT INTO `student` VALUES ('1011', 'yxzee', 'F', 'D', '68.9', '99.1', '71.5', '79.83');
INSERT INTO `student` VALUES ('1012', 'bthnp', 'F', 'B', '41.5', '84.8', '56.2', '60.83');
INSERT INTO `student` VALUES ('1013', 'nuvbp', 'F', 'E', '96.2', '97', '55.2', '82.8');
INSERT INTO `student` VALUES ('1014', 'ctaof', 'M', 'E', '91.6', '94.8', '97.9', '94.77');
INSERT INTO `student` VALUES ('1015', 'ynwxu', 'F', 'F', '98.6', '50.8', '72.8', '74.07');
INSERT INTO `student` VALUES ('1016', 'xnswo', 'F', 'C', '57', '55', '79.7', '63.9');
INSERT INTO `student` VALUES ('1017', 'eeizj', 'F', 'B', '89.7', '66.6', '86.3', '80.87');
INSERT INTO `student` VALUES ('1018', 'euzme', 'M', 'D', '90.3', '96.9', '92.4', '93.2');
INSERT INTO `student` VALUES ('1019', 'rzkhg', 'F', 'A', '70.2', '97.9', '58.6', '75.57');
INSERT INTO `student` VALUES ('1020', 'bjspw', 'F', 'G', '59.4', '91.1', '52.6', '67.7');
INSERT INTO `student` VALUES ('1021', 'hdopl', 'M', 'B', '60.3', '59.6', '65', '61.63');
INSERT INTO `student` VALUES ('1022', 'bspjv', 'F', 'B', '76.9', '57.2', '69.2', '67.77');
INSERT INTO `student` VALUES ('1023', 'fvcdv', 'M', 'B', '89.8', '70.6', '85.9', '82.1');
INSERT INTO `student` VALUES ('1024', 'dxatd', 'F', 'D', '57.1', '89.4', '71.2', '72.57');
INSERT INTO `student` VALUES ('1025', 'ilamb', 'M', 'D', '55.2', '98.8', '91.7', '81.9');
INSERT INTO `student` VALUES ('1026', 'zmirc', 'M', 'F', '86.3', '86.6', '85.9', '86.27');
INSERT INTO `student` VALUES ('1027', 'qprju', 'F', 'F', '67.3', '95.9', '50', '71.07');
INSERT INTO `student` VALUES ('1028', 'uvrrv', 'F', 'F', '95.5', '84.8', '65.3', '81.87');
INSERT INTO `student` VALUES ('1029', 'vopwc', 'M', 'D', '87.1', '77.1', '74.2', '79.47');
INSERT INTO `student` VALUES ('1030', 'gdpse', 'M', 'A', '83.4', '63.1', '91.3', '79.27');
INSERT INTO `student` VALUES ('1031', 'adwih', 'M', 'B', '56.7', '75.8', '75.9', '69.47');
INSERT INTO `student` VALUES ('1032', 'xzrpj', 'F', 'B', '87.2', '87.3', '78.7', '84.4');
INSERT INTO `student` VALUES ('1033', 'ddsxa', 'M', 'D', '54.3', '57.5', '89.8', '67.2');
INSERT INTO `student` VALUES ('1034', 'xhmoq', 'F', 'E', '83.9', '82.1', '62.6', '76.2');
INSERT INTO `student` VALUES ('1035', 'ymofn', 'M', 'B', '70.4', '79.8', '77.1', '75.77');
INSERT INTO `student` VALUES ('1036', 'uvaxd', 'M', 'D', '67.5', '83.7', '69.1', '73.43');
INSERT INTO `student` VALUES ('1037', 'bkgcq', 'F', 'E', '65.8', '58', '57.3', '60.37');
INSERT INTO `student` VALUES ('1038', 'ausfj', 'F', 'G', '90.3', '72.1', '93.6', '85.33');
INSERT INTO `student` VALUES ('1039', 'szzyx', 'M', 'B', '95.7', '79.7', '62.8', '79.4');
INSERT INTO `student` VALUES ('1040', 'silzk', 'F', 'E', '93.4', '72.3', '91', '85.57');
INSERT INTO `student` VALUES ('1041', 'opywq', 'F', 'G', '70.5', '56.7', '95.8', '74.33');
INSERT INTO `student` VALUES ('1042', 'lkhov', 'F', 'B', '92.9', '73.5', '70.2', '78.87');
INSERT INTO `student` VALUES ('1043', 'isxov', 'F', 'F', '69', '92.3', '55.1', '72.13');
INSERT INTO `student` VALUES ('1044', 'tkedm', 'F', 'F', '62.4', '84.3', '90.9', '79.2');
INSERT INTO `student` VALUES ('1045', 'hnhzf', 'M', 'C', '79.9', '93.3', '87.3', '86.83');
INSERT INTO `student` VALUES ('1046', 'qfviv', 'M', 'C', '54.5', '64.3', '61.3', '60.03');
INSERT INTO `student` VALUES ('1047', 'cedxt', 'M', 'B', '92.4', '73.8', '67.7', '77.97');
INSERT INTO `student` VALUES ('1048', 'xoyxk', 'F', 'G', '92.8', '88.3', '52.9', '78');
INSERT INTO `student` VALUES ('1049', 'aeqyi', 'F', 'C', '89.5', '70.1', '75.7', '78.43');
INSERT INTO `student` VALUES ('1050', 'ehwwg', 'M', 'B', '92.7', '77.3', '62', '77.33');
