package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

public class AdminLoginAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Iterator<Admin> iter;
	private Admin admin = new Admin();
	AdminDAO adminDAO = new AdminDAO();
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String execute() throws Exception{
        PrintWriter out = responseSetHeader();
        List list = adminDAO.findByExample(getAdmin());
        System.out.println(getAdmin().getAdminNumber());
        //iter = list.iterator();
		if(!list.isEmpty()){
			for(int i=0;i<list.size();i++)
			System.out.println(((Admin)list.get(i)).getAdminNumber());
			return SUCCESS;			
		}
		else
		return ERROR;
	}
	
	public String register() throws Exception{
        PrintWriter out = responseSetHeader();
        if(adminDAO.save(getAdmin())){
        	out.print(getAdmin().getAdminNumber());
        	return SUCCESS;
        }else return ERROR;
	}

}
