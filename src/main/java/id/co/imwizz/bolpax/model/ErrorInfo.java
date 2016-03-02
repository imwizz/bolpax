package id.co.imwizz.bolpax.model;

/**
 * Simple JavaBean domain object representing an error info of response service.
 *
 * @author Sangbas
 */
public class ErrorInfo {
	
	private String message;
	private String url;
	private String body;
	private String className;
	private String exception;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "ErrorInfo [message=" + message + ", url=" + url + ", body="
				+ body + ", className=" + className + ", exception="
				+ exception + "]";
	}
	
}
