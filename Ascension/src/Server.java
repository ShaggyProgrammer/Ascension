import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
		private Socket socket;
		private Scanner input;
		private DataOutputStream output;
		
		public Server(Socket socket, Scanner input, DataOutputStream output) {
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
}
