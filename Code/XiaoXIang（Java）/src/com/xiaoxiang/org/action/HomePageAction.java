package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.ShopGoods;

public class HomePageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List list;
	private Buyer buyer = new Buyer();
	private ShopGoods shopGoods = new ShopGoods();
	private ShopGoodsDAO shopGoodsDAO = new ShopGoodsDAO();
	public String execute() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		buyer = null;
		if(buyer!=null)
		list = shopGoodsDAO.membersRecommendedGoods(buyer);
		else {
			list = shopGoodsDAO.touristsRecommendedGoods();
		}
		
		for(int i=0;i<list.size();i++){
			shopGoods = ((ShopGoods)list.get(i));
//			System.out.println(shopGoods.getGoods().getGoodsComName());
			getDataMap().put("ShopGoodsid:"+shopGoods.getIdShopGoods().toString(),shopGoods);
			getDataMap().put(SUCCESS, true);
		}
		return DataMap;
	}
	
	public String searchQuery() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
//		list = shopGoodsDAO.
		for(int i=0;i<list.size();i++){
			shopGoods = ((ShopGoods)list.get(i));
//			System.out.println(shopGoods.getGoods().getGoodsComName());
			getDataMap().put("ShopGoodsid"+shopGoods.getIdShopGoods().toString(),shopGoods);
			getDataMap().put(SUCCESS, true);
		}
		return DataMap;
	}
	
	
	@JSON(serialize=false)
	public ShopGoods getShopGoods() {
		return shopGoods;
	}
	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}


	@JSON(serialize=false)
	public Buyer getBuyer() {
		return buyer;
	}



	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}


	@JSON(serialize=false)
	public ShopGoodsDAO getShopGoodsDAO() {
		return shopGoodsDAO;
	}



	public void setShopGoodsDAO(ShopGoodsDAO shopGoodsDAO) {
		this.shopGoodsDAO = shopGoodsDAO;
	}

}
