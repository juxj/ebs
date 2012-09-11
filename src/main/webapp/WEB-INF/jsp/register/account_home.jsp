<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <jsp:include page="../include/header.jsp"></jsp:include>
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
