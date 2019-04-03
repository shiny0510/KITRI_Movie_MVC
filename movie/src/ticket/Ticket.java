package ticket;

public class Ticket {
	private int tno;
	private String id;
	private String title;
	private String theater;
	private String screen;
	private String mdate;
	private String mtime;
	private String seat;
	
	public Ticket() {
		
	}

	public Ticket(int tno, String id, String title, String theater, String screen, String mdate, String mtime,
			String seat) {
		this.tno = tno;
		this.id = id;
		this.title = title;
		this.theater = theater;
		this.screen = screen;
		this.mdate = mdate;
		this.mtime = mtime;
		this.seat = seat;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Ticket [tno=" + tno + ", id=" + id + ", title=" + title + ", theater=" + theater + ", screen=" + screen
				+ ", mdate=" + mdate + ", mtime=" + mtime + ", seat=" + seat + "]";
	}
	
	

}
