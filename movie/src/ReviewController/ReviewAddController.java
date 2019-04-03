package ReviewController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
 * Servlet implementation class ReviewAddController
 */
@MultipartConfig(location = "C:\\temp", maxFileSize = -1)
public class ReviewAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		ReviewService service = new ReviewServiceImpl(new ReviewDaoImpl());
		Review r = new Review();
		int num = Integer.parseInt(request.getParameter("num"));		
		
		r.setNum(num);
		MovieService service1 = new MovieServiceImpl(new MovieDaoImpl());
		Movie m = service1.getMovie(num);
		m.setNum(Integer.parseInt(request.getParameter("num")));
		
		String ptype = request.getParameter("ptype");
		r.setId(request.getParameter("id"));
		r.setContent(request.getParameter("content"));
		r.setScore(Integer.parseInt(request.getParameter("score")));
		r.setRdate(request.getParameter("rdate"));
		r.setPwd(request.getParameter("pwd"));
		
		System.out.println(r);
		service.addReview(r);
		response.sendRedirect("GetMovieController?num="+num+"&ptype="+ptype);	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
