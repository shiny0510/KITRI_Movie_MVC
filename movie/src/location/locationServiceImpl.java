package location;

import java.util.ArrayList;

public class locationServiceImpl implements locationService {
	private locationDao dao;
	
	public locationServiceImpl(locationDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(Location l) {
		// TODO Auto-generated method stub
		dao.add(l);
	}

	@Override
	public Location get(String location) {
		// TODO Auto-generated method stub
		return dao.select(location);
	}

	@Override
	public ArrayList<Location> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
}
