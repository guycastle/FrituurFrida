package be.vdab.filters;

import be.vdab.dao.CookieDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author guillaume.vandecasteele on 18/08/2015 at 13:29.
 */
@WebFilter(filterName = "ServletFilter", urlPatterns = "*.htm")
public class ServletFilter implements Filter {
    private final CookieDAO cookieDAO;

    public ServletFilter() {
        cookieDAO = new CookieDAO();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req = cookieDAO.processCookieRequest((HttpServletRequest)req);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
