package movieReplyController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movieReply.MovieReply;
import movieReply.MovieReplyDaoImpl;
import movieReply.MovieReplyService;
import movieReply.MovieReplyServiceImpl;

/**
 * Servlet implementation class movieBoardViewController
 */
@WebServlet("/MovieReplyViewController")
public class MovieReplyViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieReplyViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieReplyService service = new MovieReplyServiceImpl(new MovieReplyDaoImpl());
		int parent = Integer.parseInt(request.getParameter("parent"));
		ArrayList<MovieReply> list = service.getByParent(parent);
		request.setAttribute("list", list);
		String result = "/movie/Main.jsp?sub=/movieReply/MovieReplyView.jsp";	
		RequestDispatcher dispatcher = request.getRequestDispatcher(result);
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
