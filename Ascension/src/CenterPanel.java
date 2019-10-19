import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CenterPanel extends JPanel implements ActionListener {

	private Server server;
	
	private JTextArea textarea;
	
	public CenterPanel(Server server){
		super();
		this.server = server;
		
		textarea = new JTextArea(20, 60);
		
		setLayout(new BorderLayout());
		add(textarea, BorderLayout.CENTER);
		
		String fuckme = null;
		fuckme = server.getInput().nextLine();
		
		textarea.setText(fuckme);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
