package screen;

public class Screen {
	private int num;
	private int price;
	private String rowline;
	private int columnline;
	private String parent;
	
	public Screen() {
	}

	public Screen(int num, int price, String rowline, int columnline, String parent) {
		this.num = num;
		this.price = price;
		this.rowline = rowline;
		this.columnline = columnline;
		this.parent = parent;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRowline() {
		return rowline;
	}

	public void setRowline(String rowline) {
		this.rowline = rowline;
	}

	public int getColumnline() {
		return columnline;
	}

	public void setColumnline(int columnline) {
		this.columnline = columnline;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Screen [num=" + num + ", price=" + price + ", rowline=" + rowline + ", columnline=" + columnline
				+ ", parent=" + parent + "]";
	}
}