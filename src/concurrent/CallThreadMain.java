package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallThreadMain {

	public static class CallThread implements Callable<Integer> {

		private int n;
		public CallThread(int n) {
			this.n = n;
		}
		
		@Override
		public Integer call() throws Exception {
			int result = 0;
			for (int i=0; i <= n; i++) {
				result += i;
			}
			Thread.sleep(n);
			return result;
		}
	}
	
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(3);
		
		Future<Integer> f1 = service.submit(new CallThread(10));
		Future<Integer> f2 = service.submit(new CallThread(5000));
		Future<Integer> f3 = service.submit(new CallThread(2000));
		Future<Integer> f4 = service.submit(new CallThread(10000));
		Future<Integer> f5 = service.submit(new CallThread(8000));
		
		try {
			//Future객체에서 get을 호출하면 바로 수행되는 것이 아니고 스레드가
			//종료될때까지 블로킹되서 대기한 후 작업을 수행
			System.out.println("f1 : "+f1.get());
			System.out.println("f2: "+f2.get());
			System.out.println("f3: "+f3.get());
			System.out.println("f4: "+f4.get());
			System.out.println("f5: "+f5.get());
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		service.shutdown();

	}
	
}
