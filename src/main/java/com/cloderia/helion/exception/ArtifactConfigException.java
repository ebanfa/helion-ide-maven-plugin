/**
 * 
 */
package com.cloderia.helion.exception;

/**
 * @author Edward Banfa
 *
 */
public class ArtifactConfigException extends HelionRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ArtifactConfigException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ArtifactConfigException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ArtifactConfigException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ArtifactConfigException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ArtifactConfigException(Throwable cause) {
		super(cause);
	}

}
