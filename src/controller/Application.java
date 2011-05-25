package controller;

import view.*;
import javax.swing.UIManager;

public class Application
{
	
	public static void main(String [ ] args)
	{
	
		//Use system specific GUI
		try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception _) { } // Just ignore this.
        
		MainGUI mainframe = new MainGUI("PLO Patientside");
		Patientside patient = new Patientside("0101901149");
        
        patient.setVisible(true);
		
        
	}
}
