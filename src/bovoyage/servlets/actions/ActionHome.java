package bovoyage.servlets.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bovoyage.dao.DestinationDAO;
import bovoyage.entites.Destination;
import bovoyage.metier.DestinationTO;
import bovoyage.servlets.Action;

public class ActionHome implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		DestinationDAO destinationDAO = (DestinationDAO) application.getAttribute("destinationDAO");
		
		List<DestinationTO> destinations = new ArrayList<>();
		for(Destination d : destinationDAO.getDestinations()){
			DestinationTO dTO = new DestinationTO(d);
			dTO.setImage(destinationDAO.getImages(d).get(0));
			destinations.add(dTO);
		}
		
		request.setAttribute("destinations", destinations);
		return "/home.jsp";
	}

}
