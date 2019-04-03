package cate;

import java.util.ArrayList;

public interface Dao {
	void insertCate(Cate c, String table);
	Cate selectCate(int num, String table);
	ArrayList<Cate> selectAll(int parent, String table);
	void deleteCate(int num, String table);
}
