package wdj_210426;

public class Student {
	private int hakbun;
	private String name;
	
	public Student(int hakbun, String name) {
		this.hakbun = hakbun;
		this.name = name;
	}
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "name: " + name + ", hakbun: "  + hakbun;
	}
}
