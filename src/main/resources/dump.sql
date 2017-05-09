-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: onlineschool
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(999) DEFAULT NULL,
  `password` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_login`
--

DROP TABLE IF EXISTS `admin_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_login` (
  `loginId` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(999) DEFAULT NULL,
  `osName` varchar(999) DEFAULT NULL COMMENT '操作系统',
  `userAgent` int(11) DEFAULT NULL COMMENT '浏览器',
  `loginTime` datetime DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  PRIMARY KEY (`loginId`),
  KEY `admin_login_admin_adminId_fk` (`adminId`),
  CONSTRAINT `admin_login_admin_adminId_fk` FOREIGN KEY (`adminId`) REFERENCES `admin` (`adminId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='管理员登录信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_login`
--

LOCK TABLES `admin_login` WRITE;
/*!40000 ALTER TABLE `admin_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `gradeId` int(11) DEFAULT NULL,
  `title` text,
  `description` text,
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `pic` varchar(999) DEFAULT NULL COMMENT '图片链接',
  `price` double DEFAULT '0' COMMENT '价格',
  `buyCount` int(11) DEFAULT '0' COMMENT '销售数量',
  `creatTime` datetime DEFAULT NULL,
  `updaeTime` datetime DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `course_grade_gradeId_fk` (`gradeId`),
  CONSTRAINT `course_grade_gradeId_fk` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`gradeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_kpoint`
--

DROP TABLE IF EXISTS `course_kpoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_kpoint` (
  `kpointId` int(11) NOT NULL AUTO_INCREMENT,
  `unitId` int(11) DEFAULT NULL,
  `linkId` int(11) DEFAULT NULL,
  `title` text,
  `description` text,
  `creatTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`kpointId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='课程的单元的节点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_kpoint`
--

LOCK TABLES `course_kpoint` WRITE;
/*!40000 ALTER TABLE `course_kpoint` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_kpoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_unit`
--

DROP TABLE IF EXISTS `course_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_unit` (
  `unitId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `title` text,
  `detail` text,
  `creatTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`unitId`),
  KEY `course_unit_course_courseId_fk` (`courseId`),
  CONSTRAINT `course_unit_course_courseId_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='course.unit 课程的单元';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_unit`
--

LOCK TABLES `course_unit` WRITE;
/*!40000 ALTER TABLE `course_unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `gradeId` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(999) DEFAULT NULL,
  `detail` text,
  `creatTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1为正常，0为删除\n',
  PRIMARY KEY (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='年级\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpoint_link`
--

DROP TABLE IF EXISTS `kpoint_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpoint_link` (
  `linkId` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT '0' COMMENT '0为文本，1为doc，2为pdf，3为video',
  `text` text,
  `link` varchar(999) DEFAULT NULL,
  `kpointId` int(11) DEFAULT NULL,
  PRIMARY KEY (`linkId`),
  KEY `kpoint_link_course_kpoint_kpointId_fk` (`kpointId`),
  CONSTRAINT `kpoint_link_course_kpoint_kpointId_fk` FOREIGN KEY (`kpointId`) REFERENCES `course_kpoint` (`kpointId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='附件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpoint_link`
--

LOCK TABLES `kpoint_link` WRITE;
/*!40000 ALTER TABLE `kpoint_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `kpoint_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg`
--

DROP TABLE IF EXISTS `msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg` (
  `msgId` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `sentId` int(11) DEFAULT NULL,
  `receiveId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0未读，1已读',
  `creatTime` datetime DEFAULT NULL,
  PRIMARY KEY (`msgId`),
  KEY `msg_user_userId_fk` (`sentId`),
  KEY `msg_user_userId_fk1` (`receiveId`),
  CONSTRAINT `msg_user_userId_fk` FOREIGN KEY (`sentId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `msg_user_userId_fk1` FOREIGN KEY (`receiveId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='站内通信';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg`
--

LOCK TABLES `msg` WRITE;
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `questionId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `content` text,
  `creatTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`questionId`),
  KEY `question_course_courseId_fk` (`courseId`),
  CONSTRAINT `question_course_courseId_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='作业的问题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_item`
--

DROP TABLE IF EXISTS `question_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_item` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `questionId` int(11) DEFAULT NULL,
  `content` text,
  `isAnswer` int(11) DEFAULT '0' COMMENT '是否是答案，0不是，1是',
  `creatTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  KEY `question_item_question_questionId_fk` (`questionId`),
  CONSTRAINT `question_item_question_questionId_fk` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='问题选项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_item`
--

LOCK TABLES `question_item` WRITE;
/*!40000 ALTER TABLE `question_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(999) DEFAULT NULL,
  `password` varchar(999) DEFAULT NULL,
  `career` text COMMENT '教师简介',
  `pic` varchar(999) DEFAULT NULL COMMENT '头像',
  `status` int(11) DEFAULT '1' COMMENT '状态，01正常，0删除',
  `creatTime` datetime DEFAULT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='老师';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(999) DEFAULT NULL COMMENT '名',
  `lastName` varchar(999) DEFAULT NULL COMMENT '姓',
  `username` varchar(999) DEFAULT NULL COMMENT '帐号名',
  `password` varchar(999) DEFAULT NULL,
  `mobile` varchar(999) DEFAULT NULL,
  `email` varchar(999) DEFAULT NULL,
  `sex` int(11) DEFAULT '0' COMMENT '0为男，1为女',
  `birth` datetime DEFAULT NULL COMMENT '生日',
  `address` varchar(999) DEFAULT NULL COMMENT '地址',
  `city` varchar(999) DEFAULT NULL COMMENT '城市',
  `province` varchar(999) DEFAULT NULL COMMENT '省份',
  `postalCode` varchar(999) DEFAULT NULL COMMENT '邮政编码',
  `country` varchar(999) DEFAULT NULL COMMENT '国家',
  `pic` varchar(999) DEFAULT NULL COMMENT '头像',
  `isAvailable` int(11) DEFAULT '1' COMMENT '帐号是否可用',
  `creatTime` datetime DEFAULT NULL COMMENT '注册时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `msgNum` int(11) DEFAULT NULL COMMENT '站内未读信息\n',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `loginId` int(11) NOT NULL AUTO_INCREMENT,
  `loginTime` datetime DEFAULT NULL,
  `ip` varchar(999) DEFAULT NULL,
  `osName` varchar(999) DEFAULT NULL COMMENT '操作系统',
  `userAgent` varchar(999) DEFAULT NULL COMMENT '浏览器\n',
  PRIMARY KEY (`loginId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用户登录信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-07 15:42:27
