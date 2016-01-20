package com.googlecode.jsonrpc4j;

import java.lang.reflect.Method;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * An {@link ErrorResolver} that puts type information into the data portion of
 * the error. This {@link ErrorResolver} always returns a {@link JsonError}.
 * 
 */
public class ErrorCodeResolver implements ErrorResolver {

	public static final ErrorCodeResolver INSTANCE = new ErrorCodeResolver();

	/**
	 * {@inheritDoc}
	 */
	public JsonError resolveError(Throwable t, Method method,
			List<JsonNode> arguments) {
		if (ErrorCodeException.class.isInstance(t)) {
			ErrorCodeException err_ex = (ErrorCodeException) t;
			return new JsonError(err_ex.errorCode, err_ex.getMessage(),
					new ErrorData(ErrorCodeException.class.getName(),
							err_ex.getMessage()));
		} else {
			return null;
		}
	}

	/**
	 * Data that is added to an error.
	 * 
	 */
	public static class ErrorData {

		private String exceptionTypeName;
		private String message;

		/**
		 * Creates it.
		 * 
		 * @param exceptionTypeName
		 *            the exception type name
		 * @param message
		 *            the message
		 */
		public ErrorData(String exceptionTypeName, String message) {
			this.exceptionTypeName = exceptionTypeName;
			this.message = message;
		}

		/**
		 * @return the exceptionTypeName
		 */
		public String getExceptionTypeName() {
			return exceptionTypeName;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}

	}

}
