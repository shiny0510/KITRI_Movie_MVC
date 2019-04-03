package movieBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class MovieBoardDaoImpl implements MovieBoardDao {
	private DBConnect db;
	private Connection conn;

	public MovieBoardDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(MovieBoard b) {
		// TODO Auto-generated method stub
		// num,write,type,title,content,file,date
		conn = db.getConnection();
		// num, writer, type, title, content, path, w_date, rep_num, lv, sq
		String sql = "insert into movie_board values(seq_movie_board.nextval,?,?,?,?,?,sysdate,0,0,0)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getType());
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getContent());
			pstmt.setString(5, b.getPath());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public MovieBoard select(int num) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		String sql = "select * from movie_board where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new MovieBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}
	
	@Override
	public MovieBoard select(String writer) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		String sql = "select * from movie_board where writer=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new MovieBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}


	@Override
	public void update(MovieBoard b) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update movie_board set w_date=sysdate, title=?, content=? where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());
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
		String sql = "delete movie_board where num=?";
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
	public ArrayList<MovieBoard> selectByWriter(String writer) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		ArrayList<MovieBoard> list = new ArrayList<MovieBoard>();
		String sql = "select * from movie_board where writer=? order by num desc";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			while (rs.next()) {// num,write,type,title,content,file,date
				list.add(new MovieBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return list;
	}

	@Override
	public ArrayList<MovieBoard> selectByTitle(String title) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		ArrayList<MovieBoard> list = new ArrayList<MovieBoard>();
		String sql = "select * from movie_board where title like '%title%' order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// num,write,type,title,content,file,date
				list.add(new MovieBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
		return list;
	}

	@Override
	public ArrayList<MovieBoard> selectByContent(String content) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		ArrayList<MovieBoard> list = new ArrayList<MovieBoard>();
		String sql = "select * from movie_board where title like '%content%' order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// num,write,type,title,content,file,date
				list.add(new MovieBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
		return list;
	}

	@Override
	public ArrayList<MovieBoard> selectAll() {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		ArrayList<MovieBoard> list = new ArrayList<MovieBoard>();
		;
		String sql = "select * from movie_board order by rep_num desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// num,write,type,title,content,file,date
				list.add(new MovieBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return list;
	}

	@Override
	public void reply(MovieBoard b) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		// num, writer, type, title, content, path, w_date, rep_num, lv, sq
		String sql = "insert into movie_board values(seq_movie_board.nextval,?,null,?,?,null,sysdate,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setInt(4, b.getRep_num());
			pstmt.setInt(5, b.getLv());
			pstmt.setInt(6, b.getSq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}
	
	@Override
	public ArrayList<MovieBoard> selectByReply(int reply) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		ResultSet rs;
		ArrayList<MovieBoard> list = new ArrayList<MovieBoard>();
		String sql = "select * from movie_board where rep_num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply);
			rs = pstmt.executeQuery();
			while (rs.next()) {// num,write,type,title,content,file,date
				list.add(new MovieBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
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
