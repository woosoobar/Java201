package exception;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test01 t1 = new Test01();
		String rst = t1.connect(null, 0);
		System.out.println("rst : " + rst);
	}

	String connect(String msg, int count){

		String result = null;
		try {
			int len = msg.length();
			return "success";
		} catch (Exception e) {
			System.out.println(count + " 번 실패");
			if (count >= 3) {
				return "fail";
			}
			return connect(msg, ++count);
			
		}		
		
//		if (count == 2) {
//			msg = "success";
//		}
//		
//		if (msg == "success") {
//			return msg;
//		} else {
//			System.out.println(count + " 번 실패");
//			return connect(msg, ++count);
//		}
		
	}

}
