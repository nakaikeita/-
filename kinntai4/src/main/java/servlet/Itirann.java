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

import model.Itiranninfo;
import model.Select;


//登録データを一覧表示するクラス
@WebServlet("/Itirann")
public class Itirann extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //データベース一覧表示
        Select nd = new Select();
        List<Itiranninfo> nlist = new ArrayList<>();
        try {
			nlist = nd.showAllList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        
	        HttpSession session = request.getSession();
	        session.setAttribute("nlist", nlist);
	        
        request.getRequestDispatcher("kannrisya.jsp").forward(request, response);
    }
}