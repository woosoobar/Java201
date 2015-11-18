package thread.queue;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		
		Queue q = JobQueue.getInstance();
		
		Thread con1 = new Thread(new Consumer(q, "1")); 
		Thread con2 = new Thread(new Consumer(q, "2")); 
		Thread con3 = new Thread(new Consumer(q, "3")); 

		con1.start();
		con2.start();
		con3.start();
		
//		Thread pro = new Thread(new Producer(q));
//		pro.start();
//		
//		Thread.sleep(2);
//		pro.interrupt();
		
		Thread.sleep(2);
//		con1.interrupt();
//		con2.interrupt();
//		con3.interrupt();
		
		System.out.println("[ End Main ]");
	}

}
