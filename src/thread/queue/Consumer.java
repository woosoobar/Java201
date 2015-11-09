package thread.queue;

public class Consumer implements Runnable {

	private Queue queue = null;
	private String name = null;
	
	public Consumer( Queue q, String index ) {
		this.queue = q;
		this.name = index;
	}
		
	@Override
	public void run() {
		System.out.println("[ Start Consumer-" + name + " ]");
		try {
			while( !Thread.currentThread().isInterrupted() ) {
				System.out.println(name + " : " + queue.pop().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			System.out.println("[ End Consumer-" + name + " ]");
		}

	}

}
