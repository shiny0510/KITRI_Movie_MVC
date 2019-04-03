package movieBoard;

import java.sql.Date;

public class MovieBoard {
	private int num;
	private String writer;
	private String type;
	private String title;
	private String content;
	private String path;
	private Date w_date;
	private int rep_num;
	private int lv;
	private int sq;

	public MovieBoard() {
	}

	public MovieBoard(int num, String writer, String type, String title, String content, String path, Date w_date,
			int rep_num, int lv, int sq) {
		this.num = num;
		this.writer = writer;
		this.type = type;
		this.title = title;
		this.content = content;
		this.path = path;
		this.w_date = w_date;
		this.rep_num = rep_num;
		this.lv = lv;
		this.sq = sq;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public int getRep_num() {
		return rep_num;
	}

	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getSq() {
		return sq;
	}

	public void setSq(int sq) {
		this.sq = sq;
	}

	@Override
	public String toString() {
		return "MovieBoard [num=" + num + ", writer=" + writer + ", type=" + type + ", title=" + title + ", content="
				+ content + ", path=" + path + ", w_date=" + w_date + ", rep_num=" + rep_num + ", lv=" + lv + ", sq="
				+ sq + "]";
	}

}