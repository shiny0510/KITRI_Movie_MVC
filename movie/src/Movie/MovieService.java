package Movie;

import java.util.ArrayList;

public interface MovieService {
	void addMovie(Movie m);

	ArrayList<Movie> getBydirector(String director);

	void editMovie(Movie m);

	void delMovie(int num);

	ArrayList<Movie> getByTitle(String title);

	ArrayList<Movie> getByCate(int cate, int value);

	ArrayList<Movie> getByPrice(int price1, int price2);

	Movie getMovie(int num);

	ArrayList<Movie> getAll();
	
	int makeMovieNum();
}
