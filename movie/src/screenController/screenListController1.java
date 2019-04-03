package screenController;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class screenListController1
 */
@WebServlet("/screenListController1")
public class screenListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public screenListController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		screenService service=new screenServiceImpl(new screenDaoImpl());
		String parent=request.getParameter("parent");
		ArrayList<Screen> list=service.getAllScreen(parent);
		System.out.print(parent);
		System.out.print(list.size());
		request.setAttribute("list", list);
		String view = "screen/screenList_json.jsp";
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
