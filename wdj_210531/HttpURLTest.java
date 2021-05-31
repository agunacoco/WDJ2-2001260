package wdj_210531;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpURLTest {
	public static void main(String[] args) {
		URL url = new URL("http://www.google.com/search?q=java");
		URLConnection con = (HttpUrlConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozillz/5.0");
		int responCode = con.getResponseCode();
		System.out.println("Response code: "+ responseCode);
		InputStream stream = con.getInputStream();
		InputStreamReader isreader = new InputStreamReader(stream, "UTF-8");
		BufferedReader reader = new BufferedReader(isreader);
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println()
		}
	}

}
