package screenController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.DaoImpl;
import member.Member;
import member.Service;
import member.ServiceImpl;
import screen.Screen;
import screen.screenDaoImpl;
import screen.screenService;
import screen.screenServiceImpl;

/**
 * Servlet implementation class screenAddController
 */
@WebServlet("/screenAddController")
public class screenAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public screenAddController() {
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
		screenService service=new screenServiceImpl(new screenDaoImpl());
		int num=Integer.parseInt(request.getParameter("num"));
		int price=Integer.parseInt(request.getParameter("price"));
		String rowLine=request.getParameter("rowLine");
		int columnLine=Integer.parseInt(request.getParameter("columnLine"));
		String parent=request.getParameter("parent");
		Screen s=new Screen(num, price, rowLine, columnLine, parent);
		service.addScreen(s);
		String view="/locationListController?type=1";
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
