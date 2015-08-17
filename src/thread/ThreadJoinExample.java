package thread;

import java.util.Date;

public class ThreadJoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyRunnable(), "t1");
		Thread t2 = new Thread(new MyRunnable(), "t2");
		Thread t3 = new Thread(new MyRunnable(), "t3");
		
		t1.start();
		
		try {
			// 1/1000 초만큼 기다린다 
			t1.join(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		t2.start();
		try {
			//끝날때까지 기다린다
			t1.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("All threads are dead, end main ");
	}

}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread started.. " + Thread.currentThread().getName() + ", " + new Date().getTime());
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("thread ended .." + Thread.currentThread().getName() + ", " + new Date().getTime());
	}
}
