import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {
	
	private Socket socket;
	private BufferedReader input;
	private DataOutputStream output;
	
	public Client(Socket socket, BufferedReader input, DataOutputStream output) {
		this.socket = socket;
		this.input = input;
		this.output = output;
		
	}

	public Socket getSocket() {
		return socket;
	}

	public BufferedReader getInput() {
		return input;
	}

	public DataOutputStream getOutput() {
		return output;
	}
	
	public void run() {
		while(!socket.isClosed()) {
			try {
				String action = input.readLine();
				//check the actions
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
