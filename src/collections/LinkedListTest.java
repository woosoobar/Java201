package collections;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LinkedListTest {

	public static void main(String[] args) {
		
		Queue<String> q = new ConcurrentLinkedQueue<String>();
		q.add("a");
		q.add("b");
		q.add("c");
		
//		for (String s : q) {
//			System.out.println(s);
//		}
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
}
