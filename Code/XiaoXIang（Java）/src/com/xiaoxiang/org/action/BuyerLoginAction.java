package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;

public class BuyerLoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Iterator<Buyer> iter;
	private Buyer buyer;
	
	public String execute() throws Exception{
		
		BuyerDAO buyerDAO = new BuyerDAO();
        PrintWriter out = responseSetHeader();
        buyer.setBuyerNumber("leo");
        buyer.setBuyerPassword("123456");
        
        List<Buyer> list = buyerDAO.findByExample(buyer);
        iter = list.iterator();
		if(iter.hasNext()){
			out.println(iter.next().getBuyerName());
				return SUCCESS;			
		}
        //out.print("Hello World!");
        out.flush();
        //System.out.println("Hello World");
		return ERROR;
	}

}
