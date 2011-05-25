package controller;

import view.*;
import javax.swing.UIManager;

public class Application
{
	
	public static void main(String [ ] args)
	{
		MainGUI mainframe = new MainGUI("PLO Patientside");
		//Use system specific GUI
		try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception _) { } // Just ignore this.
        
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
        
        mainframe.alert("Patient oprettet.", "Godkendt");
	}
}
