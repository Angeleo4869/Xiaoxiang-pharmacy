package com.xiaoxiang.org.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class JsonTestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;  
    private Map<String,Object> jsonData;  
    public String getJsonList(){
        jsonData = new HashMap<String,Object>();  
        jsonData.put("one", "one's apple");  
        return Action.SUCCESS;  
    }  
    public Map<String,Object> getJsonData() {  
        return jsonData;  
    }  
  
    public void setJsonData(Map<String,Object> jsonData) {  
        this.jsonData = jsonData;  
    }
}
