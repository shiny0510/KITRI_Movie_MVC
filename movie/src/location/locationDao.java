package location;

import java.util.ArrayList;

public interface locationDao {
	void add(Location l);

	Location select(String location);
	
	ArrayList<Location> selectAll();
}
