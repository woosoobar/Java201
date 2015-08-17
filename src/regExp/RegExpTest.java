package regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String expr = "^(0\\d{1,2})[-]?([1-9]\\d{2,4})[-]?(\\d{4})$";
		String expr = "^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$";
//		String expr = "^[1-9][0-9].$"; 
		Pattern patt = Pattern.compile(expr);
		Matcher matc = patt.matcher("0101234-1234");
		if (!matc.find()) {
			System.out.println("X");
		} else {
			System.out.println("O");
		}
	}

}
