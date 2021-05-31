package wdj_210531;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public static void main(String[] args) {
		URL site = new URL("http://www.naver.com");
		URLConnection con = site.openConnection();
		InputStream stream = con.getInputStream();
		InputStreamReader isreader = new InputStreamReader(stream);
	    BufferedReader reader = new BufferedReader(isreader);
	    String line;
	    while(line = reader.readLine()!=null){
	    	System.out.println(line);
	    }
	}

}
