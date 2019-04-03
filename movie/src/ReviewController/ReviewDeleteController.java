package ReviewController;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Review.ReviewDaoImpl;
import Review.ReviewService;
import Review.ReviewServiceImpl;


/**
 * Servlet implementation class ReviewDeleteController
 */
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteController() {
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
	      ReviewService service = new ReviewServiceImpl(new ReviewDaoImpl());
	      
	      String ptype = request.getParameter("ptype");
			int num = Integer.parseInt(request.getParameter("num"));	
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		service.delReview(rno);
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
