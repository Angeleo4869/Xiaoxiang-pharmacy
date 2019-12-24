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
	
	//����ҩƷ
	public String execute() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        setList(goodsDAO.findAll());
        getDataMap().put(Goods, getList());
        return DataMap;
	}
	//���ӻ�༭ҩƷ��Ϣ
	public String addOrChangeGoods() throws Exception{       //idΪnull ִ��Update ����ִ��Save
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());
        String flag = request.getParameter("idGoods");
        if(flag!=null)//�ж�id�Ƿ�Ϊnull  
        goods.setIdGoods(Integer.valueOf(flag));
        majorfunction = new MajorfunctionDAO().findById(Integer.valueOf(request.getParameter("MajorFunction")));
        goods.setGoodsNumber(request.getParameter("GoodsNumber"));//ҩƷ��ţ������룩
	    goods.setGoodsCheName(request.getParameter("GoodsCheName"));//ҩƷ����
	    goods.setGoodsComName(request.getParameter("GoodsComName"));//ҩƷƴ����ѧ��
	    goods.setGoodsComposition(request.getParameter("GoodsComposition"));//ҩƷ�ɷ�
	    goods.setStorePurchasePrice(Double.valueOf(request.getParameter("StorePurchasePrice")));//ҩƷ����
	    goods.setGoodsCharacter(request.getParameter("GoodsCharacter"));//ҩƷ��״
	    goods.setGoodsManufacturer(request.getParameter("GoodsManufacturer"));//ҩƷ����
	    goods.setGoodsProductionDate(new Date());//��������
	    goods.setGoodsSpecifications(request.getParameter("GoodsSpecifications"));//ҩƷ���
	    goods.setGoodsTaboo(request.getParameter("GoodsTaboo"));//ҩƷ����
	    goods.setGoodsUsage(request.getParameter("GoodsUsage"));//ҩƷ���÷���
	    goods.setGoodsValidity(Integer.valueOf(request.getParameter("GoodsValidity")));//ҩƷ��Ч�ڣ��£�
	    goods.setMajorfunction(majorfunction);//ҩƷ���
	    if(goodsDAO.attachDirty(goods)){
	    	getDataMap().put(SUCCESS, true);
	    }else {
			getDataMap().put(ERROR, false);
		}
        return DataMap;
	}
	//ɾ��ҩƷ
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
	//�鿴��Ʒ����
    public String viewShopGoodsDetail() throws Exception{
		responseSetHeader();
	    setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idShopGoods"));
		setList( goodsDAO.findGoodsDeatil(id));
		getDataMap().put(Goods,getList());
		return DataMap;
	}
    
	//�鿴ҩƷ����
    public String viewGoodsDetail() throws Exception{
		responseSetHeader();
	    setDataMap(new HashMap<String, Object>());
		Integer id = Integer.valueOf(request.getParameter("idGoods"));
		setGoods (goodsDAO.findById(id));
		getDataMap().put(Goods,getGoods());
		return DataMap;
	}
    
	//�����ϼ���Ʒ
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
