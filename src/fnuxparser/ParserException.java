package fnuxparser;

/**
 * ParserException
 * 
 * @author Mikkel Oscar Larsen
 * @author Aske Mottelson Clausen
 * @version 1 - 2011
 */
public class ParserException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3051357097309675805L;
	
	
	/**
	 * Constructs a new ParserException with the specified message
	 * 
	 * @param message Description of why the exception happened.
	 */
	public ParserException(String message)
	{
		super(message);
	}

}
