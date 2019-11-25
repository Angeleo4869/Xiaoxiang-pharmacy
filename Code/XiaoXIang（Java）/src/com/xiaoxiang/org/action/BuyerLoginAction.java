package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;

public class BuyerLoginAction extends BaseAction {
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
			getDataMap().put("success", true);
		}
		return "dataMap";
	}
	
	public String register() throws Exception{
        responseSetHeader();
        if(buyerDAO.save(getBuyer())){
        	return SUCCESS;
        }else return ERROR;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

}
