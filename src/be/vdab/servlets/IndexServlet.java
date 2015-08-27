package be.vdab.servlets;

import be.vdab.entities.Address;
import be.vdab.entities.Town;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author guillaume.vandecasteele
 */
@WebServlet(name="indexservlet", urlPatterns={"/index.htm"})
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final Address address = new Address();
	
	@Override
    public void init() {
        ServletContext context = this.getServletContext();
            
        address.setTown(new Town(context.getInitParameter("gemeente"), Integer.parseInt(context.getInitParameter("postCode"))));
        address.setStraat(context.getInitParameter("straat"));
        address.setHuisNr(context.getInitParameter("huisNr"));
    }
        
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("locale", request.getLocale().toLanguageTag());
        request.setAttribute("address", address);
        request.setAttribute("closed", isClosed());
        request.getRequestDispatcher(VIEW).forward(request, response);
	}

    private boolean isClosed() {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        return day == Calendar.MONDAY || day == Calendar.THURSDAY;
    }
}
