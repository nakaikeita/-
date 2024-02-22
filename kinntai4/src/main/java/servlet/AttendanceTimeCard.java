package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Insert;


/**
 * Servlet implementation class AttendanceTimeCard
 */
@WebServlet("/AttendanceTimeCard")
public class AttendanceTimeCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String id = String.valueOf(request.getParameter("id"));
	
		String attendance = request.getParameter("attendance");
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String now = sdf.format(timestamp);
        Insert dao = new Insert();
        
        try {
        	if (attendance.equals("出勤")) {
              dao.insert(id,attendance,now);
              HttpSession session = request.getSession();
              session.setAttribute("status", "出勤しました");
              
        	}
        		
        	else {
                dao.insert(id,attendance,now);
                HttpSession session = request.getSession();
                session.setAttribute("status", "退勤しました"); 

        	}
        		
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        request.getRequestDispatcher("syuttaikinn.jsp").forward(request, response);
    }
}

