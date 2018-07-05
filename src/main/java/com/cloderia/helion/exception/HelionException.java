/**
 * 
 */
package com.cloderia.helion.exception;

/**
 * @author adrian
 *
 */
public class HelionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelionException() {
		super();
	}

	public HelionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HelionException(String message, Throwable cause) {
		super(message, cause);
	}

	public HelionException(String message) {
		super(message);
	}

	public HelionException(Throwable cause) {
		super(cause);
	}

}
