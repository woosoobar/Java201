package jackson;

import vo.Name;
import vo.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper omapper = new ObjectMapper();
		
		User u = new User();
		Name n1 = new Name();
		n1.setFirstName("배");
		n1.setLastName("원");
		Name n2 = new Name();
		n2.setFirstName("김");
		n2.setLastName("원");
		Name[] ns = {n1, n2};
		u.setNames(ns);
//		u.getName().setFirstName("배");
//		u.getName().setLastName("원");
		u.setId("wb0112");
		u.setAge(37);
		
		String jsonStr = omapper.writeValueAsString(u);
		System.out.println(jsonStr);
	}

}
