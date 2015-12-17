package concurrent;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetTest {

	public static void main(String[] args) {
		ConcurrentSkipListSet<String> csls = new ConcurrentSkipListSet<>();
		csls.add("aab");
		csls.add("bbc");
		csls.add("ccd");
		csls.add("aab");
		System.out.println(csls.size());
		for (String s : csls) {
			System.out.println(s);
		}

	}

}
