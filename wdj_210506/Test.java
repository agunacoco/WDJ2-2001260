package wdj_210506;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

public class Test {
	public static void main(String[] args) {
		// 파일에 키와 값을 읽어와서 검색해준다.
		Properties props = new Properties();
		try(FileReader read = new FileReader("dict.props")) {
			props.load(read);	
		} catch(Exception err) {
			System.out.println(err.getMessage());
		}
		
		System.out.println(props.get("사과"));

		FileOutputStream out = null;
		props.put("장미", "rose");
		try { 
			out = new FileOutputStream("dict.props");
			props.store(out, "나의 한영사전");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
			} catch(Exception ignore) {}
		}
		
		System.out.println(props.get("장미"));
	}
}