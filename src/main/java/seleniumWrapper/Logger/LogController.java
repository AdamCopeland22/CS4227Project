package seleniumWrapper.Logger;

import java.io.IOException;


public class LogController {
	private Log log;
	private LogView logview;

	public LogController(Log log, LogView logview) {
		this.log = log;
		this.logview = logview;
	}
	
	public void addAction(String action) {
		log.addAction(action);
	}
	
	public void getReport() throws IOException {
		log.getReport();
	}
	
	public void startTest() {
		log.startTest();
	}
	
	public void errorHandler() {
		log.errorHandler();
	}
	
	public void passedTest() {
		log.passedTest();
	}
	
	public void updateViewType(LogView logview) {
		this.logview = logview;
	}
	
	public void updateView() {
		logview.displayResults(log.getTestStats());
	}
	

}
