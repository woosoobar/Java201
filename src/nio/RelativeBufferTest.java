package nio;

import java.nio.ByteBuffer;

public class RelativeBufferTest {

	public static void main(String[] args) {

		ByteBuffer buf = ByteBuffer.allocate(10);
		System.out.println("init posi : " + buf.position());
		System.out.println("init limit : " + buf.limit());
		System.out.println("init capa : " + buf.capacity());
		
		buf.mark();
		buf.put((byte) 10).put((byte) 11).put((byte) 12);
		
		System.out.println("init posi : " + buf.position());
		buf.reset();
		
//		byte[] arr = "a".getBytes();
//		arr[0] = (byte) 10;
//		System.out.println(arr.length);
//		System.out.println(arr[0]);
		
		System.out.println("Value : " + buf.get(2) + " , posi : " + buf.position());
		System.out.println("Value : " + buf.get() + " , posi : " + buf.position());
		System.out.println("Value : " + buf.get() + " , posi : " + buf.position());
		
		System.out.println("Value : " + buf.get() + " , posi : " + buf.position());
		System.out.println("Value : " + buf.get() + " , posi : " + buf.position());
		
	}

}
