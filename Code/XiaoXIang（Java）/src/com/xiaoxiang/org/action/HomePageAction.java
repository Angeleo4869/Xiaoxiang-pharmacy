package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.xiaoxiang.org.dao.MajorfunctionDAO;
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
	//Ö÷Ò³ÍÆ¼ö£¨µÇÂ¼/·ÇµÇÂ¼£©
	public String execute() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(null);
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
		if(buyer.getIdBuyer()!=null)
		list = shopGoodsDAO.membersRecommendedGoods(buyer);
		else {
			list = shopGoodsDAO.touristsRecommendedGoods();
		}
		getDataMap().put(ShopGoods, list);
		return DataMap;
	}
	
	//ËÑË÷ÉÌÆ·£¬µêÆÌ£¬·ÖÀà¹Ø¼ü×Ö
	public String searchQuery() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		String keyWord = request.getParameter("Search");
		list = shopGoodsDAO.search(keyWord);
		getDataMap().put(ShopGoods, list);
		return DataMap;
	}
	
	//ËÑË÷ÉÌÆ·£¬µêÆÌ¹Ø¼ü×Ö
	public String viewGoodscClass() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		list = new MajorfunctionDAO().findAll();
		getDataMap().put(ShopGoods, list);
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
