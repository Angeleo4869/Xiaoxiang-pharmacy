-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 118.25.67.96    Database: XiaoXiangPharmacy
-- ------------------------------------------------------
-- Server version	5.7.28

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
-- Temporary view structure for view `Goods_view`
--

DROP TABLE IF EXISTS `Goods_view`;
/*!50001 DROP VIEW IF EXISTS `Goods_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `Goods_view` AS SELECT 
 1 AS `idShop_Goods`,
 1 AS `Shop_GoodsImage`,
 1 AS `shop_goodsName`,
 1 AS `Shop_GoodsPrice`,
 1 AS `GoodsMajorFunctioncol`,
 1 AS `GoodsSeries`,
 1 AS `GoodsClass`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `AdminNumber` varchar(11) NOT NULL,
  `AdminPassword` varchar(20) NOT NULL,
  PRIMARY KEY (`idAdmin`),
  UNIQUE KEY `AdminNumber_UNIQUE` (`AdminNumber`),
  UNIQUE KEY `idAdmin_UNIQUE` (`idAdmin`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'leo','123456'),(31,'ruonan','123456'),(32,'xiaofeng','123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyer`
--

DROP TABLE IF EXISTS `buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyer` (
  `idBuyer` int(11) NOT NULL AUTO_INCREMENT,
  `BuyerName` varchar(45) DEFAULT NULL,
  `BuyerNumber` varchar(45) NOT NULL,
  `BuyerPassword` varchar(45) NOT NULL,
  `buyerEmail` varchar(45) DEFAULT NULL,
  `buyerTel` varchar(45) DEFAULT NULL,
  `buyerHeadpor` varchar(45) DEFAULT NULL,
  `AddressDefault` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBuyer`),
  UNIQUE KEY `BuyerNumber_UNIQUE` (`BuyerNumber`),
  UNIQUE KEY `idBuyer_UNIQUE` (`idBuyer`),
  UNIQUE KEY `buyerTel_UNIQUE` (`buyerTel`),
  UNIQUE KEY `buyerEmail_UNIQUE` (`buyerEmail`),
  KEY `AddressDefault_idx` (`AddressDefault`),
  CONSTRAINT `AddressDefault` FOREIGN KEY (`AddressDefault`) REFERENCES `shippingaddress` (`idShippingAddress`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer`
--

LOCK TABLES `buyer` WRITE;
/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
INSERT INTO `buyer` VALUES (11,'张三','1768149722','Zhangsan17680149722','17680149722@163.com','17680149722',NULL,1),(12,NULL,'1111','0000',NULL,NULL,NULL,NULL),(13,NULL,'1768149722ppp','Zhangsan17680149722',NULL,NULL,NULL,NULL),(14,NULL,'1768149722111','Zhangsan17680149722',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

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
  `Commentsdetails` varchar(100) NOT NULL,
  `CommentsReplyid` int(11) DEFAULT '0',
  PRIMARY KEY (`idComments`),
  KEY `Comments_Order_idx` (`idOder`),
  CONSTRAINT `Comments_Order` FOREIGN KEY (`idOder`) REFERENCES `orderdetail` (`idOrder`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

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
  `ComplaintsContent` varchar(45) DEFAULT NULL,
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
-- Dumping data for table `complaints`
--

LOCK TABLES `complaints` WRITE;
/*!40000 ALTER TABLE `complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `idGoods` int(11) NOT NULL AUTO_INCREMENT,
  `GoodsNUmber` varchar(20) NOT NULL,
  `GoodsComName` varchar(45) NOT NULL,
  `GoodsCheName` varchar(45) NOT NULL,
  `GoodsComposition` varchar(45) NOT NULL,
  `GoodsCharacter` varchar(45) NOT NULL,
  `idMajorFunction` int(11) NOT NULL,
  `StorePurchasePrice` double NOT NULL,
  `GoodsSpecifications` varchar(45) NOT NULL,
  `GoodsUsage` varchar(45) NOT NULL,
  `GoodsTaboo` varchar(45) NOT NULL,
  `GoodsValidity` int(11) NOT NULL,
  `GoodsProductionDate` date NOT NULL,
  `GoodsManufacturer` varchar(45) NOT NULL,
  PRIMARY KEY (`idGoods`),
  UNIQUE KEY `GoodsNUmber_UNIQUE` (`GoodsNUmber`),
  UNIQUE KEY `idGoods_UNIQUE` (`idGoods`),
  KEY `Goods_MajorFunction_idx` (`idMajorFunction`),
  CONSTRAINT `Goods_MajorFunction` FOREIGN KEY (`idMajorFunction`) REFERENCES `majorfunction` (`idMajorFunction`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (2,'0009724190','感冒灵颗粒','','三叉苦，金盏银盘，野菊花，岗梅...','浅棕色至深棕色颗粒；味甜，微苦。',2,10.9,'每袋重10g','开水冲服，一次三袋，一日三次','严重肝肾功能不全者禁用',24,'2019-12-01','华润三九医药有限公司'),(3,'1602082074','板蓝根颗粒','Banlangen Keli','板蓝根','浅棕色至深棕色颗粒；味甜，微苦。',2,30,'10g*20包','开水冲服，一次半~1袋，一日3~4次','尚不明确',24,'2019-12-01','广州白云山和记黄埔中药有限公司');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majorfunction`
--

DROP TABLE IF EXISTS `majorfunction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `majorfunction` (
  `idMajorFunction` int(11) NOT NULL AUTO_INCREMENT,
  `GoodsMajorFunctioncol` varchar(45) NOT NULL,
  `GoodsClass` varchar(45) DEFAULT NULL,
  `GoodsSeries` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMajorFunction`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majorfunction`
--

LOCK TABLES `majorfunction` WRITE;
/*!40000 ALTER TABLE `majorfunction` DISABLE KEYS */;
INSERT INTO `majorfunction` VALUES (2,'感冒发烧','西药','呼吸道疾病');
/*!40000 ALTER TABLE `majorfunction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `order_view`
--

DROP TABLE IF EXISTS `order_view`;
/*!50001 DROP VIEW IF EXISTS `order_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `order_view` AS SELECT 
 1 AS `idorder`,
 1 AS `idStore`,
 1 AS `idbuyer`,
 1 AS `storename`,
 1 AS `odstate`,
 1 AS `shname`,
 1 AS `shimage`,
 1 AS `shPrice`,
 1 AS `odprice`,
 1 AS `odNumber`*/;
