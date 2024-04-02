<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者画面</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1><br></h1>
	<p class="manager">管理者画面</p>
	<input class="back" type="submit" name="back" value="戻る" onclick="history.back()" style="width:150px;height:30px"></input>
	<table>
		<th>社員ID</th><th>日付</th><th>出勤時間</th><th>退勤時間</th><th>労働時間</th><th>残業時間</th><br><br>
		<%
			List<UserInfo> mlist = (List<UserInfo>)session.getAttribute("mlist");
			for(int i = 0; i < mlist.size(); i++) {
		%>
			<%
				UserInfo userinfo = (UserInfo)mlist.get(i);
			%>
		<tr>
            <td><%=userinfo.getId()%></td>
            <td><%=userinfo.getDate()%></td>
            <td><%=userinfo.getStime()%></td>
            <td><%=userinfo.getTtime()%></td>
            <td><%=userinfo.getRtime()%></td>
            <td><%=userinfo.getZtime()%></td>
		</tr>
		<% } %>
	</table>
</body>
</html>