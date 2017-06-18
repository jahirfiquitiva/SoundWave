-- MySQL dump 10.16  Distrib 10.1.21-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Current Database: `musicplayer`
--

CREATE DATABASE /*!32312 IF NOT EXISTS */ `musicplayer` /*!40100 DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci */;

USE `musicplayer`;

--
-- Table structure for table `GENRES`
--

DROP TABLE IF EXISTS `GENRES`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GENRES` (
  `GENRE_ID`    VARCHAR(4)  NOT NULL,
  `DESCRIPTION` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`GENRE_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GENRES`
--

LOCK TABLES `GENRES` WRITE;
/*!40000 ALTER TABLE `GENRES`
  DISABLE KEYS */;
INSERT INTO `GENRES` VALUES ('G001', 'ElectroHouse'), ('G002', 'Dubstep'), ('G003', 'ElectroDance');
/*!40000 ALTER TABLE `GENRES`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYLISTS`
--

DROP TABLE IF EXISTS `PLAYLISTS`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLAYLISTS` (
  `PL_ID` VARCHAR(5)  NOT NULL,
  `NAME`  VARCHAR(40) NOT NULL,
  PRIMARY KEY (`PL_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYLISTS`
--

LOCK TABLES `PLAYLISTS` WRITE;
/*!40000 ALTER TABLE `PLAYLISTS`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `PLAYLISTS`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYLISTS_USERS`
--

DROP TABLE IF EXISTS `PLAYLISTS_USERS`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLAYLISTS_USERS` (
  `F_PL_ID`   VARCHAR(5) NOT NULL,
  `F_USER_ID` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`F_PL_ID`, `F_USER_ID`),
  KEY `F_USER_ID` (`F_USER_ID`),
  CONSTRAINT `PLAYLISTS_USERS_ibfk_1` FOREIGN KEY (`F_PL_ID`) REFERENCES `PLAYLISTS` (`PL_ID`)
    ON UPDATE CASCADE,
  CONSTRAINT `PLAYLISTS_USERS_ibfk_2` FOREIGN KEY (`F_USER_ID`) REFERENCES `USERS` (`USER_ID`)
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYLISTS_USERS`
--

LOCK TABLES `PLAYLISTS_USERS` WRITE;
/*!40000 ALTER TABLE `PLAYLISTS_USERS`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `PLAYLISTS_USERS`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SONGS`
--

DROP TABLE IF EXISTS `SONGS`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SONGS` (
  `SONG_ID`   VARCHAR(5)  NOT NULL,
  `NAME`      VARCHAR(40) NOT NULL,
  `ARTIST`    VARCHAR(40) NOT NULL,
  `GENRE`     VARCHAR(4)  NOT NULL,
  `LENGTH`    INT(11)     NOT NULL,
  `FILE_PATH` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`SONG_ID`),
  KEY `GENRE` (`GENRE`),
  CONSTRAINT `SONGS_ibfk_1` FOREIGN KEY (`GENRE`) REFERENCES `GENRES` (`GENRE_ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SONGS`
--

LOCK TABLES `SONGS` WRITE;
/*!40000 ALTER TABLE `SONGS`
  DISABLE KEYS */;
INSERT INTO `SONGS` VALUES ('S0001', 'Spirit of Things', 'Floatinurboat NCS', 'G001', 192,
                            'assets/music/spirit_of_things_ncs.mp3'),
  ('S0002', 'Sleepless', 'NCS Release', 'G001', 270, 'assets/music/sleepless_ncs.mp3'),
  ('S0003', 'Lightning', 'NCS Release', 'G001', 213, 'assets/music/lightning_ncs.mp3'),
  ('S0004', 'Gave to me', 'NCS Release', 'G001', 212, 'assets/music/gave_to_me_ncs.mp3'),
  ('S0005', 'Where do I go', 'Brandon Jonak & Pep.B', 'G003', 222, 'assets/music/where_do_i_go.mp3'),
  ('S0006', 'Imposible', 'Alien', 'G002', 201, 'assets/music/imposible.mp3'),
  ('S0007', 'Droeloe', 'Monstercat', 'G001', 211, 'assets/music/droeloe.mp3'),
  ('S0008', 'Slushii', 'Monstercat', 'G001', 146, 'assets/music/slushii.mp3'),
  ('S0009', 'Riot', 'Monstercat', 'G002', 189, 'assets/music/riot.mp3'),
  ('S0010', 'Dirty audio', 'Monstercat', 'G002', 170, 'assets/music/dirty_audio.mp3'),
  ('S0011', 'Kontinuum', 'NCS Release', 'G001', 182, 'assets/music/kontinuum.mp3'),
  ('S0012', 'Skyline', 'Kovan & Electro Light', 'G003', 230, 'assets/music/skiline.mp3'),
  ('S0013', 'Unknown Brain', 'Marvin Divine & NCS Release', 'G003', 197, 'assets/music/unknow_brain.mp3'),
  ('S0014', 'Sicc', 'RetroVision & Domastic', 'G003', 165, 'assets/music/sicc.mp3'),
  ('S0015', 'Dont left it go', 'Anikdote & Culture Code', 'G001', 185, 'assets/music/dont_left_it_go.mp3'),
  ('S0016', 'We do', 'Monstercat', 'G002', 112, 'assets/music/we_do.mp3'),
  ('S0017', 'Discovery', 'Monstercat', 'G002', 184, 'assets/music/dicovery.mp3'),
  ('S0018', 'Bass Drop', 'Monstercat', 'G002', 186, 'assets/music/bass_drop.mp3'),
  ('S0019', 'Make me move', 'Karra & NCS Release', 'G001', 181, 'assets/music/make_me_move.mp3'),
  ('S0020', 'Whole', 'Chime & Adam Tell', 'G001', 187, 'assets/music/whole.mp3'),
  ('S0021', 'All eyes on me', 'Michael White-NCS', 'G001', 204, 'assets/music/all_eyes_on_me.mp3'),
  ('S0022', 'Free', 'Elektronomia & JJD', 'G003', 200, 'assets/music/free.mp3'),
  ('S0023', 'Psycho', 'Four eyes-NCS', 'G003', 208, 'assets/music/psycho.mp3'),
  ('S0024', 'Sweet', 'Unlike Pluto', 'G003', 190, 'assets/music/sweet.mp3');
