<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加账户信息</title>
</head>
<body>

<form id="ajaxFrm" action="AddServlet" method="post">
	<table align="center" width="450">
		<tr>
			<td align="center" colspan="2">
				<h2>添加账户信息</h2>
				<hr>
			</td>
		</tr>
       
		<tr>
			<td align="right">账户名：</td>
			<td><input type="text" name="username" id="code"></td>
		</tr>
		<tr>
			<td align="right">余额：</td>
			<td><input type="text" name="balance" id="balance"></td>
		</tr>
        <tr>
			<td align="center" colspan="2"><input type="submit" value="提交">
			</td>
		</tr>
	</table>
</form>

<h4 align="center">
	<a href="FindAllServlet">返回账户信息列表>></a>
</h4>

</body>
</html>