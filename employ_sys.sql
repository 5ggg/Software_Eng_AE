CREATE DATABASE IF NOT EXISTS `employ_sys` default charset utf8 COLLATE utf8_general_ci;

USE `employ_sys`;
drop TABLE if EXISTS `admin_info`;
CREATE TABLE IF NOT EXISTS `admin_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `name` varchar(255) DEFAULT NULL COMMENT 'name',
 `pass_word` varchar(255) DEFAULT NULL COMMENT 'password',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Administrator';


drop TABLE if EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `name` varchar(255) DEFAULT NULL COMMENT 'name',
 `pass_word` varchar(255) DEFAULT NULL COMMENT 'password',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Teacher';


drop TABLE if EXISTS `ppt_director`;
CREATE TABLE IF NOT EXISTS `ppt_director` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `name` varchar(255) DEFAULT NULL COMMENT 'name',
 `pass_word` varchar(255) DEFAULT NULL COMMENT 'password',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PTT Director';


drop TABLE if EXISTS `class_director`;
CREATE TABLE IF NOT EXISTS `class_director` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `name` varchar(255) DEFAULT NULL COMMENT 'name',
 `pass_word` varchar(255) DEFAULT NULL COMMENT 'password',
 `class_id` int(11) DEFAULT NULL COMMENT 'Class',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Class Director';


drop TABLE if EXISTS `teaching_request`;
CREATE TABLE IF NOT EXISTS `teaching_request` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `subject_id` int(11) DEFAULT NULL COMMENT 'Subject id',
 `subject_name` varchar(255) DEFAULT NULL COMMENT 'Subject name',
 `semester_id` int(11) DEFAULT NULL COMMENT 'Semester id',
 `semester_name` varchar(255) DEFAULT NULL COMMENT 'Semester',
 `teaher_id` int(11) DEFAULT NULL COMMENT 'Request Teacher ID',
 `teach_desc` varchar(1000) DEFAULT NULL COMMENT 'Teaching content',
 `check_status` int(11) DEFAULT NULL COMMENT 'check status',
 `check_remark` varchar(255) DEFAULT NULL COMMENT 'check remark',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Teaching Request';


drop TABLE if EXISTS `semester_info`;
CREATE TABLE IF NOT EXISTS `semester_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `name` varchar(255) DEFAULT NULL COMMENT 'semester name',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='semester';


drop TABLE if EXISTS `subject_info`;
CREATE TABLE IF NOT EXISTS `subject_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `name` varchar(255) DEFAULT NULL COMMENT 'subject name',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='subject';


drop TABLE if EXISTS `class_info`;
CREATE TABLE IF NOT EXISTS `class_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `name` varchar(255) DEFAULT NULL COMMENT 'class name',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='class';


drop TABLE if EXISTS `teaching_requirement`;
CREATE TABLE IF NOT EXISTS `teaching_requirement` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `semester_id` int(11) DEFAULT NULL COMMENT 'semester id',
 `semester_name` varchar(255) DEFAULT NULL COMMENT 'semester',
 `subject_id` int(11) DEFAULT NULL COMMENT 'subject id',
 `subject_name` varchar(255) DEFAULT NULL COMMENT 'subject',
 `manage_id` int(11) DEFAULT NULL COMMENT 'class director',
 `class_id` int(11) DEFAULT NULL COMMENT 'class',
 `required_remark` varchar(1000) DEFAULT NULL COMMENT 'requirement remark',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='teaching requirement';


