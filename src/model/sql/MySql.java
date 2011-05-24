package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.sql.config.SQLConfigException;
import model.sql.config.SqlConfig;

/**
 * Sql class
 * 
 * @author Mikkel Oscar Lyderik
 * @author Aske Mottelson Clausen
 * 
 * @version 1, 2011
 *
 */
public class MySql implements ISql {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String protocol = "jdbc:mysql://";
	
	/**
	 * Connect
	 * 
	 * @param host, the SQL host
	 * @param db, the database
	 * @param user, the SQL user
	 * @param pwd, the SQL password
	 * @param prefix, the prefix used for the SQL tables	 * 
	 */
	public void connect(String host, String db, String user, String pwd, String prefix) {
		
		try {
			Class.forName(driver);
			
			String server = protocol + host + "/" + db + "?user=" + user + "&password=" + pwd;  
		
			connect = DriverManager.getConnection(server);
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Connect using properties file
	 */
	public void connect() {	
		
		try {
			SqlConfig config = new SqlConfig("settings/config.properties");
			
			Class.forName(driver);
			
			String server = protocol + config.toString();  
		
			connect = DriverManager.getConnection(server);
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLConfigException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert data to the database
	 * 
	 * @param
	 */
	public void insert() {
		
	}
	
	/**
	 * Get data from the database
	 */
	public ArrayList<String> select() {
		ArrayList<String> test = new ArrayList<String>();
		
		test.add("Something");
		
		return test;
	}
	
	/**
	 * custom query
	 */
	public void query() {
		
	}
	
	/**
	 * 
	 */
	public void close() {
		
	}

}
