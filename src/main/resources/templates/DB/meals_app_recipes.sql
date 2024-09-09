-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: meals_app
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `id_meal` varchar(255) NOT NULL,
  `str_area` varchar(255) DEFAULT NULL,
  `str_category` varchar(255) DEFAULT NULL,
  `str_drink_alternate` varchar(255) DEFAULT NULL,
  `str_ingredient1` varchar(255) DEFAULT NULL,
  `str_ingredient2` varchar(255) DEFAULT NULL,
  `str_ingredient3` varchar(255) DEFAULT NULL,
  `str_ingredient4` varchar(255) DEFAULT NULL,
  `str_ingredient5` varchar(255) DEFAULT NULL,
  `str_ingredient6` varchar(255) DEFAULT NULL,
  `str_ingredient7` varchar(255) DEFAULT NULL,
  `str_ingredient8` varchar(255) DEFAULT NULL,
  `str_instructions` varchar(255) DEFAULT NULL,
  `str_meal` varchar(255) DEFAULT NULL,
  `str_meal_thumb` varchar(255) DEFAULT NULL,
  `str_measure1` varchar(255) DEFAULT NULL,
  `str_measure2` varchar(255) DEFAULT NULL,
  `str_measure3` varchar(255) DEFAULT NULL,
  `str_measure4` varchar(255) DEFAULT NULL,
  `str_measure5` varchar(255) DEFAULT NULL,
  `str_measure6` varchar(255) DEFAULT NULL,
  `str_measure7` varchar(255) DEFAULT NULL,
  `str_measure8` varchar(255) DEFAULT NULL,
  `str_youtube` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_meal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-09 21:35:09
