package movieReply;

import java.util.ArrayList;

public class MovieReplyServiceImpl implements MovieReplyService {

	private MovieReplyDao dao;

	public MovieReplyServiceImpl(MovieReplyDao dao) {
		this.dao = dao;
	}

	@Override
	public void writeReply(MovieReply r) {
		// TODO Auto-generated method stub
		dao.insert(r);
	}

	@Override
	public void editBoard(MovieReply r) {
		// TODO Auto-generated method stub
		dao.update(r);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public ArrayList<MovieReply> getByParent(int parent) {
		// TODO Auto-generated method stub
		return dao.selectByParent(parent);
	}

}
