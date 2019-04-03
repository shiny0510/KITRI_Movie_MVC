package ticketController;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Member;
import member.DaoImpl;
import member.Service;
import member.ServiceImpl;

import ticket.Ticket;
import ticket.ticketDaoImpl;
import ticket.ticketService;
import ticket.ticketServiceImpl;

/**
 * Servlet implementation class addTicketController
 */
@WebServlet("/addTicketController")
@MultipartConfig(location="C:\\temp", maxFileSize=-1)
public class addTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTicketController() {
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
		
		ticketService service=new ticketServiceImpl(new ticketDaoImpl());

		HttpSession session=request.getSession(false);
		String id="";
		if(session!=null) {
			id=(String)session.getAttribute("id");
		}
		
		String title=request.getParameter("title");
		String theater=request.getParameter("theater");
		String screen=request.getParameter("screen");
		String mdate=request.getParameter("mdate");
		String mtime=request.getParameter("mtime");
		String seat=request.getParameter("seat");
		
		service.addTicket(new Ticket(0,id,title,theater,screen,mdate,mtime,seat));
		
		Service service1=new ServiceImpl(new DaoImpl());
		Member m = new Member();
		m.setPoint(Integer.parseInt(request.getParameter("point")));
		m.setId(id);
		System.out.println(m);
		
		
		service1.editPoint(m);
		System.out.println(m);
		
		String view="movie/Main.jsp?sub=mainDown.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
