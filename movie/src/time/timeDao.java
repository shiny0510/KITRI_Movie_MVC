package time;

import java.util.ArrayList;

import join.Join;

public interface timeDao {
	void insert(Time t);

	void update(Time t);
	
	void updateName(String editName, int num);

	void delete(int num);

	Time select(String area, int screen, String time);

	ArrayList<Time> selectAreaAll(String area, int screen);
	
	ArrayList<Time> selectDateAll(String date);
	
	ArrayList<Time> selectAreaList(String area);

	ArrayList<Join> selectMoiveAll(String movie, String date);
	
	ArrayList<Time> selectAll();
}
