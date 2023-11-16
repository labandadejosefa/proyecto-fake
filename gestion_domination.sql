-- MariaDB dump 10.19  Distrib 10.6.12-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: gestion_domination
-- ------------------------------------------------------
-- Server version	10.6.12-MariaDB-0ubuntu0.22.04.1

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
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domicilio` (
  `id_domicilio` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(45) NOT NULL,
  `altura` varchar(10) NOT NULL,
  `localidad` varchar(45) NOT NULL,
  `cpostal` varchar(10) NOT NULL,
  PRIMARY KEY (`id_domicilio`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,'Perú','572','CABA','1068'),(3,'Ayacucho','2250','Gral. San Martín','1650'),(4,'Diagonal 78','541','La Plata','1900'),(6,'Av. Segurola','4310','CABA','1419');
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objetoReservable`
--

DROP TABLE IF EXISTS `objetoReservable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objetoReservable` (
  `id_objeto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio_hora` double NOT NULL,
  `tipo_objeto` varchar(45) NOT NULL,
  `sede_id` int(11) NOT NULL,
  PRIMARY KEY (`id_objeto`),
  KEY `sede_id_idx` (`sede_id`),
  CONSTRAINT `sede_id` FOREIGN KEY (`sede_id`) REFERENCES `sede` (`id_sede`) ON UPDATE CASCADE,
  CONSTRAINT `CONSTRAINT_1` CHECK (`tipo_objeto` in ('SalaEnsayo','Instrumento')),
  CONSTRAINT `CONSTRAINT_2` CHECK (`tipo_objeto` in ('SalaEnsayo','Instrumento')),
  CONSTRAINT `CONSTRAINT_3` CHECK (`tipo_objeto` in ('SalaEnsayo','Instrumento'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objetoReservable`
--

LOCK TABLES `objetoReservable` WRITE;
/*!40000 ALTER TABLE `objetoReservable` DISABLE KEYS */;
/*!40000 ALTER TABLE `objetoReservable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `objeto_id` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `duracion_hs` int(10) unsigned NOT NULL,
  `precio_reserva` double NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `usuario_id_idx` (`usuario_id`),
  KEY `objeto_id_idx` (`objeto_id`),
  CONSTRAINT `objeto_id` FOREIGN KEY (`objeto_id`) REFERENCES `objetoReservable` (`id_objeto`) ON UPDATE CASCADE,
  CONSTRAINT `usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sede`
--

DROP TABLE IF EXISTS `sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sede` (
  `id_sede` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `domicilio_id` int(11) NOT NULL,
  `usuario_sede_id` int(11) NOT NULL,
  PRIMARY KEY (`id_sede`),
  KEY `usuario_sede_id_idx` (`usuario_sede_id`),
  KEY `domicilio_id_idx` (`domicilio_id`),
  CONSTRAINT `domicilio_id` FOREIGN KEY (`domicilio_id`) REFERENCES `domicilio` (`id_domicilio`) ON UPDATE CASCADE,
  CONSTRAINT `usuario_sede_id` FOREIGN KEY (`usuario_sede_id`) REFERENCES `usuario` (`id_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sede`
--

LOCK TABLES `sede` WRITE;
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` VALUES (1,'CrackSM',3,2),(2,'Descamisados LP',4,4);
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email_usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `rol_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_usuario_UNIQUE` (`email_usuario`),
  CONSTRAINT `CONSTRAINT_1` CHECK (`rol_usuario` in ('admin','prestador','cliente')),
  CONSTRAINT `CONSTRAINT_2` CHECK (`rol_usuario` in ('admin','prestador','cliente')),
  CONSTRAINT `CONSTRAINT_3` CHECK (`rol_usuario` in ('admin','prestador','cliente'))
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Marta','Minujin','martita@gmail.com','seniamarta123','1185720009','cliente'),(2,'Patricio','Estrella','patrick99@gmail.com','fondobikini777','22182463','prestador'),(3,'David','Grohl','davefighter@gmail.com','learningtofly','117100634','cliente'),(4,'Eva','Duarte','evitacapitana@gmail.com','seremillones1952','2358638710','prestador'),(5,'Carol','Pérez','perekarolina@gmail.com','aguantetodo','1178787878','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-16  5:56:20
