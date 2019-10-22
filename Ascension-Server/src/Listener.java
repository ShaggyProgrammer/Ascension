import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Listener extends Thread {
	
	private ArrayList<Client> clients;
	
	public Listener(ArrayList<Client> clients) {
		super();
		this.clients = clients;
	}
	
	public void run() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(8123);
			while(true) {
				System.out.println("Waiting for connection on port 8123");
				Socket socket = server.accept();
				
				Scanner input = new Scanner(
						new InputStreamReader(socket.getInputStream()));
				DataOutputStream output = new DataOutputStream(
						socket.getOutputStream());
				
				output.writeBytes("Welcome\n");
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
