package be.vdab.servlets;

import be.vdab.dao.SauceDAO;
import be.vdab.entities.GuessTheSauceGame;
import be.vdab.entities.Sauce;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author guillaume.vandecasteele on 17/08/2015 at 19:10.
 */
@WebServlet(name = "GuessTheSauceServlet", urlPatterns = "/games/raaddesaus.htm")
public class GuessTheSauceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/raaddesaus.jsp";
    private static final String GAME = "guessGame";
    private final transient SauceDAO sauceDAO = new SauceDAO();

    @Resource(name=SauceDAO.JNDI_NAME)
    void setDataSource(DataSource dataSource) {
        sauceDAO.setDataSource(dataSource);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (request.getParameter("newGame") != null) {
            try {
                session.removeAttribute(GAME);
            }
            catch (NullPointerException ex) {}
        }
        else {
            GuessTheSauceGame game = (GuessTheSauceGame) session.getAttribute(GAME);
            game.checkGuess(request.getParameter("guess"));
            session.setAttribute(GAME, game);
        }
        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute(GAME) == null) {
            session.setAttribute(GAME, new GuessTheSauceGame(getRandomSauceName()));
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    private String getRandomSauceName() {
        Map<Long, Sauce> sauceMap = sauceDAO.findAll();
        List<Long> arrayOfKeys = new ArrayList<>(sauceMap.keySet());
        return sauceMap.get(arrayOfKeys.get(new Random().nextInt(arrayOfKeys.size()))).getNaam();
    }
}
