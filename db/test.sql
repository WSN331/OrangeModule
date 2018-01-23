/*
SQLyog v10.2 
MySQL - 5.6.15 : Database - orange_module
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orange_module` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `orange_module`;

/*Table structure for table `d_air_quality` */

DROP TABLE IF EXISTS `d_air_quality`;

CREATE TABLE `d_air_quality` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_PM25` float DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_DEVICE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `d_air_quality` */

insert  into `d_air_quality`(`C_ID`,`C_PM25`,`C_CREATE_TIME`,`C_USER_ID`,`C_DEVICE_ID`) values (1,10.1,'2017-10-10 09:12:12',1,1);

/*Table structure for table `d_formaldehyde` */

DROP TABLE IF EXISTS `d_formaldehyde`;

CREATE TABLE `d_formaldehyde` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_FORMALDEHYDE` float DEFAULT NULL,
  `C_INDOOR_TEMPERATURE` float DEFAULT NULL,
  `C_OUTDOOR_TEMPERATURE` float DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_DEVICE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `d_formaldehyde` */

/*Table structure for table `d_frame` */

DROP TABLE IF EXISTS `d_frame`;

CREATE TABLE `d_frame` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_ELECTRIC_QUANTITY` float DEFAULT NULL,
  `C_VOLTAGE` float DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_DEVICE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `d_frame` */

/*Table structure for table `d_u_disk` */

DROP TABLE IF EXISTS `d_u_disk`;

CREATE TABLE `d_u_disk` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_SPACE` float DEFAULT NULL,
  `C_USED_SPACE` float DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_DEVICE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `d_u_disk` */

/*Table structure for table `d_water_quality` */

DROP TABLE IF EXISTS `d_water_quality`;

CREATE TABLE `d_water_quality` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_TDS` float DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_DEVICE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `d_water_quality` */

insert  into `d_water_quality`(`C_ID`,`C_TDS`,`C_CREATE_TIME`,`C_USER_ID`,`C_DEVICE_ID`) values (1,10.2,'2017-10-10 09:12:13',1,3);

/*Table structure for table `t_config` */

DROP TABLE IF EXISTS `t_config`;

CREATE TABLE `t_config` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_NAME` varchar(50) DEFAULT NULL,
  `C_KEY` varchar(50) DEFAULT NULL,
  `C_VALUE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_config` */

insert  into `t_config`(`C_ID`,`C_NAME`,`C_KEY`,`C_VALUE`) values (1,'WWW的根路径','www_root','/home/www'),(2,'windows下www的根路径','www_root_win','E:/www');

/*Table structure for table `t_device` */

DROP TABLE IF EXISTS `t_device`;

CREATE TABLE `t_device` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_CODE` varchar(50) DEFAULT NULL,
  `C_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_device` */

insert  into `t_device`(`C_ID`,`C_CODE`,`C_NAME`) values (1,'airQuality','空气质量'),(2,'uDisk','U盘'),(3,'waterQuality','水质量'),(4,'formaldehyde','甲醛'),(5,'frame','框架');

/*Table structure for table `t_shopping_car` */

DROP TABLE IF EXISTS `t_shopping_car`;

CREATE TABLE `t_shopping_car` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_TRADE_ID` int(11) DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_PRICE` float DEFAULT NULL,
  `C_COUNT` int(11) DEFAULT NULL,
  `C_SUM_PRICE` float DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_shopping_car` */

/*Table structure for table `t_trade` */

DROP TABLE IF EXISTS `t_trade`;

CREATE TABLE `t_trade` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_CODE` varchar(50) DEFAULT NULL,
  `C_DEVICE_ID` int(11) DEFAULT NULL,
  `C_NAME` varchar(50) DEFAULT NULL,
  `C_INTRODUCE` text,
  `C_PRICE` float DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_trade` */

insert  into `t_trade`(`C_ID`,`C_CODE`,`C_DEVICE_ID`,`C_NAME`,`C_INTRODUCE`,`C_PRICE`) values (1,'123456',1,'xxx','吃不吃vjhn',NULL),(2,'234567',1,'yyy','ghj',NULL);

/*Table structure for table `t_trade_order` */

DROP TABLE IF EXISTS `t_trade_order`;

CREATE TABLE `t_trade_order` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_CODE` varchar(50) DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_ADDRESS` varchar(50) DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_RECEIVE` int(11) DEFAULT NULL,
  `C_PRICE` float DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_trade_order` */

/*Table structure for table `t_trade_order_single` */

DROP TABLE IF EXISTS `t_trade_order_single`;

CREATE TABLE `t_trade_order_single` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_TRADE_ORDER_ID` varchar(50) DEFAULT NULL,
  `C_TRADE_ID` int(11) DEFAULT NULL,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_PRICE` float DEFAULT NULL,
  `C_COUNT` int(11) DEFAULT NULL,
  `C_SUM_PRICE` float DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_trade_order_single` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_ACCOUNT` varchar(11) DEFAULT NULL,
  `C_NICKNAME` varchar(50) DEFAULT NULL,
  `C_NAME` varchar(50) DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_ICON` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`C_ID`,`C_ACCOUNT`,`C_NICKNAME`,`C_NAME`,`C_CREATE_TIME`,`C_ICON`) values (1,'15168222932','工藤胖一','方任喆','2018-01-16 16:40:35','default.jpg');

/*Table structure for table `t_user_login` */

DROP TABLE IF EXISTS `t_user_login`;

CREATE TABLE `t_user_login` (
  `C_ID` int(11) NOT NULL AUTO_INCREMENT,
  `C_USER_ID` int(11) DEFAULT NULL,
  `C_CREATE_TIME` datetime DEFAULT NULL,
  `C_ACCESS_TOKEN` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_login` */

insert  into `t_user_login`(`C_ID`,`C_USER_ID`,`C_CREATE_TIME`,`C_ACCESS_TOKEN`) values (1,1,'2018-01-23 14:58:27','2488B9F31F06681F8A3DEE08E2937405');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
