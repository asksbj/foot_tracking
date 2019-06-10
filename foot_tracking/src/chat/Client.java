package chat;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	private Socket client;
	
	public Client() {
		init();
	}
	
	private void init() {
		try {
			client = new Socket("localhost", 8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		new Thread(new Send(client)).start();
		new Thread(new Receive(client)).start();
	}

	public static void main(String[] args) {
		new Client().run();
	}

}


