CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `Kingshion`@`%` 
    SQL SECURITY DEFINER
VIEW `GoodsDetail_view` AS
    SELECT 
        `sh`.`idShop_Goods` AS `idShop_Goods`,
        `sh`.`Shop_GoodsImage` AS `Shop_GoodsImage`,
        `sh`.`shop_goodsName` AS `shop_goodsName`,
        `sh`.`Shop_GoodsPrice` AS `Shop_GoodsPrice`,
        `sh`.`Shop_GoodsSales` AS `Shop_GoodsSales`,
        `sh`.`Shop_GoodsFreight` AS `Shop_GoodsFreight`,
        `sh`.`Shop_GoodsInventory` AS `Shop_GoodsInventory`,
        `sh`.`shop_goodsDetailImage` AS `shop_goodsDetailImage`,
        `goods`.`GoodsSpecifications` AS `GoodsSpecifications`
    FROM
        ((`shop_goods` `sh`
        JOIN `goods`)
        JOIN `store`)
    WHERE
        ((`sh`.`Goods` = `goods`.`idGoods`)
            AND (`sh`.`Stort` = `store`.`idStore`))