package wdj_210419;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackTest {
	public static void main(String[] args) {
//		test1();
//		test2();
		checkExpression();
	}
	private static void checkExpression() {
		System.out.println("수식을 입력하세여..");
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();
		
		Stack<String> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(exp);
		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
			String nextVal = st.nextToken();
			//( 이면 stack에 push
			/*
			 * )이면 stack에서
			 * stack이 empty인지 확인.
			 * empty이면 잘못된 식인거지...
			 * 잘못된 식임을 출력하고...return;
			 */
			if(nextVal.equals("(")) {
				stack.push(nextVal);
			}else if(nextVal.equals(")")) {
				if(stack.empty()) {
					System.out.println("잘못된 식입니다.");
					return;
				}
				stack.pop();
			}
		}
		//	stack이 empty이면 유효한 식임을 출력
		//  그렇지 않으면 잘못된 식임을 출력.
		if (stack.empty()) {
			System.out.println("유효한 식입니다.");
		}else {
			System.out.println("잘못된 식입니다.");
		}
	}
	private static void test2() {
		String str = "Appel, Grape, Banana, Melon, Strawberry";
		StringTokenizer st = new StringTokenizer(str, ", ");
		while(st.hasMoreTokens()) {
			System.out.println("[" + st.nextToken() + "]");
		}
		
	}
	private static void test1() {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < 10; i++) {
			//auto boxing
			//stack.push(Character c); //char의 wrapper class
			//stack.push(char c);
			stack.push((char)('A'+i));	
		}
		System.out.println(stack);
		System.out.println("다음에 인출될 원소: " + stack.peek());
		System.out.println("다음에 인출될 원소: " + stack.peek());
		System.out.println("다음에 인출될 원소: " + stack.peek());
		while(stack.size() > 0) {
			Character nextVal = stack.pop();
			System.out.println(nextVal);
		}
		//stack 이 empty이면 유효한 식임을 출력.
		//그렇지 않으면 잘못된 식임을 출력.
		System.out.println(stack);
	}

}