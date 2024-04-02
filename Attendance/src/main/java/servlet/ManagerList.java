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
@WebServlet("/ManagerList")
public class ManagerList extends HttpServlet{
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
        
        HttpSession session = request.getSession();
        session.setAttribute("mlist", mlist);

        request.getRequestDispatcher("manager.jsp").forward(request, response);
        
    }
}