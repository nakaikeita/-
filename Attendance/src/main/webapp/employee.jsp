<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員画面</title>
<link rel="stylesheet" href="style2.css">
</head>
<body>
	<h1><br></h1>
	<%
		String id = (String)session.getAttribute("id");
	%>	
	<p class="employee">ID: <%= id %></p>
	<input class="back" type="submit" name="back" value="戻る" onclick="history.back()" style="width:150px;height:30px"></input>
	<br>
	<table>
		<th>日付</th><th>出勤時間</th><th>退勤時間</th><th>労働時間</th><th>残業時間</th><br>
		<%
			List<UserInfo> elist = (List<UserInfo>)session.getAttribute("elist");
			for(int i = 0; i < elist.size(); i++) {
		%>
			<%
				UserInfo userinfo = (UserInfo)elist.get(i);
			%>
        <tr>
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