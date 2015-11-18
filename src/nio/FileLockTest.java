package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		FileChannel channel = null;
		
		File file = new File("c:\test.dock");
		try {
			channel = new RandomAccessFile(file, "rw").getChannel();
	
			FileLock lock = channel.lock(0, Long.MAX_VALUE, true);
			
			try {
				boolean isShared = lock.isShared();
				System.out.println("is shared lock : " + " ; " + isShared);
				
			} 
			finally {
				lock.release();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
