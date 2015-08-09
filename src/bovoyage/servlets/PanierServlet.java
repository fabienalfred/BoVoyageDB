//package bovoyage.servlets;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bovoyage.dao.DatesVoyageDAO;
//import bovoyage.dao.DestinationDAO;
//import bovoyage.entites.DatesVoyage;
//import bovoyage.metier.Panier;
//import bovoyage.metier.Voyage;
//
///**
// * Servlet implementation class PanierServlet
// */
//@WebServlet(urlPatterns={"/PanierServlet"},loadOnStartup=10)
//public class PanierServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Panier panier = (Panier) session.getAttribute("panier");
//		if(panier == null){
//			panier = new Panier();
//			session.setAttribute("panier", panier);
//		}
//		
//		String page = "";
//		DatesVoyageDAO dao = new DatesVoyageDAO();
//		switch (request.getParameter("action")) {
//			case "show":
//				page = "/panier.jsp";
//				break;
//			case "add":
//				DestinationDAO destDao = new DestinationDAO();
//				String region = destDao.getDestinationById(Integer.parseInt(request.getParameter("idDest"))).getRegion();
//				DatesVoyage dateVoyage = dao.getVoyageById(Integer.parseInt(request.getParameter("idVoy")));
//				int nbPlaces = Integer.parseInt(request.getParameter("nbPlaces"));
//				add(panier, new Voyage(region, dateVoyage, nbPlaces));
//				request.setAttribute("idDest", request.getParameter("idDest"));
//				page = "/DestinationServlet";
//				break;
//			case "remove":
//				remove(panier, Integer.parseInt(request.getParameter("indexVoy")));
//				page = "/panier.jsp";
//				break;
//			case "inscr":
//				
//				page = "/panier.jsp";
//				break;
//			default:
//				break;
//		}
//		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(page);
//		rd.forward(request, response);
//	}
//
//	private void add(Panier panier, Voyage voyage) {
//		panier.add(voyage);
//	}
//	
//	private void remove(Panier panier, int index){
//		panier.remove(index);
//	}
//	
//	@SuppressWarnings("unused")
//	private void clear(Panier panier){
//		panier.clear();
//	}
//
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
