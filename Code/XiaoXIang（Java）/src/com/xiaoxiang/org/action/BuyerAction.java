package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;

public class BuyerAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Buyer buyer = new Buyer();
	private BuyerDAO buyerDAO = new BuyerDAO();
	public String execute() throws Exception{
		
       responseSetHeader();
       setDataMap(new HashMap<String, Object>());
       List<Buyer> list = buyerDAO.findByExample(getBuyer());
		for(int i=0;i<list.size();i++){
			buyer = list.get(i);
			getDataMap().put("Buyer",buyer);
			getDataMap().put(SUCCESS, true);
		}
		return "dataMap";
	}
	
	
	public String register() throws Exception{
        responseSetHeader();
        setDataMap(new HashMap<String, Object>());
//        buyer.setBuyerNumber("1768149722");
//        buyer.setBuyerEmail("17680149722@163.com");
//        buyer.setBuyerName("ÕÅÈý");
//        buyer.setBuyerPassword("Zhangsan17680149722");
//        buyer.setBuyerTel("17680149722");
        if(buyerDAO.save(getBuyer())){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR,false);
        }return DataMap;
	}
	
	public String cancellation() throws Exception{
		 responseSetHeader();
	     setDataMap(new HashMap<String, Object>());
	     if(buyerDAO.delete(buyer)){
	    	getDataMap().put(SUCCESS, true);
	     }else {
	    	 getDataMap().put(ERROR,false);
	     }return DataMap;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

}
