package model.sql.config;

/**
 * SQLConfigException
 * 
 * @author Mikkel Oscar Larsen
 * @author Aske Mottelson Clausen
 * @version 1 - 2011
 */
public class SQLConfigException extends Exception
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4078434189132686197L;

	/**
	 * Constructs a new SQLConfigException with the specified message
	 * 
	 * @param message Description of why the exception happened.
	 */
	public SQLConfigException(String message)
	{
		super(message);
	}

}