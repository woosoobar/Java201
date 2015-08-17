package patt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Hex;

public class PattTest {

	public static void main(String[] args) {

		String expr = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern patt = Pattern.compile(expr);
		Matcher matc = patt.matcher("test@nate.com");
		if (!matc.find()) {
			System.out.println(111);
		}else{
			System.out.println(222);
		}
		
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance( "SHA1" );
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String chgpw = Hex.encodeHexString( messageDigest.digest("ABCDEABCDEABCDEA".getBytes() ) );
		String chgpw2 = Hex.encodeHexString( messageDigest.digest("ABCDEABC".getBytes() ) );
		System.out.println(chgpw);
		System.out.println(chgpw.length());
		System.out.println(chgpw2);
		System.out.println(chgpw2.length());

	}
}