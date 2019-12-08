package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.ShopGoods;

public class HomePageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List list;
	private Buyer buyer = null;
	private ShopGoods shopGoods  = new ShopGoods();
	private ShopGoodsDAO shopGoodsDAO = new ShopGoodsDAO();
	public String execute() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		if(buyer!=null)
		list = shopGoodsDAO.membersRecommendedGoods(buyer);
		else {
			list = shopGoodsDAO.touristsRecommendedGoods();
		}
		for(int i=0;i<list.size();i++){
			shopGoods = (ShopGoods)list.get(i);
			System.out.println(shopGoods.getGoods().getGoodsComName());
//			getDataMap().put("ShopGoodsid"+shopGoods.getIdShopGoods().toString(),shopGoods);
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
