package ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Review.Review;
import dbconn.DBConnect;

public class ticketDaoImpl implements ticketDao {
	private DBConnect db;
	private Connection conn;

	public ticketDaoImpl() {
		db = DBConnect.getInstance();
	}
	@Override
	public void insert(Ticket t) {
		// TODO Auto-generated method stub
			conn = db.getConnection();
			String sql = "insert into movie_ticket values(movie_ticket_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, t.getId());
				pstmt.setString(2, t.getTitle());
				pstmt.setString(3, t.getTheater());
				pstmt.setString(4, t.getScreen());
				pstmt.setString(5, t.getMdate());
				pstmt.setString(6, t.getMtime());
				pstmt.setString(7, t.getSeat());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
				db.disConn();
			}
	}
	@Override
	public ArrayList<Ticket> selectAll() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		conn = db.getConnection();
		String sql = "select * from movie_ticket order by tno desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {		
				list.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return list;
	}
}
