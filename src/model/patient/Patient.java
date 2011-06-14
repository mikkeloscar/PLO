package model.patient;

import java.util.HashMap;
import java.util.Observable;

import model.sql.MySql;
import model.sql.config.SQLConfigException;

/**
 * Patient class
 * 
 * @author Mikkel Oscar Lyderik
 * @author Aske Mottelson Clausen
 * 
 * @version 1, 2011
 *
 */
public class Patient extends Observable {
	
	private String	CPR;
	private String	firstname;
	private String	lastname;
	private String	zip;
	private String 	address;
	private String 	city;
	private String 	phone;
	private String 	email;
	
	private PatientData sql;
	
	//private Journal journal;

	/**
	 * Creates a Patient object from CPR number
	 * Fetches data from the database
	 * 
	 * @param cpr, the CPR number as a 10 char string
	 * @throws SQLConfigException
	 */
	public Patient(String cpr) throws SQLConfigException {
		
		sql = new PatientData(cpr);
		
		CPR = sql.getCpr();
		firstname = sql.getFirstname();
		lastname = sql.getLastname();
		address = sql.getAddress();
		zip = sql.getZip();
		city = sql.getCity();
		phone = sql.getPhone();
		email = sql.getEmail();

	}
	
	/**
	 * 
	 */
	public String getCpr() {
		return this.CPR;
	}
	
	/**
	 * 
	 */
	public String getFirstname() {
		return this.firstname;
	}
	
	/**
	 * 
	 */
	public String getLastname() {
		return this.lastname;
	}
	
	/**
	 * 
	 */
	public String getZip() {
		return this.zip;
	}
	
	/**
	 * 
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * 
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * 
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * 
	 */
	public String getEmail() {
		return this.email;
	}
	
	public void getDataHash() {
		
		HashMap<String,String> dataHash = new HashMap<String, String>();
		
		dataHash.put("CPR", this.CPR);
		dataHash.put("Fornavn", this.firstname);
		dataHash.put("Efternavn", this.lastname);
		dataHash.put("Adresse", this.address);
		dataHash.put("Postnr.", this.zip);
		dataHash.put("By", this.city);
		dataHash.put("Tlf.", this.phone);
		dataHash.put("Email", this.email);		
	
		setChanged();
        	notifyObservers(new PatientEvent(PatientEvent.EVENT_PATIENT_INFO, dataHash));
	}

}
