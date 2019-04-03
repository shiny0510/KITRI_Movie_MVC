package time;

public class Time {
	private int num;

	private String area;

	private int screen;

	private String movie;
	
	private String date;
	
	private String time;
	
	private String sort;
	
	public Time() {
		
	}
	public Time(int num, String area, int screen, String movie, String date, String time, String sort) {
		this.num = num;
		this.area = area;
		this.screen = screen;
		this.movie = movie;
		this.date = date;
		this.time = time;
		this.sort = sort;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getScreen() {
		return screen;
	}
	public void setScreen(int screen) {
		this.screen = screen;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "Time [num=" + num + ", area=" + area + ", screen=" + screen + ", movie=" + movie + ", date=" + date
				+ ", time=" + time + ", sort=" + sort + "]";
	}
}
