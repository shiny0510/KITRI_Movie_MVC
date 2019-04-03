package area;

import java.util.ArrayList;

public class areaServiceImpl implements areaService {
	private areaDao dao;
	
	public areaServiceImpl(areaDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(Area a) {
		// TODO Auto-generated method stub
		dao.insert(a);
	}

	@Override
	public void editXY(Area a) {
		// TODO Auto-generated method stub
		dao.updateXY(a);
	}

	@Override
	public void editName(String editName, String name) {
		// TODO Auto-generated method stub
		dao.updateName(editName, name);
	}

	@Override
	public void del(String name) {
		// TODO Auto-generated method stub
		dao.delete(name);
	}

	@Override
	public Area get(String name) {
		// TODO Auto-generated method stub
		return dao.select(name);
	}

	@Override
	public ArrayList<Area> getAreaAll(String area) {
		// TODO Auto-generated method stub
		return dao.selectAreaAll(area);
	}

	@Override
	public ArrayList<Area> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
}
