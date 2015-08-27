package be.vdab.servlets;

import be.vdab.entities.FindTheFryGame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author guillaume.vandecasteele on 17/08/2015 at 15:08.
 */
@WebServlet(name = "FindTheFryServlet", urlPatterns = "/games/zoekdefriet.htm")
public class FindTheFryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/zoekdefriet.jsp";
    private static final String GAME = "fryGame";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute(GAME) == null) {
            session.setAttribute(GAME, new FindTheFryGame());
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (request.getParameter("newGame") != null) {
            try {
                session.removeAttribute(GAME);
            }
            catch (NullPointerException ex) {}
        } else {
            FindTheFryGame game = (FindTheFryGame) session.getAttribute(GAME);
            if (game != null) {
                try {
                    game.setOpen(Integer.parseInt(request.getParameter("door")));
                    session.setAttribute(GAME, game);
                } catch (NumberFormatException ex) {
                }
            }
        }
        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
    }
}
