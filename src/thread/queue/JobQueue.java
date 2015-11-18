package thread.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class JobQueue implements Queue{

	private static final String NAME = "JOB QUEUE";
	private static final Object monitor = new Object();

	private LinkedList<Object> jobs = new LinkedList<>();

	// 싱글톤
	private static JobQueue instance = new JobQueue();
	
	private JobQueue() {}

	public static JobQueue getInstance() {
		if (instance == null) {
			synchronized (JobQueue.class) {
				instance = new JobQueue();
			}			
		}
		return instance;
	}

	public String getName() {
		return NAME;
	}

	public LinkedList<Object> getLinkedList() {
		return jobs;
	}

	public void clear() {
		synchronized ( monitor ) {
			jobs.clear();
		}
	}

	@SuppressWarnings("unchecked")
	public void pub( Object o ) {
		synchronized ( monitor ) {
			jobs.addLast(o);
			monitor.notify();
		}
	}

	public Object pop() throws InterruptedException, NoSuchElementException {
		Object o = null;
		synchronized ( monitor ) {
			if( jobs.isEmpty() ) {
				System.out.println(Thread.currentThread().getName() + " wait...");
				monitor.wait();				
			}
			o = jobs.removeFirst();
		}
		if( o == null ) {
			throw new NoSuchElementException();
		}
		return o;
	}

	@Override
	public int size() {
		return jobs.size();
	}
	
}
