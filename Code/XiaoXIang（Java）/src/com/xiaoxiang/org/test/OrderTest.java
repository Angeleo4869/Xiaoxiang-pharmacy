package com.xiaoxiang.org.test;

import java.util.Date;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.ShopGoods;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer buyer = new Buyer();
		ShopGoods shopGoods = new ShopGoods();
		OrderdetailDAO orderdetailDAO  = new OrderdetailDAO();
		Orderdetail orderdetail = new Orderdetail();
		buyer = new BuyerDAO().findById(11);
//		shopGoods = new ShopGoodsDAO().findById(5);
//		System.out.println(buyer.getBuyerName());
//		orderdetail.setOrderNumber(new Date().toString()+buyer.getIdBuyer().toString()+shopGoods.getIdShopGoods().toString());
//		orderdetail.setBuyer(buyer);
//		orderdetail.setShopGoods(shopGoods);
//		orderdetail.setLogistics((short) 5);
//		orderdetail.setPaymentTime(new Date());
//		orderdetail.setTotalPrice(shopGoods.getShopGoodsPrice());
		
		List list = orderdetailDAO.findByOrderView(11);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

}
