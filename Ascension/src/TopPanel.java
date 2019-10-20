import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	
	private Server server;
	
	private GridBagConstraints constraints;
	
	//Main Menu
	private JLabel mainLabel;
	private BufferedImage mainLabelImage;
	
	//Lobby
	private JLabel lobbyLabel;
	private BufferedImage lobbyLabelImage;
	
	//Game
	private JLabel partyLabel;
	private BufferedImage partyLabelImage;
	
	private JPanel partyPanel;
	
	private JLabel p1;
	private JLabel p2;
	private JLabel p3;
	private JLabel p4;
	
	private BufferedImage p1Image;
	private BufferedImage p2Image;
	private BufferedImage p3Image;
	private BufferedImage p4Image;
	
	public TopPanel(Server server) {
		super();
		
		this.server = server;
		
		setPreferredSize(new Dimension(640, 48));
		//setBackground(new Color(79, 75, 74));
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		
		//Images
		try {
			mainLabelImage = ImageIO.read(new File("./img/Ascension.png"));
			lobbyLabelImage = ImageIO.read(new File("./img/Lobby.png"));
			partyLabelImage = ImageIO.read(new File("./img/Party.png"));
			p1Image = ImageIO.read(new File("./img/Class/Warrior/Default.png"));
			p2Image = ImageIO.read(new File("./img/Class/Mage/Default.png"));
			p3Image = ImageIO.read(new File("./img/Class/Cleric/Default.png"));
			p4Image = ImageIO.read(new File("./img/Class/Rogue/Default.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Images
		
		mainLabel = new JLabel(new ImageIcon(mainLabelImage));
		lobbyLabel = new JLabel(new ImageIcon(lobbyLabelImage));
		partyLabel = new JLabel(new ImageIcon(partyLabelImage));
		
		partyPanel = new JPanel();
		partyPanel.setLayout(new GridBagLayout());
		
		//Temp Labels
		p1 = new JLabel(new ImageIcon(p1Image));
			p1.setPreferredSize(new Dimension(48, 48));
		p2 = new JLabel(new ImageIcon(p2Image));
			p2.setPreferredSize(new Dimension(48, 48));
		p3 = new JLabel(new ImageIcon(p3Image));
			p3.setPreferredSize(new Dimension(48, 48));
		p4 = new JLabel(new ImageIcon(p4Image));
			p4.setPreferredSize(new Dimension(48, 48));
		//Temp Labels
			
		setMain();
		
	}
	
	public void setMain() {
		removeAll();
		revalidate();
		repaint();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		add(mainLabel, constraints);
		
		validate();
	}
	
	public void setLobby() {
		removeAll();
		revalidate();
		repaint();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		add(lobbyLabel, constraints);
		
		validate();
	}
	
	public void setGame() {
		
		//Main
		removeAll();
		revalidate();
		repaint();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(partyLabel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.anchor = GridBagConstraints.FIRST_LINE_END;
		add(partyPanel, constraints);
		
		//PartyPanel
		partyPanel.removeAll();
		partyPanel.setLayout(new GridBagLayout());
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		partyPanel.add(p1, constraints);
		
		constraints.gridx = 2;
		partyPanel.add(p2, constraints);
		
		constraints.gridx = 1;
		partyPanel.add(p3, constraints);
		
		constraints.gridx = 0;
		partyPanel.add(p4, constraints);
		
		//Validate
		partyPanel.validate();
		revalidate();
	}
}
