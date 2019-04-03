package movieReply;

import java.util.ArrayList;

public interface MovieReplyService {
	void writeReply(MovieReply r);

	void editBoard(MovieReply r);

	void deleteBoard(int num);

	ArrayList<MovieReply> getByParent(int parent);
}
