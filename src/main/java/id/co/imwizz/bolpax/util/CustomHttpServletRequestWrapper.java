package id.co.imwizz.bolpax.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

/**
 * Wrapper used to be able to consume multiple times the InputStream provided by
 * HttpServletRequest
 *
 * @author Sangbas
 */
public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private static final Logger logger = Logger.getLogger(CustomHttpServletRequestWrapper.class);
    private final String body;

    public CustomHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
            } else {
                stringBuilder.append("no body");
            }
        } catch (IOException ex) {
            logger.error("Error reading the request body...");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    logger.error("Error closing bufferedReader...");
                }
            }
        }

        body = stringBuilder.toString();
        String uri = request.getRequestURI();
        Map<String,String[]> paramsMap = request.getParameterMap();
        
        logger.info("Request URI = " + uri + ", Request params = " + paramsMap + ", Request body = " + body);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final StringReader reader = new StringReader(body);
        ServletInputStream inputStream = new ServletInputStream() {
            public int read() throws IOException {
                return reader.read();
            }

			@Override
			public boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {
				// TODO Auto-generated method stub
				
			}
        };
        return inputStream;
    }
}