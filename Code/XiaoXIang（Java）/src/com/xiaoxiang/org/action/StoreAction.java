package com.xiaoxiang.org.action;
import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.dao.StoreDAO;
import com.xiaoxiang.org.vo.Goods;
import com.xiaoxiang.org.vo.ShopGoods;
import com.xiaoxiang.org.vo.Store;

public class StoreAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store = new Store();
	private StoreDAO storeDao = new StoreDAO();
	private ShopGoods shopgoods = new ShopGoods();
	private Goods goods = new Goods();
	private ShopGoodsDAO shopGoodsDAO = new ShopGoodsDAO();
	//查看所有商家
	public String execute() throws Exception{

		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		getDataMap().put(Store,storeDao.findAll());
		return DataMap;
	}
	
	//商家登录
	public String storeLogin() throws Exception{
		// TODO Auto-generated method stub
		
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		store.setStoreNumber(request.getParameter("StoreNumber"));
		store.setStorePassword(request.getParameter("StorePassword"));
		if(store.getStoreNumber()!=null){
		List<Store> list = storeDao.findByExample(store);
		getDataMap().put(Store, list);
		} else {
			getDataMap().put(ERROR, false);
		}
		return DataMap;
	}
	//商家注册
	public String storeRegister() throws Exception{
        responseSetHeader();
		setDataMap(new HashMap<String, Object>());
        store.setStoreNumber(request.getParameter("StoreNumber"));
        store.setStorePassword(request.getParameter("StorePassword"));
        if(storeDao.save(getStore())){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR,false);
        }
        return DataMap;
	}
	
	
	//编辑店铺信息
	public String editStore() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idStore"));
		setStore(storeDao.findById(id));
		store.setStoreName(request.getParameter("StoreName"));
        store.setStorePhyName(request.getParameter("StorePhyName"));//法人姓名
        store.setStorePhyIdCard(request.getParameter("StorePhyIdCard"));//法人身份证
        store.setStoreState((short)1);//店铺状态 1 开业
        store.setStoreAddress(request.getParameter("StoreAddress"));//店铺地址
        store.setStoreLicense(request.getParameter("StoreLicense"));//店铺营业许可证
        store.setStoreTel(request.getParameter("StoreTel"));//店铺电话
        if(storeDao.attachDirty(getStore())){
      	 getDataMap().put(SUCCESS, true);
         } else {
      	  getDataMap().put(ERROR,false);
      }
      return DataMap;
	}
	
	//查看店铺信息
	public String viewStore() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		store.setIdStore(Integer.valueOf(request.getParameter("idStore")));		
		getDataMap().put(Store, storeDao.findById(store.getIdStore()));
		return DataMap;
	}
	
	
	//店铺注销
	public String deleteStore() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idStore"));
		setStore(storeDao.findById(id));
		if(storeDao.delete(getStore())){
	      	getDataMap().put(SUCCESS, true);
	      }else {
	      	getDataMap().put(ERROR,false);
	      }
	        return DataMap;
	}
	//增加或修改上架商品
	public String  addOrChangeShopGoods() throws Exception{   //id为null 执行Update 否则执行Save
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		String flag = request.getParameter("idShopgoods");
		if(flag!=null){//判断id是否为null 
			setShopgoods(shopGoodsDAO.findById(Integer.valueOf(flag)));
		}
		flag = request.getParameter("idgoods");
		if(flag!=null)		//判断id是否为null 
		goods.setIdGoods(Integer.valueOf(flag));
		flag = request.getParameter("idStore");
		if(flag!=null)      //判断id是否为null 
		store.setIdStore(Integer.valueOf(flag));
		shopgoods.setShopGoodsName(request.getParameter("ShopGoodsName"));//上架商品名称
		shopgoods.setShopGoodsImage(request.getParameter("ShopGoodsImage"));//商品展示图
		shopgoods.setShopGoodsFreight(Double.valueOf(request.getParameter("ShopGoodsFreight")));//运费
		shopgoods.setShopGoodsInventory(Integer.valueOf(request.getParameter("GoodsInventory")));//商品库存
		shopgoods.setShopGoodsPrice(Double.valueOf(request.getParameter("GoodsPrice")));//商品售价
		shopgoods.setShopGoodsSales(0);
		shopgoods.setShopGoodsDetailImage(request.getParameter("DetailImage"));//商品详情图片
		shopgoods.setStore(store);
		shopgoods.setGoods(goods);
		if(new ShopGoodsDAO().attachDirty(getShopgoods())){
	      	getDataMap().put(SUCCESS, true);
	      }else {
	      	getDataMap().put(ERROR,false);
	      }
	        return DataMap;
	}
	
	//
	public String deleteShopGoods() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idShopGoods"));
		setShopgoods(shopGoodsDAO.findById(id));
		if(shopGoodsDAO.delete(getShopgoods())){
	      	getDataMap().put(SUCCESS, true);
	      }else {
	      	getDataMap().put(ERROR,false);
	      }
		return DataMap;
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}

	public ShopGoods getShopgoods() {
		return shopgoods;
	}

	public void setShopgoods(ShopGoods shopgoods) {
		this.shopgoods = shopgoods;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}