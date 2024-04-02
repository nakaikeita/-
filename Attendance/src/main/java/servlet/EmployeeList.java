package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StampingSelect;
import model.UserInfo;

//登録データを一覧表示するクラス
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //データベース一覧表示
        StampingSelect nd = new StampingSelect();
        List<UserInfo> mlist = new ArrayList<>();
        
        try {
			mlist = nd.showAllList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        
        List<UserInfo> elist = new ArrayList<>();
        UserInfo userinfo = new UserInfo();
        HttpSession session = request.getSession();
	    String userId = (String)session.getAttribute("id");
        
        for (int i = 0; i < mlist.size(); i++) {
        	userinfo = (UserInfo)mlist.get(i);
        	if (userId.equals("12345") && userinfo.getId().equals("12345")) {
                elist.add(userinfo); 
        	}
        	if (userId.equals("23456") && userinfo.getId().equals("23456")) {
                elist.add(userinfo); 
        	}
        	if (userId.equals("34567") && userinfo.getId().equals("34567")) {
                elist.add(userinfo); 
        	}
        	if (userId.equals("45678") && userinfo.getId().equals("45678")) {
                elist.add(userinfo); 
        	}
        	if (userId.equals("56789") && userinfo.getId().equals("56789")) {
                elist.add(userinfo); 
        	}
        }
        session.setAttribute("elist", elist);
	        
        request.getRequestDispatcher("employee.jsp").forward(request, response);
        
    }
}
