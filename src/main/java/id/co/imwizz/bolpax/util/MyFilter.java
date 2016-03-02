package id.co.imwizz.bolpax.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter to wrap the request
 *
 * @author Sangbas
 */
public class MyFilter implements Filter {

    public void init(FilterConfig fc) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new CustomHttpServletRequestWrapper((HttpServletRequest)request), response);

    }

    public void destroy() {

    }

}
