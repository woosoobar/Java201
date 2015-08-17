package thread;

public class StopThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StopThreadTest stt = new StopThreadTest();
		stt.process();
	}

	private void process() {
		// TODO Auto-generated method stub
		StopThread st = new StopThread();
		Thread thread = new Thread(st);
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		st.stop();
	}

}
