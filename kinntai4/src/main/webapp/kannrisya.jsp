<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Itiranninfo" %>
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
	<p class="kannrisya">管理者画面</p>
	<input class="back" type="submit" name="back" value="戻る" onclick="history.back()" style="width:150px;height:30px"></input>
	<table>
		<th>社員ID</th><th>出勤/退勤</th><th>出勤/退勤時間</th><br><br>
	  <% List<Itiranninfo> nlist = (List<Itiranninfo>)session.getAttribute("nlist");
       for(int i = 0; i < nlist.size(); i++){ %>
        <% Itiranninfo itiranninfo = (Itiranninfo)nlist.get(i); %>
        <tr>
            <td><%=itiranninfo.getId()%></td>
            <td><%=itiranninfo.getAttendance()%></td>
            <td><%=itiranninfo.getDatetime()%></td>
        </tr>
    <% } %>
	</table>
	

</body>
</html>