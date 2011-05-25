package model.sql;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *  SQL Interface
 */
public interface ISql {
		
	/**
	 * Connect to database
	 */
	public void connect() throws SQLConnectionException;
	
	/**
	 * close connection
	 */
	public void close();
	
	/**
	 * Insert data to the database
	 */
	public void insert(String table, ArrayList<String> values);
	
	/**
	 * Get data from the database
	 */
	public ArrayList<String> select(String table);
	
	/**
	 * custom query
	 */
	public ResultSet query(String query);

}
