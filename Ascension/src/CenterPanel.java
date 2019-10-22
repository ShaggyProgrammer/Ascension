import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	private Server server;
	
	//Main Menu
	private ParallaxPanel bgContainer;
	
	private BufferedImage bgBackgroundImage;
	private BufferedImage bgLayer1Image;
	private BufferedImage bgLayer2Image;
	private BufferedImage bgLayer3Image;
	private BufferedImage bgLayer4Image;
	
	public CenterPanel(Server server){
		super();
		this.server = server;
		this.setPreferredSize(new Dimension(640, 384));
		//Images
		try {
			bgBackgroundImage = ImageIO.read(new File("./img/MainMenu/background.png"));
			bgLayer1Image = ImageIO.read(new File("./img/MainMenu/farmount.png"));
			bgLayer2Image = ImageIO.read(new File("./img/MainMenu/mount.png"));
			bgLayer3Image = ImageIO.read(new File("./img/MainMenu/fartrees.png"));
			bgLayer4Image = ImageIO.read(new File("./img/MainMenu/trees.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Images
		
		ArrayList<BufferedImage> labels = new ArrayList<BufferedImage>();
		labels.add(bgBackgroundImage);
		labels.add(bgLayer1Image);
		labels.add(bgLayer2Image);
		labels.add(bgLayer3Image);
		labels.add(bgLayer4Image);
		
		ArrayList<Integer> layers = new ArrayList<Integer>();
		layers.add(-1);
		layers.add(0);
		layers.add(1);
		layers.add(2);
		layers.add(3);
		
		ArrayList<Integer> speeds = new ArrayList<Integer>();
		speeds.add(0);
		speeds.add(1);
		speeds.add(2);
		speeds.add(3);
		speeds.add(4);
		
		bgContainer = new ParallaxPanel(labels, layers, speeds);
		
		setMain();
		
		//TO GET SUBIMAGE use BufferedImage.getSubimage(x, y, width, height);
		
		server.getInput().nextLine();
			
	}
	
	public void setMain() {
		removeAll();
		revalidate();
		repaint();
		
		setLayout(new BorderLayout());
		add(bgContainer, BorderLayout.CENTER);
		validate();
	}

}
