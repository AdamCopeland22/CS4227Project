package seleniumWrapper.WebElement;

import java.util.ArrayList;
import java.util.List;

import seleniumWrapper.Browser;
import seleniumWrapper.Commands.ClickCommand;
import seleniumWrapper.Commands.CommandInterface;
import seleniumWrapper.Commands.SendKeysCommand;
import seleniumWrapper.Commands.SubmitCommand;

public class FilterChain {
	private List<Filter> filters = new ArrayList<Filter>();
	 private ElementHandler target;
	 private Handler handler;
	private CommandInterface clickCommand;
   	private CommandInterface submitCommand;
	CommandInterface sendKeysCommand;
   	private Browser browser;
   	private String keys="";
   
	 

	 public FilterChain(Browser b) {
		 browser =b;
	 }
	   public void addFilter(Filter filter){
	      filters.add(filter);
	   }
	   

	   public void execute(String request){
		   //Cancel execution if any step fails
		   boolean passed=true;
	      for (Filter filter : filters) {
	         passed = filter.execute(target,browser,request);
	         if(!passed) {
	        	 System.out.println("Interceptor step failed, aborting action");
	        	 break;
	         }
	      }
	     if(passed) {
	    	 //execute request if all interceptor steps pass
	    	 handler.execute(request);
	     }
	   }

	   public void setTarget(ElementHandler target){
	      this.target = target;
	      //Need to re-register all commands and handlers if new target is set
		  clickCommand = new ClickCommand(target);
		  submitCommand = new SubmitCommand(target);
		  handler = new Handler();
		  handler.register("click", clickCommand);
		  handler.register("submit", submitCommand);
	   }
	   
	   public void setKeys(String keys) {
		   this.keys = keys;
			 sendKeysCommand = new SendKeysCommand(target, keys);
			 handler.register("sendKeys", sendKeysCommand);
	   }

}
