package ticketController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticket.Ticket;
import ticket.ticketDaoImpl;
import ticket.ticketService;
import ticket.ticketServiceImpl;

/**
 * Servlet implementation class TicketAllListController
 */
@WebServlet("/TicketAllListController")
public class TicketAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketAllListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("euc-kr");
			      response.setContentType("text/html; charset=EUC-KR");
			      response.setCharacterEncoding("euc-kr");
				String view = "";
				ticketService service = new ticketServiceImpl(new ticketDaoImpl());
				ArrayList<Ticket> list = service.getAll();
				request.setAttribute("list", list);
				view = "/movie/Main.jsp?sub=/Ticket/Ticketlist.jsp";
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(view);
				if (dispatcher != null) {
					dispatcher.forward(request, response);
				}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
