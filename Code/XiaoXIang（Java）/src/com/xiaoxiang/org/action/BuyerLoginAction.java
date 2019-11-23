package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;

public class BuyerLoginAction extends ActionSupport {
	private Iterator<Buyer> iter;
	private Buyer buyer;
	public String execute() throws Exception{
		
        HttpServletResponse response = ServletActionContext.getResponse();
        //‘ –ÌøÁ”Ú
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        PrintWriter out = response.getWriter();
        
        buyer.setBuyerNumber("leo");
        buyer.setBuyerPassword("123456");
        
        BuyerDAO buyerdao = new BuyerDAO();
        List<Buyer> list = buyerdao.findByExample(buyer);
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
