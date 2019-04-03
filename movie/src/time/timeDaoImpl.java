package time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
import join.Join;

public class timeDaoImpl implements timeDao {
	private DBConnect db;

	public timeDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Time t) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "insert into movie_time values(movie_time_seq.nextval,?,?,?,to_date(?,'YYYYMMDD'),to_date(?,'YYYYMMDD HH24:MI'),?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getArea());
			pstmt.setInt(2, t.getScreen());
			pstmt.setString(3, t.getMovie());
			pstmt.setString(4, t.getDate());
			pstmt.setString(5, t.getTime());
			pstmt.setString(6, t.getSort());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public void update(Time t) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "update movie_time set screen=?, movie=?, day=to_date(?,'YYYYMMDD'), time=to_date(?,'YYYYMMDD HH24:MI'), sort=? where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, t.getScreen());
			pstmt.setString(2, t.getMovie());
			pstmt.setString(3, t.getDate());
			pstmt.setString(4, t.getTime());
			pstmt.setString(5, t.getSort());
			pstmt.setInt(6, t.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}
	
	@Override
	public void updateName(String editName, int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "update movie_time set area=? where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, editName);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}


	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		String sql = "delete movie_time where num=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//현재 메서드가 종료하기 전에 꼭 실행해야하는 코드 작성
			db.disConn();
		}
	}

	@Override
	public Time select(String area, int screen, String time) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		String sql = "select * from movie_time where area=? and screen=? and time=to_char(?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			pstmt.setInt(2, screen);
			pstmt.setString(3, time);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Time(rs.getInt(1), rs.getString(2),	rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
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
	public ArrayList<Time> selectAreaAll(String area, int screen) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Time> list=new ArrayList<Time>();
		String sql = "select * from movie_time where area=? and screen=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			pstmt.setInt(2, screen);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Time(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
	public ArrayList<Join> selectMoiveAll(String movie, String date) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Join> list=new ArrayList<Join>();
		String sql = "select t1.num,t1.area,t1.screen,t1.movie,t1.day,t1.time,t1.sort,t2.price,t2.rowline as rowline,t2.columnline as columnline from movie_time t1 join movie_screen t2 on t1.area=t2.parent and t1.screen=t2.num where t1.movie=? and t1.day=to_date(?,'YYYYMMDD') order by t1.time desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join j=new Join(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				list.add(j);
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
	public ArrayList<Time> selectAreaList(String area) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Time> list=new ArrayList<Time>();
		String sql = "select * from movie_time where area=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Time(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
	public ArrayList<Time> selectDateAll(String date) {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Time> list=new ArrayList<Time>();
		String sql = "select * from movie_time where day=to_date(?,'YYYYMMDD') order by time desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Time(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
	public ArrayList<Time> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection conn = db.getConnection();
		ArrayList<Time> list=new ArrayList<Time>();
		String sql = "select * from movie_time order by day desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 list.add(new Time(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
