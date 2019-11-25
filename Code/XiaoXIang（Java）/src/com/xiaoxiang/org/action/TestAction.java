package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;
public class TestAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception{
		
        PrintWriter out = responseSetHeader();
        HttpServletRequest request = ServletActionContext.getRequest();
        String AdminNumber = request.getParameter("AdminNumber");
        String AdminPassword = request.getParameter("AdminPassword");
        /*
        Admin admin = new Admin();
        AdminDAO admindao = new AdminDAO();
        List<Admin> list = admindao.findAll();
		for(int i=0;i<list.size();i++){
			admin = list.get(i);
			out.println(admin.getAdminNumber());
			//System.out.println(list.get(i).getAdminnumber());
		}
        */
        out.println(AdminNumber);
        System.out.println(AdminNumber);
        out.println(AdminPassword);
        //out.print(new TestDao().queryAdmin().get(0).getAdminnumber());
        out.flush();
        //System.out.println("Hello World");
		return null;
	}
	

}
