package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
	
	private ServerSocket server;
	CopyOnWriteArrayList<Channel> channels = new CopyOnWriteArrayList<>();
	
	public Server(){
		try {
			server = new ServerSocket(8888);
			
		} catch (IOException e) {
			NetUtils.close();
		}
	}
	
	public void run() {
		while(true) {
			try {
				Socket client = server.accept();
				Channel channal = new Channel(client, channels);
				new Thread(channal).start();
				System.out.println("Set up a connection");
				channels.add(channal);

			} catch (IOException e) {
				NetUtils.close(server);
			}
		}
		
	}

	public static void main(String[] args) {
		new Server().run();
	}

}

class Channel implements Runnable{
	
	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	private CopyOnWriteArrayList<Channel> channels; 
	
	public Channel(Socket client, CopyOnWriteArrayList<Channel> channels) {
		try {
			this.client = client;
			this.channels = channels;
			this.dis = new DataInputStream(client.getInputStream());
			this.dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			release();
		}
		
	}
	
	public void run() {
		try {
			
			while(true) {
				String msg = dis.readUTF();				
				sendAll(msg);
			}
		} catch (IOException e) {
			release();
		}
		
	}
	
	public void sendAll(String msg) throws IOException {
		for(Channel channel: channels) {
			if(channel != this) {
				channel.send(msg);
			}
		}
	}
	
	public void send(String msg) throws IOException {
		dos.writeUTF(msg);
		dos.flush();
	}
	
	public void release() {
		NetUtils.close(dis, client);
		channels.remove(this);
	}
	
}
