import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main extends JPanel implements ActionListener {

	private Server server;
	
	private JTextArea textarea;
	
	public Main(Server server){
		super();
		this.server = server;
		
		textarea = new JTextArea(20, 60);
		
		setLayout(new BorderLayout());
		add(textarea, BorderLayout.CENTER);
		
		String fuckme = null;
		try {
			fuckme = server.getInput().readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textarea.setText(fuckme);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
