package member;

import java.util.ArrayList;

public interface Service {
	void join(Member m);

	boolean login(String id, String pwd);

	Member getMember(String id);
	
	String getId(String name, String tel);

	void editInfo(Member m);

	void out(String id);
	
	ArrayList<Member> getList(String area);
	
	void editPoint(Member m);
}
