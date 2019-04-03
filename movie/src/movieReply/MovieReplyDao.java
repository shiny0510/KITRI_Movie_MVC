package movieReply;

import java.util.ArrayList;

public interface MovieReplyDao {
	void insert(MovieReply r);
	
	void update(MovieReply r);

	void delete(int num);

	ArrayList<MovieReply> selectByParent(int parent);
}
