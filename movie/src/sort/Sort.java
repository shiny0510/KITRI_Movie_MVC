package sort;

public class Sort {
	private String sort;
	private int discount;
	
	public Sort() {
		
	}
	public Sort(String sort, int discount) {
		this.sort = sort;
		this.discount = discount;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Sort [sort=" + sort + ", discount=" + discount + "]";
	}
}
