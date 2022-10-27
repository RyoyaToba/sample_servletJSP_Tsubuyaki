package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	private final static String DB_URL = "jdbc:mysql://localhost:3306/students";
	private final static String USER_NAME = "root";
	private final static String PASSWORD = "1083rinsyankaiho";
	
	public static Connection createConnection() {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DBの接続に失敗しました");
		}
	}
		
		/* DBから切断するメソッド */
		public static void closeConnection(Connection connection) {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("DBの切断に失敗しました");
			}
	}
}
