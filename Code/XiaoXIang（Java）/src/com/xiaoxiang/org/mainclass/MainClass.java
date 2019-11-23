package com.xiaoxiang.org.mainclass;

import java.util.Iterator;
import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Admin;
import com.xiaoxiang.org.vo.Buyer;

public class MainClass {
	private static List list = null;
	private static Iterator iter;
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		/*
		 Admin admin = new Admin();
	        admin.setAdminNumber("leo");
	        admin.setAdminPassword("123456");
	        AdminDAO admindao = new AdminDAO();
	        list = admindao.findByAdminNumber(admin);
			while(iter.hasNext()){
				if(((Admin) iter.next()).getAdminPassword().equals(admin.getAdminPassword())){
					System.out.println(admin.getAdminNumber());
					System.out.println(admin.getAdminPassword());
				}
			}
		*/ 
		BuyerDAO buyerdao = new BuyerDAO();
		Buyer buyer = new Buyer();
		 buyer.setBuyerNumber("201701020134");
		 buyer.setBuyerName("leo");
	     buyer.setBuyerPassword("123456");
	     buyer.setBuyerEmail("China_leo@163.com");
	     buyer.setBuyerTel("15935724685");
	     //buyerdao.save(buyer);
	     
	        list = buyerdao.findByExample(buyer);
	        iter = list.iterator();
			if(iter.hasNext()){
				System.out.println(((Buyer) iter.next()).getBuyerName());	
			}
		
	}

}