drop TABLE if EXISTS `match_info`;
CREATE TABLE IF NOT EXISTS `match_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key id',
 `require_id` int(11) DEFAULT NULL COMMENT 'requirement',
 `request_id` int(11) DEFAULT NULL COMMENT 'teaching request',
 `teacher_id` int(11) DEFAULT NULL COMMENT 'teacher',
 `class_id` int(11) DEFAULT NULL COMMENT 'class id',
 `manage_id` int(11) DEFAULT NULL COMMENT 'class director',
 `semester_id` int(11) DEFAULT NULL COMMENT 'semester',
 `create_time` varchar(30) DEFAULT NULL COMMENT 'Creation time',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Requirement-request match';



INSERT INTO `employ_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('1','admin','123','2020-02-26 07:51:35');
INSERT INTO `employ_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('2','admin1','123','2020-03-03 04:51:35');
INSERT INTO `employ_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('3','admin2','123','2020-03-03 19:51:35');
INSERT INTO `employ_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('4','admin3','123','2020-02-27 02:51:35');
INSERT INTO `employ_sys`.`admin_info` (`id`,`name`,`pass_word`,`create_time`)  VALUES('5','admin4','123','2020-02-14 00:51:35');
INSERT INTO `employ_sys`.`teacher` (`id`,`name`,`pass_word`,`create_time`)  VALUES('1','teacher','123','2020-03-02 05:51:35');
INSERT INTO `employ_sys`.`teacher` (`id`,`name`,`pass_word`,`create_time`)  VALUES('2','teacher1','123','2020-03-02 10:51:35');
INSERT INTO `employ_sys`.`teacher` (`id`,`name`,`pass_word`,`create_time`)  VALUES('3','teacher2','123','2020-02-25 16:51:35');
INSERT INTO `employ_sys`.`teacher` (`id`,`name`,`pass_word`,`create_time`)  VALUES('4','teacher3','123','2020-02-26 05:51:35');
INSERT INTO `employ_sys`.`teacher` (`id`,`name`,`pass_word`,`create_time`)  VALUES('5','teacher4','123','2020-02-29 20:51:35');
INSERT INTO `employ_sys`.`ppt_director` (`id`,`name`,`pass_word`,`create_time`)  VALUES('1','ppt','123','2020-02-04 22:51:35');
INSERT INTO `employ_sys`.`ppt_director` (`id`,`name`,`pass_word`,`create_time`)  VALUES('2','ppt1','123','2020-02-07 02:51:35');
INSERT INTO `employ_sys`.`ppt_director` (`id`,`name`,`pass_word`,`create_time`)  VALUES('3','ppt2','123','2020-02-05 19:51:35');
INSERT INTO `employ_sys`.`ppt_director` (`id`,`name`,`pass_word`,`create_time`)  VALUES('4','ppt3','123','2020-03-04 09:51:35');
INSERT INTO `employ_sys`.`ppt_director` (`id`,`name`,`pass_word`,`create_time`)  VALUES('5','ppt4','123','2020-02-11 08:51:35');
INSERT INTO `employ_sys`.`class_director` (`id`,`name`,`pass_word`,`class_id`,`create_time`)  VALUES('1','class_direct','123','1','2020-02-03 14:51:35');
INSERT INTO `employ_sys`.`class_director` (`id`,`name`,`pass_word`,`class_id`,`create_time`)  VALUES('2','class_direct1','123','1','2020-02-09 22:51:35');
INSERT INTO `employ_sys`.`class_director` (`id`,`name`,`pass_word`,`class_id`,`create_time`)  VALUES('3','class_direct2','123','2','2020-02-28 10:51:35');
INSERT INTO `employ_sys`.`class_director` (`id`,`name`,`pass_word`,`class_id`,`create_time`)  VALUES('4','class_direct3','123','4','2020-02-29 00:51:35');
INSERT INTO `employ_sys`.`class_director` (`id`,`name`,`pass_word`,`class_id`,`create_time`)  VALUES('5','class_direct4','123','5','2020-03-04 10:51:35');
INSERT INTO `employ_sys`.`teaching_request` (`id`,`subject_id`,`subject_name`,`semester_id`,`semester_name`,`teaher_id`,`teach_desc`,`check_status`,`check_remark`,`create_time`)  VALUES('1','3','Subject 2','4','Semester 3','5','Teaching subject 0','1','check remark 0','2020-03-04 03:51:35');
INSERT INTO `employ_sys`.`teaching_request` (`id`,`subject_id`,`subject_name`,`semester_id`,`semester_name`,`teaher_id`,`teach_desc`,`check_status`,`check_remark`,`create_time`)  VALUES('2','3','Subject 2','5','Semester 4','5','Teaching subject 1','3','check remark 1','2020-02-23 01:51:35');
INSERT INTO `employ_sys`.`teaching_request` (`id`,`subject_id`,`subject_name`,`semester_id`,`semester_name`,`teaher_id`,`teach_desc`,`check_status`,`check_remark`,`create_time`)  VALUES('3','3','Subject 2','3','Semester 2','2','Teaching subject 2','1','check remark 2','2020-02-27 14:51:35');
INSERT INTO `employ_sys`.`teaching_request` (`id`,`subject_id`,`subject_name`,`semester_id`,`semester_name`,`teaher_id`,`teach_desc`,`check_status`,`check_remark`,`create_time`)  VALUES('4','4','Subject 3','5','Semester 4','4','Teaching subject 3','1','check remark 3','2020-02-09 04:51:35');
INSERT INTO `employ_sys`.`teaching_request` (`id`,`subject_id`,`subject_name`,`semester_id`,`semester_name`,`teaher_id`,`teach_desc`,`check_status`,`check_remark`,`create_time`)  VALUES('5','5','Subject 4','4','Semester 3','4','Teaching subject 4','2','check remark 4','2020-02-11 06:51:35');
INSERT INTO `employ_sys`.`semester_info` (`id`,`name`,`create_time`)  VALUES('1','Semester 0','2020-02-26 13:51:35');
INSERT INTO `employ_sys`.`semester_info` (`id`,`name`,`create_time`)  VALUES('2','Semester 1','2020-02-23 21:51:35');
INSERT INTO `employ_sys`.`semester_info` (`id`,`name`,`create_time`)  VALUES('3','Semester 2','2020-02-08 14:51:35');
INSERT INTO `employ_sys`.`semester_info` (`id`,`name`,`create_time`)  VALUES('4','Semester 3','2020-02-25 22:51:35');
INSERT INTO `employ_sys`.`semester_info` (`id`,`name`,`create_time`)  VALUES('5','Semester 4','2020-02-15 11:51:35');
INSERT INTO `employ_sys`.`subject_info` (`id`,`name`,`create_time`)  VALUES('1','Subject 0','2020-02-12 19:51:35');
INSERT INTO `employ_sys`.`subject_info` (`id`,`name`,`create_time`)  VALUES('2','Subject 1','2020-02-23 22:51:35');
INSERT INTO `employ_sys`.`subject_info` (`id`,`name`,`create_time`)  VALUES('3','Subject 2','2020-02-11 03:51:35');
INSERT INTO `employ_sys`.`subject_info` (`id`,`name`,`create_time`)  VALUES('4','Subject 3','2020-02-10 03:51:35');
INSERT INTO `employ_sys`.`subject_info` (`id`,`name`,`create_time`)  VALUES('5','Subject 4','2020-02-13 07:51:35');
INSERT INTO `employ_sys`.`class_info` (`id`,`name`,`create_time`)  VALUES('1','Class 0','2020-02-12 09:51:35');
INSERT INTO `employ_sys`.`class_info` (`id`,`name`,`create_time`)  VALUES('2','Class 1','2020-02-04 10:51:35');
INSERT INTO `employ_sys`.`class_info` (`id`,`name`,`create_time`)  VALUES('3','Class 2','2020-02-21 17:51:35');
INSERT INTO `employ_sys`.`class_info` (`id`,`name`,`create_time`)  VALUES('4','Class 3','2020-02-07 13:51:35');
INSERT INTO `employ_sys`.`class_info` (`id`,`name`,`create_time`)  VALUES('5','Class 4','2020-02-14 18:51:35');
INSERT INTO `employ_sys`.`teaching_requirement` (`id`,`semester_id`,`semester_name`,`subject_id`,`subject_name`,`manage_id`,`class_id`,`required_remark`,`create_time`)  VALUES('1','3','Semester 2','3','Subject 2','2','1','requirement remark 0','2020-02-18 03:51:35');
INSERT INTO `employ_sys`.`teaching_requirement` (`id`,`semester_id`,`semester_name`,`subject_id`,`subject_name`,`manage_id`,`class_id`,`required_remark`,`create_time`)  VALUES('2','2','Semester 1','5','Subject 4','2','1','requirement remark 1','2020-02-18 08:51:35');
INSERT INTO `employ_sys`.`teaching_requirement` (`id`,`semester_id`,`semester_name`,`subject_id`,`subject_name`,`manage_id`,`class_id`,`required_remark`,`create_time`)  VALUES('3','4','Semester 3','4','Subject 3','4','4','requirement remark 2','2020-02-13 02:51:35');
INSERT INTO `employ_sys`.`teaching_requirement` (`id`,`semester_id`,`semester_name`,`subject_id`,`subject_name`,`manage_id`,`class_id`,`required_remark`,`create_time`)  VALUES('4','1','Semester 0','4','Subject 3','5','5','requirement remark 3','2020-02-13 10:51:35');
INSERT INTO `employ_sys`.`teaching_requirement` (`id`,`semester_id`,`semester_name`,`subject_id`,`subject_name`,`manage_id`,`class_id`,`required_remark`,`create_time`)  VALUES('5','1','Semester 0','2','Subject 1','1','1','requirement remark 4','2020-02-21 20:51:35');
INSERT INTO `employ_sys`.`match_info` (`id`,`require_id`,`request_id`,`teacher_id`,`class_id`,`manage_id`,`semester_id`,`create_time`)  VALUES('1','5','4','4','1','1','1','2020-02-19 19:51:35');
INSERT INTO `employ_sys`.`match_info` (`id`,`require_id`,`request_id`,`teacher_id`,`class_id`,`manage_id`,`semester_id`,`create_time`)  VALUES('2','4','2','5','5','5','1','2020-02-22 06:51:35');
INSERT INTO `employ_sys`.`match_info` (`id`,`require_id`,`request_id`,`teacher_id`,`class_id`,`manage_id`,`semester_id`,`create_time`)  VALUES('3','5','1','5','1','1','1','2020-03-01 17:51:35');
INSERT INTO `employ_sys`.`match_info` (`id`,`require_id`,`request_id`,`teacher_id`,`class_id`,`manage_id`,`semester_id`,`create_time`)  VALUES('4','4','1','5','5','5','1','2020-02-23 18:51:35');
INSERT INTO `employ_sys`.`match_info` (`id`,`require_id`,`request_id`,`teacher_id`,`class_id`,`manage_id`,`semester_id`,`create_time`)  VALUES('5','3','5','4','4','4','4','2020-02-11 09:51:35');