package com.xiaoxiang.org.action;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.StoreDAO;
import com.xiaoxiang.org.vo.Store;

public class StoreAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store = new Store();
	private StoreDAO storeDao = new StoreDAO();
	
	//商家登录
	public String storeLogin() throws Exception{
		// TODO Auto-generated method stub
		
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		store.setStoreNumber(request.getParameter("StoreNumber"));
		store.setStorePassword(request.getParameter("StorePassword"));
		if(store.getStoreNumber()!=null){
		List<Store> list = storeDao.findByExample(store);
		getDataMap().put(Store, list);
		} else {
			getDataMap().put(ERROR, false);
		}
		return DataMap;
	}
	//商家注册
	public String storeRegister() throws Exception{
        responseSetHeader();
		setDataMap(new HashMap<String, Object>());
//        store.setStoreName("仁和药房");
        store.setStoreNumber(request.getParameter("StoreNumber"));
        store.setStorePassword(request.getParameter("StorePassword"));
//        store.setStorePhyName("陈旭");
//        store.setStorePhyIdCard("911101068022288754");
//        store.setStoreState((short)1);
//        store.setStoreAddress("北京市丰台区富丰路");
//        store.setStoreLicense("110106003156327");
//        store.setStoreTel("010-63626200");
        if(storeDao.save(getStore())){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR,false);
        }
        return DataMap;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
}