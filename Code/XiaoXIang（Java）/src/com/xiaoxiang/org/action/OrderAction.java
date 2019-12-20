package com.xiaoxiang.org.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.ShopGoods;

public class OrderAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Orderdetail orderdetail;
	private ShopGoods shopGoods;
	private Buyer buyer;
	private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
	
	//购买，但未付款
	public String placeOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
		shopGoods.setIdShopGoods(Integer.valueOf(request.getParameter("idShopGoods")));
		int goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));
        orderdetail.setOrderNumber(new Date().toString()+buyer.getIdBuyer()+shopGoods.getIdShopGoods());
		orderdetail.setBuyer(buyer);
		orderdetail.setShopGoods(shopGoods);
		orderdetail.setLogistics((short) 0);//订单状态  0 未付款
		orderdetail.setPaymentTime(new Date());
		orderdetail.setGoodsNumber(goodsnumber);
		orderdetail.setTotalPrice(shopGoods.getShopGoodsPrice()*orderdetail.getGoodsNumber());
		if(orderdetailDAO.save(orderdetail)){
			getDataMap().put(SUCCESS, true);
		}else {
			getDataMap().put(ERROR,false);
		}
        return DataMap;
	}
	//查看订单
	public String viewOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
        List list = orderdetailDAO.findByOrderView(buyer.getIdBuyer());
		getDataMap().put(Order, list);
		return DataMap;
	}
	//订单详情
	public String viewOrderDetail() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        //buyer.setIdBuyer(11);
        orderdetail= orderdetailDAO.findById(11);
		getDataMap().put(Order, orderdetail);
		return DataMap;
	}
	
	public String paymentOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Short logistics = (Short.valueOf(request.getParameter("")));
        orderdetail.setLogistics(logistics);
        if(orderdetailDAO.attachDirty(orderdetail)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }
		
		return DataMap;
	}

}
