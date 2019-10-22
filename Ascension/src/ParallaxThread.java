import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParallaxThread extends Thread {
	Boolean running;
	private JPanel panel;
	private BufferedImage image;
	private int x, y, width, height, speed;
	
	private JLabel piece1, piece2;
	private TimeUnit time = TimeUnit.MILLISECONDS;
	
	public ParallaxThread(JPanel panel, BufferedImage image, int x, int y, int width, int height, int speed, Boolean running) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.image = image;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.running = running;
		piece1 = new JLabel();
		piece2 = new JLabel();
	}
	
	public void run() {
		int currentx = x;
		while(running) {
			piece1.setIcon(new ImageIcon(image.getSubimage(0, 0, width - currentx, height)));
			piece1.setBounds(currentx, 0, width-currentx, height);
			if(currentx - x > 0) {
				piece2.setIcon(new ImageIcon(image.getSubimage(width - currentx, 0, currentx, height)));
				piece2.setBounds(0, 0, currentx - y, height);
			}
			
			if(currentx - x > 0) {
				panel.add(piece2);
			}
			panel.add(piece1);
			
			if(speed != 0) {
				try {
					time.sleep(50 / speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				currentx = currentx - 1;
				if(currentx >= width) {
					currentx = currentx - width;
				}
				else if(currentx < 0) {
					currentx = currentx + width;
				}
			}
			
		}
	}
}
