package screen;

import java.util.ArrayList;

public interface screenDao {
	void insert(Screen s);

	void update(Screen s, String editName);

	void delete(int num, String parent);

	Screen select(int num, String parent);

	ArrayList<Screen> selectAll(String parent);
}
