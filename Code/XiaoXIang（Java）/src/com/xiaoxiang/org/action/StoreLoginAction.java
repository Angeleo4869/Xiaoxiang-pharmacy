package com.xiaoxiang.org.action;
import java.io.PrintWriter;
import java.util.List;

import com.xiaoxiang.org.dao.StoreDAO;
import com.xiaoxiang.org.vo.Store;

public class StoreLoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store = new Store();
	StoreDAO storeDao = new StoreDAO();
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		
		PrintWriter printWriter = responseSetHeader();
		List<Store> list = storeDao.findByExample(store);
		if(list.isEmpty()){
			return ERROR;
		}else{
			printWriter.print(list.get(0));
			return SUCCESS;
		}
		
	}
	
	public String register() throws Exception{
        PrintWriter out = responseSetHeader();
        if(storeDao.save(getStore())){
        	out.print(getStore().getStoreName());
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