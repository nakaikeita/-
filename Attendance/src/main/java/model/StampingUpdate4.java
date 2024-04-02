package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StampingUpdate4 {
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
    public int update4(String ttm4,String rtm4,String ztm4) throws ClassNotFoundException, SQLException {
		
        // 登録した行数を保持する変数
        int result = 0;

        // 実行するSQL
        String sql1 = "UPDATE user SET ttime = REPLACE(ttime, ' ', ?) where id = '45678';";
        String sql2 = "UPDATE user SET rtime = REPLACE(rtime, ' ', ?) where id = '45678';";
        String sql3 = "UPDATE user SET ztime = REPLACE(ztime, ' ', ?) where id = '45678';";
		
        // DBに接続する
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql1);) {
			
            // パラメータの設定
            pstmt.setString(1, ttm4);
			
            // SQLの実行
            result = pstmt.executeUpdate();
        }
        
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql2);) {
			
            // パラメータの設定
            pstmt.setString(1, rtm4);
			
            // SQLの実行
            result = pstmt.executeUpdate();
        }
        
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql3);) {
			
            // パラメータの設定
            pstmt.setString(1, ztm4);
			
            // SQLの実行
            result = pstmt.executeUpdate();
        }
        return result;
    }
    
}