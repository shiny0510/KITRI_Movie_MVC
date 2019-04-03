package screen;

import java.util.ArrayList;

public class screenServiceImpl implements screenService {
	private screenDao dao;
	
	public screenServiceImpl(screenDao dao) {
		this.dao = dao;
	}

	@Override
	public void addScreen(Screen s) {
		// TODO Auto-generated method stub
		dao.insert(s);
	}

	@Override
	public void editScreen(Screen s, String editName) {
		// TODO Auto-generated method stub
		dao.update(s, editName);
	}

	@Override
	public void delScreen(int num, String parent) {
		// TODO Auto-generated method stub
		dao.delete(num, parent);
	}

	@Override
	public Screen getScreen(int num, String parent) {
		// TODO Auto-generated method stub
		return dao.select(num, parent);
	}

	@Override
	public ArrayList<Screen> getAllScreen(String parent) {
		// TODO Auto-generated method stub
		return dao.selectAll(parent);
	}
}
