package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample implements Runnable {

	private static Random random = new Random();

	private String payload;

	public FutureExample(String payload) {
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}

	@Override
	public void run() {
		int seconds = random.nextInt(10);
		long totalSleep = seconds * 1000;
		try {
			Thread.sleep(totalSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new RuntimeException("I got interrupted");
		}
		System.out.println(payload);
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		List<Future<FutureExample>> tasks = new ArrayList<Future<FutureExample>>();
		
		for (int i = 0; i < 10; i++) {
			String name = "I am thread number: " + i;
			FutureExample fe = new FutureExample(name);
			Future<FutureExample> future = es.submit(fe, fe);
			tasks.add(future);
		}

		try {
			for (Future<FutureExample> future : tasks) {
				FutureExample fe = future.get();
				System.out.println("[future complete]: " + fe.getPayload());
			}
			es.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
