package movieController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Movie.Movie;
import Movie.MovieDaoImpl;
import Movie.MovieService;
import Movie.MovieServiceImpl;
import Review.Review;
import Review.ReviewDaoImpl;
import Review.ReviewService;
import Review.ReviewServiceImpl;


/**
 * Servlet implementation class GetMovieController
 */
public class GetMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMovieController() {
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
		MovieService service = new MovieServiceImpl(new MovieDaoImpl());
		int num = Integer.parseInt(request.getParameter("num"));
		String ptype = request.getParameter("ptype");
		
		Movie m = service.getMovie(num);
		
		ReviewService service1 = new ReviewServiceImpl(new ReviewDaoImpl());
		Review r = service1.getAvgScore(num);
		request.setAttribute("r", r);
		request.setAttribute("m", m);
		
		String value = m.getPath1()+":"+m.getTitle()+":"+m.getNum();
		Cookie myCookie = new Cookie(m.getNum()+"", value);
		response.addCookie(myCookie);
/*		HttpSession session=request.getSession(false);
		String ptype = (String)session.getAttribute(ptype);*/
		if(ptype.equals("2")) {
			view = "/movie/Main.jsp?sub=/movieFix/editForm.jsp";
		
		} else if(ptype.equals("1")) {
			view = "/ReviewAllListController";
	
		}
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(view);
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
