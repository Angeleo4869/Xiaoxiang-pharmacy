package com.xiaoxiang.org.test;

import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

public class AdminTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		AdminDAO adminDao = new AdminDAO();
//		admin.setAdminNumber("xiaofeng");
//		admin.setAdminPassword("123456");
//		if(adminDao.save(admin)){
//			System.out.println("OK!");
//		}
//		System.out.println("No");
		List list = adminDao.findAll();
		
		for(int i=0;i<list.size();i++){
			admin = (Admin)list.get(i);
			System.out.println(admin.getAdminNumber());
		}
	}

}
