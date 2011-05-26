package model.patient;

import model.sql.MySql;
import model.sql.config.SQLConfigException;

/**
 * Sql class
 * 
 * @author Mikkel Oscar Lyderik
 * @author Aske Mottelson Clausen
 * 
 * @version 1, 2011
 *
 */
public class PatientData extends MySql {
	
	private String	CPR;
	private String	firstname;
	private String	lastname;
	private String	zip;
	private String 	address;
	private String 	city;
	private String 	phone;
	private String 	email;

	/**
	 * Creates a Patient object from CPR number
	 * Fetches data from the database
	 * 
	 * @param cpr, the CPR number as a 10 char string
	 * @throws SQLConfigException
	 */
	public PatientData(String cpr) throws SQLConfigException {
		
		super();
		
		try {
			super.connect();
			
			String query = "SELECT cpr, fornavn, efternavn, adresse, p.postnr, bynavn, tlf, email FROM " + 
						   prefix + "patient p, bynavn b WHERE cpr=? AND p.postnr=b.postnr";
						
			preparedStatement = connect.prepareStatement(query);			
			preparedStatement.setString(1, cpr);
			
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();

			//insert values
			CPR = resultSet.getString("cpr");
			firstname = resultSet.getString("fornavn");
			lastname = resultSet.getString("efternavn");
			address = resultSet.getString("adresse");
			zip = resultSet.getString("postnr");
			city = resultSet.getString("bynavn");
			phone = resultSet.getString("tlf");
			email = resultSet.getString("email");
			
		}
		catch(Exception e) {
			//error
			System.out.println(e.getMessage());
		}
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
	
}