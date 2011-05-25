package model.sql.config;

import java.io.FileInputStream;
import java.util.Properties;

public class SqlConfig {
	
	private String host;
	private String db;
	private String user;
	private String pwd;
	private String prefix = "";
	
	/**
	 * 
	 * @param file, the path of the config file
	 */
	public SqlConfig(String file) throws SQLConfigException 
	{
		
        Properties sqlProps = new Properties();
        try {
        	FileInputStream configInputStream = new FileInputStream(file);
        	sqlProps.load(configInputStream);
        
        	//load config
        	this.host = sqlProps.getProperty("host");
        	this.db = sqlProps.getProperty("db");
        	this.user = sqlProps.getProperty("user");
        	this.pwd = sqlProps.getProperty("pwd");
        	this.prefix = sqlProps.getProperty("prefix");
        
        	//close input stream
        	configInputStream.close();
        }
        catch(Exception e) {
        	//throw some error
        	System.out.println(e);
        	throw new SQLConfigException(e.getMessage());        	
        }
        
	}
	
	/**
	 * toString
	 * 
	 * @return return a string in this format "_host/_db?user=_user&password=_pwd"
	 * 		   (_% = variable)
	 */
	public String toString() {
		return this.host + "/" + 
			   this.db + "?user=" + 
			   this.user + "&password=" + 
			   this.pwd;
	}

	/**
	 * get host
	 * 
	 * @return host string
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * get db
	 * 
	 * @return db string
	 */
	public String getDb() {
		return this.db;
	}

	/**
	 * get user
	 * 
	 * @return user string
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * get pwd
	 * 
	 * @return pwd string
	 */
	public String getPwd() {
		return this.pwd;
	}
	
	/**
	 * get prefix
	 * 
	 * @return prefix string
	 */
	public String getPrefix() {
		return this.prefix;
	}

}