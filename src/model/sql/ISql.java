package model.sql;

import java.util.ArrayList;

/**
 *  SQL Interface
 */
public interface ISql {
	
	/**
	 * Connect using params
	 * 
	 * @param host, the SQL host
	 * @param db, the database
	 * @param user, the SQL user
	 * @param pwd, the SQL password
	 * @param prefix, the prefix used for the SQL tables
	 */
	public void connect(String host, String db, String user, String pwd, String prefix);
	
	/**
	 * Connect using properties files
	 */
	public void connect();
	
	/**
	 * close connection
	 */
	public void close();
	
	/**
	 * Insert data to the database
	 */
	public void insert();
	
	/**
	 * Get data from the database
	 */
	public ArrayList<String> select();
	
	/**
	 * custom query
	 */
	public void query();

}
