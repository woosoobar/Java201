package byteTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Random;

import vo.Item;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ByteTest1 {

	public static void main(String[] args) throws IOException {
		
		Calendar today = Calendar.getInstance();
		String date = today.get(Calendar.HOUR_OF_DAY) 
							+ ":" + today.get(Calendar.MINUTE)
							+ ":" + today.get(Calendar.SECOND)
							+ ":" + today.get(Calendar.MILLISECOND);
		
		Item item = new Item();
		item.setSystem("SW");
		item.setUpper("EAM");
		item.setLower("A1363 IPSP CONNECTION");
		item.setLower("HELLO");
		item.setItem("HLRCS152A");
		item.setLog("A1363 IPSP CONNECTION STATUS ALARM OCURRED\n"
				+"A1363 IPSP CONNECTION STATUS ALARM OCURRED\n"
				+"A1363 IPSP CONNECTION STATUS ALARM OCURRED\n"
				+"A1363 IPSP CONNECTION STATUS ALARM OCURRED\n"
				+"A1363 IPSP CONNECTION STATUS ALARM OCURRED\n"
				+"A1363 IPSP CONNECTION STATUS ALARM OCURRED\n"
				+"A1363 IPSP CONNECTION STATUS ALARM OCURRED\n");
		item.setDate(date);
		item.setAlarm(getRandomGrade());
		
//		String item = "{\"system\":\"SW\",\"upper\":null,\"lower\":null,\"item\":null,\"date\":null,\"alarm\":null,\"mask\":null,\"grade\":null,\"log\":null,\"count\":0}";
		
//		byte[] bs = new byte[375];
//		for (int i = 0; i < bs.length; i++) {
////			byte b = 'a';
////			bs[i] = b;
//		}
//		item.setBytes(bs);
		
		String a1 = "{\"bytes\":\"hy0+5ltjv0k+QV9dXiDZOdi0ryumtAM1SyQrmsqPcJ3Bk/A0thTWRvtIZFZsRNMqAc8LaDczSAAUf8zENG3eS/nnJq8bMHNCDzU5858jV7TXWL4C8s7wKtfKu7cmwSHb9y7rG34LZJDQzLW895eUK4VnfSSG4x1MGlvH0OYCcWlm8kxZ6mlkgRZBpgmmAEnrWH/dXPd2r0wogdBMM87GCFd5j3v8iY9Gvlj1xpI0r3dC1FoRHbAodJEAHF+8fc5avpC2MWaEdBMqrT9l10SLtFoaGl8jnRv5qJOMgaeV2XL047OmbvrnUb/24SlDD/zGWubCmAhK178EgPnKC/4nSDPltvxsFO1DZ2nUEdmg/AcgnhWUISdSz/86E812DQ1CHUZh7k/QT+ENIeUsTmi/Xy35Hg2Vv4pJOh6Id2dju042AOIXGaDKFyOeI9iPOE19KRErf+C/2GEXLFvC1ZLBhGXtOOheWNHVHlKPhjkbEqFdAtr1UEzo4D3knm2mnIGGd/AkQcpuW3H5O1vXIPNBHDcc+IKLp1lDGCgG+Tk6Lb6crX5amIhHDa6UWJHJ7j46yqH7NwcpP2VXL/0R3fcQEOjSAZQbWTKZwItau+/KawRLGkq8kYPz+WyMPBtXHzjQ0/DGfjnQ2ui1E6VxAeUTNJUxp9vHWwLFD0EIHWBys58=\"}";
//		String b1 = "{\"bytes\":\"lSQ7TvlWGWC07brNYLfBe3PbEkuV88CpjZuGhxPVVABzctdwlcOvT9L/2+qnDEHpfkC5PsvZgQF8XYMsZr1frj4RVZnQno2GTGfIADlIacL0J8YGR32J87eweRKSXyN2iBtVY2iOKe0eurmKi/FJ9eHfL+S8Ck2aQQxY7k8QGnt2kIg3JYOLE/UW3IW5fPjIJdA9sSEmbtwVx9JBOrcj5UPSCMJPlaG0tgeL4P+6+7vzYFrSMQ8xCZ2ifMRSx2dau3TR8jLxo7f1M1jeP9uErVQxy2/r1eIqPCV2snvHTXnAWzUNodNZHH7jRXKB+pcnop3JsBKfITfGxL1u/mrOKMkpaUxxllFH0FDfk29EhoINlrWFrfg4kQPhat4HOp9bXv58jPnMXfOdyxi/1aNbhBnFXMyIPgTnMI5dgSbK+jCdhF84mHDppUyrISInAyIRHgaQPrIOCU19Ly2Uz4YHNLhRxHYvHfXjdxGSd/scHHvHK4Go/s27oo/hX3baCR/ZdZMHMaNdz41tfJ4uitxZBJMWo1mCPCC0ALU0JwMEeD6tDmkYXQjat7EpO040TkgtWBsGoBoaOELauIrqa7X0o81tOD/Jq+4OeUhZc/kfH367uWpj5trxFyDVrg4V9hcEWN/MNNoKNFcw/KdlALJNk7iihKLHa4mVRnUaW2rOYrY=\"}";
//		System.out.println("a1: " + a1.getBytes().length);
//		System.out.println("b1: " + b1.getBytes().length);
		
		
		byte[] bArr = new byte[375]; // 512
//		byte[] bArr = new byte[2990]; // 4000
//		byte[] bArr = new byte[47990]; // 64000
//		byte[] bArr = new byte[30]; // 
		new Random().nextBytes(bArr);
		
//		item.setBytes(bArr);
		
		ObjectMapper omapper = new ObjectMapper();
		String jsonStr = omapper.writeValueAsString(item);
		
		System.out.println(jsonStr);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);   
		out.writeObject(jsonStr);
		byte[] yourBytes = bos.toByteArray();
		System.out.println(yourBytes.length);
//		System.out.println(item.getBytes().length);
	}
	
	public static String getRandomGrade(){

		String value = "NORMAL";
		Random generator = new Random();   
		int random = generator.nextInt(4);

		if (random == 1){
			value = "MINOR";
		} else if (random == 2) {
			value = "MAJOR";
		} else if (random == 3) {
			value = "CRITICAL";
		}
		return value;
	}
}
