package com.xiaoxiang.org.test;

import java.util.Date;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.OderDAO;
import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.*;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer buyer = new Buyer();
		ShopGoods shopGoods = new ShopGoods();
		
		OderDAO oderDAO = new OderDAO();
		Oder oder = new Oder();
		Orderdetail orderdetail = new Orderdetail();
		buyer = new BuyerDAO().findById(11);
		shopGoods = new ShopGoodsDAO().findById(5);
		System.out.println(buyer.getBuyerName());
		orderdetail.setOrderNumber(new Date().toString()+buyer.getIdBuyer().toString()+shopGoods.getIdShopGoods().toString());
		orderdetail.setBuyer(buyer);
		orderdetail.setShopGoods(shopGoods);
		orderdetail.setLogistics((short) 5);
		orderdetail.setPaymentTime(new Date());
		orderdetail.setTotalPrice(shopGoods.getShopGoodsPrice());
		oder.setBuyer(buyer);
		oder.setShopGoods(shopGoods);
		oder.setOderState((short)1);
		oder.setOrderdetail(orderdetail);
		if(oderDAO.save(oder)){
			System.out.println("OK");
		}

	}

}
