import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private static Server server;

	public static void main(String[] args) {
		
		Socket socket = null;
		Scanner input = null;
		DataOutputStream output = null;
		
		try {
			socket = new Socket("127.0.0.1", 8123);
			input = new Scanner(new InputStreamReader(socket.getInputStream()));
			output = new DataOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		server = new Server(socket, input, output);
		
		new GUI(server);
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}