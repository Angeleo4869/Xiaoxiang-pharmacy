package com.xiaoxiang.org.test;

import java.util.ArrayList;
import java.util.List;

import com.xiaoxiang.org.dao.OrderViewDAO;
import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.OrderView;
import com.xiaoxiang.org.vo.OrderViewId;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.ShopGoods;
import com.xiaoxiang.org.vo.Store;

public class OrderTest {

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer buyer = new Buyer();
		Store store = new Store();
		ShopGoods shopGoods = new ShopGoods();
		OrderdetailDAO orderdetailDAO  = new OrderdetailDAO();
		Orderdetail orderdetail = new Orderdetail();
		OrderView orderView = new OrderView();
		OrderViewId orderViewId = new OrderViewId();
		OrderViewDAO orderViewDAO = new OrderViewDAO();
		ArrayList<List> arrayList = new ArrayList<List>();
//		buyer.setIdBuyer(11);
//		orderViewId.setIdbuyer(buyer.getIdBuyer());
		orderViewId.setIdStore(null);
		 orderViewId.setIdbuyer(11);
		for(Short orderstate = 0;orderstate<5;orderstate++){
			orderViewId.setOdstate(orderstate);
			orderView.setId(orderViewId);
			List list = orderdetailDAO.findByOrderView(orderView);
			System.out.println(list);
//			  System.out.println(((OrderView)list.get(0)).getId().getIdorder());
		}
	}

}
