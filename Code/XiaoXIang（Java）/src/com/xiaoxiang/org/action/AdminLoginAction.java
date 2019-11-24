package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

public class AdminLoginAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Iterator<Admin> iter;
	private Admin admin;
	public String execute() throws Exception{
		
        PrintWriter out = responseSetHeader();
        
        admin.setAdminNumber("leo");
        admin.setAdminPassword("123456");
        
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> list = adminDAO.findByExample(admin);
        iter = list.iterator();
		if(iter.hasNext()){
			out.println(iter.next().getAdminNumber());
				return SUCCESS;			
		}
        //out.print("Hello World!");
        out.flush();
        //System.out.println("Hello World");
		return ERROR;
	}

}
