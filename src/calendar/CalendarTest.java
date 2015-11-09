package calendar;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Calendar today1 = Calendar.getInstance();
		System.out.println( "End Time :: " 
				+ today1.get(Calendar.HOUR_OF_DAY) + ":"  
				+ today1.get(Calendar.MINUTE) + ":"
				+ today1.get(Calendar.SECOND) + ":"
				+ today1.get(Calendar.MILLISECOND));
		
		System.out.println("s :: " + today1.getTimeInMillis());
		long stime = today1.getTimeInMillis();
		
		Thread.sleep(20);
		
		
		Calendar today2 = Calendar.getInstance();
		System.out.println( "End Time :: " 
				+ today2.get(Calendar.HOUR_OF_DAY) + ":"  
				+ today2.get(Calendar.MINUTE) + ":"
				+ today2.get(Calendar.SECOND) + ":"
				+ today2.get(Calendar.MILLISECOND));
		
		long etime = today2.getTimeInMillis();
		System.out.println("e :: " + today2.getTimeInMillis());
		double diff  = 1000.0;
		System.out.println( (etime-stime)/diff );
		
		boolean SSL = System.getProperty("ssl") != null;
		System.out.println(SSL);
	}

}
