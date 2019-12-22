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
	
	//登录
	public String buyerLogin() throws Exception{
       responseSetHeader();
       setDataMap(new HashMap<String, Object>());
       buyer.setBuyerNumber(request.getParameter("BuyerNumber"));
       buyer.setBuyerPassword(request.getParameter("BuyerPassword"));
       if(buyer.getBuyerNumber()!=null){
    	   list = buyerDAO.findByExample(getBuyer());
    	   getDataMap().put(Buyer,list);
		}else {
			getDataMap().put(ERROR,false);
		}
		return DataMap;
	}
	
	//注册
	public String buyerRegister() throws Exception{
        responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		 buyer.setBuyerNumber(request.getParameter("BuyerNumber"));
		 buyer.setBuyerPassword(request.getParameter("BuyerPassword"));  
        if(buyerDAO.save(getBuyer())){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR,false);
        }return DataMap;
	}
	//注销
	public String buyerCancellation() throws Exception{
		 responseSetHeader();
	     setDataMap(new HashMap<String, Object>());
		 Integer id = Integer.valueOf(request.getParameter("idBuyer"));  
		 buyer.setIdBuyer(id);
	     if(buyerDAO.delete(getBuyer())){
	    	getDataMap().put(SUCCESS, true);
	     }else {
	    	 getDataMap().put(ERROR,false);
	     }return DataMap;
	}
	//个人中心
	public String personalCenter() throws Exception{
		 responseSetHeader();
	     setDataMap(new HashMap<String, Object>());
		 Integer id = Integer.valueOf(request.getParameter("idBuyer"));     
	     buyer = buyerDAO.findById(id);
	     getDataMap().put(Buyer, buyer);
	     return DataMap;
	}
	
	//编辑个人信息
	public String editBuyer() throws Exception{
		 responseSetHeader();
	     setDataMap(new HashMap<String, Object>());
		 buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
		 buyer.setBuyerName(request.getParameter("BuyerName"));
		 buyer.setBuyerHeadpor(request.getParameter("Headpor"));
		 buyer.setBuyerTel(request.getParameter("BuyerTel"));
		 buyer.setBuyerEmail(request.getParameter("BuyerEmail"));
	     if(buyerDAO.attachDirty(buyer)){
	    	 getDataMap().put(SUCCESS, true);
	     }else {
	    	 getDataMap().put(ERROR, false);
	     }
	     return DataMap;
	}
	
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

}
