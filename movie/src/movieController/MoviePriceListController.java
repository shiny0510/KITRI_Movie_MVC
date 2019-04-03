package movieController;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Movie.Movie;
import Movie.MovieDaoImpl;
import Movie.MovieService;
import Movie.MovieServiceImpl;

/**
 * Servlet implementation class ProductPriceListController
 */
public class MoviePriceListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviePriceListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
	      response.setContentType("text/html; charset=EUC-KR");
	      response.setCharacterEncoding("euc-kr");
		MovieService service = new MovieServiceImpl(new MovieDaoImpl());
		int price = Integer.parseInt(request.getParameter("price"));
		ArrayList<Movie> list = service.getByPrice(0, price);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(
				"/movieOrder/movieCateList.jsp");
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
