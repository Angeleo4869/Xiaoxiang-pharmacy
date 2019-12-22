package com.xiaoxiang.org.action;

import java.util.HashMap;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;
public class TestAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Buyer buyer = new Buyer();
        BuyerDAO buyerDAO = new BuyerDAO();
        buyer = buyerDAO.findById(11);
		getDataMap().put(Buyer, buyer);
		return DataMap;
	}
	

}
