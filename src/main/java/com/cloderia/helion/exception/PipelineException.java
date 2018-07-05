/**
 * 
 */
package com.cloderia.helion.exception;

/**
 * @author adrian
 *
 */
public class PipelineException extends HelionRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PipelineException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PipelineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PipelineException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public PipelineException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PipelineException(Throwable cause) {
		super(cause);
	}
	

}