SET character_set_client = @saved_cs_client;

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
  `idVouchers` int(11) DEFAULT NULL,
  `PaymentTime` date NOT NULL,
  `TotalPrice` double NOT NULL DEFAULT '0',
  `OrderNumber` varchar(45) NOT NULL,
  `Logistics` tinyint(4) NOT NULL DEFAULT '0',
  `GoodsNumber` int(11) NOT NULL DEFAULT '1',
  `OderState` tinyint(4) NOT NULL DEFAULT '0',
  `ShippingAddress` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrder`),
  UNIQUE KEY `OrderNumber_UNIQUE` (`OrderNumber`),
  KEY `Shop_Goods_idx` (`idShop_Goods`),
  KEY `Voucher_idx` (`idVouchers`),
  KEY `order_Buyer_idx` (`idBuyer`),
  KEY `ShippingAddress_idx` (`ShippingAddress`),
  CONSTRAINT `ShippingAddress` FOREIGN KEY (`ShippingAddress`) REFERENCES `shippingaddress` (`idShippingAddress`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Shop_Goods` FOREIGN KEY (`idShop_Goods`) REFERENCES `shop_goods` (`idShop_Goods`),
  CONSTRAINT `Voucher` FOREIGN KEY (`idVouchers`) REFERENCES `vouchers` (`idVouchers`),
  CONSTRAINT `order_Buyer` FOREIGN KEY (`idBuyer`) REFERENCES `buyer` (`idBuyer`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,11,4,NULL,'2019-12-09',40,'Mon Dec 09 19:30:21 CST 2019114',5,1,0,1),(2,11,1,NULL,'2019-12-09',20.9,'Mon Dec 09 19:31:26 CST 2019111',5,1,1,1),(3,11,1,NULL,'2019-12-09',20.9,'Mon Dec 09 19:51:11 CST 2019111',5,1,2,1),(4,11,5,NULL,'2019-12-09',20.9,'Mon Dec 09 19:53:58 CST 2019115',5,1,3,1),(5,11,5,NULL,'2019-12-18',20.9,'Wed Dec 18 21:55:27 CST 2019115',5,1,4,1);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shippingaddress`
--

DROP TABLE IF EXISTS `shippingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shippingaddress` (
  `idShippingAddress` int(11) NOT NULL AUTO_INCREMENT,
  `idBuyer` int(11) NOT NULL,
  `RecipientName` varchar(45) NOT NULL,
  `RecipientTel` varchar(11) NOT NULL,
  `AddressDetail` varchar(45) NOT NULL,
  `Provinces` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  PRIMARY KEY (`idShippingAddress`),
  KEY `Buyer_idx` (`idBuyer`),
  CONSTRAINT `idBuyer` FOREIGN KEY (`idBuyer`) REFERENCES `buyer` (`idBuyer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shippingaddress`
--

LOCK TABLES `shippingaddress` WRITE;
/*!40000 ALTER TABLE `shippingaddress` DISABLE KEYS */;
INSERT INTO `shippingaddress` VALUES (1,11,'张三','15935745682','岳麓区','湖南省','长沙市');
/*!40000 ALTER TABLE `shippingaddress` ENABLE KEYS */;
UNLOCK TABLES;

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
  `Shop_GoodsImage` varchar(45) DEFAULT NULL,
  `Shop_GoodsPrice` double NOT NULL,
  `Shop_GoodsInventory` int(11) NOT NULL DEFAULT '0',
  `Shop_GoodsFreight` double NOT NULL DEFAULT '0',
  `Shop_GoodsSales` int(11) NOT NULL DEFAULT '0',
  `shop_goodsName` varchar(45) NOT NULL,
  PRIMARY KEY (`idShop_Goods`),
  KEY `idGoods_idx` (`Goods`),
  KEY `idStore_idx` (`Stort`),
  CONSTRAINT `idGood` FOREIGN KEY (`Goods`) REFERENCES `goods` (`idGoods`),
  CONSTRAINT `idStore` FOREIGN KEY (`Stort`) REFERENCES `store` (`idStore`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_goods`
