package com.xiaoxiang.org.action;

import java.util.HashMap;

import com.xiaoxiang.org.dao.ShippingaddressDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Shippingaddress;

public class ShippingAddressAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Buyer buyer = new Buyer(); 
	private Shippingaddress shippingaddress = new Shippingaddress();
	private ShippingaddressDAO shippingaddressDAO = new ShippingaddressDAO();
	
	//���ӻ��޸��ջ���ַ
	public String addOrChangeAddress() throws Exception{
		
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        String flag = request.getParameter("idShippingaddress");
        if(flag!=null){//�ж�id�Ƿ�Ϊnull  
        	
        	setShippingaddress(shippingaddressDAO.findById(Integer.valueOf(flag)));//id��Ϊnull �޸��ջ���ַ �Ȼ�ȡ���޸�
        }
        buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
        shippingaddress.setBuyer(buyer);
        shippingaddress.setRecipientName(request.getParameter("RecipientName"));
        shippingaddress.setRecipientTel(request.getParameter("RecipientTel"));
        shippingaddress.setProvinces(request.getParameter("Provinces"));//ʡ��
        shippingaddress.setCity(request.getParameter("City"));//��
        shippingaddress.setAddressDetail(request.getParameter("AddressDetail"));//��ϸ
        if(shippingaddressDAO.attachDirty(shippingaddress)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }
        
		return DataMap;
	}
	//�鿴�ջ���ַ
	public String viewAddress() throws Exception{

		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
        shippingaddress.setBuyer(buyer);
        setList(shippingaddressDAO.findByExample(shippingaddress));
        getDataMap().put(ShippingAddress, getList());        
        return DataMap;
	}
	
	//ɾ���ջ���ַ
	public String deleteAddress() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        shippingaddress.setIdShippingAddress(Integer.valueOf(request.getParameter("idShippingaddress")));
        if(shippingaddressDAO.delete(getShippingaddress())){
        	 getDataMap().put(SUCCESS, true);     
        }
        getDataMap().put(ERROR, false);        
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
