<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="com.bean.Account"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账户信息列表</title>
</head>
<body>
<center>
		<h1>账户信息列表</h1>
		<table width="80%">
			<tr>
				<td><font color=red><br> <marquee
							direction=left scrollamount="4">
							
						</marquee> </font></td>
			</tr>
			<tr>
				<td><a href="add.jsp">添加账户信息</a></td>
			</tr>
		</table>
	<table width="80%">
		
		<tr style="background-color: #00BFFF; border-bottom: 2px solid black; height: 30px">
			<th>账户</th>
			<th>余额</th>

			<th colspan="2">操作</th>
		</tr>
		<%
			// 获取个人信息集合
			List<Account> list = (List<Account>) request.getAttribute("list");
			// 判断集合是否有效
			if (list == null || list.size() < 1) {
				out.print("没有数据！");
			} else {
				// 遍历个人集合中的数据
				for (Account account : list) {
		%>
		<tr style="background-color: #87CEFA; border-bottom: 2px solid black; height: 30px">

			<td><%=account.getUsername()%></td>
			<td><%=account.getBalance()%></td>		
			<td>
				<a href="GetOldInfoServlet?id=<%=account.getId()%>">编辑</a>	 
			</td>
		    <td>
		    <a href="DeleteServlet?id=<%=account.getId()%>">删除</a>
		    </td>
		</tr>
		<%
			  }
			}
		%>
	</table>
</center>
</body>
</html>