package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;
public class TestAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception{
        HttpServletResponse response = ServletActionContext.getResponse();
        //‘ –ÌøÁ”Ú
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        PrintWriter out = response.getWriter();
        Admin admin = new Admin();
        AdminDAO admindao = new AdminDAO();
        List<Admin> list = admindao.findAll();
		for(int i=0;i<list.size();i++){
			admin = list.get(i);
			out.println(admin.getAdminNumber());
			//System.out.println(list.get(i).getAdminnumber());
		}
        
        out.print("Hello World!");
        //out.print(new TestDao().queryAdmin().get(0).getAdminnumber());
        out.flush();
        //System.out.println("Hello World");
		return null;
	}
	

}
