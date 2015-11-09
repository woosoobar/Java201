package collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> s = new LinkedHashSet<String>();
		s.add("abc");
		s.add("def");
		s.add("abc");
		
		System.out.println(s.size());
		
		
	}
}
