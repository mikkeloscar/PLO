package model.patient;

import java.util.Date;
import java.util.HashMap;

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
	
	//private HashMap<String,String> data;

	public PatientData() throws SQLConfigException {
		super();
	}
	
	public HashMap<String,String> basicInfo(String cpr) {
		
		HashMap<String, String> row = new HashMap<String, String>();
		
		try {
			super.connect();
			
			String query = "SELECT cpr, fornavn, efternavn, adresse, p.postnr, bynavn, tlf, email FROM " + 
						   prefix + "patient p, bynavn b WHERE cpr=? AND p.postnr=b.postnr";
			
			//System.out.println(query);
			
			preparedStatement = connect.prepareStatement(query);
			
			preparedStatement.setString(1, cpr);
			//preparedStatement.executeUpdate();
			resultSet = preparedStatement.executeQuery();
			
			//while (
				resultSet.next();//) {
				row = new HashMap<String, String>();
				
				row.put("cpr", resultSet.getString("cpr"));
				row.put("fornavn", resultSet.getString("fornavn"));
				row.put("efternavn", resultSet.getString("efternavn"));
				row.put("adresse", resultSet.getString("adresse"));
				row.put("postnr", resultSet.getString("postnr"));
				row.put("bynavn", resultSet.getString("bynavn"));
				row.put("tlf", resultSet.getString("tlf"));
				row.put("email", resultSet.getString("email"));
				
				//String cpr = resultSet.getString("cpr");
				/*String fornavn = resultSet.getString("fornavn");
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
				System.out.println("Email: " + email);*/
			//}		
			
		}
		catch(Exception e) {
			//error
			System.out.println(e.getMessage());
		}
		
		return row;
				
	}
	
}