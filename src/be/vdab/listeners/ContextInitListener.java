package be.vdab.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guillaume.vandecasteele on 18/08/2015 at 07:31.
**/


@WebListener
public class ContextInitListener implements ServletContextListener {
    private static final String AANTAL_REQ = "aantalRequests";

    @Override
    public void contextInitialized(ServletContextEvent scEvent) {
        scEvent.getServletContext().setAttribute(AANTAL_REQ, new LinkedHashMap<String, AtomicInteger>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent scEvent) {

    }

    /*@Override
    public void requestInitialized(ServletRequestEvent srEvent) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent srEvent) {
        String URI = stripDownURI(srEvent);
        if (checkAndFilterRequest(URI)) {
            Map<String, AtomicInteger> aantalRequests = (LinkedHashMap<String, AtomicInteger>)srEvent.getServletContext().getAttribute(AANTAL_REQ);
            if (aantalRequests.containsKey(URI)) {
                aantalRequests.get(URI).incrementAndGet();
            }
            else {
                aantalRequests.put(URI, new AtomicInteger());
                aantalRequests.get(URI).incrementAndGet();
            }
        }
    }

    */
}
