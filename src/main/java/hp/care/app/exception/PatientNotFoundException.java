package hp.care.app.exception;

public class PatientNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException() {
		
	}
	public PatientNotFoundException(String message) {
		super(message);
	}
}
