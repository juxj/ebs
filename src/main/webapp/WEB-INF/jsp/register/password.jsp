<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'edit_account.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my plage">
	<jsp:include page="include/style.jsp"/>
  </head>
  <body>
  	<jsp:include page="include/header.jsp"/>
  		<div class="box_form">
	  		<div class="form_header">Header</div>
	  		<div class="form_body">
		    	<f:form 
		    		commandName="user" 
		    		action="/ebs/user/changePassword.do" 
		    		method="post" >
		    		<f:hidden path="id"/>
		    		<dt>
		    			<dd>
		    				<h6><s:message code="tbl.user.email"/>:</h6>
		    				<f:input id="email" path="email"/></dd>
		    			<dd>
		    				<h6><s:message code="tbl.user.userName"/>:</h6>
		    				<f:input path="userName"/></dd>
		    			<dd>
		    				<h6><s:message code="tbl.user.password"/>:</h6>
		    				<f:input path="password"/></dd>
		    			<dd>
		    				<h6><s:message code="tbl.user.retypePassword"/>:</h6> 
		    				<f:input path="password"/></dd>
		    			<dd>
		    				<h6>&nbsp;</h6>
		    				<input type="submit" value="Save Changes" />
		    			</dd>
		    		</dt>
		    		
		    	</f:form>
	    	</div>
    	</div>
  </body>
<jsp:include page="include/footer.jsp"/>
</html>