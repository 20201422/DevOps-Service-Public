-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 101.43.231.2    Database: devops
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `epic`
--

DROP TABLE IF EXISTS `epic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `epic` (
  `epicIndex` int NOT NULL AUTO_INCREMENT,
  `epicId` char(100) DEFAULT NULL,
  `epicName` char(100) DEFAULT NULL,
  `epicDescribe` char(200) DEFAULT NULL,
  `epicPriority` char(100) DEFAULT NULL,
  `epicState` char(100) DEFAULT NULL,
  `projectId` char(100) DEFAULT NULL,
  PRIMARY KEY (`epicIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `epic`
--

LOCK TABLES `epic` WRITE;
/*!40000 ALTER TABLE `epic` DISABLE KEYS */;
INSERT INTO `epic` VALUES (1,'2427-1','注册登录模块','系统的注册登录功能','高','实现中','2427'),(2,'2427-2','耕种模块','实现系统的耕种功能','高','实现中','2427'),(3,'2427-3','农民模块','实现系统的农民功能','中','实现中','2427'),(4,'2427-4','购物模块','实现系统的购物功能','中','规划中','2427'),(7,'2427-5','管理员模块','实现系统的管理功能','高','规划中','2427'),(10,'614','ce','','低','规划中','2428'),(11,'612','test','123','低','规划中','2428'),(14,'613','12','','低','规划中','2428'),(15,'615','托尔斯泰','','中','规划中','2428'),(16,'2429-2','外观模式测试','','低','规划中','2429'),(17,'2429-1','史诗状态测试','','低','实现中','2429'),(18,'2430-1','预约挂号管理','进行预约挂号的管理','高','已实现','2430'),(19,'2430-2','医生管理','进行对医生的管理','高','实现中','2430'),(20,'2430-3','科室管理','对医院里的科室进行管理','高','实现中','2430'),(21,'2430-4','预约时段管理','对预约的时段进行管理','高','规划中','2430'),(22,'2430-5','患者管理','患者进行管理','高','实现中','2430'),(23,'2430-6','号源池管理','对医院内的号源池进行管理','高','规划中','2430'),(24,'2430-7','统计分析管理','对挂号预约信息进行管理','低','规划中','2430');
/*!40000 ALTER TABLE `epic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `fileId` int NOT NULL AUTO_INCREMENT,
  `fileName` char(50) DEFAULT NULL,
  `filePath` char(200) DEFAULT NULL,
  `fileSize` char(100) DEFAULT NULL,
  `fileType` char(200) DEFAULT NULL,
  `projectId` char(100) DEFAULT NULL,
  `modelId` char(100) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (21,'文本(2021-10-08 ).txt','f46680a731de4a64a36d6d0faff40c85','3087','text/plain','2428','612-1'),(23,'컴퓨터공학과 교과과정표.pdf','3c5b204271734c0781194d17eae3ac6b','131249','application/pdf','2428','612-1'),(30,'专业综合课程设计-需求分析-2-刘云龙-20201422.doc','21a1da0f7d864f1a806d505730f586cf','1321472','application/msword','2430','2430-02-1'),(39,'hospital-数据字典.rtf','4c06ced9692f44cb88e35740b669d45c','1723897','application/msword','2430','2430-03-4'),(42,'层次体系结构.png','1cd9f575f1314b50a25c32cf63d4c386','248424','image/png','2430','2430-03-1'),(49,'专业综合课程设计-软件调研报告-2-刘云龙-20201422.docx','3334c65e696a4c5eaac85fcdd546e20f','271603','application/vnd.openxmlformats-officedocument.wordprocessingml.document','2430','2430-01-2'),(50,'报告格式要求.doc','c12c453f91c34ca88192b37db9a02587','241667','application/msword','2430','2430-03-8'),(53,'软件设计模式于体系结构课设-功能结构图.png','03b998fc922744d39abb4880aad68c30','531785','image/png','2430','2430-03-2'),(54,'BS体系结构.png','27b6cf1437d64923ac4921323f311e85','549319','image/png','2430','2430-03-1'),(55,'第二组-预约挂号系统.docx','7d8e91239e714208811807472ea94ccb','291185','application/vnd.openxmlformats-officedocument.wordprocessingml.document','2430','2430-03-9'),(58,'领域类图.jpg','2b3ce11c722545fab19b561001859b84','57279','image/jpeg','2430','2430-03-3'),(62,'hospital.emf','ae430e48ea2b418295ca873c435f1f72','359908','','2430','2430-03-4'),(63,'数据库设计.docx','6207ef48aece48dcae2ef14b2f48c24c','13835','application/vnd.openxmlformats-officedocument.wordprocessingml.document','2430','2430-03-3'),(64,'课程设计阶段性电子文档模板3-系统设计.docx','b99cdbb828d0420a87ef6cbe725c403c','5234697','application/vnd.openxmlformats-officedocument.wordprocessingml.document','2430','2430-03-8'),(67,'课程设计阶段性电子文档模板4-软件测试报告.doc','45685303674946759e29b1567bffb8a5','291328','application/msword','2430','2430-04-1'),(68,'课程设计阶段性电子文档模板5-开发总结报告.doc','2ea09fa8373c4288a99559966de1903a','152576','application/msword','2430','2430-04-2');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iteration`
--

DROP TABLE IF EXISTS `iteration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iteration` (
  `iterationId` int NOT NULL AUTO_INCREMENT,
  `iterationName` varchar(255) DEFAULT NULL,
  `iterationDescribe` varchar(255) DEFAULT NULL,
  `iterationState` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `startTime` varchar(255) DEFAULT NULL,
  `endTime` varchar(255) DEFAULT NULL,
  `projectId` char(20) DEFAULT NULL,
  PRIMARY KEY (`iterationId`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iteration`
--

LOCK TABLES `iteration` WRITE;
/*!40000 ALTER TABLE `iteration` DISABLE KEYS */;
INSERT INTO `iteration` VALUES (70,'项目1-迭代1','完成项目1的第一次迭代','未开启','2023-06-01','2023-06-07','2427'),(71,'项目1-迭代2','完成项目1的第2次迭代','未开启','2023-06-08','2023-06-15','2427'),(72,'项目1-迭代3','完成项目1的第三次迭代','已开启','2023-06-16','2023-06-23','2427'),(74,'项目2-迭代1','完成项目2的第一次迭代','已开启','2023-06-02','2023-06-09','2428'),(75,'软件调研','完成对挂号预约系统的调研','未开启','2023-06-05','2023-06-06','2430'),(76,'需求分析','对挂号预约系统进行需求分析\n要求：\n1 不要画功能结构图，设计阶段做\n2 需求分析做什么\n   2.1 系统给谁用\n   2.2 划分管理员\n3 用例要求\n   3.1 用例名一定是动宾短语\n   3.2 用例一定是系统行为\n   3.3 用例一定是一件完整、有意义、运行完结果可见的事情\n   3.4 在做需求的时候，可以把用例做抽象一点，比如医生信息管理，不需要用扩展和包含（设计阶段做的），可以用泛化\n   3.5 用例图不要太庞大，用例图可以按功能拆开\n   3.6 用例命名要用业务术语','未开启','2023-06-06','2023-06-07','2430'),(77,'软件设计阶段','1.软件架构（体系结构）\n2.功能架构（功能结构）\n3.概念模型（领域类图 关联 聚集 依赖 泛化）\n4.数据库设计（可视化用powerDesigner PDM图；数据字典（字段、主码、外码）\n5.界面设计','未开启','2023-06-09','2023-06-18','2430'),(78,'实现阶段','代码实现','已开启','2023-06-19','2023-06-25','2430'),(79,'项目测试','测试要求：\n1.黑盒测试：边界值测试、等价类、决策表、记录测试结果（缺陷截图）\n2.白盒测试：程序图、基路径测试、路径覆盖（至少三种）\n3.交叉进行测试','未开启','2023-06-26','2023-06-30','2430');
/*!40000 ALTER TABLE `iteration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `projectId` char(20) NOT NULL,
  `projectName` char(100) DEFAULT NULL,
  `projectDescribe` char(200) DEFAULT NULL,
  `projectState` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('2427','共享农庄平台','实现共享土地，让会员认领土地并体验耕种；交易有机农产品。','已结束'),('2428','LFouse租房平台','提供最好的租房服务。','进行中'),('2429','敏捷开发管理平台','实现对软件项目的敏捷管理','进行中'),('2430','三联协和医院挂号预约系统','一个可以进行互联网挂号预约的平台','进行中');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_and_user`
--

DROP TABLE IF EXISTS `project_and_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_and_user` (
  `projectAndUserId` int NOT NULL AUTO_INCREMENT,
  `projectId` char(20) DEFAULT NULL,
  `userId` char(20) DEFAULT NULL,
  PRIMARY KEY (`projectAndUserId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_and_user`
--

LOCK TABLES `project_and_user` WRITE;
/*!40000 ALTER TABLE `project_and_user` DISABLE KEYS */;
INSERT INTO `project_and_user` VALUES (1,'2427','20201419'),(2,'2427','20201420'),(3,'2427','20201421'),(4,'2427','20201422'),(5,'2427','20201423'),(6,'2428','20201419'),(7,'2428','20201420'),(8,'2428','20201422'),(9,'2428','20201423'),(10,'2429','20201422'),(11,'2429','20201423'),(12,'2430','20201419'),(13,'2430','20201422'),(14,'2430','20201423');
/*!40000 ALTER TABLE `project_and_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `questionIndex` int NOT NULL AUTO_INCREMENT,
  `questionId` char(100) DEFAULT NULL,
  `questionName` char(100) DEFAULT NULL,
  `questionDescribe` char(200) DEFAULT NULL,
  `questionPriority` char(100) DEFAULT NULL,
  `questionState` char(100) DEFAULT NULL,
  `beginTime` varchar(45) DEFAULT NULL,
  `endTime` varchar(45) DEFAULT NULL,
  `projectId` char(100) DEFAULT NULL,
  `userId` char(100) DEFAULT NULL,
  `epicId` char(100) DEFAULT NULL,
  `iterationId` int DEFAULT NULL,
  PRIMARY KEY (`questionIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (8,'2427-1-1','注册功能','实现对系统的注册','高','实现中','2023-05-25T04:00:00.000Z','2023-05-30T04:00:00.000Z','2427','20201419','2427-1',70),(10,'2427-1-2','登录功能','实现对系统的登录','高','已实现','','','2427','20201422','2427-1',70),(11,'2427-1-3','修改个人信息功能','实现对个人的信息进行编辑','高','已实现','','','2427','20201423','2427-1',70),(12,'2427-1-4','退出登录功能','实现对系统的登出','高','规划中',NULL,NULL,'2427',NULL,'2427-1',70),(13,'2427-1-5','注销功能','实现注销账户','低','已实现','','','2427','20201420','2427-1',NULL),(14,'2427-2-1','自行耕种','实现会员自行耕种土地的功能','高','已实现','','','2427','20201421','2427-2',72),(15,'2427-2-2','托管代种','实现会员托管代种土地的功能','高','实现中','2023-05-31T04:00:00.000Z','2023-06-06T04:00:00.000Z','2427','20201422','2427-2',72),(17,'2427-2-3','查看耕种情况','实现会员查看耕种情况的功能','高','实现中','','','2427','20201419','2427-2',72),(18,'2427-2-4','取消耕种','实现会员取消耕种的功能','高','已实现','','','2427','20201419','2427-2',72),(19,'2427-2-5','续租土地','实现会员续租土地的功能','中','规划中','','','2427','20201423','2427-2',NULL),(20,'2427-3-1','土地管理','实现农民对土地的管理功能','高','规划中','2023-06-10T04:00:00.000Z','2023-06-14T04:00:00.000Z','2427','20201420','2427-3',NULL),(21,'2427-3-3','种植管理','用来管理农民种植','高','规划中','2023-05-29T04:00:00.000Z','2023-05-31T04:00:00.000Z','2427','20201422','2427-3',NULL),(22,'2427-3-2','畜牧管理','实现农民对畜牧的管理功能','低','实现中','','','2427','20201422','2427-3',NULL),(27,'2427-4-1','购物车管理','实现会员对购物车的管理功能','高','规划中',NULL,NULL,'2427',NULL,'2427-4',NULL),(28,'2427-4-2','订单管理','实现会员对有机农产品订单的管理功能','高','规划中','2023-05-26T04:00:00.000Z','2023-06-06T04:00:00.000Z','2427','20201423','2427-4',71),(29,'2427-5-1','用户审批','实现对用户审批成为会员的功能','高','规划中',NULL,NULL,'2427',NULL,'2427-5',71),(30,'2427-5-2','耕种审批','实现对会员耕种订单的审批功能','高','规划中',NULL,NULL,'2427',NULL,'2427-5',71),(31,'2427-5-3','进展报告功能','实现代种人员为会员编辑、发送进展报告的功能','中','规划中','2023-05-23T04:00:00.000Z','2023-06-07T04:00:00.000Z','2427','20201421','2427-5',NULL),(159,'614-1','asd',NULL,'低','规划中','','','2428','','614',NULL),(160,'612-1','awe',NULL,'低','规划中','','','2428','','',NULL),(162,'123457','test2-1',NULL,'低','规划中',NULL,NULL,'2428','',NULL,74),(164,'2430-1-1','信息查询','对号源进行信息查询','高','已实现','','','2430','20201422','2430-1',78),(165,'2430-1-2','挂号预约','进行挂号预约','高','已实现','','','2430','20201422','2430-1',78),(166,'2430-1-3','预约审核','对预约请求进行审核','中','已实现','','','2430','20201422','2430-1',78),(167,'2430-1-2-1','取消预约','对已经挂号的预约进行取消','高','已实现','','','2430','20201422','2430-1',78),(168,'2430-1-2-2','查看预约提醒','提醒患者挂号时间即将到达','中','已实现','','','2430','20201422','2430-1',78),(169,'2430-1-2-3','查看预约指南','提示患者预约挂号的相关提示信息','中','已实现','','','2430','20201422','2430-1',78),(170,'2430-1-2-4','查看挂号单','患者查看挂号详情','高','已实现','','','2430','20201422','2430-1',78),(171,'2430-2-1','医生信息管理','对医生的信息进行管理','高','实现中','','','2430','20201423','2430-2',78),(172,'2430-2-2','排班管理','对医生的排版情况进行管理','高','已实现','','','2430','20201423','2430-2',78),(173,'2430-2-3','调班管理','医生可能有紧急事情需要停诊调班','中','实现中','','','2430','20201423','2430-2',78),(174,'2430-3-1','诊室管理','对科室下的诊室进行管理','低','实现中','','','2430','20201423','2430-3',78),(175,'2430-4-1','可预约时段管理','管理预约挂号的时段','高','规划中','','','2430','20201423','2430-4',78),(176,'2430-5-1','患者队列查询','医生查看自己患者的挂号队列','高','已实现','','','2430','20201423','2430-5',78),(177,'2430-5-2','患者信息维护','对患者的信息进行维护','高','已实现','','','2430','20201422','2430-5',78),(178,'2430-5-2-1','就诊档案管理','对就诊人的档案进行管理','高','已实现','','','2430','20201422','2430-5',78),(179,'2430-5-2-2','查看个人信誉度','可以查看个人的信誉度','中','规划中','','','2430','20201422','2430-5',78),(180,'2430-5-2-3','患者进入黑名单','患者信誉度太低进入黑名单','中','规划中','','','2430','20201419','2430-5',78),(181,'2430-6-1','号源管理','对号源进行管理','高','规划中','','','2430','20201419','2430-6',78),(182,'2430-7-1','预约情况概览','对预约的情况进行概览','中','规划中','','','2430','20201419','2430-7',78),(183,'2430-7-2','预约情况分析','对预约的情况进行分析','中','规划中','','','2430','20201419','2430-7',78),(184,'2430-7-3','输出报表','打印输出预约挂号信息','低','规划中','','','2430','20201419','2430-7',78),(185,'2430-7-2-1','预约人群分析','对挂号预约的就诊人进行分析','中','规划中','','','2430','20201419','2430-7',78),(186,'2430-7-2-2','预约时间段分析','对就诊人的预约时间段进行分析','低','规划中','','','2430','20201419','2430-7',78),(187,'2430-01-1','编写软件调研报告','完成编写软件调研报告','高','已实现','2023-06-05T04:00:00.000Z','2023-06-06T04:00:00.000Z','2430','','',75),(188,'2430-01-2','规范软件调研报告','软件调研报告的格式进行规范','中','已实现','2023-06-05T04:00:00.000Z','2023-06-06T04:00:00.000Z','2430','20201419','',75),(190,'123456','test','123','低','规划中','','','2427','','',0),(191,'2430-02-1','软件需求说明','编写软件需求规格说明书','高','已实现','2023-06-06T04:00:00.000Z','2023-06-07T04:00:00.000Z','2430','20201422','',76),(192,'2430-03-1','软件架构设计','体系结构','高','已实现','2023-06-09T04:00:00.000Z','2023-06-11T04:00:00.000Z','2430','20201423','',77),(193,'2430-03-2','功能架构设计','功能结构','高','已实现','2023-06-09T04:00:00.000Z','2023-06-11T04:00:00.000Z','2430','20201423','',77),(194,'2430-03-3','概念模型设计','数据库的创建；\n领域类图 关联 聚集 依赖 泛化','高','已实现','2023-06-09T04:00:00.000Z','2023-06-11T04:00:00.000Z','2430','20201422','',77),(195,'2430-03-4','数据库设计','可视化用powerDesigner PDM图；\n数据字典（字段、主码、外码）','高','已实现','2023-06-09T04:00:00.000Z','2023-06-11T04:00:00.000Z','2430','20201419','',77),(196,'2430-03-5','系统设计文档（慧强）','完成系统设计文档的第一章、第四章以及第五章-第七章（自己的部分）','中','实现中','2023-06-11T04:00:00.000Z','2023-06-16T04:00:00.000Z','2430','20201419','',77),(198,'2430-03-6','系统设计文档（堃芃）','完成系统设计文档的第二章、第三章以及第五章-第七章（自己的部分）','中','已实现','2023-06-11T04:00:00.000Z','2023-06-16T04:00:00.000Z','2430','20201422','',77),(199,'2430-03-7','系统设计文档（瑞祥）','完成系统设计文档的第八章、第九章以及第五章-第七章（自己的部分）','中','实现中','2023-06-11T04:00:00.000Z','2023-06-16T04:00:00.000Z','2430','20201423','',77),(200,'2430-03-8','文档格式规范','按照报告格式要求规范文档格式','低','实现中','','','2430','20201423','',77),(201,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(202,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(203,'2430-03-9','设计文档初稿','1 软件体系结构图 2 系统功能结构图 3 ER图或者领域类图','高','已实现','2023-06-12T03:00:00.000Z','2023-06-13T04:00:00.000Z','2430','20201423','',77),(204,'2430-03-10','类设计（慧强）',NULL,'高','规划中',NULL,NULL,'2430','20201419',NULL,77),(205,'2430-03-11','类设计（堃芃）',NULL,'高','规划中',NULL,NULL,'2430','20201422',NULL,77),(206,'2430-03-12','类设计（瑞祥）',NULL,'高','规划中',NULL,NULL,'2430','20201423',NULL,77),(207,'2430-04-1','测试文档编写',NULL,'高','已实现','','','2430','','',79),(208,'2430-04-2','开发总结报告',NULL,'高','已实现',NULL,NULL,'2430','',NULL,79);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` char(20) NOT NULL,
  `userName` char(20) DEFAULT NULL,
  `userPassword` char(240) DEFAULT NULL,
  `userType` char(20) DEFAULT NULL,
  `userImage` char(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('20201419','慧强','e10adc3949ba59abbe56e057f20f883e','组员','hq.jpeg'),('20201420','滔滔','e10adc3949ba59abbe56e057f20f883e','组员','tt.jpeg'),('20201421','刘彤','e10adc3949ba59abbe56e057f20f883e','组员','123'),('20201422','堃芃','e10adc3949ba59abbe56e057f20f883e','组长','kp.jpeg'),('20201423','瑞祥','e10adc3949ba59abbe56e057f20f883e','组员','rx.jpeg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-13 12:45:29
