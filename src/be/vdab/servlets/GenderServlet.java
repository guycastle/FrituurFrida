package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author guillaume.vandecasteele
 */
@WebServlet(name="BoyOrGirl", urlPatterns={"/gender.htm"})
public class GenderServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;
    public static final String VIEW = "/WEB-INF/JSP/gender.jsp";
    public static final int COOKIE_TTL = 15;;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       request.getRequestDispatcher(VIEW).forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Cookie cookie = new Cookie("gender", null);
        String[] genderEntry = request.getParameterValues("gender");
        if (genderEntry != null && genderEntry.length > 1) {
            cookie.setValue("agender");
        }
        else {
            cookie.setValue(genderEntry[0]);
        }        
        cookie.setMaxAge(COOKIE_TTL);
        response.addCookie(cookie);
        response.sendRedirect(request.getRequestURI());
    }
}
