package movieBoardController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movieBoard.MovieBoard;
import movieBoard.MovieBoardDaoImpl;
import movieBoard.MovieBoardService;
import movieBoard.MovieBoardServiceImpl;

/**
 * Servlet implementation class MovieBoardListController
 */
@WebServlet("/MovieBoardListController")
public class MovieBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieBoardListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieBoardService service = new MovieBoardServiceImpl(new MovieBoardDaoImpl());
		HttpSession session = request.getSession(false);
		String writer = (String) session.getAttribute("id");
		ArrayList<MovieBoard> list = service.selectByWriter(writer);
		request.setAttribute("list", list);
		
		MovieBoard b = service.getBoard(writer); 
		int reply = b.getNum();
		ArrayList<MovieBoard> list1 = service.selectByReply(reply);
		request.setAttribute("list1", list1);
		System.out.println(list1);
		System.out.println(list);
		
		String result = "/movie/Main.jsp?sub=/movieBoard/MovieBoardList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(result);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
