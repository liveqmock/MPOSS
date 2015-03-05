/*
SQLyog Ultimate v9.30 
MySQL - 5.0.51b-community-nt-log : Database - dwz4j
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dwz4j` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `res_book` */

DROP TABLE IF EXISTS `res_book`;

CREATE TABLE `res_book` (
  `ID` int(10) unsigned NOT NULL auto_increment COMMENT '书目',
  `SN` varchar(30) default NULL COMMENT '编号',
  `NAME_CN` varchar(100) default NULL COMMENT '中文书目',
  `NAME_EN` varchar(100) default NULL COMMENT '英文书目',
  `PUBLISH` varchar(100) default NULL COMMENT '出版社',
  `PUBLISH_DATE` date default NULL COMMENT '出版日期',
  `INSERT_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `res_chapter` */

DROP TABLE IF EXISTS `res_chapter`;

CREATE TABLE `res_chapter` (
  `ID` int(10) unsigned NOT NULL auto_increment COMMENT '篇目章节',
  `BOOK_ID` int(10) unsigned default NULL COMMENT '书目ID',
  `AUTHOR_ID` int(10) unsigned default NULL COMMENT '作者ID',
  `TRANSLATOR` varchar(50) default NULL COMMENT '译者',
  `CHAPTER_NO` int(6) unsigned default NULL COMMENT '篇号',
  `NAME_CN` varchar(100) default NULL COMMENT '中文篇名',
  `NAME_EN` varchar(100) default NULL COMMENT '英文篇名',
  `SUMMARY` varchar(500) default NULL COMMENT '摘要',
  `PATH` varchar(255) default NULL COMMENT 'PDF路径',
  `KEYWORDS` varchar(200) default NULL COMMENT '关键词',
  `CONTENT` longtext COMMENT 'PDF文字内容',
  `INIT_CONTENT` tinyint(1) NOT NULL default '0' COMMENT '是否已抓取PDF文字内容',
  `START_PAGE_NO` int(10) unsigned default NULL COMMENT '起始页',
  `PAGE_COUNT` int(11) default NULL COMMENT '总页数',
  `INSERT_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`ID`),
  KEY `FK_res_chapter` (`BOOK_ID`),
  CONSTRAINT `FK_res_chapter` FOREIGN KEY (`BOOK_ID`) REFERENCES `res_book` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
