import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ParallaxPanel extends JLayeredPane {
	
	Boolean running;
	
	private ArrayList<BufferedImage> images;
	private ArrayList<Integer> layers;
	private ArrayList<Integer> speeds;
	
	private ArrayList<JPanel> panels;
	
	public ParallaxPanel(ArrayList<BufferedImage> images, ArrayList<Integer> layers, ArrayList<Integer> speeds) {
		
		this.images = images;
		this.layers = layers;
		this.speeds = speeds;
		running = Boolean.TRUE;
		
		panels = new ArrayList<JPanel>();
		
		for(int i = 0; i < images.size(); i++) {
			panels.add(new JPanel());
			panels.get(i).setOpaque(false);
			panels.get(i).setBounds(0, 0, images.get(i).getWidth(), images.get(i).getHeight());
			
			add(panels.get(i), layers.get(i));
			new ParallaxThread(panels.get(i), images.get(i), 0, 0, 
					images.get(i).getWidth(), images.get(i).getHeight(), speeds.get(i), running).start();
		}
		
		validate();
		
	}
}
