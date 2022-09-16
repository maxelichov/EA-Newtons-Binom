package workshopea.webserver.exception;

public class CourseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CourseException(String errorMessage) {  
    	super(errorMessage);  
    } 
	
}
