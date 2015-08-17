package array;

import java.util.ArrayList;

import vo.Name;

public class ArrayTest {

	public static void main(String[] args) {
		ArrayList<Name> nameList = new ArrayList<Name>();
		Name n1 = new Name();
		n1.setFirstName("bae");
		n1.setLastName("won");
		nameList.add(n1);
		
		for( Name n : nameList ) {
			n.setFirstName("배");
			n.setLastName("원");
		}
		
		System.out.println(nameList.size());
		System.out.println(nameList.get(0).getFirstName());
	}
}
