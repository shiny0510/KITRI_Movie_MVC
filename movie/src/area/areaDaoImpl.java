package area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class areaDaoImpl implements areaDao {
private DBConnect db;
	
	public areaDaoImpl() {
		db=DBConnect.getInstance();
	}
	
	@Override
	public void insert(Area a) {
		// TODO Auto-generated method stub
				Connection conn = db.getConnection();
				String sql = "insert into movie_area values(?,?,?,?)";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, a.getName());
					pstmt.setString(2, a.getArea());
					pstmt.setInt(3, a.getX());
					pstmt.setInt(4, a.getY());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
					db.disConn();
				}
	}

	@Override
	public void updateXY(Area a) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "update movie_area set x=?, y=? where name=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, a.getX());
			pstmt.setInt(2, a.getY());
			pstmt.setString(3, a.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}
	
	public void updateName(String editName, String name) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "update movie_area set name=? where name=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, editName);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "delete movie_area where name=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public Area select(String name) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		String sql = "select * from movie_area where name=?";
		Area a=null;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 a=new Area(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				 return a;
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
	public ArrayList<Area> selectAreaAll(String area) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Area> list=new ArrayList<Area>();
		String sql = "select * from movie_area where area=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Area(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
		return list;
	}
	@Override
	public ArrayList<Area> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Area> list=new ArrayList<Area>();
		String sql = "select * from movie_area";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Area(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
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
