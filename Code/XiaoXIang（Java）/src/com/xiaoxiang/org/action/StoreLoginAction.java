package com.xiaoxiang.org.action;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.StoreDAO;
import com.xiaoxiang.org.vo.Store;

public class StoreLoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store = new Store();
	private StoreDAO storeDao = new StoreDAO();
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		List<Store> list = storeDao.findByExample(store);
		for(int i=0;i<list.size();i++){
			store = list.get(i);
			getDataMap().put("Store", store);
			getDataMap().put("success", true);
			}
		return "dataMap";
	}
	
	public String register() throws Exception{
        responseSetHeader();
        if(storeDao.save(getStore())){
        	return SUCCESS;
        }else return ERROR;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
}