package Movie;

import java.util.ArrayList;

public interface MovieDao {
	void insert(Movie m);
	
	Movie select(int num);
	
	void update(Movie m);
	
	void delete(int num);
	
	ArrayList<Movie> selectBydirector(String director);

	ArrayList<Movie> selectByTitle(String title);

	ArrayList<Movie> selectByCate(int cate, int value);

	ArrayList<Movie> selectByPrice(int price1, int price2);

	ArrayList<Movie> selectAll();
	
	int makeMovieNum();
}
