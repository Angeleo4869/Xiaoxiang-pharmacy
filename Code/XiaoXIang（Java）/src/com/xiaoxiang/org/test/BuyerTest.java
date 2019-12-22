package com.xiaoxiang.org.test;

import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.ShippingaddressDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Shippingaddress;

public class BuyerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Buyer buyer = new Buyer();
		 BuyerDAO buyerDAO = new BuyerDAO();
//	     buyer = buyerDAO.findById(11);
//	     System.out.println(buyer.getBuyerName());
		 
		 ShippingaddressDAO dao = new ShippingaddressDAO();
		 Shippingaddress instance = new Shippingaddress();
		 List list = dao.findByExample(instance);
		 for(int i=0;i<list.size();i++){
			 instance = (Shippingaddress)list.get(i);
			 System.out.println(instance.getRecipientName());
		 }
	}

}
