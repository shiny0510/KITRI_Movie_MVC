package location;

public class Location {
	private String area;
	private String path1;

	public Location() {
		
	}

	public Location(String area, String path1) {
		this.area = area;
		this.path1 = path1;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	@Override
	public String toString() {
		return "Location [area=" + area + ", path1=" + path1 + "]";
	}
}
