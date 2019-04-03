package screen;

import java.util.ArrayList;

public interface screenService {
	void addScreen(Screen s);

	void editScreen(Screen s, String editName);

	void delScreen(int num, String parent);

	Screen getScreen(int num, String parent);

	ArrayList<Screen> getAllScreen(String parent);
}
