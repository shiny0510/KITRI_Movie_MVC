package Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class ReviewDaoImpl implements ReviewDao {
	private DBConnect db;
	private Connection conn;

	public ReviewDaoImpl() {
		db = DBConnect.getInstance();
	}
	@Override
	public void insert(Review r) {
		// TODO Auto-generated method stub
				conn = db.getConnection();
				String sql = "insert into movie_review(rno,num,id,content,score,rdate,pwd) values (movie_review_no.nextval, ?, ?, ?, ?,to_date(sysdate, 'yy/mm/dd'),?)";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, r.getNum());
					pstmt.setString(2, r.getId());
					pstmt.setString(3, r.getContent());
					pstmt.setInt(4, r.getScore());
					pstmt.setString(5, r.getPwd());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					db.disConn();
				}
	}

	@Override
	public void update(Review r) {
		// TODO Auto-generated method stub
				conn = db.getConnection();
				String sql = "update movie_review set score=?, content=? where rno=?";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, r.getScore());
					pstmt.setString(2, r.getContent());
					pstmt.setInt(3, r.getRno());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					db.disConn();
				}
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
				conn = db.getConnection();
				String sql = "delete from movie_review where rno=?";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, rno);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					db.disConn();
				}
	}

	@Override
	public Review select(int rno) {
		// TODO Auto-generated method stub
				ResultSet rs;
				conn = db.getConnection();
				String sql = "select r.rno, mo.num, m.id, r.content, r.score, r.rdate, r.pwd from movie_review r, movie_movie mo, movie_member m where r.num=mo.num and r.id=m.id and rno=?";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, rno);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						return new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), 
								rs.getString(4), rs.getInt(5), rs.getString(6),rs.getString(7));
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
	public void deleteBypwd(String pwd, int rno) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "delete from movie_review r,movie_member where rno=? and pwd=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public ArrayList<Review> selectBynum(int num) {
		// TODO Auto-generated method stub
				ResultSet rs;
				ArrayList<Review> list = new ArrayList<Review>();
				conn = db.getConnection();
				String sql = "select r.rno, mo.num, m.id, r.content, r.score, r.rdate, r.pwd from movie_review r, movie_movie mo, movie_member m where r.num=mo.num and r.id=m.id and num=?";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), 
								rs.getString(4), rs.getInt(5), rs.getString(6),rs.getString(7)));
					}	
					if (list.size() > 0) {
						return list;
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
	public ArrayList<Review> selectAll() {
		// TODO Auto-generated method stub
				ResultSet rs;
				ArrayList<Review> list = new ArrayList<Review>();
				conn = db.getConnection();
				String sql = "select * from movie_review order by num desc";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {		
						list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),rs.getString(7)));
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
	public Review getAvgScore(int num) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select avg(score) from movie_review where num = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Review(0, 0, "", "", rs.getInt(1), "","");
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
	public int makeReviewNum() {
		// TODO Auto-generated method stub
				ResultSet rs;
				int num;
				conn = db.getConnection();
				String sql = "select movie_review_no.nextval from dual";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						return rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					db.disConn();
				}
				return 0;
			}
}
