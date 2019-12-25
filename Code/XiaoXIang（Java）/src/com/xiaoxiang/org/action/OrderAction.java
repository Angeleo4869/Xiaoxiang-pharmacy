package com.xiaoxiang.org.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.OrderViewDAO;
import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.OrderView;
import com.xiaoxiang.org.vo.OrderViewId;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.Shippingaddress;
import com.xiaoxiang.org.vo.ShopGoods;

public class OrderAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Buyer buyer = new Buyer();
	private Orderdetail orderdetail = new Orderdetail();
	private ShopGoods shopGoods = new ShopGoods();
	private Shippingaddress shippingaddress = new Shippingaddress();
	private OrderView orderView = new OrderView();
	private OrderViewId orderViewId = new OrderViewId();
	private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
	private OrderViewDAO orderViewDAO = new OrderViewDAO();
	private ArrayList<List> arrayList = new ArrayList<List>();
	
//下单
	public String placeOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));//买家ID
		Integer flag = Integer.valueOf(request.getParameter("idShopGoods"));
		Integer goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));//商品数量
		shippingaddress.setIdShippingAddress(Integer.valueOf(request.getParameter("ShippingAddress")));//收货地址
		shopGoods = new ShopGoodsDAO().findById(flag);
        orderdetail.setOrderNumber(new Date().toString()+buyer.getIdBuyer().toString()+shopGoods.getIdShopGoods().toString());
		orderdetail.setBuyer(buyer);
		orderdetail.setShopGoods(shopGoods);
		orderdetail.setStore(shopGoods.getStore());
		orderdetail.setLogistics((short) 0);//发货状态
		orderdetail.setOderState((short) 0);//未付款
		orderdetail.setShippingaddress(shippingaddress);
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
       String flag = request.getParameter("idBuyer");
       orderViewId.setIdbuyer(null);
       orderViewId.setIdStore(null);
        if(flag!=null)
        	orderViewId.setIdbuyer(Integer.valueOf(flag));
        flag = request.getParameter("idStore");
        if(flag!=null)
        	orderViewId.setIdStore(Integer.valueOf(flag));
        for(Short orderstate = 0;orderstate<5;orderstate++){
			orderViewId.setOdstate(orderstate);
			orderView.setId(orderViewId);
			getArrayList().add(orderdetailDAO.findByOrderView(orderView));
		}
		getDataMap().put(Order, getArrayList());
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
        Integer id = Integer.valueOf(request.getParameter("idOrder"));
        Short oderState = (Short.valueOf(request.getParameter("OrderState")));//管理员确认收款，修改订单表，提示卖家发货
        setOrderdetail(orderdetailDAO.findById(id));
        orderdetail.setOderState(oderState);
        setShopGoods(orderdetail.getShopGoods());
        if(oderState==1)
        	shopGoods.setShopGoodsInventory(shopGoods.getShopGoodsInventory()-1);
        if(oderState==2)
        	shopGoods.setShopGoodsSales(shopGoods.getShopGoodsSales()+1);
        if(orderdetailDAO.attachDirty(orderdetail)){
        	new ShopGoodsDAO().attachDirty(getShopGoods());
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }
		
		return DataMap;
	}
	//获取系统时间
    private String dateTime(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		//System.out.println(sdf.format(calendar.getTime()));
		String Time = new String(sdf.format(new java.util.Date()).trim());
		return Time;
		}
    
	public Orderdetail getOrderdetail() {
		return orderdetail;
	}
	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}
	public ShopGoods getShopGoods() {
		return shopGoods;
	}
	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}
	public Shippingaddress getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(Shippingaddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public OrderView getOrderView() {
		return orderView;
	}
	public void setOrderView(OrderView orderView) {
		this.orderView = orderView;
	}
	public OrderViewId getOrderViewId() {
		return orderViewId;
	}
	public void setOrderViewId(OrderViewId orderViewId) {
		this.orderViewId = orderViewId;
	}
	public ArrayList<List> getArrayList() {
		return arrayList;
	}
	public void setArrayList(ArrayList<List> arrayList) {
		this.arrayList = arrayList;
	}

}
