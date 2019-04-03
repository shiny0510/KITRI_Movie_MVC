package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	//�̱���
	private DBConnect() {
		// TODO Auto-generated constructor stub		
	}

	public static DBConnect getInstance() {
		return db;
	}

	public Connection getConnection() {
		try {
			//����̹��ε�
			Class.forName(jdbc_driver);
			//��񿬰�(Ŀ�ؼǼ���)
			conn = DriverManager.getConnection(jdbc_url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//db���� ����
	public void disConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