/*!40000 ALTER TABLE `SONGS`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SONGS_PLAYLISTS`
--

DROP TABLE IF EXISTS `SONGS_PLAYLISTS`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SONGS_PLAYLISTS` (
  `F_SONG_ID` VARCHAR(5) NOT NULL,
  `F_PL_ID`   VARCHAR(5) NOT NULL,
  PRIMARY KEY (`F_SONG_ID`, `F_PL_ID`),
  KEY `F_PL_ID` (`F_PL_ID`),
  CONSTRAINT `SONGS_PLAYLISTS_ibfk_1` FOREIGN KEY (`F_SONG_ID`) REFERENCES `SONGS` (`SONG_ID`)
    ON UPDATE CASCADE,
  CONSTRAINT `SONGS_PLAYLISTS_ibfk_2` FOREIGN KEY (`F_PL_ID`) REFERENCES `PLAYLISTS` (`PL_ID`)
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SONGS_PLAYLISTS`
--

LOCK TABLES `SONGS_PLAYLISTS` WRITE;
/*!40000 ALTER TABLE `SONGS_PLAYLISTS`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `SONGS_PLAYLISTS`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `TYPE`     VARCHAR(5)  NOT NULL,
  `USER_ID`  VARCHAR(5)  NOT NULL,
  `NAME`     VARCHAR(40) NOT NULL,
  `EMAIL`    VARCHAR(40) NOT NULL,
  `USERNAME` VARCHAR(40) NOT NULL,
  `PASSWORD` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `TYPE` (`TYPE`),
  CONSTRAINT `USERS_ibfk_1` FOREIGN KEY (`TYPE`) REFERENCES `USER_TYPES` (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS`
  DISABLE KEYS */;
INSERT INTO `USERS` VALUES
  ('US01', 'U0001', 'Jairo Riaño', 'jairo.riano@uptc.edu.co', 'jairo.riano',
   '47a5e55ae4d8eab18c9cc56bfd2f8ab2'),
  ('US01', 'U0002', 'Jahir Fiquitiva', 'jahir.fiquitiva@gmail.com', 'jahir.fiquitiva',
   'b9fcb8d76554635ab9216864772f10f7'),
  ('US01', 'U0003', 'Sergio Rojas', 'sergio.rojas04@uptc.edu.co', 'sergio.rojas',
   '0b8a01a8fb9013f6e7a0e90f1a8099c1'),
  ('US01', 'U0004', 'Victor Suarez', 'victor.suarez01@uptc.edu.co', 'victor.suarez',
   '4a5f80fa373ee5cfcbf7604aa66b3152');
/*!40000 ALTER TABLE `USERS`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS_SONGS`
--

DROP TABLE IF EXISTS `USERS_SONGS`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS_SONGS` (
  `F_USER_ID` VARCHAR(5) NOT NULL,
  `F_SONG_ID` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`F_USER_ID`, `F_SONG_ID`),
  KEY `F_SONG_ID` (`F_SONG_ID`),
  CONSTRAINT `USERS_SONGS_ibfk_1` FOREIGN KEY (`F_USER_ID`) REFERENCES `USERS` (`USER_ID`)
    ON UPDATE CASCADE,
  CONSTRAINT `USERS_SONGS_ibfk_2` FOREIGN KEY (`F_SONG_ID`) REFERENCES `SONGS` (`SONG_ID`)
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS_SONGS`
--

LOCK TABLES `USERS_SONGS` WRITE;
/*!40000 ALTER TABLE `USERS_SONGS`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `USERS_SONGS`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_TYPES`
--

DROP TABLE IF EXISTS `USER_TYPES`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_TYPES` (
  `ID`          VARCHAR(5)  NOT NULL,
  `DESCRIPTION` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_TYPES`
--

LOCK TABLES `USER_TYPES` WRITE;
/*!40000 ALTER TABLE `USER_TYPES`
  DISABLE KEYS */;
INSERT INTO `USER_TYPES`
VALUES ('US01', 'ADMIN'), ('US02', 'PREMIUM'), ('US03', 'ARTIST'), ('US04', 'NORMAL'),
  ('US05', 'GUEST');
/*!40000 ALTER TABLE `USER_TYPES`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2017-06-18 13:28:46
