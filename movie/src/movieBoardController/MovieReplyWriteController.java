package movieBoardController;

import java.io.IOException;

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
 * Servlet implementation class MovieReplyWriteController
 */
@WebServlet("/MovieReplyWriteController")
public class MovieReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieReplyWriteController() {
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
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		MovieBoardService service = new MovieBoardServiceImpl(new MovieBoardDaoImpl());
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(writer);
		int rep_num =  Integer.parseInt(request.getParameter("parent"));
//		int lv =  Integer.parseInt(request.getParameter("lv"));
//		int sq =  Integer.parseInt(request.getParameter("sq"));
//int num, String writer, String type, String title, String content, String path, Date w_date, int rep_num, int lv
		MovieBoard b = new MovieBoard(0, writer, null, title, content, null, null, rep_num, 0, 0);
		System.out.println(b);
		service.writeReply(b);
		response.sendRedirect("movieBoard/MovieBoardComplete.jsp");
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
