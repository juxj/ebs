<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Account Home</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    
    <ul>
    	
    	<form action="./edit/0.do">
    		<input type="submit" value="create a new account.">
    	</form>
	    <c:forEach items="${accountList}" var="item">
	    	<li><a href="./edit/${item.id }.do">${item.id }, ${item.shortName }, , ${item.fullName }</a></li>
	    </c:forEach>
    </ul>
    <br>
  </body>
</html>