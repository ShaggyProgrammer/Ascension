import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Listener extends Thread {
	
	private ArrayList<Client> clients;
	
	public Listener(ArrayList<Client> clients) {
		super();
		this.clients = clients;
	}
	
	public void run() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(8000);
			while(true) {
				System.out.println("Waiting for connection on port 8000");
				Socket socket = server.accept();
				
				BufferedReader input = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				DataOutputStream output = new DataOutputStream(
						socket.getOutputStream());
				
				output.writeBytes("Welcome");
				Client client = new Client(socket, input, output);
				clients.add(client);
				client.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cleanup() {
		for (Client client : clients) {
			try {
				client.getInput().close();
				client.getOutput().close();
				client.getSocket().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
