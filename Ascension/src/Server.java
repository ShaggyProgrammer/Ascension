import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

public class Server {
	
		private Socket socket;
		private BufferedReader input;
		private DataOutputStream output;
		
		public Server(Socket socket, BufferedReader input, DataOutputStream output) {
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
}
