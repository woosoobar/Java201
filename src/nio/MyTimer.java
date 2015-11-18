package nio;

public class MyTimer {

	protected static final String filePath = "C:\\Users\\mtelo01\\Downloads\\jetty-distribution-9.3.3.v20150827.zip";
	
	private static long startTime;
	private static long endTime;
	
	protected static void start() {
		startTime = System.currentTimeMillis();
	}
	
	protected static void end(String name) {
		endTime = System.currentTimeMillis();
		System.out.println("[ " + name + " Time : " + (endTime-startTime) + " ]");
	}
	
	
}
