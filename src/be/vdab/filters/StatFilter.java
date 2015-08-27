package be.vdab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guillaume.vandecasteele on 18/08/2015 at 14:54.
 */
@WebFilter(filterName = "StatFilter", urlPatterns = "*.htm")
public class StatFilter implements Filter {
    private static final String AANTAL_REQ = "aantalRequests";
    private final Map<String, String> displayNames = new LinkedHashMap<>();

    public StatFilter() {
        displayNames.put("index.htm", "Welkom");
        displayNames.put("sauzen.htm", "Sauzen");
        displayNames.put("sauzenperingredient.htm", "Sauzen per Ingrediënt");
        displayNames.put("gender.htm", "Geslacht");
        displayNames.put("zoekdefriet.htm", "Zoek de Friet");
        displayNames.put("raaddesaus.htm", "Raad de Saus");
        displayNames.put("statistieken.htm", "Statistieken");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String uri = stripDownURI(req);
        Map<String, AtomicInteger> aantalRequests = (LinkedHashMap<String, AtomicInteger>)req.getServletContext().getAttribute(AANTAL_REQ);
        if (aantalRequests.containsKey(uri)) {
            aantalRequests.get(uri).incrementAndGet();
        }
        else {
            aantalRequests.put(uri, new AtomicInteger());
            aantalRequests.get(uri).incrementAndGet();
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private String stripDownURI(ServletRequest request) {
        String URI = ((HttpServletRequest)request).getRequestURI().toLowerCase();
        if (URI.contains("/")) {
            URI = URI.substring(URI.lastIndexOf("/")+1);
            if (URI.isEmpty()) {
                URI = "index.htm";
            }
            else if (URI.contains("jsession")) {
                URI = URI.substring(0, URI.indexOf(";"));
            }
        }
        return URI;
    }
}
