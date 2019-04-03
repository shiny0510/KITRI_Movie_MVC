package movieBoard;

import java.util.ArrayList;

public class MovieBoardServiceImpl implements MovieBoardService {

	private MovieBoardDao dao;

	public MovieBoardServiceImpl(MovieBoardDao dao) {
		this.dao = dao;
	}

	@Override
	public void writeBoard(MovieBoard b) {
		// TODO Auto-generated method stub
		dao.insert(b);
	}

	@Override
	public MovieBoard getMovieBoard(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public void editBoard(MovieBoard b) {
		// TODO Auto-generated method stub
		dao.update(b);
	}

	@Override
	public void delBoard(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public ArrayList<MovieBoard> selectByWriter(String writer) {
		// TODO Auto-generated method stub
		return dao.selectByWriter(writer);
	}

	@Override
	public ArrayList<MovieBoard> selectByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.selectByTitle(title);
	}

	@Override
	public ArrayList<MovieBoard> selectByContent(String content) {
		// TODO Auto-generated method stub
		return dao.selectByContent(content);
	}

	@Override
	public ArrayList<MovieBoard> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void writeReply(MovieBoard b) {
		// TODO Auto-generated method stub
		dao.reply(b);
	}

	@Override
	public ArrayList<MovieBoard> selectByReply(int reply) {
		// TODO Auto-generated method stub
		return dao.selectByReply(reply);
	}

	@Override
	public MovieBoard getBoard(String writer) {
		// TODO Auto-generated method stub
		return dao.select(writer);
	}

}
