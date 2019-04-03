package Review;

public class Review {
	private int rno;
	private int num;
	private String id;
	private String content;
	private int score;
	private String rdate;
	private String pwd;
	
	public Review() {
		
	}
	
	public Review(int rno, int num, String id, String content, int score, String rdate, String pwd) {
		this.rno = rno;
		this.num = num;
		this.id = id;
		this.content = content;
		this.score = score;
		this.rdate = rdate;
		this.pwd = pwd;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Review [rno=" + rno + ", num=" + num + ", id=" + id + ", content=" + content + ", score=" + score
				+ ", rdate=" + rdate + ", pwd=" + pwd + "]";
	}
	
	
	
}

