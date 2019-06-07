package utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author sijie
 *
 */
public class FileCopy {
	
	/**
	 * 
	 * @param input
	 * @param output
	 */
	public static void copy(InputStream input, OutputStream output) {
		try {
			byte[] flush = new byte[1024];
			int len = -1;
			
			while((len=input.read(flush)) != -1) {
				output.write(flush, 0, len);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		finally {
			close(input, output);
		}
		
	}
	
	/**
	 * 
	 * @param ios
	 */
	public static void close(Closeable... ios) {
		for(Closeable io: ios) {
			try {
				io.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
