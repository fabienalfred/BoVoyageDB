package bovoyage.servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bovoyage.metier.Panier;


/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event)  { 
    	HttpSession session = event.getSession();
    	session.setAttribute("panier", new Panier());
    }


    public void sessionDestroyed(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    }
	
}
