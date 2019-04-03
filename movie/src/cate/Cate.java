package cate;

public class Cate {
	private int num;
	private String name;
	private int parent;

	public Cate() {
	}

	public Cate(int num, String name, int parent) {
		this.num = num;
		this.name = name;
		this.parent = parent;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Cate [num=" + num + ", name=" + name + ", parent=" + parent + "]";
	}

}
