import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PartyPanel extends JPanel {
	
	private Server server;
	private JLabel label;
	
	public PartyPanel(Server server) {
		super();
		
		this.server = server;
		label = new JLabel("Party:");
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Temp Labels
		JLabel P1 = new JLabel("1");
		JLabel P2 = new JLabel("2");
		JLabel P3 = new JLabel("3");
		JLabel P4 = new JLabel("4");
		
		//Temp Labels
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 1;
		add(label, c);
		
		c.gridx = 7;
		c.gridwidth = 1;
		add(P1, c);
		
		c.gridx = 6;
		add(P2, c);
		
		c.gridx = 5;
		add(P3, c);
		
		c.gridx = 4;
		add(P4, c);
	}
}
