import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	
	private Socket socket;
	private Scanner input;
	private DataOutputStream output;
	
	public Client(Socket socket, Scanner input, DataOutputStream output) {
		this.socket = socket;
		this.input = input;
		this.output = output;
		
	}

	public Socket getSocket() {
		return socket;
	}

	public Scanner getInput() {
		return input;
	}

	public DataOutputStream getOutput() {
		return output;
	}
	
	public void run() {
		while(!socket.isClosed()) {
			String action = input.nextLine();
		}
	}
}
