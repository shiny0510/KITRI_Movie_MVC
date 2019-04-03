package movieBoard;

import java.util.ArrayList;

public interface MovieBoardService {
	void writeBoard(MovieBoard b);
	
	void writeReply(MovieBoard b);
	
	MovieBoard getMovieBoard(int num);
	
	MovieBoard getBoard(String writer);

	void editBoard(MovieBoard b);

	void delBoard(int num);

	ArrayList<MovieBoard> selectByWriter(String writer);

	ArrayList<MovieBoard> selectByTitle(String title);

	ArrayList<MovieBoard> selectByContent(String content);
	
	ArrayList<MovieBoard> selectByReply(int reply);

	ArrayList<MovieBoard> selectAll();
}
