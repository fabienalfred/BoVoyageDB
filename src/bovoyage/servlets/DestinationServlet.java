package bovoyage.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bovoyage.dao.DestinationDAO;

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
			request.setAttribute("destinations", dao.getDestinations());
			page = "/index.jsp";
		}
		else{
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
