package lang;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


public class UnpooledTest {

	public static void main(String[] args) {
		ByteBuf buffer = Unpooled.unreleasableBuffer(Unpooled.buffer(1, Integer.MAX_VALUE));
		System.out.println(buffer.capacity());
	}
}
