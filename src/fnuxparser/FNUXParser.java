package src.fnuxparser;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * FNUXParser
 * 
 * @author Mikkel Oscar Larsen
 * @author Aske Mottelson Clausen
 * @version 1.0 - 2011
 */
public class FNUXParser {
	
	private File file;
	private Boolean hasParsed;
	
	/**
	 * Constructs a new FNUXParser to work on the specified FNUX file
	 * 
	 * @param file
	 */
	public FNUXParser(File file) throws FileNotFoundException
	{
		this.file = file;
		hasParsed = false;
		
		if (!file.isFile())
            throw new FileNotFoundException("The specified file does not exist.");
	}
	
	/**
	 * Constructs a new FNUXParser given a path as a String
	 * 
	 * @throws FileNotFoundException If the specified path is not a file 
	 * @param fileName path to the file as string
	 */
	public FNUXParser(String fileName) throws FileNotFoundException
	{
		this(new File(fileName));
	}
	
	/**
	 * Parses the file
	 */
	public void parseFnux() {
		
	}
	
	/**
	 * Creates a FNUX formatted file from database data
	 * 
	 * @return
	 */
	public String makeFnux() {
		return "fnux-output";
	}
}