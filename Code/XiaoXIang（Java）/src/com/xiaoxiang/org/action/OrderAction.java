package com.xiaoxiang.org.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.OderDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Oder;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.ShopGoods;

public class OrderAction extends BaseAction {
	private Oder order;
	private Orderdetail orderdetail;
	private ShopGoods shopGoods;
	private Buyer buyer;
	private OderDAO orderDAO = new OderDAO();
	public String placeOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        orderdetail.setOrderNumber(new Date().toString()+buyer.getIdBuyer().toString()+shopGoods.getIdShopGoods().toString());
		orderdetail.setBuyer(buyer);
		orderdetail.setShopGoods(shopGoods);
		orderdetail.setLogistics((short) 5);
		orderdetail.setPaymentTime(new Date());
		orderdetail.setTotalPrice(shopGoods.getShopGoodsPrice());
		order.setBuyer(buyer);
		order.setShopGoods(shopGoods);
		order.setOderState((short)1);
		order.setOrderdetail(orderdetail);
		if(orderDAO.save(order)){
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
        order.setBuyer(buyer);
		List list = orderDAO.findByExample(order);
		getDataMap().put("Order", list);
		return DataMap;
	}

}
