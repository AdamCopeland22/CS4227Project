package seleniumWrapper.fileChecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogFilter implements Filter{
	
	public LogFilter() {
		
	}
	
	@Override
	public String validationCheck(File target) {
		String output = "";
		String line = null;
		
		 try {
	            FileReader fileReader =  new FileReader(target);
	            BufferedReader bufferedReader =  new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	                output += line + "\n";
	            }   

	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            output += "Unable to open file: '" +  target.getName() + "'";                
	        }
	        catch(IOException ex) {
	            output += "Error reading file: '" + target.getName() + "'";     
	        }
		return output; 
    }
}
