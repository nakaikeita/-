<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>出退勤</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1><br></h1>
	<%
		String status = (String)session.getAttribute("status");	
		String t_errorMsg = (String)session.getAttribute("t_errorMsg");
		String d_errorMsg = (String)session.getAttribute("d_errorMsg");
	    if (status != null && t_errorMsg == null && d_errorMsg == null) {
	%>  	
			<div class="sample-popup-window">
				<input type="checkbox" id="sample-popup-switch" />
				<div class="sample-popup-background"></div>
				<div class="sample-popup-box">
					<div class="sample-popup-content">
						<p><%= status %></p>
						<label for="sample-popup-switch" class="sample-popup-close">OK</label>
					</div>
				</div>
			</div> 	
	 <%
		}
	 %>

	<h2>
	<%
      GregorianCalendar cal = new GregorianCalendar();
      SimpleDateFormat format = new SimpleDateFormat("M月d日");
      String datestr = format.format(cal.getTime());
      out.println(datestr);
	%>

  <script>
    function twoDigit(num) {
      let ret;
      if( num < 10 ) 
        ret = "0" + num; 
      else 
        ret = num; 
      return ret;
    }
    function showClock() {
      let nowTime = new Date();
      let nowHour = twoDigit( nowTime.getHours() );
      let nowMin  = twoDigit( nowTime.getMinutes() );
      let nowSec  = twoDigit( nowTime.getSeconds() );
      let msg = nowHour + ":" + nowMin + ":" + nowSec;
      document.getElementById("realtime").innerHTML = msg;
    }
    setInterval('showClock()',1000);
  </script>
  
   <p id="realtime"></p>
	</h2>
   
     <h3>
		<form action="StampingTimeCard" method="POST" >
		<tr>	
			<input type="text" name="id" placeholder="ID" style="width:250px;height:30px" required ></input><br>
			<input type="password" name="password" placeholder="password" style="width:250px;height:30px" required ></input>
		<tr><br>
	 </h3>
	
		<tr>
			<input type="submit" name="attendance" value="出勤"  style="width:100px;height:50px"></input>
			<input type="submit" name="attendance" value="退勤"  style="width:100px;height:50px"></input>
		<tr>

		<% 
			if (t_errorMsg != null) { 
		%>
			<p class="error-msg"><%= t_errorMsg %></p>
		<%
			} 
		%>
		
		<% 
			if (d_errorMsg != null) { 
		%>
			<p class="error-msg"><%= d_errorMsg %></p>
		<%
			} 
		%>
	</form><br><br><br>
	
	 <hr>|<a href="employeelogin.jsp">従業員画面へ</a>|&emsp;&emsp;
	 	 |<a href="managerlogin.jsp">管理者画面へ</a>|
	 <hr>

</body>
</html>
