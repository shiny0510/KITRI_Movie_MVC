package member;

import java.util.ArrayList;

public class ServiceImpl implements Service {
	private Dao dao;

	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void join(Member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		Member m = getMember(id);
		if(m!=null && m.getPwd().equals(pwd)) {
			return true;
		}
		return false;
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}
	
	@Override
	public String getId(String name, String tel) {
		// TODO Auto-generated method stub
		return dao.selectId(name, tel);
	}

	@Override
	public void editInfo(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void out(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public ArrayList<Member> getList(String area) {
		// TODO Auto-generated method stub
		return dao.selectAll(area);
	}

	@Override
	public void editPoint(Member m) {
		// TODO Auto-generated method stub
		dao.editPoint(m);
	}

}
