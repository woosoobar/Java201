package patt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) throws JSONException {

		JSONObject jo1 = new JSONObject();
		JSONObject jo11 = new JSONObject();
		jo11.accumulate("USER ID", "test30");
		jo11.accumulate("USER NAME", "홍길동");
		jo11.accumulate("COMPANY", "sk");
		jo11.accumulate("DEPART", "운영");
		jo11.accumulate("POSITION", "과장");
//		JSONArray ja1 = new JSONArray();
//		ja1.put(jo11);
//		ja1.put(jo12);
//		ja1.put(jo13);
//		ja1.put(jo14);
//		ja1.put(jo15);
		
		jo1.append("CREATE USER", jo11);
		
//		System.out.println(jo1.toString());
		
		JSONObject json = new JSONObject();
		String[] item = {"CPU", "MEMORY"};
		int[] cpuval = {10, 20};
		for (int i=0, len=item.length; i<len; i++){
			JSONObject subj1 = new JSONObject();
			subj1.put("item", "item_name");
			subj1.put("value", item[i]);
			json.append("VNFI", subj1);
			
			subj1 = new JSONObject();
			subj1.put("item", "minor");
			subj1.put("value", cpuval[i]);
			json.append("VNFI", subj1);
			
//			JSONObject subj2 = new JSONObject();
//			subj2.put("item", "minor");
//			subj2.put("value", cpuval[i]);
//			json.append("VNFI", subj2);
		}
		
		System.out.println(json.toString());
		
	}

}
