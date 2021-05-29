package wdj_210412;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQTest {

	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		Queue<String> sq = new PriorityQueue<>();
		// 우선순위 큐는 오름차순으로 정렬되어있다
		// Queue에서 원소 추가 offer/add
		sq.offer("PineApple");
		sq.offer("Banana");
		sq.offer("Carrot");
		sq.offer("Cherry");
		sq.offer("Strawberry");
		
		// Queue에서 다음 원소가 무엇인지 보기만 하는 것(출력 x)
		// peek/element
		System.out.println(sq.peek());
		
		// Queue에 저장되어 있는 원소들을 하나씩 출력
		// poll/remove
		while(sq.size() > 0) {
			System.out.println(sq.remove());
		}
	}

}