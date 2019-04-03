package movieReply;

import java.sql.Date;

public class MovieReply {
	private int num;
	private int board_num; //ref 원본글 번호
	private int parent; // step 답변글의 출력순서
	private Date w_date;
	private String writer;
	private String content;

	public MovieReply() {
	}

	public MovieReply(int num, int board_num, int parent, Date w_date, String writer, String content) {
		this.num = num;
		this.board_num = board_num;
		this.parent = parent;
		this.w_date = w_date;
		this.writer = writer;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MovieBoardReply [num=" + num + ", board_num=" + board_num + ", parent=" + parent + ", w_date=" + w_date
				+ ", writer=" + writer + ", content=" + content + "]";
	}

}
