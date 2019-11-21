-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: xiaoxiangpharmacy
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `idOrder` int(11) NOT NULL AUTO_INCREMENT,
  `idBuyer` int(11) NOT NULL,
  `idShop_Goods` int(11) NOT NULL,
  `idVouchers` int(11) NOT NULL DEFAULT '0',
  `PaymentTime` datetime NOT NULL,
  `TotalPrice` double NOT NULL DEFAULT '0',
  `GoodsNumber` int(11) NOT NULL DEFAULT '0',
  `Logistics` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idOrder`),
  KEY `Shop_Goods_idx` (`idShop_Goods`),
  KEY `Voucher_idx` (`idVouchers`),
  KEY `order_Buyer_idx` (`idBuyer`),
  CONSTRAINT `Order` FOREIGN KEY (`idOrder`) REFERENCES `oder` (`idOder`),
  CONSTRAINT `Shop_Goods` FOREIGN KEY (`idShop_Goods`) REFERENCES `shop_goods` (`idShop_Goods`),
  CONSTRAINT `Voucher` FOREIGN KEY (`idVouchers`) REFERENCES `vouchers` (`idVouchers`),
  CONSTRAINT `order_Buyer` FOREIGN KEY (`idBuyer`) REFERENCES `buyer` (`idBuyer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-21 17:22:26
