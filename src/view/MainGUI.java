package view;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Main window for the application.
 * 
 * @author Aske Mottelson Clausen
 * @author Mikkel Oscar Lyderik Larsen
 * @version 1
 */
public class MainGUI extends JFrame{

	public MainGUI(String title){
		this.setTitle(title);
		this.pack();
		
	}
	
	public void alert(String alert, String title){
		JOptionPane pane = new JOptionPane();
		pane.showMessageDialog(this, alert, title, JOptionPane.PLAIN_MESSAGE);
	}
	
}
