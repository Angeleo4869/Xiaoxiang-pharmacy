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
	
	//添加购物车
	public String addShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));//买家ID
		shopGoods.setIdShopGoods(Integer.valueOf(request.getParameter("idShopGoods")));//上架商品ID
		Integer goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));//商品数量
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
	//删除购物车
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
