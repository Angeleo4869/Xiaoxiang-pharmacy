package com.xiaoxiang.org.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.ShopGoods;

public class OrderAction extends BaseAction {
	private Orderdetail orderdetail;
	private ShopGoods shopGoods;
	private Buyer buyer;
	private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
	public String placeOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        orderdetail.setOrderNumber(new Date().toString()+buyer.getIdBuyer().toString()+shopGoods.getIdShopGoods().toString());
		orderdetail.setBuyer(buyer);
		orderdetail.setShopGoods(shopGoods);
		orderdetail.setLogistics((short) 5);
		orderdetail.setPaymentTime(new Date());
		orderdetail.setGoodsNumber(1);
		orderdetail.setTotalPrice(shopGoods.getShopGoodsPrice()*orderdetail.getGoodsNumber());
		if(orderdetailDAO.save(orderdetail)){
			getDataMap().put(SUCCESS, true);
		}else {
			getDataMap().put(ERROR,false);
		}
        return DataMap;
	}
	
	public String viewOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        buyer = new BuyerDAO().findById(11);
        System.out.println(buyer.getBuyerName());
		List list = orderdetailDAO.findByExample(orderdetail);
		getDataMap().put("Order", list);
		return DataMap;
	}

}
