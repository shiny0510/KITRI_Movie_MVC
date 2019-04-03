package cate;

import java.util.ArrayList;

public interface Service {
	void addCate(Cate c, String table);
	ArrayList<Cate> getCates(int parent, String table);
	Cate getCate(int num, String table);
	void delCate(int num, String table);
}
