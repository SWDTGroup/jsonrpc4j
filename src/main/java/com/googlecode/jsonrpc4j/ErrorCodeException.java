package com.googlecode.jsonrpc4j;


/**
 * Unchecked exception aimed to preserve error response body in case of http
 * error.
 * 
 * @author Alexander Makarov
 * 
 */
public class ErrorCodeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public int errorCode = 0;

	public ErrorCodeException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

}
