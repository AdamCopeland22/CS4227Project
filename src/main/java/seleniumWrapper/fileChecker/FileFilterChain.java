package seleniumWrapper.fileChecker;

import java.io.File;
import java.util.ArrayList;

public class FileFilterChain {
	private ArrayList<Filter> filters;
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
		filters = new ArrayList<Filter>();
		target = tar;
	}
	
	/**
	 *@name addFilter
	 *@author Cathal
	 *@param filter - The filter you wish to add to the FilterChain
	 *@return void
	 *@desc - Adds the filter to the FilterChain if it is not already in there
	*/
	public void addFilter(Filter filter) {
		if(!filters.contains(filter))
			filters.add(filter);
	}
	
	/**
	 *@name removeFilter
	 *@author Cathal
	 *@param filter - The filter you wish to remove from the FilterChain
	 *@return void
	 *@desc - Removes reference of Filter from the chain if it is in there
	*/
	public void removeFilter(Filter filter) {
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
		for(Filter filter: filters) {
			outputs.add(filter.validationCheck(target));
		}
		return outputs;
	}
}
