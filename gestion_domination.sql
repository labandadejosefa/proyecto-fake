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
  `altura` varchar(45) NOT NULL,
  `localidad` varchar(45) NOT NULL,
  `cpostal` varchar(20) NOT NULL,
  PRIMARY KEY (`id_domicilio`),
  UNIQUE KEY `id_UNIQUE` (`id_domicilio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,'Av Belgrano','520','CABA','1064'),(2,'Chile','740','CABA','1065');
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
  `nombre_objeto` varchar(45) NOT NULL,
  `precio_hora` double NOT NULL,
  `precio_min` double NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `sede_id` int(11) NOT NULL,
  PRIMARY KEY (`id_objeto`),
  KEY `id_sede_idx` (`sede_id`),
  CONSTRAINT `sede_id` FOREIGN KEY (`sede_id`) REFERENCES `sede` (`id_sede`) ON UPDATE CASCADE,
  CONSTRAINT `CONSTRAINT_1` CHECK (`tipo` in ('SalaEnsayo','Instrumento')),
  CONSTRAINT `CONSTRAINT_2` CHECK (`tipo` in ('SalaEnsayo','Instrumento'))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objetoReservable`
--

LOCK TABLES `objetoReservable` WRITE;
/*!40000 ALTER TABLE `objetoReservable` DISABLE KEYS */;
INSERT INTO `objetoReservable` VALUES (1,'Contrabajo Segovia 3/4',3500,2000,'Instrumento',1),(2,'Sala A',4500,3500,'SalaEnsayo',1);
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
  KEY `id_reservable_idx` (`objeto_id`),
  KEY `id_usuario` (`usuario_id`),
  CONSTRAINT `id_objeto` FOREIGN KEY (`objeto_id`) REFERENCES `objetoReservable` (`id_objeto`) ON UPDATE CASCADE,
  CONSTRAINT `id_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,2,2,'2023-11-10 06:06:34',1,4500),(2,1,2,'2023-11-10 13:30:00',2,9000);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(30) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Prestador'),(3,'Cliente');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sede`
--

DROP TABLE IF EXISTS `sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sede` (
  `id_sede` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_sede` varchar(45) NOT NULL,
  `domicilio_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id_sede`),
  KEY `domicilio_id` (`domicilio_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `domicilio_id` FOREIGN KEY (`domicilio_id`) REFERENCES `domicilio` (`id_domicilio`) ON UPDATE CASCADE,
  CONSTRAINT `usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sede`
--

LOCK TABLES `sede` WRITE;
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` VALUES (1,'Sounds',1,3);
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
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_UNIQUE` (`email_usuario`),
  KEY `_idx` (`rol_id`),
  CONSTRAINT `rol_id` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id_rol`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Pepin','peters','lalalala','55555','14521',2),(2,'hola','chau','ooooo','563214','820',1),(3,'Eddie','Vedder','eddie@gmail.com','pjam2023','5555',2);
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

-- Dump completed on 2023-11-10  4:44:21
