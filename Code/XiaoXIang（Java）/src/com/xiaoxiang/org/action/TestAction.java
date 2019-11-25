package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;
public class TestAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        String AdminNumber = request.getParameter("AdminNumber");
        String AdminPassword = request.getParameter("AdminPassword");
        
        Admin admin = new Admin();
        AdminDAO admindao = new AdminDAO();
        admin.setAdminNumber(AdminNumber);
        admin.setAdminPassword(AdminPassword);
        
        //System.out.println(admin.getAdminNumber());
        
        List<Admin> list = admindao.findByExample(admin);
		for(int i=0;i<list.size();i++){
			admin = list.get(i);
			getDataMap().put("Admin", admin);
			getDataMap().put("success", true);
			
			//out.println(dataMap);
			//System.out.println(admin.getAdminNumber());
		}
        //out.flush();
        //out.println("Hello World");
		return "dataMap";
	}
	

}
