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
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		StoreDAO storeDao = new StoreDAO();
		PrintWriter printWriter = responseSetHeader();
		List<Store> list = storeDao.findByExample(store);
		if(list.isEmpty()){
			return ERROR;
		}else{
			printWriter.print(list.get(0));
			return SUCCESS;
		}
		
	}
}