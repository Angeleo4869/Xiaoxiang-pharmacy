package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

public class AdminLoginAction extends ActionSupport {
	
	private Iterator<Admin> iter;
	private Admin admin;
	public String execute() throws Exception{
		
        HttpServletResponse response = ServletActionContext.getResponse();
        //‘ –ÌøÁ”Ú
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        PrintWriter out = response.getWriter();
        
        admin.setAdminNumber("leo");
        admin.setAdminPassword("123456");
        
        AdminDAO admindao = new AdminDAO();
        List<Admin> list = admindao.findByExample(admin);
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
