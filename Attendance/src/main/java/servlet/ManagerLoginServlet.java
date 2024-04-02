package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ログイン処理を行うサーブレット
 * @author M.Takahashi
 */
@WebServlet("/Manager-login-servlet")
public class ManagerLoginServlet extends HttpServlet {
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
		if (userId.equals("00000") && password.equals("pass0000")) {
			url = "ManagerList";
		}
		else {
			request.setAttribute("errorMsg", "IDまたはpasswordに誤りがあります。");	
			url = "managerlogin.jsp";
		}
        
		// 転送
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
