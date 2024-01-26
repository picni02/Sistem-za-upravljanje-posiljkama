-- MariaDB dump 10.19  Distrib 10.4.28-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: ris_250
-- ------------------------------------------------------
-- Server version	10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ris_250`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ris_250` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `ris_250`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id_radnika` int(11) NOT NULL,
  PRIMARY KEY (`id_radnika`),
  CONSTRAINT `FK2hno5bays7tehpueow89cpa3n` FOREIGN KEY (`id_radnika`) REFERENCES `radnik` (`id_radnika`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (2);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dostavljac`
--

DROP TABLE IF EXISTS `dostavljac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dostavljac` (
  `id_radnika` int(11) NOT NULL,
  `filijalaid` int(11) DEFAULT NULL,
  `okrugid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_radnika`),
  KEY `FKmeu73bckfki0pueohrgqp9xav` (`filijalaid`),
  KEY `FKke4nanjmg8a1mwcowsqefc4cu` (`okrugid`),
  CONSTRAINT `FKccg356safngd41tni6bmebsvw` FOREIGN KEY (`id_radnika`) REFERENCES `radnik` (`id_radnika`),
  CONSTRAINT `FKke4nanjmg8a1mwcowsqefc4cu` FOREIGN KEY (`okrugid`) REFERENCES `okrug` (`okrugid`),
  CONSTRAINT `FKmeu73bckfki0pueohrgqp9xav` FOREIGN KEY (`filijalaid`) REFERENCES `filijala` (`filijalaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dostavljac`
--

LOCK TABLES `dostavljac` WRITE;
/*!40000 ALTER TABLE `dostavljac` DISABLE KEYS */;
INSERT INTO `dostavljac` VALUES (3,1,1);
/*!40000 ALTER TABLE `dostavljac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filijala`
--

DROP TABLE IF EXISTS `filijala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filijala` (
  `filijalaid` int(11) NOT NULL AUTO_INCREMENT,
  `adresa_filijale` varchar(100) NOT NULL,
  `naziv_filijale` varchar(100) NOT NULL,
  `id_radnika` int(11) DEFAULT NULL,
  `regijaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`filijalaid`),
  UNIQUE KEY `UK_jj1r3mhxq21jtl3t5f9mcpmpk` (`id_radnika`),
  KEY `FK7uvwx5il67td7e0dbbben2r2b` (`regijaid`),
  CONSTRAINT `FK7uvwx5il67td7e0dbbben2r2b` FOREIGN KEY (`regijaid`) REFERENCES `regija` (`regijaid`),
  CONSTRAINT `FKcnowv0rcmgsvo9mv9r2pvtxxk` FOREIGN KEY (`id_radnika`) REFERENCES `admin` (`id_radnika`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filijala`
--

LOCK TABLES `filijala` WRITE;
/*!40000 ALTER TABLE `filijala` DISABLE KEYS */;
INSERT INTO `filijala` VALUES (1,'Masarykova 33','Centar',2,1);
/*!40000 ALTER TABLE `filijala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kvar`
--

DROP TABLE IF EXISTS `kvar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kvar` (
  `kvarid` int(11) NOT NULL AUTO_INCREMENT,
  `opis_kvara` varchar(255) NOT NULL,
  `voziloid` int(11) DEFAULT NULL,
  PRIMARY KEY (`kvarid`),
  KEY `FKe1h71xhw9mnosatns10j0bmeq` (`voziloid`),
  CONSTRAINT `FKe1h71xhw9mnosatns10j0bmeq` FOREIGN KEY (`voziloid`) REFERENCES `vozilo` (`voziloid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kvar`
--

LOCK TABLES `kvar` WRITE;
/*!40000 ALTER TABLE `kvar` DISABLE KEYS */;
/*!40000 ALTER TABLE `kvar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lokacija`
--

DROP TABLE IF EXISTS `lokacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lokacija` (
  `lokacijaid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_lokacije` varchar(50) NOT NULL,
  `postanski_broj` int(11) NOT NULL,
  PRIMARY KEY (`lokacijaid`),
  UNIQUE KEY `UK_6m56ngqj8nf0b15k6sxjaod9t` (`postanski_broj`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokacija`
--

LOCK TABLES `lokacija` WRITE;
/*!40000 ALTER TABLE `lokacija` DISABLE KEYS */;
INSERT INTO `lokacija` VALUES (1,'Zenica Centar',72101),(2,'Crkvice',72000),(3,'Nemila',72060);
/*!40000 ALTER TABLE `lokacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `okrug`
--

DROP TABLE IF EXISTS `okrug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `okrug` (
  `okrugid` int(11) NOT NULL AUTO_INCREMENT,
  `filijalaid` int(11) DEFAULT NULL,
  `lokacijaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`okrugid`),
  KEY `FK9kr8klti4kuexji6x52q9kf2f` (`filijalaid`),
  KEY `FK9dkb4f1xwf97o596wjkiyagkv` (`lokacijaid`),
  CONSTRAINT `FK9dkb4f1xwf97o596wjkiyagkv` FOREIGN KEY (`lokacijaid`) REFERENCES `lokacija` (`lokacijaid`),
  CONSTRAINT `FK9kr8klti4kuexji6x52q9kf2f` FOREIGN KEY (`filijalaid`) REFERENCES `filijala` (`filijalaid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `okrug`
--

LOCK TABLES `okrug` WRITE;
/*!40000 ALTER TABLE `okrug` DISABLE KEYS */;
INSERT INTO `okrug` VALUES (1,1,2),(2,1,3);
/*!40000 ALTER TABLE `okrug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posiljka`
--

DROP TABLE IF EXISTS `posiljka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posiljka` (
  `idposiljke` int(11) NOT NULL AUTO_INCREMENT,
  `filijalaid` int(11) NOT NULL,
  `adresa_posiljaoca` varchar(100) NOT NULL,
  `adresa_primaoca` varchar(100) NOT NULL,
  `cijena` double NOT NULL,
  `dodatne_informacije` varchar(255) DEFAULT NULL,
  `prio` bit(1) NOT NULL,
  `tezina` double NOT NULL,
  `id_radnika` int(11) DEFAULT NULL,
  `id_usera` int(11) DEFAULT NULL,
  `okrugid` int(11) DEFAULT NULL,
  `statusid` int(11) DEFAULT NULL,
  `tipid` int(11) DEFAULT NULL,
  PRIMARY KEY (`idposiljke`),
  KEY `FK1msu01a58cbme8na138nbk93k` (`id_radnika`),
  KEY `FK6do7c9o43btbr55mi2boaqp99` (`id_usera`),
  KEY `FKiaj75imkc6nxjk8qdm6gg6onu` (`okrugid`),
  KEY `FKm592mongtji05b2k1bvf0pf92` (`statusid`),
  KEY `FKkgqdhvlkaj5gicy4xct4lf8qe` (`tipid`),
  CONSTRAINT `FK1msu01a58cbme8na138nbk93k` FOREIGN KEY (`id_radnika`) REFERENCES `dostavljac` (`id_radnika`),
  CONSTRAINT `FK6do7c9o43btbr55mi2boaqp99` FOREIGN KEY (`id_usera`) REFERENCES `user` (`id_usera`),
  CONSTRAINT `FKiaj75imkc6nxjk8qdm6gg6onu` FOREIGN KEY (`okrugid`) REFERENCES `okrug` (`okrugid`),
  CONSTRAINT `FKkgqdhvlkaj5gicy4xct4lf8qe` FOREIGN KEY (`tipid`) REFERENCES `tip` (`tipid`),
  CONSTRAINT `FKm592mongtji05b2k1bvf0pf92` FOREIGN KEY (`statusid`) REFERENCES `status` (`statusid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posiljka`
--

LOCK TABLES `posiljka` WRITE;
/*!40000 ALTER TABLE `posiljka` DISABLE KEYS */;
INSERT INTO `posiljka` VALUES (1,1,'Masarykova 33','Ulica branilaca 44',22.5,'Ostaviti na terasi u slučaju da ne bude niko kući','',7.5,NULL,NULL,NULL,3,2),(2,1,'Fakultetska 3','Nemila 75',30,'Zvati na broj 062/987-345','\0',10.5,NULL,NULL,1,3,2);
/*!40000 ALTER TABLE `posiljka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radnik`
--

DROP TABLE IF EXISTS `radnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `radnik` (
  `id_radnika` int(11) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(100) NOT NULL,
  `broj_telefona` varchar(20) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `datum_zaposlenja` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `spol` varchar(10) NOT NULL,
  PRIMARY KEY (`id_radnika`),
  UNIQUE KEY `UK_rnhnd2h4trw7u43fgtpfm7a1r` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radnik`
--

LOCK TABLES `radnik` WRITE;
/*!40000 ALTER TABLE `radnik` DISABLE KEYS */;
INSERT INTO `radnik` VALUES (1,'Crkvice 50','062/430-974','2002-06-16','2019-05-30','superadmin@postexpress.ba','Nedžma','Brkić','$2a$12$uY6C5eh5kfZw5Daj/VzJIuX5vgeDVeRKKYJIIIrCoMNhuiNzFtrzu',0,'žensko'),(2,'Zgošća bb','062/015-130','2002-04-12','2017-08-16','amer.delic@postexpress.ba','Amer','Delić','$2a$12$QTfSjfKnwkdDg29U2wxwCua6gncjOoRIQyDHwgNppvpOGw1UkOJe2',1,'muško'),(3,'Kosova 67','061/850-444','1998-02-18','2018-11-21','adem.spahic@postexpress.ba','Adem','Spahić','$2a$12$qXsB9avD8AHl/VliHt4wTeK4qAdIoQH8fFY.p3NgqeocJcHLzVdem',2,'muško');
/*!40000 ALTER TABLE `radnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regija`
--

DROP TABLE IF EXISTS `regija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regija` (
  `regijaid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_regije` varchar(100) NOT NULL,
  `id_radnika` int(11) DEFAULT NULL,
  PRIMARY KEY (`regijaid`),
  UNIQUE KEY `UK_oj936314rhvsw3p1egaojmd9o` (`id_radnika`),
  CONSTRAINT `FKo4ox1rjqilogu3a7wx7ikphb` FOREIGN KEY (`id_radnika`) REFERENCES `superadmin` (`id_radnika`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regija`
--

LOCK TABLES `regija` WRITE;
/*!40000 ALTER TABLE `regija` DISABLE KEYS */;
INSERT INTO `regija` VALUES (1,'Zenica',1);
/*!40000 ALTER TABLE `regija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_role` varchar(20) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `statusid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_statusa` varchar(20) NOT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Isporučeno'),(2,'Preuzeto'),(3,'U fazi isporuke'),(4,'Neuspješna isporuka'),(5,'Vraćeno');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `superadmin`
--

DROP TABLE IF EXISTS `superadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `superadmin` (
  `id_radnika` int(11) NOT NULL,
  PRIMARY KEY (`id_radnika`),
  CONSTRAINT `FK3n5brn89rw61ob61cyrpqxve0` FOREIGN KEY (`id_radnika`) REFERENCES `radnik` (`id_radnika`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superadmin`
--

LOCK TABLES `superadmin` WRITE;
/*!40000 ALTER TABLE `superadmin` DISABLE KEYS */;
INSERT INTO `superadmin` VALUES (1);
/*!40000 ALTER TABLE `superadmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tip`
--

DROP TABLE IF EXISTS `tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tip` (
  `tipid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_tipa` varchar(20) NOT NULL,
  PRIMARY KEY (`tipid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip`
--

LOCK TABLES `tip` WRITE;
/*!40000 ALTER TABLE `tip` DISABLE KEYS */;
INSERT INTO `tip` VALUES (1,'Pismo'),(2,'Paket');
/*!40000 ALTER TABLE `tip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_usera` int(11) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(100) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usera`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Ulica branilaca 72','mehomehic@gmail.com','Meho','Mehić','$2a$10$1dsxWKT2K0grcY/sZtCrGuMjoLzT9vl3ZL.WXuwYGkcVibQEevO0a',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vozilo`
--

DROP TABLE IF EXISTS `vozilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vozilo` (
  `voziloid` int(11) NOT NULL AUTO_INCREMENT,
  `registarske_oznake` varchar(20) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `id_radnika` int(11) DEFAULT NULL,
  `filijalaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`voziloid`),
  UNIQUE KEY `UK_pfys97ip3755wve3m3q1hbf7q` (`registarske_oznake`),
  UNIQUE KEY `UK_5fd6atvgkp1c9eat4xiipv7d6` (`id_radnika`),
  KEY `FK71qjvpngnddwbspnfbrkae4g3` (`filijalaid`),
  CONSTRAINT `FK6lxmxiwf61gqfe8v8wlkadyhi` FOREIGN KEY (`id_radnika`) REFERENCES `dostavljac` (`id_radnika`),
  CONSTRAINT `FK71qjvpngnddwbspnfbrkae4g3` FOREIGN KEY (`filijalaid`) REFERENCES `filijala` (`filijalaid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vozilo`
--

LOCK TABLES `vozilo` WRITE;
/*!40000 ALTER TABLE `vozilo` DISABLE KEYS */;
INSERT INTO `vozilo` VALUES (2,'123-A-456','',NULL,1),(3,'123-B-541','\0',NULL,1);
/*!40000 ALTER TABLE `vozilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zahtjev`
--

DROP TABLE IF EXISTS `zahtjev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zahtjev` (
  `zahtjevid` int(11) NOT NULL AUTO_INCREMENT,
  `dodatne_informacije` varchar(255) DEFAULT NULL,
  `placeno` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `korisnikid` int(11) DEFAULT NULL,
  `okrugid` int(11) DEFAULT NULL,
  PRIMARY KEY (`zahtjevid`),
  KEY `FK30krn9td5w7lgn9axvps0eket` (`korisnikid`),
  KEY `FKct0dluutnb0mamurys97lrk5y` (`okrugid`),
  CONSTRAINT `FK30krn9td5w7lgn9axvps0eket` FOREIGN KEY (`korisnikid`) REFERENCES `user` (`id_usera`),
  CONSTRAINT `FKct0dluutnb0mamurys97lrk5y` FOREIGN KEY (`okrugid`) REFERENCES `okrug` (`okrugid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zahtjev`
--

LOCK TABLES `zahtjev` WRITE;
/*!40000 ALTER TABLE `zahtjev` DISABLE KEYS */;
/*!40000 ALTER TABLE `zahtjev` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-26 17:17:30
