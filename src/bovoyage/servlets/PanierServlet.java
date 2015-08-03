package bovoyage.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bovoyage.dao.DateVoyageDAO;
import bovoyage.metier.DateVoyage;
import bovoyage.metier.Panier;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet(urlPatterns={"/PanierServlet"},loadOnStartup=10)
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		if(panier == null){
			panier = new Panier();
			session.setAttribute("panier", panier);
		}
		
		String page = "";
		DateVoyageDAO dao = new DateVoyageDAO();
		switch (request.getParameter("action")) {
			case "show":
				page = "/panier.jsp";
				break;
			case "add":
				DateVoyage voyageToAdd = (dao.getVoyageById(Integer.parseInt(request.getParameter("idVoy")))).get(0);
				add(panier, voyageToAdd);
				request.setAttribute("idDest", request.getParameter("idDest"));
				page = "/DestinationServlet";
				break;
			case "remove":
				for(DateVoyage dv : panier.getVoyages()){
					System.out.println(dv.getIdDateVoyage());
				}
				DateVoyage voyageToRemove = (dao.getVoyageById(Integer.parseInt(request.getParameter("idVoy")))).get(0);
				remove(panier, voyageToRemove);
//				request.setAttribute("action", "show");
				page = "/panier.jsp";
				for(DateVoyage dv : panier.getVoyages()){
					System.out.println(dv.getIdDateVoyage());
				}
				break;
			default:
				break;
		}
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	private void add(Panier panier, DateVoyage voyage) {
		panier.add(voyage);
		
	}
	private void remove(Panier panier, DateVoyage voyage) {
		 panier.remove(voyage);
		
	}
	
	private void clear(Panier panier){
		panier.clear();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
