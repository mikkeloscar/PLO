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
	
	private String host;
	private String db;
	private String user;
	private String pwd;
	private String prefix = "";
	
	
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String protocol = "jdbc:mysql://";
	
	/**
	 * Construct mysql object to talk to the database
	 * 
	 * @param host, the SQL host
	 * @param db, the database
	 * @param user, the SQL user
	 * @param pwd, the SQL password
	 * @param prefix, the prefix used for the SQL tables
	 */
	public MySql(String host, String db, String user, String pwd, String prefix) {
		this.host = host;
		this.db = db;
		this.user = user;
		this.pwd = pwd;
		this.prefix = prefix;
	}
	
	public MySql() throws SQLConfigException
	{
		SqlConfig config = new SqlConfig("settings/config.properties");
						
		this.host = config.getHost();
		this.db = config.getDb();
		this.user = config.getUser();
		this.pwd = config.getPwd();
		this.prefix = config.getPrefix();
	}
	
	/**
	 * Connect
	 */
	public void connect() throws SQLConnectionException
	{
		
		try {
			Class.forName(driver);
			
			String server = protocol + 
							this.host + "/" + 
							this.db + "?user=" + 
							this.user + "&password=" + 
							this.pwd;  
		
			this.connect = DriverManager.getConnection(server);
		}
		
		catch (Exception e) {
			throw new SQLConnectionException(e.getMessage());
		}
		
	}
	
		
	/**
	 * Insert data to the database
	 * 
	 * @param
	 */
	public void insert(String table, ArrayList<String> values) {
		try {
			this.connect();
			
			preparedStatement = connect.prepareStatement("insert into " + 
														 prefix + 
														 table + 
														 "values ()");
		}
		catch(SQLConnectionException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			close();
		}
	}
	
	/**
	 * Get data from the database
	 */
	public ArrayList<String> select(String table) {
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
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
