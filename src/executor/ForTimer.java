package executor;

import java.util.Calendar;

public class ForTimer {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		long cTime = cal.getTimeInMillis();
		
		int i = 0;
		while (Calendar.getInstance().getTimeInMillis() < (cTime+1000)) {
			i++;
		}
		System.out.println(i);
		
	}
}
