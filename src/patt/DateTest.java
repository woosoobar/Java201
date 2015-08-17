package patt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
//		GregorianCalendar gc = new GregorianCalendar();
//		long milis = gc.getTimeInMillis();// 밀리초로 바꿔준다
//		//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH24mmss"); // 기본 데이타베이스 저장 타입
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd"); // 기본 데이타베이스 저장 타입
//		Date d = gc.getTime(); // Date -> util 패키지
//		String date = sf.format(d);

//		System.out.println(getDate());
		
		String format = "YYYY-mm-dd";
		String gubun = "M";
		int val = -1;
		
		String inputDate = addDate(gubun, format, val);
		
		System.out.println(inputDate);
		
	}


	public static String getDate() {
		String date = getDate("-");
		return date;
	}

	public static String getDate(String shape) {
		Calendar cal = Calendar.getInstance();
		String yyyy = Integer.toString(cal.get(Calendar.YEAR));
		String mm = Integer.toString(cal.get(Calendar.MONTH)+1);
		String dd = Integer.toString(cal.get(Calendar.DATE));
		if(mm.length()==1)mm = "0"+mm;
		if(dd.length()==1)dd = "0"+dd;

		String date = yyyy + shape + mm + shape + dd; 
		return date;
	}
	
	public static String addDate(String gubun, String format, int val) {
		Calendar cal = Calendar.getInstance();
		if ("Y".equals(gubun)) {
			cal.add(Calendar.YEAR, val);
		} else if ("M".equals(gubun)) {
			cal.add(Calendar.MONTH, val);
		} else if ("D".equals(gubun)) {
			cal.add(Calendar.DATE, val);
		}
		
		return setDateFormat(cal, format);
	}

	public static String getTime() {
		String time = getTime("-");
		return time;
	}

	public static String getTime(String shape) {
		Calendar cal = Calendar.getInstance();
		String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
		String min = Integer.toString(cal.get(Calendar.MINUTE));
		String sec = Integer.toString(cal.get(Calendar.SECOND));
		if(min.length()==1)min = "0"+min;
		if(sec.length()==1)sec = "0"+sec;

		String time = hour + shape + min + shape + sec; 
		return time;
	}
	
	public static String setDateFormat(Calendar cal, String format) {
//		Date today = new Date();
		return new SimpleDateFormat(format).format(cal.getTimeInMillis());
	}
	public static String setDateFormat2(String format) {
		Date today = new Date();
		return new SimpleDateFormat(format).format(today);
	}
}
