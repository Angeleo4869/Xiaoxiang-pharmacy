package com.xiaoxiang.org.test;

import java.util.List;

import com.xiaoxiang.org.dao.GoodsDAO;
import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Goods;
import com.xiaoxiang.org.vo.ShopGoods;
import com.xiaoxiang.org.vo.Store;

public class ShopGoodsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list;
		Store store = new Store();
		Goods goods = new Goods();
		Buyer buyer = new Buyer();
		ShopGoods shopGoods = new ShopGoods();
		GoodsDAO goodsDAO = new GoodsDAO();
		ShopGoodsDAO dao = new ShopGoodsDAO();
//		goods = new GoodsDAO().findById(2);
//		System.out.println(goods.getGoodsNumber());
//		store = new StoreDAO().findById(9);
//		System.out.println(store.getStoreNumber());
//		shopGoods.setGoods(goods);
//		shopGoods.setStore(store);
//		shopGoods.setShopGoodsImage("0001");
//		shopGoods.setShopGoodsPrice(goods.getStorePurchasePrice()+10);
//		shopGoods.setShopGoodsSales(0);
//		shopGoods.setShopGoodsInventory(100);
//		shopGoods.setShopGoodsFreight(10.0);
//		
//		if(dao.save(shopGoods)){
//			System.out.println(shopGoods.getGoods().getGoodsComName());
//		}
//		buyer.setIdBuyer(11);
		list = goodsDAO.findGoodsDeatil(1);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));	
		}
	}

}
