package area;

public class Area {
	private String name;
	private String area;
	private int x;
	private int y;
	
	public Area() {
	}

	public Area(String name, String area, int x, int y) {
		this.name = name;
		this.area = area;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Area [name=" + name + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}
}
