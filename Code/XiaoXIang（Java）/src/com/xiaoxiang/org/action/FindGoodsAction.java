package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.ShopGoods;

public class FindGoodsAction extends BaseAction {
	private ShopGoods shopGoods;
	private ShopGoodsDAO shopGoodsDAO;
	public String execute() throws Exception{
		responseSetHeader();
	    setDataMap(new HashMap<String, Object>());
		List<ShopGoods> list = shopGoodsDAO.findAll();
		for(int i=0;i<list.size();i++){
			shopGoods = list.get(i);
			getDataMap().put("ShopGoodsid"+shopGoods.getIdShopGoods().toString(),shopGoods);
			getDataMap().put(SUCCESS, true);
		}
		return DataMap;
	}

}
