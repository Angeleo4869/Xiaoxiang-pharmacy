package com.xiaoxiang.org.action;

import java.util.HashMap;

import com.xiaoxiang.org.dao.ShoppingcartDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.ShopGoods;
import com.xiaoxiang.org.vo.Shoppingcart;

public class ShoppingCartAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Buyer buyer = new Buyer();
	private ShopGoods shopGoods = new ShopGoods();
	private Shoppingcart shoppingcart;
	private ShoppingcartDAO shoppingcartDAO = new ShoppingcartDAO();
	
	//��ӹ��ﳵ
	public String addShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));//���ID
		shopGoods.setIdShopGoods(Integer.valueOf(request.getParameter("idShopGoods")));//�ϼ���ƷID
		Integer goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));//��Ʒ����
        shoppingcart.setBuyer(buyer);
        shoppingcart.setShopGoods(shopGoods);
        shoppingcart.setGoodsNumber(goodsnumber);
        if(shoppingcartDAO.save(shoppingcart)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }                
        return DataMap;
	}
	//ɾ�����ﳵ
	public String deleteShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        shoppingcart.setIdshoppingcart(Integer.valueOf(request.getParameter("idShoppingCart")));
        if(shoppingcartDAO.delete(shoppingcart)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }                
        return DataMap;
	}
	
	
	public Shoppingcart getShoppingcart() {
		return shoppingcart;
	}
	public void setShoppingcart(Shoppingcart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

}
