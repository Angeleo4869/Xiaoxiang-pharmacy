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
	//�鿴�����̼�
	public String execute() throws Exception{

		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		getDataMap().put(Store,storeDao.findAll());
		return DataMap;
	}
	
	//�̼ҵ�¼
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
	//�̼�ע��
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
	
	
	//�༭������Ϣ
	public String editStore() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idStore"));
		setStore(storeDao.findById(id));
		store.setStoreName(request.getParameter("StoreName"));
        store.setStorePhyName(request.getParameter("StorePhyName"));//��������
        store.setStorePhyIdCard(request.getParameter("StorePhyIdCard"));//�������֤
        store.setStoreState((short)1);//����״̬ 1 ��ҵ
        store.setStoreAddress(request.getParameter("StoreAddress"));//���̵�ַ
        store.setStoreLicense(request.getParameter("StoreLicense"));//����Ӫҵ���֤
        store.setStoreTel(request.getParameter("StoreTel"));//���̵绰
        if(storeDao.attachDirty(getStore())){
      	 getDataMap().put(SUCCESS, true);
         } else {
      	  getDataMap().put(ERROR,false);
      }
      return DataMap;
	}
	
	//�鿴������Ϣ
	public String viewStore() throws Exception{
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		store.setIdStore(Integer.valueOf(request.getParameter("idStore")));		
		getDataMap().put(Store, storeDao.findById(store.getIdStore()));
		return DataMap;
	}
	
	
	//����ע��
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
	//���ӻ��޸��ϼ���Ʒ
	public String  addOrChangeShopGoods() throws Exception{   //idΪnull ִ��Update ����ִ��Save
		responseSetHeader();
		setDataMap(new HashMap<String, Object>());
		String flag = request.getParameter("idShopgoods");
		if(flag!=null){//�ж�id�Ƿ�Ϊnull 
			setShopgoods(shopGoodsDAO.findById(Integer.valueOf(flag)));
		}
		flag = request.getParameter("idgoods");
		if(flag!=null)		//�ж�id�Ƿ�Ϊnull 
		goods.setIdGoods(Integer.valueOf(flag));
		flag = request.getParameter("idStore");
		if(flag!=null)      //�ж�id�Ƿ�Ϊnull 
		store.setIdStore(Integer.valueOf(flag));
		shopgoods.setShopGoodsName(request.getParameter("ShopGoodsName"));//�ϼ���Ʒ����
		shopgoods.setShopGoodsImage(request.getParameter("ShopGoodsImage"));//��Ʒչʾͼ
		shopgoods.setShopGoodsFreight(Double.valueOf(request.getParameter("ShopGoodsFreight")));//�˷�
		shopgoods.setShopGoodsInventory(Integer.valueOf(request.getParameter("GoodsInventory")));//��Ʒ���
		shopgoods.setShopGoodsPrice(Double.valueOf(request.getParameter("GoodsPrice")));//��Ʒ�ۼ�
		shopgoods.setShopGoodsSales(0);
		shopgoods.setShopGoodsDetailImage(request.getParameter("DetailImage"));//��Ʒ����ͼƬ
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