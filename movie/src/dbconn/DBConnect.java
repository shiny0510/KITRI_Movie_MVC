package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	//싱글톤
	private DBConnect() {
		// TODO Auto-generated constructor stub		
	}

	public static DBConnect getInstance() {
		return db;
	}

	public Connection getConnection() {
		try {
			//드라이버로드
			Class.forName(jdbc_driver);
			//디비연결(커넥션수립)
			conn = DriverManager.getConnection(jdbc_url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//db연결 끊음
	public void disConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
