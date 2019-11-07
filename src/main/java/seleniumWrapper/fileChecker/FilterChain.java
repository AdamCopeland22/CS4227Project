package seleniumWrapper.fileChecker;

import java.io.File;
import java.util.ArrayList;

public class FilterChain {
	ArrayList<Filter> filters;
	File target;
	
	public FilterChain(File tar) {
		filters = new ArrayList<Filter>();
		target = tar;
	}
	
	public void addFilter(Filter filter) {
		filters.add(filter);
	}
	
	public void removeFilter(Filter filter) {
		filters.remove(filter);
	}
	
	public ArrayList<String> validationCheck () {
		ArrayList<String> outputs = new ArrayList<String>();
		for(Filter filter: filters) {
			outputs.add(filter.validationCheck());
		}
		return outputs;
	}
}
