package wdj_210531;

import java.net.InetAddress;
import java.rmi.UnknownHostException;

public class Host2InetAddr {
	public static void main(String[] args) {
		String hostName = "www.naver.com";
		try {
			InetAddress address = InetAddress.getByName(hostName);
			System.out.println("IP 주소: " + address.getHostAddress());
		}catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
	}

}
