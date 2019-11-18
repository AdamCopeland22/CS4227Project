package seleniumWrapper.fileChecker;

import java.io.File;
import java.util.ArrayList;

public class FileFilterChain {
	private ArrayList<FileFilter> filters;
	private File target;
	
	/**
	 *@name FilterChain
	 *@author Cathal
	 *@param tar - This is the target file in which you want to do validation checks on
	 *@return void
	 *@desc - Is the constructor for the FilterChain which is responsible for keeping track of all the filters and when to execute them. 
	 *It also handles any outputs from the filters 
	*/
	public FileFilterChain(File tar) {
		filters = new ArrayList<FileFilter>();
		target = tar;
	}
	
	public void addFilter(FileFilter filter) {
		if(!filters.contains(filter))
			filters.add(filter);
	}
	
	public void removeFilter(FileFilter filter) {
		if(filters.contains(filter))
			filters.remove(filter);
	}
	
	/**
	 *@name validationCheck
	 *@author Cathal
	 *@param None
	 *@return void
	 *@desc - Is the implementation of the method from the Filter interface. 
	 *This is used to call the validation check method on all the filters that the FilterChain is keeping track of.
	*/
	public ArrayList<String> validationCheck () {
		ArrayList<String> outputs = new ArrayList<String>();
		for(FileFilter filter: filters) {
			outputs.add(filter.validationCheck(target));
		}
		return outputs;
	}
}
