package movieBoardController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movieBoard.MovieBoard;
import movieBoard.MovieBoardDaoImpl;
import movieBoard.MovieBoardService;
import movieBoard.MovieBoardServiceImpl;

/**
 * Servlet implementation class MovieBoardGetController
 */
@WebServlet("/MovieBoardGetController")
public class MovieBoardGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieBoardGetController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		MovieBoardService service = new MovieBoardServiceImpl(new MovieBoardDaoImpl());
		String type = request.getParameter("type");
		int num = Integer.parseInt(request.getParameter("num"));
		MovieBoard b = service.getMovieBoard(num);
		request.setAttribute("b", b);
		String result = "";
		if (type.equals("1")) {
			result = "/movieBoard/editForm.jsp";
		} else {
			result = "/movieReply/MovieReplyJson.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(result);
		dispatcher.forward(request, response);
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
