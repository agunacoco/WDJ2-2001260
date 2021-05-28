package wdj_210318;

public class SubString {
	public static void main(String[] args) {
		String s = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
		
//		for(int i = 0; i < s.length(); i++)
//		{
//			System.out.print(s.charAt(i));
//		}
		
		// 해당 문자열이 시작하는 위치의 index를 반환한다
		int idx = s.indexOf("백두산");
//		System.out.println(idx);
		
		// substring에 시작 인덱스만 주면 그 인덱스부터 시작해서 끝까지의 문자열을 반환하고
		// 시작과 끝의 인덱스를 주면 끝의 인덱스 - 1까지의 문자열을 반환한다
		String subs = s.substring(idx, idx + "백두산".length());
		System.out.println(subs);
		
		subs = s.substring(idx, s.indexOf("마르고"));
		System.out.println("[" + subs + "]");
	}

}
