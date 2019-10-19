import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI extends JFrame {
	
	private Server server;
	
	private JPanel main;
	
	public GUI(Server server) {
		super("Ascension");
		this.server = server;
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		main = new Main(server);
		
		System.out.println("wtf");
		
		setLayout(new BorderLayout());
		add(main, BorderLayout.CENTER);
		
		
		
	}
}
