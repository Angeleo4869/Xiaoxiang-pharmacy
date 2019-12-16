package com.xiaoxiang.org.action;

import java.io.IOException;
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
	public static String DataMap = "dataMap";
	public static String Admin = "Admin";
	public static String Buyer = "Buyer";
	public static String Store = "Store";;
	public static String ShopGoods = "ShopGoods";
	public static String Order = "Oder";
	public static String Goods = "Goods";
	public void responseSetHeader() throws Exception{
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "*");
	    response.addHeader("Access-Control-Allow-Headers","Content-Type");
	    response.addHeader("Access-Control-Max-Age","3600");	     
		response.setContentType("text/html; charset=utf-8");
	}
	
	//解析请求的Json数据
    private String getRequestPostData(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {
            int len = request.getInputStream().read(buffer, i, contentLength - i);
            if (len == -1) {
                break;
            }
            i += len;
        }
        return new String(buffer, "utf-8");
    }
    
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	protected void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
