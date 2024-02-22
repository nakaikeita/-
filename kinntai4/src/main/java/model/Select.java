package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select {
    // データベースのURL
    private static final String URL = "jdbc:mysql://localhost:3306/dakokuinfo";
	
    // データベースにアクセスするユーザー
    private static final String USER = "user";
	
    // データベースにアクセスするユーザーのパスワード
    private static final String PASSWORD = "nakai0918";
	
    private List<Itiranninfo> nlist = new ArrayList<>();
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
    public  List<Itiranninfo> showAllList() throws ClassNotFoundException, SQLException {
		
        // 実行するSQL
        String sql = "SELECT * FROM user";
		
        // DBに接続する
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            //SQL文の実行
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){

                //データベースから取得した値をセット
                Itiranninfo nakamura = new Itiranninfo();

                //氏名の取得
                nakamura.setId(rs.getString("id"));
                nakamura.setAttendance(rs.getString("attendance"));
                nakamura.setDatetime(rs.getString("datetime"));

                nlist.add(nakamura);
            }

        }		
        return nlist;
    }
}