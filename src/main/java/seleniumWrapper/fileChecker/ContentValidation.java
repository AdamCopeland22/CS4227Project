package seleniumWrapper.fileChecker;

public class ContentValidation implements Filter{
	
	private String fileExtension;
	private int fileSize;

	public ContentValidation(String ext, int size) {
		fileExtension = ext;
		fileSize = size;
	}
	
	@Override
	public String validationCheck() {
		String output = "content";
		return output; 
	}

}
