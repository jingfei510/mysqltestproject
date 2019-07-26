/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.27 : Database - mysqltest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mysqltest` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mysqltest`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`cid`,`cname`,`credit`) values (1,'数据库',4),(2,'数学',2),(3,'操作系统',3),(4,'数据结构',4);

/*Table structure for table `sc` */

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `snum` varchar(32) DEFAULT NULL,
  `cid` int(32) DEFAULT NULL,
  `grade` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sc_ibfk_2` (`cid`),
  KEY `sc_ibfk_1` (`snum`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`snum`) REFERENCES `student` (`snum`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `sc` */

insert  into `sc`(`id`,`snum`,`cid`,`grade`) values (18,'03163079',1,80),(19,'03163079',2,89),(20,'03163079',3,85),(21,'03163079',4,75),(22,'03163078',1,63),(23,'03163078',2,86),(24,'03163078',3,82),(25,'03163078',4,76),(26,'03163080',1,96),(27,'03163080',3,80),(28,'03163080',4,63);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `snum` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` enum('男','女') DEFAULT NULL,
  `age` int(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `snum` (`snum`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`snum`) REFERENCES `user` (`snum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`snum`,`name`,`sex`,`age`,`phone`) values (7,'03163079','景飞','男',23,'13891887789'),(8,'03163078','王五','男',25,'13895546665'),(9,'03163080','胡兵','男',24,'15188967789');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `snum` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `snum` (`snum`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`snum`,`username`,`password`) values (2,'03163079','景飞','21232f297a57a5a743894a0e4a801fc3'),(3,'03163078','王五','e10adc3949ba59abbe56e057f20f883e'),(14,'03163080','胡兵','e10adc3949ba59abbe56e057f20f883e'),(15,'123456','bos','21232f297a57a5a743894a0e4a801fc3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