--

LOCK TABLES `shop_goods` WRITE;
/*!40000 ALTER TABLE `shop_goods` DISABLE KEYS */;
INSERT INTO `shop_goods` VALUES (1,2,1,'0001',20.9,100,10,2,'感冒灵 '),(4,3,9,'0001',40,100,10,3,'板蓝根·'),(5,2,9,'0001',20.9,100,10,5,'感冒灵');
/*!40000 ALTER TABLE `shop_goods` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `idStore` int(11) NOT NULL AUTO_INCREMENT,
  `StoreNumber` varchar(45) NOT NULL,
  `StorePassword` varchar(16) NOT NULL,
  `StoreName` varchar(45) DEFAULT NULL,
  `StoreState` tinyint(4) DEFAULT '0',
  `StorePhyName` varchar(45) DEFAULT NULL,
  `StorePhyIdCard` varchar(24) DEFAULT NULL,
  `StoreLicense` varchar(45) DEFAULT NULL,
  `StoreTel` varchar(45) DEFAULT NULL,
  `StoreAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStore`),
  UNIQUE KEY `StoreNumber_UNIQUE` (`StoreNumber`),
  UNIQUE KEY `idStore_UNIQUE` (`idStore`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'hnjzt.com','jiuzhitang','九芝堂大药房',1,'劳澄','不详','16501111','0731-84499738','湖南 长沙 坡子街'),(9,'xiaomm@yaofang.com','renhe','仁和药房',1,'陈旭','911101068022288754','110106003156327','010-63626200','北京市丰台区富丰路');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `vouchers`
--

LOCK TABLES `vouchers` WRITE;
/*!40000 ALTER TABLE `vouchers` DISABLE KEYS */;
/*!40000 ALTER TABLE `vouchers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `Goods_view`
--

/*!50001 DROP VIEW IF EXISTS `Goods_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`Kingshion`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `Goods_view` AS select `sh`.`idShop_Goods` AS `idShop_Goods`,`sh`.`Shop_GoodsImage` AS `Shop_GoodsImage`,`sh`.`shop_goodsName` AS `shop_goodsName`,`sh`.`Shop_GoodsPrice` AS `Shop_GoodsPrice`,`mf`.`GoodsMajorFunctioncol` AS `GoodsMajorFunctioncol`,`mf`.`GoodsSeries` AS `GoodsSeries`,`mf`.`GoodsClass` AS `GoodsClass` from (((`shop_goods` `sh` join `store`) join `majorfunction` `mf`) join `goods`) where ((`sh`.`Goods` = `goods`.`idGoods`) and (`sh`.`Stort` = `store`.`idStore`) and (`goods`.`idMajorFunction` = `mf`.`idMajorFunction`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `order_view`
--

/*!50001 DROP VIEW IF EXISTS `order_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`Kingshion`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `order_view` AS select `od`.`idOrder` AS `idorder`,`store`.`idStore` AS `idStore`,`buyer`.`idBuyer` AS `idbuyer`,`store`.`StoreName` AS `storename`,`od`.`OderState` AS `odstate`,`sh`.`shop_goodsName` AS `shname`,`sh`.`Shop_GoodsImage` AS `shimage`,`sh`.`Shop_GoodsPrice` AS `shPrice`,`od`.`TotalPrice` AS `odprice`,`od`.`GoodsNumber` AS `odNumber` from (((`orderdetail` `od` join `buyer`) join `shop_goods` `sh`) join `store`) where ((`od`.`idBuyer` = `buyer`.`idBuyer`) and (`od`.`idShop_Goods` = `sh`.`idShop_Goods`) and (`store`.`idStore` = `sh`.`Stort`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-23  0:08:23
