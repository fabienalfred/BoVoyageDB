package bovoyage.servlets.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bovoyage.dao.DestinationDAO;
import bovoyage.entites.Destination;
import bovoyage.metier.Panier;
import bovoyage.metier.Voyage;
import bovoyage.servlets.Action;

public class ActionAddVoyage implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Destination d = (Destination) session.getAttribute("dest");
		Voyage voyage = new Voyage();
		voyage.setRegion(d.getRegion());
		int indexVoyage = Integer.parseInt(request.getParameter("voy"));
		voyage.setDatesVoyage(d.getDatesVoyages().get(indexVoyage));
		int nbPlaces = Integer.parseInt(request.getParameter("nbPlaces"));
		voyage.setNbPlaces(nbPlaces);
		
		Panier panier = (Panier) session.getAttribute("panier");
		panier.add(voyage);
		session.setAttribute("panier", panier);
		
		return "/details_dest.jsp";
	}

}
