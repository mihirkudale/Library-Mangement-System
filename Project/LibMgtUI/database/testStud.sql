/*
SQLyog Community Edition- MySQL GUI v5.20
Host - 5.0.45-community-nt : Database - test
*********************************************************************
Server version : 5.0.45-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `test`;

USE `test`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` int(10) NOT NULL auto_increment,
  `callno` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `quantity` int(10) NOT NULL,
  `issued` int(10) NOT NULL default '0',
  `added_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `callno` (`callno`),
  UNIQUE KEY `callno_2` (`callno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `books` */

insert  into `books`(`id`,`callno`,`name`,`author`,`publisher`,`quantity`,`issued`,`added_date`) values (1,'Java@11','Black Book of Java','Santosh Kumar','dreamTech',18,2,'2017-12-20 16:21:46'),(2,'C@11','let us c','yashwant kanetkar','tata mcgraw',9,1,'2017-12-20 16:23:21');

/*Table structure for table `issuebooks` */

DROP TABLE IF EXISTS `issuebooks`;

CREATE TABLE `issuebooks` (
  `id` int(11) NOT NULL auto_increment,
  `bookcallno` varchar(50) NOT NULL,
  `studentid` varchar(50) NOT NULL,
  `studentname` varchar(50) NOT NULL,
  `studentcontact` varchar(20) NOT NULL,
  `issueddate` varchar(20) NOT NULL,
  `currentdate` varchar(20) default NULL,
  `latefine` int(10) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_issuebooks` (`studentid`),
  CONSTRAINT `FK_issuebooks` FOREIGN KEY (`studentid`) REFERENCES `registrationtbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `issuebooks` */

insert  into `issuebooks`(`id`,`bookcallno`,`studentid`,`studentname`,`studentcontact`,`issueddate`,`currentdate`,`latefine`) values (1,'Java@11','ST00001','q q','9876543210','10-12-2017','20-12-2017',0),(2,'C@11','ST00001','q q','9876543210','1-12-2017','20-12-2017',0);

/*Table structure for table `issuequantity` */

DROP TABLE IF EXISTS `issuequantity`;

CREATE TABLE `issuequantity` (
  `studentid` varchar(100) default NULL,
  `quantity` int(11) default NULL,
  KEY `FK_issuequantity` (`studentid`),
  CONSTRAINT `FK_issuequantity` FOREIGN KEY (`studentid`) REFERENCES `registrationtbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `issuequantity` */

insert  into `issuequantity`(`studentid`,`quantity`) values ('ST00001',2);

/*Table structure for table `librarian` */

DROP TABLE IF EXISTS `librarian`;

CREATE TABLE `librarian` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `gender` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `librarian` */

insert  into `librarian`(`id`,`name`,`email`,`address`,`password`,`contact`,`gender`) values ('LIB00001','Amit','amit@gmail.com','pune','amit','8528528525','Male');

/*Table structure for table `logintbl` */

DROP TABLE IF EXISTS `logintbl`;

CREATE TABLE `logintbl` (
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `contact` varchar(45) NOT NULL,
  PRIMARY KEY  (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `logintbl` */

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `Name` varchar(50) default NULL,
  `Username` varchar(50) default NULL,
  `Password` varchar(50) default NULL,
  `ConfirmPassword` varchar(50) default NULL,
  `Status` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

/*Table structure for table `registrationtbl` */

DROP TABLE IF EXISTS `registrationtbl`;

CREATE TABLE `registrationtbl` (
  `id` varchar(50) NOT NULL,
  `fname` varchar(50) default NULL,
  `lname` varchar(50) default NULL,
  `contact` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `dob` varchar(50) default NULL,
  `bg` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `gender` varchar(50) default NULL,
  `nameofschool` varchar(50) default NULL,
  `addressofschool` varchar(100) default NULL,
  `city` varchar(100) default NULL,
  `passoutyear` varchar(50) default NULL,
  `reason` varchar(100) default NULL,
  `edu` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `regis_UQ` (`id`,`bg`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registrationtbl` */

insert  into `registrationtbl`(`id`,`fname`,`lname`,`contact`,`email`,`dob`,`bg`,`address`,`gender`,`nameofschool`,`addressofschool`,`city`,`passoutyear`,`reason`,`edu`) values ('ST00001','q','q','9876543210','q@gmail.com','20-12-2017','O+','pune','Male','q','q','q','2010','q','SSC'),('ST00002','Raj','Shet','9988776655','raj@gmail.com','02-05-2018','O-','Nagar','Male','RMJVB','Nagar Road','Nagar','2013','EOS','BE');

/* Procedure structure for procedure `validateRegistration` */

drop procedure if exists `validateRegistration`;

DELIMITER $$

CREATE DEFINER=`cutandstiches`@`localhost` PROCEDURE `validateRegistration`(Name1 varchar(50),Username1 varchar(50),Password1 varchar(50),ConfirmPassword1 varchar(50),Status1 varchar(50))
BEGIN
insert  into `registration`(`Name`,`Username`,`Password`,`ConfirmPassword`,`Status`) values (Name1,Username1,Password1,ConfirmPassword1,Status1);
END$$

DELIMITER ;

/* Procedure structure for procedure `ValidateUser` */

drop procedure if exists `ValidateUser`;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ValidateUser`(Username1 varchar(50),Password1 varchar(50))
BEGIN
select Username,Password from registration where Username=Username1 and Password=Password1;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
