package com.xiaoxiang.org.action;

import java.util.ArrayList;
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
	private Orderdetail orderdetail = new Orderdetail();
	private ShopGoods shopGoods = new ShopGoods();
	private Buyer buyer = new Buyer();
	private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
	private ArrayList<List> list = new ArrayList<List>();
	
	//购买，但未付款
	public String placeOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
		shopGoods.setIdShopGoods(Integer.valueOf(request.getParameter("idShopGoods")));
		Integer goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));
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
        Integer id = Integer.valueOf(request.getParameter("idBuyer"));
		buyer.setIdBuyer(id);
		for(Short orderstate = 0;orderstate<5;orderstate++){
			list.add(orderdetailDAO.findByOrderView(11,orderstate));
		}
		getDataMap().put(Order, list);
		return DataMap;
	}
	//订单详情
	public String viewOrderDetail() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Integer id = Integer.valueOf(request.getParameter("idOrder"));
        orderdetail= orderdetailDAO.findById(id);
		getDataMap().put(Order, orderdetail);
		return DataMap;
	}
	//付款完成(修改订单状态)
	public String paymentOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Short logistics = (Short.valueOf(request.getParameter("")));//管理员确认收款，修改订单表，提示卖家发货
        orderdetail.setLogistics(logistics);
        if(orderdetailDAO.attachDirty(orderdetail)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }
		
		return DataMap;
	}

}
