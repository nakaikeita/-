package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insert {
    // データベースのURL
    private static final String URL = "jdbc:mysql://localhost:3306/dakokuinfo";
	
    // データベースにアクセスするユーザー
    private static final String USER = "user";
	
    // データベースにアクセスするユーザーのパスワード
    private static final String PASSWORD = "nakai0918";
	
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
    public int insert(String id, String attendance, String now) throws ClassNotFoundException, SQLException {
		
        // 登録した行数を保持する変数
        int result = 0;
		
        
        // 実行するSQL
        String sql = "INSERT INTO user(id, attendance, datetime) values(?, ?, ?);";
		
        // DBに接続する
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
			
            // パラメータの設定
            pstmt.setString(1, id);
            pstmt.setString(2, attendance);
            pstmt.setString(3, now);
			
            // SQLの実行
            result = pstmt.executeUpdate();
        }		
        return result;
    }
}