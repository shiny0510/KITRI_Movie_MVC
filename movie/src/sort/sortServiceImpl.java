package sort;

import java.util.ArrayList;

public class sortServiceImpl implements sortService {
	private sortDaoImpl dao;
	
	public sortServiceImpl(sortDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public ArrayList<Sort> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
}
