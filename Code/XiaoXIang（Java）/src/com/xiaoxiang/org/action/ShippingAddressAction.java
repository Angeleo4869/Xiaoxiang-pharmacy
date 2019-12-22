package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.ShippingaddressDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Shippingaddress;

public class ShippingAddressAction extends BaseAction {
	
	private Buyer buyer = new Buyer(); 
	private Shippingaddress shippingaddress = new Shippingaddress();
	private ShippingaddressDAO shippingaddressDAO = new ShippingaddressDAO();
	
	//增加或修改收货地址
	public String addOrChangeAddress() throws Exception{
		
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
        shippingaddress.setBuyer(buyer);
        shippingaddress.setRecipientName(request.getParameter("RecipientName"));
        shippingaddress.setRecipientTel(request.getParameter("RecipientTel"));
        shippingaddress.setProvinces(request.getParameter("Provinces"));//省份
        shippingaddress.setCity(request.getParameter("City"));//市
        shippingaddress.setAddressDetail(request.getParameter("AddressDetail"));//详细
        if(shippingaddressDAO.attachDirty(shippingaddress)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }
        
		return DataMap;
	}
	//查看收货地址
	public String viewAddress() throws Exception{

		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
        shippingaddress.setBuyer(buyer);
        list = shippingaddressDAO.findByExample(shippingaddress);
        getDataMap().put(Shippingaddress, true);        
        return DataMap;
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
	
}
