package com.xiaoxiang.org.action;

import java.util.HashMap;

import com.xiaoxiang.org.dao.ShoppingcartDAO;
import com.xiaoxiang.org.vo.Shoppingcart;

public class ShoppingCartAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shoppingcart shoppingcart;
	private ShoppingcartDAO shoppingcartDAO = new ShoppingcartDAO();
	
	
	
	public String addShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
//        shoppingcart.setBuyer(buyer);
//        shoppingcart.setShopGoods(shopGoods);
//        shoppingcart.setGoodsNumber(goodsNumber);
        if(shoppingcartDAO.save(shoppingcart)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }                
        return DataMap;
	}
	
	public String deleteShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
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
