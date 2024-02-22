<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>

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
	    if (status != null) {
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
		<form action="AttendanceTimeCard" method="POST" >
		<tr>	
			【社員番号】
			<input type="text" name="id"  required  class="id"></input>
		<tr><br>
	</h3>
	
		<tr>
			<input type="submit" name="attendance" value="出勤"  style="width:100px;height:50px"></input>
			
			<input type="submit" name="attendance" value="退勤"  style="width:100px;height:50px"></input>
		<tr>
		
	</form><br><br>
	
	<br><br><a href="Itirann">管理者画面へ</a>
	
</body>
</html>