package wdj_210415;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		test1();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("작업1", 5));
		queue.offer(new Task("작업2", 3));
		queue.offer(new Task("작업3", 2));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		for(int i = 0; i < 5; i++) {
			System.out.println(queue.poll());
		}
	}
	private static void test1() {
		/*
		 * 우선순위큐 객체를 생성하고
		 * task 인스턴스를 삽입.
		 */
		//우선순위큐: 기본은 오름차순으로 인출 
		Queue<Task> queue = new PriorityQueue<>();
		
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		
		while(queue.isEmpty() == false) {
			Task task = queue.poll();
			
			System.out.println(task);
		}
	}
}
	//task인스턴스를 비교가능한 객체로 생성하기 위해 Comparable 인터페이스를 구현.
	class Task implements Comparable<Task>{
		String desc;
		int priority = 5;
		
		@Override  //
 		public String toString() {
			return "[desc:" +desc+ ", priority:" + priority  +"]"; 
		}
		
		public Task(String desc, int priority) {
			this.desc=desc;
			this.priority=priority;
		}
		@Override
		public int compareTo(Task o) {
			//이 객체의 값이 크면 양수, 같으면 0, 작으면 음수를 반환.
			//return (-1) * (this.priority - o.priority);
			return this.priority - o.priority;
		}
	}
	
	class MyQueue {
		Task[] tasks = new Task[10];
		int idx = 0;
		int pidx = 0;
		public void offer(Task value) {
			tasks[idx++] = value; 
			for(int i = idx -1; i >= 0; i--) {
				int max = i;
				for(int j = 0; j < i; j++) {
					if(tasks[j].compareTo(tasks[max]) > 0) {
						max = j;
					}
				}
				Task tmp = tasks[max];
				tasks[max] = tasks[i];
				tasks[i] = tmp;
			}
		}
		public Task poll() {
			return tasks[pidx++];
		}
	}
	
