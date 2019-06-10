package chat;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetUtils {
	
	public static void close(Closeable... close_objs) {
		for(Closeable close_obj: close_objs) {
			try {
				close_obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class Send implements Runnable{
	private Socket client;
	private BufferedReader br;
	private DataOutputStream dos;
	
	public Send(Socket client) {
		try {
			this.client = client;
			this.br = new BufferedReader(new InputStreamReader(System.in));
			this.dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			NetUtils.close(client, br, dos);
		}
	}
	
	public void run() {
		while(true) {	
			try {
				dos.writeUTF(br.readLine());
				dos.flush();
			} catch (IOException e) {
				NetUtils.close(client, br, dos);
			}
		}
	}
}

class Receive implements Runnable{
	private Socket client;
	private DataInputStream dis;
	
	public Receive(Socket client) {
		try {
			this.client = client;
			this.dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			NetUtils.close(client, dis);
		}
	}
	
	public void run() {
		while(true) {
			try {
				String msg = dis.readUTF();
				System.out.println(msg);
			} catch (IOException e) {
				NetUtils.close(client, dis);
			}
		}
		
	}
}