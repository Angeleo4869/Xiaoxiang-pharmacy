package com.xiaoxiang.org.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	private Map<String, Object> dataMap;
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

}
