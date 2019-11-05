package seleniumWrapper.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Log {

	 ArrayList<String> actionList;
	int test,passed,failed;
	public Log() {
		actionList = new ArrayList<>();
	}
	
	public void addAction(String action) {
		actionList.add(action);
	}
	
	public void getReport() throws IOException {
	
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		Path path = Paths.get("./logs/"+timeStamp+".txt");
		Files.write(path, actionList, StandardCharsets.UTF_8);
	}
	
	public void startTest() {
		actionList.add("Starting test " + test);
		test++;
	}
	
	public void errorHandler() {
		actionList.add("Failed test " + test);
		failed++;
	}
	
	public void passedTest() {
		actionList.add("Passed test " + test);
		passed++;
	}
	
	public int[] getTestStats() {
		int [] results = {test,passed,failed};
		return results;
	}
	
}
