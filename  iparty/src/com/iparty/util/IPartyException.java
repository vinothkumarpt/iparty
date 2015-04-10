/**
 * 
 */
package com.iparty.util;

import org.apache.log4j.Logger;

/**
 * @author Vinothkumar P T
 *
 */
public class IPartyException extends Exception {

	private final static Logger logger = Logger.getLogger(IPartyException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -5049544992990489821L;

	private String message = null;
	
	private Exception exception = null;

	
	public IPartyException(String message, Exception exception){
		this.message = message;
		this.exception = exception;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
	public void log(){
		logger.error(message, exception);
	}

}
