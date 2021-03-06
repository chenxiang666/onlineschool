-- MySQL dump 10.16  Distrib 10.1.25-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: onlineschool
-- ------------------------------------------------------
-- Server version	10.1.25-MariaDB

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
-- Current Database: `onlineschool`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `onlineschool` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `onlineschool`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creatTime` datetime DEFAULT NULL,
  `description` text,
  `gradeId` int(11) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `teacherId` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlmfwelta3u90fi95vaj82ot3h` (`teacherId`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'2017-06-01 22:50:56','This course introduces students to the world of business. Students will develop an understanding of the functions of business, including accounting, marketing, information and communication technology, human resources, and production, and of the importance of ethics and social responsibility. This course builds a foundation for further studies in business and helps students develop the business knowledge and skills they will need in their everyday lives.',1,NULL,0,1,'English1',0,NULL),(2,'2017-06-01 22:51:00','1 This course introduces students to the world of business. Students will develop an understanding of the functions of business, including accounting, marketing, information and communication technology, human resources, and production, and of the importance of ethics and social responsibility. This course builds a foundation for further studies in business and helps students develop the business knowledge and skills they will need in their everyday lives. course integrates two or more of the arts (dance, drama, media arts, music, and visual arts), giving students the opportunity to produce and present integrated art works created individually or collaboratively. Students will demonstrate innovation as they learn and apply concepts, styles, and conventions unique to the various arts and acquire skills that are transferable beyond the classroom. Students will use the creative process and responsible practices to explore solutions to integrated arts challenges.',1,NULL,0,1,'English6',0,NULL),(3,'2017-06-01 22:50:58','2This course introduces students to the world of business. Students will develop an understanding of the functions of business, including accounting, marketing, information and communication technology, human resources, and production, and of the importance of ethics and social responsibility. This course builds a foundation for further studies in business and helps students develop the business knowledge and skills they will need in their everyday lives.',1,NULL,0,155,'English4',0,NULL),(4,'2017-06-01 22:50:59','This course introduces students to the world of business. Students will develop an understanding of the functions of business, including accounting, marketing, information and communication technology, human resources, and production, and of the importance of ethics and social responsibility. This course builds a foundation for further studies in business and helps students develop the business knowledge and skills they will need in their everyday lives.',2,NULL,0,1,'English5',0,NULL),(5,NULL,'This course introduces students to the world of business. Students will develop an understanding of the functions of business, including accounting, marketing, information and communication technology, human resources, and production, and of the importance of ethics and social responsibility. This course builds a foundation for further studies in business and helps students develop the business knowledge and skills they will need in their everyday lives.',2,NULL,0,155,'Math1',0,NULL),(6,'2017-06-01 22:51:01','This course introduces students to the world of business. Students will develop an understanding of the functions of business, including accounting, marketing, information and communication technology, human resources, and production, and of the importance of ethics and social responsibility. This course builds a foundation for further studies in business and helps students develop the business knowledge and skills they will need in their everyday lives.',2,NULL,0,1,'Math2',0,NULL),(7,NULL,'This course introduces students to the world of business. Students will develop an understanding of the functions of business, including accounting, marketing, information and communication technology, human resources, and production, and of the importance of ethics and social responsibility. This course builds a foundation for further studies in business and helps students develop the business knowledge and skills they will need in their everyday lives.',2,NULL,0,1,'Math3',0,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_file`
--

DROP TABLE IF EXISTS `course_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `title` text,
  `url` text,
  `unitId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_file`
--

LOCK TABLES `course_file` WRITE;
/*!40000 ALTER TABLE `course_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_unit`
--

DROP TABLE IF EXISTS `course_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `creatTime` datetime DEFAULT NULL,
  `description` text,
  `title` varchar(255) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `spendTime` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_unit`
--

LOCK TABLES `course_unit` WRITE;
/*!40000 ALTER TABLE `course_unit` DISABLE KEYS */;
INSERT INTO `course_unit` VALUES (9,1,NULL,'<p>go</p>\r\n','Unit 2 - First Step',NULL,'12 Hour'),(8,1,NULL,'<p>Let&#39;s do it</p>\r\n\r\n<p>&nbsp;</p>\r\n','Unit 1 - English Learning',NULL,'46 Hour'),(7,2,NULL,'4','Unit7',NULL,'12Hour'),(6,2,NULL,'6','Unit6',NULL,'7Hour'),(5,2,NULL,'5','Unit5',NULL,'6Hour'),(4,2,NULL,'4','Unit4',NULL,'42Hour'),(3,2,NULL,'sdf','Unit3',NULL,'46Hour'),(2,2,NULL,'4466','Unit2',NULL,'7Hour'),(1,2,'2017-06-08 09:50:01','333','Unit1',NULL,'5Hour'),(13,3,NULL,'<p>English learning</p>\r\n','Unit 1 - English Learning',NULL,'24Hour'),(14,3,NULL,'<p>English learning two day</p>\r\n','Unit 2 - First Step',NULL,'12 Hours'),(15,3,NULL,'<p>Learning English three day</p>\r\n','Unit 3 - Second Step',NULL,'15 Hours'),(16,3,NULL,'<p>day day learning&nbsp;</p>\r\n','Unit 4-Learning',NULL,'10 Hours'),(17,5,NULL,'<p>I will tell you what`s math</p>\r\n','Unit 1 - What`s Math',NULL,'10 Hours'),(18,5,NULL,'<p>I will tell you how to use math</p>\r\n','Unit 2 - First Step',NULL,'15 Hours');
/*!40000 ALTER TABLE `course_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_unit_lesson`
--

DROP TABLE IF EXISTS `course_unit_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_unit_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `unitId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_unit_lesson`
--

LOCK TABLES `course_unit_lesson` WRITE;
/*!40000 ALTER TABLE `course_unit_lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_unit_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beginTime` datetime DEFAULT NULL,
  `courseId` int(11) NOT NULL,
  `endTime` datetime DEFAULT NULL,
  `score` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `percent` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,NULL,2,NULL,0,'Test1',0,0),(20,'2017-06-29 00:00:00',1,'2017-06-30 00:00:00',100,'111',1,25),(17,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',100,'Three Test',1,0),(16,'2017-06-01 00:00:00',1,'2017-06-09 00:00:00',0,'Second test',1,0),(15,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',0,'First test',1,0),(22,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',4,'2',1,6),(23,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',4,'2',1,6),(24,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',5,'24',1,56),(25,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',24,'22',1,0),(26,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',36,'24',1,45),(27,'2017-06-01 00:00:00',1,'2017-06-02 00:00:00',436,'35',1,7),(28,'2017-06-01 00:00:00',1,'2017-06-03 00:00:00',26,'24',1,26),(29,'2017-06-01 00:00:00',1,'2017-06-03 00:00:00',25,'2134',1,26),(31,'2017-06-16 00:00:00',3,'2017-06-24 00:00:00',100,'Unit 1 Test',1,10),(32,'2017-06-16 00:00:00',3,'2017-06-24 00:00:00',100,'Unit 2 Test',1,10),(33,'2017-06-12 00:00:00',5,'2017-06-30 00:00:00',100,'Unit 1 Test',1,10),(34,'2017-06-01 00:00:00',5,'2017-06-30 00:00:00',100,'Unit 2 Test',1,10);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_question`
--

DROP TABLE IF EXISTS `exam_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) DEFAULT NULL,
  `itemScore` double DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_question`
--

LOCK TABLES `exam_question` WRITE;
/*!40000 ALTER TABLE `exam_question` DISABLE KEYS */;
INSERT INTO `exam_question` VALUES (43,31,50,20,0),(12,17,100,10,0),(19,20,45,10,0),(18,20,25,12,0),(17,20,20,13,0),(21,22,4,0,0),(22,22,6,0,0),(23,22,7,0,0),(24,23,4,13,0),(25,23,6,12,0),(26,23,7,10,0),(27,24,26,13,0),(28,24,27,12,0),(29,24,27,10,0),(30,25,34,13,0),(31,25,25,12,0),(32,25,56,10,0),(33,26,3,13,0),(34,26,36,12,0),(35,26,7,10,0),(36,27,35,13,0),(37,27,36,0,0),(38,27,7,0,0),(39,28,27,13,0),(40,29,12,13,0),(42,31,50,17,0),(44,32,10,17,0),(45,32,10,18,0),(46,32,20,19,0),(47,32,60,20,0),(48,33,20,21,0),(49,33,80,23,0),(50,34,20,21,0),(51,34,20,22,0),(52,34,60,23,0);
/*!40000 ALTER TABLE `exam_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result`
--

DROP TABLE IF EXISTS `exam_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `score` double NOT NULL,
  `time` datetime DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `courseId` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result`
--

LOCK TABLES `exam_result` WRITE;
/*!40000 ALTER TABLE `exam_result` DISABLE KEYS */;
INSERT INTO `exam_result` VALUES (25,20,60,NULL,2,1,1),(15,17,0,NULL,155,1,0),(26,17,0,NULL,2,1,0),(24,17,4,NULL,2,1,1),(27,31,0,NULL,157,3,0);
/*!40000 ALTER TABLE `exam_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result_question`
--

DROP TABLE IF EXISTS `exam_result_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_result_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `examId` int(11) NOT NULL,
  `isRight` bit(1) DEFAULT NULL,
  `questionId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `examResultId` int(11) NOT NULL,
  `itemScore` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=129 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result_question`
--

LOCK TABLES `exam_result_question` WRITE;
/*!40000 ALTER TABLE `exam_result_question` DISABLE KEYS */;
INSERT INTO `exam_result_question` VALUES (97,'A',17,'',10,155,15,0),(96,'B',17,'\0',10,155,14,0),(126,'A',17,'',10,2,26,0),(125,'<p>22222222222222222</p>\r\n',20,NULL,13,2,25,0),(124,'A',20,'',12,2,25,0),(123,'A',20,'',10,2,25,0),(122,'A',17,'',10,2,24,0),(127,'<p>2</p>\r\n',31,NULL,20,157,27,0),(128,'C',31,'',17,157,27,0);
/*!40000 ALTER TABLE `exam_result_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creatTime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gradeName` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,'2017-06-01 09:31:00','This is grade9','grade9','2017-06-01 09:31:48'),(2,'2017-06-01 09:31:53','This is grade10','grade10','2017-06-01 09:32:11'),(3,'2017-06-02 08:56:18','This is grade11','grade11','2017-06-02 08:56:32');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg`
--

DROP TABLE IF EXISTS `msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `msgId` int(11) NOT NULL,
  `receiverId` int(11) NOT NULL,
  `senderId` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg`
--

LOCK TABLES `msg` WRITE;
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
INSERT INTO `msg` VALUES (1,'111','2017-06-29 16:21:40',0,1,2,0),(2,'222','2017-06-29 16:21:45',1,1,2,0),(3,'333','2017-06-29 16:21:59',2,2,1,0),(4,'4444','2017-06-29 16:22:09',0,155,1,0),(5,'dsd','2017-06-29 17:05:55',0,1,2,0);
/*!40000 ALTER TABLE `msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `courseId` int(11) NOT NULL,
  `creatTime` datetime DEFAULT NULL,
  `optiona` varchar(255) DEFAULT NULL,
  `optionb` varchar(255) DEFAULT NULL,
  `optionc` varchar(255) DEFAULT NULL,
  `optiond` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `unitId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (13,'ah',1,NULL,NULL,NULL,NULL,NULL,NULL,'<p>ag</p>\r\n',2,8),(2,NULL,2,NULL,'go','dd','ee','gg',NULL,'<p>What\'s your name?</p>\r\n',1,0),(12,'A',1,NULL,'g','h','j','j',NULL,'<p>sg</p>\r\n',1,8),(10,'A',1,NULL,'Yes','No','No,but he can.','Yes,I can',NULL,'<p>Can you do it?</p>\r\n',1,8),(8,'A',2,NULL,'ag','g','h','h',NULL,'<p>sdf</p>\r\n',1,0),(17,'C',3,NULL,'ok','fine','just so (right)','um...',NULL,'<p>How are you?</p>\r\n',1,13),(18,'B',3,NULL,'jack','Tom(right)','haha','zhangsan',NULL,'<p>What`s your name</p>\r\n',1,14),(19,'B',3,NULL,'wuhan','jiangxia(right)','china','japan',NULL,'<p>Where are you from?</p>\r\n',1,16),(20,'I hava a pen',3,NULL,NULL,NULL,NULL,NULL,NULL,'<p>what do you hava?</p>\r\n',2,15),(21,'B',5,NULL,'1','2','3','4',NULL,'<p>1+1=()</p>\r\n',1,17),(22,'A',5,NULL,'3','4','5','6',NULL,'<p>1+2=( )</p>\r\n',1,18),(23,'5050',5,NULL,NULL,NULL,NULL,NULL,NULL,'<p>1+2+..+100=?</p>\r\n',2,17);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test1`
--

DROP TABLE IF EXISTS `test1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9ak8raiajnjrllrabqfdc2y0c` (`exam_id`),
  KEY `FKnk2tu61ufvbevy5eampr56i6l` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test1`
--

LOCK TABLES `test1` WRITE;
/*!40000 ALTER TABLE `test1` DISABLE KEYS */;
INSERT INTO `test1` VALUES (1,'sdf',NULL,1,NULL),(2,'sdf',NULL,NULL,NULL);
/*!40000 ALTER TABLE `test1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test1_course`
--

DROP TABLE IF EXISTS `test1_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test1_course` (
  `Test1_id` int(11) NOT NULL,
  `courseList_id` int(11) NOT NULL,
  KEY `FKhfy982gaupfknh9emqnm5913n` (`courseList_id`),
  KEY `FKqf32wdck0k7hvlssrf7py1322` (`Test1_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test1_course`
--

LOCK TABLES `test1_course` WRITE;
/*!40000 ALTER TABLE `test1_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `test1_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test1_grade`
--

DROP TABLE IF EXISTS `test1_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test1_grade` (
  `Test1_id` int(11) NOT NULL,
  `gradeList_id` int(11) NOT NULL,
  UNIQUE KEY `UK_t3uqey6kxtbjnnswq41hqxrg0` (`gradeList_id`),
  KEY `FK4rog5uy0y3atd788u61wux2qn` (`Test1_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test1_grade`
--

LOCK TABLES `test1_grade` WRITE;
/*!40000 ALTER TABLE `test1_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `test1_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `creatTime` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `msgNum` int(11) NOT NULL,
  `password` varchar(255) DEFAULT '1111',
  `pic` varchar(255) DEFAULT NULL,
  `postalCode` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=315 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'111','teacher','one',NULL,0,'111',NULL,NULL,NULL,1,0,0,NULL,'111'),(159,NULL,NULL,NULL,NULL,NULL,NULL,'admin@gmail.com',NULL,NULL,NULL,0,'admin',NULL,NULL,NULL,2,0,0,NULL,'admin'),(157,'we',NULL,NULL,'6',NULL,NULL,'26@45','21','3','3',0,'student',NULL,'3',NULL,0,1,0,NULL,'jack@gmail.com'),(156,'216','','wuhan','America',NULL,'I\'m good','liufreeo@gmail.com','Lucy','Jack','034-345-677',0,'1111',NULL,'88888',NULL,0,0,0,NULL,'liufreeo@gmail.com'),(155,'',NULL,NULL,'',NULL,NULL,'','teacher','test','',0,'teacher',NULL,'',NULL,1,0,0,NULL,'tom@gmail.com'),(2,'',NULL,NULL,'',NULL,NULL,'','','','',0,'1111',NULL,'',NULL,0,1,0,NULL,'222'),(313,'Gray',NULL,NULL,'America',NULL,NULL,'qqq@gmail.com','Michael','JackSon','111111',0,'1111',NULL,'666666',NULL,0,1,0,NULL,'qqq@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_course`
--

DROP TABLE IF EXISTS `user_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_course`
--

LOCK TABLES `user_course` WRITE;
/*!40000 ALTER TABLE `user_course` DISABLE KEYS */;
INSERT INTO `user_course` VALUES (1,1,309),(43,3,157),(42,5,157),(36,1,156),(34,1,154),(32,1,154),(29,1,0),(4,4,2);
/*!40000 ALTER TABLE `user_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `loginTime` varchar(255) DEFAULT NULL,
  `osName` varchar(255) DEFAULT NULL,
  `userAgent` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
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

-- Dump completed on 2017-07-20 10:01:08
