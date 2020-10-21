CREATE DATABASE  IF NOT EXISTS `dictionary`;
#default collate - utf8mb4

USE `dictionary`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `datetime_created` datetime DEFAULT NULL,
  `datetime_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--
INSERT INTO `user` VALUES 
	(1,'Leslie','Andrews','leslie@ancsin.com', '1979-12-15', now(), null),
	(2,'Emma','Baumgarten','emma@ancsin.com','1983-03-12', now(), null),
	(3,'Avani','Gupta','avani@ancsin.com','1989-07-25', now(), null),
	(4,'Yuri','Petrov','yuri@ancsin.com','1995-06-18', now(), null),
	(5,'Juan','Vega','juan@ancsin.com','2001-09-01', now(), null);

