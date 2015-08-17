package access;

class Hello {

	String name = "publicHello class";
	
	public String pubName = "public name variable";
	
	int add(int a, int b) {
		return a+b;
	}
	
	public int gob(int a, int b){
		return a*b;
	}

	@Override
	public String toString() {
		return "Hello [name=" + name + ", pubName=" + pubName + "]";
	}
	
}
