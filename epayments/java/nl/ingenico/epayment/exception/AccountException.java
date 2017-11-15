package nl.ingenico.epayment.exception;

/**
 * Custom exception to wrap other exception.
 * 
 * @author dillipkumar.vp
 *
 */

public class AccountException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public AccountException() {
		super();
	}

	/**
	 * Method to add error message to the error appender
	 * 
	 * @param message
	 */
	public AccountException(String message) {
		super(message);
	}

	/**
	 * Method to Add throwable/exception object to the error appender
	 * 
	 * @param cause
	 */

	public AccountException(Throwable cause) {
		super(cause);
	}

	/**
	 * Method to add Custom message and throwable object to error appender.
	 * 
	 * @param message
	 * @param throwable
	 */
	public AccountException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
