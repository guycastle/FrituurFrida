package be.vdab.servlets;

import be.vdab.dao.SauceDAO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 *
 * @author guillaume.vandecasteele
 */
@WebServlet(name="SauceByIngredient", urlPatterns={"/sauzen/sauzenperingredient.htm"})
public class SauceByIngredient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/sauzenperingredient.jsp";
    private final transient SauceDAO sauceDAO = new SauceDAO();

    @Resource(name=SauceDAO.JNDI_NAME)
    void setDataSource(DataSource dataSource) {
        sauceDAO.setDataSource(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String ingredient = request.getParameter("ingredient");
        boolean errors = true;
           if (ingredient != null) {
               if (!ingredient.isEmpty() && !ingredient.equalsIgnoreCase("Verplicht")) {
                   request.setAttribute("sauzen", sauceDAO.contains(ingredient));
                   errors = false;
               }
               else {
                  errors = true;
               }
           }
        request.setAttribute("errors", errors);
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
