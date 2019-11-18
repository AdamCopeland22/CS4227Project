package seleniumWrapper.fileChecker;

import java.io.File;
import java.util.ArrayList;

public class FileFilterManager {
	
	private int filterType;
	private FileFilterChain chain;
	
	public FileFilterManager(int type, File targetFile) {
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
	public static FileFilterManager ManagerCreation(int type, File targetFile) {
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
		case 1: chain.addFilter((FileFilter)new LogFilter());
		return;
		case 2: chain.addFilter((FileFilter)new JsonSchemaValidation(new File(System.getProperty("user.dir") 
				+ "\\src\\main\\java\\seleniumWrapper\\fileChecker\\Json\\Schema.json")));
		return;
		case 3: chain.addFilter((FileFilter)new ContentValidation(".json", 100));
		return;
		case 4: chain.addFilter((FileFilter)new JsonSchemaValidation(new File(System.getProperty("user.dir") 
				+ "\\src\\main\\java\\seleniumWrapper\\fileChecker\\Json\\Schema.json")));
		chain.addFilter((FileFilter)new ContentValidation(".json", 100));
		chain.addFilter((FileFilter)new LogFilter());
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
		for(String output: outputs) {
			System.out.print(output);
		}
	}
}
