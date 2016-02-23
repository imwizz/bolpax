package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.model.ErrorInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@CrossOrigin
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorInfo handleException(HttpServletRequest req, Throwable ex) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setMessage(ex.getMessage());
		errorInfo.setUrl(req.getRequestURL().toString());
		errorInfo.setClassName(getStackTrace(ex.getStackTrace()));
		errorInfo.setException(ex.getClass().getName());
		errorInfo.setBody(getBody(req));
		System.out.println(errorInfo);
		ex.printStackTrace();
		return errorInfo;
	}

	private String getBody(HttpServletRequest request) {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line;
		    while ((line = reader.readLine()) != null) {
		    	stringBuilder.append(line);
		    }
		} catch (IOException ex) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
				}
			}
		}

		return stringBuilder.toString();
	}
	
	private String getStackTrace(StackTraceElement[] trace) {
		for (StackTraceElement traceElement : trace) {
        	if(traceElement.getClassName().contains("id.co.imwizz.bolpax")) {
        		return traceElement.toString();
        	}
        }
        return null;
	}
	
}
