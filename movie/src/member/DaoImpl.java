package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
import location.Location;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "insert into movie_member values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getTel());
			pstmt.setString(6, m.getAddress());
			pstmt.setInt(7, m.getType());
			pstmt.setInt(8, m.getPoint());
			pstmt.setString(9, m.getArea());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		String sql = "select * from movie_member where id=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString(1), rs.getString(2),	rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
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
	public String selectId(String name, String tel) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		String sql = "select * from movie_member where name=? and tel=?";
		String id="";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 id=rs.getString(1);
				 return id;
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
		return null;
	}

	//area, type, 아이디 수정 불가
	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "update movie_member set pwd=?, tel=?, address=?, point=?, area=? where id=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getAddress());
			pstmt.setInt(4, m.getPoint());
			pstmt.setString(5, m.getArea());
			pstmt.setString(6, m.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "delete movie_member where id=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public ArrayList<Member> selectAll(String area) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Member> list=new ArrayList<Member>();
		String sql = "select * from movie_member where area=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Member(rs.getString(1), rs.getString(2),	rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9)));
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
	public void editPoint(Member m) {
		// TODO Auto-generated method stub
				Connection conn = db.getConnection();
				String sql = "update movie_member set point=point-? where id = ?";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);		
					pstmt.setInt(1, m.getPoint());
					pstmt.setString(2, m.getId());
				System.out.println("1");
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
					db.disConn();
				}
	}

}
