package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.ShopGoods;

public class HomePageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShopGoods shopGoods  = new ShopGoods();
	private ShopGoodsDAO shopGoodsDAO = new ShopGoodsDAO();
	public String execute() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		List<ShopGoods> list;
		if(true)
		list = shopGoodsDAO.findAll();
		else {
			list = shopGoodsDAO.findByExample(shopGoods);
		}
		for(int i=0;i<list.size();i++){
			shopGoods = list.get(i);
			getDataMap().put("ShopGoods",shopGoods);
			getDataMap().put(SUCCESS, true);
		}
		return DataMap;
	}
	
	
	
	public ShopGoods getShopGoods() {
		return shopGoods;
	}
	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}

}
