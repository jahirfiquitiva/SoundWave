-- MySQL dump 10.16  Distrib 10.2.12-MariaDB, for osx10.13 (x86_64)
--
-- Host: localhost    Database: soundwave
-- ------------------------------------------------------
-- Server version	10.2.12-MariaDB

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `id_album` int(11) NOT NULL AUTO_INCREMENT,
  `name_album` varchar(24) NOT NULL,
  `img_path_album` varchar(150) NOT NULL,
  `release_year_album` int(11) NOT NULL,
  `ARTIST_id_artist` int(11) NOT NULL,
  PRIMARY KEY (`id_album`,`ARTIST_id_artist`),
  UNIQUE KEY `img_path_album_UNIQUE` (`img_path_album`),
  KEY `fk_ALBUM_SINGER1_idx` (`ARTIST_id_artist`),
  CONSTRAINT `fk_ALBUM_SINGER1` FOREIGN KEY (`ARTIST_id_artist`) REFERENCES `artist` (`id_artist`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'Phantom','https://i1.sndcdn.com/artworks-000225347036-c2bg8r-t500x500.jpg',2001,1),(2,'Uplifting','https://i1.sndcdn.com/artworks-000327485997-ge7z2h-t500x500.jpg',2009,3),(3,'Phantom','https://i1.sndcdn.com/artworks-000227526682-qlodkc-t500x500.jpg',2007,2),(4,'Prismo','https://i1.sndcdn.com/artworks-000228011793-1mp015-t500x500.jpg',2005,4),(5,'Mosnters','https://i1.sndcdn.com/artworks-000228761930-uw4sqw-t500x500.jpg',2004,8),(6,'PaintHerad','https://i1.sndcdn.com/artworks-000222434012-2yqck6-t500x500.jpg',2003,6),(7,'Broken','https://i1.sndcdn.com/artworks-000224856191-2t8qlj-t500x500.jpg',2004,7),(8,'Ph','https://i1.sndcdn.com/artworks-000220484881-v2muub-t500x500.jpg',2017,5),(9,'Tobu life','https://i1.sndcdn.com/artworks-000219943203-3go96g-t500x500.jpg',2016,9),(10,'Condeko','https://i1.sndcdn.com/artworks-000219341859-7euouf-t500x500.jpg',2015,10),(11,'Sploot','https://i1.sndcdn.com/artworks-000218689296-qxjf8b-t500x500.jpg',2014,15),(12,'This Life','https://i1.sndcdn.com/artworks-000220114872-2lx5v1-t500x500.jpg',2016,12),(13,'It','https://i1.sndcdn.com/artworks-000206543305-qlafgl-t500x500.jpg',2017,14),(14,'Toom','https://i1.sndcdn.com/artworks-000321976684-ioht1l-t500x500.jpg',2015,13),(15,'Come Alive','https://i1.sndcdn.com/artworks-000358063767-t7fxzq-t500x500.jpg',2011,11);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
  `id_artist` int(11) NOT NULL AUTO_INCREMENT,
  `name_artist` varchar(24) NOT NULL,
  `nick_artist` varchar(16) NOT NULL,
  `email_artist` varchar(45) NOT NULL,
  `password_artist` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_artist`),
  UNIQUE KEY `id_singer_UNIQUE` (`id_artist`),
  UNIQUE KEY `email_user_UNIQUE` (`email_artist`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'Floatinurboat NCS','floatinurboat','floatinurboatncs@hooli.com','677f53abc26be3d9be0bfd4676d7e4ab'),(2,'NCS Release','Release','ncsrelease@hooli.com','123fead50246387983ee340507115ef4'),(3,'Brandon Jonak & Pep.B','Jonak','brandonjonak@hooli.com','7771cbf7a10f027967edfd6eb718a55d'),(4,'Alien','Alien','alien@hooli.com','273910799eacaacec06aba83c9d54906'),(5,'Monstercat','monstercat','monstercat@hooli.com','b9a8869d9fa892ca21d9e7c4cc3ba9a7'),(6,'Kovan & Electro Light','Kovan','kovanelectro@hooli.com','f8221e2deff55c2a14a55a3a3af41a6b'),(7,'Marvin Divine & NCS Rele','Divine','marvindivine@hooli.com','67d46ec7d84ba284982e634970c5b7df'),(8,'RetroVision & Domastic','Vision','retrovision@hooli.com','f42087059b37ae7f4d9f0d3a475801a8'),(9,'Anikdote & Culture Code','Code','anikdote@hooli.com','c13367945d5d4c91047b3b50234aa7ab'),(10,'Karra & NCS Release','karra','karra@hooli.com','f165da20d8e4f33fcb7c90970c121b0d'),(11,'Michael White-NCS','White','michaelwhite@hooli.com','d508fe45cecaf653904a0e774084bb5c'),(12,'Chime & Adam Tell','Chime','chimeadamtell@hooli.com','0478721a7cf7b2b81641cbf75a43a3cb'),(13,'Elektronomia & JJD','Electronic','elektronomia@hooli.com','16518154fcc12cb9c715478443414867'),(14,'Four eyes-NCS','foureyes','foureyes@hooli.com','4e30936bcc50e5dab6e1fca028e63085'),(15,'Unlike Pluto','Pluto','unlikepluto@hooli.com','c6009f08fc5fc6385f1ea1f5840e179f');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `id_genre` int(11) NOT NULL AUTO_INCREMENT,
  `name_genre` varchar(24) NOT NULL,
  `img_path_genre` varchar(150) NOT NULL,
  PRIMARY KEY (`id_genre`),
  UNIQUE KEY `img_path_genre_UNIQUE` (`img_path_genre`),
  UNIQUE KEY `name_genre_UNIQUE` (`name_genre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'EletroHouse','https://i1.sndcdn.com/artworks-000362051544-ob89uk-t500x500.jpg'),(2,'Dubstep','https://i1.sndcdn.com/artworks-000032712130-mr3nkn-t500x500.jpg'),(3,'EletroDance','https://i1.sndcdn.com/artworks-000364916883-7iusr3-t500x500.jpg');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist` (
  `id_playlist` int(11) NOT NULL AUTO_INCREMENT,
  `name_playlist` varchar(24) NOT NULL,
  `USER_id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_playlist`,`USER_id_user`),
  KEY `fk_PLAYLIST_USER_idx` (`USER_id_user`),
  CONSTRAINT `fk_PLAYLIST_USER` FOREIGN KEY (`USER_id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'GYM',2),(2,'STUDY',1);
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_has_song`
--

DROP TABLE IF EXISTS `playlist_has_song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist_has_song` (
  `PLAYLIST_id_playlist` int(11) NOT NULL,
  `SONG_id_song` int(11) NOT NULL,
  PRIMARY KEY (`PLAYLIST_id_playlist`,`SONG_id_song`),
  KEY `fk_PLAYLIST_has_SONG_SONG1_idx` (`SONG_id_song`),
  KEY `fk_PLAYLIST_has_SONG_PLAYLIST1_idx` (`PLAYLIST_id_playlist`),
  CONSTRAINT `fk_PLAYLIST_has_SONG_PLAYLIST1` FOREIGN KEY (`PLAYLIST_id_playlist`) REFERENCES `playlist` (`id_playlist`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PLAYLIST_has_SONG_SONG1` FOREIGN KEY (`SONG_id_song`) REFERENCES `song` (`id_song`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_has_song`
--

LOCK TABLES `playlist_has_song` WRITE;
/*!40000 ALTER TABLE `playlist_has_song` DISABLE KEYS */;
INSERT INTO `playlist_has_song` VALUES (1,5),(1,11),(2,8),(2,23);
/*!40000 ALTER TABLE `playlist_has_song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song` (
  `id_song` int(11) NOT NULL AUTO_INCREMENT,
  `name_song` varchar(24) NOT NULL,
  `track_song` int(11) NOT NULL,
  `length_song` int(11) NOT NULL,
  `path_song` varchar(150) NOT NULL,
  `GENRE_id_genre` int(11) NOT NULL,
  `ALBUM_id_album` int(11) NOT NULL,
  PRIMARY KEY (`id_song`,`GENRE_id_genre`,`ALBUM_id_album`),
  UNIQUE KEY `path_song_UNIQUE` (`path_song`),
  KEY `fk_SONG_GENRE1_idx` (`GENRE_id_genre`),
  KEY `fk_SONG_ALBUM1_idx` (`ALBUM_id_album`),
  CONSTRAINT `fk_SONG_ALBUM1` FOREIGN KEY (`ALBUM_id_album`) REFERENCES `album` (`id_album`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SONG_GENRE1` FOREIGN KEY (`GENRE_id_genre`) REFERENCES `genre` (`id_genre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'Spirit of Things',1,192,'assets/music/spirit_of_things_ncs.mp3',1,1),(2,'Sleepless',1,270,'assets/music/sleepless_ncs.mp3',1,3),(3,'Lightning',2,213,'assets/music/lightning_ncs.mp3',1,3),(4,'Gave to me',3,212,'assets/music/gave_to_me_ncs.mp3',2,3),(5,'Where do I go',1,222,'assets/music/where_do_i_go.mp3',3,2),(6,'Imposible',1,201,'assets/music/imposible.mp3',3,4),(7,'Droeloe',1,211,'assets/music/droeloe.mp3',1,8),(8,'Slushii',2,146,'assets/music/slushii.mp3',1,8),(9,'Riot',3,189,'assets/music/riot.mp3',2,8),(10,'Dirty audio',4,170,'assets/music/dirty_audio.mp3',2,8),(11,'Kontinuum',4,182,'assets/music/kontinuum.mp3',1,3),(12,'Skyline',1,230,'assets/music/skiline.mp3',3,6),(13,'Unknown Brain',1,197,'assets/music/unknow_brain.mp3',3,7),(14,'Sicc',1,165,'assets/music/sicc.mp3',3,5),(15,'Dont left it go',1,185,'assets/music/dont_left_it_go.mp3',1,9),(16,'We do',5,112,'assets/music/we_do.mp3',2,8),(17,'Discovery',6,184,'assets/music/discovery.mp3',2,8),(18,'Bass Drop',7,186,'assets/music/bass_drop.mp3',2,8),(19,'Make me move',1,181,'assets/music/make_me_move.mp3',1,10),(20,'Whole',0,187,'assets/music/whole.mp3',1,15),(21,'All eyes on me',1,204,'assets/music/all_eyes_on_me.mp3',1,15),(22,'Free',1,200,'assets/music/free.mp3',3,14),(23,'Psycho',1,208,'assets/music/psycho.mp3',3,13),(24,'Sweet',1,190,'assets/music/sweet.mp3',3,11);
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `doc_user` int(11) NOT NULL,
  `name_user` varchar(24) NOT NULL,
  `last_name_user` varchar(24) NOT NULL,
  `age_user` int(11) NOT NULL,
  `nick_user` varchar(16) NOT NULL,
  `email_user` varchar(45) NOT NULL,
  `password_user` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  UNIQUE KEY `doc_user_UNIQUE` (`doc_user`),
  UNIQUE KEY `nick_user_UNIQUE` (`nick_user`),
  UNIQUE KEY `email_user_UNIQUE` (`email_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1055274577,'Sergio','Rojas',20,'sarl','sergioandresrojasleon@gmail.com','3237f19d94b7798c28f268653e7656c3'),(2,1057275856,'Jahir','Fiquitiva',22,'jffr','Jahir.fiquitiva@gmail.com','23af2638899dca1c911fa86ee0b501e2'),(4,123456,'Pepe','Perez',18,'pepepe','pepe@gmail.com','ccc13534d127ed9357824da53023c5f9');
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

-- Dump completed on 2018-07-01 16:11:13
