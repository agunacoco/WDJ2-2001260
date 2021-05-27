package wdj_210426;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest1 {
	public static void main(String[]args) {
		test1();
		
	}
	public static void test1() {
		Map<String, Student> map = new HashMap<>();
		map.put("200101", new Student(200101,"홍길동"));
		map.put("200102", new Student(200102,"구나현"));
		map.put("200103", new Student(200103,"장재현"));
		map.put("200104", new Student(200104,"김소은"));
		map.put("200105", new Student(200105,"정몽주"));
		
		Student value = map.get("200103");
		System.out.println(value.getName());
		
		map.put("200103", new Student(200103, "구세현"));
		value = map.get("200103");
		System.out.println(value.getName());
		
		//map이라는 자료구조에 들어가 있는 모든 원소들을 다 읽을 수 있는 방법
		// 첫번째: map에게 가진 원소들의 모든 키 값을 요청하고 그 집합의 각 원소를 가지고 map에게 값을 요청하는 방법
		// 두번째: map에게 <key, value> 쌍으로 저장된 엔트리 집합을 요청해서 그 집합의 원소를 하나씩 읽는 방법
		
		Set<String> keyset =  map.keySet();
		//set 원소를 하나씩 접근하는 방법 
		
//		Iterator<String> iter = keyset.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			Student val = map.get(key);
//			System.out.println("key: "+ key+ "value: " + val);
//		}
		//map에서 엔트리라 함은 <key, value>의 쌍으로 구성된 하나의 객체
		//객체는 이 객체를 정의하는 클래스가 있다는 의미다. 
		Set<Entry<String, Student>> entryset = map.entrySet();
		Iterator<Entry<String, Student>> eIter = entryset.iterator();
		while(eIter.hasNext()) {
			Entry<String, Student> entryObj = eIter.next();
			String key = entryObj.getKey();
			Student val = entryObj.getValue();
			System.out.println("key: " + key + ", value: " + val);
		}
	}
}