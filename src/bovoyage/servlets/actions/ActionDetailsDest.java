package bovoyage.servlets.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bovoyage.dao.DestinationDAO;
import bovoyage.entites.Destination;
import bovoyage.servlets.Action;

public class ActionDetailsDest implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DestinationDAO dao = (DestinationDAO) request.getServletContext().getAttribute("destinationDAO");
		int idDest = Integer.parseInt(request.getParameter("idDest"));
		Destination d = dao.getDestinationById(idDest);
		d.setDatesVoyages(dao.getDatesVoyages(d));
		d.setImages(dao.getImages(d));
		HttpSession session = request.getSession();
		session.setAttribute("dest", d);
		return "/details_dest.jsp";
	}

}
