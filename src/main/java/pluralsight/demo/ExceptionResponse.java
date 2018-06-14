package pluralsight.demo;

import java.util.Date;

public class ExceptionResponse {

	private Date date;
	private String exceptionMessage;
	private String exceptionDetails;
	public ExceptionResponse(Date date, String exceptionMessage, String exceptionDetails) {
		super();
		this.date = date;
		this.exceptionMessage = exceptionMessage;
		this.exceptionDetails = exceptionDetails;
	}
	public Date getDate() {
		return date;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public String getExceptionDetails() {
		return exceptionDetails;
	}
	
	
}
