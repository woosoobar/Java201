package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHowto {

	private final ReentrantLock howtoLock = new ReentrantLock();
	private int count = 0 ;
	
	public int getCount() {
		howtoLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
			return count++;
		} finally {
			howtoLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final ReentrantLockHowto obj = new ReentrantLockHowto();
		
		Thread t1 = new Thread("First Thread") {
			public void run() {
				while (obj.getCount() < 6) {
					try {
						//Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
		};
		
		Thread t2 = new Thread("Second Thread") {
			public void run() {
				while (obj.getCount() < 6) {
					try {
						//Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
		};
		
		t1.start();
		t2.start();
		
	}
}
