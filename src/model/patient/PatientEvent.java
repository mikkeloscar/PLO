package model.patient;

import java.util.HashMap;

/**
 * Patient Event
 * Used to handle MVC
 * 
 * @author Mikkel Oscar Lyderik
 * @author Aske Mottelson Clausen
 * 
 * @version 1, 2011
 *
 */
public class PatientEvent {
    public static final int 		EVENT_PATIENT_INFO   = 1;
    //public static final int 		EVENT_REMOVED = 2;
    //public static final int 		EVENT_CLEARED = 3;
    private int             		event;
    private HashMap<String, String> data;
        
    public PatientEvent(int event, HashMap<String,String> data)
    {
        this.event = event;
        this.data  = data;
    }
        
    public int getEvent()
    {
        return event;
    }
        
    public HashMap<String,String> getData()
    {
        return data;
    }
}
