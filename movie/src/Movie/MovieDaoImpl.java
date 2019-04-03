package Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class MovieDaoImpl implements MovieDao {

	private DBConnect db;
	private Connection conn;
	
	public MovieDaoImpl() {
		db = DBConnect.getInstance();
	}
	@Override
	public void insert(Movie m) {
		// TODO Auto-generated method stub
				conn = db.getConnection();
				String sql = "insert into movie_movie(num,title,path1,path2,path3,path4,cate1,cate2,cate3,runtime,director,mcast,genre) values(movie_movie_no.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, m.getTitle());
					
					
					pstmt.setString(2, m.getPath1());
					pstmt.setString(3, m.getPath2());
					pstmt.setString(4, m.getPath3());
					pstmt.setString(5, m.getPath4());
					
					pstmt.setInt(6, m.getCate1());
					pstmt.setInt(7, m.getCate2());
					pstmt.setInt(8, m.getCate3());
					
					pstmt.setInt(9, m.getRuntime());
					pstmt.setString(10, m.getDirector());
					pstmt.setString(11, m.getMcast());
					pstmt.setString(12, m.getGenre());
					
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				db.disConn();
				}
	}

	@Override
	public Movie select(int num) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select * from movie_movie where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Movie(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getInt(9),rs.getInt(10),
						rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)
						);
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
	public void update(Movie m) {
		// TODO Auto-generated method stub
				Connection conn = db.getConnection();
				String sql = "update movie_movie set title=?, path1=?,path2=?,path3=?,path4=?, cate1=?, cate2=?,cate3=?, runtime=?, director=?, mcast=?, genre=?, counter=? where num=?";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);		
					pstmt.setString(1, m.getTitle());
					
					pstmt.setString(2, m.getPath1());
					pstmt.setString(3, m.getPath2());
					pstmt.setString(4, m.getPath3());
					pstmt.setString(5, m.getPath4());
					
					pstmt.setInt(6, m.getCate1());
					pstmt.setInt(7, m.getCate2());
					pstmt.setInt(8, m.getCate3());
					
					pstmt.setInt(9, m.getRuntime());
					pstmt.setString(10, m.getDirector());
					pstmt.setString(11, m.getMcast());
					pstmt.setString(12, m.getGenre());
					pstmt.setInt(13, m.getCounter());
					pstmt.setInt(14, m.getNum());
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
		Connection conn = db.getConnection();
		String sql = "delete movie_movie where num=?";
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
	public ArrayList<Movie> selectBydirector(String director) {
		// TODO Auto-generated method stub
				ResultSet rs;
				ArrayList<Movie> list = new ArrayList<Movie>();
				conn = db.getConnection();
				String sql = "select * from movie_movie where director=? order by num desc";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, director);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						list.add(new Movie(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
								rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getInt(9),rs.getInt(10),
								rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)
							));
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
	public ArrayList<Movie> selectByTitle(String title) {
		// TODO Auto-generated method stub
				ResultSet rs;
				ArrayList<Movie> list = new ArrayList<Movie>();
				conn = db.getConnection();
				String sql = "select * from movie_movie where director like '%" + title + "%' order by num desc";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						list.add(new Movie(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
								rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getInt(9),rs.getInt(10),
								rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)));
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
	public ArrayList<Movie> selectByCate(int cate, int value) {
		// TODO Auto-generated method stub
				ResultSet rs;
				ArrayList<Movie> list = new ArrayList<Movie>();
				conn = db.getConnection();
				String clm = "cate"+cate;
				String sql = "select * from movie_movie where "+clm+
						"=? order by num desc";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, value);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						list.add(new Movie(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
								rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getInt(9),rs.getInt(10),
								rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)));
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
	public ArrayList<Movie> selectByPrice(int price1, int price2) {
		// TODO Auto-generated method stub
				ResultSet rs;
				ArrayList<Movie> list = new ArrayList<Movie>();
				conn = db.getConnection();
				String sql = "select * from movie_movie where price between ? and ? order by num desc";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, price1);
					pstmt.setInt(2, price2);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						list.add(new Movie(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
								rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getInt(9),rs.getInt(10),
								rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)));
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
	public ArrayList<Movie> selectAll() {
		// TODO Auto-generated method stub
				ResultSet rs;
				ArrayList<Movie> list = new ArrayList<Movie>();
				conn = db.getConnection();
				String sql = "select * from movie_movie order by num desc";
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						list.add(new Movie(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
								rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8), rs.getInt(9),rs.getInt(10),
								rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)));
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
	public int makeMovieNum() {
		// TODO Auto-generated method stub
				ResultSet rs;
				int num;
				conn = db.getConnection();
				String sql = "select movie_movie_no.nextval from dual";
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

