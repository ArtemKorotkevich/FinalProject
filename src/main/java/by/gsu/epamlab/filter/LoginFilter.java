package by.gsu.epamlab.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.utilit.Constant;


@WebFilter(filterName = "LoginFilter", urlPatterns = {"/addTask.jsp","/index.jsp"})
public class LoginFilter implements Filter {

    public LoginFilter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	  HttpServletRequest ServletRequest = (HttpServletRequest) request;
	  HttpSession session = ServletRequest.getSession();
	  User user = (User) session.getAttribute(Constant.USER);
	    if(user == null){
	      session.invalidate();
	      HttpServletResponse servletResponse = (HttpServletResponse) response;
	      servletResponse.sendRedirect(Constant.LOGIN_PAGE);
	      return;
	    }
	    chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
