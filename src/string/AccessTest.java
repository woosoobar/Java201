package string;



public class AccessTest {

//	Hello h = new Hello();
//	PublicHello ph = new PublicHello();
	public static void main(String[] args) {
		String user = "hong";
		user = replace(user, "/", "%2F");
		System.out.println(user);
		
	}
	
	public static String replace(String inString, String oldPattern, String newPattern) {
//		if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
//			return inString;
//		}
		StringBuilder sb = new StringBuilder();
		int pos = 0; // our position in the old string
		int index = inString.indexOf(oldPattern);
		// the index of an occurrence we've found, or -1
		int patLen = oldPattern.length();
		while (index >= 0) {
			sb.append(inString.substring(pos, index));
			sb.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}
		sb.append(inString.substring(pos));
		// remember to append any characters to the right of a match
		return sb.toString();
	}
}
