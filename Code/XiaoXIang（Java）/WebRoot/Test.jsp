<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>潇湘Test</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>后台测试</h1><br>
    <div>
     <form action="BuyerLogin">
	    <p>用户登录测试</p>
	    <input type="text" name="BuyerNumber"/>
	    <input type="password" name="BuyerPassword"/>
	    <input type="submit" value="登录"/>
    </form>   
    </div>
    <div>
     <form action="HomePage">
	    <p>主页药品展示</p>
	    <input type="text" name="idBuyer"/>
	    <input type="submit" value="查看药品"/>
    </form>   
    </div>
  </body>
</html>
