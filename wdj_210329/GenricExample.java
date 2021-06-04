package wdj_210329;

import java.util.ArrayList;

public class GenricExample {
	public static void main(String[] args) {
		// array는 기본적으로 배열의 크기가 정해져 있기 때문에 유동적으로 배열을 사용해야 할때는 불편함.
//		String[] arr1 = {"동해", "바다", "고래" };
//		arr1[3] = "거북이";
		
		// ArrayList를 사용하면 크기에 상관 없이 사용할 수 있다
		ArrayList<String> strList = new ArrayList<>();
		
		for(int i = 0; i < 200; i++)
		{
			// ArrayList의 각 원소들을 add 메소드를 사용해여 각 인덱스의 원소들을 추가할 수 있다
			strList.add(String.valueOf(i));
		}
		
		for(int i = 0; i < strList.size(); i++) 
		{
			System.out.println(strList.get(i));
		}
		
		ArrayList<Student> stdList = new ArrayList<>();
		for(int i = 0; i < 100; i++)
		{
			stdList.add(new Student());
		}
	}

}
