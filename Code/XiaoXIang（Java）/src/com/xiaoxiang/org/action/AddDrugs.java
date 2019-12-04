package com.xiaoxiang.org.action;

import java.util.Date;
import java.util.HashMap;

import com.xiaoxiang.org.dao.GoodsDAO;
import com.xiaoxiang.org.dao.MajorfunctionDAO;
import com.xiaoxiang.org.vo.Goods;
import com.xiaoxiang.org.vo.Majorfunction;

public class AddDrugs extends BaseAction {
	private Goods goods = new Goods();
	private Majorfunction majorfunction = new Majorfunction();
	
	public String execute() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        GoodsDAO goodsDAO = new GoodsDAO();
        goods.setGoodsNumber("1602082074");
	    goods.setGoodsCheName("Banlangen Keli");
	    goods.setGoodsComName("板蓝根颗粒");
	    goods.setGoodsComposition("板蓝根");
	    goods.setStorePurchasePrice(30.00);
	    goods.setGoodsCharacter("浅棕色至深棕色颗粒；味甜，微苦。");
	    goods.setGoodsManufacturer("广州白云山和记黄埔中药有限公司");
	    goods.setGoodsProductionDate(new Date());
	    goods.setGoodsSpecifications("10g*20包");
	    goods.setGoodsTaboo("尚不明确");
	    goods.setGoodsUsage("开水冲服，一次半~1袋，一日3~4次");
	    goods.setGoodsValidity(24);
	    majorfunction = new MajorfunctionDAO().findById(2);
	    goods.setMajorfunction(majorfunction);
	    if(goodsDAO.save(goods)){
	    	getDataMap().put(SUCCESS, true);
	    }
        return DataMap;
	}

}
