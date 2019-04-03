package area;

import java.util.ArrayList;

import location.Location;

public interface areaDao {
	void insert(Area a);

	void updateXY(Area a);
	
	void updateName(String editName, String name);

	void delete(String name);

	Area select(String name);

	ArrayList<Area> selectAreaAll(String area);
	
	ArrayList<Area> selectAll();
	
}
