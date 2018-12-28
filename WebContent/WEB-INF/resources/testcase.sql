
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `testcase` */

DROP TABLE IF EXISTS `testcase`;

CREATE TABLE `testcase` (
  `caseId` INT(11) NOT NULL AUTO_INCREMENT,
  `caseName` VARCHAR(255) CHARACTER SET latin1 NOT NULL,
  `caseDetail` VARCHAR(255) CHARACTER SET latin1 NOT NULL,
  `caseDevice` VARCHAR(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`caseId`)
) ENGINE=INNODB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `testcase` */

INSERT  INTO `testcase`(`caseId`,`caseName`,`caseDetail`,`caseDevice`) VALUES (2,'2','233','444'),(16,'dsf','sf','sfd'),(17,'safd','sadf','asf'),(18,'saf','ggd','sdf'),(19,'dsaf','sdf','sdf'),(20,'sfd','sfd','(NfdsULL)'),(21,'sdf','v','v'),(22,'f','f','e'),(23,'w','r3','rt'),(24,'er','rtrt','sfad'),(25,'sf','sdf','fds'),(26,'sa','s','s'),(27,'e','e','e'),(28,'sa','rt','rt'),(29,'we','ew','qw'),(30,'we','(NULfL)','dsf'),(31,'fd','s','g'),(32,'s','g','f'),(33,'sf','f','f'),(34,'c','c','c'),(35,'e','e','e'),(36,'d','d','q'),(37,'q','e','r'),(38,'f','r','g'),(39,'g','(NULgL)','g'),(40,'gg','g','d'),(41,'f','f','f'),(42,'f','f','f'),(43,'f','f','f'),(44,'v','f','g'),(45,'e','e','r'),(46,'4','rt','fg'),(47,'dsf','ds','sdf');
