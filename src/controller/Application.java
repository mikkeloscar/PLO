package controller;

import view.*;
import javax.swing.UIManager;

import model.patient.Patient;
import model.sql.config.SQLConfigException;

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
        
		/*Loginside login = new Loginside();
        login.setVisible(true);*/
        
        PatientPage patient;
		try {
			patient = new PatientPage(new Patient("0101901149"));
			
			patient.setVisible(true);
		} catch (SQLConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	}
}
