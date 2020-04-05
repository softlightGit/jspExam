<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.Account" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin:0;
		padding:0;
		list-style:none;
	}
	form {
		width:300px;
		height:400px;
		margin:0 auto;
	}
	form label {
		margin-right:10px
	}
	form input {
		width:160px;
		height:30px;
		padding-left:10px;
		line-height:30px
	}
	form ul li {
		height:40px;
		margin:20px 0;
		line-height:40px;
	}
	form ul li:last-of-type input {
		width:80px;
		height:33px;
		margin-left:80px;
		margin-top:20px;
		padding-left:0;
		border:none;
		background:rgba(30,144,255,.3);
		line-height:34px;
		text-align:center;
		font-weight:700;
		
	}
</style>
</head>
<body>
<% 
	request.setCharacterEncoding("UTF-8"); 
	
	Account account = (Account) request.getAttribute("account");
	
	if (account != null) {
%>
	<form action="UpdateServlet?id=<%=account.getId()%>" method="post">
		<ul>
			<li><label>账户:</label><input type="text" name="username" value="<%=account.getUsername()%>"></li>
			<li><label>余额:</label><input type="text" name="balance" value="<%=account.getBalance()%>"></li>
			<li><input type="submit" value="确认修改"></li>
		</ul>
	</form>
</body>
</html>
<% 
	} else {
		out.print("要修改的数据有误！");
	}
%>