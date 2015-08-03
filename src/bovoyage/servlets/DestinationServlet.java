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
@WebServlet("/DestinationServlet")
public class DestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationDAO dao = new DestinationDAO();
		List<Destination> destinations = new ArrayList<>();
		String page;

		String idDest = request.getParameter("idDest");
		if(idDest == null){
			destinations = dao.getDestinations();
			request.setAttribute("destinations", destinations);
			page = "/index.jsp";
		}
		else{
			destinations = dao.getDestinationsById(Integer.parseInt(idDest));
			request.setAttribute("dest", destinations.get(0));
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
