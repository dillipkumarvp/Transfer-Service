package nl.ingenico.epayment.exception;

/**
 * Custom exception to wrap other exception.
 * 
 * @author dillipkumar.vp
 *
 */

public class PaymentException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public PaymentException() {
		super();
	}

	/**
	 * Method to add error message to the error appender
	 * 
	 * @param message
	 */
	public PaymentException(String message) {
		super(message);
	}

	/**
	 * Method to Add throwable/exception object to the error appender
	 * 
	 * @param cause
	 */

	public PaymentException(Throwable cause) {
		super(cause);
	}

	/**
	 * Method to add Custom message and throwable object to error appender.
	 * 
	 * @param message
	 * @param throwable
	 */
	public PaymentException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
