package patt;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StringTest {

	public static void main(String[] args) throws JSONException {
		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("1", "김");
//		System.out.println(map.size());
//		add(map);
//		System.out.println(map.size());
			
		ArrayList<String> arr1 = new ArrayList<String>();
		arr1.add("aa");
		arr1.add("bb");
		arr1.add("cca");
		System.out.println(arr1.toString());
		
//		String str1 = "aa, ";
//		System.out.println(str1.lastIndexOf(","));
//		System.out.println(str1.substring(0, str1.lastIndexOf(",")));
		
		JSONObject json = new JSONObject();
		JSONObject subjson1 = new JSONObject();
		
		subjson1.put("item", "id");
		subjson1.put("value", "aa");
		
		json.append("SS", subjson1);
		
		System.out.println(json.toString());
	}
	
	private static void add(Map<String, String> map) {
		map.put("2", "박");
	}
}
