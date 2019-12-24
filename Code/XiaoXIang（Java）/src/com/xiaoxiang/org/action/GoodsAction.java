package com.xiaoxiang.org.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.GoodsDAO;
import com.xiaoxiang.org.dao.MajorfunctionDAO;
import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.vo.Goods;
import com.xiaoxiang.org.vo.Majorfunction;

public class GoodsAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Goods goods = new Goods();
	private Majorfunction majorfunction = new Majorfunction();
	private GoodsDAO goodsDAO = new GoodsDAO();
	
	//所有药品
	public String execute() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        setList(goodsDAO.findAll());
        getDataMap().put(Goods, getList());
        return DataMap;
	}
	//增加或编辑药品信息
	public String addOrChangeGoods() throws Exception{       //id为null 执行Update 否则执行Save
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        String flag = request.getParameter("idGoods");
        if(flag!=null)//判断id是否为null  
        goods.setIdGoods(Integer.valueOf(flag));
        majorfunction = new MajorfunctionDAO().findById(Integer.valueOf(request.getParameter("MajorFunction")));
        goods.setGoodsNumber(request.getParameter("GoodsNumber"));//药品编号（条形码）
	    goods.setGoodsCheName(request.getParameter("GoodsCheName"));//药品名称
	    goods.setGoodsComName(request.getParameter("GoodsComName"));//药品拼音或化学名
	    goods.setGoodsComposition(request.getParameter("GoodsComposition"));//药品成分
	    goods.setStorePurchasePrice(Double.valueOf(request.getParameter("StorePurchasePrice")));//药品进价
	    goods.setGoodsCharacter(request.getParameter("GoodsCharacter"));//药品性状
	    goods.setGoodsManufacturer(request.getParameter("GoodsManufacturer"));//药品厂家
	    goods.setGoodsProductionDate(new Date());//生产日期
	    goods.setGoodsSpecifications(request.getParameter("GoodsSpecifications"));//药品规格
	    goods.setGoodsTaboo(request.getParameter("GoodsTaboo"));//药品禁忌
	    goods.setGoodsUsage(request.getParameter("GoodsUsage"));//药品服用方法
	    goods.setGoodsValidity(Integer.valueOf(request.getParameter("GoodsValidity")));//药品有效期（月）
	    goods.setMajorfunction(majorfunction);//药品类别
	    if(goodsDAO.attachDirty(goods)){
	    	getDataMap().put(SUCCESS, true);
	    }else {
			getDataMap().put(ERROR, false);
		}
        return DataMap;
	}
	//删除药品
	public String deleteGoods() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Integer id = Integer.valueOf(request.getParameter("idGoods"));
		setGoods(goodsDAO.findById(id));
		if(goodsDAO.delete(goods)){
			getDataMap().put(SUCCESS, true);
		}else {
			getDataMap().put(ERROR, false);
		}
		return DataMap;
	}
	//查看商品详情
    public String viewShopGoodsDetail() throws Exception{
		responseSetHeader();
	    setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idShopGoods"));
		setList( goodsDAO.findGoodsDeatil(id));
		getDataMap().put(Goods,getList());
		return DataMap;
	}
    
	//查看药品参数
    public String viewGoodsDetail() throws Exception{
		responseSetHeader();
	    setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idGoods"));
		setGoods (goodsDAO.findById(id));
		getDataMap().put(Goods,getGoods());
		return DataMap;
	}
    
	//所有上架商品
	public String allShopGoods() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		setList(new  ShopGoodsDAO().touristsRecommendedGoods());
		getDataMap().put(ShopGoods, getList());
		return DataMap;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
