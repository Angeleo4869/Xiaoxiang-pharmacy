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
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		List<Store> list = storeDao.findByExample(store);
		for(int i=0;i<list.size();i++){
			store = list.get(i);
			getDataMap().put("Store", store);
			getDataMap().put(SUCCESS, true);
			}
		return "dataMap";
	}
	
	public String register() throws Exception{
        responseSetHeader();
		setDataMap(new HashMap<String, Object>());
//        store.setStoreName("仁和药房");
//        store.setStoreNumber("xiaomm@yaofang.com");
//        store.setStorePassword("renhe");
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