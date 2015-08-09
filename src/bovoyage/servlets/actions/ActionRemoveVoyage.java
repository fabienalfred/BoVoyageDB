package bovoyage.servlets.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bovoyage.metier.Panier;
import bovoyage.servlets.Action;

public class ActionRemoveVoyage implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		int index = Integer.parseInt(request.getParameter("indexVoy"));
		panier.remove(index);
		session.setAttribute("panier", panier);
		
		return "/panier.jsp";
	}

}
