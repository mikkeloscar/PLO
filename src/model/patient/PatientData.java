package model.patient;

import java.util.Date;

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

	public PatientData() throws SQLConfigException {
		super();
	}
	
	public void basicInfo(String cpr) {
		try {
			super.connect();
			
			String query = "SELECT cpr, fornavn, efternavn, adresse, postnr, bynavn, tlf, email FROM " + 
						   prefix + "patient p, bynavn b WHERE cpr=? AND p.postnr=b.postnr";
			
			//System.out.println(query);
			
			preparedStatement = connect.prepareStatement(query);
			
			preparedStatement.setString(1, cpr);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				//String cpr = resultSet.getString("cpr");
				String fornavn = resultSet.getString("fornavn");
				String efternavn = resultSet.getString("efternavn");
				String adresse = resultSet.getString("adresse");
				int postnr = resultSet.getInt("postnr");
				String by = resultSet.getString("bynavn");
				String tlf = resultSet.getString("tlf");
				String email = resultSet.getString("email");
				
				System.out.println("CPR: " + cpr);
				System.out.println("Efternavn: " + efternavn);
				System.out.println("Fornavn: " + fornavn);
				System.out.println("adresse: " + adresse + "\n" + postnr + ", " + by);
				System.out.println("Tlf.: " + tlf);
				System.out.println("Email: " + email);
			}
			
		}
		catch(Exception e) {
			//error
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
