package seleniumWrapper.Logger;

import java.io.IOException;


public class LogController {
	private Log log;
	private LogView logview;

	public LogController(Log log, LogView logview) {
		this.log = log;
		this.logview = logview;
	}
	
	/**
	 *@name addAction(String action)
	 *@author Cian
	 *@param String action
	 *@return void
	 *@desc - Method to add an action to the log	
	*/
	public void addAction(String action) {
		log.addAction(action);
	}
	
	/**
	 *@name getReport
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Writes the log to a txt file	
	*/
	
	public void getReport() throws IOException {
		log.getReport();
	}
	
	/**
	 *@name startTes()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Logs the start of a test case	
	*/
	
	public void startTest() {
		log.startTest();
	}
	
	/**
	 *@name errorHandler()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Logs an error in a test case	
	*/
	
	public void errorHandler(Exception e) {
		log.errorHandler(e);
	}
	
	/**
	 *@name passedTest()
	 *@author Cian
	 *@param None
	 *@return void
	 *@desc - Logs a passed test case	
	*/
	public void passedTest() {
		log.passedTest();
	}
	
	/**
	 *@name updateViewType(LogView logview)
	 *@author Cian
	 *@param Logview 
	 *@return void
	 *@desc - Updates the type of LogView output for the log - Barchart, piechart etc	
	*/
	public void updateViewType(LogView logview) {
		this.logview = logview;
	}
	
	/**
	 *@name updateView()
	 *@author Cian
	 *@param 
	 *@return void
	 *@desc - Displays the test results in the current view	
	*/
	public void updateView() {
		logview.displayResults(log.getTestStats());
	}
	

}
