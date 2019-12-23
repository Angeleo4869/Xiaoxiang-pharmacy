package com.xiaoxiang.org.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.ShopGoods;

public class OrderTest {

	private static ArrayList<List> list = new ArrayList<List>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer buyer = new Buyer();
		ShopGoods shopGoods = new ShopGoods();
		OrderdetailDAO orderdetailDAO  = new OrderdetailDAO();
		Orderdetail orderdetail = new Orderdetail();
		buyer = new BuyerDAO().findById(11);
		for(int orderstate = 0;orderstate<4;orderstate++){
			List order = orderdetailDAO.findByOrderView(11,(short)orderstate);
			System.out.println(order.get(0));
			list.addAll(order);
			System.out.println(list.get(0));
		}
	}

}
