package com.xiaoxiang.org.mainclass;

import java.util.Date;
import java.util.List;

import com.xiaoxiang.org.dao.AdminDAO;
import com.xiaoxiang.org.dao.BuyerDAO;
import com.xiaoxiang.org.dao.GoodsDAO;
import com.xiaoxiang.org.dao.MajorfunctionDAO;
import com.xiaoxiang.org.vo.Admin;
import com.xiaoxiang.org.vo.Buyer;
import com.xiaoxiang.org.vo.Goods;
import com.xiaoxiang.org.vo.Majorfunction;

public class MainClass {
	private static List list = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		
//		 Admin admin = new Admin();
//	        admin.setAdminNumber("leo");
//	        admin.setAdminPassword("123456");
//	        AdminDAO admindao = new AdminDAO();
//	        //admindao.save(admin);
//	        list = admindao.findByExample(admin);
//	        for(int i=0;i<list.size();i++){
//	        	System.out.println(((Admin)list.get(i)).getAdminNumber());
//	        }
//			
//		 BuyerDAO buyerdao = new BuyerDAO();
//		 Buyer buyer = new Buyer();
//		 buyer.setBuyerNumber("201701020134");
//		 buyer.setBuyerName("leo");
//	     buyer.setBuyerPassword("123456");
//	     buyer.setBuyerEmail("China_leo@163.com");
//	     buyer.setBuyerTel("15935724685");
//	     //buyerdao.save(buyer);
//	     
//	        list = buyerdao.findByExample(buyer);
//	        iter = list.iterator();
//			if(iter.hasNext()){
//				System.out.println(((Buyer) iter.next()).getBuyerName());	
//			}
//		
//	        
//	    
	    Goods goods = new Goods();
	    Majorfunction majorfunction = new Majorfunction();
	    majorfunction.setGoodsClass("��ҩ");
	    majorfunction.setGoodsSeries("����������");
	    majorfunction.setGoodsMajorFunctioncol("��ð����");
	    goods.setGoodsNumber("0009724190");
	    goods.setGoodsCheName("");
	    goods.setGoodsComName("��ð�����");
	    goods.setGoodsComposition("����࣬��յ���̣�Ұ�ջ�����÷...");
	    goods.setStorePurchasePrice(10.90);
	    goods.setGoodsCharacter("ǳ��ɫ������ɫ������ζ��΢�ࡣ");
	    goods.setGoodsManufacturer("��������ҽҩ���޹�˾");
	    goods.setGoodsProductionDate(new Date());
	    goods.setGoodsSpecifications("ÿ����10g");
	    goods.setGoodsTaboo("���ظ������ܲ�ȫ�߽���");
	    goods.setGoodsUsage("��ˮ�����һ��������һ������");
	    goods.setGoodsValidity(24);
	    goods.setMajorfunction(majorfunction);
	    new MajorfunctionDAO().save(majorfunction);
	    new GoodsDAO().save(goods);
//		list = new MajorfunctionDAO().findAll();
//		for(int i=0;i<list.size();i++){
//			System.out.println(((Majorfunction)list.get(i)).getGoodsMajorFunctioncol());
//		}
	    System.out.println("OK!");
	}

}
