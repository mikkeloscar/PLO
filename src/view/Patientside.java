package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Patientside extends JFrame{

	public Patientside(String cpr){
		super("Patientside" + " - " + cpr);
		
		JMenu filer = new JMenu("Filer");
		
		JMenuItem opret = new JMenuItem("Opret ny patient");
		filer.add(opret);
		JMenuItem aabn = new JMenuItem("Åbn ny patient");
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
	
	
}

