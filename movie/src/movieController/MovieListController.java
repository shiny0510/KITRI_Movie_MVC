package movieController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Movie.Movie;
import Movie.MovieDaoImpl;
import Movie.MovieService;
import Movie.MovieServiceImpl;

/**
 * Servlet implementation class MovieListController
 */
public class MovieListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListController() {
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
		MovieService service = new MovieServiceImpl(new MovieDaoImpl());
		ArrayList<Movie> list = service.getAll();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("movieFix/list_json.jsp");
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
