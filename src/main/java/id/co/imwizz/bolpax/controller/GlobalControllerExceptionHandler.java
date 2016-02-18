package id.co.imwizz.bolpax.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import id.co.imwizz.bolpax.model.ErrorInfo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
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
		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
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
