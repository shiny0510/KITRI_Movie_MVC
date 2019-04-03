package ReviewController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Review.Review;
import Review.ReviewDaoImpl;
import Review.ReviewService;
import Review.ReviewServiceImpl;


/**
 * Servlet implementation class ReviewAllListController
 */
public class ReviewAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAllListController() {
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
		ReviewService service = new ReviewServiceImpl(new ReviewDaoImpl());
		ArrayList<Review> list = service.getAll();
		request.setAttribute("list", list);
		view = "/movie/Main.jsp?sub=/movieOrder/detail.jsp";
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
