import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CenterPanel extends JPanel {

	private Server server;
	
	public CenterPanel(Server server){
		super();
		this.server = server;
		
		server.getInput().nextLine();
		
		
	}

}
