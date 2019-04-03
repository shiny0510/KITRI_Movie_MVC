package Movie;

public class Movie {
	private int num;
	private String title;
	private String path1;
	private String path2;
	private String path3;
	private String path4;
	private int cate1;
	private int cate2;
	private int cate3;
	private int runtime;
	private String director;
	private String mcast;
	private String genre;
	private int counter;

	public Movie() {
		
	}

	public Movie(int num, String title, String path1, String path2, String path3, String path4, int cate1, int cate2,
			int cate3, int runtime, String director, String mcast, String genre, int counter) {
		this.num = num;
		this.title = title;
		this.path1 = path1;
		this.path2 = path2;
		this.path3 = path3;
		this.path4 = path4;
		this.cate1 = cate1;
		this.cate2 = cate2;
		this.cate3 = cate3;
		this.runtime = runtime;
		this.director = director;
		this.mcast = mcast;
		this.genre = genre;
		this.counter = counter;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}

	public String getPath3() {
		return path3;
	}

	public void setPath3(String path3) {
		this.path3 = path3;
	}

	public String getPath4() {
		return path4;
	}

	public void setPath4(String path4) {
		this.path4 = path4;
	}

	public int getCate1() {
		return cate1;
	}

	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}

	public int getCate2() {
		return cate2;
	}

	public void setCate2(int cate2) {
		this.cate2 = cate2;
	}

	public int getCate3() {
		return cate3;
	}

	public void setCate3(int cate3) {
		this.cate3 = cate3;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMcast() {
		return mcast;
	}

	public void setMcast(String mcast) {
		this.mcast = mcast;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "Movie [num=" + num + ", title=" + title + ", path1=" + path1 + ", path2=" + path2 + ", path3=" + path3
				+ ", path4=" + path4 + ", cate1=" + cate1 + ", cate2=" + cate2 + ", cate3=" + cate3 + ", runtime="
				+ runtime + ", director=" + director + ", mcast=" + mcast + ", genre=" + genre + ", counter=" + counter
				+ "]";
	}
	
	

	
	
}
