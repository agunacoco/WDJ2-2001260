package wdj_210401;

public class Student {
	
	private String name;
	private String address;
	private int sid;
	
	public Student(String name, int sid) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "[name : " + name + ", address : " + address + ", sid : " + sid + "]"; 
	}

}
