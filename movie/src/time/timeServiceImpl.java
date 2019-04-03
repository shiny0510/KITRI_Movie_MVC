package time;

import java.util.ArrayList;

import join.Join;

public class timeServiceImpl implements timeService {
	private timeDaoImpl dao;
	
	public timeServiceImpl(timeDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public void add(Time t) {
		// TODO Auto-generated method stub
		dao.insert(t);
	}

	@Override
	public void edit(Time t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void del(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public Time getInfo(String area, int screen, String time) {
		// TODO Auto-generated method stub
		return dao.select(area, screen, time);
	}

	@Override
	public ArrayList<Time> getAreaAllInfo(String area, int screen) {
		// TODO Auto-generated method stub
		return dao.selectAreaAll(area, screen);
	}
	@Override
	public ArrayList<Time> getDateAllInfo(String date) {
		// TODO Auto-generated method stub
		return dao.selectDateAll(date);
	}
	
	@Override
	public ArrayList<Time> getAreaList(String area) {
		// TODO Auto-generated method stub
		return dao.selectAreaList(area);
	}
	
	
	@Override
	public ArrayList<Time> getAllInfo() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editName(String editName, int num) {
		// TODO Auto-generated method stub
		dao.updateName(editName, num);
	}

	@Override
	public ArrayList<Join> getMovieList(String movie, String date) {
		// TODO Auto-generated method stub
		return dao.selectMoiveAll(movie,date);
	}
}
