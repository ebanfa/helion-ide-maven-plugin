/**
 * 
 */
package com.cloderia.helion.config;

import com.cloderia.helion.HelionRuntimeException;

/**
 * @author Edward Banfa
 *
 */
public class ArtifactException extends HelionRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ArtifactException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ArtifactException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ArtifactException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ArtifactException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ArtifactException(Throwable cause) {
		super(cause);
	}

}
