# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost:4306    Database: users
# ------------------------------------------------------
# Server version 5.0.18-nt



#
# Source for table organization
#

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `ORGANIZATION_ID` bigint(20) NOT NULL auto_increment,
  `ORGANIZATION_NAME` varchar(255) collate utf8_unicode_ci default NULL,
  `ORGANIZATION_DESCRIPTION` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`ORGANIZATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table organization
#

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'计算机1201','计算机科学与技术');
INSERT INTO `organization` VALUES (2,'计算机1202班','计算机专业');
INSERT INTO `organization` VALUES (3,'计算机1203班','计算机专业');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table role
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` bigint(20) NOT NULL auto_increment,
  `ROLE_NAME` varchar(255) collate utf8_unicode_ci default NULL,
  `ROLE_DESCRIPTION` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table role
#

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'本科生','大学生');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` bigint(20) NOT NULL auto_increment,
  `USER_NAME` varchar(255) collate utf8_unicode_ci default NULL,
  `USER_PASSWORD` varchar(255) collate utf8_unicode_ci default NULL,
  `USER_EMAIL` varchar(255) collate utf8_unicode_ci default NULL,
  `USER_ORGANIZATION_ID` bigint(20) default NULL,
  PRIMARY KEY  (`USER_ID`),
  KEY `FK36EBCB177B6850` (`USER_ORGANIZATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table user
#

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','E10ADC3949BA59ABBE56E057F20F883E','admin@163.com',1);
INSERT INTO `user` VALUES (2,'student1','E10ADC3949BA59ABBE56E057F20F883E','student1@163.com',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user_role
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `USER_ROLE_USER_ID` bigint(20) NOT NULL,
  `USER_ROLE_ROLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`USER_ROLE_USER_ID`,`USER_ROLE_ROLE_ID`),
  KEY `FK143BF46A6ECCD0F` (`USER_ROLE_ROLE_ID`),
  KEY `FK143BF46AAC1790EF` (`USER_ROLE_USER_ID`),
  CONSTRAINT `FK143BF46A6ECCD0F` FOREIGN KEY (`USER_ROLE_ROLE_ID`) REFERENCES `role` (`ROLE_ID`),
  CONSTRAINT `FK143BF46AAC1790EF` FOREIGN KEY (`USER_ROLE_USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Dumping data for table user_role
#

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table user
#

ALTER TABLE `user`
ADD CONSTRAINT `FK36EBCB177B6850` FOREIGN KEY (`USER_ORGANIZATION_ID`) REFERENCES `organization` (`ORGANIZATION_ID`);



/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
