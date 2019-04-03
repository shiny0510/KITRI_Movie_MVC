package area;

import java.util.ArrayList;

import location.Location;

public interface areaService {
	
	void add(Area a);

	void editXY(Area a);
	
	void editName(String editName, String name);

	void del(String name);

	Area get(String name);

	ArrayList<Area> getAreaAll(String area);
	
	ArrayList<Area> getAll();
}
