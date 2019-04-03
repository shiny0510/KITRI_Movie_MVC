package member;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private int age;
	private String tel;
	private String address;
	private int type;
	private int point;
	private String area;
	
	public Member() {
		
	}
	public Member(String id, String pwd, String name, int age, String tel, String address, int type, int point,
			String area) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.address = address;
		this.type = type;
		this.point = point;
		this.area = area;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", tel=" + tel + ", address="
				+ address + ", type=" + type + ", point=" + point + ", area=" + area + "]";
	}
	
	
}
