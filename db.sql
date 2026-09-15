CREATE DATABASE  IF NOT EXISTS `bd_tp_grupal_oo2_grupo11` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_tp_grupal_oo2_grupo11`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_tp_grupal_oo2_grupo11
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cajero`
--

DROP TABLE IF EXISTS `cajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cajero` (
  `idCajero` bigint NOT NULL,
  `turnoTrabajo` varchar(255) NOT NULL,
  `plusAntiguedad` double NOT NULL,
  PRIMARY KEY (`idCajero`),
  CONSTRAINT `FKhwswbfupq5t5nlb8f2q9935pj` FOREIGN KEY (`idCajero`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cajero`
--

LOCK TABLES `cajero` WRITE;
/*!40000 ALTER TABLE `cajero` DISABLE KEYS */;
INSERT INTO `cajero` VALUES (1,'Mañana',500),(3,'Noche',700),(5,'Tarde',900),(6,'Mañana',2100),(8,'Tarde',1100),(10,'Noche',900),(12,'Mañana',1300);
/*!40000 ALTER TABLE `cajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cocinero`
--

DROP TABLE IF EXISTS `cocinero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cocinero` (
  `idCocinero` bigint NOT NULL,
  `categoria` bigint NOT NULL,
  `especialidad` varchar(255) NOT NULL,
  `porcentaje` bigint NOT NULL,
  PRIMARY KEY (`idCocinero`),
  CONSTRAINT `FKj1eyosxlb31ueour4o4gq1bbi` FOREIGN KEY (`idCocinero`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cocinero`
--

LOCK TABLES `cocinero` WRITE;
/*!40000 ALTER TABLE `cocinero` DISABLE KEYS */;
INSERT INTO `cocinero` VALUES (2,1,'Pizza',10),(4,1,'Hamburguesa',800),(7,2,'Sushi',12),(9,3,'Pastas',15),(11,2,'Mariscos',18);
/*!40000 ALTER TABLE `cocinero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `dni` bigint NOT NULL,
  `fechNacimiento` date NOT NULL,
  `fechaIngreso` date NOT NULL,
  `sueldoBase` double NOT NULL,
  `idUnidadVenta` bigint DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `UK_anilfn0t89ht43r8n8lthr5b6` (`dni`),
  KEY `FK1u64hsk5prfmajlq8uj6r3mmg` (`idUnidadVenta`),
  CONSTRAINT `FK1u64hsk5prfmajlq8uj6r3mmg` FOREIGN KEY (`idUnidadVenta`) REFERENCES `unidadventa` (`idUnidadVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Nicolás','Ledesma',18061993,'1993-06-18','2021-03-10',700000,2),(2,'María','González',15071989,'1989-07-15','2018-02-20',800000,1),(3,'Juan','Pérez',20081994,'1994-08-20','2022-05-12',700000,1),(4,'Lucía','Martínez',25091996,'1996-09-25','2020-11-08',800000,1),(5,'Carlos','Rodríguez',30101998,'1998-10-30','2023-04-15',50000,2),(6,'Carlos','López',18111987,'1987-11-18','2020-01-10',31000,3),(7,'Sofía','Benítez',4042000,'2000-04-04','2023-06-01',620000,2),(8,'Mateo','Gómez',12072001,'2001-07-12','2024-01-15',580000,2),(9,'Valentina','Silva',22091994,'1994-09-22','2021-09-03',760000,2),(10,'Tomás','Rojas',7111992,'1992-11-07','2022-02-22',650000,3),(11,'Florencia','Acosta',29082095,'1995-08-29','2023-05-05',710000,3),(12,'Ezequiel','Morales',14021989,'1989-02-14','2019-08-12',690000,1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `festival`
--

DROP TABLE IF EXISTS `festival`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `festival` (
  `idFestival` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `temporada` varchar(255) NOT NULL,
  `fechInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `costoSuperficie` double NOT NULL,
  `costoMontaje` double NOT NULL,
  `plusElectricidad` double NOT NULL,
  PRIMARY KEY (`idFestival`),
  UNIQUE KEY `UK_sqsia62xd54vbnd8atpe4wjic` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `festival`
--

LOCK TABLES `festival` WRITE;
/*!40000 ALTER TABLE `festival` DISABLE KEYS */;
INSERT INTO `festival` VALUES (1,'Sabores del Sur','Verano','2026-12-15','2026-12-21',500,10,2000),(2,'Festival Gastronómico','Otoño','2026-04-10','2026-04-16',500,10,2000),(3,'Festival de Lanús','Invierno','2026-07-15','2026-07-21',500,10,2000);
/*!40000 ALTER TABLE `festival` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foodtruck`
--

DROP TABLE IF EXISTS `foodtruck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foodtruck` (
  `idFoodTruck` bigint NOT NULL,
  `patente` varchar(255) NOT NULL,
  `conexionElectrica` bit(1) NOT NULL,
  PRIMARY KEY (`idFoodTruck`),
  CONSTRAINT `FK8awgadxbwk7envtkao56p5tgr` FOREIGN KEY (`idFoodTruck`) REFERENCES `unidadventa` (`idUnidadVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodtruck`
--

LOCK TABLES `foodtruck` WRITE;
/*!40000 ALTER TABLE `foodtruck` DISABLE KEYS */;
INSERT INTO `foodtruck` VALUES (2,'AJL199',_binary ''),(3,'SUX999',_binary '');
/*!40000 ALTER TABLE `foodtruck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itempedido`
--

DROP TABLE IF EXISTS `itempedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itempedido` (
  `idItemPedido` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` bigint NOT NULL,
  `idPedido` bigint NOT NULL,
  `idPlato` bigint NOT NULL,
  PRIMARY KEY (`idItemPedido`),
  KEY `FKc2n0dqtp4ffnlr6cwubr5xy1c` (`idPedido`),
  KEY `FK16mr6v8076sx54cnqk6633ust` (`idPlato`),
  CONSTRAINT `FK16mr6v8076sx54cnqk6633ust` FOREIGN KEY (`idPlato`) REFERENCES `plato` (`idPlato`),
  CONSTRAINT `FKc2n0dqtp4ffnlr6cwubr5xy1c` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itempedido`
--

LOCK TABLES `itempedido` WRITE;
/*!40000 ALTER TABLE `itempedido` DISABLE KEYS */;
INSERT INTO `itempedido` VALUES (1,2,1,1),(2,1,1,2),(3,2,1,5),(4,3,2,3),(5,4,2,4),(6,1,3,6),(7,2,3,8),(8,3,3,11),(9,2,4,9),(10,1,4,10),(11,4,4,13),(12,2,5,2),(13,3,5,4),(14,1,5,5),(15,2,6,7),(16,1,6,12),(17,3,7,14),(18,2,7,17),(19,1,8,18),(20,4,8,7),(21,2,9,12),(22,1,9,14),(23,3,9,17),(24,3,10,7),(25,2,10,18),(26,2,11,15),(27,3,11,16),(28,1,12,19),(29,2,12,20),(30,3,13,15),(31,1,13,19),(32,2,14,16),(33,4,14,20),(34,1,15,15),(35,1,15,16),(36,2,15,19),(37,1,15,20);
/*!40000 ALTER TABLE `itempedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idPedido` bigint NOT NULL AUTO_INCREMENT,
  `fechaTransaccion` datetime(6) NOT NULL,
  `cerrado` bit(1) NOT NULL,
  `idUnidadVenta` bigint NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `FKdgsktycffu8tyl3amrgbx4gfs` (`idUnidadVenta`),
  CONSTRAINT `FKdgsktycffu8tyl3amrgbx4gfs` FOREIGN KEY (`idUnidadVenta`) REFERENCES `unidadventa` (`idUnidadVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2026-12-15 11:15:00.000000',_binary '',1),(2,'2026-12-16 12:00:00.000000',_binary '',1),(3,'2026-12-17 18:10:00.000000',_binary '',1),(4,'2026-12-18 20:05:00.000000',_binary '',1),(5,'2026-12-19 14:20:00.000000',_binary '',1),(6,'2026-12-15 13:00:00.000000',_binary '',2),(7,'2026-12-17 10:30:00.000000',_binary '',2),(8,'2026-12-18 19:40:00.000000',_binary '',2),(9,'2026-12-19 12:50:00.000000',_binary '',2),(10,'2026-12-21 15:20:00.000000',_binary '',2),(11,'2026-12-15 18:15:00.000000',_binary '',3),(12,'2026-12-17 13:45:00.000000',_binary '',3),(13,'2026-12-18 13:35:00.000000',_binary '',3),(14,'2026-12-19 17:55:00.000000',_binary '',3),(15,'2026-12-21 20:10:00.000000',_binary '',3);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plato` (
  `idPlato` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `precioVenta` double NOT NULL,
  `costoProduccion` double NOT NULL,
  `idUnidadVenta` bigint NOT NULL,
  PRIMARY KEY (`idPlato`),
  UNIQUE KEY `UK_rd2kuqgarl3hvul9kpr864dmh` (`nombre`),
  KEY `FKgvo6so3wrxwrw3mylc664lvih` (`idUnidadVenta`),
  CONSTRAINT `FKgvo6so3wrxwrw3mylc664lvih` FOREIGN KEY (`idUnidadVenta`) REFERENCES `unidadventa` (`idUnidadVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (1,'Choripán',950,420,1),(2,'Hamburguesa doble',1400,620,1),(3,'Milanesa napolitana',1550,700,1),(4,'Empanada de carne',250,105,1),(5,'Taco de pollo',280,130,1),(6,'Lomito con papas',1800,900,1),(7,'Pizza fugazzeta',1450,680,1),(8,'Sandwich de milanesa',1200,540,1),(9,'Wrap de pollo',1050,470,1),(10,'Quesadilla de carne',11000,470,1),(11,'Churros con dulce de leche',600,220,1),(12,'Pizza margarita',1400,600,2),(13,'Ensalada César con pollo',1300,610,2),(14,'Pizza napolitana',1500,650,2),(15,'Nigiri',520,200,2),(16,'Tempura',380,140,2),(17,'Pizza de calabresa',3000,720,3),(18,'Pizza cuatro quesos',1850,780,3),(19,'Sashimi de salmón',980,360,3),(20,'Roll de atún',1150,430,3);
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puestodesarmable`
--

DROP TABLE IF EXISTS `puestodesarmable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puestodesarmable` (
  `idPuestoDesarmable` bigint NOT NULL,
  `cantidadDeCarpas` bigint NOT NULL,
  `tiempoMontaje` bigint NOT NULL,
  PRIMARY KEY (`idPuestoDesarmable`),
  CONSTRAINT `FKaqsqlrncqhddagfsbpphd4agy` FOREIGN KEY (`idPuestoDesarmable`) REFERENCES `unidadventa` (`idUnidadVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puestodesarmable`
--

LOCK TABLES `puestodesarmable` WRITE;
/*!40000 ALTER TABLE `puestodesarmable` DISABLE KEYS */;
INSERT INTO `puestodesarmable` VALUES (1,4,2);
/*!40000 ALTER TABLE `puestodesarmable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadventa`
--

DROP TABLE IF EXISTS `unidadventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidadventa` (
  `idUnidadVenta` bigint NOT NULL AUTO_INCREMENT,
  `nombreComercial` varchar(255) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  `superficie` double NOT NULL,
  `idFestival` bigint NOT NULL,
  `idResponsable` bigint DEFAULT NULL,
  PRIMARY KEY (`idUnidadVenta`),
  UNIQUE KEY `UK_lgwjqftlphhpr36qns69r0j0g` (`codigo`),
  KEY `FKdu0aqr3nngh8cgkad48tkif5r` (`idFestival`),
  KEY `FKsg45jrjfwlkkpkl7cjrbrt7er` (`idResponsable`),
  CONSTRAINT `FKdu0aqr3nngh8cgkad48tkif5r` FOREIGN KEY (`idFestival`) REFERENCES `festival` (`idFestival`),
  CONSTRAINT `FKsg45jrjfwlkkpkl7cjrbrt7er` FOREIGN KEY (`idResponsable`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadventa`
--

LOCK TABLES `unidadventa` WRITE;
/*!40000 ALTER TABLE `unidadventa` DISABLE KEYS */;
INSERT INTO `unidadventa` VALUES (1,'Hamburguesas Deliciosas','HBD123',15,1,2),(2,'Pizzas Ledesma','AJL199',10,1,1),(3,'Sushi Express','SE-001',18,1,6);
/*!40000 ALTER TABLE `unidadventa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-15  3:41:37
