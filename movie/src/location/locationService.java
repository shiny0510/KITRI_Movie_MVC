package location;

import java.util.ArrayList;

public interface locationService {
	void add(Location l);

	Location get(String location);

	ArrayList<Location> getAll();
}
