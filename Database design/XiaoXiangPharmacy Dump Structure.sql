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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `AdminNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `AdminPassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idAdmin`),
  UNIQUE KEY `AdminNumber_UNIQUE` (`AdminNumber`),
  UNIQUE KEY `idAdmin_UNIQUE` (`idAdmin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `buyer`
--

DROP TABLE IF EXISTS `buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyer` (
  `idBuyer` int(11) NOT NULL AUTO_INCREMENT,
  `BuyerName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BuyerNumber` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BuyerPassword` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyerEmail` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `buyerTel` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `buyerHeadpor` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idBuyer`),
  UNIQUE KEY `BuyerNumber_UNIQUE` (`BuyerNumber`),
  UNIQUE KEY `idBuyer_UNIQUE` (`idBuyer`),
  UNIQUE KEY `buyerTel_UNIQUE` (`buyerTel`),
  UNIQUE KEY `buyerEmail_UNIQUE` (`buyerEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collection` (
  `idcollection` int(11) NOT NULL AUTO_INCREMENT,
  `idBUyer` int(11) NOT NULL,
  `idShop_Goods` int(11) NOT NULL,
  PRIMARY KEY (`idcollection`),
  KEY `collection_Buyer_idx` (`idBUyer`),
  KEY `collection_Good_idx` (`idShop_Goods`),
  CONSTRAINT `collection_Buyer` FOREIGN KEY (`idBUyer`) REFERENCES `buyer` (`idBuyer`),
  CONSTRAINT `collection_Good` FOREIGN KEY (`idShop_Goods`) REFERENCES `shop_goods` (`idShop_Goods`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `idComments` int(11) NOT NULL AUTO_INCREMENT,
  `idOder` int(11) NOT NULL,
  `CommentLevel` tinyint(4) NOT NULL DEFAULT '0',
  `CommentsAnonymous` tinyint(4) NOT NULL DEFAULT '0',
  `Commentsdetails` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CommentsReplyid` int(11) DEFAULT '0',
  PRIMARY KEY (`idComments`),
  KEY `Comments_Order_idx` (`idOder`),
  CONSTRAINT `Comments_Order` FOREIGN KEY (`idOder`) REFERENCES `orderdetail` (`idOrder`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `complaints`
--

DROP TABLE IF EXISTS `complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaints` (
  `idComplaints` int(11) NOT NULL AUTO_INCREMENT,
  `idBuyer` int(11) NOT NULL,
  `idStore` int(11) NOT NULL,
  `ComplaintsContent` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ComplaintsCategory` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idComplaints`),
  UNIQUE KEY `idComplaints_UNIQUE` (`idComplaints`),
  KEY `complaintsBuyer_idx` (`idBuyer`),
  KEY `complaintsStort_idx` (`idStore`),
  CONSTRAINT `complaintsBuyer` FOREIGN KEY (`idBuyer`) REFERENCES `buyer` (`idBuyer`),
  CONSTRAINT `complaintsStort` FOREIGN KEY (`idStore`) REFERENCES `store` (`idStore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `idGoods` int(11) NOT NULL AUTO_INCREMENT,
  `GoodsNUmber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsComName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsCheName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsComposition` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsCharacter` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idMajorFunction` int(11) NOT NULL,
  `StorePurchasePrice` double NOT NULL,
  `GoodsSpecifications` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsUsage` int(11) NOT NULL,
  `GoodsTaboo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsValidity` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsProductionDate` date NOT NULL,
  `GoodsManufacturer` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idGoods`),
  UNIQUE KEY `GoodsNUmber_UNIQUE` (`GoodsNUmber`),
  UNIQUE KEY `idGoods_UNIQUE` (`idGoods`),
  KEY `Goods_MajorFunction_idx` (`idMajorFunction`),
  CONSTRAINT `Goods_MajorFunction` FOREIGN KEY (`idMajorFunction`) REFERENCES `majorfunction` (`idMajorFunction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `majorfunction`
--

DROP TABLE IF EXISTS `majorfunction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `majorfunction` (
  `idMajorFunction` int(11) NOT NULL AUTO_INCREMENT,
  `GoodsMajorFunctioncol` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsClass` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `GoodsSeries` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idMajorFunction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `oder`
--

DROP TABLE IF EXISTS `oder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oder` (
  `idOder` int(11) NOT NULL AUTO_INCREMENT,
  `OderState` tinyint(4) NOT NULL DEFAULT '0',
  `idShop_Goods` int(11) NOT NULL,
  `idBuyer` int(11) NOT NULL,
  PRIMARY KEY (`idOder`),
  KEY `idBuyer_idx` (`idBuyer`),
  KEY `Oder_Shop_Good_idx` (`idShop_Goods`),
  CONSTRAINT `Oder_Buyer` FOREIGN KEY (`idBuyer`) REFERENCES `buyer` (`idBuyer`),
  CONSTRAINT `Oder_Shop_Good` FOREIGN KEY (`idShop_Goods`) REFERENCES `shop_goods` (`idShop_Goods`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shippingaddress`
--

DROP TABLE IF EXISTS `shippingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shippingaddress` (
  `idShippingAddress` int(11) NOT NULL AUTO_INCREMENT,
  `idBuyer` int(11) NOT NULL,
  `RecipientName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RecipientTel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RecipientAddress` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idShippingAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shop_goods`
--

DROP TABLE IF EXISTS `shop_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_goods` (
  `idShop_Goods` int(11) NOT NULL AUTO_INCREMENT,
  `Goods` int(11) NOT NULL,
  `Stort` int(11) NOT NULL,
  `Shop_GoodsImage` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Shop_GoodsPrice` double NOT NULL,
  `Shop_GoodsInventory` int(11) NOT NULL DEFAULT '0',
  `Shop_GoodsFreight` double NOT NULL DEFAULT '0',
  `Shop_GoodsSales` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idShop_Goods`),
  KEY `idGoods_idx` (`Goods`),
  KEY `idStore_idx` (`Stort`),
  CONSTRAINT `idGood` FOREIGN KEY (`Goods`) REFERENCES `goods` (`idGoods`),
  CONSTRAINT `idStore` FOREIGN KEY (`Stort`) REFERENCES `store` (`idStore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoppingcart` (
  `idshoppingcart` int(11) NOT NULL AUTO_INCREMENT,
  `Buyer` int(11) NOT NULL,
  `GoodsNumber` int(11) NOT NULL DEFAULT '1',
  `Shop_Goods` int(11) NOT NULL,
  PRIMARY KEY (`idshoppingcart`),
  KEY `shoppingcart-buyer_idx` (`Buyer`),
  KEY `Shoppingcart_Goods_idx` (`Shop_Goods`),
  CONSTRAINT `Shoppingcart_Goods` FOREIGN KEY (`Shop_Goods`) REFERENCES `shop_goods` (`idShop_Goods`),
  CONSTRAINT `shoppingcart-buyer` FOREIGN KEY (`Buyer`) REFERENCES `buyer` (`idBuyer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `idStore` int(11) NOT NULL AUTO_INCREMENT,
  `StoreNumber` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StorePassword` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StoreName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StoreState` tinyint(4) NOT NULL DEFAULT '0',
  `StorePhyName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StorePhyIdCard` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StoreLicense` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StoreTel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StoreAddress` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idStore`),
  UNIQUE KEY `StoreNumber_UNIQUE` (`StoreNumber`),
  UNIQUE KEY `idStore_UNIQUE` (`idStore`),
  UNIQUE KEY `StoreTel_UNIQUE` (`StoreTel`),
  UNIQUE KEY `StoreState_UNIQUE` (`StoreState`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vouchers`
--

DROP TABLE IF EXISTS `vouchers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vouchers` (
  `idVouchers` int(11) NOT NULL AUTO_INCREMENT,
  `idBuyer` int(11) NOT NULL,
  `VouchersAmount` double NOT NULL,
  `idShop_Goods` int(11) NOT NULL,
  PRIMARY KEY (`idVouchers`),
  KEY `vouchers_Buyer_idx` (`idBuyer`),
  KEY `vouchers_shop_idx` (`idShop_Goods`),
  CONSTRAINT `vouchers_Buyer` FOREIGN KEY (`idBuyer`) REFERENCES `buyer` (`idBuyer`),
  CONSTRAINT `vouchers_goods` FOREIGN KEY (`idShop_Goods`) REFERENCES `shop_goods` (`idShop_Goods`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-01 15:23:42
