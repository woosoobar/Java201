package list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import vo.Oper;

public class SortTest {

	public static void main(String[] args) {

		String sortIndex = "";
		String sortType = "desc";
		
		Oper o1 = new Oper();
		o1.setId(100);
		o1.setUserId("won_sa");
		o1.setLastLiTime("2015-06-02 14:17:13");
		
		Oper o2 = new Oper();
		o2.setId(101);
		o2.setUserId("mu_test1");
		o2.setLastLiTime("2015-06-01 14:17:13");
		
		Oper o3 = new Oper();
		o3.setId(300);
		o3.setUserId("belsnake2");
		o3.setLastLiTime("2015-05-02 14:17:13");
		
		Map<Object, Oper> map = new HashMap<Object, Oper>();
//		Map<Object, Oper> sortedMap = new TreeMap<Object, Oper>();
		NavigableMap<Object, Oper> sortedMap = new TreeMap<Object, Oper>();
		
		map.put(o1.getUserId(), o1);
		map.put(o2.getUserId(), o2);
		map.put(o3.getUserId(), o3);
		
		sortedMap.putAll(map);
		
		if ("desc".equals(sortType)) {
//			sortedMap = ((TreeMap<Object, Oper>) sortedMap).descendingMap();
//			sortedMap = sortedMap.descendingMap();
		}
		
		Iterator<Object> iter = sortedMap.keySet().iterator();
		while(iter.hasNext()) {
			Object key = iter.next();
			Oper oo = sortedMap.get(key);
			System.out.println(oo.getUserId());
		}
		
	}

}
