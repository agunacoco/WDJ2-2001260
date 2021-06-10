
package wdj_210419;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] agrs) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i < 10; i++) {
			deque.add(i + 1);
		}
		
//		System.out.println(deque);
		
		while(deque.size() > 0) {
			Integer val = deque.poll(); 
			// 차례대로 하나씩 원소를 빼서 큐의 사이즈가 1씩 감소한다
			System.out.print(val + " ");
		}
		
		// poll을 하면 큐에 저장되어 있던 자료를 빼서 하나씩 삭제하는 것이라 모두 poll하면 삭제된다
		System.out.println("\n큐의 상태...");
		System.out.println(deque);
	}	
}