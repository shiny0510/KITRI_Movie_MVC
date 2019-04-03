package cate;

import java.util.ArrayList;

public class ServiceImpl implements Service {
	private Dao dao;
	
	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void addCate(Cate c, String table) {
		// TODO Auto-generated method stub
		dao.insertCate(c, table);
	}

	@Override
	public ArrayList<Cate> getCates(int parent, String table) {
		// TODO Auto-generated method stub
		return dao.selectAll(parent, table);
	}

	@Override
	public Cate getCate(int num, String table) {
		// TODO Auto-generated method stub
		return dao.selectCate(num, table);
	}

	@Override
	public void delCate(int num, String table) {
		// TODO Auto-generated method stub
		dao.deleteCate(num, table);
	}

}
