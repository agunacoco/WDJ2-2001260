package wdj_210531;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLPostTest {
	String site = "http://localhost:8080/test";
	URL url = new URL(site);
	HttpURLConnection con = (HttpURLConnection)url.openConnection();
	
	con.setDoOutput(true);
	con.setRequestMethod("POST");
	con.setRequestProperty("content-type", "applocation/x-www-form-urlencoded");
	
	//id=scpark & pw = 1111
	OutputStream stream = con.getOutputStream();
	OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
	PrintWriter writer = new PrintWriter(owriter);
	writer.println("id=kmhan&pw=1111");

}
