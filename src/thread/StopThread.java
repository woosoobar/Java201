package thread;

public class StopThread implements Runnable {

	private boolean stopFlag = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!stopFlag) {
			System.out.println("Thread is alive..");
			try {
				//Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.err.println("Thread is dead!");

	}
	
	public void stop() {
		this.stopFlag = true;
	}
}
