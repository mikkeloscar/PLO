package model.sql;

/**
 * SQLConfigException
 * 
 * @author Mikkel Oscar Larsen
 * @author Aske Mottelson Clausen
 * @version 1 - 2011
 */
public class SQLConnectionException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6966928978055327041L;

	/**
	 * Constructs a new SQLConnectionException with the specified message
	 * 
	 * @param message Description of why the exception happened.
	 */
	public SQLConnectionException(String message)
	{
		super(message);
	}

}