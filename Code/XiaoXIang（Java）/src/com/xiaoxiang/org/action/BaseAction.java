package com.xiaoxiang.org.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

public class BaseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	private Map<String, Object> dataMap;
	private List list = new ArrayList();
	public static String DataMap = "dataMap";
	public static String Admin = "Admin";
	public static String Buyer = "Buyer";
	public static String Store = "Store";;
	public static String ShopGoods = "ShopGoods";
	public static String Order = "Oder";
	public static String Goods = "Goods";
	public static String ShippingAddress = "shippingaddress";
	public static String MajorFunction = "Majorfunction";
	public static String Collection = "Collection";
	
	public void responseSetHeader() throws Exception{
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "*");
	    response.addHeader("Access-Control-Allow-Headers","Content-Type");
	    response.addHeader("Access-Control-Max-Age","3600");	     
		response.setContentType("text/html; charset=utf-8");
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	protected void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
