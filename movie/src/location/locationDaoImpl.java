package location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class locationDaoImpl implements locationDao {
private DBConnect db;
	
	public locationDaoImpl() {
		db=DBConnect.getInstance();
	}
	
	@Override
	public void add(Location l) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "insert into location values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getArea());
			pstmt.setString(2, l.getPath1());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public Location select(String location) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		String sql = "select * from location where area=?";
		Location l=null;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 l=new Location(rs.getString(1),rs.getString(2));
				 return l;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
		return null;
	}

	@Override
	public ArrayList<Location> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Location> list=new ArrayList<Location>();
		String sql = "select * from location";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Location(rs.getString(1),rs.getString(2)));
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
