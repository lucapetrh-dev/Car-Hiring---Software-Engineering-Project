package DB;

import java.sql.*;

public class DBManager {
	public static Connection conn;
	public static Connection getConnection() {
		try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
            System.out.println("Stabilita Connessione");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

	}
	public static void closeConnection() {
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			conn = null;
		}
	}
}