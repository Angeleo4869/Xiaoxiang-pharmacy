package com.xiaoxiang.org.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

public class AdminAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	private AdminDAO adminDAO = new AdminDAO();
	public String execute() throws Exception {
        responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        admin.setAdminNumber(request.getParameter("AdminNumber"));
        admin.setAdminPassword(request.getParameter("AdminPassword"));
        if(admin.getAdminNumber()!=null){
        	System.out.println(admin.getAdminNumber());
        setList(adminDAO.findByExample(admin));
        getDataMap().put("Admin", getList());
        }else {
        	getDataMap().put(ERROR, false);
        }
		return DataMap;
		
	}
	
	public String register() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        getAdmin().setAdminNumber(request.getParameter("AdminNumber"));
        getAdmin().setAdminPassword(request.getParameter("AdminPassword"));
        if(adminDAO.save(getAdmin())){
        	getDataMap().put("Admin", getAdmin());
			getDataMap().put(SUCCESS, true);
        }else getDataMap().put(ERROR, false);
        	return DataMap;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
