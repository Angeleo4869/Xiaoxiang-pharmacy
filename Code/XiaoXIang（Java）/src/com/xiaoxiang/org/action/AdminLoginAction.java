package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

public class AdminLoginAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	private AdminDAO adminDAO = new AdminDAO();

	public String execute() throws Exception{
        responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        AdminDAO admindao = new AdminDAO();
        admin.setAdminNumber(request.getParameter("AdminNumber"));
        admin.setAdminPassword(request.getParameter("AdminPassword"));
        List<Admin> list = admindao.findByExample(admin);
		for(int i=0;i<list.size();i++){
			admin = list.get(i);
			getDataMap().put("Admin", admin);
			getDataMap().put("success", true);
		}
		return "dataMap";
	}
	
	public String register() throws Exception{
        responseSetHeader();
        if(adminDAO.save(getAdmin())){
        	return SUCCESS;
        }else return ERROR;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
