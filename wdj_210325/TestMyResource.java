package wdj_210325;

import java.awt.datatransfer.SystemFlavorMap;

public class TestMyResource {
	public static void main(String[] args) {
//		test1();
		test2();

	}
	public static void test1() {
		MyResource r = new MyResource();
		try{
			System.out.println(r.getValue());
			System.out.println("정상처리...");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			r.close();
		}
		
	}
	public static void test2() {
		try( MyResource r = new MyResource()){
			System.out.println(r.getValue());
			System.out.println("정상처리...");
		}catch(OutOfResourcesException e) {
			System.out.println(e.getMessage());
		}
	}
	public void close() {
		System.out.println("close...지원반납");
	}
}
