package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiang.org.dao.ShopGoodsDAO;
import com.xiaoxiang.org.dao.ShoppingcartDAO;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.GoodsView;
import com.xiaoxiang.org.vo.ShopGoods;
import com.xiaoxiang.org.vo.Shoppingcart;

public class ShoppingCartAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Buyer buyer = new Buyer();
	private ShopGoods shopGoods = new ShopGoods();
	private Shoppingcart shoppingcart = new Shoppingcart();
	private ShoppingcartDAO shoppingcartDAO = new ShoppingcartDAO();
	private List cart;
	//��ӹ��ﳵ
	public String addShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
		buyer.setIdBuyer(Integer.valueOf(request.getParameter("idBuyer")));//���ID
		shopGoods.setIdShopGoods(Integer.valueOf(request.getParameter("idShopGoods")));//�ϼ���ƷID
		Integer goodsnumber = Integer.valueOf(request.getParameter("GoodsNumber"));//��Ʒ����
        shoppingcart.setBuyer(getBuyer());
        shoppingcart.setShopGoods(getShopGoods());
        shoppingcart.setGoodsNumber(goodsnumber);
        if(shoppingcartDAO.save(shoppingcart)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }                
        return DataMap;
	}
	//ɾ�����ﳵ
	public String deleteShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        Integer id = Integer.valueOf(request.getParameter("idShoppingCart"));
       setShoppingcart(shoppingcartDAO.findById(id));
        if(shoppingcartDAO.delete(shoppingcart)){
        	getDataMap().put(SUCCESS, true);
        }else {
        	getDataMap().put(ERROR, false);
        }                
        return DataMap;
	}
	
	//�鿴���ﳵ
		public String viewShoppingCart() throws Exception{
			responseSetHeader();
	        setDataMap(new HashMap<String, Object>());
	        Integer id = Integer.valueOf(request.getParameter("idBuyer"));
	        buyer.setIdBuyer(id);
	        shoppingcart.setBuyer(buyer);
	        cart = shoppingcartDAO.findByExample(shoppingcart);
	       for(int i=0;i<cart.size();i++){
	    	   shoppingcart = (Shoppingcart)cart.get(i);
	    	   GoodsView goodsView = new ShopGoodsDAO().findGoodsByIdShopGoods(shoppingcart.getShopGoods());
	    	   getList().add(goodsView);
	       }
	        getDataMap().put(ShopGoods, getList());
	        return DataMap;
		}
	
	public Shoppingcart getShoppingcart() {
		return shoppingcart;
	}
	public void setShoppingcart(Shoppingcart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public ShopGoods getShopGoods() {
		return shopGoods;
	}
	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}

}
