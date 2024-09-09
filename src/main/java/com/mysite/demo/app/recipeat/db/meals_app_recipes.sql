CREATE DATABASE  IF NOT EXISTS `meals_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `meals_app`;
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
  `idMeal` varchar(100) NOT NULL,
  `strMeal` varchar(100) DEFAULT NULL,
  `strDrinkAlternate` varchar(100) DEFAULT NULL,
  `strCategory` varchar(100) DEFAULT NULL,
  `strArea` varchar(100) DEFAULT NULL,
  `strInstructions` varchar(255) DEFAULT NULL,
  `strMealThumb` varchar(100) DEFAULT NULL,
  `strYoutube` varchar(100) DEFAULT NULL,
  `strIngredient1` varchar(100) DEFAULT NULL,
  `strIngredient2` varchar(100) DEFAULT NULL,
  `strIngredient3` varchar(100) DEFAULT NULL,
  `strIngredient4` varchar(100) DEFAULT NULL,
  `strIngredient5` varchar(100) DEFAULT NULL,
  `strIngredient6` varchar(100) DEFAULT NULL,
  `strIngredient7` varchar(100) DEFAULT NULL,
  `strIngredient8` varchar(100) DEFAULT NULL,
  `strMeasure1` varchar(100) DEFAULT NULL,
  `strMeasure2` varchar(100) DEFAULT NULL,
  `strMeasure3` varchar(100) DEFAULT NULL,
  `strMeasure4` varchar(100) DEFAULT NULL,
  `strMeasure5` varchar(100) DEFAULT NULL,
  `strMeasure6` varchar(100) DEFAULT NULL,
  `strMeasure7` varchar(100) DEFAULT NULL,
  `strMeasure8` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idMeal`)
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

-- Dump completed on 2024-08-31 12:07:59