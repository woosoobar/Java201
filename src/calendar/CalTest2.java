package calendar;

import java.util.Calendar;

public class CalTest2 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.getTime());
		for (int t=50; t > 0; t--) {
			
			c.add(Calendar.MINUTE, -t);
			System.out.println(c.getTime());
			c.add(Calendar.MINUTE, t);
		}
	}
}
