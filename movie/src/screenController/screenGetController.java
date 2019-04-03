package screenController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import screen.Screen;
import screen.screenDaoImpl;
import screen.screenService;
import screen.screenServiceImpl;

/**
 * Servlet implementation class screenGetController
 */
@WebServlet("/screenGetController")
public class screenGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public screenGetController() {
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
		String parent=request.getParameter("parent");
		Screen s=service.getScreen(num,parent);
		request.setAttribute("s",s);
		String view="";
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
