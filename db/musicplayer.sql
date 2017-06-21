-- MySQL dump 10.16  Distrib 10.1.21-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.21-MariaDB

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
-- Current Database: `musicplayer`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `musicplayer` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `musicplayer`;

--
-- Table structure for table `GENRES`
--

DROP TABLE IF EXISTS `GENRES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GENRES` (
  `GENRE_ID` varchar(4) NOT NULL,
  `DESCRIPTION` varchar(40) NOT NULL,
  `IMG_PATH` varchar(200) NOT NULL,
  PRIMARY KEY (`GENRE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GENRES`
--

LOCK TABLES `GENRES` WRITE;
/*!40000 ALTER TABLE `GENRES` DISABLE KEYS */;
INSERT INTO `GENRES` VALUES ('G001','ElectroHouse','https://i1.sndcdn.com/artworks-000227378436-y07in3-t500x500.jpg'),('G002','Dubstep','http://3.bp.blogspot.com/--pem6TeduTg/TiXe97AyVlI/AAAAAAAAACU/ou6R6fM-j58/s1600/pop.jpg'),('G003','ElectroDance','https://i1.sndcdn.com/artworks-000228571109-9v1ty0-t500x500.jpg');
/*!40000 ALTER TABLE `GENRES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYLISTS`
--

DROP TABLE IF EXISTS `PLAYLISTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLAYLISTS` (
  `PL_ID` varchar(5) NOT NULL,
  `NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`PL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYLISTS`
--

LOCK TABLES `PLAYLISTS` WRITE;
/*!40000 ALTER TABLE `PLAYLISTS` DISABLE KEYS */;
INSERT INTO `PLAYLISTS` VALUES ('FAVS','Favorites'),('PL001','Gimnasio'),('PL002','Nueva'),('PL003','Hola');
/*!40000 ALTER TABLE `PLAYLISTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYLISTS_USERS`
--

DROP TABLE IF EXISTS `PLAYLISTS_USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLAYLISTS_USERS` (
  `F_PL_ID` varchar(5) NOT NULL,
  `F_USER_ID` varchar(5) NOT NULL,
  PRIMARY KEY (`F_PL_ID`,`F_USER_ID`),
  KEY `F_USER_ID` (`F_USER_ID`),
  CONSTRAINT `PLAYLISTS_USERS_ibfk_1` FOREIGN KEY (`F_PL_ID`) REFERENCES `PLAYLISTS` (`PL_ID`) ON UPDATE CASCADE,
  CONSTRAINT `PLAYLISTS_USERS_ibfk_2` FOREIGN KEY (`F_USER_ID`) REFERENCES `USERS` (`USER_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYLISTS_USERS`
--

LOCK TABLES `PLAYLISTS_USERS` WRITE;
/*!40000 ALTER TABLE `PLAYLISTS_USERS` DISABLE KEYS */;
INSERT INTO `PLAYLISTS_USERS` VALUES ('FAVS','U0002'),('PL001','U0002'),('PL002','U0002'),('PL003','U0002');
/*!40000 ALTER TABLE `PLAYLISTS_USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SONGS`
--

DROP TABLE IF EXISTS `SONGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SONGS` (
  `SONG_ID` varchar(5) NOT NULL,
  `NAME` varchar(40) NOT NULL,
  `ARTIST` varchar(40) NOT NULL,
  `GENRE` varchar(4) NOT NULL,
  `FILE_PATH` varchar(100) NOT NULL,
  `IMG_PATH` varchar(200) NOT NULL,
  PRIMARY KEY (`SONG_ID`),
  KEY `GENRE` (`GENRE`),
  CONSTRAINT `SONGS_ibfk_1` FOREIGN KEY (`GENRE`) REFERENCES `GENRES` (`GENRE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SONGS`
--

LOCK TABLES `SONGS` WRITE;
/*!40000 ALTER TABLE `SONGS` DISABLE KEYS */;
INSERT INTO `SONGS` VALUES ('S0001','Spirit of Things','floatinurboat','G001','assets/music/spirit_of_things.mp3','https://i1.sndcdn.com/artworks-000227625218-5u67k2-t500x500.jpg'),('S0002','Sleepless','ncs.release','G001','assets/music/sleepless.mp3','https://i1.sndcdn.com/artworks-000225347036-c2bg8r-t500x500.jpg'),('S0003','Lightning','ncs.release','G001','assets/music/lightning.mp3','https://i1.sndcdn.com/artworks-000225852881-pk95lg-t500x500.jpg'),('S0004','Gave to me','ncs.release','G001','assets/music/gave_to_me.mp3','https://i1.sndcdn.com/artworks-000225347036-c2bg8r-t500x500.jpg'),('S0005','Where do I go','brandon','G003','assets/music/where_do_i_go.mp3','https://i1.sndcdn.com/artworks-000219688327-32sd7f-t500x500.jpg'),('S0006','Imposible','alien','G002','assets/music/imposible.mp3','https://i1.sndcdn.com/artworks-000227526682-qlodkc-t500x500.jpg'),('S0007','Droeloe','monstercat','G001','assets/music/droeloe.mp3','https://i1.sndcdn.com/artworks-000228761930-uw4sqw-t500x500.jpg'),('S0008','Slushii','monstercat','G001','assets/music/slushii.mp3','https://i1.sndcdn.com/artworks-000228011793-1mp015-t500x500.jpg'),('S0009','Riot','monstercat','G002','assets/music/riot.mp3','https://i1.sndcdn.com/artworks-000227210598-cg71d7-t500x500.jpg'),('S0010','Dirty audio','monstercat','G002','assets/music/dirty_audio.mp3','https://i1.sndcdn.com/artworks-000225651456-ypd7ay-t500x500.jpg'),('S0011','Kontinuum','ncs.release','G001','assets/music/kontinuum.mp3','https://i1.sndcdn.com/artworks-000224978962-mn9lmp-t500x500.jpg'),('S0012','Skyline','kovan','G003','assets/music/skiline.mp3','https://i1.sndcdn.com/artworks-000224616021-j9uv1f-t500x500.jpg'),('S0013','Unknown Brain','marvin.divine','G003','assets/music/unknow_brain.mp3','https://i1.sndcdn.com/artworks-000223136404-gh0bj7-t500x500.jpg'),('S0014','Sicc','retrovision','G003','assets/music/sicc.mp3','https://i1.sndcdn.com/artworks-000222434012-2yqck6-t500x500.jpg'),('S0015','Dont let it go','anikdote','G001','assets/music/dont_left_it_go.mp3','https://i1.sndcdn.com/artworks-000222122845-o35pkp-t500x500.jpg'),('S0016','We do','monstercat','G002','assets/music/we_do.mp3','https://i1.sndcdn.com/artworks-000224856191-2t8qlj-t500x500.jpg'),('S0017','Discovery','monstercat','G002','assets/music/dicovery.mp3','https://i1.sndcdn.com/artworks-000224856191-2t8qlj-t500x500.jpg'),('S0018','Bass Drop','monstercat','G002','assets/music/bass_drop.mp3','https://i1.sndcdn.com/artworks-000220489672-uqnbk6-t500x500.jpg'),('S0019','Make me move','karra','G001','assets/music/make_me_move.mp3','https://i1.sndcdn.com/artworks-000221373876-hm35dg-t500x500.jpg'),('S0020','Whole','chime','G001','assets/music/whole.mp3','https://i1.sndcdn.com/artworks-000220484881-v2muub-t500x500.jpg'),('S0021','All eyes on me','michael.white','G001','assets/music/all_eyes_on_me.mp3','https://i1.sndcdn.com/artworks-000219943203-3go96g-t500x500.jpg'),('S0022','Free','elektronomia','G003','assets/music/free.mp3','https://i1.sndcdn.com/artworks-000219341859-7euouf-t500x500.jpg'),('S0023','Psycho','foureyes','G003','assets/music/psycho.mp3','https://i1.sndcdn.com/artworks-000218689296-qxjf8b-t500x500.jpg'),('S0024','Sweet','unlike.pluto','G003','assets/music/sweet.mp3','https://i1.sndcdn.com/artworks-000220114872-2lx5v1-t500x500.jpg');
/*!40000 ALTER TABLE `SONGS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SONGS_PLAYLISTS`
--

DROP TABLE IF EXISTS `SONGS_PLAYLISTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SONGS_PLAYLISTS` (
  `F_SONG_ID` varchar(5) NOT NULL,
  `F_PL_ID` varchar(5) NOT NULL,
  PRIMARY KEY (`F_SONG_ID`,`F_PL_ID`),
  KEY `F_PL_ID` (`F_PL_ID`),
  CONSTRAINT `SONGS_PLAYLISTS_ibfk_1` FOREIGN KEY (`F_SONG_ID`) REFERENCES `SONGS` (`SONG_ID`) ON UPDATE CASCADE,
  CONSTRAINT `SONGS_PLAYLISTS_ibfk_2` FOREIGN KEY (`F_PL_ID`) REFERENCES `PLAYLISTS` (`PL_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SONGS_PLAYLISTS`
--

LOCK TABLES `SONGS_PLAYLISTS` WRITE;
/*!40000 ALTER TABLE `SONGS_PLAYLISTS` DISABLE KEYS */;
INSERT INTO `SONGS_PLAYLISTS` VALUES ('S0002','FAVS'),('S0003','PL002');
/*!40000 ALTER TABLE `SONGS_PLAYLISTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `TYPE` varchar(5) NOT NULL,
  `USER_ID` varchar(5) NOT NULL,
  `NAME` varchar(40) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `USERNAME` varchar(40) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `TYPE` (`TYPE`),
  CONSTRAINT `USERS_ibfk_1` FOREIGN KEY (`TYPE`) REFERENCES `USER_TYPES` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES ('US01','U0001','Jairo Riaño','jairo.riano@uptc.edu.co','jairo.riano','47a5e55ae4d8eab18c9cc56bfd2f8ab2'),('US01','U0002','Jahir Fiquitiva','jahir.fiquitiva@gmail.com','jahir.fiquitiva','b9fcb8d76554635ab9216864772f10f7'),('US01','U0003','Sergio Rojas','sergio.rojas04@uptc.edu.co','sergio.rojas','0b8a01a8fb9013f6e7a0e90f1a8099c1'),('US01','U0004','Victor Suarez','victor.suarez01@uptc.edu.co','victor.suarez','4a5f80fa373ee5cfcbf7604aa66b3152'),('US02','U0005','Alien','alien@artists.co','alien','273910799eacaacec06aba83c9d54906'),('US02','U0006','Anikdote & Culture Code','anikdote@artists.co','anikdote','86f846e13f93d27147a075f7a49da0b6'),('US02','U0007','Brandon Jonak & Pep.B','brandon@artists.co','brandon','fc275ac3498d6ab0f0b4389f8e94422c'),('US02','U0008','Chime & Adam Tell','chime@artists.co','chime','0478721a7cf7b2b81641cbf75a43a3cb'),('US02','U0009','Elektronomia & JJD','elektronomia@artists.co','elektronomia','6a2a63ad0b6d096b1cb9d692c2f0d4cb'),('US02','U0010','Floatinurboat NCS','floatinurboat@artists.co','floatinurboat','677f53abc26be3d9be0bfd4676d7e4ab'),('US02','U0011','Four Eyes - NCS','foureyes@artists.co','foureyes','4e30936bcc50e5dab6e1fca028e63085'),('US02','U0012','Karra & NCS Release','karra@artists.co','karra','f165da20d8e4f33fcb7c90970c121b0d'),('US02','U0013','Kovan & Electro Light','kovan@artists.co','kovan','f8221e2deff55c2a14a55a3a3af41a6b'),('US02','U0014','Marvin Divine & NCS Release','marvin.divine@artists.co','marvin.divine','02cbb74d68d15bb703cb16999e295670'),('US02','U0015','Michael White - NCS','michael.white@artists.co','michael.white','e903dbd71aa5a9227400d59fc889b76c'),('US02','U0016','Monstercat','monstercat@artists.co','monstercat','b9a8869d9fa892ca21d9e7c4cc3ba9a7'),('US02','U0017','NCS Release','ncs.release@artists.co','ncs.release','47aca31ea6b07eb5cca5a1e2ed98e2d6'),('US02','U0018','Retrovision & Domastic','retrovision@artists.co','retrovision','d87528910381b1a177500804d90d99bd'),('US02','U0019','Unlike Pluto','unlike.pluto@artists.co','unlike.pluto','f63f26bce953ee55274e477c7a273279');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS_SONGS`
--

DROP TABLE IF EXISTS `USERS_SONGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS_SONGS` (
  `F_USER_ID` varchar(5) NOT NULL,
  `F_SONG_ID` varchar(5) NOT NULL,
  PRIMARY KEY (`F_USER_ID`,`F_SONG_ID`),
  KEY `F_SONG_ID` (`F_SONG_ID`),
  CONSTRAINT `USERS_SONGS_ibfk_1` FOREIGN KEY (`F_USER_ID`) REFERENCES `USERS` (`USER_ID`) ON UPDATE CASCADE,
  CONSTRAINT `USERS_SONGS_ibfk_2` FOREIGN KEY (`F_SONG_ID`) REFERENCES `SONGS` (`SONG_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS_SONGS`
--

LOCK TABLES `USERS_SONGS` WRITE;
/*!40000 ALTER TABLE `USERS_SONGS` DISABLE KEYS */;
/*!40000 ALTER TABLE `USERS_SONGS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_TYPES`
--

DROP TABLE IF EXISTS `USER_TYPES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_TYPES` (
  `ID` varchar(5) NOT NULL,
  `DESCRIPTION` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_TYPES`
--

LOCK TABLES `USER_TYPES` WRITE;
/*!40000 ALTER TABLE `USER_TYPES` DISABLE KEYS */;
INSERT INTO `USER_TYPES` VALUES ('US01','ADMIN'),('US02','ARTIST'),('US03','NORMAL'),('US04','GUEST');
/*!40000 ALTER TABLE `USER_TYPES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-20 23:38:26
