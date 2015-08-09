package bovoyage.servlets;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bovoyage.dao.DestinationDAO;

@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger log = Logger.getAnonymousLogger();

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();
		DestinationDAO destinationDAO = new DestinationDAO();
		application.setAttribute("destinationDAO", destinationDAO);
        log.info(">>> destinationDAO ajouté au contexte applicatif");
	}

}
