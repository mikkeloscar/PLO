package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.patient.Patient;
import view.PatientPage;
import view.SearchDialog;

/**
 * Patient Controller
 * 
 * @author Mikkel Oscar Lyderik
 * @author Aske Mottelson Clausen
 * 
 * @version 1, 2011
 *
 */
public class PatientPageController implements ActionListener {
	
	private Patient		patient;
    private PatientPage	frame;
    //private boolean		used;
    
    public PatientPageController(PatientPage frame, Patient patient)
    {
        this.patient = patient;
        this.frame   = frame;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
                
        if (command.equals("open"))
        {
        	
        	SearchDialog searchDialog = new SearchDialog(frame, true);
        	if (!searchDialog.canceled())
        	{
				patient.getBasicInfo(); 		
        	}
        }        
    }
}