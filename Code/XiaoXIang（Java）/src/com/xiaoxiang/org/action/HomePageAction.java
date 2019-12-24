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
	private Buyer buyer = new Buyer();
	private ShopGoods shopGoods = new ShopGoods();
	private ShopGoodsDAO shopGoodsDAO = new ShopGoodsDAO();
	
	
	//主页推荐（登录/非登录）
	public String execute() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		String flag = request.getParameter("idBuyer");
		if(flag!=null){//判断idBuyer是否为null
		buyer.setIdBuyer(Integer.valueOf(flag));
		setList(shopGoodsDAO.membersRecommendedGoods(buyer));
		}else {
			setList(shopGoodsDAO.touristsRecommendedGoods());
		}
		getDataMap().put(ShopGoods, getList());
		return DataMap;
	}
	
	//搜索商品，店铺，分类关键字
	public String searchQuery() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		String keyWord = request.getParameter("Search");
		setList( shopGoodsDAO.search(keyWord));
		getDataMap().put(ShopGoods, getList());
		return DataMap;
	}
	
	//药品分类表
	public String viewGoodscClass() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		setList(new MajorfunctionDAO().findAll());
		getDataMap().put(MajorFunction, getList());
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
