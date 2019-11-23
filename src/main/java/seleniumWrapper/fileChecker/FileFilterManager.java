package seleniumWrapper.fileChecker;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;

public class FileFilterManager {
	
	private String filterType;
	private FileFilterChain chain;
	
	public FileFilterManager(String type, File targetFile) {
	  filterType = type;
	  chain = new FileFilterChain(targetFile);
	  setFilters();
	}
	
	/**
	 *@name ManagerCreation
	 *@author Cathal
	 *@params type - type of manager we want
	 *		  targetFile - the file we want to do checks on
	 *@return FilterManager - instance to be used by client
	 *@desc - Sets up the manager so as not to use new keyword
	*/
	public static FileFilterManager ManagerCreation(String type, File targetFile) {
		return new FileFilterManager(type, targetFile);
	}

	/**
	 *@name setFilters
	 *@author Cathal
	 *@param None
	 *@return void
	 *@desc - Sets up the filters for the chain depending on the configuration of the user
	*/
	private void setFilters() {
		switch(filterType) {
		case "Log": chain.addFilter((FileFilter)new LogFilter());
		return;
		case "Json": chain.addFilter((FileFilter)new JsonSchemaValidation(new File(System.getProperty("user.dir") 
				+ "\\src\\main\\java\\seleniumWrapper\\fileChecker\\Files\\Schema.json")));
		return;
		case "Content": chain.addFilter((FileFilter)new ContentValidation(".json", 100));
		return;
		case "Http": chain.addFilter((FileFilter)new HttpValidation("http:webcode.me"));
		return;
		case "Transaction":
			chain.addFilter((FileFilter)new JsonSchemaValidation(new File(System.getProperty("user.dir") 
			+ "\\src\\main\\java\\seleniumWrapper\\fileChecker\\Files\\Schema.json")));
			chain.addFilter((FileFilter)new ContentValidation(".json", 100));
			chain.addFilter((FileFilter)new LogFilter());
		return;
		case "All":
			chain.addFilter((FileFilter)new JsonSchemaValidation(new File(System.getProperty("user.dir") 
			+ "\\src\\main\\java\\seleniumWrapper\\fileChecker\\Files\\Schema.json")));
			chain.addFilter((FileFilter)new ContentValidation(".json", 100));
			chain.addFilter((FileFilter)new LogFilter());
			chain.addFilter((FileFilter)new HttpValidation("http:webcode.me"));
		return;
		default: return;
		}
	}
	
	/**
	 *@name FilterRequest
	 *@author Cathal
	 *@param None
	 *@return void
	 *@desc - Calls the chain to execute its list and prints out the feedback from the filters
	*/
	public void FilterRequest() {
		ArrayList<String> outputs = chain.validationCheck();
		boolean failure = false;
		
		for(String output: outputs) {
			if(output.contains("Error:"))
				failure = true;
			System.out.print(output);
		}
		
		if(failure)
			fail();
	}
}
