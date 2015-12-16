package collections;

import java.util.LinkedList;
import java.util.List;
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
		System.out.println(q.remove());
		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.size());
		
		
		LinkedList<String> list = new LinkedList<>();
		
		list.add("ee");
		list.add("bb");
		list.add("cc");
		list.clear();
		System.out.println(list.size());
	}
}
