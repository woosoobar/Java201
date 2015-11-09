package sizeTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import vo.DataGroup;
import vo.DataSet;
import vo.Item;

public class ObjectSizeTest {

	public static void main(String[] args) throws IOException {

		Map<String, DataSet> dg1 = new HashMap<String, DataSet>();

		DataGroup dg2 = new DataGroup();

		for (int i=0,len=1000; i<len; i++) {

		}

		Calendar today1 = Calendar.getInstance();
		String currentTime = today1.get(Calendar.HOUR_OF_DAY) 
				+ ":" + today1.get(Calendar.MINUTE)
				+ ":" + today1.get(Calendar.SECOND)
				+ ":" + today1.get(Calendar.MILLISECOND);

		Item item = new Item();
//		item.setSystem("SW");
//		item.setUpper("EAM");
//		item.setLower("HELLO");
//		item.setItem("HLRCS152A");
//		item.setLog("A1363 IPSP CONNECTION STATUS ALARM OCURRED");
//		item.setDate(currentTime);
//		item.setAlarm("1");


		byte[] itemBytes = serialize( item );
		
		System.out.println(itemBytes.length);

	}

	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(b);
		o.writeObject(obj);
		return b.toByteArray();
	}

	public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream b = new ByteArrayInputStream(bytes);
		ObjectInputStream o = new ObjectInputStream(b);
		return o.readObject();
	}

}
