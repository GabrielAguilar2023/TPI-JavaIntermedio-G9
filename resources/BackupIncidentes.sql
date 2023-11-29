CREATE DATABASE  IF NOT EXISTS `reporte_incidentes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `reporte_incidentes`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: reporte_incidentes
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Juan B.Justo 435','Optica La Torre','20252545'),(2,'San Martin 345','Juan Ordoñez','45464564'),(3,'Viamonte 435','Daniela Arcila','54945645'),(4,'Agustin Tejeda 676','Marcelo Argañaraz','435982532'),(5,'Bedoya 895','Libreria \'La Esquina\'','45353456');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratos`
--

DROP TABLE IF EXISTS `contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contratos` (
  `idContrato` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idServicioContratado` int NOT NULL,
  PRIMARY KEY (`idContrato`),
  KEY `FKl2r8oxudtogldfp7ytf89i397` (`idCliente`),
  KEY `FKo7of6p0oqjhqfuscvu91gmcnu` (`idServicioContratado`),
  CONSTRAINT `FKl2r8oxudtogldfp7ytf89i397` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  CONSTRAINT `FKo7of6p0oqjhqfuscvu91gmcnu` FOREIGN KEY (`idServicioContratado`) REFERENCES `servicioscontratados` (`idServicioContratado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratos`
--

LOCK TABLES `contratos` WRITE;
/*!40000 ALTER TABLE `contratos` DISABLE KEYS */;
INSERT INTO `contratos` VALUES (1,1,2),(2,2,2),(3,3,1);
/*!40000 ALTER TABLE `contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidades` (
  `idEspecialidad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `idTecnico` int NOT NULL,
  PRIMARY KEY (`idEspecialidad`),
  KEY `FKs1513rrfogcp3h09fujr60lr9` (`idTecnico`),
  CONSTRAINT `FKs1513rrfogcp3h09fujr60lr9` FOREIGN KEY (`idTecnico`) REFERENCES `tecnicos` (`idTecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidades`
--

LOCK TABLES `especialidades` WRITE;
/*!40000 ALTER TABLE `especialidades` DISABLE KEYS */;
INSERT INTO `especialidades` VALUES (1,'Tecnico Electronico',1),(2,'Tecnico Electrisista',1),(3,'Tecnico Telecomunicaciones',1),(4,'Tecnico Programador',3),(5,'Programador Junior',8);
/*!40000 ALTER TABLE `especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidentes`
--

DROP TABLE IF EXISTS `incidentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidentes` (
  `idIncidente` int NOT NULL AUTO_INCREMENT,
  `descripcionProblema` varchar(255) DEFAULT NULL,
  `fechaInicioTramite` datetime(6) DEFAULT NULL,
  `fechaSolucionEstimada` datetime(6) DEFAULT NULL,
  `fechaSolucionReal` datetime(6) DEFAULT NULL,
  `informeTecnico` varchar(255) DEFAULT NULL,
  `resuelto` bit(1) NOT NULL DEFAULT b'0',
  `idContrato` int DEFAULT NULL,
  `idTecnico` int DEFAULT NULL,
  PRIMARY KEY (`idIncidente`),
  KEY `FK8w9pprnndrtxy9gqpt805qdte` (`idContrato`),
  KEY `FKfifn6j8sst9lecnx6d40eywrm` (`idTecnico`),
  CONSTRAINT `FK8w9pprnndrtxy9gqpt805qdte` FOREIGN KEY (`idContrato`) REFERENCES `contratos` (`idContrato`),
  CONSTRAINT `FKfifn6j8sst9lecnx6d40eywrm` FOREIGN KEY (`idTecnico`) REFERENCES `tecnicos` (`idTecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidentes`
--

LOCK TABLES `incidentes` WRITE;
/*!40000 ALTER TABLE `incidentes` DISABLE KEYS */;
INSERT INTO `incidentes` VALUES (1,'Incidente 1','2023-10-24 22:23:10.000000','2023-10-27 22:23:10.000000','2023-10-25 22:23:10.000000','Todo termino OK',_binary '',3,1),(2,'Incidente 2','2023-10-24 22:23:10.000000','2023-10-27 22:23:10.000000','2023-10-27 22:23:10.000000','Sin novedades',_binary '',3,1),(3,'Incidente 3','2023-10-24 22:23:10.000000','2023-10-27 22:23:10.000000','2023-10-25 16:23:10.000000','Todo bien',_binary '',3,3),(4,'incidente anterior','2023-02-24 22:23:10.000000','2023-02-27 22:23:10.000000','2023-02-25 16:23:10.000000','Sin novedades',_binary '',2,3),(5,'Incidente 5','2023-10-22 22:23:10.000000','2023-10-25 22:23:10.000000','2023-10-24 22:23:10.000000','Todo termino OK',_binary '',1,3),(6,'Incidente 6','2023-10-24 22:23:10.000000','2023-10-27 22:23:10.000000','2023-10-25 22:23:10.000000','Todo termino OK',_binary '',1,3),(7,'Incidente 7','2023-11-24 22:23:10.000000','2023-11-27 22:23:10.000000','2023-11-25 22:23:10.000000','Todo termino OK',_binary '',2,1),(8,'Incidente 8','2023-11-25 22:23:10.000000','2023-11-28 22:23:10.000000','2023-11-28 10:23:10.000000','Problema solucionado',_binary '',1,3);
/*!40000 ALTER TABLE `incidentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problemas`
--

DROP TABLE IF EXISTS `problemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problemas` (
  `idProblema` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) DEFAULT NULL,
  `Tiempo` int DEFAULT NULL,
  `idEspecialidad` int NOT NULL,
  `idIncidente` int NOT NULL,
  `idServicoContratado` int NOT NULL,
  PRIMARY KEY (`idProblema`),
  KEY `FKgknnh0mvooc03jxmskhutkxx6` (`idEspecialidad`),
  KEY `FKt4tdn5srkaoihur27uqy6mtve` (`idIncidente`),
  KEY `FKln7ugebivgvbh9dsfa0j708hp` (`idServicoContratado`),
  CONSTRAINT `FKgknnh0mvooc03jxmskhutkxx6` FOREIGN KEY (`idEspecialidad`) REFERENCES `especialidades` (`idEspecialidad`),
  CONSTRAINT `FKln7ugebivgvbh9dsfa0j708hp` FOREIGN KEY (`idServicoContratado`) REFERENCES `servicioscontratados` (`idServicioContratado`),
  CONSTRAINT `FKt4tdn5srkaoihur27uqy6mtve` FOREIGN KEY (`idIncidente`) REFERENCES `incidentes` (`idIncidente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problemas`
--

LOCK TABLES `problemas` WRITE;
/*!40000 ALTER TABLE `problemas` DISABLE KEYS */;
INSERT INTO `problemas` VALUES (1,'problema 1',5,1,1,1),(2,'problema 2',3,1,2,1),(3,'problema 3',4,1,3,1);
/*!40000 ALTER TABLE `problemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicioscontratados`
--

DROP TABLE IF EXISTS `servicioscontratados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicioscontratados` (
  `idServicioContratado` int NOT NULL AUTO_INCREMENT,
  `NombreServicio` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idServicioContratado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicioscontratados`
--

LOCK TABLES `servicioscontratados` WRITE;
/*!40000 ALTER TABLE `servicioscontratados` DISABLE KEYS */;
INSERT INTO `servicioscontratados` VALUES (1,'Servicio Premium'),(2,'Servicio Básico');
/*!40000 ALTER TABLE `servicioscontratados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnicos`
--

DROP TABLE IF EXISTS `tecnicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnicos` (
  `idTecnico` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numeroDocumento` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipoNotificacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnicos`
--

LOCK TABLES `tecnicos` WRITE;
/*!40000 ALTER TABLE `tecnicos` DISABLE KEYS */;
INSERT INTO `tecnicos` VALUES (1,'Altamirano','27 de Abril 443','Miguel','65456654','514-645665','eMail'),(3,'Flores','Oncativo 5934','Yohana','43544543','514-645656','Whatsapp'),(4,'Perez','San Martin 5934','Daniel','43544543','514-645665','Whatsapp'),(5,'Dominguez','Amelia Stocklin 5934','Marcela','43544543','514-645665','Whatsapp'),(7,'Garcia','Pedro de Mendoza 4534','Micaela','34235454','45345646','Whatsapp'),(8,'Molina','Ruben Dario 3543','Daniela','53453455','45676754','Whatsapp');
/*!40000 ALTER TABLE `tecnicos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 23:34:43
