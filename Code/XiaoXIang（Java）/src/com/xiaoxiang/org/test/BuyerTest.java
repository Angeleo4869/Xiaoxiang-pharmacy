package com.xiaoxiang.org.test;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;

public class BuyerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Buyer buyer = new Buyer();
		 BuyerDAO buyerDAO = new BuyerDAO();
	     buyer = buyerDAO.findById(11);
	     System.out.println(buyer.getBuyerName());

	}

}
