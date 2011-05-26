package view;

import controller.PatientPageController;

import model.patient.Patient;
import model.patient.PatientData;
import model.patient.PatientEvent;
import model.sql.config.SQLConfigException;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Patient Page
 * 
 * @author Mikkel Oscar Lyderik
 * @author Aske Mottelson Clausen
 * 
 * @version 1, 2011
 *
 */
public class PatientPage extends MainGUI implements Observer
{
	
	private PatientPageController control;

	public PatientPage(Patient patient){
		super("Patientside" + " - " + patient.getCpr(), 1000, 600);
		
		control = new PatientPageController(this, patient);
        patient.addObserver(this);
		
		JMenu filer = new JMenu("Filer");
		
		JMenuItem opret = new JMenuItem("Opret ny patient");
		filer.add(opret);
		JMenuItem aabn = new JMenuItem("Åbn ny patient");
		aabn.setActionCommand("open");
		aabn.addActionListener(control);	
		
		filer.add(aabn);	
		JMenuItem gem = new JMenuItem("Gem");
		filer.add(gem);
		JMenuItem eksporter = new JMenuItem("Exporter journal til FNUX");
		filer.add(eksporter);
		JMenuItem luk = new JMenuItem("Luk");
		filer.add(luk);
		
		JMenu rediger = new JMenu("Rediger");
		
		JMenuItem fortryd = new JMenuItem("Fortryd");
		rediger.add(fortryd);
		JMenuItem gentag = new JMenuItem("Gentag sidste handling");
		rediger.add(gentag);	
		JMenuItem copy = new JMenuItem("Kopiér");
		rediger.add(copy);
		JMenuItem cut = new JMenuItem("Klip");
		rediger.add(cut);
		JMenuItem paste = new JMenuItem("Sæt ind");
		rediger.add(paste);
		
		JMenu journal = new JMenu("Journal");
		JMenuItem konsultation = new JMenuItem("Registrer konsultation");
		journal.add(konsultation);
		JMenuItem henvisning = new JMenuItem("Registrer henvisning");
		journal.add(henvisning);
		
		JMenuItem diagnose = new JMenuItem("Registrer diagnose");
		journal.add(diagnose);
		JMenuItem soeg = new JMenuItem("Søg i journal");
		journal.add(soeg);
		JMenuItem privi = new JMenuItem("Ændre privelegier");
		journal.add(privi);
		JMenuItem importer = new JMenuItem("Importér FNUX-journal");
		journal.add(importer);
		JMenuItem udskriv = new JMenuItem("Udskriv journal");
		journal.add(udskriv);
		
		JMenu patientMenu = new JMenu("Patient");
		JMenuItem oplysning = new JMenuItem("Ændre stamoplysninger");
		patientMenu.add(oplysning);

		JMenu help = new JMenu("Hjælp");
		JMenuItem om = new JMenuItem("Om PLO");
		help.add(om);
		JMenuItem manual = new JMenuItem("Manual");
		help.add(manual);
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(filer);
		bar.add(rediger);
		bar.add(journal);
		bar.add(patientMenu);
		bar.add(help);
		
		// fetch information from DB
			//TODO: implement this with key cpr
		
		
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		
	}
	
	public void patientInfo(HashMap<String,String> data) {
		
		JPanel patientInfo = new JPanel();		
		patientInfo.setLayout(new GridLayout(0,2));		
		
		
		Set set = data.entrySet();
		// Get an iterator 
		Iterator i = set.iterator(); 
		// Display elements
		
		//String info = "";
		while(i.hasNext()) { 
			Map.Entry me = (Map.Entry)i.next();
			patientInfo.add(new JLabel(me.getKey() + ": " + me.getValue()));
		}
		
		this.add(patientInfo, BorderLayout.CENTER);
		
		this.validate();
	}
	
	public void update(Observable sender, Object arg)
    {
        if (arg instanceof PatientEvent)
        {
            PatientEvent e = (PatientEvent)arg;
            if (e.getEvent() == PatientEvent.EVENT_PATIENT_INFO) {
            	System.out.println("test-patientpage");
            	patientInfo(e.getData());
            }
        }
    }
}