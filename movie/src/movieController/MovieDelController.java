package movieController;


import java.io.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Movie.MovieDaoImpl;
import Movie.MovieService;
import Movie.MovieServiceImpl;

/**
 * Servlet implementation class ProductDelController
 */
public class MovieDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDelController() {
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
		MovieService service = new MovieServiceImpl(new MovieDaoImpl());
		int num = Integer.parseInt(request.getParameter("num"));
		String path = "C:\\Users\\KITRI\\Desktop\\java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img2\\movie2\\";
		File dir = new File(path);
		File[] list = dir.listFiles();
		for(File f:list) {
			if(f.getName().startsWith(num+"_")) {
				f.delete();
			}
		}
		service.delMovie(num);
		response.sendRedirect("MovieAllListController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
