import java.util.ArrayList;

public class Server {
	
	private static ArrayList<Client> clients = new ArrayList<Client>(40);

	public static void main(String[] args) {
		Listener listener = new Listener(clients);
		listener.start();
		
		//Game game = new Game(clients);
		//game.start();
		
		
	}

}
