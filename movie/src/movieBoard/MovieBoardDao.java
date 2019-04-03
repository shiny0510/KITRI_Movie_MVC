package movieBoard;

import java.util.ArrayList;

public interface MovieBoardDao {
	void insert(MovieBoard b);
	
	MovieBoard select(int num);
	
	MovieBoard select(String writer);

	void update(MovieBoard b);

	void delete(int num);

	ArrayList<MovieBoard> selectByWriter(String writer);

	ArrayList<MovieBoard> selectByTitle(String title);

	ArrayList<MovieBoard> selectByContent(String content);

	ArrayList<MovieBoard> selectAll();
	
	ArrayList<MovieBoard> selectByReply(int reply);

	void reply(MovieBoard b);
}

