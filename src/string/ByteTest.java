package string;

public class ByteTest {

	public static void main(String[] args) {

		String a = "a";
		String b = "가";
		String aa = "abc";
		String bb = "가나다";
		String msg = "[<Command>(LOGINROUTE)][<RetVal>(Success:super)]";

		System.out.println(a.getBytes().length);
		System.out.println(b.getBytes().length);
		System.out.println(aa.getBytes().length);
		System.out.println(bb.getBytes().length);
		System.out.println(msg.getBytes().length);
//		
//		byte[] bs = a.getBytes();
//		for(byte i : bs) {
//			System.out.println(i);
//		}
//		System.out.println(new String(bs));
	}

}
