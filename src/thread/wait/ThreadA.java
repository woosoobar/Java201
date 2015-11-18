package thread.wait;

public class ThreadA {
	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();
		
		synchronized (b) {
			System.out.println("Waiting for b to complete...");
			b.wait();
		}
		System.out.println("Total is: " + b.total);
 
	}
}
 
class ThreadB extends Thread {
	int total;
 
	@Override
	public void run() {
		synchronized ( this ) {
			for (int i = 0; i < 20000; i++) {
				total = i;
			}
			this.notify();
		}
	}
	
}
