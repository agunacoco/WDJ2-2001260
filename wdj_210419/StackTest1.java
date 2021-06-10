package wdj_210419;

import java.util.Stack;

public class StackTest1 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		
		for(int i = 0; i < 10; i++) {
			stack.push(i + 1);
			// stack에서 데이터를 넣는 메소드는 push이다
		}
		
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			Integer val = stack.pop();
			System.out.print(val + " ");
		}
	}

}
