package practiceJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TextFile {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Ashok\\Documents\\Custom Office Templates\\TextFile.txt");
//		if (!file.exists())
//			file.createNewFile();
//		
		FileInputStream fis = new FileInputStream(file);
		int asciicode;
		
		String text = new String();
		asciicode = fis.read();
		while((asciicode = fis.read()) !=-1) {
			text += String.valueOf((char)asciicode);
					//System.out.print((char)asciicode);
					System.out.println(text);
		
	}
		fis.close();
}
}