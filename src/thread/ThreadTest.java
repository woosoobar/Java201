package thread;

import java.util.ArrayList;

public class ThreadTest implements Runnable {

	int seq;
	public ThreadTest(int seq) {
		// TODO Auto-generated constructor stub
		this.seq = seq;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.seq + " thread start..");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		System.out.println(this.seq + " thread end");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i=0; i<10; i++) {
			Thread t = new Thread(new ThreadTest(i));
			t.start();
			threads.add(t);
		}
		
		for (int i=0; i<threads.size(); i++) {
			Thread t = threads.get(i);
			try {
				//t.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("main end");
	}

}
