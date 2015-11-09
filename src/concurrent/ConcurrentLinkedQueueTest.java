package concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {

		ConcurrentLinkedQueue<String> c = new ConcurrentLinkedQueue<>();
		c.add("1");
		c.add("2");
		
		for (String s : c) {
			System.out.println(s);
		}
	}

}
