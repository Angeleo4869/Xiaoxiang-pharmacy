package com.xiaoxiang.org.action;

import java.util.HashMap;

public class ShoppingCartAction extends BaseAction {
	
	public String addShoppingCart() throws Exception{
		responseSetHeader();
        setDataMap(new HashMap<String, Object>());

        return DataMap;
	}

}
