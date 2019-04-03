package sort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
import time.Time;

public class sortDaoImpl implements sortDao {
	private DBConnect db;

	public sortDaoImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public ArrayList<Sort> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Sort> list=new ArrayList<Sort>();
		String sql = "select * from movie_sort";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Sort(rs.getString(1), rs.getInt(2)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
		return list;
	}

}
