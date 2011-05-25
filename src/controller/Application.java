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
        catch (Exception _) { } // Silent exception handling
        
		Loginside login = new Loginside();
        login.setVisible(true);

        
	}
}
