package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFile {

	public static void main(String[] args) {
		File file = new File("src/abc.txt");

		InputStream input = null;
		try {
			input = new FileInputStream(file);
			int length;
			byte[] flush = new byte[1024*10];
			
			while((length=input.read(flush)) != -1) {
				String str = new String(flush);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
