package practiceJava;

import java.io.File;
import java.io.IOException;

public class FileHandle {
	
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\abc.txt");
		//if(f.exists())
		//	f.delete();
		System.out.println(f.createNewFile());
	 		
	}

}
