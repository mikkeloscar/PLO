package view;


import controller.PatientSideController;

import model.patient.PatientData;
import model.sql.config.SQLConfigException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Patientside extends MainGUI {
	
	private PatientSideController control;

	public Patientside(String cpr){
		super("Patientside" + " - " + cpr);
		
		JMenu filer = new JMenu("Filer");
		
		JMenuItem opret = new JMenuItem("Opret ny patient");
		filer.add(opret);
		JMenuItem aabn = new JMenuItem("Åbn ny patient");
		aabn.setActionCommand("open");
		aabn.addActionListener(control);
		//test
		aabn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 try {
					 PatientData data = new PatientData();
					
					 //System.out.println("test");
					
					 HashMap<String, String> map = data.basicInfo("0101901149");
					
					 Set set = map.entrySet();
					 // Get an iterator 
					 Iterator i = set.iterator(); 
					 // Display elements
					
					 String info = "";
					 while(i.hasNext()) { 
						 Map.Entry me = (Map.Entry)i.next(); 
						 /*System.out.print(me.getKey() + ": "); 
						 System.out.println(me.getValue());*/
						 info = info + me.getKey() + ": " + me.getValue() + "\n";
					 }
					
					 patientInfo(info);
					
				 } catch (SQLConfigException e1) {
					 // TODO Auto-generated catch block
					 e1.printStackTrace();
				 }  
			 }  
		});
		
		
		
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
		JMenuItem udskriv = new JMenuItem("Udskriv journal");
		rediger.add(udskriv);
		
		JMenu journal = new JMenu("Journal");
		JMenuItem konsultation = new JMenuItem("Registrér konsultation");
		journal.add(konsultation);
		JMenuItem henvisning = new JMenuItem("Registrér henvisning");
		journal.add(henvisning);
		
		JMenuItem diagnose = new JMenuItem("Registrér diagnose");
		journal.add(diagnose);
		JMenuItem soeg = new JMenuItem("Søg i journal");
		journal.add(soeg);
		JMenuItem privi = new JMenuItem("Ændre privelegier");
		journal.add(privi);
		JMenuItem importer = new JMenuItem("Importér FNUX-journal");
		journal.add(importer);
		
		JMenu patient = new JMenu("Patient");
		JMenuItem oplysning = new JMenuItem("Ændre stamoplysninger");
		patient.add(oplysning);

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
		bar.add(patient);
		bar.add(help);
		
		// fetch information from DB
			//TODO: implement this with key cpr
		
		
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		
	}
	
	public void patientInfo(String info) {
		JPanel patientInfo = new JPanel();
		
		JLabel label = new JLabel(info);
		
		patientInfo.add(label);
		
		this.add(patientInfo);
		
		this.validate();
	}	
}