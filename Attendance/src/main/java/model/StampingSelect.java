package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StampingSelect {
    // データベースのURL
    private static final String URL = "jdbc:mysql://localhost:3306/dakokuinfo";
	
    // データベースにアクセスするユーザー
    private static final String USER = "user";
	
    // データベースにアクセスするユーザーのパスワード
    private static final String PASSWORD = "nakai0918";
	
    private List<UserInfo> mlist = new ArrayList<>();
    /**
     * データベースの接続を取得する
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
	
    /**
     * データベースにデータを登録する
     * @param title
     * @param price
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public  List<UserInfo> showAllList() throws ClassNotFoundException, SQLException {
		
        // 実行するSQL
        String sql = "SELECT * FROM user";
		
        // DBに接続する
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
        	
            //SQL文の実行
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){

                //データベースから取得した値をセット
                UserInfo userinfo = new UserInfo();

                //氏名の取得
                userinfo.setId(rs.getString("id"));
                userinfo.setDate(rs.getString("date"));
                userinfo.setStime(rs.getString("stime"));
                userinfo.setTtime(rs.getString("ttime"));
                userinfo.setRtime(rs.getString("rtime"));
                userinfo.setZtime(rs.getString("ztime"));

                mlist.add(userinfo);
            }

        }		
        return mlist;
    }
}