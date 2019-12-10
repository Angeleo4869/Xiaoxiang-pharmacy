package com.xiaoxiang.org.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.vo.Admin;

import net.sf.json.JSON;

public class AdminAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	private AdminDAO adminDAO = new AdminDAO();
	private List<Admin> list = new ArrayList<Admin>();
	public String execute() throws Exception {
        responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        getAdmin().setAdminNumber(request.getParameter("AdminNumber"));
        getAdmin().setAdminPassword(request.getParameter("AdminPassword"));
        if(getAdmin()!=null){
        list = adminDAO.findByExample(getAdmin());
        jsonArray.add(list);
//		for(int i=0;i<list.size();i++){
//			admin = list.get(i);
//			System.out.println(admin.getAdminNumber());
//			getDataMap().put("Admin", admin);
//			
//			getJsonArray().add(getDataMap().get(admin));
//			getDataMap().put(SUCCESS, true);
//		}
//		
//        }else {
//        	getDataMap().put(ERROR, false);
        }
//		System.out.println("success");
		return "jsonArray";
		
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
