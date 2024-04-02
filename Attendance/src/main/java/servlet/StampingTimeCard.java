package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StampingInsert;
import model.StampingUpdate1;
import model.StampingUpdate2;
import model.StampingUpdate3;
import model.StampingUpdate4;
import model.StampingUpdate5;

/**
 * Servlet implementation class AttendanceTimeCard
 */
@WebServlet("/StampingTimeCard")
public class StampingTimeCard extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static Date kstm;
    public static String errorMsg1;
    public static String errorMsg2;
    public static String errorMsg3;
    public static String errorMsg4;
    public static String errorMsg5;
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String id = String.valueOf(request.getParameter("id"));
		String password = request.getParameter("password");
		String attendance = request.getParameter("attendance");
		String t_errorMsg;
		String d_errorMsg;

        StampingInsert stampinginsert = new StampingInsert();
        StampingUpdate1 stampingupdate1 = new StampingUpdate1();
        StampingUpdate2 stampingupdate2 = new StampingUpdate2();
        StampingUpdate3 stampingupdate3 = new StampingUpdate3();
        StampingUpdate4 stampingupdate4 = new StampingUpdate4();
        StampingUpdate5 stampingupdate5 = new StampingUpdate5();
        
        try {
            HttpSession session = request.getSession();
      	    session.setAttribute("t_errorMsg", null);	
      	    session.setAttribute("d_errorMsg", null);	
      	    
        	if (id.equals("12345") && password.equals("pass1111") && attendance.equals("出勤")) {
        		Date date = new Date();
        	    StampingTimeCard.kstm = date;
                SimpleDateFormat DateFormat = new SimpleDateFormat("M/dd");
                String dt = DateFormat.format(date);
                SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                String stm = TimeFormat.format(date);
                String ttm = " ";
                String rtm = " ";
                String ztm = " ";
                stampinginsert.insert(id,dt,stm,ttm,rtm,ztm);
                session.setAttribute("status", "出勤しました"); 
                errorMsg1 = "出勤が完了していません。";
        	}

        	else if (id.equals("23456") && password.equals("pass2222") && attendance.equals("出勤")) {
        	    Date date = new Date();
        	    StampingTimeCard.kstm = date;
                SimpleDateFormat DateFormat = new SimpleDateFormat("M/dd");
                String dt = DateFormat.format(date);
                SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                String stm = TimeFormat.format(date);
                String ttm = " ";
                String rtm = " ";
                String ztm = " ";
                stampinginsert.insert(id,dt,stm,ttm,rtm,ztm);
                session.setAttribute("status", "出勤しました"); 
                errorMsg2 = "出勤が完了していません。";
        	}
        	
        	else if (id.equals("34567") && password.equals("pass3333") && attendance.equals("出勤")) {
        		Date date = new Date();
          	    StampingTimeCard.kstm = date;
                SimpleDateFormat DateFormat = new SimpleDateFormat("M/dd");
                String dt = DateFormat.format(date);
                SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                String stm = TimeFormat.format(date);
                String ttm = " ";
                String rtm = " ";
                String ztm = " ";
                stampinginsert.insert(id,dt,stm,ttm,rtm,ztm);
                session.setAttribute("status", "出勤しました"); 
                errorMsg3 = "出勤が完了していません。";
          	}
        	
        	else if (id.equals("45678") && password.equals("pass4444") && attendance.equals("出勤")) {
        		Date date = new Date();
            	StampingTimeCard.kstm = date;
                SimpleDateFormat DateFormat = new SimpleDateFormat("M/dd");
                String dt = DateFormat.format(date);
                SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                String stm = TimeFormat.format(date);
                String ttm = " ";
                String rtm = " ";
                String ztm = " ";
                stampinginsert.insert(id,dt,stm,ttm,rtm,ztm);
                session.setAttribute("status", "出勤しました");  
                errorMsg4 = "出勤が完了していません。";
            }
        	
        	else if (id.equals("56789") && password.equals("pass5555") && attendance.equals("出勤")) {
        		Date date = new Date();
            	StampingTimeCard.kstm = date;
                SimpleDateFormat DateFormat = new SimpleDateFormat("M/dd");
                String dt = DateFormat.format(date);
                SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                String stm = TimeFormat.format(date);
                String ttm = " ";
                String rtm = " ";
                String ztm = " ";
                stampinginsert.insert(id,dt,stm,ttm,rtm,ztm);
                session.setAttribute("status", "出勤しました");   
                errorMsg5 = "出勤が完了していません。";
            }
        	
        	else if (id.equals("12345") && password.equals("pass1111") && attendance.equals("退勤") && errorMsg1 != null) {
        		Date ttm = new Date();
                SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                SimpleDateFormat RZTimeFormat = new SimpleDateFormat("HH:mm"); 
             					 RZTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                Long rtm = ttm.getTime() - StampingTimeCard.kstm.getTime();
                Date drtm = new Date(rtm);    
                String ttm1 = TimeFormat.format(ttm);
                String rtm1 = RZTimeFormat.format(drtm);
                Long ztm = rtm - 28800000;

                if (ztm < 0) {
                	Long lztm = ztm * -1;
                	Date dztm = new Date(lztm);
            	    String ztm1 = "-" + RZTimeFormat.format(dztm);
            	    stampingupdate1.update1(ttm1,rtm1,ztm1);
                }
                else {
                	Date dztm = new Date(ztm);
                    String ztm1 = RZTimeFormat.format(dztm);
                    stampingupdate1.update1(ttm1,rtm1,ztm1);
                }
                session.setAttribute("status", "退勤しました"); 
        	}
        	
        	else if (id.equals("23456") && password.equals("pass2222") && attendance.equals("退勤") && errorMsg2 != null){
        		Date ttm = new Date();
                SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                SimpleDateFormat RZTimeFormat = new SimpleDateFormat("HH:mm"); 
                				 RZTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                Long rtm = ttm.getTime() - StampingTimeCard.kstm.getTime();
                Date drtm = new Date(rtm);    
                String ttm2 = TimeFormat.format(ttm);
                String rtm2 = RZTimeFormat.format(drtm);
                Long ztm = rtm - 28800000;

                if (ztm < 0) {
                	Long lztm = ztm * -1;
            	    Date dztm = new Date(lztm);
             	    String ztm2 = "-" + RZTimeFormat.format(dztm);
             	    stampingupdate2.update2(ttm2,rtm2,ztm2);
                }
                else {
                	Date dztm = new Date(ztm);
                    String ztm2 = RZTimeFormat.format(dztm);
                    stampingupdate2.update2(ttm2,rtm2,ztm2);
                }
                session.setAttribute("status", "退勤しました"); 
             }
             else if (id.equals("34567") && password.equals("pass3333") && attendance.equals("退勤") && errorMsg3 != null){
            	 Date ttm = new Date();
                 SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                 SimpleDateFormat RZTimeFormat = new SimpleDateFormat("HH:mm"); 
                    			  RZTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                 Long rtm = ttm.getTime() - StampingTimeCard.kstm.getTime();
                 Date drtm = new Date(rtm);    
                 String ttm3 = TimeFormat.format(ttm);
                 String rtm3 = RZTimeFormat.format(drtm);
                 Long ztm = rtm - 28800000;

                 if (ztm < 0) {
                	 Long lztm = ztm * -1;
                     Date dztm = new Date(lztm);
                     String ztm3 = "-" + RZTimeFormat.format(dztm);
                     stampingupdate3.update3(ttm3,rtm3,ztm3);
                 }
                 else {
                	  Date dztm = new Date(ztm);
                      String ztm3 = RZTimeFormat.format(dztm);
                      stampingupdate3.update3(ttm3,rtm3,ztm3);
                 }
                 session.setAttribute("status", "退勤しました"); 
             }
             else if (id.equals("45678") && password.equals("pass4444") && attendance.equals("退勤") && errorMsg4 != null){
            	 Date ttm = new Date();
                 SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                 SimpleDateFormat RZTimeFormat = new SimpleDateFormat("HH:mm"); 
                        		  RZTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                 Long rtm = ttm.getTime() - StampingTimeCard.kstm.getTime();
                 Date drtm = new Date(rtm);    
                 String ttm4 = TimeFormat.format(ttm);
                 String rtm4 = RZTimeFormat.format(drtm);
                 Long ztm = rtm - 28800000;

                 if (ztm < 0) {
                	 Long lztm = ztm * -1;
                     Date dztm = new Date(lztm);
                	 String ztm4 = "-" + RZTimeFormat.format(dztm);
                     stampingupdate4.update4(ttm4,rtm4,ztm4);
                 }
                 else {
                	 Date dztm = new Date(ztm);
                     String ztm4 = RZTimeFormat.format(dztm);
                     stampingupdate4.update4(ttm4,rtm4,ztm4);
                 }
                 session.setAttribute("status", "退勤しました"); 
             }
             else if (id.equals("56789") && password.equals("pass5555") && attendance.equals("退勤") && errorMsg5 != null){
            	 Date ttm = new Date();
                 SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm"); 
                 SimpleDateFormat RZTimeFormat = new SimpleDateFormat("HH:mm"); 
                           		  RZTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                 Long rtm = ttm.getTime() - StampingTimeCard.kstm.getTime();
                 Date drtm = new Date(rtm);    
                 String ttm5 = TimeFormat.format(ttm);
                 String rtm5 = RZTimeFormat.format(drtm);
                 Long ztm = rtm - 28800000;

                 if (ztm < 0) {
                	 Long lztm = ztm * -1;
                     Date dztm = new Date(lztm);
                 	 String ztm5 = "-" + RZTimeFormat.format(dztm);
                     stampingupdate5.update5(ttm5,rtm5,ztm5);
                 }
                 else {
                	 Date dztm = new Date(ztm);
                     String ztm5 = RZTimeFormat.format(dztm);
                     stampingupdate5.update5(ttm5,rtm5,ztm5);
                 }
                 session.setAttribute("status", "退勤しました");  
             }   	
             else if ((id.equals("12345") && password.equals("pass1111") && attendance.equals("退勤") && errorMsg1 == null) ||
            		  (id.equals("23456") && password.equals("pass2222") && attendance.equals("退勤") && errorMsg2 == null) || 
            		  (id.equals("34567") && password.equals("pass3333") && attendance.equals("退勤") && errorMsg3 == null) ||
            		  (id.equals("45678") && password.equals("pass4444") && attendance.equals("退勤") && errorMsg4 == null) ||
            		  (id.equals("56789") && password.equals("pass5555") && attendance.equals("退勤") && errorMsg5 == null)) {
            	 t_errorMsg = "出勤が完了していません。";
            	 session.setAttribute("t_errorMsg", t_errorMsg);
            	 RequestDispatcher dispatcher = request.getRequestDispatcher("stamping.jsp");
            	 dispatcher.forward(request, response);
             }
             else {
            	 d_errorMsg = "IDまたはpasswordに誤りがあります。";
           	     session.setAttribute("d_errorMsg", d_errorMsg);	
                 RequestDispatcher dispatcher = request.getRequestDispatcher("stamping.jsp");
                 dispatcher.forward(request, response);
             }
        		
        } catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
        } 
        request.getRequestDispatcher("stamping.jsp").forward(request, response);
	}
}


