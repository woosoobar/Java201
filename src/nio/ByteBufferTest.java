package nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		byte[] b = new byte[5];
		
		
		for (int i=0; i<b.length; i++) {
			b[i] = (byte) i;
		}
		buffer.put(b, 0, 1);
//		System.out.println(buffer.position());
//		System.out.println(buffer.limit());
		int off = buffer.position();
		System.out.println(off);
		
		
	}
}
