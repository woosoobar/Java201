package vo;

public class User {

//	public static class name {
//		private String firstName;
//		private String lastName;
//		public String getFirstName() {
//			return firstName;
//		}
//		public void setFirstName(String firstName) {
//			this.firstName = firstName;
//		}
//		public String getLastName() {
//			return lastName;
//		}
//		public void setLastName(String lastName) {
//			this.lastName = lastName;
//		}
//	}
	private Name[] names;
	private String id;
	private int age;
	private String gender;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Name[] getNames() {
		return names;
	}
	public void setNames(Name[] names) {
		this.names = names;
	}
	
}
