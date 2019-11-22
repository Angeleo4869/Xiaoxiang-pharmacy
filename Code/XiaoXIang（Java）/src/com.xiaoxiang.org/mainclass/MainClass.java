package com.xiaoxiang.org.mainclass;

import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Admin admin = new Admin();
		AdminDAO admindao = new AdminDAO();
	    admin.setAdminNumber("jjx");
		admin.setAdminPassword("123456");
		admindao.save(admin);
		//admindao.delete(admin);
		List<Admin> list = admindao.findAll();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getAdminNumber());
		}
		System.out.println("Hello World!");
	}

}
