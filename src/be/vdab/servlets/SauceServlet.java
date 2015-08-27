package be.vdab.servlets;

import be.vdab.dao.SauceDAO;
import be.vdab.entities.Sauce;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author guillaume.vandecasteele
 */
@WebServlet(name="sauzenservlet", urlPatterns={"/sauzen.htm"})
public class SauceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";
    private static final String REDIRECT_URL = "%s/sauzen.htm";
    private final transient SauceDAO sauceDAO = new SauceDAO();

    @Resource(name=SauceDAO.JNDI_NAME)
    void setDataSource(DataSource dataSource) {
        sauceDAO.setDataSource(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sauzen", sauceDAO.findAll().values());
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Map<Long, Sauce> sauceMap = new HashMap<>();
        sauceMap = sauceDAO.findAll();
        Map<String, String> errors = new HashMap<>();
        Set<Long> sausIds = new HashSet<>();
        if (request.getParameterValues("sauce") != null) {
            for (String id : request.getParameterValues("sauce")) {
                try {
                    long sauceId = Long.parseLong(id);
                    if (sauceMap.containsKey(sauceId)) {
                        sausIds.add(sauceId);
                    }
                }
                catch (NumberFormatException ex) {
                    errors.put("saus", "Saus bestaat niet");
                }
            }
        }
        if (errors.isEmpty()) {
            sauceDAO.remove(sausIds);
            response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
        }
        else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(VIEW).forward(request, response);
        }
    }
}
