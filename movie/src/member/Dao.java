package member;

import java.util.ArrayList;

public interface Dao {
	void insert(Member m);

	Member select(String id);
	
	String selectId(String name,String tel);

	void update(Member m);

	void delete(String id);
	
	ArrayList<Member> selectAll(String area);
	
	void editPoint(Member m);
	
}
