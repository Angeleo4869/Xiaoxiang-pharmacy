package com.xiaoxiang.org.action;

import java.util.HashMap;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Shippingaddress;
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
        Shippingaddress shippingaddress = new  Shippingaddress();
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));//买家ID
		Integer flag = Integer.valueOf(request.getParameter("idShopGoods"));
		Integer goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));//商品数量
		shippingaddress.setIdShippingAddress(Integer.valueOf(request.getParameter("ShippingAddress")));//收货地址
		getDataMap().put(SUCCESS, buyer.getIdBuyer());
		getDataMap().put(SUCCESS,flag);
		getDataMap().put(SUCCESS, goodsnumber);
		return DataMap;
	}
	

}
