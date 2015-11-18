package lang;

import java.util.concurrent.TimeUnit;

public class SystemTest {

	public static void main(String[] args) {
		long stime = System.nanoTime();

		System.out.println("start : " + System.nanoTime());
		System.out.println("start2 : " + System.currentTimeMillis());

		while( System.nanoTime()-stime < 1000000000 ) {

		}
		System.out.println("end : " + System.nanoTime());
//		TimeUnit seconds = new TimeUnit(); 
//		TimeUnit.SECONDS.convert(System.nanoTime()-stime, TimeUnit.NANOSECONDS);
		System.out.println("diff : " + (System.nanoTime()-stime));
		System.out.println(TimeUnit.NANOSECONDS.toSeconds(System.nanoTime()-stime));
		System.out.println(TimeUnit.NANOSECONDS.toMillis(250000000));

	}
}
