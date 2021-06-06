package wdj_210408;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		test1();
	}
	private static void test1() {
		List<String> list = new ArrayList<>();
		String[] sArr = { "자동차", "운동장", "유치원", "학교", "임채환"};
		
		for(String s : sArr) list.add(s);
		System.out.println(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		for(String s : list ) {
			System.out.println();
		}
		Iterator<String> iter = list.iterator();
	
		while(iter.hasNext())
			 System.out.print(iter.next() + " ");
		System.out.println();
		
		list.add(1, "벚꽃");
		
		iter = list.iterator();
		while(iter.hasNext()) {
			 System.out.print(iter.next() + " ");
		}
		System.out.println();
		
//		list.remove(list.size()-1);
//		while(list.size() > 0 ) {
//			list.remove(0);
//		}
//		
		list.remove(3);
		System.out.println(list);
	}
		

		
	
}
