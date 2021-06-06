package wdj_210408;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class setTest {
	public static void main(String[] args) {
		test1();
	}
	private static void test1() {
		File file = new File("workbook.txt");
		Set<String> set = new HashSet<>();
//		if(file.exists() == true) {
//			System.out.println(file.getAbsolutePath() + ": 존재함");
//		}else {
//			System.out.println(file.getAbsolutePath() + ": 존재하지 않음.");
//		}
//		파일 내용을 읽자.
		/*
		 *읽을 때는 Input Stream
		 *쓸 때는 Output Stream
		 *Stream은 기본적으로 Byte Stream.
		 *그런데 문자 단위로 읽고 쓸 때는 문자스크립을 이용하는 것이 편리.
		 *문자 단위의 ㅇ입력 스트림은 Reader 객체로 표현된다.
		 *문자단위의 출력 스트림은 Writer 객체로 표현된다. 
		 */
		//fileReader는 한문자씩 읽을 때 사용.
		int cnt = 0;
		BufferedReader bReader = null;
		try {
			FileReader fileReader = new FileReader(file);
			//라인 단위로 읽기위햐서 BufferedReader를 이용.
			bReader = new BufferedReader(fileReader);
			String line = null;
			while((line=bReader.readLine()) != null) {
				System.out.println(line);
				set.add(line);
				cnt++;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				bReader.close();
			} catch(Exception e) {
				
			};
		}
		System.out.println("단어 수(중복포함):" + cnt);
		System.out.println("단어 수(중복미포함):" + set.size());
		
	}

}
