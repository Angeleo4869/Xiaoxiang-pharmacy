package com.xiaoxiang.org.action;

import java.util.HashMap;

import com.xiaoxiang.org.dao.CollectionDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Collection;
import com.xiaoxiang.org.vo.ShopGoods;

public class CollectionAction extends BaseAction {
	private Buyer buyer = new Buyer();
	private ShopGoods shopgoods = new ShopGoods();
	private Collection collection = new Collection();
	private CollectionDAO collectionDAO = new CollectionDAO();
	
	//����ղ�
	public String addCollection() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		String flag = request.getParameter("idShopgoods");
		if(flag!=null)		//�ж�id�Ƿ�Ϊnull 
		shopgoods.setIdShopGoods(Integer.valueOf(flag));
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
		collection.setBuyer(buyer);
		collection.setShopGoods(shopgoods);
		if(collectionDAO.save(collection)){
			getDataMap().put(SUCCESS,true);
			
		}else {
			getDataMap().put(ERROR,false);
		}
		return DataMap;
	}
	
	//ɾ���ղ�
	public String deleteCollection() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
		collection.setBuyer(buyer);
		collection.setShopGoods(shopgoods);
		if(collectionDAO.delete(collection)){
			getDataMap().put(SUCCESS,true);
		}else {
			getDataMap().put(ERROR,false);
		}
		return DataMap;
	}
	
	//�鿴�ղ�
	public String ViewCollection() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));
		collection.setBuyer(buyer);
		collection.setShopGoods(shopgoods);
		setList(collectionDAO.findByExample(collection));
		getDataMap().put(Collection, getList());
		return DataMap;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public ShopGoods getShopgoods() {
		return shopgoods;
	}
	public void setShopgoods(ShopGoods shopgoods) {
		this.shopgoods = shopgoods;
	}
	

}
