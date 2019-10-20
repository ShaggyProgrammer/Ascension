import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI extends JFrame {
	
	private Server server;
	
	private JPanel main;
	private TopPanel top;
	
	public GUI(Server server) {
		super("Ascension");
		this.server = server;
		this.setIconImage(new ImageIcon("./img/Icon.png").getImage());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(640, 480);
		setResizable(false);
		
		top = new TopPanel(server);
		main = new CenterPanel(server);
		//bottom = new ButtonPanel();
		
		System.out.println("wtf");
		
		setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);
		add(main, BorderLayout.CENTER);
		validate();
		top.setGame();
		validate();
	}
}
