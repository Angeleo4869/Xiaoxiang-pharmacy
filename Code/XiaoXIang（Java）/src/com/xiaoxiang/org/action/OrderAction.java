package com.xiaoxiang.org.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.OrderdetailDAO;
import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Orderdetail;
import com.xiaoxiang.org.vo.Shippingaddress;
import com.xiaoxiang.org.vo.ShopGoods;

public class OrderAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Orderdetail orderdetail = new Orderdetail();
	private ShopGoods shopGoods = new ShopGoods();
	private Shippingaddress shippingaddress = new Shippingaddress();
	private Buyer buyer = new Buyer();
	private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
	private ArrayList<List> list = new ArrayList<List>();

	//���򣬵�δ����
	public String placeOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));//���ID
		shopGoods.setIdShopGoods(Integer.valueOf(request.getParameter("idShopGoods")));//�ϼ���ƷID
		Integer goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));//��Ʒ����
		shippingaddress.setIdShippingAddress(Integer.valueOf(request.getParameter("ShippingAddress")));//�ջ���ַ
		shopGoods = new ShopGoodsDAO().findById(shopGoods.getIdShopGoods());
        orderdetail.setOrderNumber(new Date().toString()+buyer.getIdBuyer()+shopGoods.getIdShopGoods());
		orderdetail.setBuyer(buyer);
		orderdetail.setShopGoods(shopGoods);
		orderdetail.setLogistics((short) 0);//����״̬
		orderdetail.setOderState((short) 0);//δ����
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
	//�鿴����
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
	//��������
	public String viewOrderDetail() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Integer id = Integer.valueOf(request.getParameter("idOrder"));
        orderdetail= orderdetailDAO.findById(id);
		getDataMap().put(Order, orderdetail);
		return DataMap;
	}
	//�������(�޸Ķ���״̬)
	public String paymentOrder() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Short oderState = (Short.valueOf(request.getParameter("OderState")));//����Աȷ���տ�޸Ķ�������ʾ���ҷ���
        orderdetail.setOderState(oderState);
        if(orderdetailDAO.attachDirty(orderdetail)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }
		
		return DataMap;
	}

}
