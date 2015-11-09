package executor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	static ScheduledExecutorService timer = 
			Executors.newSingleThreadScheduledExecutor(); 

	static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	public static void main(String[] args) {

		timer.scheduleAtFixedRate(
	             () -> sendTimeToAll(), 1, 1, TimeUnit.SECONDS);  
//		timer.scheduleAtFixedRate(sendTimeToAll(), 3, 3, TimeUnit.SECONDS);
		
		try {
			if (timer.awaitTermination(5, TimeUnit.SECONDS)) {
				System.out.println("end");
			} else {
				
				System.out.println("still");
			}
			
////			Thread.sleep(10000);
////			timer.shutdownNow();
////			timer.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void sendTimeToAll() {       
		System.out.println(LocalTime.now().format(timeFormatter));
		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
