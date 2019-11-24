package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;

public class BuyerLoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Buyer buyer;
	BuyerDAO buyerDAO = new BuyerDAO();
	public String execute() throws Exception{
		
        PrintWriter out = responseSetHeader();
        //buyer.setBuyerNumber("leo");
        //buyer.setBuyerPassword("123456");
        
        List<Buyer> list = buyerDAO.findByExample(getBuyer());
		if(!list.isEmpty()){
			out.println(list.get(0).getBuyerName());
			out.flush();
			return SUCCESS;			
		}
		return ERROR;
	}
	
	public String register() throws Exception{
        PrintWriter out = responseSetHeader();
        if(buyerDAO.save(getBuyer())){
        	out.print(getBuyer().getBuyerName());
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
