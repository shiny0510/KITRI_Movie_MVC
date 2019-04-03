package screen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class screenDaoImpl implements screenDao {
	private DBConnect db;

	public screenDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Screen s) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "insert into movie_screen values(?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getNum());
			pstmt.setInt(2, s.getPrice());
			pstmt.setString(3, s.getRowline());
			pstmt.setInt(4, s.getColumnline());
			pstmt.setString(5, s.getParent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public void update(Screen s, String editName) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "update movie_screen set price=?, rowline=?, columnline=?,parent=? where parent=? and num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, s.getPrice());
			pstmt.setString(2, s.getRowline());
			pstmt.setInt(3, s.getColumnline());
			pstmt.setString(4, editName);
			pstmt.setString(5, s.getParent());
			pstmt.setInt(6, s.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public void delete(int num, String parent) {
		// TODO Auto-generated method stub
				Connection conn = db.getConnection();
				String sql = "delete movie_screen where num=? and parent=?";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);		
					pstmt.setInt(1, num);
					pstmt.setString(2, parent);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
					db.disConn();
				}
	}

	@Override
	public Screen select(int num, String parent) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		String sql = "select * from movie_screen where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, parent);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Screen(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5));
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
	public ArrayList<Screen> selectAll(String parent) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Screen> list=new ArrayList<Screen>();
		String sql = "select * from movie_screen where parent=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,parent);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Screen(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
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
