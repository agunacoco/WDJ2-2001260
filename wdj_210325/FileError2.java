package wdj_210325;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileError2 {
	public static void main(String[] args) {
		writeList();
	}
	
	private static void writeList() {
		PrintWriter out = null;
		//AutoClosable 인터페이스를 구현해야한다.
		//그 객체는 try with resources 절에 사용될 수 있다.
		try(FileWriter fw = new FileWriter("out2.txt")) {
			out = new PrintWriter(fw);
			out.println("안녕핫용");
			System.out.println("작업종료....");
		} catch(IOException e) {
			System.out.println("catch:" + e.getMessage());
		} finally {
			System.out.println("finally code...");
			if(out != null) {
				out.close();
			}
			System.out.println("finally end...");
		}
	}

}
