package view;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 * Main window for the application. All windows is inherited from this class.
 * 
 * @author Aske Mottelson Clausen
 * @author Mikkel Oscar Lyderik Larsen
 * @version 1
 */
public class MainGUI extends JFrame{

	public MainGUI(String title, int width, int height){
		super(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(null); 
		
		this.pack();
	}
	
	// error popup
	public void error(String error, String title){
		JOptionPane errorpane = new JOptionPane();
		errorpane.showMessageDialog(this, error, title, JOptionPane.ERROR_MESSAGE);
		errorpane.setVisible(true);
	}
	
	// ok popup
	public void okPop(String message, String title){
		JOptionPane okpane = new JOptionPane();
		okpane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
		okpane.setVisible(true);
	}
	
	// ok_cancel popup
	public void okCancel(String message, String title){
		JOptionPane okCancel = new JOptionPane();
		okCancel.showConfirmDialog(this, message, title, JOptionPane.OK_CANCEL_OPTION);
		okCancel.setVisible(true);
	}
	
	// exit function. kills frame
	public void exit(){
		this.dispose();
	}
	
}
