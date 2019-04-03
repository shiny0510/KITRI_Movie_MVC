package Movie;

import java.util.ArrayList;

public class MovieServiceImpl implements MovieService {
	private MovieDao dao;
	
	public MovieServiceImpl(MovieDao dao) {
		this.dao = dao;
	}

	@Override
	public void addMovie(Movie m) {
		// TODO Auto-generated method stub
		dao.insert(m);

	}

	@Override
	public ArrayList<Movie> getBydirector(String director) {
		// TODO Auto-generated method stub
		return dao.selectBydirector(director);
	}

	@Override
	public void editMovie(Movie m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMovie(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public ArrayList<Movie> getByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.selectByTitle(title);
	}

	@Override
	public ArrayList<Movie> getByCate(int cate, int value) {
		// TODO Auto-generated method stub
		return dao.selectByCate(cate, value);
	}

	@Override
	public ArrayList<Movie> getByPrice(int price1, int price2) {
		// TODO Auto-generated method stub
		return dao.selectByPrice(price1, price2);
	}

	@Override
	public Movie getMovie(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public ArrayList<Movie> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public int makeMovieNum() {
		// TODO Auto-generated method stub
		return dao.makeMovieNum();
	}


}
