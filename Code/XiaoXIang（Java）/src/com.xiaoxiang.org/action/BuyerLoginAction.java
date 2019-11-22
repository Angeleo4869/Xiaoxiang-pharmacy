package com.xiaoxiang.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;

public class BuyerLoginAction extends ActionSupport {
	private Buyer buyer;
	
	public String execute() throws Exception{
		BuyerDAO buyerdao = new BuyerDAO();
		buyer.getBuyerNumber();
		buyer.getBuyerPassword();
		if(buyerdao.findByProperty("Buyer", buyer.getBuyerNumber())!=null)
		return SUCCESS;
		else return ERROR;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	

}
