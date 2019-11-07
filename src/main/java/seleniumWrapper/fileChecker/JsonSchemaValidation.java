package seleniumWrapper.fileChecker;

import java.io.File;

public class JsonSchemaValidation implements Filter {
	
	private File jsonSchema;
	
	public JsonSchemaValidation(File json) {
		jsonSchema = json;
	}
	
	@Override
	public String validationCheck() {
		String output = "json";
		return output; 
    }
}
