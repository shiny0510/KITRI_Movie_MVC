package time;

import java.util.ArrayList;

import join.Join;

public interface timeService {
	void add(Time t);

	void edit(Time t);
	
	void editName(String editName, int num);

	void del(int num);

	Time getInfo(String area, int screen, String time);

	ArrayList<Time> getAreaAllInfo(String area, int screen);
	
	ArrayList<Time> getDateAllInfo(String date);
	
	ArrayList<Time> getAreaList(String area);
	
	ArrayList<Join> getMovieList(String movie, String date);
	
	ArrayList<Time> getAllInfo();
}
