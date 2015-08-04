package bovoyage.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bovoyage.dao.DestinationDAO;
import bovoyage.metier.Destination;

/**
 * Servlet implementation class DestinationServlet
 */
@WebServlet(urlPatterns={"/DestinationServlet"}, loadOnStartup=10)
public class DestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationDAO dao = new DestinationDAO();
		String page;

		String idDest = request.getParameter("idDest");
		if(idDest == null){
//			List<Destination> destinations = dao.getDestinations();
			request.setAttribute("destinations", dao.getDestinations());
			page = "/index.jsp";
		}
		else{
//			destinations = dao.getDestinationById(Integer.parseInt(idDest));
			request.setAttribute("dest", dao.getDestinationById(Integer.parseInt(idDest)));
			page = "/details_dest.jsp";
		}
				
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
