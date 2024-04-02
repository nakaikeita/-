package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログイン処理を行うサーブレット
 * @author M.Takahashi
 */
@WebServlet("/Employee-login-servlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String url;
		// ログイン処理
		if (userId.equals("12345") && password.equals("pass1111")) {
			url = "EmployeeList";
		}
		else if (userId.equals("23456") && password.equals("pass2222")){
			url = "EmployeeList";
		}
		else if (userId.equals("34567") && password.equals("pass3333")){
			url = "EmployeeList";
		}
		else if (userId.equals("45678") && password.equals("pass4444")){
			url = "EmployeeList";
		}
		else if (userId.equals("56789") && password.equals("pass5555")){
			url = "EmployeeList";
		}
		else {
			request.setAttribute("errorMsg", "IDまたはpasswordに誤りがあります。");	
			url = "employeelogin.jsp";
		}
		
        HttpSession session = request.getSession();
        session.setAttribute("id", userId);
        
		// 転送
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
