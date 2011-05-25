package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.patient.PatientData;

import view.Patientside;

public class PatientSideController implements ActionListener {
	
	private PatientData patientData;
    private Patientside    frame;
    private boolean       used;
    
    public PatientSideController(PatientData patientData,Patientside frame)
    {
        this.patientData = patientData;
        this.frame   = frame;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
                
        if (command.equals("open"))
        {
            /*AddTypeDialog addDialog = new AddTypeDialog(frame, true);
            if (!addDialog.canceled())
            {
                machine.enterItemType(addDialog.getType(),
                                      addDialog.getDescription(),
                                      addDialog.getValue());
            }*/
        	
        	SearchDialog searchDialog = new SearchDialog(frame, true);
        	if (!searchDialog.canceled())
        	{
        		patientData.basicInfo(searchDialog.getCpr());
        	}
        }
        else if (command.equals("remove"))
        {
            /*try {
                machine.removeItemType(frame.getSelectedType());
            }
            catch (ReturnMachineException ex)
            {
                // Invalid type, just ignore this.
            }*/
        }
        /*else if (command.equals("reset"))
            machine.reset();
        else if (command.equals("resetall"))
            machine.resetAll();
        else if (command.equals("show"))
        {
            Object source = e.getSource();
            final Component showItem = (Component)source;
            showItem.setEnabled(false);
            
            UserFrame userFrame = new UserFrame(machine);
            userFrame.addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(WindowEvent event)
                    {
                        showItem.setEnabled(true);
                        machine.deleteObserver((UserFrame)event.getSource());
                    }
                });
            userFrame.setVisible(true);
        }*/
    }
}