package wdj_210329;

public class BoxTest {
	public static void main(String[] args) {
		Box box = new Box();
		box.setContent("동해물과백두산이");
		
		String cont = box.getContent();
		System.out.println(cont);
		
		Box2 box2 = new Box2();
		box2.setContent(100);
		Integer cont2 = box2.getContent();
		System.out.println(cont2);
		
		Box3 box3 = new Box3();
		Student std = new Student();
		std.setName("홍길동");
		std.setName("컴정");
		std.setGrade(100);
		
		box3.setContent(std);
		std = box3.getContent();
		System.out.println(std.getName() + ":" + std.getDept());
		
		Box4 box4 = new Box4();
		box4.setContent(new Student());
		box4.setContent(100);
		box4.setContent("마르고 닳도록");
	}

}
