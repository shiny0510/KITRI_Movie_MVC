package movieReply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class MovieReplyDaoImpl implements MovieReplyDao {
	private DBConnect db;
	private Connection conn;

	public MovieReplyDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(MovieReply r) {
		// TODO Auto-generated method stub
		db = DBConnect.getInstance();
		conn = db.getConnection();
		String sql = "insert into movie_reply values(seq_movie_reply.nextval,seq_movie_board.nextval,?,sysdate,?,?)";
		PreparedStatement pstmt;
		try {// int num, int board_num, int parent, Date date, String writer, String content
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getParent());
			pstmt.setString(2, r.getWriter());
			pstmt.setString(3, r.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void update(MovieReply r) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update movie_reply set w_date=sysdate, content=? where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getContent());
			pstmt.setInt(2, r.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.disConn();
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "delete movie_reply where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.disConn();
	}

	@Override
	public ArrayList<MovieReply> selectByParent(int parent) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		ArrayList<MovieReply> list = new ArrayList<MovieReply>();
		String sql = "select * from movie_reply where parent=? order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parent);
			rs = pstmt.executeQuery();
			while (rs.next()) {// int num, int board_num, int parent, Date date, String writer, String content
				list.add(new MovieReply(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5),
						rs.getString(6)));
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
